package simulator;

public class Main {
  public static void main(String[] args){

    Simulator sim = new Simulator();

    if( args.length != 1){
      System.out.println("Need scenario file");
      return;
    }
    try{
      sim.openScenario(args);
    } catch (Exception e){
      System.out.println("Exception accrued");
      return ;
    }

  }
}
