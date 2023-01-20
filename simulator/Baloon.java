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
		String w = _weatherTower.getWeather(_coordinates);
		if (w.equals("SNOW"))
			System.out.println(getIdString() + "]" + "baloon snow");		
		else if (w.equals("RAIN"))
			System.out.println(getIdString() + "]" +"baloon rain");		
		else if (w.equals("SUN"))
			System.out.println(getIdString() + "]" +"baloon sun");		
		else if (w.equals("FOG"))
			System.out.println(getIdString() + "]" +"baloon fog");

	}

	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "Baloon"; };

	public String getIdString() { return Long.toString(_id); }

}
