package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import domain.EmailId;
import domain.PhoneId;
import utils.JDBCUtils;

public class EmailIdDao {
	// 添加用户操作
		public boolean insert(EmailId email) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "insert into emailid(name,email,password)"+"values('"+email.getName()
				+"','"
				+email.getEmail()
				+"','"
				+email.getPassword()
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
		// 查找所有的用户对象
		public ArrayList<EmailId> findAll(){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<EmailId> list = new ArrayList<>();
			try {
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "select * from emailid";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					EmailId email = new EmailId();
					String Email = rs.getString("email");
					email.setEmail(Email);
					list.add(email);
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
		public EmailId find(String email) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "select * from emailid where email = '"+ email+"'";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					EmailId emailid = new EmailId();
					emailid.setPassword(rs.getString("password"));
					return emailid;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return null;
			
		}
}
