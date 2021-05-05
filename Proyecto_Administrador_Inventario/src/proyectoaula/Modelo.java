package proyectoaula;

import java.sql.*;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.text.SimpleDateFormat;
///////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Modelo {

    String url = "basedb.db";
    Connection connect;

    public void conectar() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void cerrar() {
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Error en el cierre" + ex.getMessage());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    public void Escribir_en_Excel() {
        File file = new File("C:\\Users\\CALEÑO\\Desktop\\Facturas\\Inventario.xls");
        int row = 1;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD);
        WritableCellFormat cf = new WritableCellFormat(wf);
        WritableFont tit = new WritableFont(WritableFont.COURIER, 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
        WritableCellFormat clr = new WritableCellFormat(tit);
        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));

        try {
            workbook = Workbook.createWorkbook(file, wbSettings);
            //hoja con nombre de la tabla
            workbook.createSheet("Inventario", 0);
            excelSheet = workbook.getSheet(0);
            System.out.println("creando hoja excel.....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        //Consulta SQL 
        String diri = "SELECT id , codigobarras , descripcion , tventa, pcosto , pventas , pmayoreo, departamento , cantidad FROM productos ";
        try {
            PreparedStatement pstm = connect.prepareStatement(diri);
            ResultSet res = pstm.executeQuery();
            System.out.println("obteniendo registros.....Listo");
            Label a = new Label(0, 0, "Código Barras", clr);
            Label b = new Label(1, 0, "Descripción", clr);
            Label c = new Label(2, 0, "Tipo venta", clr);
            Label d = new Label(3, 0, "Precio Costo", clr);
            Label e = new Label(4, 0, "Precio Venta", clr);
            Label f = new Label(5, 0, "Precio Mayoreo", clr);
            Label g = new Label(6, 0, "Departamento", clr);
            Label h = new Label(7, 0, "Cantidad", clr);
            try {
                excelSheet.addCell(a);
                excelSheet.addCell(b);
                excelSheet.addCell(c);
                excelSheet.addCell(d);
                excelSheet.addCell(e);
                excelSheet.addCell(f);
                excelSheet.addCell(g);
                excelSheet.addCell(h);
            } catch (WriteException ex) {
                System.err.println(ex.getMessage());
            }
            while (res.next()) {
                Number codigobarras = new Number(0, row, res.getInt("codigobarras"), cf);
                Label descripcion = new Label(1, row, res.getString("descripcion"), cf);
                Label tventa = new Label(2, row, res.getString("tventa"), cf);
                Number pcosto = new Number(3, row, res.getFloat("pcosto"), cf);
                Number pventas = new Number(4, row, res.getFloat("pventas"), cf);
                Number pmayoreo = new Number(5, row, res.getFloat("pmayoreo"), cf);
                Label departamento = new Label(6, row, res.getString("departamento"), cf);
                Number cantidad = new Number(7, row, res.getInt("cantidad"), cf);

                row++;
                try {
                    excelSheet.addCell(codigobarras);
                    excelSheet.addCell(descripcion);
                    excelSheet.addCell(tventa);
                    excelSheet.addCell(pcosto);
                    excelSheet.addCell(pventas);
                    excelSheet.addCell(pmayoreo);
                    excelSheet.addCell(departamento);
                    excelSheet.addCell(cantidad);
                } catch (WriteException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println("Escribiendo en disco....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("Proceso completado....");
        JOptionPane.showMessageDialog(null, "Inventario generado correctamente");

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public int validarUsuario(String Us, String Ps) {
        int estado = 0;
        ResultSet result;
        String claveRes;
        try {
            PreparedStatement st
                    = connect.prepareStatement("select * from usuario where usuario=?");
            st.setString(1, Us);
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));

                System.out.print("usuario: ");
                System.out.println(result.getString("usuario"));

                System.out.print("Clave: ");
                System.out.println(result.getString("clave"));

                System.out.println("=======================");

                claveRes = result.getString("clave");
                if (claveRes.equals(Ps) && !result.getString("usuario").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    public int guardaProductos(String bar, String des, String tve, String pcos, String pven, String pma, String depto, String cant) {
        int estado;
        try {
            PreparedStatement st
                    = connect.prepareStatement("insert into productos (codigobarras,descripcion,tventa,pcosto,pventas,pmayoreo,departamento,cantidad) values (?,?,?,?,?,?,?,?)");
            st.setString(1, bar);
            st.setString(2, des);
            st.setString(3, tve);
            st.setString(4, pcos);
            st.setString(5, pven);
            st.setString(6, pma);
            st.setString(7, depto);
            st.setString(8, cant);
            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int guardaClientes(String nom, String snom, String pap, String sap, String dir, String ced, String tel, String corr, String sala, String ucom, String sald) {
        int estado;
        try {
            PreparedStatement st
                    = connect.prepareStatement("insert into clientes (pnombre,snombre,papellido,sapellido,direccion,cedula,telefono,correo,saldoa,ucompra,saldoc) values (?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, nom);
            st.setString(2, snom);
            st.setString(3, pap);
            st.setString(4, sap);
            st.setString(5, dir);
            st.setString(6, ced);
            st.setString(7, tel);
            st.setString(8, corr);
            st.setString(9, sala);
            st.setString(10, ucom);
            st.setString(11, sald);
            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int NuevoUsuario(String usu, String cla) {
        int estado;
        try {
            PreparedStatement st
                    = connect.prepareStatement("insert into usuario (usuario,clave) values (?,?)");
            st.setString(1, usu);
            st.setString(2, cla);
            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public String BuscaClientes(String Dato, int opcion) {
        String resultado = "", campoDB = "";
        ResultSet result;

        try {

            if (opcion == 1) {
                campoDB = "select * from clientes where pnombre";
            }
            if (opcion == 2) {
                campoDB = "select * from clientes where papellido";
            }
            if (opcion == 3) {
                campoDB = "select * from clientes where cedula";
            }

            PreparedStatement st = connect.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {

                resultado = resultado + "\nID:" + result.getInt("id")
                        + "\nPrimer Nombre: " + result.getString("pnombre")
                        + "\nSegundo Nombre: " + result.getString("snombre")
                        + "\nPrimer Apellido: " + result.getString("papellido")
                        + "\nSegundo Apellido: " + result.getString("sapellido")
                        + "\nDirección: " + result.getString("direccion")
                        + "\nN° Cédula: " + result.getString("cedula")
                        + "\nTeléfono: " + result.getString("telefono")
                        + "\nCorreo: " + result.getString("correo")
                        + "\nSaldo Actual: " + result.getString("saldoa")
                        + "\nUltimo valor de compra: " + result.getString("ucompra")
                        + "\nSaldo: " + result.getString("saldoc")
                        + "\n=======================";

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return resultado;

    }

    public String[] Busca_Modificar(String Dato, int opcion) {
        String resultado[] = new String[9], campoDB = "";
        ResultSet result;
        try {

            if (opcion == 1) {
                campoDB = "select * from productos where codigobarras";
            }
            if (opcion == 2) {
                campoDB = "select * from productos where descripcion";
            }
            if (opcion == 3) {
                campoDB = "select * from productos where tventa";
            }
            if (opcion == 4) {
                campoDB = "select * from productos where pcosto";
            }
            if (opcion == 5) {
                campoDB = "select * from productos where pventas";
            }
            if (opcion == 6) {
                campoDB = "select * from productos where pmayoreo";
            }
            if (opcion == 7) {
                campoDB = "select * from productos where departamento";
            }
            if (opcion == 8) {
                campoDB = "select * from productos where cantidad";
            }
            PreparedStatement st
                    = connect.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("id");
                resultado[1] = result.getString("codigobarras");
                resultado[2] = result.getString("descripcion");
                resultado[3] = result.getString("tventa");
                resultado[4] = result.getString("pcosto");
                resultado[5] = result.getString("pventas");
                resultado[6] = result.getString("pmayoreo");
                resultado[7] = result.getString("departamento");
                resultado[8] = result.getString("cantidad");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public String[] VentaNBusca(String Dato, int opcion) {
        String resultado[] = new String[9], campoDB = "";
        ResultSet result;
        try {
            if (opcion == 0) {
                campoDB = "select * from productos where codigobarras";
            }
            if (opcion == 1) {
                campoDB = "select * from productos where descripcion";
            }

            PreparedStatement st
                    = connect.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("id");
                resultado[1] = result.getString("codigobarras");
                resultado[2] = result.getString("descripcion");
                resultado[3] = result.getString("tventa");
                resultado[4] = result.getString("pcosto");
                resultado[5] = result.getString("pventas");
                resultado[6] = result.getString("pmayoreo");
                resultado[7] = result.getString("departamento");
                resultado[8] = result.getString("cantidad");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public String[] Busca_ModiClientes(String Dato, int opcion) {
        String resultado[] = new String[12], campoDB = "";
        ResultSet result;
        try {

            if (opcion == 1) {
                campoDB = "select * from clientes where pnombre";
            }
            if (opcion == 2) {
                campoDB = "select * from clientes where papellido";
            }
            if (opcion == 3) {
                campoDB = "select * from clientes where cedula";
            }
            PreparedStatement st
                    = connect.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("id");
                resultado[1] = result.getString("pnombre");
                resultado[2] = result.getString("snombre");
                resultado[3] = result.getString("papellido");
                resultado[4] = result.getString("sapellido");
                resultado[5] = result.getString("direccion");
                resultado[6] = result.getString("cedula");
                resultado[7] = result.getString("telefono");
                resultado[8] = result.getString("correo");
                resultado[9] = result.getString("saldoa");
                resultado[10] = result.getString("ucompra");
                resultado[11] = result.getString("saldoc");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int actualizaDatos(int id, String bar, String des, String tve, String pcos, String pven, String pma, String depto, String cant
    ) {
        int estado;
        try {
            PreparedStatement st = connect.prepareStatement(
                    "update productos set codigobarras=?,descripcion=?,tventa=?,pcosto=?,pventas=?,pmayoreo=?,departamento=?,cantidad=?" + "where id=?"
            );
            st.setString(1, bar);
            st.setString(2, des);
            st.setString(3, tve);
            st.setString(4, pcos);
            st.setString(5, pven);
            st.setString(6, pma);
            st.setString(7, depto);
            st.setString(8, cant);
            st.setInt(9, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int actualizaDatoClie(int id, String nom, String snom, String pap, String sap, String dir, String ced, String tel, String corr, String sala, String ucom, String sald
    ) {
        int estado;
        try {
            PreparedStatement st = connect.prepareStatement(
                    "update clientes set pnombre=?,snombre=?,papellido=?,sapellido=?,direccion=?,cedula=?,telefono=?,correo=?,saldoa=?,ucompra=?,saldoc=?" + "where id=?"
            );
            st.setString(1, nom);
            st.setString(2, snom);
            st.setString(3, pap);
            st.setString(4, sap);
            st.setString(5, dir);
            st.setString(6, ced);
            st.setString(7, tel);
            st.setString(8, corr);
            st.setString(9, sala);
            st.setString(10, ucom);
            st.setString(11, sald);
            st.setInt(12, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int actualizaVarCli(int id, String sala, String ucom, String sald) {
        int estado;
        try {
            PreparedStatement st = connect.prepareStatement(
                    "update clientes set saldoa=?,ucompra=?,saldoc=?" + "where id=?"
            );
            st.setString(1, sala);
            st.setString(2, ucom);
            st.setString(3, sald);
            st.setInt(4, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int actualizaCant(int id, String cant) {
        int estado;
        try {
            PreparedStatement st = connect.prepareStatement(
                    "update productos set cantidad=?" + "where id=?"
            );
            st.setString(1, cant);
            st.setInt(2, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int Busca_Cantidad(int Dato) {
        int resultado = 0;
        String campoDB = "";
        ResultSet result;
        try {

            campoDB = "select * from productos where codigobarras";

            PreparedStatement st
                    = connect.prepareStatement(campoDB + "=?");
            st.setInt(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado = result.getInt("cantidad");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int BorrarCliente(int id) {
        int estado;
        try {
            PreparedStatement st
                    = connect.prepareStatement(
                            "delete from clientes where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int BorrarUsuario(int id) {
        int estado;
        try {
            PreparedStatement st
                    = connect.prepareStatement(
                            "delete from usuario where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public String Busca_Usuario(String Dato) {
        String resultado = "", campoDB = "";
        ResultSet result;
        try {

            campoDB = "select * from usuario where usuario";

            PreparedStatement st
                    = connect.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado = result.getString("id");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public String Busca_Clientes(int dato) {
        String resultado = "", campoDB = "";
        ResultSet result;
        try {

            campoDB = "select * from clientes where cedula";

            PreparedStatement st
                    = connect.prepareStatement(campoDB + "=?");
            st.setInt(1, dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado = result.getString("cedula");

            }
        } catch (SQLException ex) {
            System.out.println("Cliente no encontrado");
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public String Busca_Contraseña(String Dato) {
        String resultado = "", campoDB = "";
        ResultSet result;
        try {

            campoDB = "select * from usuario where clave";

            PreparedStatement st
                    = connect.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado = result.getString("clave");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int Contador_Combo() {
        int resultado = 0;
        ResultSet result;
        try {

            PreparedStatement st = connect.prepareStatement("SELECT count(*) FROM depto");
            result = st.executeQuery();
            while (result.next()) {
                resultado = result.getInt("count(*)");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
 public int Contador_Facturas() {
        int resultado = 0;
        ResultSet result;
        try {

            PreparedStatement st = connect.prepareStatement("SELECT contador FROM contf");
            result = st.executeQuery();
            while (result.next()) {
                resultado = result.getInt("contador");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    public int Contador_Ganancia() {
        int resultado = 0;
        ResultSet result;
        try {

            PreparedStatement st = connect.prepareStatement("SELECT gana FROM ganancias");
            result = st.executeQuery();
            while (result.next()) {
                resultado = result.getInt("gana");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int Actualizar_ContadorF(int cant) {
        int estado;
        try {
            PreparedStatement st = connect.prepareStatement(
                    "update contf set contador=?" + "where id=1"
            );
            st.setInt(1, cant);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }
    public int Actualizar_Ganancia(int cant) {
        int estado;
        try {
            PreparedStatement st = connect.prepareStatement(
                    "update ganancias set gana=?" + "where id=1"
            );
            st.setInt(1, cant);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int ValidaNuevo(int id) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st
                    = connect.prepareStatement("select * from usuario where 1=?");
            st.setInt(1, id);
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));

                System.out.print("usuario: ");
                System.out.println(result.getString("usuario"));

                System.out.print("Clave: ");
                System.out.println(result.getString("clave"));

                System.out.println("=======================");

                if (!result.getString("id").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;

    }

    public String Buscador1(int opcion, int x) {
        String resultado = "", campoDB = "";
        ResultSet result;
        try {

            if (opcion == 0) {

                campoDB = "select * from depto where id=" + x;

            }
            if (opcion == 1) {
                campoDB = "select * from depto where id=" + x;
            }

            PreparedStatement st = connect.prepareStatement(campoDB);
            result = st.executeQuery();

            while (result.next()) {
                if (opcion == 0) {
                    resultado = resultado
                            + result.getString("depto");
                }
                if (opcion == 1) {
                    resultado = resultado
                            + result.getString("depto");
                }

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return resultado;

    }

    public int Valida_NProducto(int codigo) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st
                    = connect.prepareStatement("select * from productos where codigobarras=?");
            st.setInt(1, codigo);
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("Codigo Barras: ");
                System.out.println(result.getInt("codigobarras"));

                System.out.print("Descripción: ");
                System.out.println(result.getString("descripcion"));

                System.out.println("=======================");

                if (!result.getString("codigobarras").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;

    }

    public int Valida_NCliente(int cedula) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st
                    = connect.prepareStatement("select * from clientes where cedula=?");
            st.setInt(1, cedula);
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("Nombre: ");
                System.out.println(result.getString("pnombre"));

                System.out.print("cedula: ");
                System.out.println(result.getString("cedula"));

                System.out.println("=======================");

                if (!result.getString("cedula").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;

    }

    public void crearPdf(String Ruta, String t[]) {
        File file;
        PdfWriter writer;
        PdfDocument pdf;
        Document document;
        try {
            file = new File(Ruta);
            file.getParentFile().mkdirs();
            writer = new PdfWriter(Ruta);
            pdf = new PdfDocument(writer);
            document = new Document(pdf);
            document.add(new Paragraph("   "+"PROYECTO PROGRAMACIÓN II"));
            document.add(new Paragraph("      "+"SUPERMERCADO 9 A 9"));
            document.add(new Paragraph("BUENA CALIDAD, PRECIOS JUSTOS"));
            document.add(new Paragraph("Cliente: " + t[2] + " " + t[3]));
            document.add(new Paragraph(""));
            document.add(new Paragraph("" + t[0]));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Valor de la compra: " + t[1]));
            document.add(new Paragraph("  Gracias por su compra"));
            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
            document.add(new Paragraph("" + date.format(now) + " " + hour.format(now) + " PM"));

            /*document.add(new Paragraph("Apellido: " + t[1]));
            document.add(new Paragraph("EPS: " + t[2]));
            document.add(new Paragraph("N° Documento: " + t[3]));
            document.add(new Paragraph("Tipo/Grupo sanguineo: " + t[4]));
            document.add(new Paragraph("Diagnostico: " + t[5]));*/
            document.close();
        } catch (IOException ioex) {
            System.out.println("" + ioex.getMessage());
        }
    }

}
