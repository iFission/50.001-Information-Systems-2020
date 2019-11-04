//**SEE BELOW** modify AirPollutionAlert 

//YOU DO NOT NEED TO MODIFY THIS PART OF THE CODE -------
interface Observer {
	void update(double airPollutionIndex);
}

class Subscriber implements Observer {
	private Subject subject;
	private String observerId;
	public static String outputMessage = "";

	public Subscriber(String observerId, Subject subject) {
		this.subject = subject;
		this.observerId = observerId;
		this.subject.register(this); // register itself
	}

	@Override
	public void update(double airPollutionIndex) {
		String s = this.observerId + " received notification: " + airPollutionIndex;
		System.out.println(s);
		outputMessage += (s + " ");
	}
}

interface Subject {
	void register(Observer o);

	void unregister(Observer o);

	void notifyObservers();
}
//-------------------------------------------------------

//TODO: modify AirPollutionAlert to implement interface Subject, under Observer design pattern
class AirPollutionAlert implements Subject {
	private double airPollutionIndex;

	public void setAirPollutionIndex(double airPollutionIndex) {
		this.airPollutionIndex = airPollutionIndex;
	}
}
