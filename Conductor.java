public class Conductor {
	public static void main(String[] args) {
		String[] NWK_2_WTC = {"Newark", "Harrison", "Journal Square", "Grove Street", "Exchange Place", "World Trade Center"};
		String[] JSQ_2_33D = {"Journal Square", "Grove Street", "Newport", "Christopher St", "9th St", "14th St", "23rd St", "33rd St"};
		String[] HOB_2_WTC = {"Hoboken", "Newport", "Exchange Place", "World Trade Center"};
		String[] HOB_2_33D = {"Hoboken", "Christopher St", "9th St", "14th St", "23rd St", "33rd St"};

		PathTrainCar[] trains = Conductor.makeTrains(NWK_2_WTC, JSQ_2_33D, HOB_2_WTC, HOB_2_33D);
		Passenger[] totalPassengers = Conductor.makePassengers();

		for(int i = 0; i < 17; i++) {
			System.out.println("Loading passengers...");
			for(int j = 0; j < trains.length; j++) {
				trains[j].unloadPassengers();
				trains[j].loadPassengers(totalPassengers);
				System.out.println(trains[j]);
				System.out.println(trains[j].getPassengers());
			}
			System.out.println("Moving Train...");
			for(int k = 0; k < trains.length; k++) {
				trains[k].moveTrain();
			}
		}
	}

	static PathTrainCar[] makeTrains(String[] line1, String[] line2, String[] line3, String[] line4) {
		PathTrainCar myTrain = new PathTrainCar("PATH-1", line1);
		System.out.println(myTrain);

		PathTrainCar mySecondTrain = new PathTrainCar("PATH-2", line2);
		System.out.println(mySecondTrain);

		PathTrainCar myThirdTrain = new PathTrainCar("PATH-3", line3);
		System.out.println(myThirdTrain);

		PathTrainCar myFourthTrain = new PathTrainCar("PATH-4", line4, false);
		System.out.println(myFourthTrain);

		PathTrainCar[] ret = {myTrain, mySecondTrain, myThirdTrain, myFourthTrain};
		return(ret);
	}

	static Passenger[] makePassengers() {
		Passenger pass1 = new Passenger("Chris", "Newark", "World Trade Center");
		Passenger pass2 = new Passenger("Miguel", "Exchange Place", "World Trade Center");
		Passenger pass3 = new Passenger("Nicole", "Grove Street", "Newark");
		Passenger[] ret = {pass1, pass2, pass3};
		return(ret);
	}
}
