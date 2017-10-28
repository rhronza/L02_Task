package cz.expertkom.ju.task;

import java.util.Date;

public class Product extends Item implements Nameable {

	private String name;
	
	public Product() {
		super();
	}
	
	public Product(Date date) {
		super(date);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreated() {
		Date created = super.getCreated();
		 
		if (created == null) {
			return new Date();
		}
		return new Date();
	}	
	
	
}
