### 해야하는 것  
[ ] 클래스 다이어그램 + - ~ # _(밑줄), 화살표 등등 설명 정리  
[ ] 옵저버, 싱글톤(√), 팩토리 패턴 정리  
[ ] BufferedReader?
[ ] `public` `static` void main(String[] args)
[ ] default access modifier
[ ] runtime Exception?

### 궁금한 것  
[ ] 싱글톤 패턴이 어디에 적용되어야 할까?
```
- 시뮬레이터 안에서 각 개체들을 호출할 때?
  WeatherTower, WeatherProvider 객체들은 여러개 존재할 이유가 있을까?
  -> WeatherProvider는 확실히 싱글톤 패턴이 적용되는게 맞음 타워는?
  -> 타워는 여러개 생성되어 좌표를 분담한다거나 하는 등의 확장이 가능해보임.
```
[ ] WT의 getWeather()와 WP의 getCurrentWeather() 존재 의의  
```
WeatherTower
  public String getWeather(Coordinates coordinates)

WeatherProvider
	public String getCurreuntWeather(Coordinates coordinates)


-> 그냥 좌표의 날씨를 가져오는건데 getCurrnetWeather는 날씨 생성,
   WeatherTower의 함수는 관측의 개념이 적용되는 걸까?


```



---
---
**참고한 자료 모아두기**  
```
https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-class-diagram/

- Visibility of Class attributes and Operations 부분

```
