package simulator;

public class Coordinates {
	private int _longitude;
	private int _latitude;
	private int _height;

	Coordinates(int longitude, int latitude, int height){
		// System.out.println("Coordinate construct called");
		_longitude = longitude;
		_latitude = latitude;
		_height = height;
	}

	public int getLongitude(){ return _longitude; }
	public int getLatitude(){ return _latitude; }
	public int getHeight(){ return _height; }

	public void updateCoordinate(int a, int b, int c){
		_longitude += a;
		_latitude += b;
		_height += c;
		if (_height > 100)
			_height = 100;
	}
}