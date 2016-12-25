package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.HotelPromotionPO;

public interface HotelPromotionDataService extends Remote{

	public boolean insertHotelPromotion(HotelPromotionPO hp)throws RemoteException;
	public boolean updateHotelPromotion(HotelPromotionPO hp)throws RemoteException;
	public void deleteHotelPromotion(String name)throws RemoteException;
	public List<HotelPromotionPO> findHotelPromotionByHotelname(String hotelname) throws RemoteException;
	public HotelPromotionPO findHotelPromotionByHotelNameAndName(String hotelName, String name)throws RemoteException;
}
