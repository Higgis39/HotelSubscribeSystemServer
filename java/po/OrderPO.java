package po;

public class OrderPO {
		
		private String id;
		
		private String hotelId;
		
		private String userId;
		
		private String status;
		
		private String entryTime;
		
		private String lastTime;
		
		private double price;
		
		private String comment;
		
		private String RoomType;
		
		private int RoomNum;
		
		private boolean haschild;
		
		public OrderPO(){
			
		}

		public OrderPO(String id, String hotelId, String userId, String status,
				String entryTime, String lastTime,int price,String comment,String RoomType,int RoomNum,boolean haschild) {
			super();
			this.id = id;
			this.hotelId = hotelId;
			this.userId = userId;
			this.status = status;
			this.entryTime = entryTime;
			this.lastTime = lastTime;
			this.price = price;
			this.comment = comment;
			this.RoomType = RoomType;
			this.RoomNum = RoomNum;
			this.haschild = haschild;
		}
		
		

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getHotelId() {
			return hotelId;
		}

		public void setHotelId(String hotelId) {
			this.hotelId = hotelId;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEntryTime() {
			return entryTime;
		}

		public void setEntryTime(String entryTime) {
			this.entryTime = entryTime;
		}

		public String getLastTime() {
			return lastTime;
		}

		public void setLastTime(String lastTime) {
			this.lastTime = lastTime;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double d) {
			this.price = d;
		}

		public String getComment(){
			return comment;
		}
		
		public void setComment(String Comment){
			this.comment=Comment;
		}

		public String getRoomType() {
			return RoomType;
		}

		public void setRoomType(String roomType) {
			RoomType = roomType;
		}

		public int getRoomNum() {
			return RoomNum;
		}

		public void setRoomNum(int roomNum) {
			RoomNum = roomNum;
		}
		
		public boolean gethaschild(){
			return haschild;
		}
		
		public void sethaschild(boolean haschild){
			this.haschild = haschild;
		}

		@Override
		public String toString() {
			return "OrderPO [id=" + id + ", hotelId=" + hotelId + ", userId=" + userId + ", status=" + status
					+ ", entryTime=" + entryTime + ", lastTime=" + lastTime + ", price=" + price + ", comment="
					+ comment + ", RoomType=" + RoomType + ", RoomNum=" + RoomNum + "]";
		}
		
		
}
