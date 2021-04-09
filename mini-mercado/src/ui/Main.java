package ui;

import model.Minimarket;

public class Main {
	private static Minimarket miniMarket;
	
	public static void main(String[] args) {
		miniMarket=new Minimarket();
		miniMarket.menu();
	}

}
