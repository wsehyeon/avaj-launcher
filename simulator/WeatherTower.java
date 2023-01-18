package simulator;

public class WeatherTower extends Tower {
	public WeatherTower(){
		super();
		System.out.println("Weather tower construct");
	}

	@Override
		public void register(Flyable flyable){
			System.out.println("Tower says: "+ flyable.getType() + "#" + flyable.getName() + "(" + flyable.getIdString() + ") registered to weather-tower.");
		getObs().add(flyable);
		flyable.registerTower(this);
	}

	// public String getWeather(Coordinates coordinates){
		
	// }

	void changeWeather(){
		conditionChanged();
	}
}
