package model;
import java.util.ArrayList;
public class Shop {
	//Attributes
	private String name;
	private int quantity_clients;
	//Relations
	private ArrayList<Client>clients;
	//Methods
	public Shop(String name){
		this.name=name;
		this.clients=new ArrayList<Client>();
	}
	public String getName(){
		return name;
	}
	public int getQuantity_Clients(){
		return quantity_clients;
	}
	public void setQuantity_Clients(int quantity_clients){
		this.quantity_clients=quantity_clients;
	}
	public ArrayList<Client> getClients(){
		return clients;
	}
	
}
