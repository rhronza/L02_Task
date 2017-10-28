package cz.expertkom.ju.task;

public class MyException extends Exception {

	private String duvod;
	
	MyException (String duvod){
		this.duvod = duvod;
		
	}

	public String getDuvod() {
		return duvod;
	}

	public void setDuvod(String duvod) {
		this.duvod = duvod;
	}
	
	
	
}
