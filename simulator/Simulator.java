package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
  int totalSimulationTime;
  Tower tower;

  // void openSinario(); √
  // void checkScenario() √;
  // void simulate();
  // void endSimulate();
  public Simulator(){
    tower = new WeatherTower();
  }

  void simulate(int totalSimulationTime){
    WeatherProvider wp = WeatherProvider.getProvider();
    
    for (int i = 0; i <totalSimulationTime; i++){
      wp.generateWeather();
      // 비행체 비행

      //tower.changeWeather(); ?? 어떻게 비행체를 동작시킬까...

    }
  }

  void checkScenario(String line){
    String arr[];
    int lot;
    int lat;
    int hei;  
  
    arr = line.split(" ");
    if (arr.length != 5){
      System.out.println("wrong number of Aircraft data");
      return ;
      //throw exception?
    }
    try{
      lot = Integer.parseInt(arr[2]);
      lat = Integer.parseInt(arr[3]);
      hei = Integer.parseInt(arr[4]);  
      // System.out.println(lot +" "+ lat +" "+ hei);
      
      // height limit is 100
      if (lot < 0 || lat < 0 || hei < 0)
      {
        //throw?
        System.out.println("wrong range coordinate");
        return ;
      }
      if (hei > 100)
        hei = 100;
      createAirCreate(arr[0], arr[1], lot, lat, hei);

    } catch(NumberFormatException e){
      System.out.println("coordinate not a number");
    }

    
    // Aircraft 생성...
    /* 
     * 예외처리의 범위..? 선택지
     * 1. type만 확인하고 그쪽 생성자에서 좌표계 예외처리하기 √
     * 2. 여기서 파일 유효성체크 전부다 하기 
     */
  }

  void openScenario(String[] args) throws IOException {
    File f = new File(args[0]);
    if (f.exists()){
      BufferedReader infile = new BufferedReader(new FileReader(f));
      String line = infile.readLine();
      try {
        totalSimulationTime = Integer.parseInt(line);   
      } catch (NumberFormatException e){
        System.out.println("NOT number format simulate time input");
        infile.close();
        return ;
      }
      while((line = infile.readLine()) != null){
        // System.out.println("****"+ line +"****");
        checkScenario(line);
      }
      infile.close();
    }
  }

  void createAirCreate(String type, String name, int lot, int lat, int hei){
    Flyable fly = AircraftFactory.newAircraft(type, name, lot, lat, hei);
    tower.register(fly);
  }
}
