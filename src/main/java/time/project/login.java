package time.project;
import java.io.UnsupportedEncodingException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  
import java.sql.*;
import java.util.Map;
public class login extends ActionSupport { 
	   public String logname;//登入名
	   public String logpass;//密码
	   
	   public List<a_student_leave> leave_list ; //学生请假表
	   a_student_leave stu = new a_student_leave();
	   
	   public a_student_leave getStu() {
		return stu;
	}
	public  String getLogname(){
		   return logname;
	   }
	   public void setLogname(String logname){
		   this.logname = logname;
	   }
	   public String getLogpass(){
		   return logpass;
	   }
	   public List<a_student_leave> getStudents_leave() {
		return leave_list;
	   }
	   public void setStudents_leave(List<a_student_leave> students_leave) {
		   this.leave_list = students_leave;
	   }
	   public void setLogpass(String logpass){
		   this.logpass = logpass;
	   }
	   private boolean verifyadmin(){ //验证是否是管理员，后续需要扩展
		   if("admin".equals(logname) && "123456".equals(logpass))
			   return true;
		   else
			   return false;
	   }
	   private boolean verifystudent(){
		   //验证是否是学生，目前默认返回正确，因为还没有得到资方数据库
		   return true;
	   }
	    public String execute()throws Exception{  
	    	if(verifyadmin()){
	    		//验证是老师返回请假数据库中的所有请假信息
	    		DBHelper.querystudents();
	    		DBHelper.search();
	    		 return "teacher";
	    	}
	    	else if(verifystudent())
	    	{
	    		//验证是学生返回到学生请假界面
	    		HttpSession session = ServletActionContext.getRequest().getSession(); 
	    		session.setAttribute("studentID", logname); 
	    		a_student_leave stu_leave;
	    		stu_leave=DBHelper.querymyleave(logname);
	    		session.setAttribute("stu_cancel", stu_leave);
	    		return "student";
	    	}
	    	else
	    		return "FALSE";
	    }  
}
