package time.project;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.*;
public class Actiontest {

	//@Test
	public void DBtest() throws SQLException {	
		Connection con =  DBHelper.connect();
		 Statement stmt = con.createStatement(); 
		 
		 stmt.executeUpdate("insert into student_leave values('1150320218', '李书','1','1997-11-19','1997-11-20','去拯救世界','1');");
		String  result,expect;
		  ResultSet rs = stmt.executeQuery("select * from student_leave;");
	         while (rs.next())
	         {
	             System.out.println(rs.getString("studentID") +" "+ rs.getString("detail"));
	         }
		con.close();
		if(con!=null)
			 result = "1";
		else
			result = "0";
		assertEquals(result,"1");
	}
	//@Test
	public void teachertest() throws Exception{
		login a = new login();
		a.logname = "admin";
		a.logpass = "123456";
		a.execute();
		String result,expect;
		expect = "1150320218";
		result = "1";
		assertEquals(result,expect);
	}
	@Test
	public void applytest() throws Exception{
		apply_cancel a = new apply_cancel();
		a.studentID = "1150320217";
		a.leave_year = "2017";
		a.leave_month = "1";
		a.leave_day = "1";
		a.return_year = "2017";
		a.return_month = "2";
		a.return_day = "1";
		a.detail = "save the world";
		a.apply();
	}

}
