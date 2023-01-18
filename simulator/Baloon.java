package simulator;

public class Baloon extends Aircraft implements Flyable{
	private WeatherTower _weatherTower;

	Baloon(String name, Coordinates coordinates){
		super(name,coordinates);
		// System.out.println(YELLOW + "baloon construct called"+ RESET);
	}

	/* implements Flyable's method */
	@Override
	public void updateConitions() {
		
	}

	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "Baloon"; };

	public String getIdString() { return Long.toString(_id); }

}
