package simulator;

import java.util.ArrayList;

// abstract? 
public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<>();

	public Tower(){};
	public void register(Flyable flyable){
		// System.out.println("tower construct");
		// Flyable.registerTower take WeatherTower type;
		// so this method can not call flyable.registerTower(this);
	};
	public void unregister(Flyable flyable){};
	public ArrayList<Flyable> getObs(){ return observers; }


	protected void conditionChanged(){
		for (Flyable o : observers)
			o.updateConitions();
	};
}
