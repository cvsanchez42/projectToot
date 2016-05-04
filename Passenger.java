public class Passenger {

  //Static Fields


  //Instance Fields
  private String name;
  private String startPoint;
  private String endPoint;
  private String atStop;
  private boolean tripDone = false;

  String getStartPoint() {
    return(startPoint);
  }

  boolean isTripDone() {
    return(tripDone);
  }

  //Constructor
  Passenger(String name, String stpt, String endpt) {
    this.name = name;
    this.startPoint = stpt;
    this.endPoint = endpt;
    this.atStop = startPoint;
  }

  //Static Methods


  //Instance Methods
  void movePassenger(String newStop) {
    atStop = newStop;
  }

  boolean atDestination() {
    if(atStop == endPoint) {
      System.out.println(name + " made it!");
      tripDone = true;
      return(true);
    }
    return(false);
  }

  public String toString() {
    String ret = "";
    ret += "Passenger Name: " + name;
    ret += "\tStart Point: " + startPoint;
    ret += "\tEnd Point: " + endPoint;
    ret += "\tAt Stop: " + atStop;
    return(ret);
  }

}
