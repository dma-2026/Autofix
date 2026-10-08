import java.util.Scanner;

public class LecturaEntrada {

    private final Scanner scanner = new Scanner(System.in);

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    public int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje).trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: debe ingresar un número entero.");
            }
        }
    }
    public double leerDecimal(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(leerTexto(mensaje).trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: debe ingresar un número.");
            }
        }
    }
}