package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.DBUtil;
import dataService.HotelPromotionDataService;
import po.HotelPromotionPO;

/**
 * HotelPromotionData的职责是实现对数据库中hotelPromotion对象的增删改查
 * @author hly
 * @see
 */
public class HotelPromotionData implements HotelPromotionDataService{
	
	/**
	 * 增加hotelPromotion对象
	 * 
	 * @param hp HotelPromotionPO类型，系统用来存储hotelPromotion对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public boolean insertHotelPromotion(HotelPromotionPO hp){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into hotelpromotion "
				+ "(hotelname,name,isbirthday,numberofroom,ispartner,begintime,endtime,discount)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, hp.getHotelname());
			ptmt.setString(2, hp.getName());
			ptmt.setBoolean(3, hp.isIsbirthday());
			ptmt.setInt(4, hp.getNumberofroom());
			ptmt.setBoolean(5, hp.isIspartner());
			ptmt.setString(6, hp.getBegintime());
			ptmt.setString(7, hp.getEndtime());
			ptmt.setDouble(8, hp.getDiscount());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 更新hotelPromotion对象
	 * 
	 * @param hp HotelPromotionPO类型，系统用来存储hotelPromotion对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public boolean updateHotelPromotion(HotelPromotionPO hp){
		Connection conn = DBUtil.getConnection();
		String sql = "update hotelpromotion "
				+ " set hotelname=?,isbirthday=?,numberofroom=?,ispartner=?,begintime=?,endtime=?,discount=?"
				+ " where name=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, hp.getHotelname());
			ptmt.setBoolean(2, hp.isIsbirthday());
			ptmt.setInt(3, hp.getNumberofroom());
			ptmt.setBoolean(4, hp.isIspartner());
			ptmt.setString(5, hp.getBegintime());
			ptmt.setString(6, hp.getEndtime());
			ptmt.setDouble(7, hp.getDiscount());
			ptmt.setString(8, hp.getName());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 删除hotelPromotion对象
	 * 
	 * @param name String类型，不同的酒店销售策略名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void deleteHotelPromotion(String name){
		Connection conn = DBUtil.getConnection();
		String sql = " delete from hotelpromotion "
				   + " where name=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据酒店名称返回酒店促销策略
	 * 
	 * @param hotelname String类型，不同的酒店名称
	 * @see
	 */
	public ArrayList<HotelPromotionPO> findHotelPromotionByHotelname(String hotelname){
		ArrayList<HotelPromotionPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotelpromotion");
		sb.append(" where hotelname=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, hotelname);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPromotionPO hp = null;
		while(rs.next()){
			hp = new HotelPromotionPO();
			hp.setHotelname(rs.getString("hotelname"));
			hp.setName(rs.getString("name"));
			hp.setIsbirthday(rs.getBoolean("isbirthday"));
			hp.setNumberofroom(rs.getInt("numberofroom"));
			hp.setIspartner(rs.getBoolean("ispartner"));
			hp.setBegintime(rs.getString("begintime"));
			hp.setEndtime(rs.getString("endtime"));
			hp.setDiscount(rs.getDouble("discount"));
			
			result.add(hp);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<HotelPromotionPO> findHotelPromotionByDiscount(double discount) throws SQLException{
		ArrayList<HotelPromotionPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotelpromotion");
		sb.append(" where discount=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setDouble(1, discount);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPromotionPO hp = null;
		while(rs.next()){
			hp = new HotelPromotionPO();
			hp.setHotelname(rs.getString("hotelname"));
			hp.setName(rs.getString("name"));
			hp.setIsbirthday(rs.getBoolean("isbirthday"));
			hp.setNumberofroom(rs.getInt("numberofroom"));
			hp.setIspartner(rs.getBoolean("ispartner"));
			hp.setBegintime(rs.getString("begintime"));
			hp.setEndtime(rs.getString("endtime"));
			hp.setDiscount(rs.getDouble("discount"));
			
			result.add(hp);
		}
		return result;
	}

	@Override
	public HotelPromotionPO findHotelPromotionByHotelNameAndName(String hotelName, String name) {
		HotelPromotionPO hp = null;
		Connection conn = DBUtil.getConnection();
		String sql = " select * from hotelpromotion "
				   + " where hotelname=? and name=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, hotelName);
			ptmt.setString(2, name);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				hp = new HotelPromotionPO();
				hp.setHotelname(rs.getString("hotelname"));
				hp.setName(rs.getString("name"));
				hp.setIsbirthday(rs.getBoolean("isbirthday"));
				hp.setNumberofroom(rs.getInt("numberofroom"));
				hp.setIspartner(rs.getBoolean("ispartner"));
				hp.setBegintime(rs.getString("begintime"));
				hp.setEndtime(rs.getString("endtime"));
				hp.setDiscount(rs.getDouble("discount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hp;
	}
}
