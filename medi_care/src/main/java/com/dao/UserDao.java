package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	private Connection conn;
	
	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}


	public boolean userRegister(User u) {
		
		boolean flag = false;
		try {
			String query = "insert into user_detail(name,email,password) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			int res = ps.executeUpdate();
			if(res == 1) flag = true;
			
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return flag;
	}
	
	public User login(String email, String pass) {
		User u = null;
		try {
			String query = "select * from user_detail where email = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString (2,pass);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return u;
	}
}
