package simulator;

public class WeatherProvider {
	private static WeatherProvider _wp;
	private static String[] _weather = {"RAIN","FOG","SUN", "SNOW"};
	private WeatherProvider(){};

	public static WeatherProvider getProvider(){
		if (_wp == null)
			_wp = new WeatherProvider();
		return _wp;
	}



	// actually weather generator?
	// public String getCurreuntWeather(Coordinates coordinates){
		/* 날씨생성 알고리즘
		 * 	: 범위를 지정하여 블록 당 날씨를 생성
		 * 	-> 블록은 몇개? || 저장할것인가?
		 *  
		 *  - 블록의 개수 : 100개 (최대고도가 100이기 때문에 100 * 100 * 100 으로 설정하고,
		 * 								10 * 10 * 10 크기로 분할하여 날씨를 생성하겠음)
		 *  - 저장 방식 : 100짜리 int배열에 날씨 인덱스를 기록하는 방향으로 고려
		 */
	// }

}
