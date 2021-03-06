package time.project;
import java.io.UnsupportedEncodingException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class apply_cancel extends ActionSupport{
	public String leave_year,leave_month,reason,
	leave_day,return_year,return_month,return_day,detail,studentID;

	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
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
	   public String apply()
	   {
		   a_student_leave insert_apply = new a_student_leave() ;
		   String return_date,leave_date;
		   String student_name = "peter";  //需要从数据库中读出，本行仅供测试
		   return_date = return_year +"-" + return_month + "-" + return_day;
		   leave_date = leave_year + "-" + leave_month + "-" +leave_day;
		   String states = "1";  //测试第三条请假原因，设置状态1为申请状态
		   Connection con = DBHelper.connect();
		   HttpSession session = ServletActionContext.getRequest().getSession(); 
   		   studentID = (String)session.getAttribute("studentID");
		   System.out.println(studentID);
  		 String sql = "insert into student_leave values(?,?,?,?,?,?,?);";
		try {
			 PreparedStatement psmt = con.prepareStatement(sql);
			 psmt.setString(1, studentID);
			 psmt.setString(2, student_name);
			 psmt.setString(3, reason);
			 psmt.setString(4, leave_date);
			 psmt.setString(5, return_date);
			 psmt.setString(6, detail);
			 psmt.setString(7, states);
			 psmt.executeUpdate();
			 con.close();
			   return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILS";
		}  
  		
	   }
	   
	   public String cancel() throws SQLException{ //学生销假
		   HttpSession session = ServletActionContext.getRequest().getSession(); 
   		   studentID = (String)session.getAttribute("studentID");
   		   DBHelper.cancel(studentID);
		   return "SUCCESS";
	   }
	   public String confirm() throws SQLException{ 
		   System.out.println(studentID);
		   DBHelper.confirm(studentID); //通过DBHelper中的confirm方法确认学生状态
		   return "SUCCESS";
	   }
	   public String search() throws SQLException{
		   DBHelper.search();
		   return "SUCCESS";
	   } 
}
