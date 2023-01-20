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
		String w = _weatherTower.getWeather(_coordinates);
		if (w.equals("SNOW"))
			System.out.println( getIdString() + "]" + "heli snow");		
		else if (w.equals("RAIN"))
			System.out.println(getIdString() + "]" + "heli rain");		
		else if (w.equals("SUN"))
			System.out.println(getIdString() + "]" + "heli sun");		
		else if (w.equals("FOG"))
			System.out.println(getIdString() + "]" + "heli fog");
	}

	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "Helicopter"; };
	public String getIdString() { return Long.toString(_id); }

}
