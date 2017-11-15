package time.project;
import java.io.UnsupportedEncodingException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.apache.struts2.ServletActionContext;  
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class apply_cancel extends login {
	
	public String leave_year,leave_month,
	leave_day,return_year,return_month,return_day,detail;
	   public String getLeave_year(){
		   return leave_year;
	   }
	   public void setLeave_year(String leave_year){
		   this.leave_year = leave_year;
	   }
	   public String getLeave_month(){
		   return leave_month;
	   }
	   public void setLeave_month(String leave_month){
		   this.leave_month = leave_month;
	   }
	   public String getLeave_day(){
		   return leave_day;
	   }
	   public void setLeave_day(String leave_day){
		   this.leave_day = leave_day;
	   }
	   public String getReturn_year(){
		   return return_year;
	   }
	   public void setReturn_year(String return_year){
		   this.return_year = return_year;
	   }
	   public String getReturn_month(){
		   return return_month;
	   }
	   public void setReturn_month(String return_month){
		   this.return_month = return_month;
	   }
	   public String getReturn_day(){
		   return return_day;
	   }
	   public void setReturn_day(String return_day){
		   this.return_day = return_day;
	   }
	   public String getDetail(){
		   return detail;
	   }
	   public void setDetail(String detail){
		   this.detail = detail;
	   }
	   public String insert()
	   {
		   System.out.println(leave_year);
		   System.out.println(logname);
		   
		   a_student_leave insert_apply = new a_student_leave() ;
		   String return_date,leave_date;
		   String student_name = "peter";  //需要从数据库中读出，本行仅供测试
		   return_date = return_year +"-" + return_month + "-" + return_day;
		   leave_date = leave_year + "-" + leave_month + "-" +leave_day;
		   String reason = "3",states = "1";  //测试第三条请假原因，设置状态1为申请状态
		   Connection con = DBHelper.connect();
  		 String sql = "insert into student_leave values(?,?,?,?,?,?,?);";
		try {
			logname = "1150320218";
			 PreparedStatement psmt = con.prepareStatement(sql);
			 psmt.setString(1, logname);
			 psmt.setString(2, student_name);
			 psmt.setString(3, reason);
			 psmt.setString(4, leave_date);
			 psmt.setString(5, return_date);
			 psmt.setString(6, detail);
			 psmt.setString(7, states);
			 psmt.executeUpdate();
			   return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILS";
		}  
  		
	   }
	   
	   public String cancel(){
		   
		   
		   return "SUCCESS";
	   }
	  
}
