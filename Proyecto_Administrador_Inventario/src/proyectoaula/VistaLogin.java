package proyectoaula;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import javax.swing.*;

public class VistaLogin extends JFrame implements ActionListener {

    JTextField T, t;
    JPasswordField P, p;
    JLabel L1, L2, L3, L4, L1a, L2b;
    JButton A, B, Aa, Bb;
    JPanel PE, PA;
    Container cont = null;

    VistaLogin() {
        PE = new JPanel();
        PE.setLayout(null);
        PE.setVisible(true);
        PE.setBackground(new Color(063, 136, 143));
        PE.setSize(400, 400);

        this.setTitle("Punto de venta");
        this.setSize(400, 400);
        this.setLocation(340, 300);//posicion en el que aparecera la ventana
        // this.setLayout(null);

        L1 = new JLabel("Usuario:");
        L1.setFont(new Font("Calibri", Font.BOLD, 15));
        T = new JTextField();
        T.setFont(new Font("Monospaced", Font.BOLD, 12));
        L2 = new JLabel("Contraseña:");
        L2.setFont(new Font("Calibri", Font.BOLD, 15));
        P = new JPasswordField();
        //L3 = new JLabel("Eres nuevo?");
        A = new JButton("Entrar");
        B = new JButton("Limpiar");

        L1.setBounds(160, 40, 100, 40);
        T.setBounds(140, 80, 100, 40);
        L2.setBounds(150, 140, 100, 40);
        P.setBounds(140, 180, 100, 40);
        A.setBounds(100, 250, 80, 30);
        B.setBounds(200, 250, 80, 30);
        L4 = new JLabel("Haz click para crear Usuario Nuevo");
        L4.setBounds(100, 310, 200, 30);
        L4.setVisible(false);
        PE.add(L1);
        PE.add(T);

        PE.add(L2);
        //this.add(L3);
        PE.add(P);
        PE.add(A);
        PE.add(B);

        PA = new JPanel();
        PA.setLayout(null);
        PA.setVisible(false);
        PA.setBackground(new Color(063, 136, 143));
        PA.setSize(400, 400);
        L1a = new JLabel("Nuevo Usuario:");
        L1a.setFont(new Font("Calibri", Font.BOLD, 15));
        t = new JTextField();
        t.setFont(new Font("Monospaced", Font.BOLD, 12));
        L2b = new JLabel("Contraseña:");
        L2b.setFont(new Font("Calibri", Font.BOLD, 15));
        p = new JPasswordField();
        //L3 = new JLabel("Eres nuevo?");
        Aa = new JButton("Crear");
        Bb = new JButton("Limpiar");

        L1a.setBounds(140, 40, 100, 40);
        t.setBounds(140, 80, 100, 40);
        L2b.setBounds(150, 140, 100, 40);
        p.setBounds(140, 180, 100, 40);
        Aa.setBounds(100, 250, 80, 30);
        Bb.setBounds(200, 250, 80, 30);
        PA.add(L1a);
        PA.add(t);

        PA.add(L2b);
        //this.add(L3);
        PA.add(p);
        PA.add(Aa);
        PA.add(Bb);

        //PE.add(PA);
        // Modelo Cor=new Modelo();
        //p = Cor.validarUsuario(T.getText(), P.getText());
        int l = 0;
        Modelo Cold = new Modelo();
        Cold.conectar();
        l = Cold.ValidaNuevo(1);
        if (l == 1) {
            PA.setVisible(false);
            PE.setVisible(true);
            this.add(PE);
            this.add(PA);
            System.out.println("siiiiii");//Existe registrosout   
        } else {
            System.out.println("nooooo");//No hay registros
            L3 = new JLabel("Eres nuevo?");
            L3.setBounds(160, 290, 100, 40);
            L3.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    L3.setFont(new Font("Arial", Font.BOLD, 12));
                    System.out.println(".mouseClicked()");
                }

                @Override
                public void mousePressed(MouseEvent e) {////////////////////////////////////////////////////////////////
                    L3.setFont(new Font("Arial", Font.BOLD, 12));
                    PA.setVisible(true);
                    PE.setVisible(false);

                    System.out.println(".mousePressed()");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    L3.setFont(new Font("Arial", Font.BOLD, 12));
                    System.out.println(".mouseReleased()");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    L3.setFont(new Font("Arial", TextAttribute.UNDERLINE_ON, 12));
                    L4.setVisible(true);
                    L4.setForeground(Color.red);
                    System.out.println(".mouseEntered()");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    L3.setFont(new Font("Arial", Font.BOLD, 12));
                    System.out.println(".mouseExited()");
                }
            });
            PE.add(L3);
            PE.add(L4);
            this.add(PE);
            this.add(PA);
        }

        A.addActionListener(this);
        B.addActionListener(this);
        Aa.addActionListener(this);
        Bb.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == A) {
            int s;
            Modelo Con = new Modelo();
            Con.conectar();
            //System.out.println(Con.validarUsuario(T.getText(), P.getText()));

            s = Con.validarUsuario(T.getText(), P.getText());
            if (s == 1) {
                Vista V = new Vista();
                Modelo M = new Modelo();
                Control C = new Control(V, M);
                V.setVisible(true);
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Bienvenido " + T.getText());
                V.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Clave incorrecto");
            }
            Con.cerrar();
        } else if (e.getSource() == B) {
            T.setText("");
            P.setText("");
        } else if (e.getSource() == Bb) {
            t.setText("");
            p.setText("");
        } else if (e.getSource() == Aa) {
            int s;
            Modelo Con = new Modelo();
            Con.conectar();
            s = Con.NuevoUsuario(t.getText(), p.getText());
            if (s == 1) {
               L3.setVisible(false);
                L4.setVisible(false);
                this.add(PE);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                PA.setVisible(false);
                PE.setVisible(true);

                JOptionPane.showMessageDialog(null, "Usuario " + t.getText() + " creado satisfactoriamente ");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no creado");
            }
            Con.cerrar();
        }
    }
}
