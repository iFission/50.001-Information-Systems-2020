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
        if (this.airPollutionIndex > 100) {
            notifyObservers();
        }
    }

    private java.util.ArrayList<Observer> observers = new java.util.ArrayList<Observer>();

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(airPollutionIndex);
        }
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }
}

public class TestAirPollution {
    public static void main(String[] args) {
        AirPollutionAlert singaporeAlert = new AirPollutionAlert();
        Subscriber man = new Subscriber("man", singaporeAlert);
        Subscriber simon = new Subscriber("simon", singaporeAlert);
        singaporeAlert.setAirPollutionIndex(200);
        singaporeAlert.setAirPollutionIndex(50);
        singaporeAlert.setAirPollutionIndex(120);
        singaporeAlert.unregister(man);
        singaporeAlert.setAirPollutionIndex(300);
    }
}