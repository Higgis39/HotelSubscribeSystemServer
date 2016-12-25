package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.DBUtil;
import dataService.WorkerDataService;
import po.WorkerPO;

/**
 * WorkerData的职责是实现对数据库中worker对象的增删改查
 * @author hly
 * @see
 */
public class WorkerData implements WorkerDataService{

	/**
	 * 根据酒店名称查找工作人员
	 * 
	 * @param hotelName String类型，系统用来存储酒店的名称
	 * @see
	 */
	public List<WorkerPO> findWorkerByHotelName(String hotelName) {
		List<WorkerPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from worker");
		sb.append(" where hotelName=?");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, hotelName);
		
		ResultSet rs = ptmt.executeQuery();
		
		WorkerPO w = null;
		while(rs.next()){
			w = new WorkerPO();
			w.setHotelName(rs.getString("hotelName"));
			w.setName(rs.getString("name"));
			w.setAge(rs.getInt("age"));
			w.setSex(rs.getString("sex"));
			w.setBeginTime(rs.getString("beginTime"));
			
			result.add(w);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 添加酒店工作人员
	 * 
	 * @param p WorkerPO类型，系统存储工作人员
	 * @see
	 */
	public void insertWorker(WorkerPO p) {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into worker "
				+ "( hotelName, name, age, sex, beginTime ) "
				+ " values(?,?,?,?,?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, p.getHotelName());
			ptmt.setString(2, p.getName());
			ptmt.setInt(3, p.getAge());
			ptmt.setString(4, p.getSex());
			ptmt.setString(5, p.getBeginTime());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新酒店工作人员
	 */
	public void updateWorker(WorkerPO p) {
		Connection conn = DBUtil.getConnection();
		String sql = "update worker "
				+ " set hotelName=?, name=?, age=?, sex=?, beginTime=? "
				+ " where name=?";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, p.getHotelName());
			ptmt.setString(2, p.getName());
			ptmt.setInt(3, p.getAge());
			ptmt.setString(4, p.getSex());
			ptmt.setString(5, p.getBeginTime());
			ptmt.setString(6, p.getName());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
