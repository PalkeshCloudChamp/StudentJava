package DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//import com.mysql.jdbc.Connection;

public class MakeConnection {
	private Connection con;
	private Statement stm;
	public MakeConnection() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Inside the constructor");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Occured:- "+e);
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp_test", "root", "Blaze@12345");
			stm = con.createStatement();
			ResultSet res = stm.executeQuery("select * from product");
			System.out.println("Got some input");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong:- " + e);
		}
	}

		
	
	
//	private Connection con;
//	private Statement stm;
//public MakeConnection() {
//	// TODO Auto-generated constructor stub
//	System.out.println("Inside Make Connection Class");
//	try {
////		System.out.println("Connection Success");
//		Class.forName("com.mysql.cj.jdbc.Driver");
////		System.out.println("Connection Success");
//		this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp_test?autoReconnect=true&useSSL=false","root","Blaze@12345");
//		System.out.println("Connection Success");
//		this.stm=this.con.createStatement();
////		System.out.println("Connection Success");
//	} catch (Exception e) {
//		System.out.println(e);
//		this.con = null;
//		this.stm = null;
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//	public Dictionary UsersList()
//	{
//		ResultSet result;
//		Dictionary res = new Hashtable();
//		if(this.con == null) {
//			return null;
//		}
//		else
//		{
//			try {
//				result = this.stm.executeQuery("Select * from product");
//				int i = 0;
//				while(result.next()) {
//					Object temp[] = null;
//					temp[0] = result.getInt(1);
//					temp[1] = result.getString(2);
//					temp[2] = result.getInt(3);
//					res.put(i,temp);
//					i++;
//				}
//				return res;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}
//		}
//	}
	
}
