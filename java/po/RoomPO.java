package po;

public class RoomPO {
	
	String hotelName;
	int roomNum;
	String roomType;
	int roomPrice;
	int peopleNumber;
	boolean IsEmpty;
	
	public RoomPO(){
		
	}
	
	public RoomPO(String HotelName, int RoomNum,int PeopleNumber,int RoomPrice,String RoomType){
		
		hotelName=HotelName;
		roomNum=RoomNum;
		roomType=RoomType;
		roomPrice=RoomPrice;
		peopleNumber=PeopleNumber;
		IsEmpty=true;
	}
	
	public String getHotelName(){
		return hotelName;
	}
	
	public int getRoomNum(){
		return roomNum;
	}
	
	public String getRoomType(){
		return roomType;
	}
	
	public int getRoomPrice(){
		return roomPrice;
	}
	
	public int getPeopleNumber(){
		return peopleNumber;
	}
	
	public boolean getIsEmpty(){
		return IsEmpty;
	}
	
	public void addRoom(){
		IsEmpty=true;
	}

	
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public void setIsEmpty(boolean isEmpty) {
		IsEmpty = isEmpty;
	}
	
	
}
