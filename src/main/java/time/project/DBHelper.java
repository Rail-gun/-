package time.project; 
import java.sql.*;
	public class DBHelper {  
	    public static final String url = "jdbc:mysql://127.0.0.1:3306/leaves?characrerEncoding = utf8";  //数据库地址，一会儿我看看能不能弄成远程的
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "root";  
	    public static final String password = "HljHhZMK661530";  
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
	    public void querystudents(a_student_leave leave_list[]) throws SQLException{
	    	DBHelper.conn = DBHelper.connect();
	    	 String sql = "SELECT * FROM student_leave;";
    		 Statement psmt = conn.createStatement();  
    		 ResultSet rs = psmt.executeQuery(sql);
    		 int i= 0;
    		 while (rs.next())
             {
    			 leave_list[i] = new a_student_leave();
    			 
    			 leave_list[i].setStudentID(rs.getString("studentID"));
    			 leave_list[i].setName(rs.getString("name"));
    			 leave_list[i].setReason(rs.getString("reason"));
    			 leave_list[i].setLeave_date(rs.getString("leave_date"));
    			 leave_list[i].setReturn_date(rs.getString("return_date"));
    			 leave_list[i].setDetail(rs.getString("detail"));
    			 if (rs.getString("states")!=null)
    				 leave_list[i].setStates(rs.getString("states"));
    			 i++;
             }
    		 conn.close();
	    }
	    public a_student_leave querymyleave(String studentID) throws SQLException{
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
	}  
//create table student_leave(studentID varchar(15),name varchar(50),reason char,leave_date DATE,return_date DATE ,detail varchar(300),states char;
