package po;

/**
 * HotelPromotionPO的职责是保存酒店促销策略持久对象，用来在业务逻辑层与数据层之间传递数据
 * @author hly
 * @version 1.0
 * @see
 */
public class HotelPromotionPO {

	private String hotelname;
	private String name;
	private boolean isbirthday;
	private int numberofroom;
	private boolean ispartner;
	private String begintime;
	private String endtime;
	private double discount;
	
	public HotelPromotionPO(String hotelname, String name, String introduction, boolean isbirthday, int numberofroom, boolean ispartner,
			String begintime, String endtime, double discount) {
		super();
		this.hotelname = hotelname;
		this.name = name;
		this.isbirthday = isbirthday;
		this.numberofroom = numberofroom;
		this.ispartner = ispartner;
		this.begintime = begintime;
		this.endtime = endtime;
		this.discount = discount;
	}

	public HotelPromotionPO(){
		
	}

	
	
	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIsbirthday() {
		return isbirthday;
	}

	public void setIsbirthday(boolean isbirthday) {
		this.isbirthday = isbirthday;
	}

	public int getNumberofroom() {
		return numberofroom;
	}

	public void setNumberofroom(int numberofroom) {
		this.numberofroom = numberofroom;
	}

	public boolean isIspartner() {
		return ispartner;
	}

	public void setIspartner(boolean ispartner) {
		this.ispartner = ispartner;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
