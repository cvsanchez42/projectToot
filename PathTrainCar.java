public class PathTrainCar {

  //Static Fields


  //Instance Fields
  private String trainName;
  private String curr_stopName;
  private String next_stopName;
  private String[] line;
  private int stopNumber = 0;
  private int nextStopNumber = 1;
  private int di = 1;
  private Passenger[] passengers = new Passenger[30];
  private int numOfPass = 0;

  //Constructor
  PathTrainCar(String name, String[] lineRef) {
    this.trainName = name;
    this.line = lineRef;
    this.curr_stopName = line[0];
    this.next_stopName = line[1];
  }

  PathTrainCar(String name, String[] lineRef, boolean forwards) {
    this(name, lineRef);
    this.di = forwards ? 1 : -1;
  }

  //Static Methods
  private static boolean atEndOfLine(String[] aLine, int index, int direction) {
    try {
      String abc = aLine[index + direction];
      return(false);
    } catch(ArrayIndexOutOfBoundsException e) {
      return(true);
    }
  }

  //Instance Methods
  void moveTrain() {
    stopNumber = nextStopNumber;
    if(this.atEndOfLine(line, stopNumber, di)) {
      di *= -1;
    }
    nextStopNumber += di;
    curr_stopName = line[stopNumber];
    next_stopName = line[nextStopNumber];
    for(int m = 0; m < numOfPass; m++) {
      passengers[m].movePassenger(curr_stopName);
    }
  }

  void unloadPassengers() {
    int passengersLost = 0;
    for(int x = 0; x < numOfPass; x++) {
      if(passengers[x].atDestination()) {
        passengers[x] = null;
        passengersLost++;
      }
    }
    numOfPass -= passengersLost;
    for(int y = 0; y < numOfPass; y++) {
      if(passengers[y] == null) {
        int z = y;
        while(passengers[z] == null) {
          z++;
        }
        passengers[y] = passengers[z];
        passengers[z] = null;
      }
    }
  }

  void loadPassengers(Passenger[] totalPassengers) {
    for(int n = 0; n < totalPassengers.length; n++) {
      if(curr_stopName == totalPassengers[n].getStartPoint() && !(totalPassengers[n].isTripDone())) {
        passengers[numOfPass] = totalPassengers[n];
        numOfPass++;
      }
    }
  }

  String getPassengers() {
    String ret = "";
    for(int b = 0; b < numOfPass; b++) {
      ret += passengers[b];
      ret += "\n";
    }
    return(ret);
  }

  public String toString() {
    String ret = "";
    ret += "Train Name: " + trainName;
    ret += "\tCurrent Stop: " + curr_stopName;
    ret += "\t\tNext Stop: " + next_stopName;
    ret += "\t\tDirection: " + (di > 0 ? "Forward" : "Backwards");
    ret += "\t\tNumber of Passengers: " + numOfPass;
    return(ret);
  }

}
