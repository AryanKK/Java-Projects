import java.util.*;
public class Catalog {
	private String name;
	private ArrayList<Item> items = new ArrayList<>();;
	public Catalog(String name) { //constructs catalog and sets name
		this.name = name;
	}
	public void add(Item item) {//adds item to catalog list (items)
		items.add(item);
	}
	public int size() { //returns size of items list (how many items in catalog)
		return items.size();
	}
	public Item get(int index) { //returns Item at requested index
		return items.get(index);
	}
	public String getName() {//returns name of catalog
		return name;
	}

}
