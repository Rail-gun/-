package time.project;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import time.project.WordUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Desc：生成word
 * @Author：王雪松
 * @Date：2017-12-11下午05:03:19
 */
@SuppressWarnings("serial")
public class WordAction  extends ActionSupport{

 private String filePath; //文件路径
 private String fileName; //文件名称
 private String fileOnlyName; //文件唯一名称
 private String studentID;
 /**
  * @Desc：生成word文档
  * @Author：王雪松
  * @Date：2017-12-11下午05:03:19
  * @return
  */
 	public String getStudentID() {
		return studentID;
	}
 	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
 	
    public String createWord() throws SQLException{
        /** 用于组装word页面需要的数据 */
        Map<String, Object> dataMap = new HashMap<String, Object>();
       
        /** 组装数据 */
		a_student_leave student = new a_student_leave();
		student = DBHelper.createWord(studentID);
        dataMap.put("studentID", student.getStudentID());
        dataMap.put("name", student.getName());
        dataMap.put("leavetime", student.getLeave_date());
        dataMap.put("reason", student.getDetail());
        switch(student.getReason())
		{
		   case "1":
			   dataMap.put("thetype", "出国留学");
			   break;
		   case "2":
			   dataMap.put("thetype", "参加比赛/培训");
			   break;
		   case "3":
			   dataMap.put("thetype", "国内交流");
			   break;
		   case "4":
			   dataMap.put("thetype", "病假");
			   break;
		   case "5":
			   dataMap.put("thetype", "其他");
			   break;
		   default:
			   dataMap.put("thetype", "其他");
			   break;
		}
       
        /** 文件名称，唯一字符串 */
        Random r=new Random();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        StringBuffer sb=new StringBuffer();
        sb.append(sdf1.format(new Date()));
        sb.append("_");
        sb.append(r.nextInt(100));
       
        //文件路径
        filePath=ServletActionContext.getServletContext().getRealPath("/")+"upload";
        //System.out.println(filePath);
       
        //文件唯一名称
        fileOnlyName = student.getStudentID() + "-" + student.getName()+"请假表"+sb+".doc";
       
        //文件名称
        fileName = student.getStudentID() + "-" + student.getName()+"请假表" + ".doc";
          
        /** 生成word */
        WordUtil.createWord(dataMap, "news.ftl", filePath, fileOnlyName);
        return "createWordSuccess";
    }
   
   
 /**
  * @Desc：下载生成的word文档，入口，用来跳转至struts XML配置
  * @Author：王雪松
  * @Date：2017-12-11下午05:03:19
  * @return
  */
    public String dowloadWord() {
        /** 先判断文件是否已生成  */
        try {
         //解决中文乱码
         filePath = URLDecoder.decode(filePath, "UTF-8");
         fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
         fileName = URLDecoder.decode(fileName, "UTF-8");
         
         //如果文件不存在，则会跳入异常，然后可以进行异常处理
        
         new FileInputStream(filePath + File.separator +  fileOnlyName);
        } catch (Exception e) {
         e.printStackTrace();
         return "error";
        }
        return "dowloadWord";
    }
   
    /**
     * @Desc：下载生成的word文档
     * 该方法是struts.xml文件中的： <param name="inputName">wordFile</param> 中自动对应的get方法，该方法自动调用
     * @Author：王雪松
     * @Date：2017-12-11下午05:03:19
     * @return 返回最终生成的word文档 文件流
     */
    public InputStream getWordFile(){
        try {
         //解决中文乱码
        	 filePath = URLDecoder.decode(filePath, "UTF-8");
             fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
             fileName = URLDecoder.decode(fileName, "UTF-8");
         
            /** 返回最终生成的word文件流  */
            return new FileInputStream(filePath + File.separator + fileOnlyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


 public String getFilePath() {
  return filePath;
 }


 public void setFilePath(String filePath) {
  this.filePath = filePath;
 }


 public String getFileName() {
  return fileName;
 }


 public void setFileName(String fileName) {
  this.fileName = fileName;
 }


 public String getFileOnlyName() {
  return fileOnlyName;
 }


 public void setFileOnlyName(String fileOnlyName) {
  this.fileOnlyName = fileOnlyName;
 }

}