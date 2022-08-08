import java.util.*;
public class ShoppingCart {
	
	private boolean isDiscounted;
	
	private ArrayList<ItemOrder> orders;
	public ShoppingCart() {
		 orders = new ArrayList<>();
		
	}
	
	public void setDiscount(boolean value) {//makes discounted true if discount is applied
		this.isDiscounted = value;
	}
	public void add (ItemOrder order) {//adds item order to shopping cart
		boolean b = false;
		for (int i = 0; i < orders.size(); i++) {
			//checks to see if string rep of both items is name (for comparison)
			if ((orders.get(i).getItem().toString()).equals(order.getItem().toString())) {
				orders.set(i, order);
				b = true;
			}
			
		}
		//if order didnt replace existing order, add the order to end of cart
		if(b == false) {
			orders.add(order);
		}
		
		
	}
	public double getTotal() {//returns total price of items in shopping cart
		double cost = 0;
		for (int i = 0; i < orders.size(); i++) {
			cost += orders.get(i).getPrice();
			
		}
		
		if (isDiscounted) cost *= 0.9;
		return cost;
	}
	

}
