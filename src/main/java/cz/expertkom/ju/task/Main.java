package cz.expertkom.ju.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {

	private static final String WHEN_TS = "when (ts): ";
	private static final String LIST = "list: ";
	private static final String TEXT = "text ";

	// private static int count = 10;
	private static int countInt = 10;

	public static void main(String[] args) throws UnirestException, MyException /* vyhození v cyklu */ {
		
		
		Person p = new Customer("Jan", "Nov�k");
		
		try {
			String result = Helper.getSum(5, 4);
			System.out.println(result);
		} catch (MyException e){
			System.out.println("chyba:"+e.getLocalizedMessage());
		};
		
		
		Gson gson = new Gson();	
		String json = gson.toJson(p);
		String json2 = gson.toJson(p.getName());
		System.out.println(json);
		System.out.println(json2);
		

		System.out.println("************************************************************/");
		
  		HttpResponse<JsonNode> asJson = Unirest.post("http://httpbin.org/post")
		  .queryString("name", "Mark")
		  .field("last", "Polo")
		  .field("last2", "Polo2")
		  .asJson();
		System.out.println(asJson.getBody());
		
		System.out.println("************************************************************/");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		String cal = sdf.format(calendar.getTime());
		
		System.out.println("Cal: "+cal);
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.MONTH) + 1); // aktu�ln� m�s�c +1 !!
		System.out.println("Te� je: "+calendar.getTime());
		
		Date date = new Date();
		String format = sdf.format(date);
		System.out.println("Nyn� je: "+format);
		
		System.out.println("************************************************************/");
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < countInt; i++) {
			Date date2 = new Date();
			System.out.println(WHEN_TS + date2.getTime());
			String text = TEXT + i;
			list.add(text);
			if (i % 2 == 0) {
				System.out.println(text);
			}
			list.size();

		}

		for (String s : list) {
			if (s.contains("5")) {
				//break;
				continue;
			}
			System.out.println(LIST + s);
		}
		
		for (int i=0; i<20; i++) {
			Person p2 = new Person("Jan", "Novák"); 
			if (i>20) {
				
				throw new MyException("dvacátá první !");
			}
		}
	} // konec metody main
}
