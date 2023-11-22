/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Connections.*;
import Entidades.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author chris
 */
public class Sistema extends javax.swing.JFrame {
    private Conexion conexion;
    private CrudManager crud;
    private DefaultTableModel modeloTabla = null;
    private DefaultTableModel modeloTablaIns = null;
    private DefaultTableModel modeloTablaSal = null;
    
    /**
     * Creates new form Sistema
     */
    public Sistema() throws SQLException {
        initComponents();
                this.setLocationRelativeTo(null);
                setResizable(false);
        
        crud = new CrudManager(conexion.getConnection());
        this.modeloTabla = (DefaultTableModel) this.JTableUser.getModel();
        this.cargarDatosEnTabla();
        this.JTableUser.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                     if (!e.getValueIsAdjusting()) {
                        int selectedRow = JTableUser.getSelectedRow();

                        if (selectedRow != -1) {
                            // Obtener los valores de la fila seleccionada
                            String valor1 = JTableUser.getValueAt(selectedRow, 0).toString();
                            String valor2 = JTableUser.getValueAt(selectedRow, 1).toString();
                            String valor3 = JTableUser.getValueAt(selectedRow, 2).toString();
                            String valor4 = JTableUser.getValueAt(selectedRow, 3).toString();
                            String valor5 = JTableUser.getValueAt(selectedRow, 4).toString();
                            String valor6 = JTableUser.getValueAt(selectedRow, 5).toString();
                            String valor7 = JTableUser.getValueAt(selectedRow, 6).toString();

                            // Actualizar los 7 TextFields
                            idEmpleadoField.setText(valor1);
                            nombreEmpleadoField.setText(valor2);
                            cargoEmpleadoField.setText(valor3);
                            emailEmpleadoField.setText(valor4);
                            nombreUsuarioField.setText(valor5);
                            passwordUsuarioField.setText(valor6);
                            registroUsuarioField.setText(valor7);
                        }
                    }
                }
                
            }
        );
        
        this.modeloTablaIns = (DefaultTableModel) this.JTableInsumo.getModel();
        this.cargarInsumos();
        
        this.modeloTablaSal = (DefaultTableModel) this.JTableSalida.getModel();
        this.cargarSalidas();
        this.JTableSalida.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                     if (!e.getValueIsAdjusting()) {
                        int selectedRow = JTableSalida.getSelectedRow();

                        if (selectedRow != -1) {
                            // Obtener los valores de la fila seleccionada
                            String valor1 = JTableSalida.getValueAt(selectedRow, 1).toString();
                            String valor2 = JTableSalida.getValueAt(selectedRow, 2).toString();

                            // Actualizar los 7 TextFields
                            upIdInsumoField.setText(valor1);
                            upCantInsumoField.setText(valor2);
                        }
                    }
                }
                
            }
        );
        
        rsscalelabel.RSScaleLabel.setScaleLabel(IMGP1,"src\\Imagenes\\IMG1.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(IMGLO,"src\\Imagenes\\IMGLO1.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(IMGHA1,"src\\Imagenes\\IMGHA.png");
    }
    
    public Sistema(Conexion conn) throws SQLException {
        initComponents();
                this.setLocationRelativeTo(null);
                setResizable(false);
        
        this.conexion = conn;
        crud = new CrudManager(conexion.getConnection());
        this.modeloTabla = (DefaultTableModel) this.JTableUser.getModel();
        this.cargarDatosEnTabla();
        this.JTableUser.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                     if (!e.getValueIsAdjusting()) {
                        int selectedRow = JTableUser.getSelectedRow();

                        if (selectedRow != -1) {
                            // Obtener los valores de la fila seleccionada
                            String valor1 = JTableUser.getValueAt(selectedRow, 0) != null ? JTableUser.getValueAt(selectedRow, 0).toString() : "";
                            String valor2 = JTableUser.getValueAt(selectedRow, 1) != null ? JTableUser.getValueAt(selectedRow, 1).toString() : "";
                            String valor3 = JTableUser.getValueAt(selectedRow, 2) != null ? JTableUser.getValueAt(selectedRow, 2).toString() : "";
                            String valor4 = JTableUser.getValueAt(selectedRow, 3) != null ? JTableUser.getValueAt(selectedRow, 3).toString() : "";
                            String valor5 = JTableUser.getValueAt(selectedRow, 4) != null ? JTableUser.getValueAt(selectedRow, 4).toString() : "";
                            String valor6 = JTableUser.getValueAt(selectedRow, 5) != null ? JTableUser.getValueAt(selectedRow, 5).toString() : "";
                            String valor7 = JTableUser.getValueAt(selectedRow, 6) != null ? JTableUser.getValueAt(selectedRow, 6).toString() : "";

                            // Actualizar los 7 TextFields
                            idEmpleadoField.setText(valor1);
                            nombreEmpleadoField.setText(valor2);
                            cargoEmpleadoField.setText(valor3);
                            emailEmpleadoField.setText(valor4);
                            registroUsuarioField.setText(valor5);
                            nombreUsuarioField.setText(valor6);
                            passwordUsuarioField.setText(valor7);
                        }
                    }
                }
                
            }
        );
        
        this.modeloTablaIns = (DefaultTableModel) this.JTableInsumo.getModel();
        this.cargarInsumos();
        
        this.modeloTablaSal = (DefaultTableModel) this.JTableSalida.getModel();
        this.cargarSalidas();
        this.JTableSalida.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                     if (!e.getValueIsAdjusting()) {
                        int selectedRow = JTableSalida.getSelectedRow();

                        if (selectedRow != -1) {
                            // Obtener los valores de la fila seleccionada
                            String valor1 = JTableSalida.getValueAt(selectedRow, 1).toString();
                            String valor2 = JTableSalida.getValueAt(selectedRow, 2).toString();

                            // Actualizar los 7 TextFields
                            upIdInsumoField.setText(valor1);
                            upCantInsumoField.setText(valor2);
                        }
                    }
                }
                
            }
        );
        
        rsscalelabel.RSScaleLabel.setScaleLabel(IMGP1,"src\\Imagenes\\IMG1.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(IMGLO,"src\\Imagenes\\IMGLO1.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(IMGHA1,"src\\Imagenes\\IMGHA.png");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegUser = new javax.swing.JButton();
        btnInsumo = new javax.swing.JButton();
        btnSallidaIns = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        IMGP1 = new javax.swing.JLabel();
        IMGLO = new javax.swing.JLabel();
        IMGHA1 = new javax.swing.JLabel();
        tbP_Menu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idEmpleadoField = new javax.swing.JTextField();
        nombreEmpleadoField = new javax.swing.JTextField();
        cargoEmpleadoField = new javax.swing.JTextField();
        emailEmpleadoField = new javax.swing.JTextField();
        nombreUsuarioField = new javax.swing.JTextField();
        passwordUsuarioField = new javax.swing.JTextField();
        registroUsuarioField = new javax.swing.JTextField();
        btinAgUs = new javax.swing.JButton();
        btnEliminiarUs = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableUser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        idInsumoField = new javax.swing.JTextField();
        nomInsumoField = new javax.swing.JTextField();
        cantInsumoField = new javax.swing.JTextField();
        tipoInsumoField = new javax.swing.JTextField();
        fechaIngresoInsumo = new javax.swing.JTextField();
        horaIngresoInsumo = new javax.swing.JTextField();
        regEmpleadoField = new javax.swing.JTextField();
        btnIngresarIns = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableInsumo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        upIdInsumoField = new javax.swing.JTextField();
        upCantInsumoField = new javax.swing.JTextField();
        horaSalidaInsumo = new javax.swing.JTextField();
        fechaSalidaInsumo = new javax.swing.JTextField();
        btnBorrarInsumo = new javax.swing.JButton();
        btnActualizarInsumo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableSalida = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegUser.setText("Registrar Usuario");
        btnRegUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 40));

        btnInsumo.setText("Ingresar Insumo");
        btnInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsumoActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 190, 40));

        btnSallidaIns.setText("Salida Insumo");
        btnSallidaIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSallidaInsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSallidaIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 190, 40));

        btnExit.setText("Cerrar Sesion");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 130, 30));

        IMGP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(IMGP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 550));

        IMGLO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(IMGLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 580, 140));

        IMGHA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(IMGHA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 290, 140));

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Id Empleado :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 110, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del empleado :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 50, 170, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Cargo Empleado :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 90, 130, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Email Empleado :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(430, 10, 120, 30);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Nombre del Usurio :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(420, 50, 150, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Contraseña Usuario :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(420, 86, 150, 30);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Fecha Registro");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 130, 110, 20);
        jPanel1.add(idEmpleadoField);
        idEmpleadoField.setBounds(140, 10, 270, 30);
        jPanel1.add(nombreEmpleadoField);
        nombreEmpleadoField.setBounds(170, 50, 240, 30);
        jPanel1.add(cargoEmpleadoField);
        cargoEmpleadoField.setBounds(140, 90, 270, 30);

        emailEmpleadoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailEmpleadoFieldActionPerformed(evt);
            }
        });
        jPanel1.add(emailEmpleadoField);
        emailEmpleadoField.setBounds(580, 10, 260, 30);
        jPanel1.add(nombreUsuarioField);
        nombreUsuarioField.setBounds(580, 50, 260, 30);
        jPanel1.add(passwordUsuarioField);
        passwordUsuarioField.setBounds(580, 90, 260, 30);
        jPanel1.add(registroUsuarioField);
        registroUsuarioField.setBounds(140, 130, 270, 30);

        btinAgUs.setText("Agregar");
        btinAgUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btinAgUsActionPerformed(evt);
            }
        });
        jPanel1.add(btinAgUs);
        btinAgUs.setBounds(450, 130, 110, 40);

        btnEliminiarUs.setText("Eliminar ");
        btnEliminiarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminiarUsActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminiarUs);
        btnEliminiarUs.setBounds(600, 130, 110, 40);

        JTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Empleado", "Nombre Empleado", "Cargo Empleado", "Fecha Registro", "Email Empleado", "Nombre Usuario", "Contraseña"
            }
        ));
        jScrollPane3.setViewportView(JTableUser);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(2, 172, 880, 210);

        tbP_Menu.addTab("Registrar Usuario", jPanel1);

        jPanel2.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Id Insumo :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 10, 110, 30);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Nombre Insumo :");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 50, 140, 30);

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Cantidad de Insumos :");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 90, 170, 20);

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setText("Tipo de Insumo :");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(380, 20, 140, 20);

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("Fecha Ingreso :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(390, 60, 110, 30);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setText("Hora Ingreso :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(390, 100, 120, 30);

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setText("Id Empleado :");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 130, 110, 30);
        jPanel2.add(idInsumoField);
        idInsumoField.setBounds(140, 10, 230, 30);
        jPanel2.add(nomInsumoField);
        nomInsumoField.setBounds(140, 50, 230, 30);
        jPanel2.add(cantInsumoField);
        cantInsumoField.setBounds(170, 90, 200, 30);
        jPanel2.add(tipoInsumoField);
        tipoInsumoField.setBounds(510, 20, 250, 30);
        jPanel2.add(fechaIngresoInsumo);
        fechaIngresoInsumo.setBounds(510, 60, 250, 30);
        jPanel2.add(horaIngresoInsumo);
        horaIngresoInsumo.setBounds(510, 100, 250, 30);
        jPanel2.add(regEmpleadoField);
        regEmpleadoField.setBounds(120, 130, 250, 30);

        btnIngresarIns.setText("Ingresar");
        btnIngresarIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarInsActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresarIns);
        btnIngresarIns.setBounds(780, 20, 90, 30);

        JTableInsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Insumo", "Nombre Insumo", "Cantidad Insumos", "Id Empleado", "Tipo Insumo", "Fecha Ingreso Insu", "Hora Ingreso Insu"
            }
        ));
        jScrollPane2.setViewportView(JTableInsumo);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(2, 172, 870, 200);

        tbP_Menu.addTab("Ingresar Insumo", jPanel2);

        jPanel3.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setText("Nombre Insumo:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(10, 10, 130, 30);

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setText("Cantida Insumo :");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(10, 50, 130, 30);

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel17.setText("Hora Salida :");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(0, 90, 140, 30);

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel18.setText("Fecha Salida :");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(0, 130, 140, 30);
        jPanel3.add(upIdInsumoField);
        upIdInsumoField.setBounds(130, 10, 240, 30);
        jPanel3.add(upCantInsumoField);
        upCantInsumoField.setBounds(140, 50, 230, 30);
        jPanel3.add(horaSalidaInsumo);
        horaSalidaInsumo.setBounds(100, 90, 270, 30);
        jPanel3.add(fechaSalidaInsumo);
        fechaSalidaInsumo.setBounds(100, 130, 270, 30);

        btnBorrarInsumo.setText("Borrar");
        btnBorrarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarInsumoActionPerformed(evt);
            }
        });
        jPanel3.add(btnBorrarInsumo);
        btnBorrarInsumo.setBounds(460, 20, 100, 30);

        btnActualizarInsumo.setText("Actualizar");
        btnActualizarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarInsumoActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizarInsumo);
        btnActualizarInsumo.setBounds(680, 20, 100, 30);

        JTableSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id insumo", "Nombre Insumo", "Cantidad Insumo", "Id Empleado", "Tipo Insumo", "Fecha Ingreso Insu", "Hora Ingreso Insu"
            }
        ));
        jScrollPane1.setViewportView(JTableSalida);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(2, 172, 870, 200);

        tbP_Menu.addTab("Salida Insumo", jPanel3);

        getContentPane().add(tbP_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 870, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSallidaInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSallidaInsActionPerformed
        // TODO add your handling code here:
        this.tbP_Menu.setSelectedIndex(2);
    }//GEN-LAST:event_btnSallidaInsActionPerformed

    private void emailEmpleadoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailEmpleadoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailEmpleadoFieldActionPerformed

    private void btnRegUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegUserActionPerformed
        // TODO add your handling code here:
        this.tbP_Menu.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegUserActionPerformed

    private void btnInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsumoActionPerformed
        // TODO add your handling code here:
        this.tbP_Menu.setSelectedIndex(1);
    }//GEN-LAST:event_btnInsumoActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            Login v1 = new Login();
            v1.setVisible(true);
            this.conexion.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btinAgUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btinAgUsActionPerformed
        try {
            // TODO add your handling code here:
            this.agregarEmpleado();
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.agregarUsuario();
        try {
            this.cargarDatosEnTabla();
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btinAgUsActionPerformed

    private void btnEliminiarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminiarUsActionPerformed
        // TODO add your handling code here:
        int nRow = this.JTableUser.getSelectedRow();
        
        if (nRow < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro", "Sugerencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        } 
        
        try {
            crud.deleteUsuario(this.idEmpleadoField.getText());
            this.nombreUsuarioField.setText("");
            this.passwordUsuarioField.setText("");
            this.cargarDatosEnTabla();
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminiarUsActionPerformed

    private void btnIngresarInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarInsActionPerformed
        // TODO add your handling code here:
        this.agregarInsumo();
        try {
            this.cargarInsumos();
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresarInsActionPerformed

    private void btnActualizarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarInsumoActionPerformed
        // TODO add your handling code here:
        int nRow = this.JTableSalida.getSelectedRow();
        String clave = (String) this.JTableSalida.getModel().getValueAt(nRow, 0);
        try {
            Insumo insumo = buscar(clave);
            System.out.print(insumo.getClave());
            crud.updateInsumo(insumo);
            this.cargarSalidas();
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarInsumoActionPerformed

    private void btnBorrarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarInsumoActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int nRow = this.JTableSalida.getSelectedRow();
        String clave = (String) this.JTableSalida.getModel().getValueAt(nRow, 0);
        try {
            crud.deleteInsumo(clave);
            this.cargarSalidas();
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarInsumoActionPerformed
    private void cargarSalidas() throws SQLException {
        List<Insumo> insumos = crud.getAllInsumos();
        this.modeloTablaSal.setRowCount(0);
        
        for (Insumo insumo : insumos) {
            Object[] fila = {
                insumo.getClave(),
                insumo.getNombre(),
                insumo.getCantidad(),
                insumo.getClaveEmpleado(),
                insumo.getTipo(),
                insumo.getFechaIngreso(),
                insumo.getHoraIngreso()
            };
            
            this.modeloTablaSal.addRow(fila);
        }
    }
    
    private Insumo buscar(String clave) throws SQLException {
        // Obtener la lista de insumos y ordenarla por clave
        List<Insumo> insumos = crud.getAllInsumos();
        Collections.sort(insumos, (i1, i2) -> i1.getClave().compareTo(i2.getClave()));

        // Realizar búsqueda binaria por clave // Reemplaza "clave_deseada" con la clave que estás buscando
        Insumo ins = buscarInsumoPorClave(insumos, clave);

        if (ins != null) return ins;
        return null;
    }

    // Implementación de búsqueda binaria
    private Insumo buscarInsumoPorClave(List<Insumo> insumos, String clave) {
        // Búsqueda binaria
        int inicio = 0;
        int fin = insumos.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Insumo insumoActual = insumos.get(medio);
            int comparacion = clave.compareTo(insumoActual.getClave());

            if (comparacion == 0) {
                // Se encontró el insumo con la clave buscada
                return insumoActual;
            } else if (comparacion < 0) {
                // La clave buscada está en la mitad izquierda
                fin = medio - 1;
            } else {
                // La clave buscada está en la mitad derecha
                inicio = medio + 1;
            }
        }

        // La clave no se encontró
        return null;
    }
    
    private void cargarInsumos() throws SQLException {
        List<Insumo> insumos = crud.getAllInsumos();
        this.modeloTablaIns.setRowCount(0);
        
        for (Insumo insumo : insumos) {
            Object[] fila = {
                insumo.getClave(),
                insumo.getNombre(),
                insumo.getCantidad(),
                insumo.getClaveEmpleado(),
                insumo.getTipo(),
                insumo.getFechaIngreso(),
                insumo.getHoraIngreso()
            };
            
            modeloTablaIns.addRow(fila);
        }
    }
    
    private void cargarDatosEnTabla() throws SQLException {
        // Obtener la lista de empleados desde la base de datos
        List<Empleado> empleados = crud.getAllEmpleados();
        List<Usuario> usuarios = crud.getAllUsuarios();

        // Limpiar el modelo de la tabla antes de agregar nuevos datos
        modeloTabla.setRowCount(0);

        // Agregar cada empleado como una fila en la tabla
        for (Empleado empleado : empleados) {
            Object[] fila = {
                    empleado.getClave(),
                    empleado.getNombre(),
                    empleado.getCargo(),
                    empleado.getFechaRegistro(),
                    empleado.getEmail(),
            };
            modeloTabla.addRow(fila);
        }

        // Agregar cada usuario como una fila en la tabla, al final
        for (Usuario usuario : usuarios) {
            // Obtener la última fila agregada (correspondiente al empleado)
            int ultimaFila = modeloTabla.getRowCount() - 1;

            // Asegurarse de que la fila esté dentro del rango antes de agregar los valores de usuario
            if (ultimaFila >= 0) {
                modeloTabla.setValueAt(usuario.getNombre(), ultimaFila, 5);
                modeloTabla.setValueAt(usuario.getPassword(), ultimaFila, 6);
            } else {
                // Si no hay empleados, agregar una nueva fila para el usuario
                Object[] fila = {"", "", "", "", "", usuario.getNombre(), usuario.getPassword()};
                modeloTabla.addRow(fila);
            }
        }
    }
    
    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public void agregarEmpleado() throws ParseException {
        String clave = this.idEmpleadoField.getText();
        String nombre = this.nombreEmpleadoField.getText();
        String cargo = this.cargoEmpleadoField.getText();
        // Define el formato de la cadena de fecha
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Convierte la cadena de fecha a un objeto java.sql.Date
        LocalDate localDate = LocalDate.parse(this.registroUsuarioField.getText(), format);
        
        try {
            Date fechaRegistro = Date.valueOf(localDate);
            if (!this.isValidEmail(this.emailEmpleadoField.getText())) {
             JOptionPane.showMessageDialog(null, "Error el formato de Email no es valido!");
            } else {
                Empleado empleado = new Empleado(
                        clave,
                        nombre,
                        cargo, 
                        fechaRegistro,
                        this.emailEmpleadoField.getText()
                );
                try {
                    crud.insertEmpleado(empleado);
                } catch (SQLException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception  e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
    }
    
    public void agregarUsuario() {
        String nombre = this.nombreUsuarioField.getText();
        String password = this.passwordUsuarioField.getText();
        String clave = this.idEmpleadoField.getText();
        
        Usuario usuario = new Usuario(
                nombre,
                password,
                clave
        ); 
        try {
            crud.insertUsuario(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarInsumo() {
        String clave = this.idInsumoField.getText();
        String nombre = this.nomInsumoField.getText();
        int cantidad = Integer.parseInt(this.cantInsumoField.getText());
        String tipo = this.tipoInsumoField.getText();
        
        // Define el formato de la cadena de fecha
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Convierte la cadena de fecha a un objeto java.sql.Date
        LocalDate localDate = LocalDate.parse(this.fechaIngresoInsumo.getText(), format);
        Date fechaIngreso = Date.valueOf(localDate);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Convierte la cadena de hora a un objeto java.sql.Time
        LocalTime localTime = LocalTime.parse(this.horaIngresoInsumo.getText() + ":00", formatter);
        Time horaSQL = Time.valueOf(localTime);
        
        Time horaIngreso = horaSQL;
        String claveEmpleado = this.regEmpleadoField.getText();
        
        try {
            Insumo insumo = new Insumo(
                    clave,
                    nombre,
                    cantidad,
                    tipo,
                    fechaIngreso,
                    horaIngreso,
                    claveEmpleado
            );
            crud.insertInsumo(insumo);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Sistema().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMGHA1;
    private javax.swing.JLabel IMGLO;
    private javax.swing.JLabel IMGP1;
    private javax.swing.JTable JTableInsumo;
    private javax.swing.JTable JTableSalida;
    private javax.swing.JTable JTableUser;
    private javax.swing.JButton btinAgUs;
    private javax.swing.JButton btnActualizarInsumo;
    private javax.swing.JButton btnBorrarInsumo;
    private javax.swing.JButton btnEliminiarUs;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnIngresarIns;
    private javax.swing.JButton btnInsumo;
    private javax.swing.JButton btnRegUser;
    private javax.swing.JButton btnSallidaIns;
    private javax.swing.JTextField cantInsumoField;
    private javax.swing.JTextField cargoEmpleadoField;
    private javax.swing.JTextField emailEmpleadoField;
    private javax.swing.JTextField fechaIngresoInsumo;
    private javax.swing.JTextField fechaSalidaInsumo;
    private javax.swing.JTextField horaIngresoInsumo;
    private javax.swing.JTextField horaSalidaInsumo;
    private javax.swing.JTextField idEmpleadoField;
    private javax.swing.JTextField idInsumoField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomInsumoField;
    private javax.swing.JTextField nombreEmpleadoField;
    private javax.swing.JTextField nombreUsuarioField;
    private javax.swing.JTextField passwordUsuarioField;
    private javax.swing.JTextField regEmpleadoField;
    private javax.swing.JTextField registroUsuarioField;
    private javax.swing.JTabbedPane tbP_Menu;
    private javax.swing.JTextField tipoInsumoField;
    private javax.swing.JTextField upCantInsumoField;
    private javax.swing.JTextField upIdInsumoField;
    // End of variables declaration//GEN-END:variables
}
