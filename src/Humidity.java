import java.util.Random;

public class Humidity {
    private double humidity;  // Represents the humidity value

    private final double MAX_VALUE = 100.0;  // Maximum allowed humidity value
    private final double MIN_VALUE = 0.0;    // Minimum allowed humidity value

    // Default constructor that initializes humidity randomly
    public Humidity() {
        humidity = initializeHumidity();
    }

    // Constructor that sets humidity with validation
    public Humidity(double humidity) {
        // Check if the given humidity is within the allowed range
        if (isInRange(humidity)) {
            this.humidity = humidity;
        } else {
            // Throw an exception if the measurement is outside the allowed range
            throw new IllegalArgumentException("Measurement outside the range (" + MIN_VALUE + "-" + MAX_VALUE + ")");
        }
    }

    // Copy constructor that creates a copy of another Humidity object
    public Humidity(Humidity humidity) {
        this.humidity = humidity.getHumidity();
    }

    // Getter method for humidity field
    public double getHumidity() {
        return humidity;
    }

    // Generate a random humidity value within the specified range
    private double initializeHumidity() {
        return truncateToTwoDecimals(new Random().nextDouble() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
    }

    // Helper method to check if a given value is within the allowed range
    private boolean isInRange(double value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }

    // Helper method to truncate a double value to two decimal places
    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }

    // Return a string representation of the Humidity object
    public String toString() {
        return "Humidity:" + getHumidity();
    }

    // Override the equals method to compare Humidity objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Humidity otherHumidity = (Humidity) obj;

        // Compare the humidity values for equality
        return Double.compare(otherHumidity.humidity, humidity) == 0;
    }
}
