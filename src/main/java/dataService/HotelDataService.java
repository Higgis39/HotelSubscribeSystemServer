package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import po.HotelPO;

public interface HotelDataService extends Remote{
	/**
	 * 增加hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insertHotel(HotelPO h)throws RemoteException;
	
	/**
	 * 更新hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void updateHotel(HotelPO h)throws RemoteException;
	
	public HotelPO findHotelByName(String hotelname)throws RemoteException;
	public HotelPO findHotelById(String id)throws RemoteException;
	
	public ArrayList<HotelPO> findByCityAndBusinessarea(String city, String businessarea) throws RemoteException;
	public ArrayList<HotelPO> findByCityAndBusinessareaAndName(String city, String businessarea, String hotelname) throws RemoteException;
	public ArrayList<HotelPO> findByCityAndBusinessareaAndStar(String city, String businessarea, int star) throws RemoteException;
	public ArrayList<HotelPO> findByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade) throws RemoteException;
	public ArrayList<HotelPO> findByAll(String address, String businessarea, int star, double mingrade, double maxgrade) throws RemoteException;
	
	public ArrayList<HotelPO> pfindByCityAndBusinessarea(String city, String businessarea, String userId) throws RemoteException;
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndName(String city, String businessarea, String hotelname, String userId) throws RemoteException;
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndStar(String city, String businessarea, int star, String userId) throws RemoteException;
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade, String userId) throws RemoteException;
	public ArrayList<HotelPO> pfindByAll(String address, String businessarea, int star, double mingrade, double maxgrade, String userId) throws RemoteException;
	
	
	public ArrayList<HotelPO> find(ArrayList<Map<String, Object>> params) throws RemoteException;
	
	/**
	 * 得到最后一个hotel对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeHotelid() throws RemoteException;

	ArrayList<HotelPO> pfind(ArrayList<Map<String, Object>> params, String userId)throws RemoteException;
}
