package simulator;

import java.util.ArrayList;

// abstract? 
public class Tower {
	private ArrayList<Flyable> observers;

	public void register(Flyable flyable){};
	public void unregister(Flyable flyable){};
	
	protected void conditionChanged(){
		for (Flyable o : observers)
			o.updateConitions();
	};
}
