package ObserverDesign;
import util.*;

class WeatherStation implements Obserable {
    private List<Observer> observers;
    private float temparature;
    private float humidity;
    private WeatherStation() {
        this.observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for(Observer o: observers) {
            o.update(temparature, humidity);
        }
    }
    public void setMeasurement(float temparature, float humidity) {
        this.temparature = temparature;
        this.humidity = humidity;
        notifyObservers();
    }

}