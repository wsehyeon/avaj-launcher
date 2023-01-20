package simulator;

public class JetPlane extends Aircraft implements Flyable{
	private WeatherTower _weatherTower;

	JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
		// System.out.println(GREEN + "jet construct called" + RESET);
	}

	/* implements Flyable's method */
	@Override
	public void updateConitions() {
		String w = _weatherTower.getWeather(_coordinates);
		if (w.equals("SNOW"))
			System.out.println(getIdString() + "]" +"jet snow");		
		else if (w.equals("RAIN"))
			System.out.println(getIdString() + "]" +"jet rain");		
		else if (w.equals("SUN"))
			System.out.println(getIdString() + "]" +"jet sun");		
		else if (w.equals("FOG"))
			System.out.println(getIdString() + "]" +"jet fog");
	}

	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "GetPlane"; };
	public String getIdString() { return Long.toString(_id); }
	
}
