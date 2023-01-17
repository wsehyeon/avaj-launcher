package simulator;

public abstract class Aircraft {
	public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";
	
	private static long _idCounter;
	
	protected long _id;
	protected String _name;
	protected Coordinates _coordinates;

	private Aircraft(){};
	protected Aircraft(String name, Coordinates coordinates){
		System.out.println("super AirCraft construct called");
		_name = name;
		_coordinates = coordinates;
	}

	private long nextId(){
		// _idCounter가 마지막 id를 가지고 있을까? 아님 그냥 현재 _id에서 ++하면 되는걸까?
		return ++_id;
	}

	public String getName(){ return _name; }
	public String getIdString() { return Long.toString(_id); }
	public abstract String getType();
}
