package simulator;

import java.util.Random;

// 시뮬레이터랑 weatherProvider는 독립적인 관계 (has-a 아님!)
public class WeatherProvider {
	private static WeatherProvider _wp;
	private static String[] _weather = {"RAIN","FOG","SUN", "SNOW"};
	private int[][][] weatherArr = new int[10][10][10];
	private WeatherProvider(){};

	public static WeatherProvider getProvider(){
		if (_wp == null)
			_wp = new WeatherProvider();
		return _wp;
	}

	void generateWeather(){
		Random random = new Random(); 
		for (int h = 0; h < 10; h++){
			for (int x = 0; x < 10; x++){
				for (int y = 0; y < 10; y++){
					int randomInt = random.nextInt(4);
					weatherArr[h][x][y] = randomInt;
				}
			}
		}
	}

	// actually weather generator? -> NO
	public String getCurrentWeather(Coordinates coordinates){
		// 임시 날씨 생성(레이어 개념으로 고도에 따라 날씨가 변함)
		int hei = coordinates.getHeight() / 10;
		int	lot = coordinates.getLongitude() / 10;
		int lat = coordinates.getLatitude() / 10;
		
		// System.out.println("coordinates : " + lot + " " +lat + " " + hei);

		if(lot >= 10 || lat >= 10 || hei >= 10)
			return _weather[3]; // 돔 밖에서는 무조건 날씨가 눈 (겨울이니깐ㅎ)	
		return _weather[weatherArr[hei][lot][lat]];
		/* 날씨생성 알고리즘
		 * 	: 범위를 지정하여 블록 당 날씨를 생성
		 * 	-> 블록은 몇개? || 저장할것인가?
		 *  
		 *  - 블록의 개수 : 100개 (최대고도가 100이기 때문에 100 * 100 * 100 으로 설정하고,
		 * 								10 * 10 * 10 크기로 분할하여 날씨를 생성하겠음)
		 *  - 저장 방식 : 100짜리 int배열에 날씨 인덱스를 기록하는 방향으로 고려
		 */
	}
}
