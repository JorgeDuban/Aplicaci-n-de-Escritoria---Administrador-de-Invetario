package proyectoaula;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Control implements ActionListener {

    Vista v;
    Modelo m;

    Control(Vista vis, Modelo mod) {

        this.v = vis;
        this.m = mod;

        v.BNuevo.addActionListener(this);
        v.BModificar.addActionListener(this);
        v.BAjuste.addActionListener(this);
        v.BBuscar.addActionListener(this);

        v.NuevoC.addActionListener(this);
        v.ModificarC.addActionListener(this);
        v.BuscarC.addActionListener(this);
        v.EliminarC.addActionListener(this);
        v.GuardarProductoN.addActionListener(this);
        v.Usuario.addActionListener(this);
        v.BuscarMP.addActionListener(this);
        v.GuardarProductoM.addActionListener(this);
        v.BuscarA.addActionListener(this);
        v.GuardarCantidadA.addActionListener(this);
        v.Env.addActionListener(this);
        v.Bor.addActionListener(this);
        v.BuscarM.addActionListener(this);
        v.EnvM.addActionListener(this);
        v.BorM.addActionListener(this);
        v.BuscarBB.addActionListener(this);
        v.BuscarE.addActionListener(this);
        v.BuscarB.addActionListener(this);
        v.Buscar2.addActionListener(this);
        v.Elim.addActionListener(this);
        v.borrarc.addActionListener(this);
        v.borrarb.addActionListener(this);
        v.Exportar.addActionListener(this);
        v.Excel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.BNuevo) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(true);
            v.panel3.setVisible(false);
            v.panel4.setVisible(false);
            v.panel5.setVisible(false);
            v.panel6.setVisible(false);
            v.panel7.setVisible(false);
            v.panel8.setVisible(false);
            v.panel9.setVisible(false);
            v.panel10.setVisible(false);

        }
        if (e.getSource() == v.BModificar) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(true);
            v.panel4.setVisible(false);
            v.panel5.setVisible(false);
            v.panel6.setVisible(false);
            v.panel7.setVisible(false);
            v.panel8.setVisible(false);
            v.panel9.setVisible(false);
            v.panel10.setVisible(false);

        }
        if (e.getSource() == v.BAjuste) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(false);
            v.panel4.setVisible(true);
            v.panel5.setVisible(false);
            v.panel6.setVisible(false);
            v.panel7.setVisible(false);
            v.panel8.setVisible(false);
            v.panel9.setVisible(false);
            v.panel10.setVisible(false);
            Modelo m = new Modelo();
            m.conectar();
            v.GanR.setText(String.valueOf(m.Contador_Ganancia()));
            m.cerrar();

        }
        if (e.getSource() == v.BBuscar) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(false);
            v.panel4.setVisible(false);
            v.panel5.setVisible(true);
            v.panel6.setVisible(false);
            v.panel7.setVisible(false);
            v.panel8.setVisible(false);
            v.panel9.setVisible(false);
            v.panel10.setVisible(false);

        }

        if (e.getSource() == v.NuevoC) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(false);
            v.panel4.setVisible(false);
            v.panel5.setVisible(false);
            v.panel6.setVisible(true);
            v.panel7.setVisible(false);
            v.panel8.setVisible(false);
            v.panel9.setVisible(false);
            v.panel10.setVisible(false);

        }
        if (e.getSource() == v.ModificarC) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(false);
            v.panel4.setVisible(false);
            v.panel5.setVisible(false);
            v.panel6.setVisible(false);
            v.panel7.setVisible(true);
            v.panel8.setVisible(false);
            v.panel9.setVisible(false);
            v.panel10.setVisible(false);

        }
        if (e.getSource() == v.BuscarC) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(false);
            v.panel4.setVisible(false);
            v.panel5.setVisible(false);
            v.panel6.setVisible(false);
            v.panel7.setVisible(false);
            v.panel8.setVisible(true);
            v.panel9.setVisible(false);
            v.panel10.setVisible(false);

        }
        if (e.getSource() == v.EliminarC) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(false);
            v.panel4.setVisible(false);
            v.panel5.setVisible(false);
            v.panel6.setVisible(false);
            v.panel7.setVisible(false);
            v.panel8.setVisible(false);
            v.panel9.setVisible(true);
            v.panel10.setVisible(false);

        }
        if (e.getSource() == v.Usuario) {
            v.panel0.setVisible(false);
            v.panel2.setVisible(false);
            v.panel3.setVisible(false);
            v.panel4.setVisible(false);
            v.panel5.setVisible(false);
            v.panel6.setVisible(false);
            v.panel7.setVisible(false);
            v.panel8.setVisible(false);
            v.panel9.setVisible(false);
            v.panel10.setVisible(true);

        }

        if (e.getSource() == v.GuardarProductoN) {
            int s;
            Modelo Con = new Modelo();
            Con.conectar();
            int existe = Con.Valida_NProducto(Integer.parseInt(v.TCodigoN.getText()));
            if (existe == 1) {
                JOptionPane.showMessageDialog(null, "El código ya existe");
                //JOptionPane.showMessageDialog(null, "Actualización completa");
            } else {
                String x = "";
                if (v.UnidadN.isSelected() == true) {
                    x = v.UnidadN.getText();

                } else if (v.GranelN.isSelected() == true) {
                    x = v.GranelN.getText();
                } else if (v.PaqueteN.isSelected() == true) {
                    x = v.PaqueteN.getText();
                }
                s = Con.guardaProductos(v.TCodigoN.getText(), v.TDescripcionN.getText(), x, v.TPrecioCN.getText(), v.TPrecioVN.getText(), v.TPrecioMN.getText(), v.TDepartamentoN.getSelectedItem().toString(), v.TCantidadN.getSelectedItem().toString());
                if (s == 1) {
                    JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Problema al guardar");
                }
                Con.cerrar();

            }

        }
        if (e.getSource() == v.Excel) {///////////////////////////////
            Modelo Con = new Modelo();
            Con.conectar();
            Con.Escribir_en_Excel();
            Con.cerrar();
        }
        if (e.getSource() == v.Env) {///////////////////////////////
            int s;
            Modelo Con = new Modelo();
            Con.conectar();
            int existe = Con.Valida_NCliente(Integer.parseInt(v.TCe.getText()));
            if (existe == 1) {
                JOptionPane.showMessageDialog(null, "El cliente con cédula " + v.TCe.getText() + " ya existe");
            } else {
                s = Con.guardaClientes(v.TNom1.getText(), v.TNom2.getText(), v.TApe1.getText(), v.TApe2.getText(), v.TDir.getText(), v.TCe.getText(), v.TTel.getText(), v.TCor.getText(), v.TCom.getText(), v.TUl.getText(), v.TSal.getText());
                if (s == 1) {
                    JOptionPane.showMessageDialog(null, "Cliente " + v.TNom1.getText() + " creado Exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Problema al guardar");
                }
            }
            Con.cerrar();
        }
        if (e.getSource() == v.Bor) {
            v.TNom1.setText("");
            v.TNom2.setText("");
            v.TApe1.setText("");
            v.TApe2.setText("");
            v.TDir.setText("");
            v.TCe.setText("");
            v.TTel.setText("");
            v.TCor.setText("");
            v.TCom.setText("");
            v.TUl.setText("");
            v.TSal.setText("");
        }
        if (e.getSource() == v.Bor) {
            v.TNom1.setText("");
            v.TNom2.setText("");
            v.TApe1.setText("");
            v.TApe2.setText("");
            v.TDir.setText("");
            v.TCe.setText("");
            v.TTel.setText("");
            v.TCor.setText("");
            v.TCom.setText("");
            v.TUl.setText("");
            v.TSal.setText("");
        }

        if (e.getSource() == v.BuscarBB) {
            Modelo Con = new Modelo();
            Con.conectar();
            v.ResuBB.setText(Con.BuscaClientes(v.CampoBB.getText(), v.TipoBB.getSelectedIndex()));
            Con.cerrar();
        }
        if (e.getSource() == v.BuscarE) {///////////////////////////////////////////////////////////////////////
            Modelo Con = new Modelo();
            Con.conectar();
            String data[] = Con.Busca_ModiClientes(v.CampoE.getText(),
                    v.TipoE.getSelectedIndex());
            v.ResuE.setText(data[1] + "\n" + data[2] + "\n" + data[3] + "\n" + data[4] + "\n" + data[5] + "\n" + data[6]);
            v.Laux.setText(data[0]);
            Con.cerrar();
        }
        int pago;
        int ganancia;
        if (e.getSource() == v.BuscarB) {///////////////////////////////////////////////////////////////////////

            Modelo Con = new Modelo();
            Con.conectar();
            int j = Integer.parseInt(v.TCantidadB.getText());
            int k = Con.Busca_Cantidad(Integer.parseInt(v.CampoB.getText()));
            if (j > k) {
                JOptionPane.showMessageDialog(null, "La cantidad deseada no está disponible, quedan " + k + " existencias");
                Con.cerrar();
            } else {
                String data[] = Con.Busca_Modificar(v.CampoB.getText(), v.TipoB.getSelectedIndex() + 1);
                pago = (Integer.parseInt(data[5]) * Integer.parseInt(v.TCantidadB.getText()));
                ganancia = ((Integer.parseInt(data[5]) - (Integer.parseInt(data[4]))) * Integer.parseInt(v.TCantidadB.getText()));
                v.ResuB.append(data[1] + "              " + data[2] + "               " + (v.TCantidadB.getText()) + "             $" + pago + "\n");
                int y = Integer.parseInt(v.ValorR.getText());
                int re = Integer.parseInt(v.GanR.getText());
                v.ValorR.setText(String.valueOf(pago + y));
                v.GanR.setText(String.valueOf(ganancia + re));
                Con.Actualizar_Ganancia(Integer.parseInt(v.GanR.getText()));
                //??????????????????????????????????????????????????????????????????????????????????????????????????
                v.Laux.setText(data[0]);
                int in = (Integer.parseInt(data[8]) - Integer.parseInt(v.TCantidadB.getText()));
                Con.actualizaCant(Integer.parseInt(v.Laux.getText()), String.valueOf(in));
                Con.cerrar();
            }
        }

        if (e.getSource() == v.Buscar2) {////////////////////////////////////////////%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
            Modelo Con = new Modelo();
            Con.conectar();
            int j = Integer.parseInt(v.TCantidadB.getText());
            int k = Con.Busca_Cantidad(Integer.parseInt(v.CampoB.getText()));
            if (j > k) {
                JOptionPane.showMessageDialog(null, "La cantidad deseada no está disponible, quedan " + k + " existencias");
                Con.cerrar();
            } else {
                String data[] = Con.Busca_Modificar(v.CampoB.getText(), v.TipoB.getSelectedIndex() + 1);
                pago = (Integer.parseInt(data[6]) * Integer.parseInt(v.TCantidadB.getText()));
                ganancia = (Integer.parseInt(data[6]) - (Integer.parseInt(data[4]))) * Integer.parseInt(v.TCantidadB.getText());
                v.ResuB.append(data[1] + "              " + data[2] + "               " + (v.TCantidadB.getText()) + "        $" + pago + "\n");
                int y = Integer.parseInt(v.ValorR.getText());
                int re = Integer.parseInt(v.GanR.getText());
                v.ValorR.setText(String.valueOf(pago + y));
                v.GanR.setText(String.valueOf(ganancia + re));
                Con.Actualizar_Ganancia(Integer.parseInt(v.GanR.getText()));
                v.Laux.setText(data[0]);
                int in = (Integer.parseInt(data[8]) - Integer.parseInt(v.TCantidadB.getText()));
                Con.actualizaCant(Integer.parseInt(v.Laux.getText()), String.valueOf(in));
                Con.cerrar();
            }
        }
        if (e.getSource() == v.borrarc) {
            int s;
            Modelo Con = new Modelo();
            Con.conectar();
            s = Con.NuevoUsuario(v.tusuarioc.getText(), v.tclavec.getText());
            if (s == 1) {
                JOptionPane.showMessageDialog(null, "Usuario " + v.tusuarioc.getText() + " creado satisfactoriamente ");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no creado");
            }
            Con.cerrar();
        }
        if (e.getSource() == v.Elim) {
            Modelo Con = new Modelo();
            Con.conectar();

            int res = Con.BorrarCliente(Integer.parseInt(v.Laux.getText()));
            Con.cerrar();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "El cliente " + v.CampoE.getText() + " ha sido borrado");
                v.CampoE.setText("");
                v.ResuE.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar");
            }
        }
        if (e.getSource() == v.borrarb) {////////////////////********************************************************
            Modelo Con = new Modelo();
            Con.conectar();
            String encontro = Con.Busca_Usuario(v.tusuariob.getText());
            v.Laux.setText(encontro);
            JFrame frame = new JFrame();
            String code = JOptionPane.showInputDialog(
                    frame,
                    "Digite la contraseña del Usuario " + v.tusuariob.getText(),
                    "Contraseña",
                    JOptionPane.WARNING_MESSAGE
            );
            String encont = Con.Busca_Contraseña(code);

            if (code.equals(encont)) {
                //JOptionPane.showMessageDialog(null, "El Usuario " + v.tusuariob.getText() + " ha sido borrado");
                //v.tusuariob.setText("");
                int res = Con.BorrarUsuario(Integer.parseInt(v.Laux.getText()));
                Con.cerrar();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "El Usuario " + v.tusuariob.getText() + " ha sido borrado");
                    v.tusuariob.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo borrar");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Contraseña o Usuario incorrecto");
            }

        }
        if (e.getSource() == v.BuscarM) {
            Modelo conec = new Modelo();
            conec.conectar();
            String encontro[] = conec.Busca_ModiClientes(v.CampoM.getText(), v.TipoM.getSelectedIndex());
            v.Laux.setText(encontro[0]);//Lnro.setText(encontro[0]);
            v.TNom1M.setText(encontro[1]);
            v.TNom2M.setText(encontro[2]);
            v.TApe1M.setText(encontro[3]);///////////////////////////////////////////////////////////////////////////////////////////////
            v.TApe2M.setText((encontro[4]));
            v.TDirM.setText((encontro[5]));
            v.TCeM.setText((encontro[6]));
            v.TTelM.setText((encontro[7]));
            v.TCorM.setText((encontro[8]));
            v.TComM.setText((encontro[9]));
            v.TUlM.setText((encontro[10]));
            v.TSalM.setText((encontro[11]));
            conec.cerrar();
        }

        if (e.getSource() == v.BuscarMP) {
            Modelo conec = new Modelo();
            conec.conectar();
            String encontro[] = conec.Busca_Modificar(v.TCodigoM.getText(), v.Tipo1M.getSelectedIndex());
            v.Laux.setText(encontro[0]);//Lnro.setText(encontro[0]);
            v.TCodigoM.setText(encontro[1]);
            v.TDescripcionM.setText(encontro[2]);
            if (encontro[3].equals("Por Unidad")) {
                v.UnidadM.setSelected(true);
            } else if (encontro[3].equals("A Granel")) {
                v.GranelM.setSelected(true);
            } else if (encontro[3].equals("Como Paquete")) {
                v.PaqueteM.setSelected(true);
            }
            v.TPrecioCM.setText((encontro[4]));
            v.TPrecioVM.setText((encontro[5]));
            v.TPrecioMM.setText((encontro[6]));
            v.TDepartamentoM.setSelectedItem((encontro[7]));
            v.TCantidadM.setSelectedItem((encontro[8]));
            conec.cerrar();
        }
        if (e.getSource() == v.BuscarA) {///////////////////////////////////////////////////////////////////////////////////////////
            Modelo conec = new Modelo();
            conec.conectar();
            String encontro[] = conec.Busca_Modificar(v.TCodigoA.getText(), 1);
            v.Laux.setText(encontro[0]);//Lnro.setText(encontro[0]);
            v.TDescripcionA.setText(encontro[2]);
            v.TCantidadActualA.setText((encontro[8]));
            conec.cerrar();
        }
        if (e.getSource() == v.GuardarCantidadA) {////////////////////////////////////////////////////////////////////
            Modelo conec = new Modelo();
            conec.conectar();

            int re = conec.actualizaCant(Integer.parseInt(v.Laux.getText()), v.TCantidadNuevaA.getSelectedItem().toString());
            if (re == 1) {
                JOptionPane.showMessageDialog(null, "Actualización completa");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el cambio");
            }
        }
        if (e.getSource() == v.GuardarProductoM) {
            Modelo conec = new Modelo();
            conec.conectar();
            String x = "";
            if (v.UnidadM.isSelected() == true) {
                x = v.UnidadM.getText();

            } else if (v.GranelM.isSelected() == true) {
                x = v.GranelM.getText();
            } else if (v.PaqueteM.isSelected() == true) {
                x = v.PaqueteM.getText();
            }
            int re = conec.actualizaDatos(Integer.parseInt(v.Laux.getText()), v.TCodigoM.getText(),
                    v.TDescripcionM.getText(), x, v.TPrecioCM.getText(), v.TPrecioVM.getText(), v.TPrecioMM.getText(), v.TDepartamentoM.getSelectedItem().toString(), v.TCantidadM.getSelectedItem().toString());
            if (re == 1) {
                JOptionPane.showMessageDialog(null, "Actualización completa");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el cambio");
            }
        }
        if (e.getSource() == v.EnvM) {
            Modelo conec = new Modelo();
            conec.conectar();
            int re = conec.actualizaDatoClie(Integer.parseInt(v.Laux.getText()), v.TNom1M.getText(),
                    v.TNom2M.getText(), v.TApe1M.getText(), v.TApe2M.getText(), v.TDirM.getText(), v.TCeM.getText(), v.TTelM.getText(), v.TCorM.getText(), v.TComM.getText(), v.TUlM.getText(), v.TSalM.getText());
            if (re == 1) {
                JOptionPane.showMessageDialog(null, "Actualización de cliente " + v.TNom1M.getText() + " completo");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el cambio");
            }
        }
        if (e.getSource() == v.Exportar) {//////////////////////////////////////////////////////////////////////
            Modelo con = new Modelo();
            con.conectar();
            JFrame frame = new JFrame();
            String cliente = JOptionPane.showInputDialog(
                    frame,
                    "Digite cédula del cliente ",
                    "Cliente",
                    JOptionPane.WARNING_MESSAGE
            );
            int promo=con.Valida_NCliente(Integer.parseInt(cliente));
            if (promo==1) {
                String[] encontro = con.Busca_ModiClientes(cliente, 3);
            v.Laux.setText(encontro[0]);
            int tr = Integer.parseInt(encontro[9]) + Integer.parseInt(v.ValorR.getText());
            int ts = Integer.parseInt(v.ValorR.getText());
            int tp = Integer.parseInt(encontro[11]) - Integer.parseInt(v.ValorR.getText());

            int resl=con.actualizaVarCli(Integer.parseInt(v.Laux.getText()), String.valueOf(tr), String.valueOf(ts), String.valueOf(tp));
            if (resl==1) {
                JOptionPane.showMessageDialog(null, "Gracias "+encontro[1]+" por su compra");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema en base de datos");
            }
            int ax=con.Contador_Facturas(); 
            String Datos[] = new String[4];
            Datos[0] = (String) v.ResuB.getText();
            Datos[1] = (String) v.ValorR.getText();
            Datos[2] = (String) encontro[1];
             Datos[3] = (String) encontro[3];
            String ruta = "C:\\Users\\CALEÑO\\Desktop\\Facturas\\Factura"+ax+".pdf";
            con.crearPdf(ruta, Datos);
            v.ValorR.setText("0");
            v.TCantidadB.setText("");
            v.CampoB.setText("");
            v.ResuB.setText("");
            con.Actualizar_ContadorF(ax+1);
            } else {
                 JOptionPane.showMessageDialog(null, "El número "+cliente+" no está en base de datos, verifique de nuevo o cree un nuevo cliente.");
            }
            
        }

    }
}
