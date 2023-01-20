package simulator;

public class JetPlane extends Aircraft implements Flyable{
	public static final String RESET = "\u001B[0m";
  public static final String PURPLE = "\u001B[35m";

	private WeatherTower _weatherTower;

	JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
		// System.out.println(GREEN + "jet construct called" + RESET);
	}

	private String getCoordString(){
		return _coordinates.getLongitude() + " " + _coordinates.getLatitude() + " " + _coordinates.getHeight();
	}

	/* implements Flyable's method */
	@Override
	public void updateConitions() {
		String w = _weatherTower.getWeather(_coordinates);
		// System.out.println("[" + myInfo() + " coordinates : " + _coordinates.getLongitude() + " " + _coordinates.getLatitude() + " " + _coordinates.getHeight() + "]");
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

	private void sun(){
		System.out.println(PURPLE + myInfo() + " jetplane met sun" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 10, 2);
	}

	private void rain(){
		System.out.println(PURPLE + myInfo() + " jetplane met rain" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 5, 0);
	}
	
	private void fog(){
		System.out.println(PURPLE + myInfo() + " jetplane met fog" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 1,0);
	}

	private void snow(){
		System.out.println(PURPLE + myInfo() + " jetplane met snow" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 0, -7);
	}

	public boolean checkLanding(){
		if (super._coordinates.getHeight() <= 0){
			System.out.println(PURPLE + myInfo() + "landing...." + RESET + "[" + getCoordString() + "]");
			return true;
		}
		else
			return false;
	}


	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "GetPlane"; };
	public String getIdString() { return Long.toString(_id); }
	
}
