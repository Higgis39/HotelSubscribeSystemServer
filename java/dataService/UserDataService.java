package dataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.UserPO;

/**
 * 
 * @author 费慧通
 *
 */
public interface UserDataService extends Remote{
	/**
	 * 增加user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void insertUser(UserPO u)throws RemoteException;
	
	/**
	 * 更新user对象
	 * 
	 * @param u UserPO类型，系统用来存储的User对象
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public void updateUser(UserPO u)throws RemoteException;
	
	/**
	 * 获得单个user对象
	 * 
	 * @param id String类型，用户的唯一标识id
	 * @see
	 * try/catch块捕获数据库连接失败异常
	 */
	public UserPO findUser(String id)throws RemoteException;

	/**
	 * 得到最后一个user对象的id
	 * 
	 * @see
	 * @throws SQLException 抛出数据库连接失败异常
	 */
	public String distributeUserid() throws RemoteException;
	
	/**
	 * 将信用值变化情况转化为String类型
	 * @param cc ArrayList<String>类型
	 */
	public String creditchangeToSql(ArrayList<String> cc) throws RemoteException;
	
	/**
	 * 将数据库读出的String类型信用变化转化为ArrayList类型
	 * @param creditchange String类型
	 */
	public ArrayList<String> creditchangeToList(String creditchange)throws RemoteException;
}
