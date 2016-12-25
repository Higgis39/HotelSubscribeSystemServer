package po;

import java.io.Serializable;

public class BussinessAreaPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cityName;
	String bussinessAreaName;
	
	public BussinessAreaPO(String cityName, String bussinessAreaName) {
		super();
		this.cityName = cityName;
		this.bussinessAreaName = bussinessAreaName;
	}

	public BussinessAreaPO(){
		
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBussinessAreaName() {
		return bussinessAreaName;
	}

	public void setBussinessAreaName(String bussinessAreaName) {
		this.bussinessAreaName = bussinessAreaName;
	}
	
	
}
