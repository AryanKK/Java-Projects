/*Aryan K. Kedarisetty 
 The following program uses OOP and arraylists to support a GUI interface
 of an interactive shopping cart. 
*/


import java.text.*;
public class Item {
	private String name;
	private double price;
	private double bulkPrice;
	private int bulkQuant;
	private boolean isBulk;
	
	public Item (String name, double price) {// initializes standard price and name fields
		if (price < 0) throw new IllegalArgumentException ("price cannot be negative");
		this.name = name;
		this.price = price;
		
	}
	public Item (String name, double price, int bulkQuantity, double bulkPrice) { //initializes field values along with bulk values
		if (price < 0|| bulkQuantity < 0 || bulkPrice < 0) throw new IllegalArgumentException ("prices or quantities cannot be negative");
		this.name = name;
		this.price = price;
		this.bulkQuant = bulkQuantity;
		this.bulkPrice = bulkPrice;
		this.isBulk = true;
	}
	public double priceFor(int quant) { //returns price for specific quantity
		double quantPrice = 0;
		int numBulks = 0;
		int individualQuant = 0;
		if (quant < 0) throw new IllegalArgumentException ("quantity cannot be negative");
		if (isBulk && (double) quant/bulkQuant >= 1) {//checks if bulk price should be applied
			numBulks = (quant - (quant % bulkQuant))/bulkQuant;
			individualQuant = quant % bulkQuant;
			quantPrice = (numBulks * bulkPrice) + (individualQuant * price);
			
			
		}
		else {
			quantPrice = quant * price;
		}
		return quantPrice;
	}
	
	public String toString () {//returns String representation 
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String itemStr = name + ", " + nf.format(price);
		if (isBulk) {//checks if bulk fields apply
			itemStr += "( " + bulkQuant + " for " + nf.format(bulkPrice) + " )";
		}
		return itemStr;
	}
	
		
	
}
