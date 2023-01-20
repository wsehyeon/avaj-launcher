package simulator;

public class Baloon extends Aircraft implements Flyable{
  public static final String RESET = "\u001B[0m";
  public static final String YELLOW = "\u001B[33m";

	private WeatherTower _weatherTower;

	Baloon(String name, Coordinates coordinates){
		super(name,coordinates);
		// System.out.println(YELLOW + "baloon construct called"+ RESET);
	}

	/* implements Flyable's method */
	@Override
	public void updateConitions() {
		String w = _weatherTower.getWeather(_coordinates);
		// System.out.println(YELLOW + "[" + myInfo() + " coordinates : " + _coordinates.getLongitude() + " " + _coordinates.getLatitude() + " " + _coordinates.getHeight() + "]" + RESET);
		if (w.equals("SNOW"))
			snow();
		else if (w.equals("RAIN"))
			rain();
		else if (w.equals("SUN"))
			sun();
		else if (w.equals("FOG"))
			fog();	
	}

	private String myInfo(){
		return (getType() + "#" + getName() + "(" + getIdString() + ")");
	}


	private String getCoordString(){
		return _coordinates.getLongitude() + " " + _coordinates.getLatitude() + " " + _coordinates.getHeight();
	}

	private void sun(){
		System.out.println(YELLOW + myInfo() + " baloon met sun" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(2, 0, 4);
	}

	private void rain(){
		System.out.println(YELLOW + myInfo() + " baloon met rain" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 0, -5);
	}
	
	private void fog(){
		System.out.println(YELLOW + myInfo() + " baloon met fog" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 0,-3);
	}

	private void snow(){
		System.out.println(YELLOW + myInfo() + " baloon met snow" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 0, -15);
	}

	public boolean checkLanding(){
		if (super._coordinates.getHeight() <= 0){
			System.out.println(YELLOW + myInfo() + "landing...." + RESET + "[" + getCoordString() + "]");
			return true;
		}
		else
			return false;
	}

	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "Baloon"; };

	public String getIdString() { return Long.toString(_id); }

}
