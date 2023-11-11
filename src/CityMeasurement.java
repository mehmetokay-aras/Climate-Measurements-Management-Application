public class CityMeasurement extends Measurement{
    private Humidity humidity;
    private Temperature temperature;
    private WindSpeed windSpeed;
    private RadiationAbsorption radiationAbsorption;
    private double feltTemperature;
    private double feltTemperatureinFahrenheit;
    private double feltTemperaturinKelvin;
    public CityMeasurement(){
        super();
        this.humidity = new Humidity();
        this.temperature = new Temperature();
        this.windSpeed = new WindSpeed();
        this.radiationAbsorption = new RadiationAbsorption();
        this.feltTemperature =initializefelttemperature();
        this.feltTemperatureinFahrenheit = convertFahrenheit();
        this.feltTemperaturinKelvin = convertKelvin();
    }
    public CityMeasurement(int year,int month){
        super(year,month);
        this.temperature = new Temperature(year,month);
        this.humidity = new Humidity(year,month);
        this.windSpeed = new WindSpeed(year,month);
        this.radiationAbsorption = new RadiationAbsorption(year,month);
        this.feltTemperature =initializefelttemperature();
        this.feltTemperatureinFahrenheit = convertFahrenheit();
        this.feltTemperaturinKelvin = convertKelvin();}
    public CityMeasurement(CityMeasurement cityMeasurement){
        super(cityMeasurement.getYearcode(),cityMeasurement.getMonthCode());
        this.windSpeed = cityMeasurement.getWindSpeed();
        this.humidity = cityMeasurement.getHumidity();
        this.radiationAbsorption = cityMeasurement.getRadiationAbsorption();
        this.temperature = cityMeasurement.getTemperature();
        this.feltTemperature =initializefelttemperature();
        this.feltTemperatureinFahrenheit = convertFahrenheit();
        this.feltTemperaturinKelvin = convertKelvin();
    }
    public String toString(){
        return super.toString()+temperature.toString()+
                windSpeed.toString()+radiationAbsorption.toString()+" felt temperature in C:"+getFeltTemperature()+
                " felt temperature in F:"+getFeltTemperatureinFahrenheit()+
                " felt temperature in K:"+getFeltTemperaturinKelvin();
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
    private double initializefelttemperature(){
        return truncateToTwoDecimals(temperature.getCelsiusMeasurement()+0.3* (humidity.getHumidity()/100)-0.7*(radiationAbsorption.getUnitAbsorptionValue()/(windSpeed.getMetersPerSecond()+10)));
    }
    private double convertFahrenheit() {
        return truncateToTwoDecimals(feltTemperature * 9 / 5 + 32);
    }
    private double convertKelvin() {
        return truncateToTwoDecimals(feltTemperature + 273);
    }

    public double getFeltTemperature() {
        return feltTemperature;
    }

    public double getFeltTemperatureinFahrenheit() {
        return feltTemperatureinFahrenheit;
    }

    public double getFeltTemperaturinKelvin() {
        return feltTemperaturinKelvin;
    }
    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }
}