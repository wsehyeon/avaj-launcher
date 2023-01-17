package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";

  int totalSimulationTime;
  Tower tower;

  // void openSinario(); √
  // void checkScenario() √;
  // create aircraft() ???
  // void simulate();
  // void endSimulate();
  public Simulator(){
    AircraftFactory factory = new AircraftFactory();
    tower = new WeatherTower();
  }

  void checkScenario(String line){
    String arr[];
    int lot;
    int let;
    int hei;  
  
    arr = line.split(" ");
    if (arr.length != 5){
      System.out.println("wrong number of Aircraft data");
      return ;
      //throw exception?
    }
    try{
      lot = Integer.parseInt(arr[2]);
      let = Integer.parseInt(arr[3]);
      hei = Integer.parseInt(arr[4]);  
      
      // height limit is 100
      if (lot < 0 || let < 0 || (hei < 0 && hei > 100))
      {
        //throw?
        System.out.println("wrong range coordinate");
        return ;
      }

      createAirCreate(arr[0], arr[1], lot, let, hei);

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
        return ;
      }
      while((line = infile.readLine()) != null){
        System.out.println("****"+ line +"****");
        checkScenario(line);
      }
      infile.close();
    }
  }

  void createAirCreate(String type, String name, int lot, int let, int hei){
    Flyable fly = AircraftFactory.newAircraft(type, name, lot, let, hei);
    tower.register(fly);
  }
}
