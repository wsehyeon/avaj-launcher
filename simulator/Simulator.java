package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
  private int simulateTime;
  private AircraftFactory factory = new AircraftFactory();
  private Tower tower = new WeatherTower();
  // input file validate 
  private void checkFile(String str){
    String arr[] = str.split("\n");
    if (arr.length == 0)
      return;
    if (arr.length == 1)
      try{
        simulateTime = Integer.parseInt(arr[0]);
      } catch (NumberFormatException ex){
        System.out.println("input data can't convert to Integer");
      }
    else{
      arr = str.split(" ");
      createAircraft(arr);
    }
  }

  private void createAircraft(String arr[]){
    int longtitude;
    int lattitude;
    int height;
    Flyable fly;

    if (arr.length != 5) // exception?
      return;
    try{
      longtitude = Integer.parseInt(arr[2]);
      lattitude = Integer.parseInt(arr[3]);
      height = Integer.parseInt(arr[4]);
      if(longtitude < 0 || lattitude < 0) //exception?
        return ;
      if (height < 0 || height > 100) //exception
        return ;
      
      fly = factory.newAircraft(arr[0], arr[1], longtitude, lattitude, height);
      tower.register(fly);
      
    }catch (NumberFormatException ex){
      System.out.println("input data can't convert to Integer");
    }
  }

  public static void main(String[] args) throws IOException{
    if (args.length() == 1)

    if (args.length != 1)
      System.out.println("need to sinario file");
    File file = new File(args[0]);
    if(file.exists()){
      BufferedReader inFile = new BufferedReader(new FileReader(file));
      String line = null;
      while ((line = inFile.readLine()) != null){
        checkFile(line);
      }

    }
      

  }
}
