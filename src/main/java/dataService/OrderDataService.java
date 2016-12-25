package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

import po.OrderPO;

public interface OrderDataService extends Remote{
	public boolean insertOrder(OrderPO po)throws RemoteException;
	
	public List<OrderPO> findOrderByClient(String ID) throws RemoteException;
	
	public boolean updateOrder(OrderPO po)throws RemoteException;
	
	public String distributeOrderid() throws RemoteException;
	
	public OrderPO findOrderByOrderID(String ID)throws RemoteException;
	
	public List<OrderPO> findOrderByDate(String Date) throws RemoteException;
	
	public List<OrderPO> findOrderByHotelID(String ID) throws RemoteException;
	
	public List<OrderPO> findOrderByStatus(String Status) throws RemoteException;
} 
