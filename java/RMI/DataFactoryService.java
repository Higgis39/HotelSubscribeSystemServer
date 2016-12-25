package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import data.HotelData;
import data.HotelPromotionData;
import data.OrderData;
import data.RoomData;
import data.UserData;
import data.WebPromotionData;
import data.WorkerData;
import dataService.HotelDataService;
import dataService.HotelPromotionDataService;
import dataService.OrderDataService;
import dataService.RoomDataService;
import dataService.UserDataService;
import dataService.WebPromotionDataService;
import dataService.WorkerDataService;
import po.HotelPO;
import po.HotelPromotionPO;
import po.OrderPO;
import po.RoomPO;
import po.UserPO;
import po.WebPromotionPO;
import po.WorkerPO;

public class DataFactoryService extends UnicastRemoteObject implements HotelPromotionDataService,
                                                                       OrderDataService,RoomDataService,UserDataService,
                                                                       WebPromotionDataService,WorkerDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 536926594031666155L;
	private HotelDataService hotel;
	private HotelPromotionDataService hotelpromotion;
	private OrderDataService order;
	private RoomDataService room;
	private UserDataService user;
	private WebPromotionDataService webpromotion;
	private WorkerDataService worker;
	
	public DataFactoryService() throws RemoteException {
		hotel = new HotelData();
		hotelpromotion = new HotelPromotionData();
		order = new OrderData();
		room = new RoomData();
		user = new UserData();
		webpromotion = new WebPromotionData();
		worker = new WorkerData();
	}

    public void insertHotel(HotelPO h)throws RemoteException {
	
    }
	
	/**
	 * 更新hotel对象
	 * 
	 * @param h HotelPO类型，系统用来存储的Hotel对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void updateHotel(HotelPO h)throws RemoteException{
		hotel.updateHotel(h);
	}
	
	public HotelPO findHotelByName(String hotelname)throws RemoteException{
		return hotel.findHotelByName(hotelname);
	}
	public HotelPO findHotelById(String id)throws RemoteException{
		return hotel.findHotelById(id);
	}
	
	public ArrayList<HotelPO> findByCityAndBusinessarea(String city, String businessarea) throws RemoteException{
		return hotel.findByCityAndBusinessarea(city, businessarea);
	}
	
	public ArrayList<HotelPO> findByCityAndBusinessareaAndName(String city, String businessarea, String hotelname) throws RemoteException{
		return hotel.findByCityAndBusinessareaAndName(city, businessarea, hotelname);
	}
	
	public ArrayList<HotelPO> findByCityAndBusinessareaAndStar(String city, String businessarea, int star) throws RemoteException{
		return hotel.findByCityAndBusinessareaAndStar(city, businessarea, star);
	}
	
	public ArrayList<HotelPO> findByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade) throws RemoteException{
		return hotel.findByCityAndBusinessareaAndGrade(city, businessarea, mingrade, maxgrade);
	}
	
	public ArrayList<HotelPO> findByAll(String address, String businessarea, int star, double mingrade, double maxgrade) throws RemoteException{
		return hotel.findByAll(address, businessarea, star, mingrade, maxgrade);
	}
	
	public ArrayList<HotelPO> pfindByCityAndBusinessarea(String city, String businessarea, String userId) throws RemoteException{
		return hotel.pfindByCityAndBusinessarea(city, businessarea, userId);
	}
	
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndName(String city, String businessarea, String hotelname, String userId) throws RemoteException{
		return hotel.pfindByCityAndBusinessareaAndName(city, businessarea, hotelname, userId);}
	
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndStar(String city, String businessarea, int star, String userId) throws RemoteException{
		return hotel.pfindByCityAndBusinessareaAndStar(city, businessarea, star, userId);}
	
	public ArrayList<HotelPO> pfindByCityAndBusinessareaAndGrade(String city, String businessarea, double mingrade, double maxgrade, String userId) throws RemoteException{
		return hotel.pfindByCityAndBusinessareaAndGrade(city, businessarea, mingrade, maxgrade, userId);}
	
	public ArrayList<HotelPO> pfindByAll(String address, String businessarea, int star, double mingrade, double maxgrade, String userId) throws RemoteException{
		return hotel.findByAll(address, businessarea, star, mingrade, maxgrade);}

	public ArrayList<HotelPO> find(ArrayList<Map<String, Object>> params) throws RemoteException{
		return hotel.find(params);}
	
	public String distributeHotelid() throws RemoteException {
		return hotel.distributeHotelid();
	}

	ArrayList<HotelPO> pfind(ArrayList<Map<String, Object>> params, String userId)throws RemoteException {
		return hotel.pfind(params, userId);
	}
	
	public boolean insertHotelPromotion(HotelPromotionPO hp)throws RemoteException {
		return hotelpromotion.insertHotelPromotion(hp);
	}
	public boolean updateHotelPromotion(HotelPromotionPO hp)throws RemoteException {
		return hotelpromotion.updateHotelPromotion(hp);
	}
	public void deleteHotelPromotion(String name)throws RemoteException {
		hotelpromotion.deleteHotelPromotion(name);
	}
	public List<HotelPromotionPO> findHotelPromotionByHotelname(String hotelname) throws RemoteException {
		return hotelpromotion.findHotelPromotionByHotelname(hotelname);
	}
	public HotelPromotionPO findHotelPromotionByHotelNameAndName(String hotelName, String name)throws RemoteException {
		return hotelpromotion.findHotelPromotionByHotelNameAndName(hotelName, name);
	}
	
    public boolean insertOrder(OrderPO po)throws RemoteException {
		return order.insertOrder(po);
	}
	
	public List<OrderPO> findOrderByClient(String ID) throws RemoteException {
		return order.findOrderByClient(ID);
	}
	
	public boolean updateOrder(OrderPO po)throws RemoteException {
		return order.updateOrder(po);
	}
	
	public String distributeOrderid() throws RemoteException {
		return order.distributeOrderid();
	}
	
	public OrderPO findOrderByOrderID(String ID)throws RemoteException {
		return order.findOrderByOrderID(ID);
	}
	
	public List<OrderPO> findOrderByDate(String Date) throws RemoteException {
		return order.findOrderByDate(Date);
	}
	
	public List<OrderPO> findOrderByHotelID(String ID) throws RemoteException {
		return order.findOrderByHotelID(ID);
	}
	
	public List<OrderPO> findOrderByStatus(String Status) throws RemoteException {
		return order.findOrderByStatus(Status);
	}

    public void insertRoom(RoomPO r)throws RemoteException {
    	room.insertRoom(r);
	}
	
	public void updateRoom(RoomPO r)throws RemoteException {
		room.updateRoom(r);
	}
	
	public ArrayList<RoomPO> findRoomByHotelName(String HotelName) throws RemoteException {
		return room.findRoomByHotelName(HotelName);
	}
	
	public RoomPO findRoomByIDAndHotelname(String roomID,String hotelName) throws RemoteException {
		return room.findRoomByIDAndHotelname(roomID, hotelName);
	}
	
    public void insertUser(UserPO u)throws RemoteException {
    	user.insertUser(u);
    }
	
	public void updateUser(UserPO u)throws RemoteException {
		user.updateUser(u);
	}
	
	public UserPO findUser(String id)throws RemoteException {
		return user.findUser(id);
	}

	public String distributeUserid() throws RemoteException {
		return user.distributeUserid();
	}
	
	public String creditchangeToSql(ArrayList<String> cc) throws RemoteException {
		return user.creditchangeToSql(cc);
	}
	
	public ArrayList<String> creditchangeToList(String creditchange)throws RemoteException {
		return user.creditchangeToList(creditchange);
	}

	public boolean insertWebPromotion(WebPromotionPO wp)throws RemoteException {
		return webpromotion.insertWebPromotion(wp);
	}
	public boolean updateWebPromotion(WebPromotionPO wp)throws RemoteException {
		return webpromotion.updateWebPromotion(wp);
	}
	public void deleteWebPromotion(String name)throws RemoteException {
		webpromotion.deleteWebPromotion(name);
	}
	public ArrayList<WebPromotionPO> findWebPromotion() throws RemoteException {
		return webpromotion.findWebPromotion();
	}
	public ArrayList<WebPromotionPO> findWebPromotionByDiscount(double discount) throws RemoteException {
		return webpromotion.findWebPromotionByDiscount(discount);
	}
	public WebPromotionPO findWebPromotionByName(String name) throws RemoteException {
		return webpromotion.findWebPromotionByName(name);
	}
	
	public void updateWorker(WorkerPO p)throws RemoteException {
		worker.updateWorker(p);
	}

	public void insertWorker(WorkerPO po)throws RemoteException {
		worker.insertWorker(po);
	}
	
	public List<WorkerPO> findWorkerByHotelName(String hotelName) throws RemoteException {
		return worker.findWorkerByHotelName(hotelName);
	}
}
