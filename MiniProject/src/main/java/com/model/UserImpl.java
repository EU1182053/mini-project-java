package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.connection.MyConnection;
import com.pojo.User;

public class UserImpl implements UserDao {

	
	public boolean register(User user) {
		boolean b = false;
		String sql = "insert into user values(?,?,?,?,?,?);";
		try (Connection conn = MyConnection.connect()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, user.getPassword());
			pstmt.setLong(2, user.getContact());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUsername());
			pstmt.setString(6, user.getEmail());
			

			int no = pstmt.executeUpdate();

			System.out.println("Number of rows affected: " + no);
			if (no > 0)
				b = true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
		return b;
		
	}

	
	public boolean login(User user) {
		boolean b = false;
		try(Connection conn=MyConnection.connect()){
			
			String sql="select *  from user where email=? and password=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,user.getEmail());
			pstmt.setString(2,user.getPassword());	
			System.out.println(pstmt);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				b=true;
			}
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return b;
	}

	
	public boolean changePassword(User user) {
		
		boolean b = false;
		String sql = "update user set password=? where username=? and email=?;";
		try (Connection conn = MyConnection.connect()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			

			int no = pstmt.executeUpdate();

			System.out.println("Number of rows affected: " + no);
			if (no > 0)
				b = true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
		return b;
	}

	
	public boolean updateProfile(User user) {
		boolean b = false;
		String sql = "update menu set name=?, contact=?, email=?, address=? where username=? and password=?";

		try (Connection conn = MyConnection.connect()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getName());
			pstmt.setLong(2, user.getContact());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUsername());
			pstmt.setString(6, user.getPassword());
			int no = pstmt.executeUpdate();

			System.out.println("Number of rows affected: " + no);
			if (no > 0)
				b = true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
		return b;
	}

	
	public String getUserByUsername(User user) {
		String username = null, name = null, address = null, email = null;
		long contact = 0;
		try(Connection conn=MyConnection.connect()){
			
			String sql="select *  from user where username=? and password=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());	
			System.out.println(pstmt);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				username=rs.getString("username");
				name=rs.getString("name");
				contact=rs.getLong("contact");
				address=rs.getString("address");
				email=rs.getString("email");
			}
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ""+ username + "" + name + "" + contact+ "" + ""+address+""+ email ;
		
	}

	
	public boolean deleteUserByUsername(User user) {
		boolean b=false;
		String sql="delete from employee where username=? and password=?"; 
		try (Connection connection=MyConnection.connect()){	  
			PreparedStatement pstatement=connection.prepareStatement(sql);
			pstatement.setString(1, user.getUsername());
			pstatement.setString(2, user.getPassword());
			System.out.println(pstatement);
			int no=pstatement.executeUpdate(); 
			System.out.println("Number of rows affected: "+no);
			if(no>0)
				b=true;
		} 
		  catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Autoclosed");
		return b;
	}
	
}
