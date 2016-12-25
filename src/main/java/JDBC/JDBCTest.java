package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import data.HotelData;
import data.OrderData;
import data.UserData;
import po.HotelPO;
import po.OrderPO;
import po.UserPO;


public class JDBCTest {
	
	public static void main(String[] args) {
		
		Connection conn = DBUtil.getConnection();
//		HotelData hd = new HotelData();
////		
//		ArrayList<Map<String, Object>> params = new ArrayList<Map<String, Object>>();
//		Map<String, Object> param = new HashMap<String, Object>();
//		//查找roomID=2;
//		param.put("name", "roomID");
//		param.put("rela", "=");
//		param.put("value", "2");
//		//查找star小于4
//		param.put("name", "grade");
//		param.put("rela", "<=");
//		param.put("value", "3");
//		param.put("name", "grade");
//		param.put("rela", ">=");
//		param.put("value", "2");
//		params.add(param);
//		
//		ArrayList<HotelPO> po = hd.findByAddressAndBusinessarea("南京", "仙林中心");
////		
//		for(int i=0; i<po.size(); i++){
//			System.out.print(po.get(i).toString()+" ");
//		}
		

		
//		UserData ud = new UserData();
//////		
//		UserPO up = new UserPO();
//		up.setName("lisii");
//		up.setId("10004");
//		up.setPassword("0");
//		up.setUsertype("普通客户");
//		up.setCreditvalue(1000);
//		up.setVIPtype("企业会员");
//		up.setVIPgrade(5);
//		up.setPhonenumber("13579246868");
//		up.setBirthday("06-20");
//		up.setCompany("google");
//		ArrayList<String> a = new ArrayList<>();
//		a.add("增加50");
//		a.add("减少50");
//		up.setCreditchange(a);
//		
//		ud.insert(up);
		
//		up = ud.find("10005");
//		System.out.println(up.getname());
//		System.out.println(up.getid());
//		System.out.println(up.getpassword());
//		System.out.println(up.getphonenumber());
//		System.out.println(up.getcreditchange());
//		String id = ud.distributeid();
//		System.out.println(id);
//		UserPO up = ud.find("10000");
		
//		HotelData  hd = new HotelData();
////		ArrayList<HotelPO> h = new ArrayList<>();
////		h = hd.findByAddressAndBusinessarea("南京", "仙林中心");
//		HotelPO h = new HotelPO();
//		h = hd.findById("10000");
//		String name = h.getName();
//		System.out.println(name);
		
//		OrderData od = new OrderData();
//		OrderPO op = new OrderPO();
//		op.setId("10001");
//		op.setHotelId("10000");
//		op.setUserId("10002");
//		op.setStatus("未执行");
//		op.setEntryTime("11-11");
//		op.setLastTime("11-14");
//		op.setPrice(90);
//		op.setComment("一般般");
//		op.setRoomType("双人间");
//		op.setRoomNum(4);
//		od.insert(op);
		
//		List<String> o = new ArrayList<>(); 
//		o = od.findHotelIdByUserId("10005");
//		System.out.println(o.get(0));
//		o = od.findByClient("10002");
//		String name = o.get(0).getComment();
//		System.out.println(name);
	}			
}

//private String id;
//private String hotelId;
//private String userId;
//private String status;
//private String entryTime;
//private String lastTime;
//private double price;
//private String comment;
//private String RoomType;
//private int RoomNum;
