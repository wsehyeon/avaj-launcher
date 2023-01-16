package simulator;

public class JetPlane extends Aircraft implements Flyable{
	private WeatherTower _weatherTower;

	JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	/* implements Flyable's method */
	@Override
	public void updateConitions() {
		
	}

	@Override
	public void registerTower(WeatherTower weathertower) {

	}
	
}
