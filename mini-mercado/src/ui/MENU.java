package ui;

import java.util.Arrays;
import java.util.Scanner;

import exception.AgeException;
import exception.DayException;
import model.Minimarket;

public class MENU {
	private final static int ADD_PERSON = 1;
	private final static int SHOW_ATTEMPS = 2;
	private final static int EXIT = 3;
	private static Scanner sc = new Scanner(System.in);
	private Minimarket minimarket;
	
	public MENU() {
		this.minimarket= new Minimarket();
	}
	public void startProgram() {
		System.out.println("Welcome to the mini-market 'Mi Barrio Te Quiere'");
		int option;
		do {
			showMenu();
			option = readOption();
			doOperation(option);
		} while(option != EXIT);
	}
	public void showMenu() {
		System.out.println("\n"+"(1) Register the entry of a person");
		System.out.println("(2) Check the number of people who have tried to enter");
		System.out.println("(3) exit the program");
	}
	
	public int readOption() {
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	public void addPerson() {
		System.out.println("Tipo De Documento de Identidad");
		System.out.println("(1) Tarjeta De Identidad"+"\n"+"(2) Cedula De Ciudadania"+"\n"+"(3) Pasaporte"+"\n"+"(4) Cedula De Extranjeria");
		int choice = sc.nextInt();
		sc.nextLine();
		String idType="";
		switch(choice) {
		case 1:
			idType="Tarjeta De Identidad";
			break;
		case 2:
			idType="Cedula De Ciudadania";
			break;
		case 3:
			idType="Pasaporte";
			break;
		case 4:
			idType="Cedula De Extranjeria";
			break;
		default:
			System.out.println("Invalid option, repeat again");
	}
		System.out.println("Enter the document number (No points)");
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			if(minimarket.addPerson(idType,id))  {
				System.out.println("\n"+"***Login successfully added***");
			}
		} catch (AgeException e) {
			System.out.println(e.getMessage());
			System.out.println(Arrays.deepToString(e.getStackTrace()));
		} catch (DayException e) {
			System.out.println(e.getMessage());
			System.out.println(Arrays.deepToString(e.getStackTrace()));
		}
	}
	public void doOperation(int choice) {
		switch(choice) {
			case ADD_PERSON:
				addPerson();
				break;
			case SHOW_ATTEMPS:
				System.out.println("The number of people who have tried to enter the minimarket is: "+minimarket.getAttempsNum());				
				break;
			case EXIT:
				break;
			default:
				System.out.println("Invalid option, try again");
		}
	}
}
