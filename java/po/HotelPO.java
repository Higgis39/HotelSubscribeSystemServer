package po;

public class HotelPO {
	String hotelid;
	String password;
	String hotelname;
	String phonenumber;
	String address;
	String city;
	String businessarea;
	String introduction;
	String facilities;
	int star;
	double grade;
	int minprice;
	int numberofevaluators;
	
	//构造函数
	public HotelPO(String hotelid,String password,String hotelname,String phonenumber,String city,String address,String businessarea,String introduction,String facilities,int star,double grade,int minprice, int numberofevaluators){
		this.hotelid = hotelid;
		this.password = password;
		this.hotelname = hotelname;
		this.phonenumber = phonenumber;
		this.city = city;
		this.address = address;
		this.businessarea= businessarea;
		this.introduction = introduction;
		this.facilities = facilities;
		this.star = star;
		this.grade = grade;
		this.minprice = minprice;
		this.numberofevaluators = numberofevaluators;
	}
	
	public HotelPO(){
		
	}
	
	//得到酒店账号
	public String getHotelId(){
		return hotelid;
	}
	
	//得到酒店账号密码
	public String getPassword(){
		return password;
	}
	
	//得到酒店名称
	public String getName(){
		return hotelname;
	}
	
	//得到酒店联系方式
	public String getPhonenumber(){
		return phonenumber;
	}
	
	//得到酒店地址
	public String getAddress(){
		return address;
	}
	
	//得到酒店所在城市
	public String getCity() {
		return city;
	}

	//得到酒店所处商圈
	public String getBusinessArea(){
		return businessarea;
	}

	//得到酒店简介
	public String getIntroduction(){
		return introduction;
	}
	
	//得到酒店设施服务
	public String getFacilities(){
		return facilities;
	}
	
	//得到酒店星级
	public int getStar(){
		return star;
	}
	
	//得到酒店评分
	public double getGrade(){
		return grade;
	}
	
	//得到酒店的房间最低价格
	public int getminprice(){
		return minprice;
	}
	
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public void setMinprice(int minprice){
		this.minprice = minprice;
	}

	public int getNumberofevaluators() {
		return numberofevaluators;
	}

	public void setNumberofevaluators(int numberofevaluators) {
		this.numberofevaluators = numberofevaluators;
	}

	@Override
	public String toString() {
		return "HotelPO [hotelid=" + hotelid + ", password=" + password + ", hotelname=" + hotelname + ", phonenumber="
				+ phonenumber + ", address=" + address + ", city=" + city + ", businessarea=" + businessarea
				+ ", introduction=" + introduction + ", facilities=" + facilities + ", star=" + star + ", grade="
				+ grade + ", minprice=" + minprice + ", numberofevaluators=" + numberofevaluators + "]";
	}

	

	
}
