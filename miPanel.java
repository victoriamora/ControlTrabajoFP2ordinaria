package PaqC01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class miPanel extends JFrame{
    private JPanel MiPanel;
    private JTextField txtnumid;
    private JTextField txtpeso;
    private JTextArea txtareadescripcion;
    private JTextField txtremitente;
    private JTextField txtreceptor;
    private JRadioButton RBoton1;
    private JRadioButton RBoton2;
    private JRadioButton RBoton3;
    private JCheckBox cBoxaduana;
    private JLabel lnumid;
    private JLabel lpeso;
    private JLabel ldescripcion;
    private JLabel lremirente;
    private JLabel lreceptor;
    private JLabel lprocedencia;
    private JLabel lprioridad;
    private JButton botonapilar;
    private JButton botondesapilar;
    private JButton Botonmostrar;
    private JButton botoncuantos;
    private JTextField txtnumcol;
    private JTextField txtIDCont;
    private JTextField txtcuantos;
    private JTextArea txtAreaEstado;
    private JLabel txtEstado;
    private JPanel MiPanel2;
    private JTextField txtpais;
    private JTextField txtidpais;

    public miPanel(){
        setTitle("Trabajo");
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(MiPanel);
        Hub h=new Hub();


        botonapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // verifica que los campos de entrada de datos no estén vacíos
                if (txtnumid.getText().isEmpty() || txtpeso.getText().isEmpty() || txtareadescripcion.getText().isEmpty() ||
                        txtremitente.getText().isEmpty() || txtreceptor.getText().isEmpty() || txtpais.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son requeridos", "Alerta", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // verifica que los campos numéricos contengan valores numéricos válidos
                int id, prioridad;
                float peso;
                try {
                    id = Integer.parseInt(txtnumid.getText());
                    peso = Float.parseFloat(txtpeso.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido en los campos 'ID' y 'Peso'", "Alerta", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String descripcion = txtareadescripcion.getText();
                String empresa = txtremitente.getText();
                String recep = txtreceptor.getText();
                boolean aduana = cBoxaduana.isSelected(); // usa isSelected() en lugar de getVerifyInputWhenFocusTarget()
                String pais = txtpais.getText();

                // determina la prioridad seleccionada
                if (RBoton1.isSelected()) {
                    prioridad = 1;
                } else if (RBoton2.isSelected()) {
                    prioridad = 2;
                } else {
                    prioridad = 3;
                }

                Contenedor c = new Contenedor(id, peso, prioridad, pais, descripcion, empresa, recep);
                h.apilar(c);

                JOptionPane.showMessageDialog(null, "El contenedor se ha agregado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        botondesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                int columna=Integer.parseInt(txtIDCont.getText());
                if(h!=null) h.desapilar(columna);
                 */
                try {
                    int columna = Integer.parseInt(txtIDCont.getText());
                    if (h != null) {
                        h.desapilar(columna);
                    }
                } catch (NumberFormatException ex) {
                    // Manejar la excepción de entrada no válida aquí
                }

            }
        });
        Botonmostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(h==null) txtAreaEstado.setText("No hay contenedores");
                else txtAreaEstado.setText(h.toString());
            }
        });
        txtcuantos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (h != null) {
                    int cont = 0;
                    String pais = txtidpais.getText();
                    // Validar la entrada del usuario
                    if (pais != null && !pais.isEmpty()) {
                        // Obtener la matriz de contenedores de la estructura de datos h
                        Contenedor[][] matriz = h.getMatriz();
                        // Recorrer la matriz y contar los contenedores del país especificado
                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[i].length; j++) {
                                if (pais.equals(matriz[i][j].getPais())){ // Usar equals() en lugar de == para comparar Strings
                                    cont++;
                                }
                            }
                        }
                        // Mostrar el resultado de la búsqueda
                        if(cont>0) {
                            System.out.println("Hay " + cont + " contenedor(es) de " + pais);
                        } else {
                            System.out.println("No hay ningún contenedor de " + pais);
                        }
                    } else {
                        // Manejar la entrada nula o vacía del usuario
                    }
                }
            }

        });
    }

    public static void main(String[] args) {
        new miPanel();
    }

}
