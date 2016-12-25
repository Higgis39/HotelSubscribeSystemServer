package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import JDBC.DBUtil;
import dataService.HotelDataService;
import po.HotelPO;

/**
 * HotelData的职责是实现对数据库中hotel对象的增删改查
 * @author hly
 * @see
 */
public class HotelData implements HotelDataService{

	Encryption encryption = new Encryption();
	
	/**
	 * 增加hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insertHotel(HotelPO h){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into hotel "
				+ " (hotelid, password, hotelname, phonenumber, address, city, businessarea, introduction, facilities, star, grade, minprice, numberofevaluators)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, h.getHotelId());
			ptmt.setString(2, h.getPassword());
			ptmt.setString(3, h.getName());
			ptmt.setString(4, h.getPhonenumber());
			ptmt.setString(5, h.getAddress());
			ptmt.setString(6, h.getCity());
			ptmt.setString(7, h.getBusinessArea());
			ptmt.setString(8, h.getIntroduction());
			ptmt.setString(9, h.getFacilities());
			ptmt.setInt(10, h.getStar());
			ptmt.setDouble(11, h.getGrade());
			ptmt.setInt(12, h.getminprice());
			ptmt.setInt(13, h.getNumberofevaluators());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void updateHotel(HotelPO h){
		Connection conn = DBUtil.getConnection();
		String sql = "update hotel "
				+ " set hotelid=?, password=?, hotelname=?, phonenumber=?, address=?, city=?, businessarea=?, introduction=?, facilities=?, star=?, grade=?, minprice=?, numberofevaluators=?"
				+ " where hotelid=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, h.getHotelId());
			ptmt.setString(2, h.getPassword());
			ptmt.setString(3, h.getName());
			ptmt.setString(4, h.getPhonenumber());
			ptmt.setString(5, h.getAddress());
			ptmt.setString(6, h.getCity());
			ptmt.setString(7, h.getBusinessArea());
			ptmt.setString(8, h.getIntroduction());
			ptmt.setString(9, h.getFacilities());
			ptmt.setInt(10, h.getStar());
			ptmt.setDouble(11, h.getGrade());
			ptmt.setInt(12, h.getminprice());
			ptmt.setInt(13, h.getNumberofevaluators());
			ptmt.setString(14, h.getHotelId());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * 删除hotel对象
//	 * 
//	 * @param hotelname String类型，酒店的名称
//	 * @see
//	 * try/catch块捕获数据库连接失败异常
//	 */
//	public void delete(String hotelname){
//		Connection conn = DBUtil.getConnection();
//		String sql = " delete from hotel "
//				   + " where hotelname=?";
//		try {
//			PreparedStatement ptmt = conn.prepareStatement(sql);
//			ptmt.setString(1, hotelname);
//			ptmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * 根据酒店名称获得hotel对象
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public HotelPO findHotelByName(String hotelname){
		HotelPO h = null;
		Connection conn = DBUtil.getConnection();
		String sql = " select * from hotel "
				   + " where hotelname=? ";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, hotelname);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				h = new HotelPO();
				h.setHotelid(rs.getString("hotelid"));
				h.setPassword(rs.getString("password"));
				h.setHotelname(rs.getString("hotelname"));
				h.setPhonenumber(rs.getString("phonenumber"));
				h.setAddress(rs.getString("address"));
				h.setCity(rs.getString("city"));
				h.setBusinessarea(rs.getString("businessarea"));
				h.setIntroduction(rs.getString("introduction"));
				h.setFacilities(rs.getString("facilities"));
				h.setStar(rs.getInt("star"));
				h.setGrade(rs.getDouble("grade"));
				h.setMinprice(rs.getInt("minprice"));
				h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	/**
	 * 根据酒店ID获得hotel对象
	 * @param hotelname String类型,酒店的名称
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public HotelPO findHotelById(String hotelid){
		HotelPO h = null;
		Connection conn = DBUtil.getConnection();
		String sql = " select * from hotel "
				   + " where hotelid=? ";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, hotelid);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()){
				h = new HotelPO();
				h.setHotelid(rs.getString("hotelid"));
				h.setPassword(rs.getString("password"));
				h.setHotelname(rs.getString("hotelname"));
				h.setPhonenumber(rs.getString("phonenumber"));
				h.setAddress(rs.getString("address"));
				h.setCity(rs.getString("city"));
				h.setBusinessarea(rs.getString("businessarea"));
				h.setIntroduction(rs.getString("introduction"));
				h.setFacilities(rs.getString("facilities"));
				h.setStar(rs.getInt("star"));
				h.setGrade(rs.getDouble("grade"));
				h.setMinprice(rs.getInt("minprice"));
				h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	/**
	 * 根据城市和所属商圈获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @throws SQLException 抛出数据库连接失败异常
	 * @see
	 */
	public ArrayList<HotelPO> findByCityAndBusinessarea(String city, String businessarea){
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? ");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			result.add(h);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public ArrayList<HotelPO> findByCityAndBusinessareaAndName(String city, String businessarea, String hotelname)
			 {
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? and hotelname=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setString(3, hotelname);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			result.add(h);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 根据城市和所属商圈和酒店星级获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @param star int,酒店星级
	 * @see
	 */
	public ArrayList<HotelPO> findByCityAndBusinessareaAndStar(String city, String businessarea, int star){
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? and star=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setInt(3, star);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			result.add(h);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 根据城市和所属商圈和酒店评分获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @param grade int类型,酒店评分
	 * @see
	 */
	public ArrayList<HotelPO> findByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade){
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? and grade>? and grade<? ");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setDouble(3, mingrade);
		ptmt.setDouble(4, maxgrade);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			result.add(h);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 根据城市和所属商圈和星级和评分获得hotel对象
	 * 
	 * @param address String类型,酒店所在的城市
	 * @param businessarea String类型,酒店所属的商圈
	 * @param star int类型，酒店星级
	 * @param grade int类型，酒店评分
	 * @see
	 */
	public ArrayList<HotelPO> findByAll(String city, String businessarea, int star, double mingrade, double maxgrade){
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? and star=? and grade<? and grade>?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setInt(3, star);
		ptmt.setDouble(4, mingrade);
		ptmt.setDouble(5, maxgrade);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			result.add(h);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * 根据输入的不同条件获得hotel对象
	 * 
	 * @param params ArrayList<Map<String, Object>>类型,不同的筛选条件
	 * @see
	 */
//	sb.append("select * from hotel INNER JOIN room on hotel.hotelname=room.hotelName");
//	sb.append(" where room.roomID=?");
	public ArrayList<HotelPO> find(ArrayList<Map<String, Object>> params){
		
		ArrayList<String> hotelName = new ArrayList<>();
		
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel INNER JOIN room on hotel.hotelname=room.hotelName where 1=1");
		
		if(params!=null && params.size()>0){
			for(int i=0; i<params.size(); i++){
				Map<String, Object> map = params.get(i);
				sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value"));
			}
		}
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			boolean flag = true;
			for(int i=0; i<result.size(); i++){
				if(rs.getString("hotelname").equals(hotelName.get(i))){
					flag = false;
				}
			}
			if(flag){
				hotelName.add(rs.getString("hotelname"));
				result.add(h);
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	/**
	 * 得到最后一个hotel对象的id
	 * 
	 * @see
	 */
	public String distributeHotelid() {
		HotelPO h = null;
		Connection conn = DBUtil.getConnection();
			
		String sql = " select * from hotel where hotel=(select MAX(hotelkey) from hotel) ";
			
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
					
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return h.getHotelId();
	}

	@Override
	public ArrayList<HotelPO> pfindByCityAndBusinessarea(String city, String businessarea, String userId) {
		
		ArrayList<String> hotelName = new ArrayList<>();
		OrderData od = new OrderData();
		try {
			hotelName = od.findHotelIdByUserId(userId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? ");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			for(int i=0; i<hotelName.size(); i++){
				if(rs.getString("hotelid").equals(hotelName.get(i))){
					result.add(h);
					break;
				}
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndName(String city, String businessarea, String hotelname, String userId) {
		
		ArrayList<String> hotelName = new ArrayList<>();
		OrderData od = new OrderData();
		try {
			hotelName = od.findHotelIdByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from hotel");
		sb.append(" where city=? and businessarea=? and hotelname=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setString(3, hotelname);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			for(int i=0; i<hotelName.size(); i++){
				if(rs.getString("hotelid").equals(hotelName.get(i))){
					result.add(h);
					break;
				}
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndStar(String city, String businessarea, int star, String userId) {
		 
		ArrayList<String> hotelName = new ArrayList<>();
		OrderData od = new OrderData();
		try {
			hotelName = od.findHotelIdByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? and star=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setInt(3, star);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			for(int i=0; i<hotelName.size(); i++){
				if(rs.getString("hotelid").equals(hotelName.get(i))){
					result.add(h);
					break;
				}
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade , String userId) {
		
		ArrayList<String> hotelName = new ArrayList<>();
		OrderData od = new OrderData();
		try {
			hotelName = od.findHotelIdByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? and grade>? and grade<? ");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setDouble(3, mingrade);
		ptmt.setDouble(4, maxgrade);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			for(int i=0; i<hotelName.size(); i++){
				if(rs.getString("hotelid").equals(hotelName.get(i))){
					result.add(h);
					break;
				}
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<HotelPO> pfindByAll(String city, String businessarea, int star, double mingrade, double maxgrade, String userId) {
		
		ArrayList<String> hotelName = new ArrayList<>();
		OrderData od = new OrderData();
		try {
			hotelName = od.findHotelIdByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<HotelPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel");
		sb.append(" where city=? and businessarea=? and star=? and grade<? and grade>?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		ptmt.setString(2, businessarea);
		ptmt.setInt(3, star);
		ptmt.setDouble(4, mingrade);
		ptmt.setDouble(5, maxgrade);
		
		ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			for(int i=0; i<hotelName.size(); i++){
				if(rs.getString("hotelid").equals(hotelName.get(i))){
					result.add(h);
					break;
				}
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<HotelPO> pfind(ArrayList<Map<String, Object>> params, String userId){
		
		//通过用户ID查找住过的酒店ID
		ArrayList<String> photelId = new ArrayList<>();
		OrderData od = new OrderData();
		try {
			photelId = od.findHotelIdByUserId(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//存放返回对象
		ArrayList<HotelPO> result = new ArrayList<>();
		
		//存放符合预定条件的酒店
		ArrayList<HotelPO> fresult = new ArrayList<>();
				
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from hotel INNER JOIN room on hotel.hotelname=room.hotelName where 1=1");
		
		if(params!=null && params.size()>0){
			for(int i=0; i<params.size(); i++){
				Map<String, Object> map = params.get(i);
				sb.append(" and "+map.get("name")+" "+ map.get("rela") +" "+map.get("value"));
			}
		}
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ResultSet rs = ptmt.executeQuery();
		
		HotelPO h = null;
		//符合基础搜索条件的酒店
		int hotelnum = -1;
		while(rs.next()){
			h = new HotelPO();
			h.setHotelid(rs.getString("hotelid"));
			h.setPassword(rs.getString("password"));
			h.setHotelname(rs.getString("hotelname"));
			h.setPhonenumber(rs.getString("phonenumber"));
			h.setAddress(rs.getString("address"));
			h.setCity(rs.getString("city"));
			h.setBusinessarea(rs.getString("businessarea"));
			h.setIntroduction(rs.getString("introduction"));
			h.setFacilities(rs.getString("facilities"));
			h.setStar(rs.getInt("star"));
			h.setGrade(rs.getDouble("grade"));
			h.setMinprice(rs.getInt("minprice"));
			h.setNumberofevaluators(rs.getInt("numberofevaluators"));
			
			boolean flag = true;
			for(int i=0; i<result.size(); i++){
				if(rs.getString("hotelid").equals(result.get(i).getHotelId())){
					flag = false;
				}
			}
			if(flag){
				result.add(h);
				hotelnum++;
			
				for(int i=0; i<photelId.size(); i++){
					if(result.get(hotelnum).getHotelId().equals(photelId.get(i))){
						fresult.add(result.get(hotelnum));
					}
				}
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fresult;
	}
	
	

	
}
