package simulator;

public interface Flyable {
	public void updateConitions();
	
	// registerTower가 왜 인터페이스에 있어야 할까...?
	public void registerTower(WeatherTower weathertower);
	public String getType();
	public String getName();
	public String getIdString();
}

