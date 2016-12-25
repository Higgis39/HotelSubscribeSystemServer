package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.DBUtil;
import dataService.RoomDataService;
import po.RoomPO;

/**
 * RoomData的职责是实现对数据库中room对象的增删改查
 * @author hly
 * @see
 */
public class RoomData implements RoomDataService{

	/**
	 * 增加room对象
	 * 
	 * @param r RoomPO类型，系统用来存储的Room对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insertRoom(RoomPO r) {
		Connection conn = DBUtil.getConnection();
		String sql = " insert into room "
				+ " (hotelName, roomNum, roomType, roomPrice, peopleNumber, IsEmpty) "
				+ " values(?,?,?,?,?,?) ";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, r.getHotelName());
			ptmt.setInt(2, r.getRoomNum());
			ptmt.setString(3, r.getRoomType());
			ptmt.setInt(4, r.getRoomPrice());
			ptmt.setInt(5, r.getPeopleNumber());
			ptmt.setBoolean(6, r.getIsEmpty());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新room对象
	 * 
	 * @param r RoomPO类型，系统用来存储的Room对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void updateRoom(RoomPO r) {
		Connection conn = DBUtil.getConnection();
		String sql = "update room "
				+ " set roomNum=?, roomType=?, roomPrice=?, peopleNumber=?, IsEmpty=? "
				+ " where hotelName=? and roomType=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, r.getRoomNum());
			ptmt.setString(2, r.getRoomType());
			ptmt.setInt(3, r.getRoomPrice());
			ptmt.setInt(4, r.getPeopleNumber());
			ptmt.setBoolean(5, r.getIsEmpty());
			ptmt.setString(6, r.getHotelName());
			ptmt.setString(7, r.getRoomType());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据酒店名字查看房间
	 * 
	 * @param hotelName String类型，酒店的名
	 * @see
	 */
	public ArrayList<RoomPO> findRoomByHotelName(String HotelName) {
		ArrayList<RoomPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from room ");
		sb.append(" where HotelName=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, HotelName);
		
		ResultSet rs = ptmt.executeQuery();
		
		RoomPO r = null;
		while(rs.next()){
			r = new RoomPO();
			r.setHotelName(rs.getString("hotelName"));
			r.setRoomNum(rs.getInt("roomNum"));
			r.setRoomType(rs.getString("roomType"));
			r.setRoomPrice(rs.getInt("roomPrice"));
			r.setPeopleNumber(rs.getInt("peopleNumber"));
			r.setIsEmpty(rs.getBoolean("IsEmpty"));
			
			result.add(r);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public RoomPO findRoomByIDAndHotelname(String roomID,String hotelName){
		RoomPO r = null;
		Connection conn = DBUtil.getConnection();
		
		String sql = " select * from user "
				   + " where RoomId=? ,hotelName=? ";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, roomID);
			ptmt.setString(2, hotelName);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				r = new RoomPO();
				r.setHotelName(rs.getString("HotelName"));
				r.setRoomNum(rs.getInt("roomNum"));
				r.setRoomType(rs.getString("RoomType"));
				r.setRoomPrice(rs.getInt("RoomPrice"));
				r.setPeopleNumber(rs.getInt("PeopleNumber"));
				r.setIsEmpty(rs.getBoolean("IsEmpty"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	
}
