package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BussinessAreaPO;

public interface BussinessAreaDataService extends Remote{

	public ArrayList<String> findCity()throws RemoteException;
	
	public ArrayList<BussinessAreaPO> findBussinessAreaByCity(String city)throws RemoteException;
}
