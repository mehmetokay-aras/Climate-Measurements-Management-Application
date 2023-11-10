import java.util.Random;

public class WindSpeed {
    private double metersPerSecond;  // Wind speed in meters per second
    private double kmPerHour;         // Wind speed in kilometers per hour
    private final double MAX_VALUE = 113.2;  // Maximum allowed wind speed in meters per second
    private final double MIN_VALUE = 0.0;    // Minimum allowed wind speed in meters per second

    // Default constructor that initializes wind speed randomly
    public WindSpeed() {
        metersPerSecond = initializeWindSpeed();
        kmPerHour = convertKmPerHour();
    }

    // Constructor that sets wind speed with validation
    public WindSpeed(double metersPerSecond) {
        // Check if the given wind speed is within the allowed range
        if (isInRange(metersPerSecond)) {
            this.metersPerSecond = metersPerSecond;
            kmPerHour = convertKmPerHour();
        } else {
            // Throw an exception if the measurement is outside the allowed range
            throw new IllegalArgumentException("Measurement outside the range (" + MIN_VALUE + "-" + MAX_VALUE + ")");
        }
    }

    // Copy constructor that creates a copy of another WindSpeed object
    public WindSpeed(WindSpeed windSpeed) {
        metersPerSecond = windSpeed.getMetersPerSecond();
        kmPerHour = windSpeed.getKmPerHour();
    }

    // Generate a random wind speed within the specified range
    private double initializeWindSpeed() {
        return truncateToTwoDecimals(new Random().nextDouble() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
    }

    // Convert wind speed from meters per second to kilometers per hour
    private double convertKmPerHour() {
        return truncateToTwoDecimals(metersPerSecond * 3600 / 1000);
    }

    // Getter method for metersPerSecond field
    public double getMetersPerSecond() {
        return metersPerSecond;
    }

    // Getter method for kmPerHour field
    public double getKmPerHour() {
        return kmPerHour;
    }

    // Return a string representation of the WindSpeed object
    public String toString() {
        return "metersPerSecond:" + getMetersPerSecond() + " kmPerHour:" + getKmPerHour();
    }

    // Helper method to truncate a double value to two decimal places
    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }

    // Helper method to check if a given value is within the allowed range
    private boolean isInRange(double value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }

    // Override the equals method to compare WindSpeed objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        WindSpeed otherWindSpeed = (WindSpeed) obj;

        // Compare each field for equality
        return Double.compare(otherWindSpeed.metersPerSecond, metersPerSecond) == 0 &&
                Double.compare(otherWindSpeed.kmPerHour, kmPerHour) == 0;
    }
}
