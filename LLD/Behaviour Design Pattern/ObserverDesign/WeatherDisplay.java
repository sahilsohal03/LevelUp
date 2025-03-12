class WeatherDisplay implements Observer {
    private float temparature;
    private float humidity;
    @Override
    public void update(float temparature, float humidity) {
        this.temparature = temparature;
        this.humidity = humidity;
        display();
    }
    private void display() {
        System.out.println("Temparature: " + temparature + " Humidity: " + humidity);
    }
}