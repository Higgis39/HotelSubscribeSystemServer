package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.WebPromotionPO;

public interface WebPromotionDataService extends Remote{

	public boolean insertWebPromotion(WebPromotionPO wp)throws RemoteException;
	public boolean updateWebPromotion(WebPromotionPO wp)throws RemoteException;
	public void deleteWebPromotion(String name)throws RemoteException;
	public ArrayList<WebPromotionPO> findWebPromotion() throws RemoteException;
	public ArrayList<WebPromotionPO> findWebPromotionByDiscount(double discount) throws RemoteException;
	public WebPromotionPO findWebPromotionByName(String name) throws RemoteException;
}
