package runner;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import RMI.RemoteHelper;
import data.OrderData;
import dataService.OrderDataService;
import po.OrderPO;

public class ServerRunner {
	public ServerRunner() {
		new RemoteHelper();
		System.out.println("Server Run!");
//		setAbnormal();
	}
	
	private static void setAbnormal(){
		Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.HOUR_OF_DAY, 18); // 控制时  
        calendar.set(Calendar.MINUTE, 0);       // 控制分  
        calendar.set(Calendar.SECOND, 0);       // 控制秒  
  
        Date time = calendar.getTime();         // 得出执行任务的时间,此处为今天的18：00：00  
  
        Timer timer = new Timer();  
//        MyTask task = new MyTask();
//        timer.scheduleAtFixedRate(task, time, 1000 * 60 * 60 * 24);// 这里设定将延时每天固定执行  
    }  
	
//	static class MyTask extends TimerTask{      
//        public void run(){     
//        	OrderDataService service = new OrderData();
//        	Date dt=new Date();
//        	DateFormat df=new SimpleDateFormat("yyyy/mm/dd");
//        	String time = df.format(dt);
//        	try {
//        		List<OrderPO> list=service.findByDate(time);
//        	    for(OrderPO po:list){
//        	    	if(po.getStatus().equals("未执行")){
//        	    		po.setStatus("异常");
//        	    		service.update(po);
//        	    		}
//        	    }
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (RemoteException e) {
//				e.printStackTrace();
//			}
//        }     
//    }  	
	
	public static void main(String[] args){
		new ServerRunner();
	}
}

