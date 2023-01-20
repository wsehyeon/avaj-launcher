package simulator;

public class Helicopter extends Aircraft implements Flyable{
	public static final String RESET = "\u001B[0m";
	public static final String BLUE = "\u001B[34m";

	private WeatherTower _weatherTower;

	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
		// System.out.println( BLUE + "heli construct called"+ RESET);
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

	private String getCoordString(){
		return _coordinates.getLongitude() + " " + _coordinates.getLatitude() + " " + _coordinates.getHeight();
	}

	private void sun(){
		System.out.println(BLUE + myInfo() + " heli met sun" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(10, 0, 2);
	}

	private void rain(){
		System.out.println(BLUE + myInfo() + " heli met rain" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(5, 0, 0);
	}
	
	private void fog(){
		System.out.println(BLUE + myInfo() + " heli met fog" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(1, 0,0);
	}

	private void snow(){
		System.out.println(BLUE + myInfo() + " heli met snow" + RESET + "[" + getCoordString() + "]");
		super._coordinates.updateCoordinate(0, 0, -12);
	}

	public boolean checkLanding(){
		if (super._coordinates.getHeight() <= 0){
			System.out.println(BLUE + myInfo() + "landing...." + RESET + "[" + getCoordString() + "]");
			return true;
		}
		else
			return false;
	}


	@Override
	public void registerTower(WeatherTower weathertower) {
		_weatherTower = weathertower;
	}
	
	public String getType(){ return "Helicopter"; };
	public String getIdString() { return Long.toString(_id); }

}
