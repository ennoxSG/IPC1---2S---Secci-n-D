/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clase6.Ventanas;

import clase6.Clases.Estudiante;
import clase6.Clases.Muestra;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author esteb
 */
public class Admin extends javax.swing.JFrame {

    private ArrayList<Estudiante> estudiantes; 
    private ArrayList<Muestra> muestras; 
    private DefaultTableModel modeloTabla; 
    
    public Admin(ArrayList<Estudiante> est, ArrayList<Muestra> mst) {
        this.estudiantes = est; 
        this.muestras = mst; 
        
        initComponents();
        setLocationRelativeTo(null); 
        
        // Se define un arreglo de cadenas con los nombres de las columnas para la tabla, "Usuario" y "Rol"
        String[] columnas = {"Codigo", "NomBre", "Rol"};

        // Se crea un nuevo modelo de tabla utilizando las columnas definidas y sin filas iniciales (0 filas)
        modeloTabla = new DefaultTableModel(columnas, 0);

        // Se asigna el modelo de tabla creado a la tabla en la interfaz (tablaUsuarios)
        tablaUsuarios.setModel(modeloTabla);

        // Se llama al método cargarDatos() para llenar la tabla con los datos de los estudiantes
        cargarDatos();    
        cargarMuestras(); 
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                guardarDatos();
                System.exit(0);
            }
        }); 
        
        
        cargarAsignaciones();
        
        
        
    }
    
    
    private void cargarAsignaciones(){
        for (Estudiante est : estudiantes){
            comboEstudiante.addItem(est.getCodigo()); 
        }
        
        for (Muestra muestra : muestras) {
            if(muestra.getEstado().equals("Ingreso")){
                comboMuestra.addItem(String.valueOf(muestra.getId()));
            }
        }
        
    
    
    }
    
    
    private void guardarDatos(){
        try (FileOutputStream fileOut = new FileOutputStream("muestras.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(muestras);
            System.out.println("Datos de muestras serializados correctamente.");
        } catch (IOException i) {
            i.printStackTrace();
        }   
        
        try (FileOutputStream fileOut = new FileOutputStream("estudiantes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(estudiantes);
            System.out.println("Datos de estudiantes serializados correctamente.");
        } catch (IOException i) {
            i.printStackTrace();
        } 
    }
    
    private void cargarMuestras(){
        String[] columnas = {"ID", "NomBre","Estado", "Accion"};
        DefaultTableModel model =  new DefaultTableModel(columnas, 0);
        
        for (Muestra muestra : muestras){
            model.addRow(new Object[]{muestra.getId(), muestra.getNombre(), muestra.getEstado(), "Ver"}); 
        }
        
        tableMuestras.setModel(model);
        
        tableMuestras.getColumnModel().getColumn(3).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> new JButton(value.toString()));
        tableMuestras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int column = tableMuestras.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / tableMuestras.getRowHeight();

                // Verifica si el clic fue en la columna de los botones
                if (row < tableMuestras.getRowCount() && row >= 0 && column == 3) {
                    // Obtén el ID de la muestra seleccionada
                    int id = (int) tableMuestras.getValueAt(row, 0);
                    for (Muestra mst : muestras){
                        if(mst.getId() == id ){
                            generarHTML(id, mst.getPatron()); 
                            JOptionPane.showMessageDialog(null, "Reporte generado! ");
                            break; 
                        }
                    }
                    
                }
            }
        });
        
    
    }
    
    private void generarHTML(int codigo, int[][] patron){
        String nombreArchivo = "Muestra_" + codigo + ".html"; 
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))){
           
            writer.write("""
                         <html>
                         \t<body> 
                         \t\t<h1> Matriz de la muestra: """ + codigo + "</h1> \n" + 
"		<table border=\"1\"> "); 
            
            for (int[] fila : patron) {
                writer.write("<tr>");
                for (int valor : fila) {
                    writer.write("<td>" + valor + "</td>");
                }
                writer.write("</tr>");
            }
            
            writer.write("""
                         \t\t</table> 
                         \t</body>
                         </html>"""); 
    
        } catch (IOException e){
            e.printStackTrace();        
        }
        
    
    }
    
    
    public void cargarDatos(){
        // Se limpia el modelo de la tabla, eliminando todas las filas existentes
        modeloTabla.setRowCount(0);

        // Se recorre la lista de estudiantes
        for(Estudiante estudiante : estudiantes) {
            //Se declara la variable de rol con el valor de Admin
            String rol = ""; 
            
            //Se valida si el rol es 1 (usuario), y sino se le pasa el valor de Admin
            
            if(estudiante.getRol() == 1){
                rol = "Usuario";
            }else {
                rol = "Admin";
            }

            // Se crea un arreglo de objetos que representa una fila en la tabla, con el usuario y el rol del estudiante
            Object[] fila = {estudiante.getCodigo(),estudiante.getNombre(), rol};

            // Se añade la fila al modelo de la tabla
            modeloTabla.addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanelGrafica = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMuestras = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        comboEstudiante = new javax.swing.JComboBox<>();
        comboMuestra = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setText("Cerrar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Titulo 2"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        jButton2.setText("Crear Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar desde CSV");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGraficaLayout = new javax.swing.GroupLayout(jPanelGrafica);
        jPanelGrafica.setLayout(jPanelGraficaLayout);
        jPanelGraficaLayout.setHorizontalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelGraficaLayout.setVerticalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton4.setText("Generar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tabla Usuarios", jPanel2);

        tableMuestras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tableMuestras);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Muestras", jPanel3);

        jLabel1.setText("ASignacion de Muestras a Estudiantes");

        jButton5.setText("Asignar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("Estudiante");

        jLabel3.setText("Muestra");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboEstudiante, 0, 136, Short.MAX_VALUE)
                            .addComponent(comboMuestra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Asignacion", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //Para cerrar la sesión, cierra la ventana actual y abre la ventana de login
        Login lg = new Login(estudiantes, muestras); 
        lg.setVisible(true);
        this.dispose(); 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        //Abre ventana para añadir un nuevo estudiante, pasa los parámetros de lsita de estudiantes y modelo de tabla
        Add ad = new Add(estudiantes, modeloTabla); 
        ad.setVisible(true); 
        
        //Continua en ventana Add...
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser fl = new JFileChooser(); 
        fl.setDialogTitle("Seleccionar archivo CSV");
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo CSV", "csv"); 
        fl.setFileFilter(filter);
        
        int result = fl.showOpenDialog(null); 
        
        if (result == JFileChooser.APPROVE_OPTION ){
            File archivoSeleccionado = fl.getSelectedFile(); 
            
            try {
                BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado)); 
                String linea;
                br.readLine(); 
                
                while ((linea = br.readLine()) != null){
                    String[] valores = linea.split(","); 
                    
                    if(valores.length == 4){
                        String codigo = valores[0]; 
                        String nombre = valores[1]; 
                        String pass = valores[2]; 
                        
                        int rol = Integer.parseInt(valores[3]); 
                        
                        Estudiante estudiante = new Estudiante(codigo, nombre, pass, rol); 
                        estudiantes.add(estudiante); 
                    
                    }
                
                }
                
                cargarDatos();
            } catch (IOException e){
                e.printStackTrace(); 
            }
            
        }
        
        
        
        
     
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String codigo =  JOptionPane.showInputDialog(this, "Ingrese el codigo del usuario a eliminar: ", "Eliminar Usuario", JOptionPane.WARNING_MESSAGE); 
        boolean encontrado = false; 
        
        for (Estudiante est : estudiantes){
            if(est.getCodigo().equals(codigo)){
                estudiantes.remove(est); 
                JOptionPane.showMessageDialog(this, "Usuario eliminado");
                cargarDatos(); 
                return; 
            }
        }
        
        JOptionPane.showMessageDialog(this, "No se encontro el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        
        String codigo =  JOptionPane.showInputDialog(this, "Ingrese el codigo del usuario a actualizar: ", "Actualizar Usuario", JOptionPane.WARNING_MESSAGE); 
        
        
        for (Estudiante est : estudiantes){
            if(est.getCodigo().equals(codigo)){
                
                uptEstudiante vtn = new uptEstudiante(est, this);
                vtn.setVisible(true);
                
                
                return; 
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Crear un dataset para la gráfica de barras
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 

        // Añadir valores al dataset
        // El primer parámetro es el valor de la barra,
        // el segundo parámetro es la serie de datos (en este caso, "Valores"),
        // y el tercero es la categoría (en este caso, nombres)
        dataset.addValue(40, "Valores", "Arturo");
        dataset.addValue(30, "Valores", "Juan");
        dataset.addValue(10, "Valores", "Gabriel");
        dataset.addValue(5, "Valores", "Yo");

        // Crear el gráfico de barras utilizando el dataset
        JFreeChart chart = ChartFactory.createBarChart(
                "Gráfica de Barras", // Título del gráfico
                "Categorías",       // Etiqueta del eje X
                "Valores",          // Etiqueta del eje Y
                dataset,            // Dataset
                org.jfree.chart.plot.PlotOrientation.VERTICAL, // Orientación del gráfico (vertical)
                true,               // Incluir leyenda
                true,               // Incluir herramientas de información (tooltip)
                false               // Incluir URLs
        );  

        // Obtener el plot del gráfico
        CategoryPlot plot = chart.getCategoryPlot();

        // Obtener el renderer del plot y establecer el color de las barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(83, 131, 150)); // Establecer color de la serie (serie 0)

        // Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(200, 200)); // Establecer tamaño preferido del panel

        // Configurar el panel donde se mostrará el gráfico
        jPanelGrafica.setLayout(new BorderLayout()); // Usar BorderLayout para agregar el gráfico
        jPanelGrafica.add(chartPanel, BorderLayout.CENTER); // Añadir el panel del gráfico al centro del panel principal

        // Ajustar el tamaño de la ventana y actualizar la visualización
        pack(); 
        repaint();    

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String codigoEst = (String) comboEstudiante.getSelectedItem();
        
        Estudiante estudianteSeleccionado = null;
        
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigoEst)) {
                estudianteSeleccionado = estudiante;
                break;
            }
        }
        
        int idMuestraSeleccionada = Integer.parseInt((String) comboMuestra.getSelectedItem());
        
        Muestra muestraSeleccionada = null;
        for (Muestra muestra : muestras) {
            if (muestra.getId() == idMuestraSeleccionada) {
                muestraSeleccionada = muestra;
                
                break;
            }
        }
        
        if (estudianteSeleccionado != null && muestraSeleccionada != null) {
            estudianteSeleccionado.addMuestra(muestraSeleccionada);
            muestraSeleccionada.setEstado("En proceso"); 
            cargarMuestras(); 
            JOptionPane.showMessageDialog(this, "Muestra asignada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al asignar muestra.");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboEstudiante;
    private javax.swing.JComboBox<String> comboMuestra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelGrafica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTable tableMuestras;
    // End of variables declaration//GEN-END:variables
}
