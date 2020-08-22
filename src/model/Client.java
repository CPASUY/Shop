package model;

public class Client {
	//Attributes
		private String type;
		private String number;
	//Constants
		public static final String CI="Identification";
		public static final String CC="Cedula";
		public static final String PP= "Pasaporte";
	//Methods
		public Client (String type,String number) {
			this.type=type;
			this.number=number;
		}
		public String getType(){
			return type;
		}
		public void setType(String type){
			this.type=type;
		}
		public String getNumber(){
			return number;
		}
		public void setNumber(String number){
			this.number=number;
		}
}
