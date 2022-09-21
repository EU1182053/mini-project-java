package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.MyConnection;
import com.pojo.Menu;

public class MenuImpl implements MenuDao {

	public boolean addFood(Menu menu) {
		boolean b = false;
		String sql = "insert into menu values(?,?,?,?,?);";
		try (Connection conn = MyConnection.connect()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, menu.getId());
			pstmt.setString(1, menu.getName());
			pstmt.setInt(3, menu.getPrice());
			pstmt.setString(4, menu.getType());
			pstmt.setString(5, menu.getAvailable());

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

	public boolean updateFood(Menu menu) {
		boolean b = false;
		String sql = "update menu set name=?, price=?, type=?, in_stock=? where id=?";

		try (Connection conn = MyConnection.connect()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, menu.getName());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setString(3, menu.getType());
			pstmt.setString(4, menu.getAvailable());
			pstmt.setInt(5, menu.getId());
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

	public boolean deleteFood(int id) {
		boolean b = false;

		String sql = "delete from menu where id=?";
		try (Connection connection = MyConnection.connect()) {
			PreparedStatement pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1, id);

			System.out.println(pstatement);
			int no = pstatement.executeUpdate();
			System.out.println("Number of rows affected: " + no);
			if (no > 0)
				b = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Autoclosed");
		return b;

	}

	public List<Menu> showFood() {

		Menu m = null;
		String sql = "select * from menu";
		List<Menu> menuList = new ArrayList<>();
		try (Connection connection = MyConnection.connect()) {
			PreparedStatement pstatement = connection.prepareStatement(sql);

			ResultSet rs = pstatement.executeQuery();

			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("name");
				int price = Integer.parseInt(rs.getString("price"));
				String type = rs.getString("type");
				String in_stock = rs.getString("in_stock");

				m = new Menu(id, price, name, type, in_stock);
				menuList.add(m);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Autoclosed");

		return menuList;

	}

	public Menu getFoodById(int id) {
		Menu m = null;
		String sql = "select * from menu where id=?";

		try (Connection connection = MyConnection.connect()) {
			PreparedStatement pstatement = connection.prepareStatement(sql);

			pstatement.setInt(1, id);
			ResultSet rs = pstatement.executeQuery();

			id = Integer.parseInt(rs.getString("id"));
			String name = rs.getString("name");
			int price = Integer.parseInt(rs.getString("price"));
			String type = rs.getString("type");
			String in_stock = rs.getString("in_stock");

			m = new Menu(id, price, name, type, in_stock);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	

		
	}

}
