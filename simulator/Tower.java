package simulator;

import java.util.ArrayList;
import java.util.Iterator;

// abstract? 
public class Tower {
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String RESET = "\u001B[0m";

	private ArrayList<Flyable> observers = new ArrayList<>();

	public Tower(){};
	public void register(Flyable flyable){
		// System.out.println("tower construct");
		// Flyable.registerTower take WeatherTower type;
		// so this method can not call flyable.registerTower(this);
	};
	public void unregister(Flyable flyable){
		if (observers.contains(flyable)){
			System.out.println(RED_BACKGROUND + "Tower says: "+ flyable.getType() + "#" + flyable.getName() + "(" + flyable.getIdString() + ") unregisted from weather-tower" + RESET);
		}
	};
	public ArrayList<Flyable> getObs(){ return observers; }


	protected void conditionChanged(){
		// System.out.println("CONDITIONCHANGED in TOWER");
		Iterator<Flyable> iter = observers.iterator();
		while(iter.hasNext()) {
			Flyable f = iter.next();
			// System.out.println(f.getIdString());
			f.updateConitions();
    	if (f.checkLanding() == true){
				unregister(f);
				iter.remove();
			}
		}
	};
}

/*
*


for (Flyable o : observers){
	o.updateConitions();
	if (o.checkLanding() == true){
		unregister(o);
	}
}


* Iterator iter = list.iterator();
while(iter.hasNext()) {
    if("melon".equals(iter.next())) {
        iter.remove();
    }
}
` 
 * 
 */
