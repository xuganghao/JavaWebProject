package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.PhoneId;
import utils.JDBCUtils;

public class PhoneIdDao {
	// 添加用户操作
	public boolean insert(PhoneId phone) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into phoneid(name,phone,password)"+"values('"+phone.getName()
			+"','"
			+phone.getPhone()
			+"','"
			+phone.getPassword()
			+"')";
			int num = stmt.executeUpdate(sql);
			if(num > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.release(rs,stmt, conn);
		}
		return false;
	}
	// 查找�?有的用户对象
	public ArrayList<PhoneId> findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PhoneId> list = new ArrayList<>();
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from phoneid";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PhoneId phoneid = new PhoneId();
				String phone = rs.getString("phone");
				phoneid.setPhone(phone);
				list.add(phoneid);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	// 根据phone查找PhoneId
	public PhoneId find(String phone) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from phoneid where phone ='"+phone+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PhoneId phoneid = new PhoneId();
				phoneid.setPassword(rs.getString("password"));
				return phoneid;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.release(rs,stmt, conn);
		}
		return null;
		
	}
	// 根据phone查找PhoneId
		public boolean find1(String phone) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "select * from phoneid where phone ='"+phone+"'";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					PhoneId phoneid = new PhoneId();
					phoneid.setPassword(rs.getString("password"));
					return true;
				}
			} catch (Exception e) {
				return false;
			} finally{
				JDBCUtils.release(rs,stmt, conn);
			}
			return false;
			
		}
}
