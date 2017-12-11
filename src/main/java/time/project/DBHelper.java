package time.project; 
import java.util.ArrayList;
import java.util.List;


import java.sql.*;
	public class DBHelper {  
	    public static final String url = "jdbc:mysql://127.0.0.1:3306/leaves?characrerEncoding = utf8";  //数据库地址，一会儿我看看能不能弄成远程的
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "root";  
	    public static final String password = "12345abc";  
	    public static Connection conn = null;  
	    										//数据库操作
	    public static Connection connect() {  
	        try {  
	            Class.forName(name);//指定连接类型  
	            conn = DriverManager.getConnection(url, user, password);//获取连接  
	            return conn;       
	        } catch (Exception e) {  
	            e.printStackTrace(); 
	            return null;   
	        }
	    } 
	    public void close() {  
	        try {  
	            DBHelper.conn.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    public List<a_student_leave> querystudents() throws SQLException{ //查询状态为1和3的操作
	    	DBHelper.conn = DBHelper.connect();
	    	List<a_student_leave> list = new ArrayList<a_student_leave>();
	    	a_student_leave leave  = new a_student_leave(); //这块是个坑
	    	 String sql = "SELECT * FROM student_leave where states = '1' or states = '3' ;";
    		 Statement psmt = conn.createStatement();  
    		 ResultSet rs = psmt.executeQuery(sql);
    		 int i= 0;
    		 while (rs.next())
             {
    			 leave.setStudentID(rs.getString("studentID"));
    			 leave.setName(rs.getString("name"));
    			 leave.setReason(rs.getString("reason"));
    			 leave.setLeave_date(rs.getString("leave_date"));
    			 leave.setReturn_date(rs.getString("return_date"));
    			 leave.setDetail(rs.getString("detail"));
    			 if (rs.getString("states")!=null)
    				 leave.setStates(rs.getString("states"));
    			 i++;
    			 list.add(leave);
             }
    		 conn.close();
    		 return list;
	    }
	    public static a_student_leave querymyleave(String studentID) throws SQLException{
	    	DBHelper.conn = DBHelper.connect();
	    	a_student_leave stu_leave = new a_student_leave();

	    	 String sql = "select * from student_leave where studentID = \""+ studentID +"\" and states = 2;" ;
	    	 Statement psmt = conn.createStatement();  
	    	 ResultSet rs = psmt.executeQuery(sql);
	    	 while(rs.next()) {
	    		 stu_leave.setStudentID(studentID);
	    		 stu_leave.setName(rs.getString("name"));
	    		 stu_leave.setReason(rs.getString("reason"));
	    		 stu_leave.setLeave_date(rs.getString("leave_date"));
	    		 stu_leave.setReturn_date(rs.getString("return_date"));
	    		 stu_leave.setDetail(rs.getString("detail"));
	    		 stu_leave.setStates(rs.getString("states"));
	    	 }
            conn.close();
	    	return stu_leave;
	    }
	    public static void cancel(String studentID) throws SQLException{
	    	DBHelper.conn = DBHelper.connect();
	    	String sql = "update student_leave set states = '3' where studentID =" + studentID;
	    	Statement psmt = conn.createStatement();  
	    	psmt.executeUpdate(sql);
	    }
	}  
//create table student_leave(studentID varchar(15),name varchar(50),reason char,leave_date DATE,return_date DATE ,detail varchar(300),states char;
