package optimizacion;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Optimizacion extends javax.swing.JFrame {

    private int contadorEntradas;
    List<List<String>> secciones = new ArrayList<>();
    private int seccionActual = 0;

    public Optimizacion() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLeer = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea1 = new javax.swing.JTextArea();
        lblContador = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("ventana"); // NOI18N

        btnLeer.setText("Leer Archivo");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        txtArea1.setColumns(20);
        txtArea1.setRows(5);
        jScrollPane1.setViewportView(txtArea1);

        lblContador.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblContador.setText("Número de entradas:");

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Optimizacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla1);

        btnSiguiente.setText("----->");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAtras.setText("<-----");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Optimización de Triplos");

        jLabel2.setText("PCM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnLeer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContador)
                .addGap(116, 116, 116)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeer)
                    .addComponent(btnProcesar))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnAtras)
                    .addComponent(lblContador))
                .addGap(12, 12, 12)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this); // "this" representa la ventana actual

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String contenido = leerArchivoTexto(archivo);

            // Mostrar el contenido en el JTextArea
            txtArea1.setText(contenido);
            lblContador.setText("Número de entradas: " + contadorEntradas);

            // Separar el contenido en secciones
            String[] seccionesArray = contenido.split("#");
            secciones = Arrays.stream(seccionesArray)
                    .map(seccion -> Arrays.asList(seccion.trim().split("\n")))
                    .collect(Collectors.toList());

            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) tabla1.getModel();

            // Obtener la primera sección
            List<String> primeraSeccion = secciones.get(0);

            // Limpiar la tabla
            model.setRowCount(0);

            // Agregar la primera sección a la tabla
            for (String linea : primeraSeccion) {
                model.addRow(new Object[]{linea, ""}); // Agregar la línea a la tabla con una celda vacía en la columna "Optimización"
            }

            // Actualizar el modelo de la tabla
            tabla1.setModel(model);

            // Asignar el evento ActionListener al botón btnSiguiente
            btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSiguienteActionPerformed(evt);
                }
            });
        }

    }//GEN-LAST:event_btnLeerActionPerformed

    
  

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();

        // Obtener la próxima sección
        seccionActual++;
        if (seccionActual >= secciones.size()) {
            // Reiniciar al llegar a la última sección
            seccionActual = 0;
        }
        List<String> proximaSeccion = secciones.get(seccionActual);

        // Limpiar la tabla
        model.setRowCount(0);

        // Agregar la próxima sección a la tabla
        for (String linea : proximaSeccion) {
            model.addRow(new Object[]{linea, ""}); // Agregar la línea a la tabla con una celda vacía en la columna "Optimización"
        }

        // Actualizar el modelo de la tabla
        tabla1.setModel(model);


    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed

        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
        int rowCount = model.getRowCount();
        String[] triplos = new String[rowCount];
        for (int i = 0; i < rowCount; i++) {
            triplos[i] = model.getValueAt(i, 0).toString();
        }
        try {
            
           int i = 0;
        for (String triplo12 : modificarTriplos(triplos)) {
            model.setValueAt(triplo12, i, 1);

            tabla1.setModel(model);
            i++;
            // Pausa de 3 segundos
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i = 0;
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "No es posible optimizar el codigo", "Error", JOptionPane.ERROR_MESSAGE);
        }
       

        
        
        
        
        
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();

        // Obtener la sección anterior
        seccionActual--;
        if (seccionActual < 0) {
            // Reiniciar al llegar al inicio de la sección
            seccionActual = secciones.size() - 1;
        }
        List<String> seccionAnterior = secciones.get(seccionActual);

        // Limpiar la tabla
        model.setRowCount(0);

        // Agregar la sección anterior a la tabla
        for (String linea : seccionAnterior) {
            model.addRow(new Object[]{linea, ""}); // Agregar la línea a la tabla con una celda vacía en la columna "Optimización"
        }

        // Actualizar el modelo de la tabla
        tabla1.setModel(model);
    }//GEN-LAST:event_btnAtrasActionPerformed

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
//                if (triplo.charAt(1) == '=' && !triplo.matches(".*\\(\\d+\\).*")) {
//                    // El triplo es de asignación y no tiene números entre paréntesis, eliminarlo de la lista
//                    triplosModificados.remove(i);
//                    i--; // Actualizar el índice para evitar omitir el siguiente elemento
//                }
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

    private String leerArchivoTexto(File archivo) {
        StringBuilder contenido = new StringBuilder();
        contadorEntradas = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.equals("#")) {
                    contadorEntradas++;
                }
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido.toString();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Optimizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnLeer;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblContador;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextArea txtArea1;
    // End of variables declaration//GEN-END:variables
}
