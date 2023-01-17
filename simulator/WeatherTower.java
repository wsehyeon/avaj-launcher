package simulator;

public class WeatherTower extends Tower {
  public static final String PURPLE = "\u001B[35m";
  public static final String RESET = "\u001B[0m";
	
	public WeatherTower(){
		super();
		System.out.println("Weather tower construct");
	}

	@Override
		public void register(Flyable flyable){
			System.out.println(PURPLE + "Tower says: "+ flyable.getType() + "#" + flyable.getName() + "(" + flyable.getIdString() + ") registered to weather-tower." + RESET);
		getObs().add(flyable);
		flyable.registerTower(this);
	}

	// public String getWeather(Coordinates coordinates){
		
	// }

	// void changeWeather(){

	// }
}
