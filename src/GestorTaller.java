import java.util.ArrayList;
import java.util.List;

public class GestorTaller {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    public void registrar(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println(vehiculo.getMarca() + " (" + vehiculo.getTipo() + ") registrado correctamente.");
    }

    public List<Vehiculo> buscarPorMarca(String criterio) {
        List<Vehiculo> encontrados = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v.getMarca().equalsIgnoreCase(criterio.trim())) {
                encontrados.add(v);
            }
        }
        return encontrados;
    }
    public void listarTodos() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }
}