package model;
import java.util.ArrayList;
import java.util.*;
import exceptions.NoAgeException;
import exceptions.NormativeException;
public class Shop {
	//Attributes
	private String name;
	private int quantity_clients;
	private Calendar date;
	private int day;
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
	public boolean parNumber(int day) {
		boolean is=false;
		if (day%2==0) {
			is=true;
		}
		return is;
	}
	public void allowEntry(String type,String number) throws NoAgeException, NormativeException{
		Calendar date =  new GregorianCalendar();
		int penultimate=0;
		day=date.get(Calendar.DATE);
		char last = number.charAt(number.length()-2);
		penultimate = last;
		boolean daypar=parNumber(day);
		boolean idNumber = parNumber(penultimate);
		if(type.equals(Client.CI)) {
			quantity_clients++;
			throw new NoAgeException();
		}
		else if(daypar==true && idNumber==false) {
			Client client=new Client(type, number);
			this.clients.add(client);
			quantity_clients++;
		}
		else if(daypar==false && idNumber==true) {
			Client client=new Client(type, number);
			this.clients.add(client);
			quantity_clients++;
			}
		else {
			quantity_clients++;
			throw new NormativeException();
			}
	}
	public int quantityClients(){
		return quantity_clients;
	}
	public void exitProgram() {
		this.clients.clear();
		quantity_clients=0;
	}
}
