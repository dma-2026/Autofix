import java.util.List;

public class Main {

    public static void main(String[] args) {
        GestorTaller gestor = new GestorTaller();

        Auto toyotaAuto = new Auto("Toyota", 2022, 18000, "Yaris", true);
        Auto chevrolet = new Auto("Chevrolet", 2018, 62000, "Sail", false);
        Furgon toyotaFurgon = new Furgon("Toyota", 2020, 45000, 2.0);
        Furgon hyundai = new Furgon("Hyundai", 2023, 12000, 1.0);

        toyotaAuto.activarGarantia();

        gestor.registrar(toyotaAuto);
        gestor.registrar(chevrolet);
        gestor.registrar(toyotaFurgon);
        gestor.registrar(hyundai);

        System.out.println("\n=== BUSQUEDA POR MARCA: \"Toyota\" ===");
        mostrarDetalles(gestor.buscarPorMarca("Toyota"));

        System.out.println("\n=== LISTADO DE VEHICULOS ===");
        gestor.listarTodos();

        LecturaEntrada lector = new LecturaEntrada();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n=======     MENU     =======");
            System.out.println("\n¡Bienvenido al sistema de Autofix!");
            System.out.println("1. Listar todos los vehículos");
            System.out.println("2. Buscar por marca");
            System.out.println("3. Simular costo con descuento");
            System.out.println("4. Salir");
            opcion = lector.leerEntero("Seleccione una opción: ");

            if (opcion == 1) {
                gestor.listarTodos();
            } else if (opcion == 2) {
                String marca = lector.leerTexto("Marca a buscar: ");
                mostrarDetalles(gestor.buscarPorMarca(marca));
            } else if (opcion == 3) {
                simularDescuento(gestor, lector);
            } else if (opcion == 4) {
                System.out.println("Hasta luego.");
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarDetalles(List<Vehiculo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron vehículos.");
            return;
        }
        for (Vehiculo v : lista) {
            System.out.println(v.obtenerDetalle());
            System.out.println("---");
        }
    }

    private static void simularDescuento(GestorTaller gestor, LecturaEntrada lector) {
        String marca = lector.leerTexto("Marca a simular: ");
        List<Vehiculo> lista = gestor.buscarPorMarca(marca);
        if (lista.isEmpty()) {
            System.out.println("No se encontraron vehículos.");
            return;
        }
        boolean valido = false;
        while (!valido) {
            double descuento = lector.leerDecimal("Porcentaje de descuento (0-100): ");
            try {
                for (Vehiculo v : lista) {
                    System.out.printf("%s | Normal: $%.2f | Con %.1f%% desc: $%.2f%n",
                            v, v.calcularCostoServicio(), descuento, v.calcularCostoServicio(descuento));
                }
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intente nuevamente.");
            }
        }
    }
}