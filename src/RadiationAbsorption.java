import java.util.Random;

public class RadiationAbsorption extends Measurement {
    private final double unitAbsorptionValue;
    private RadiationIntensity radiationIntensity;

    private static final double MAX_VALUE = 20.0;
    private static final double MIN_VALUE = 5.0;
    public RadiationAbsorption(){
        super();
        unitAbsorptionValue = initializeUnitAbsorptionValue();
        radiationIntensity = getRandomRadiationIntensity();
    }

    public RadiationAbsorption(int year, int month) {
        super(year, month);
        unitAbsorptionValue = initializeUnitAbsorptionValue();
        radiationIntensity = getRandomRadiationIntensity();
    }

    public RadiationAbsorption(int year, int month, double unitAbsorptionValue) {
        super(year, month);
        if (isInRange(unitAbsorptionValue)) {
            this.unitAbsorptionValue = unitAbsorptionValue;
            radiationIntensity = getRandomRadiationIntensity();
        } else {
            throw new IllegalArgumentException("Measurement outside the range (" + MIN_VALUE + "-" + MAX_VALUE + ")");
        }
    }

    public RadiationAbsorption(RadiationAbsorption radiationAbsorption) {
        super(radiationAbsorption.getYear(), radiationAbsorption.getMonthCode());
        this.unitAbsorptionValue = radiationAbsorption.getUnitAbsorptionValue();
        this.radiationIntensity = radiationAbsorption.getIntensity();
    }

    private double initializeUnitAbsorptionValue() {
        return truncateToTwoDecimals(new Random().nextDouble() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
    }

    public double getUnitAbsorptionValue() {
        return unitAbsorptionValue;
    }

    public RadiationIntensity getIntensity() {
        return radiationIntensity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RadiationAbsorption other = (RadiationAbsorption) obj;
        return super.equals(obj) &&
                Double.compare(other.unitAbsorptionValue, unitAbsorptionValue) == 0 &&
                radiationIntensity == other.radiationIntensity;
    }

    @Override
    public String toString() {
        return " Radiation Intensity: " + getIntensity() + " Unit Absorption: " + getUnitAbsorptionValue();
    }

    private static double truncateToTwoDecimals(double value) {
        return Math.floor(value * 100) / 100;
    }

    private boolean isInRange(double value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }

    private enum RadiationIntensity {
        LOW, MEDIUM, HIGH
    }

    private RadiationIntensity getRandomRadiationIntensity() {
        RadiationIntensity[] values = RadiationIntensity.values();
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex];
    }
}
