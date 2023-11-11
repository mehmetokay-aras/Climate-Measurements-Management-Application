public class CountryMeasurement extends Measurement{
    private Temperature temperature;
    public CountryMeasurement(){
        super();
        temperature = new Temperature();
    }
    public CountryMeasurement(int year,int month){
        super(year,month);
        temperature = new Temperature(year,month);
    }
    public CountryMeasurement(CountryMeasurement countryMeasurement){
        super(countryMeasurement.getYearcode(),countryMeasurement.getMonthCode());
        temperature = countryMeasurement.getTemperature();
    }
    public Temperature getTemperature() {
        return new Temperature(temperature.getYearcode(),temperature.getMonthCode(),temperature.getCelsiusMeasurement());
    }
    public String toString(){return super.toString()+temperature.toString();}
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CountryMeasurement otherCountryMeasurement = (CountryMeasurement) obj;

        return super.equals(obj) &&
                temperature.equals(otherCountryMeasurement.temperature);
    }
}