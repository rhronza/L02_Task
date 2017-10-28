package cz.expertkom.ju.task;

import java.util.Date;

public abstract class Item {
	
	/* abstract - nejde vytvořit instance tříydy, míá metody jdou přepsat  */

	public Item() {
		this.created = new Date();
	}
	
	public Item(Date created) {
		super();
		this.created = created;
	}

	private /*final*/ Date created =  new Date(); /* hodnota se do ní dostae jen při inicializaci tj. přes konstriktor nebo při nincilizaci */

	public /*final*/ Date getCreated() {
		return created;
	}

	
}
