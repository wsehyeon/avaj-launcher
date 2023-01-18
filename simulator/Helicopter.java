package simulator;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower _weatherTower;

	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
		// System.out.println( BLUE + "heli construct called"+ RESET);
	}

	/* implements Flyable's method */
	@Override
	public void updateConitions() {
		

		
	}

	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "Helicopter"; };
	public String getIdString() { return Long.toString(_id); }

}
