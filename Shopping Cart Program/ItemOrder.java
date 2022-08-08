
public class ItemOrder {
	Item item;
	int quantity;
	public ItemOrder(Item item, int quant) {//constructs order with specified item and quantity
		this.item = item;
		this.quantity = quant;
	}
	public double getPrice() {//returns price of order
		return item.priceFor(quantity);
		
	}
	
	public Item getItem() {//returns item of the order
		return item;
	}
	
}
