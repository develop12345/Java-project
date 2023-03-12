package tutorial.serv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// class that will handle performing operation on database like save, delete, update or retreat data..
public class EmpDao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con=null;	
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crudservletapplication", "root", "Database12345");
		return con;
	}

	public static int save(Emp e) {
		int status=0;
		try {
			Connection con= EmpDao.getConnection();
			PreparedStatement pst= con.prepareStatement("insert into CRUDServletApplication.emp(name, password, email, country)values(?,?,?,?)");
			pst.setString(1,e.getName());
			pst.setString(2,e.getPassword());
			pst.setString(3,e.getEmail());
			pst.setString(4,e.getCountry());
			
			status= pst.executeUpdate();
			con.close();
		}
		catch(Exception t) {
			System.out.println(t);
		}
		return status;
	}
	
	public static int update(Emp e) {
		int status=0;
		try {
			Connection con= EmpDao.getConnection();
			PreparedStatement pst= con.prepareStatement("update CRUDServletApplication.emp set name=?, password=?, email=?, country=? where id=?");
			pst.setString(1,e.getName());
			pst.setString(2,e.getPassword());
			pst.setString(3,e.getEmail());
			pst.setString(4,e.getCountry());
			pst.setInt(5,e.getId());
			
			status= pst.executeUpdate();
			con.close();
		}
		catch(Exception t) {
			System.out.println(t);
		}
		return status;
	}
	
	public static int delete(int id) {
		int status=0;
		try {
			Connection con= EmpDao.getConnection();
			PreparedStatement pst= con.prepareStatement("delete from CRUDServletApplication.emp where id=?");
			pst.setInt(1,id);
			
			status= pst.executeUpdate();
			con.close();
		}
		catch(Exception t) {
			System.out.print(t);
		}
		return status;
	}
	
	public static Emp getEmployeeById(int id) {
		Emp e= new Emp();
		try {
			Connection con= EmpDao.getConnection();
			PreparedStatement pst= con.prepareStatement("Select * from CRUDServletApplication.emp where id=?");
			pst.setInt(1, id);
			
			ResultSet rs= pst.executeQuery();
			
			while(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		}
		catch(Exception t) {
			System.out.print(t);
		}
		return e;
	}
	
	public static List<Emp> getAllEmployee(){
		List<Emp> list= new ArrayList<>();
		try {
			Connection con= EmpDao.getConnection();
			PreparedStatement pst= con.prepareStatement("Select * from CRUDServletApplication.emp");
			
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				Emp e= new Emp();
				e.setId(rs.getInt(1));
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			con.close();
		}
		catch(Exception t) {
			System.out.print(t);
		}
		return list;
	}
}
