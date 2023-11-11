public class CityMeasurement extends Measurement{
    private Humidity humidity;
    private Temperature temperature;
    private WindSpeed windSpeed;
    private RadiationAbsorption radiationAbsorption;
    public CityMeasurement(){
        super();
        this.humidity = new Humidity();
        this.temperature = new Temperature();
        this.windSpeed = new WindSpeed();
        this.radiationAbsorption = new RadiationAbsorption();}
    public CityMeasurement(int year,int month){
        super(year,month);
        this.temperature = new Temperature(year,month);
        this.humidity = new Humidity(year,month);
        this.windSpeed = new WindSpeed(year,month);
        this.radiationAbsorption = new RadiationAbsorption(year,month);}
    public CityMeasurement(CityMeasurement cityMeasurement){
        super(cityMeasurement.getYearcode(),cityMeasurement.getMonthCode());
        this.windSpeed = cityMeasurement.getWindSpeed();
        this.humidity = cityMeasurement.getHumidity();
        this.radiationAbsorption = cityMeasurement.getRadiationAbsorption();
        this.temperature = cityMeasurement.getTemperature();
    }
    public String toString(){
        return super.toString()+temperature.toString()+windSpeed.toString()+radiationAbsorption.toString();
        }
    public Humidity getHumidity(){
        Humidity temp = new Humidity(humidity.getYearcode(),humidity.getMonthCode(), humidity.getHumidity());
        return temp;
    }
    public Temperature getTemperature(){
        Temperature temp = new Temperature(temperature.getYearcode(),temperature.getMonthCode(), temperature.getCelsiusMeasurement());
        return temp;
    }
    public WindSpeed getWindSpeed(){
        WindSpeed temp = new WindSpeed(windSpeed.getYearcode(),windSpeed.getMonthCode(),windSpeed.getMetersPerSecond());
        return temp;
    }
    public RadiationAbsorption getRadiationAbsorption(){
        RadiationAbsorption temp = new RadiationAbsorption(radiationAbsorption.getYearcode(),radiationAbsorption.getMonthCode(),radiationAbsorption.getUnitAbsorptionValue(),radiationAbsorption.getIntensity());
        return temp;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CityMeasurement otherCityMeasurement = (CityMeasurement) obj;

        return super.equals(obj) &&
                humidity.equals(otherCityMeasurement.humidity) &&
                temperature.equals(otherCityMeasurement.temperature) &&
                windSpeed.equals(otherCityMeasurement.windSpeed) &&
                radiationAbsorption.equals(otherCityMeasurement.radiationAbsorption);
    }
}

