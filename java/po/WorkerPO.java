package po;

import java.util.Date;

public class WorkerPO {
	
	private String hotelName;
	private String name;
	private int age;
	private String sex;
	private String beginTime;
	
	public WorkerPO() {
		
	}

	public WorkerPO(String hotelName, String name, int age, String sex, String beginTime) {
		super();
		this.hotelName = hotelName;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.beginTime = beginTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	
}
