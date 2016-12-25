package po;

/**
 * WebPromotionPO的职责是保存网站促销策略持久对象，用来在业务逻辑层与数据层之间传递数据
 * @author hly
 * @version 1.0
 * @see
 */
public class WebPromotionPO {

	private String name;
	private String begintime;
	private String endtime;
	private int VIPgrade;
	private String specificbusinessarea;
	private double discount;
	
	public WebPromotionPO(String name, String begintime, String endtime, int VIPgrade,
			String specificbusinessarea, double discount) {
		super();
		this.name = name;
		this.begintime = begintime;
		this.endtime = endtime;
		this.VIPgrade = VIPgrade;
		this.specificbusinessarea = specificbusinessarea;
		this.discount = discount;
	}
	
	public WebPromotionPO(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	public int getVIPgrade() {
		return VIPgrade;
	}

	public void setVIPgrade(int vIPgrade) {
		VIPgrade = vIPgrade;
	}

	public String getSpecificbusinessarea() {
		return specificbusinessarea;
	}

	public void setSpecificbusinessarea(String specificbusinessarea) {
		this.specificbusinessarea = specificbusinessarea;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
