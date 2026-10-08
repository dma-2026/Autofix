import java.util.Locale;

public class Auto extends Vehiculo implements Garantizable {

    private String modelo;
    private boolean garantiaFabricaVigente;
    private boolean garantiaActiva = false;

    public Auto(String marca, int anioFabricacion, double kilometraje,
                String modelo, boolean garantiaFabricaVigente) {
        super(marca, anioFabricacion, kilometraje);
        setModelo(modelo);
        setGarantiaFabricaVigente(garantiaFabricaVigente);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar nulo ni vacío.");
        }
        this.modelo = modelo;
    }

    public boolean isGarantiaFabricaVigente() {
        return garantiaFabricaVigente;
    }

    public void setGarantiaFabricaVigente(boolean garantiaFabricaVigente) {
        this.garantiaFabricaVigente = garantiaFabricaVigente;
    }

    public void setGarantiaActiva(boolean garantiaActiva) {
        this.garantiaActiva = garantiaActiva;
    }

    @Override
    public double calcularCostoServicio() {
        double costo = 25000;
        if (!garantiaFabricaVigente) {
            costo = costo * 1.30; // +30%
        }
        return costo;
    }

    @Override
    public String getTipo() {
        return "Auto";
    }

    @Override
    public String obtenerDetalle() {
        return datosComunes()
                + " | Modelo: " + modelo
                + " | Garantía vigente: " + (garantiaFabricaVigente ? "Sí" : "No")
                + "\n  Garantía activa: " + (garantiaActiva ? "Sí" : "No")
                + String.format(Locale.US, " | Costo servicio: $%.0f", calcularCostoServicio());
    }

    @Override
    public boolean tieneGarantiaActiva() {
        return garantiaActiva;
    }

    @Override
    public void activarGarantia() {
        setGarantiaActiva(true);
    }
}