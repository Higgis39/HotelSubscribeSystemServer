package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDataService extends Remote{
	
	public void insertRoom(RoomPO r)throws RemoteException;
	
	public void updateRoom(RoomPO r)throws RemoteException;
	
	public ArrayList<RoomPO> findRoomByHotelName(String HotelName) throws RemoteException;
	
	public RoomPO findRoomByIDAndHotelname(String roomID,String hotelName) throws RemoteException;
}
