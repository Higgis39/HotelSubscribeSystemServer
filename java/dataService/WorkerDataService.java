package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.WorkerPO;

public interface WorkerDataService extends Remote{
	public void updateWorker(WorkerPO p)throws RemoteException;

	public void insertWorker(WorkerPO po)throws RemoteException;
	
	public List<WorkerPO> findWorkerByHotelName(String hotelName) throws RemoteException;
}
