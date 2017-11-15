package time.project;
import java.io.UnsupportedEncodingException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.apache.struts2.ServletActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
import java.sql.*;
public class login extends ActionSupport { 
	   public String logname;//登入名
	   public String logpass;//密码
	   public a_student_leave[] students_leave =new  a_student_leave[100]; //学生请假表
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
	   public a_student_leave[] getStudents_leave() {
		return students_leave;
	   }
	   public void setStudents_leave(a_student_leave[] students_leave) {
		   this.students_leave = students_leave;
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
	    		Connection con = DBHelper.connect();
	    		
	    		 String sql = "SELECT * FROM student_leave;";
	    		 Statement psmt = con.createStatement();  
	    		 ResultSet rs = psmt.executeQuery(sql);
	    		 
	    		 int i= 0;
	    		 while (rs.next())
	             {
	    			 students_leave[i] = new a_student_leave();
	    			 
	    			 students_leave[i].setStudentID(rs.getString("studentID"));
	    			 students_leave[i].setName(rs.getString("name"));
	    			 students_leave[i].setReason(rs.getString("reason"));
	    			 students_leave[i].setLeave_date(rs.getString("leave_date"));
	    			 students_leave[i].setReturn_date(rs.getString("return_date"));
	    			 students_leave[i].setDetail(rs.getString("detail"));
	    			 if (rs.getString("states")!=null)
	    				 students_leave[i].setStates(rs.getString("states"));
	    			 
	    			 i++;
	             }
	    		 
	    		 con.close();
	    		 return "teacher";
	    	}
	    	else if(verifystudent())
	    	{
	    		System.out.println(logname);
	    		//验证是学生返回到学生请假界面
	    		return "student";
	    	}
	    	else
	    		return "FALSE";
	          
	    }  
}
