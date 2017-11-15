package time.project; 
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
	            this.conn.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	}  
//create table student_leave(studentID varchar(15),name varchar(50),reason char,leave_date DATE,return_date DATE ,detail varchar(300),states char;
