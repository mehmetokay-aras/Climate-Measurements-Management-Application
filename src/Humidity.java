import java.util.Random;

public class Humidity extends Measurement {
    private double humidity;

    private static final double MIN_VALUE = 0.0;
    private static final double MAX_VALUE = 100.0;
    public Humidity(){
        super();
        humidity=initializeHumidity();
    }

    public Humidity(int year, int month) {
        super(year, month);
        humidity = initializeHumidity();
    }

    public Humidity(int year, int month, double humidity) {
        super(year, month);
        if (isInRange(humidity)) {
            this.humidity = humidity;
        } else {
            throw new IllegalArgumentException("Measurement outside the range (" + MIN_VALUE + "-" + MAX_VALUE + ")");
        }
    }

    public Humidity(Humidity humidity) {
        super(humidity.getYear(), humidity.getMonthCode());
        this.humidity = humidity.getHumidity();
    }

    private double initializeHumidity() {
        return truncateToTwoDecimals(new Random().nextDouble() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
    }

    public double getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return " Humidity: " + getHumidity();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Humidity otherHumidity = (Humidity) obj;
        return super.equals(obj) && Double.compare(otherHumidity.humidity, humidity) == 0;
    }

    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }

    private boolean isInRange(double value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }
}