package cz.expertkom.ju.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public /*abstract*/ class Person implements Nameable {
	
	public Person(String firstname, String surname) {
		super();
		this.firstname = firstname;
		this.surname = surname;
	}

	private List<Item> items = new ArrayList<Item>();

	private String firstname;
	private String surname;
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getName() {
		return firstname + " " + surname;
	}

	public void setName(String name) {
		if (name != null && name.contains(" ")) {
			String[] parts = name.split(Pattern.quote(" "));
			if (parts.length > 1) {
				this.firstname = parts[0];
				this.surname = parts[1];
			}
		}
	}

}
