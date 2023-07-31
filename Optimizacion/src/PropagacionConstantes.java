
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropagacionConstantes {

    public List<String> modificarTriplos(String[] triplos) {
        Set<String> posEnLista = new HashSet<>();
        List<String> triplosModificados = new ArrayList<>();

        for (int i = 0; i < triplos.length; i++) {
            String triplo = triplos[i];
            char operador = triplo.charAt(2);
            String pos = String.valueOf(triplo.charAt(0));
            String valor = triplo.substring(triplo.lastIndexOf(",") + 1, triplo.lastIndexOf(")"));

            if (operador == '=') {
                for (int j = i + 1; j < triplos.length; j++) {
                    String triplo2 = triplos[j];

                    // Verificar si triplo2 contiene un número entre paréntesis y compararlo con pos
                    Pattern pattern = Pattern.compile("\\((\\d+)\\)");
                    Matcher matcher = pattern.matcher(triplo2);

                    if (matcher.find()) {
                        String numeroEntreParentesis = matcher.group(1);

                        if (numeroEntreParentesis.equals(pos)) {
                            // Verificar si el triplo2 tiene paréntesis alrededor del último valor
                            if (!triplo2.matches(".*\\(.*\\)$")) {
                                triplo2 = triplo2.replace("(" + numeroEntreParentesis + ")", valor);
                                triplos[j] = triplo2;

                            } else {
                                triplo2 = triplo2.replace("(" + numeroEntreParentesis + ")", valor);

                                if (posEnLista.contains(pos)) {
                                    triplos[j] = triplo2;
                                    posEnLista.add(pos);
                                } else {
                                    triplos[j] = triplo2;
                                    posEnLista.add(pos);
                                }
                            }
                        }
                    }

                    // Eliminar comas consecutivas en la salida
                    triplo2 = triplo2.replaceAll(",+", ",");
                }
            }
        }

        int cont = 1;

        for (int i = 0; i < triplos.length; i++) {
            String triplo = triplos[i];
            char operador = triplo.charAt(2);
            String valor = triplo.substring(triplo.lastIndexOf(",") + 1, triplo.lastIndexOf(")"));
            triplo = triplo.substring(1);

            if (operador == '=') {
                if (valor.matches("\\(\\d+\\)")) {
                    String triploModificado = String.valueOf(cont) + triplo;
                    int numeroEntreParentesis = Integer.parseInt(valor.substring(1, valor.length() - 1));
                    if (numeroEntreParentesis > 0) {
                        triploModificado = triploModificado.replace(valor, "(" + (numeroEntreParentesis - 1) + ")");
                    }
                    triplosModificados.add(triploModificado);
                    cont++;
                }
            } else {
                if (valor.matches("\\(\\d+\\)")) {
                    String triploModificado = String.valueOf(cont) + triplo;
                    int numeroEntreParentesis = Integer.parseInt(valor.substring(1, valor.length() - 1));
                    if (numeroEntreParentesis > 0) {
                        triploModificado = triploModificado.replace(valor, "(" + (numeroEntreParentesis - 1) + ")");
                    }
                    triplosModificados.add(triploModificado);
                    cont++;
                } else {
                    String triploModificado = String.valueOf(cont) + triplo;
                    triplosModificados.add(triploModificado);
                    cont++;
                }
            }
        }

        //folding para triplosModificados
        int auxEntero = 0; // Variable auxiliar entera para almacenar el resultado sin decimales
        double auxDecimal = 0.0; // Variable auxiliar double para almacenar el resultado con decimales
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String resultadoFormateado = "";
        for (int i = 0; i < triplosModificados.size(); i++) {
            String triplo = triplosModificados.get(i);
            char operador = triplo.charAt(2);
            String pos = String.valueOf(triplo.charAt(0));

            if ((operador == '+' || operador == '-' || operador == '*' || operador == '/') && !triplo.matches(".*\\(\\d+\\).*")) {
                // Obtener los operandos
                double operando1 = Double.parseDouble(triplo.substring(4, triplo.lastIndexOf(",")));
                double operando2 = Double.parseDouble(triplo.substring(triplo.lastIndexOf(",") + 1, triplo.lastIndexOf(")")));

                // Realizar la operación correspondiente y guardar el resultado en las variables auxiliares
                if (operador == '+') {
                    auxDecimal = operando1 + operando2;
                } else if (operador == '-') {
                    auxDecimal = operando1 - operando2;
                } else if (operador == '*') {
                    auxDecimal = operando1 * operando2;
                } else if (operador == '/') {
                    auxDecimal = operando1 / operando2;
                }

                // Verificar si el resultado tiene decimales mayores a 0
                if (Math.abs(auxDecimal % 1) >= 1e-10 && Math.abs(auxDecimal % 1 - 1) >= 1e-10) {
                    // Formatear el resultado con dos decimales

                    resultadoFormateado = decimalFormat.format(auxDecimal);
                } else {
                    // Convertir el resultado a int y usar la variable auxEntero si el decimal es igual a 0
                    auxEntero = (int) auxDecimal;
                }

                // Iterar la lista a partir de la posición actual más 1
                for (int j = i + 1; j < triplosModificados.size(); j++) {
                    String triplo2 = triplosModificados.get(j);

                    // Verificar si triplo2 contiene un número entre paréntesis igual a pos
                    if (triplo2.contains("(" + pos + ")")) {
                        // Reemplazar el número entre paréntesis por el valor correspondiente
                        if (Math.abs(auxDecimal % 1) >= 1e-10 && Math.abs(auxDecimal % 1 - 1) >= 1e-10) {
                            triplo2 = triplo2.replace("(" + pos + ")", String.valueOf(resultadoFormateado));
                        } else {
                            triplo2 = triplo2.replace("(" + pos + ")", String.valueOf(auxEntero));
                        }
                        triplosModificados.set(j, triplo2);
                    }
                    System.out.println(triplo2);
                }

            }

        }

        for (int i = 0; i < triplosModificados.size(); i++) {
            String triplo = triplosModificados.get(i);
            triplo = triplo.substring(1);
            

            // Validar si el triplo no contiene un número entre paréntesis y el operador es diferente de "="
            if (!triplo.matches(".*\\(\\d+\\).*") && triplo.charAt(1) != '=') {
                // El triplo no cumple las condiciones, eliminarlo de la lista
                triplosModificados.remove(i);
                i--; // Actualizar el índice para evitar omitir el siguiente elemento
            } else {
                if (triplo.charAt(1) == '=' && !triplo.matches(".*\\(\\d+\\).*")) {
                    // El triplo es de asignación y no tiene números entre paréntesis, eliminarlo de la lista
                    triplosModificados.remove(i);
                    i--; // Actualizar el índice para evitar omitir el siguiente elemento
                }
            }
        }
        System.out.println("'''''''''''''''''''''");

        int c = 1;
        for (int i = 0; i < triplosModificados.size(); i++) {
            String triplo = triplosModificados.get(i);
            System.out.println(triplo);
            triplo = triplo.substring(1);
            triplo = c + triplo; // Cambiar la posición por c
            triplosModificados.set(i, triplo); // Actualizar el triplo en la lista
                           

            c++;
        }
        c = 0;
        return triplosModificados;
    }

    public static void main(String[] args) {
        String[] triplos = {
            "1(=,ID3,5)",
            "2(-,(1),2)",
            "3(*,12,(2))",
            "4(/,35,(2))",
            "5(=,ID4,(2))"

        };
        PropagacionConstantes obj = new PropagacionConstantes();
        List<String> triplosModificados = obj.modificarTriplos(triplos);

        for (int i = 0; i < triplosModificados.size(); i++) {
            String triploModificado = triplosModificados.get(i);
            System.out.println(triploModificado);
        }

    }
}
