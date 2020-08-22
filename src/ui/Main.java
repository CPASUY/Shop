package ui;
import java.util.Scanner;

import model.Client;
import model.Shop;
import exceptions.NoAgeException;
import exceptions.NormativeException;
public class Main {
	private Shop mainShop;
	private static Scanner lector;
	public static void main(String[] args) {
		lector = new Scanner (System.in);
		Main objMain=new Main();
		objMain.createCompany();
		int option=0;
		do{
			cls();
			System.out.println ("Options Menu"+
					"\n1.Enter the store"+
					"\n2.Check the number of people who have tried to enter"+
					"\n3.Exit the program");
			System.out.println ("Choose the option you want");
			option=lector.nextInt();
			lector.nextLine();
			switch (option){
				case 1:
					objMain.allowEntry();
				break;
				case 2:
					objMain.quantityClients();
				break;
				case 3:
					objMain.exitProgram();
				break;
			}
		System.out.println("To return to the menu type 0");
		option=lector.nextInt();
		} while (option==0);
	}
	public static void cls(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch (Exception E){
			System.out.println (E);
		}
	}	
	public void createCompany(){
			String name="Mi Barrio Te Quiere";
			mainShop=new Shop (name);
	}
	public void allowEntry(){
		String type="";
		System.out.println("What is your type of document?");
		System.out.println("Type 1 for Tarjeta de Identidad, 2 for Cedula, 3 for Pasaporte");
		int option=Integer.parseInt(lector.nextLine());
		if(option==1){
			type=Client.CI;
		}
		else if(option==2){
			type=Client.CC;
		}
		else if(option==3){
			type=Client.PP;
		}
		System.out.println("Enter the identification number");
		String number=lector.nextLine();
		try{
		mainShop.allowEntry(type,number);
		System.out.println("You can enter store");
		}catch(NoAgeException e) {
			System.out.println(e.getMessage());
		}catch(NormativeException e) {
		System.out.println(e.getMessage());
		}
	}
	public void quantityClients(){
		int quantity=mainShop.quantityClients();
		System.out.println("The total number of clients who have tried to enter the store is" + quantity);
	}
	public void exitProgram(){
	mainShop.exitProgram();
	System.out.println("You have exited the program successfully");
	}
}
