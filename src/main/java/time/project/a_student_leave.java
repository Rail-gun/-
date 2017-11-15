package time.project;

import java.sql.Array;

public class a_student_leave {
	String studentID,name,reason,leave_date,return_date,detail,states;
	
	public a_student_leave(){
		studentID = null;
		name = null;
		reason = null;
		leave_date = null;
		return_date = null;
		detail = null;
		states = null;
	}
	   public String getStudentID(){
		   return studentID;
	   }
	   public void setStudentID(String studentID){
		   this.studentID = studentID;
	   }
	   public String getName(){
		   return name;
	   }
	   public void setName(String name){
		   this.name = name;
	   }
	   public String getReason(){
		   return reason;
	   }
	   public void setReason(String reason){
		   switch(reason)
		   {
		   case "1":
			   this.reason = "出国留学";
		   case "2":
			   this.reason = "参加比赛/培训";
		   case "3":
			   this.reason = "国内交流";
		   case "4":
			   this.reason = "病假";
		   case "5":
			   this.reason = "其他";
		   }
		   this.reason = reason;
	   }
	   public String getLeave_date(){
		   return leave_date;
	   }
	   public void setLeave_date(String leave_date){
		   this.leave_date = leave_date;
	   }
	   public String getReturn_date(){
		   return return_date;
	   }
	   public void setReturn_date(String return_date){
		   this.return_date = return_date;
	   }
	   public String getDetail(){
		   return detail;
	   }
	   public void setDetail(String detail){
		   this.detail = detail;
	   }
	   public String getStates(){
		   return states;
	   }
	   public void setStates(String states){
		   switch(states)
		   {case "1" :   
		        this.states = "申请请假";
		   case "2":
			   this.states = "批准请假";
		   case "3":
			   this.states = "申请销假";
		   case "4":
			   this.states = "申请销假";
		   }
	   }
		
	}

