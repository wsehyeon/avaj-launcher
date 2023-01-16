package simulator;

public abstract class Aircraft {
	private static long _idCounter;
	
	protected long _id;
	protected String _name;
	protected Coordinates _coordinates;

	protected Aircraft(String name, Coordinates coordinates){
		_name = name;
		_coordinates = coordinates;
	}

	private long nextId(){
		// _idCounter가 마지막 id를 가지고 있을까? 아님 그냥 현재 _id에서 ++하면 되는걸까?
		return ++_id;
	}
}
