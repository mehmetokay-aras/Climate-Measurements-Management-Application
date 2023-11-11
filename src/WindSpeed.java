import java.util.Random;

public class WindSpeed extends Measurement {
    private double metersPerSecond;
    private double kmPerHour;

    private static final double MIN_VALUE = 0.0;
    private static final double MAX_VALUE = 113.2;

    public WindSpeed(int year, int month) {
        super(year, month);
        metersPerSecond = initializeWindSpeed();
        kmPerHour = convertKmPerHour();
    }

    public WindSpeed(int year, int month, double metersPerSecond) {
        super(year, month);
        if (isInRange(metersPerSecond)) {
            this.metersPerSecond = metersPerSecond;
            kmPerHour = convertKmPerHour();
        } else {
            throw new IllegalArgumentException("Measurement outside the range (" + MIN_VALUE + "-" + MAX_VALUE + ")");
        }
    }

    public WindSpeed(WindSpeed windSpeed) {
        super(windSpeed.getYear(), windSpeed.getMonthCode());
        this.metersPerSecond = windSpeed.getMetersPerSecond();
        this.kmPerHour = windSpeed.getKmPerHour();
    }

    private double initializeWindSpeed() {
        return truncateToTwoDecimals(new Random().nextDouble() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
    }

    private double convertKmPerHour() {
        return truncateToTwoDecimals(metersPerSecond * 3600 / 1000);
    }

    public double getMetersPerSecond() {
        return metersPerSecond;
    }

    public double getKmPerHour() {
        return kmPerHour;
    }

    @Override
    public String toString() {
        return super.toString() + " metersPerSecond: " + getMetersPerSecond() + " kmPerHour: " + getKmPerHour();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WindSpeed otherWindSpeed = (WindSpeed) obj;
        return super.equals(obj) &&
                Double.compare(otherWindSpeed.metersPerSecond, metersPerSecond) == 0 &&
                Double.compare(otherWindSpeed.kmPerHour, kmPerHour) == 0;
    }

    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }

    private boolean isInRange(double value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }
}