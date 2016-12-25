package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBUtil;
import dataService.OrderDataService;
import po.OrderPO;

/**
 * OrderData的职责是实现对数据库中user对象的增删改查
 * @author hly
 * @see
 */
public class OrderData implements OrderDataService{

	Encryption encryption = new Encryption();
	
	/**
	 * 增加order对象
	 * 
	 * @param o OrderPO类型，系统用来存储的Order对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public boolean insertOrder(OrderPO o) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into orders "
				+ "(id, hotelId, userId, status, entryTime, lastTime, price, comment, RoomType, RoomNum, haschild)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, o.getId());
			ptmt.setString(2, o.getHotelId());
			ptmt.setString(3, encryption.encryption(o.getUserId()));
			ptmt.setString(4, o.getStatus());
			ptmt.setString(5, o.getEntryTime());
			ptmt.setString(6, o.getLastTime());
			ptmt.setDouble(7, o.getPrice());
			ptmt.setString(8, o.getComment());
			ptmt.setString(9, o.getRoomType());
			ptmt.setInt(10, o.getRoomNum());
			ptmt.setBoolean(11, o.gethaschild());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新Order对象
	 * 
	 * @param o OrderPO类型，系统用来存储的Order对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public boolean updateOrder(OrderPO o) {
		Connection conn = DBUtil.getConnection();
		String sql = "update orders "
				+ " set id=?, hotelId=?, userId=?, status=?, entryTime=?, lastTime=?, price=?, comment=?, RoomType=?, RoomNum=?, haschild=? "
				+ " where id=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, o.getId());
			ptmt.setString(2, o.getHotelId());
			ptmt.setString(3, encryption.encryption(o.getUserId()));
			ptmt.setString(4, o.getStatus());
			ptmt.setString(5, o.getEntryTime());
			ptmt.setString(6, o.getLastTime());
			ptmt.setDouble(7, o.getPrice());
			ptmt.setString(8, o.getComment());
			ptmt.setString(9, o.getRoomType());
			ptmt.setInt(10, o.getRoomNum());
			ptmt.setBoolean(11, o.gethaschild());
			ptmt.setString(12, o.getId());
			
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 根据订单ID查找相应订单
	 * 
	 * @param ID String型，每个订单的唯一标识
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public OrderPO findOrderByOrderID(String ID) {
		OrderPO o = null;
		Connection conn = DBUtil.getConnection();
		
		String sql = " select * from orders "
				   + " where id=? ";
		
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, ID);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				o = new OrderPO();
				o.setId(rs.getString("id"));
				o.setHotelId(rs.getString("hotelId"));
				o.setUserId(encryption.decryption(rs.getString("userId")));
				o.setStatus(rs.getString("status"));
				o.setEntryTime(rs.getString("entryTime"));
				o.setLastTime(rs.getString("lastTime"));
				o.setPrice(rs.getDouble("price"));
				o.setComment(rs.getString("comment"));
				o.setRoomType(rs.getString("RoomType"));
				o.setRoomNum(rs.getInt("RoomNum"));
				o.sethaschild(rs.getBoolean("haschild"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	/**
	 * 增加预计入住时间查找订单
	 * 
	 * @param Date String类型,每份订单的预计入住时间
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	@Override
	public List<OrderPO> findOrderByDate(String Date) {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from orders");
		sb.append(" where entryTime=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, Date);
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setId(rs.getString("id"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(encryption.decryption(rs.getString("userId")));
			o.setStatus(rs.getString("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setPrice(rs.getInt("price"));
			o.setComment(rs.getString("comment"));
			o.setRoomType(rs.getString("RoomType"));
			o.setRoomNum(rs.getInt("RoomNum"));
			o.sethaschild(rs.getBoolean("haschild"));
			
			result.add(o);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 根据不同酒店查找相应订单
	 * 
	 * @param ID String类型，不同酒店的唯一标示
	 * @see
	 */
	@Override
	public List<OrderPO> findOrderByHotelID(String ID) {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from orders");
		sb.append(" where hotelId=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, ID);
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setId(rs.getString("id"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(encryption.decryption(rs.getString("userId")));
			o.setStatus(rs.getString("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setPrice(rs.getInt("price"));
			o.setComment(rs.getString("comment"));
			o.setRoomType(rs.getString("RoomType"));
			o.setRoomNum(rs.getInt("RoomNum"));
			o.sethaschild(rs.getBoolean("haschild"));
			
			result.add(o);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 根据不同客户ID寻找订单
	 * 
	 * @param ID String类型，不同客户的唯一标识
	 * @see
	 */
	public List<OrderPO> findOrderByClient(String ID) {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from orders ");
		sb.append(" where userId=? ");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, encryption.encryption(ID));
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setId(rs.getString("id"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(encryption.decryption(rs.getString("userId")));
			o.setStatus(rs.getString("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setPrice(rs.getInt("price"));
			o.setComment(rs.getString("comment"));
			o.setRoomType(rs.getString("RoomType"));
			o.setRoomNum(rs.getInt("RoomNum"));
			o.sethaschild(rs.getBoolean("haschild"));
			
			result.add(o);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 根据订单的状态查找订单
	 * 
	 * @param Status String类型,表示订单的状态
	 * @see
	 */
	@Override
	public List<OrderPO> findOrderByStatus(String Status) {
		List<OrderPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from orders ");
		sb.append(" where status=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, Status);
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setId(rs.getString("id"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(encryption.decryption(rs.getString("userId")));
			o.setStatus(rs.getString("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setPrice(rs.getDouble("price"));
			o.setComment(rs.getString("comment"));
			o.setRoomType(rs.getString("RoomType"));
			o.setRoomNum(rs.getInt("RoomNum"));
			o.sethaschild(rs.getBoolean("haschild"));
			
			result.add(o);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<String> findHotelIdByUserId(String userId) throws SQLException{
		ArrayList<String> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from orders ");
		sb.append(" where userId=?");
		
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		ptmt.setString(1, encryption.encryption(userId));
		
		ResultSet rs = ptmt.executeQuery();
		
		OrderPO o = null;
		while(rs.next()){
			o = new OrderPO();
			o.setId(rs.getString("id"));
			o.setHotelId(rs.getString("hotelId"));
			o.setUserId(encryption.decryption(rs.getString("userId")));
			o.setStatus(rs.getString("status"));
			o.setEntryTime(rs.getString("entryTime"));
			o.setLastTime(rs.getString("lastTime"));
			o.setPrice(rs.getDouble("price"));
			o.setComment(rs.getString("comment"));
			o.setRoomType(rs.getString("RoomType"));
			o.setRoomNum(rs.getInt("RoomNum"));
			o.sethaschild(rs.getBoolean("haschild"));
			
			result.add(rs.getString("hotelId"));
		}
		return result;
	}
	
	/**
	 * 得到最后一个order对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeOrderid(){
		OrderPO o = null;
		Connection conn = DBUtil.getConnection();
			
		String sql = " select * from orders where orderkey=(select MAX(orderkey) from orders) ";
			
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()){
			o = new OrderPO();
			o.setId(rs.getString("id"));
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
					
		return o.getId();
	}
	
	
}
