package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import domain.EmailId;
import domain.SelfInfo;
import utils.JDBCUtils;

public class SelfInfoDao {
	// 添加用户的操�?
	public boolean insert(SelfInfo self) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String birth = sdf.format(self.getBirth());
			String sql = "insert into selfinfo(account,img,xm,birth,phone,city,sex,web,email,address)"+
			"values('"+self.getAccount()
			+"','"
			+self.getImg()
			+"','"
			+self.getXm()
			+"','"
			+self.getBirth()
			+"','"
			+self.getPhone()
			+"','"
			+self.getCity()
			+"','"
			+self.getSex()
			+"','"
			+self.getWeb()
			+"','"
			+self.getEmail()
			+"','"
			+self.getAddress()
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
	// 根据account查找指定user
	public SelfInfo find(String account) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from selfinfo where account = '"+ account+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				SelfInfo self = new SelfInfo();
				self.setImg(rs.getString("img"));
				self.setXm(rs.getString("xm"));
				self.setBirth(rs.getString("birth"));
				self.setPhone(rs.getString("phone"));
				self.setCity(rs.getString("city"));
				self.setSex(rs.getString("sex"));
				self.setWeb(rs.getString("web"));
				self.setEmail(rs.getString("email"));
				self.setAddress(rs.getString("address"));
				return self;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.release(rs,stmt, conn);
		}
		return null;
	}
	// 修改用户
		public boolean update(SelfInfo info) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			// 获取数据连接
			try {
				conn = JDBCUtils.getConnection();
			// 获得Statement对象
				stmt = conn.createStatement();
				// 发�?�SQL语句
				String sql = "update selfinfo set img='"+info.getImg()
				+ "',xm='"+info.getXm()
				+ "',birth='"+info.getBirth()+"',phone='"+info.getPhone()
				+"',city='"+info.getCity()+"',sex='"+info.getSex()+
				"',web='"+info.getWeb()+
				"',email='"+info.getEmail()+
				"',address='"+info.getAddress()+
				"'where account= '"+info.getAccount()+"'";
				int num = stmt.executeUpdate(sql);
				if(num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.release(rs, stmt, conn);
			}
			return false;
		}

}
