public class EnviromentalMeasurement extends Measurement{
    private Humidity humidity;
    private Temperature temperature;
    private WindSpeed windSpeed;
    private RadiationAbsorption radiationAbsorption;
    public EnviromentalMeasurement(){
        super();
        this.humidity = new Humidity();
        this.temperature = new Temperature();
        this.windSpeed = new WindSpeed();
        this.radiationAbsorption = new RadiationAbsorption();
    }
    public String toString(){
        return super.toString()+temperature.toString()+windSpeed.toString()+radiationAbsorption.toString();
    }
}
