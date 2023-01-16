package simulator;

public class AircraftFactory {
  public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
    if (type == "Heilcoptor")
      return new Helicopter(name, new Coordinates(longitude, latitude, height));
    else if (type == "JetPlane")
      return new JetPlane(name, new Coordinates(longitude, latitude, height));
    else if (type == "Baloon")
      return new Baloon(name, new Coordinates(longitude, latitude, height));
    else
      return null;
  }
}
