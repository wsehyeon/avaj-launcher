package simulator;

public abstract class Aircraft {
	private static long _idCounter = 0;
	
	protected long _id;
	protected String _name;
	protected Coordinates _coordinates;

	protected Aircraft(String name, Coordinates coordinates){
		// System.out.println("super AirCraft construct called");
		_name = name;
		_coordinates = coordinates;
		_id = nextId();
	}

	private  long nextId(){
		// _idCounter가 마지막 id를 가지고 있을까? 아님 그냥 현재 _id에서 ++하면 되는걸까?
		return ++_idCounter;
	}

	public static void setId(int num){ _idCounter = num; }

	public String getName(){ return _name; }
	public abstract String getType();
}
