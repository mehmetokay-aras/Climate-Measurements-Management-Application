import java.util.Random;

public class Temperature {
    // Fields to store temperature measurements in Celsius, Fahrenheit, and Kelvin
    private double celsiusMeasurement;
    private  double fahrenheitMeasurement;
    private double kelvinMeasurement;

    // Constants for the valid range of temperature measurements
    private final double MIN_VALUE = -40.0;
    private final double MAX_VALUE = 50.0;

    // Default constructor initializes temperature measurements using random values
    public Temperature() {
        celsiusMeasurement = initializeTemperature();
        fahrenheitMeasurement = convertFahrenheit();
        kelvinMeasurement = convertKelvin();
    }

    // Parameterized constructor initializes temperature measurements with a specified Celsius value
    public Temperature(double celsiusMeasurement) {
        // Check if the provided Celsius value is within the valid range
        if (isInRange(celsiusMeasurement)) {
            this.celsiusMeasurement = celsiusMeasurement;
            fahrenheitMeasurement = convertFahrenheit();
            kelvinMeasurement = convertKelvin();
        } else {
            // Throw an exception if the value is outside the valid range
            throw new IllegalArgumentException("Measurement outside the range (" + MIN_VALUE + "-" + MAX_VALUE + ")");
        }
    }

    // Copy constructor creates a new Temperature object from an existing one
    public Temperature(Temperature aTemperature) {
        celsiusMeasurement = aTemperature.getCelsiusMeasurement();
        fahrenheitMeasurement = aTemperature.getFahrenheitMeasurement();
        kelvinMeasurement = aTemperature.getKelvinMeasurement();
    }

    // Private method to initialize temperature with a random value in the valid range
    private double initializeTemperature() {
        return truncateToTwoDecimals(new Random().nextDouble() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
    }

    // Private method to convert Celsius to Fahrenheit
    private double convertFahrenheit() {
        return truncateToTwoDecimals(celsiusMeasurement * 9 / 5 + 32);
    }

    // Private method to convert Celsius to Kelvin
    private double convertKelvin() {
        return truncateToTwoDecimals(celsiusMeasurement + 273);
    }

    // Getter methods to retrieve temperature measurements
    public double getCelsiusMeasurement() {
        return celsiusMeasurement;
    }

    public double getFahrenheitMeasurement() {
        return fahrenheitMeasurement;
    }

    public double getKelvinMeasurement() {
        return kelvinMeasurement;
    }

    // Override toString method to provide a string representation of the Temperature object
    public String toString() {
        return String.format("Celsius: %.2f Fahrenheit: %.2f Kelvin: %.2f", getCelsiusMeasurement(), getFahrenheitMeasurement(), getKelvinMeasurement());
    }


    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }

    // Private method to check if a value is within the valid range
    private boolean isInRange(double value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }
    // Override the equals method to compare Temperature objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Temperature otherTemperature = (Temperature) obj;

        // Compare each field for equality
        return Double.compare(otherTemperature.celsiusMeasurement, celsiusMeasurement) == 0 &&
                Double.compare(otherTemperature.fahrenheitMeasurement, fahrenheitMeasurement) == 0 &&
                Double.compare(otherTemperature.kelvinMeasurement, kelvinMeasurement) == 0;
    }
}
