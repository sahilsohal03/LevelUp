public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        WeatherDisplay wd = new WeatherDisplay();
        ws.addObserver(wd);
        ws.setMeasurement(10, 20);
        ws.setMeasurement(20, 30);
    }
}