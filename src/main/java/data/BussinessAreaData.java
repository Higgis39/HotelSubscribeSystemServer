package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.DBUtil;
import dataService.BussinessAreaDataService;
import po.BussinessAreaPO;

public class BussinessAreaData implements BussinessAreaDataService{

	/**
	 * 查找城市
	 */
	public ArrayList<String> findCity() {
		ArrayList<String> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from bussinessarea");
		
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ResultSet rs = ptmt.executeQuery();
		
		BussinessAreaPO ba = null;
		while(rs.next()){
			ba = new BussinessAreaPO();
			ba.setCityName(rs.getString("city"));
			ba.setBussinessAreaName(rs.getString("bussinessarea"));
			
			String city = rs.getString("city");
			boolean isNotRepeat = true;
			for(int i=0; i<result.size(); i++){
				if(result.get(i).equals(city)){
					isNotRepeat = false;
				}
			}
			if(isNotRepeat){
				result.add(city);
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	/**
	 * 根据城市查找商圈
	 */
	public ArrayList<BussinessAreaPO> findBussinessAreaByCity(String city) {
		ArrayList<BussinessAreaPO> result = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from bussinessarea");
		sb.append(" where city=?");
		
		PreparedStatement ptmt;
			
		try {
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, city);
		
		ResultSet rs = ptmt.executeQuery();
		
		BussinessAreaPO ba = null;
		while(rs.next()){
			ba = new BussinessAreaPO();
			ba.setCityName(rs.getString("city"));
			ba.setBussinessAreaName(rs.getString("bussinessarea"));
			
			result.add(ba);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

}
