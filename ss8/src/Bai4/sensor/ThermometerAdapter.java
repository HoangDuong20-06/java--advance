package Bai4.sensor;

public class ThermometerAdapter implements TemperatureSensor {
    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        double f = oldThermometer.getTemperatureFahrenheit();
        return (f - 32) * 5 / 9;
    }
}
