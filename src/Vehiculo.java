import java.util.Locale;

public abstract class Vehiculo {
    private String marca;
    private int anioFabricacion;
    private double kilometraje;
    public Vehiculo(String marca, int anioFabricacion, double kilometraje) {
        setMarca(marca);
        setAnioFabricacion(anioFabricacion);
        setKilometraje(kilometraje);
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        if (marca== null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacia");
        }
        this.marca = marca;
    }
    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    public int setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 1990 || anioFabricacion> 2026) {
            throw new IllegalArgumentException("El año de fabricacion debe estar entre 1990 y 2026");
        }
        this.anioFabricacion = anioFabricacion;
        return anioFabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        if (kilometraje <= 0){
            throw new IllegalArgumentException("El kilometraje debe ser mayor a 0");
        }
        this.kilometraje = kilometraje;
    }
    public abstract double calcularCostoServicio();
    public abstract String getTipo();
    public abstract String obtenerDetalle();
    public double calcularCostoServicio(double porcentajeDescuento) {
        if (porcentajeDescuento <0 || porcentajeDescuento >100){
            throw new IllegalArgumentException("El descuento debe ser entre 0% y 100%");
        }
        double costo = calcularCostoServicio();
        return costo - (costo * porcentajeDescuento /100);
    }
    protected String datosComunes(){
        return String.format(Locale.US,"tipo:%s|Marca:%s|Año:%d|Kilometraje:%.0f",
                getTipo(),marca,anioFabricacion,kilometraje);

    }
    @Override
    public String toString(){
        return "Marca: " + marca + "|Año: " + anioFabricacion;
    }
}
