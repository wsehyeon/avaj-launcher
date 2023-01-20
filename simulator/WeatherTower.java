package simulator;

public class WeatherTower extends Tower {
	public WeatherTower(){
		super();
		// System.out.println("Weather tower construct");
	}

	@Override
		public void register(Flyable flyable){
			System.out.println(GREEN_BACKGROUND + "Tower says: "+ flyable.getType() + "#" + flyable.getName() + "(" + flyable.getIdString() + ") registered to weather-tower." + RESET);
		getObs().add(flyable);
		flyable.registerTower(this);
	}

	public String getWeather(Coordinates coordinates){
		WeatherProvider wp = WeatherProvider.getProvider();
		return wp.getCurrentWeather(coordinates);
	}

	void changeWeather(){
		// 날씨가 바뀌었을 때만 로그메세지를 출력하기 -> 아님
		
	}
}
