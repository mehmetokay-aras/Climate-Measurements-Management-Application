import java.util.Random;

public class RadiationAbsorption {
    private final double unitAbsorptionValue;
    private static final double MAX_VALUE = 20.0;
    private static final double MIN_VALUE = 5.0;
    private RadiationIntensity radiationIntensity;

    // Enumeration to represent radiation intensity levels
    private enum RadiationIntensity { LOW, MEDIUM, HIGH }

    // Default constructor
    public RadiationAbsorption() {
        unitAbsorptionValue = initializeUnitAbsorptionValue();
        radiationIntensity = getRandomRadiationIntensity();
    }

    // Parameterized constructor with a specified unit absorption value
    public RadiationAbsorption(double unitAbsorptionValue) {
        // Check if the given value is within the allowed range
        if (isInRange(unitAbsorptionValue)) {
            this.unitAbsorptionValue = unitAbsorptionValue;
            radiationIntensity = getRandomRadiationIntensity();
        } else {
            // Throw an exception if the measurement is outside the allowed range
            throw new IllegalArgumentException("Measurement outside the range (" + MIN_VALUE + "-" + MAX_VALUE + ")");
        }
    }

    // Copy constructor
    public RadiationAbsorption(RadiationAbsorption radiationAbsorption) {
        unitAbsorptionValue = radiationAbsorption.getUnitAbsorptionValue();
        radiationIntensity = radiationAbsorption.getIntensity();
    }

    // Truncate a double value to two decimal places
    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }

    // Check if a value is within the allowed range
    private boolean isInRange(double value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }

    // Initialize the unit absorption value with a random value in the allowed range
    private double initializeUnitAbsorptionValue() {
        return truncateToTwoDecimals(new Random().nextDouble() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
    }

    // Get a random radiation intensity level
    public RadiationIntensity getRandomRadiationIntensity() {
        RadiationIntensity[] values = RadiationIntensity.values();
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex];
    }

    // Get the unit absorption value
    public double getUnitAbsorptionValue() {
        return unitAbsorptionValue;
    }

    // Get the radiation intensity level
    public RadiationIntensity getIntensity() {
        return radiationIntensity;
    }

    // Override the equals method to compare objects for equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RadiationAbsorption other = (RadiationAbsorption) obj;
        return Double.compare(other.unitAbsorptionValue, unitAbsorptionValue) == 0
                && radiationIntensity == other.radiationIntensity;
    }

    // Override the toString method for a meaningful string representation
    @Override
    public String toString() {
        return "radiationIntensity: " + getIntensity() + " unitAbsorption: " + getUnitAbsorptionValue();
    }
}
