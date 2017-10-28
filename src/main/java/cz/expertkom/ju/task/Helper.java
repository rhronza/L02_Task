package cz.expertkom.ju.task;

import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public  class Helper {
	
	private static int i1;
	private static int i2;
	
	private static AtomicBoolean ab = new AtomicBoolean(true);
	
	private static final Object lock = new Object();
	
	/* lze do něj přidávat (ideálně  kontruktoru)statickém  ale už ne přepisovat - final */
	private static final List<String> s = new ArrayList<String>(); 
	
	/* statický konstruktor */
	static {
		s.add("text");
	}
	
	
	
	/* statická proměnná vznikne jen jednou, všechny poitery ukazují jen na ní !!! */
	/* synchronized (nedělat u korporátních řešení, které se stejně spouští ve více instancích ) 
	 * - Java nepustí 2 uživatele, další až ukončí předchozí - bu´d v hlavičce metody nebo tělě metody*/
	/* lepší nechat bez zámku, ale někdy to nejde */
	public static /*synchronized*/ String getSum(final int i1, final int i2) throws MyException {
		
		if (s.size()<0) {
			
		}
		
	/* spouštění dalšího vlákna:------------------------------------------- */
		Runnable r = new Runnable() {
			public void run() {
				int result = i1 + i2;
				System.out.println(result);
				if (result>100) {
					try {
						throw new MyException("je toho moc");
					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(1000);
				/* Throwable - nepoužívat odchytne úplně vše !! */
				}catch (NullPointerException e){  
					
					
				} catch (Exception e){  /* Throwable - nepoužívat odchytne úplně vše !! */
					
				}
				
				
			}
		};
		new Thread(r).start(); // nové pararelní vlákno které se rozjede 
	/* -------------------------------------------------------------------- */
		
		if (ab.compareAndSet(true, false))  {/*neco udelam */} else {/*smula*/};
		
		synchronized (lock) {
			Helper.i1 = i1;
			Helper.i2 = i2;	
		}
		
		return String.valueOf(Helper.i1 + Helper.i2);
	}
	
	/*final metoda nejde přetížit - nejde přepsat */
	
	
	

	
	
}
