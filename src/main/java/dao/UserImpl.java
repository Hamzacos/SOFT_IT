package dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import com.mysql.cj.api.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.UserEntity;
import util.DbUtil;

public class UserImpl implements UserDao {

	@Override
	public boolean checkUsername(String username) {
		
		ResultSet result;
		boolean checkResult = false;
		
		try {
			Connection conn = DbUtil.getConnection();
			String sql = "SELECT * FROM user WHERE username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			result = stmt.executeQuery();
			checkResult = result.next();
		}catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
	}

	@Override
	public boolean checkEmail(String email) {
		ResultSet res;
		boolean checkResult = false ;
		try {
			Connection conn = DbUtil.getConnection();
			String sql = "SELECT * FROM user WHERE email = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			res = stmt.executeQuery();
			checkResult = res.next();
		}catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
	}

	@Override
	public boolean checkPassword(String password) {
		ResultSet res;
		boolean checkResult = false;
		try {
			Connection conn = DbUtil.getConnection();
			String sql = "SELECT * FROM user WHERE password = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, password);
			res = stmt .executeQuery();
			checkResult = res.next();		
		}catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
	}

	@Override
	public boolean checkUsernameAndPassword(UserEntity user) {
		ResultSet rs;
        boolean checkResult = false;
        try {
            Connection conn = DbUtil.getConnection();
            String sql = "select * from user" +
                    " where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            checkResult = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
	}

	@Override
	public int Register(UserEntity user) {
		int result = 0;
         try {
        	  Connection con = DbUtil.getConnection();
     		  String sql = "INSERT INTO user"
     		  		+ "(username,email,password) VALUES (?,?,?)";
     		  PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     		  stmt.setString(1, user.getUsername());
              stmt.setString(2, user.getEmail());
              stmt.setString(3, user.getPassword());
              stmt.executeUpdate();
              
              try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                  if (generatedKeys.next()) {
                      result=generatedKeys.getInt(1);
                  }
                  else {
                      throw new SQLException("Creating user failed, no ID obtained.");
                  }
              }
              
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}

}
