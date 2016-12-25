package po;

import java.util.ArrayList;

/**
 * 
 * @author 费慧通
 *
 */
public class UserPO {
	String name;
	String id;
	String password;
	String usertype;
	int creditvalue;
	String VIPtype;
	int VIPgrade;
	String phonenumber;
	String birthday;
	String company;
	ArrayList<String> creditchange;
	
	//构造函数
	public UserPO(String name,String id,String password,String usertype,int creditvalue,String VIPtype,int VIPgrade,String phonenumber,String birthday,String company,ArrayList<String> creditchange){
		this.name = name;
		this.id = id;
		this.password = password;
		this.usertype = usertype;
		this.creditvalue = creditvalue;
		this.VIPtype = VIPtype;
		this.VIPgrade = VIPgrade;
		this.phonenumber = phonenumber;
		this.birthday = birthday;
		this.company = company;
		this.creditchange = creditchange;
	}
	
	public UserPO(){
		
	}
	
	//得到用户名
	public String getname(){
		return name;
	}
	
	//得到账户
	public String getid(){
		return id;
	}
	
	//得到密码
	public String getpassword(){
		return password;
	}
	
	//得到用户类型
	public String getusertype(){
		return usertype;
	}
	
	//得到信用值
	public int getcreditvalue(){
		return creditvalue;
	}
	
	//得到VIP类型
	public String getVIPtype(){
		return VIPtype;
	}
	
	//得到VIP等级
	public int getVIPgrade(){
		return VIPgrade;
	}	
	
	//得到联系方式
	public String getphonenumber(){
		return phonenumber;
	}	
	
	//得到生日
	public String getbirthday(){
		return birthday;
	}
	
	//得到公司
	public String getcompany(){
		return company;
	}
	
	//得到信用变化
	public ArrayList<String> getcreditchange(){
		return creditchange;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public void setCreditvalue(int creditvalue) {
		this.creditvalue = creditvalue;
	}

	public void setVIPtype(String vIPtype) {
		VIPtype = vIPtype;
	}

	public void setVIPgrade(int vIPgrade) {
		VIPgrade = vIPgrade;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCreditchange(ArrayList<String> creditchange) {
		this.creditchange = creditchange;
	}
}
