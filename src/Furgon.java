import java.util.Locale;

public class Furgon extends Vehiculo {

    private double capacidadCargaToneladas;

    public Furgon(String marca, int anioFabricacion, double kilometraje,
                  double capacidadCargaToneladas) {
        super(marca, anioFabricacion, kilometraje);
        setCapacidadCargaToneladas(capacidadCargaToneladas);
    }

    public double getCapacidadCargaToneladas() {
        return capacidadCargaToneladas;
    }

    public void setCapacidadCargaToneladas(double capacidadCargaToneladas) {
        if (capacidadCargaToneladas <= 0) {
            throw new IllegalArgumentException("La capacidad de carga debe ser mayor que cero.");
        }
        this.capacidadCargaToneladas = capacidadCargaToneladas;
    }

    @Override
    public double calcularCostoServicio() {
        double costo = 35000;
        if (capacidadCargaToneladas > 1.5) {
            costo = costo * 1.25; // +25%
        }
        return costo;
    }

    @Override
    public String getTipo() {
        return "Furgon";
    }

    @Override
    public String obtenerDetalle() {
        return datosComunes()
                + String.format(Locale.US, " | Capacidad: %.1f toneladas | Costo servicio: $%.0f",
                capacidadCargaToneladas, calcularCostoServicio());
    }
}