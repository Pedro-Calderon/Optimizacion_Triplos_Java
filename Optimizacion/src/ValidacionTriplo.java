import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidacionTriplo {
    public static boolean validarTriplo(String cadena) {
        // Expresión regular para validar el formato del tríplo
        String regex = "^\\d\\([\\-+/*=],\\(\\d+|[I]\\d+D\\d+\\))?\\,\\(\\d+\\)\\)$";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher para hacer coincidir la cadena con el patrón
        Matcher matcher = pattern.matcher(cadena);

        // Verificar si la cadena coincide con el patrón
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Ejemplos de cadenas a validar
        String cadena1 = "4(/,1,1)";
        String cadena2 = "9(-,(2))";
        String cadena3 = "1(+,(I2D123),(-2))";
        String cadena4 = "7(*,(2))";

        // Validar las cadenas
        System.out.println("Cadena 1: " + validarTriplo(cadena1));
        System.out.println("Cadena 2: " + validarTriplo(cadena2));
        System.out.println("Cadena 3: " + validarTriplo(cadena3));
        System.out.println("Cadena 4: " + validarTriplo(cadena4));
    }
}
