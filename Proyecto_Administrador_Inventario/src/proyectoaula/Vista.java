package proyectoaula;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Vista extends JFrame implements ActionListener {

    JPanel panel0, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10, panel11;
    JLabel LNuevo, LCodigoN, LDescripcionN, LSevendeN, LPrecioCN, LPrecioVN, LPrecioMN, LDepartamentoN, LCantidadN,GanR,GanA,
            LModificar, LCodigoM, LDescripcionM, LSevendeM, LPrecioCM, LPrecioVM, LPrecioMM, LDepartamentoM, LCantidadM,
            LAjuste, LCodigoA, LDescripcionA, LCantidadActualA, TDescripcionA, TCantidadActualA, LCantidadNuevaA,
            CantidadB, LPrueba,
            LNom1, LNom2, LApe1, LApe2, LDir, LCe, LTel, LCor, LCom, LUl, LSal,
            LNom1M, LNom2M, LApe1M, LApe2M, LDirM, LCeM, LTelM, LCorM, LComM, LUlM, LSalM, LnroM,
            nro,
            MsjBuscar, MsjBuscar1, MsjBuscar2, MsjNuevo, MsjModificar, Bienvenidos, Laux,
            crear, usuarioc, clavec, borraru, usuariob, ValorA, ValorR;

    JRadioButton UnidadN, GranelN, PaqueteN,
            UnidadM, GranelM, PaqueteM;
    JTextField TCodigoN, TDescripcionN, TPrecioCN, TPrecioVN, TPrecioMN,
            TCodigoM, TDescripcionM, TPrecioCM, TPrecioVM, TPrecioMM,
            TCodigoA,
            CampoB,
            TCantidadB,
            TNom1, TNom2, TApe1, TApe2, TDir, TCe, TTel, TCor, TCom, TUl, TSal,
            TNom1M, TNom2M, TApe1M, TApe2M, TDirM, TCeM, TTelM, TCorM, TComM, TUlM, TSalM, CampoM,
            CampoBB,
            CampoE,
            tusuarioc, tusuariob;
    JPasswordField tclavec;
    JComboBox TCantidadN, TDepartamentoN,
            TCantidadM, TDepartamentoM,
            TCantidadNuevaA,
            TipoB,
            Tipo1M,
            TipoM, TipoBB,
            TipoE;
    JButton BNuevo, BModificar, BAjuste, BBuscar, Buscar2,
            GuardarProductoN,
            GuardarProductoM,
            GuardarCantidadA,
            BuscarB,
            BuscarMP,
            BuscarA,Excel,
            NuevoC, ModificarC, BuscarC, EliminarC,
            Env, Bor,
            EnvM, BorM, BuscarM,
            BuscarBB,
            BuscarE, Elim,
            Exportar,
            Usuario,
            borrarc, borrarb;

    JScrollPane panelB,
            panelBB,
            panelE;
    JTextArea ResuB,
            ResuBB,
            ResuE;
    ImageIcon GuardarN,
            GuardarM, logo,
            ReemplazarA, RemplazarB, RemplazarC, Borrar, IconNuevoC, IconModificarC, IconNuevoP, IconModificarP, IconAjusteP, IconBuscarP, IPrueba,
            IconUsuario;
    ButtonGroup GrupoN,
            GrupoM;
    Font Fuente, Fuent, FUENTE, f;

    Vista() {

        setTitle("Punto de Venta");
        this.setSize(1275, 750);
        this.setLayout(null);
        logo = new ImageIcon("Inventario.png");//Nombre y extension de la imagen
        Image logoven = logo.getImage(); //conversio0n a imagen
        this.setLocation(120, 0);//posicion en el que aparecera la ventana
        this.setIconImage(logoven);//poner nuevo icono a la ventana

        Fuente = new Font("Calibri", Font.ITALIC, 15);
        Fuent = new Font("Calibri", Font.ITALIC, 35);
        FUENTE = new Font("Calibri", Font.ITALIC, 100);
        f = new Font("Calibri", Font.ITALIC, 20);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.setBackground(new Color(062, 95, 138));
        panel1.setBounds(0, 0, 1260, 150);
        this.add(panel1);

        panel0 = new JPanel();
        panel0.setLayout(null);
        panel0.setVisible(true);
        panel0.setBackground(new Color(063, 136, 143));
        panel0.setBounds(0, 150, 1260, 600);
        this.add(panel0);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setVisible(false);
        panel2.setBackground(new Color(063, 136, 143));
        panel2.setBounds(0, 150, 1260, 600);
        this.add(panel2);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setVisible(false);
        panel3.setBackground(new Color(063, 136, 143));
        panel3.setBounds(0, 150, 1260, 600);
        this.add(panel3);

        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setVisible(false);
        panel4.setBackground(new Color(063, 136, 143));
        panel4.setBounds(0, 150, 1260, 600);
        this.add(panel4);

        panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setVisible(false);
        panel5.setBackground(new Color(063, 136, 143));
        panel5.setBounds(0, 150, 1260, 600);
        this.add(panel5);

        panel6 = new JPanel();
        panel6.setLayout(null);
        panel6.setVisible(false);
        panel6.setBackground(new Color(063, 136, 143));
        panel6.setBounds(0, 150, 1260, 600);
        this.add(panel6);

        panel7 = new JPanel();
        panel7.setLayout(null);
        panel7.setVisible(false);
        panel7.setBackground(new Color(063, 136, 143));
        panel7.setBounds(0, 150, 1260, 600);
        this.add(panel7);

        panel8 = new JPanel();
        panel8.setLayout(null);
        panel8.setVisible(false);
        panel8.setBackground(new Color(063, 136, 143));
        panel8.setBounds(0, 150, 1260, 600);
        this.add(panel8);

        panel9 = new JPanel();
        panel9.setLayout(null);
        panel9.setVisible(false);
        panel9.setBackground(new Color(063, 136, 143));
        panel9.setBounds(0, 150, 1260, 600);
        this.add(panel9);

        panel10 = new JPanel();
        panel10.setLayout(null);
        panel10.setVisible(false);
        panel10.setBackground(new Color(063, 136, 143));
        panel10.setBounds(0, 150, 1260, 600);
        this.add(panel10);

////////////////////////////////////////////////////COMIENZO////////////////////////////////////////////////////////////        
        IPrueba = new ImageIcon("ImagenLogin.png");
        LPrueba = new JLabel(IPrueba);

        Bienvenidos = new JLabel("BIENVENIDO");
        Bienvenidos.setBounds(170, 100, 600, 200);
        //panel0.add(Bienvenidos);
        LPrueba.setBounds(0, 0, 1260, 625);
        panel0.add(LPrueba);
        Bienvenidos.setFont(FUENTE);

/////////////////////////////////////////////////////////////////MENU///////////////////////////////////////////////////        
        IconNuevoP = new ImageIcon("NuevoProducto.png");
        BNuevo = new JButton("NUEVO PRODUCTO", IconNuevoP);
        BNuevo.setFont(Fuente);
        IconModificarP = new ImageIcon("ModificarP.png");
        BModificar = new JButton("MODIFICAR PRODUCTO", IconModificarP);
        BModificar.setFont(Fuente);
        IconAjusteP = new ImageIcon("AjusteP.png");
        BAjuste = new JButton("AJUSTE DE PRODUCTO", IconAjusteP);
        BAjuste.setFont(Fuente);
        IconBuscarP = new ImageIcon("BuscarPr.png");
        BBuscar = new JButton("VENTAS", IconBuscarP);
        BBuscar.setFont(Fuente);
        IconUsuario = new ImageIcon("Usuario.png");
        Usuario = new JButton("USUARIOS", IconUsuario);
        Usuario.setFont(Fuente);

        BNuevo.setBounds(50, 30, 230, 40);
        BModificar.setBounds(280, 30, 230, 40);
        BAjuste.setBounds(510, 30, 230, 40);
        BBuscar.setBounds(740, 30, 230, 40);
        Usuario.setBounds(980, 55, 230, 60);

        panel1.add(BNuevo);
        panel1.add(BModificar);
        panel1.add(BAjuste);
        panel1.add(BBuscar);
        panel1.add(Usuario);

/////////////////////////////////////////////////////////////////NUEVO PRODUCTO/////////////////////////////////////////
        LNuevo = new JLabel("NUEVO PRODUCTO");
        LNuevo.setFont(Fuent);
        LCodigoN = new JLabel("Código de Barras:");
        LCodigoN.setFont(Fuente);
        LDescripcionN = new JLabel("Descripción:");
        LDescripcionN.setFont(Fuente);
        LSevendeN = new JLabel("Se Vende:");
        LSevendeN.setFont(Fuente);
        LPrecioCN = new JLabel("Precio Costo:");
        LPrecioCN.setFont(Fuente);
        LPrecioVN = new JLabel("Precio Venta:");
        LPrecioVN.setFont(Fuente);
        LPrecioMN = new JLabel("Precio Mayoreo:");
        LPrecioMN.setFont(Fuente);
        LDepartamentoN = new JLabel("Departamento:");
        LDepartamentoN.setFont(Fuente);
        LCantidadN = new JLabel("Cantidad:");
        LCantidadN.setFont(Fuente);

        UnidadN = new JRadioButton("Por Unidad");
        UnidadN.setFont(Fuente);
        GranelN = new JRadioButton("A Granel");
        GranelN.setFont(Fuente);
        PaqueteN = new JRadioButton("Como Paquete");
        PaqueteN.setFont(Fuente);

        GrupoN = new ButtonGroup();

        GrupoN.add(UnidadN);
        GrupoN.add(GranelN);
        GrupoN.add(PaqueteN);

        TCodigoN = new JTextField("");
        TCodigoN.setFont(Fuente);
        TDescripcionN = new JTextField("");
        TDescripcionN.setFont(Fuente);
        TPrecioCN = new JTextField("");
        TPrecioCN.setFont(Fuente);
        TPrecioVN = new JTextField("");
        TPrecioVN.setFont(Fuente);
        TPrecioMN = new JTextField("");
        TPrecioMN.setFont(Fuente);
        TDepartamentoN = new JComboBox();
        TDepartamentoN.setFont(Fuente);
        Modelo m = new Modelo();
        m.conectar();
        for (int i = 1; i <= m.Contador_Combo(); i++) {
            TDepartamentoN.addItem(m.Buscador1(0, i));
        }
        m.cerrar();
        TCantidadN = new JComboBox();
        TCantidadN.addItem("");
        TCantidadN.setFont(Fuente);
        for (int i = 1; i <= 100; i++) {
            TCantidadN.addItem("" + i);

        }

        GuardarN = new ImageIcon("Guardar.png");
        GuardarProductoN = new JButton("Guardar Producto", GuardarN);
        GuardarProductoN.setFont(Fuente);

        LNuevo.setBounds(500, 5, 350, 50);
        LCodigoN.setBounds(20, 70, 120, 40);
        TCodigoN.setBounds(140, 70, 120, 40);
        LDescripcionN.setBounds(40, 120, 120, 40);
        TDescripcionN.setBounds(140, 120, 200, 40);
        LSevendeN.setBounds(60, 170, 100, 40);
        UnidadN.setBounds(140, 170, 160, 40);
        GranelN.setBounds(300, 170, 160, 40);
        PaqueteN.setBounds(460, 170, 160, 40);
        LPrecioCN.setBounds(40, 220, 100, 40);
        TPrecioCN.setBounds(140, 220, 120, 40);
        LPrecioVN.setBounds(40, 270, 100, 40);
        TPrecioVN.setBounds(140, 270, 120, 40);
        LPrecioMN.setBounds(30, 320, 110, 40);
        TPrecioMN.setBounds(140, 320, 120, 40);
        LDepartamentoN.setBounds(40, 370, 100, 40);
        TDepartamentoN.setBounds(140, 370, 120, 40);
        LCantidadN.setBounds(70, 420, 70, 40);
        TCantidadN.setBounds(140, 420, 50, 40);
        GuardarProductoN.setBounds(100, 480, 200, 40);

        panel2.add(LNuevo);
        panel2.add(LCodigoN);
        panel2.add(TCodigoN);
        panel2.add(LDescripcionN);
        panel2.add(TDescripcionN);
        panel2.add(LSevendeN);
        panel2.add(UnidadN);
        panel2.add(GranelN);
        panel2.add(PaqueteN);
        panel2.add(LPrecioCN);
        panel2.add(TPrecioCN);
        panel2.add(LPrecioVN);
        panel2.add(TPrecioVN);
        panel2.add(LPrecioMN);
        panel2.add(TPrecioMN);
        panel2.add(LDepartamentoN);
        panel2.add(TDepartamentoN);
        panel2.add(LCantidadN);
        panel2.add(TCantidadN);
        panel2.add(GuardarProductoN);

////////////////////////////////////////////////////////////////MODIFICAR PRODUCTO///////////////////////////////////////
        Tipo1M = new JComboBox();
        Tipo1M.addItem("-Seleccione-");
        Tipo1M.addItem("Codigo");
        Tipo1M.addItem("Descripcion");

        Tipo1M.setFont(Fuente);

        RemplazarB = new ImageIcon("BuscarP.png");
        BuscarMP = new JButton();
        BuscarMP.setToolTipText("Buscar");
        BuscarMP.setIcon(RemplazarB);
        BuscarMP.setFont(Fuente);

        Laux = new JLabel("");
        LModificar = new JLabel("MODIFICAR PRODUCTO");
        LModificar.setFont(Fuent);
        LCodigoM = new JLabel("Nuevo Codigo:");
        LCodigoM.setFont(Fuente);
        LDescripcionM = new JLabel("Descripción:");
        LDescripcionM.setFont(Fuente);
        LSevendeM = new JLabel("Se Vende:");
        LSevendeM.setFont(Fuente);
        LPrecioCM = new JLabel("Precio Costo:");
        LPrecioCM.setFont(Fuente);
        LPrecioVM = new JLabel("Precio Venta:");
        LPrecioVM.setFont(Fuente);
        LPrecioMM = new JLabel("Precio Mayoreo:");
        LPrecioMM.setFont(Fuente);
        LDepartamentoM = new JLabel("Departamento:");
        LDepartamentoM.setFont(Fuente);
        LCantidadM = new JLabel("Cantidad Actual:");
        LCantidadM.setFont(Fuente);

        UnidadM = new JRadioButton("Por Unidad");
        UnidadM.setFont(Fuente);
        GranelM = new JRadioButton("A Granel");
        GranelM.setFont(Fuente);
        PaqueteM = new JRadioButton("Como Paquete");
        PaqueteM.setFont(Fuente);

        GrupoM = new ButtonGroup();

        GrupoM.add(UnidadM);
        GrupoM.add(GranelM);
        GrupoM.add(PaqueteM);

        TCodigoM = new JTextField("");
        TCodigoM.setFont(Fuente);
        TDescripcionM = new JTextField("");
        TDescripcionM.setFont(Fuente);
        TPrecioCM = new JTextField("$ ");
        TPrecioCM.setFont(Fuente);
        TPrecioVM = new JTextField("$ ");
        TPrecioVM.setFont(Fuente);
        TPrecioMM = new JTextField("$ ");
        TPrecioMM.setFont(Fuente);
        TDepartamentoM = new JComboBox();
        m.conectar();
        for (int i = 1; i <= m.Contador_Combo(); i++) {
            TDepartamentoM.addItem(m.Buscador1(0, i));
        }
        m.cerrar();
        TDepartamentoM.setFont(Fuente);
        TCantidadM = new JComboBox();
        TCantidadM.addItem("");
        for (int i = 1; i <= 100; i++) {
            TCantidadM.addItem("" + i);
            TCantidadM.setFont(Fuente);

        }

        GuardarM = new ImageIcon("Guardar.png");
        GuardarProductoM = new JButton("Guardar Producto", GuardarM);
        GuardarProductoM.setFont(Fuente);

        LModificar.setBounds(500, 5, 350, 50);
        LCodigoM.setBounds(30, 70, 110, 40);
        TCodigoM.setBounds(140, 70, 120, 40);
        LDescripcionM.setBounds(50, 120, 120, 40);
        TDescripcionM.setBounds(140, 120, 200, 40);
        LSevendeM.setBounds(60, 170, 100, 40);
        UnidadM.setBounds(140, 170, 160, 40);
        GranelM.setBounds(300, 170, 160, 40);
        PaqueteM.setBounds(460, 170, 160, 40);
        LPrecioCM.setBounds(40, 220, 100, 40);
        TPrecioCM.setBounds(140, 220, 120, 40);
        LPrecioVM.setBounds(40, 270, 100, 40);
        TPrecioVM.setBounds(140, 270, 120, 40);
        LPrecioMM.setBounds(30, 320, 110, 40);
        TPrecioMM.setBounds(140, 320, 120, 40);
        LDepartamentoM.setBounds(40, 370, 100, 40);
        TDepartamentoM.setBounds(140, 370, 120, 40);
        LCantidadM.setBounds(30, 420, 110, 40);
        TCantidadM.setBounds(140, 420, 50, 40);
        GuardarProductoM.setBounds(100, 480, 200, 40);
        Tipo1M.setBounds(300, 70, 150, 40);
        BuscarMP.setBounds(470, 70, 70, 40);

        panel3.add(LModificar);
        panel3.add(LCodigoM);
        panel3.add(TCodigoM);
        panel3.add(LDescripcionM);
        panel3.add(TDescripcionM);
        panel3.add(LSevendeM);
        panel3.add(UnidadM);
        panel3.add(GranelM);
        panel3.add(PaqueteM);
        panel3.add(LPrecioCM);
        panel3.add(TPrecioCM);
        panel3.add(LPrecioVM);
        panel3.add(TPrecioVM);
        panel3.add(LPrecioMM);
        panel3.add(TPrecioMM);
        panel3.add(LDepartamentoM);
        panel3.add(TDepartamentoM);
        panel3.add(LCantidadM);
        panel3.add(TCantidadM);
        panel3.add(GuardarProductoM);
        panel3.add(Tipo1M);
        panel3.add(BuscarMP);

/////////////////////////////////////////////////////////////AJUSTE DE PRODUCTO//////////////////////////////////////////
        LAjuste = new JLabel("AJUSTE DE INVENTARIO");
        LAjuste.setFont(Fuent);
        LCodigoA = new JLabel("Codigo del Producto:");
        LCodigoA.setFont(Fuente);
        LDescripcionA = new JLabel("Descripción:");
        LDescripcionA.setFont(Fuente);
        LCantidadActualA = new JLabel("Cantidad Actual:");
        LCantidadActualA.setFont(Fuente);
        TCantidadActualA = new JLabel("");
        TCantidadActualA.setFont(Fuente);
        LCantidadNuevaA = new JLabel("Nueva Cantidad:");
        LCantidadNuevaA.setFont(Fuente);
        TDescripcionA = new JLabel("");
        TDescripcionA.setFont(Fuente);
        RemplazarB = new ImageIcon("BuscarP.png");
        BuscarA = new JButton();
        BuscarA.setToolTipText("Buscar");
        BuscarA.setIcon(RemplazarB);
        BuscarA.setFont(Fuente);
        Excel = new JButton("Reporte Inventario");
        Excel.setFont(Fuente);
        GanA = new JLabel("GANANCIAS:");
        GanA.setFont(Fuente);
        GanR = new JLabel("0");
        GanR.setFont(Fuente);

        TCodigoA = new JTextField("");
        TCodigoA.setFont(Fuente);
        TCantidadNuevaA = new JComboBox();
        TCantidadNuevaA.addItem("");
        for (int i = 1; i <= 100; i++) {
            TCantidadNuevaA.addItem("" + i);
            TCantidadNuevaA.setFont(Fuente);

        }
        

        ReemplazarA = new ImageIcon("ImagenReeemplazar.jpg");
        GuardarCantidadA = new JButton();
        GuardarCantidadA.setIcon(ReemplazarA);
        GuardarCantidadA.setToolTipText("Reemplazar cantidad de inventario del producto");
        GuardarCantidadA.setFont(Fuente);

        LAjuste.setBounds(500, 5, 350, 50);
        LCodigoA.setBounds(470, 70, 130, 40);
        TCodigoA.setBounds(600, 70, 120, 40);
        LDescripcionA.setBounds(500, 120, 120, 40);
        TDescripcionA.setBounds(600, 120, 120, 40);
        LCantidadActualA.setBounds(490, 170, 120, 40);
        TCantidadActualA.setBounds(600, 170, 120, 40);
        LCantidadNuevaA.setBounds(490, 220, 120, 40);
        TCantidadNuevaA.setBounds(600, 220, 50, 40);
        GuardarCantidadA.setBounds(600, 280, 50, 50);
        GanA.setBounds(750, 410, 120, 40);
        GanR.setBounds(880, 410, 70, 40);
        BuscarA.setBounds(730, 70, 70, 40);
        Excel.setBounds(500, 400, 200, 50);

        panel4.add(LAjuste);
        panel4.add(LCodigoA);
        panel4.add(GanA);
        panel4.add(GanR);
        panel4.add(TCodigoA);
        panel4.add(LDescripcionA);
        panel4.add(TDescripcionA);
        panel4.add(LCantidadActualA);
        panel4.add(TCantidadActualA);
        panel4.add(LCantidadNuevaA);
        panel4.add(TCantidadNuevaA);
        panel4.add(GuardarCantidadA);
        panel4.add(Excel);
        panel4.add(BuscarA);

////////////////////////////////////////////////////////VENTAAAAAAASSSS//////////////////////////////////////////////////
        CampoB = new JTextField(50);
        CampoB.setFont(Fuente);
        Exportar = new JButton("FACTURA");
        Exportar.setFont(Fuente);
        MsjBuscar1 = new JLabel("FACTURACIÓN");
        MsjBuscar1.setFont(Fuent);
        TipoB = new JComboBox();
        TipoB.addItem("Codigo");
        TipoB.addItem("Descripción");
        TipoB.setFont(Fuente);
        CantidadB = new JLabel("Cantidad:");
        CantidadB.setFont(Fuente);
        ValorA = new JLabel("VALOR COMPRA:");
        ValorA.setFont(Fuente);
        ValorR = new JLabel("0");
        ValorR.setFont(Fuente);
        TCantidadB = new JTextField("");
        TCantidadB.setFont(Fuente);

        RemplazarB = new ImageIcon("BuscarP.png");
        BuscarB = new JButton();
        BuscarB.setToolTipText("Precio normal");
        BuscarB.setIcon(RemplazarB);
        BuscarB.setFont(Fuente);

        Buscar2 = new JButton();
        Buscar2.setToolTipText("Precio Mayoreo");
        Buscar2.setIcon(RemplazarB);
        Buscar2.setFont(Fuente);

        ResuB = new JTextArea();
        ResuB.setFont(Fuente);
        ResuB.setText("Código      Descripción    Cant    Precio"+"\n");
        panelB = new JScrollPane(ResuB);
        MsjBuscar1.setBounds(530, 5, 350, 50);
        CampoB.setBounds(400, 70, 150, 40);
        TipoB.setBounds(560, 70, 150, 40);
        CantidadB.setBounds(720, 70, 70, 40);
        TCantidadB.setBounds(800, 70, 50, 40);
        BuscarB.setBounds(550, 150, 50, 50);
        Buscar2.setBounds(660, 150, 50, 50);
        panelB.setBounds(430, 210, 300, 160);
        ValorA.setBounds(750, 410, 120, 40);
        ValorR.setBounds(880, 410, 70, 40);
        Exportar.setBounds(500, 390, 150, 40);

        panel5.add(CampoB);
        panel5.add(ValorA);
        panel5.add(ValorR);
        panel5.add(TipoB);
        panel5.add(BuscarB);
        panel5.add(Buscar2);
        panel5.add(panelB);
        panel5.add(MsjBuscar1);
        panel5.add(Exportar);
        panel5.add(CantidadB);
        panel5.add(TCantidadB);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////CLIENTESSS/////////////////////////////////CLIENTESSS/////////////////////////////////
        IconNuevoC = new ImageIcon("NuevoC.png");
        NuevoC = new JButton("NUEVO CLIENTE", IconNuevoC);
        NuevoC.setFont(Fuente);
        IconModificarC = new ImageIcon("ModificarC.png");
        ModificarC = new JButton("MODIFICAR CLIENTE", IconModificarC);
        ModificarC.setFont(Fuente);
        RemplazarC = new ImageIcon("BuscarC.png");
        BuscarC = new JButton("BUSCAR CLIENTE", RemplazarC);
        BuscarC.setFont(Fuente);
        Borrar = new ImageIcon("Borrar.png");
        EliminarC = new JButton("ELIMINAR CLIENTE", Borrar);
        EliminarC.setFont(Fuente);

        NuevoC.setBounds(50, 90, 230, 40);
        ModificarC.setBounds(280, 90, 230, 40);
        BuscarC.setBounds(510, 90, 230, 40);
        EliminarC.setBounds(740, 90, 230, 40);

        panel1.add(NuevoC);
        panel1.add(ModificarC);
        panel1.add(BuscarC);
        panel1.add(EliminarC);

//////////////////////////////////////////////////////////NUEVO CLIENTE/////////////////////////////////////////////////
        MsjNuevo = new JLabel("NUEVO CLIENTE");
        MsjNuevo.setFont(Fuent);
        LNom1 = new JLabel("Primer Nombre:");
        LNom1.setFont(Fuente);
        LNom2 = new JLabel("Segundo Nombre:");
        LNom2.setFont(Fuente);
        LApe1 = new JLabel("Primer Apellido:");
        LApe1.setFont(Fuente);
        LApe2 = new JLabel("Segundo Apellido:");
        LApe2.setFont(Fuente);
        LDir = new JLabel("Dirección:");
        LDir.setFont(Fuente);
        LCe = new JLabel("Cédula:");
        LCe.setFont(Fuente);
        LTel = new JLabel("Teléfono:");
        LTel.setFont(Fuente);
        LCor = new JLabel("Correo:");
        LCor.setFont(Fuente);
        LCom = new JLabel("Saldo Anual:");
        LCom.setFont(Fuente);
        LUl = new JLabel("Ultima Compra:");
        LUl.setFont(Fuente);
        LSal = new JLabel("Saldo:");
        LSal.setFont(Fuente);

        TNom1 = new JTextField();
        TNom1.setFont(Fuente);
        TNom2 = new JTextField();
        TNom2.setFont(Fuente);
        TApe1 = new JTextField();
        TApe1.setFont(Fuente);
        TApe2 = new JTextField();
        TApe2.setFont(Fuente);
        TDir = new JTextField();
        TDir.setFont(Fuente);
        TCe = new JTextField();
        TCe.setFont(Fuente);
        TTel = new JTextField();
        TTel.setFont(Fuente);
        TCor = new JTextField();
        TCor.setFont(Fuente);
        TCom = new JTextField();
        TCom.setFont(Fuente);
        TUl = new JTextField();
        TUl.setFont(Fuente);
        TSal = new JTextField();
        TSal.setFont(Fuente);

        Env = new JButton();
        Env.setIcon(GuardarN);
        Env.setToolTipText("Guardar");
        Env.setFont(Fuente);
        Bor = new JButton();
        Bor.setIcon(Borrar);
        Bor.setToolTipText("Limpiar");
        Bor.setFont(Fuente);

        MsjNuevo.setBounds(500, 5, 350, 50);
        LNom1.setBounds(420, 70, 100, 30);
        TNom1.setBounds(540, 70, 200, 30);
        LNom2.setBounds(400, 110, 120, 30);
        TNom2.setBounds(540, 110, 200, 30);
        LApe1.setBounds(420, 150, 100, 30);
        TApe1.setBounds(540, 150, 200, 30);
        LApe2.setBounds(410, 190, 110, 30);
        TApe2.setBounds(540, 190, 200, 30);
        LDir.setBounds(450, 230, 60, 30);
        TDir.setBounds(540, 230, 200, 30);
        LCe.setBounds(450, 270, 60, 30);
        TCe.setBounds(540, 270, 200, 30);
        LTel.setBounds(440, 310, 80, 30);
        TTel.setBounds(540, 310, 200, 30);
        LCor.setBounds(450, 350, 60, 30);
        TCor.setBounds(540, 350, 200, 30);
        LCom.setBounds(430, 390, 90, 30);
        TCom.setBounds(540, 390, 200, 30);
        LUl.setBounds(420, 430, 100, 30);
        TUl.setBounds(540, 430, 200, 30);
        LSal.setBounds(450, 470, 60, 30);
        TSal.setBounds(540, 470, 200, 30);

        Env.setBounds(540, 510, 50, 50);
        Bor.setBounds(670, 510, 50, 50);

        panel6.add(LNom1);
        panel6.add(TNom1);
        panel6.add(LNom2);
        panel6.add(TNom2);
        panel6.add(LApe1);
        panel6.add(TApe1);
        panel6.add(LApe2);
        panel6.add(TApe2);
        panel6.add(LDir);
        panel6.add(TDir);
        panel6.add(LCe);
        panel6.add(TCe);
        panel6.add(LTel);
        panel6.add(TTel);
        panel6.add(LCor);
        panel6.add(TCor);
        panel6.add(LCom);
        panel6.add(TCom);
        panel6.add(LUl);
        panel6.add(TUl);
        panel6.add(LSal);
        panel6.add(TSal);
        panel6.add(MsjNuevo);
        panel6.add(Env);
        panel6.add(Bor);

////////////////////////////////////////////////////////MODIFICAR CLIENTE///////////////////////////////////////////////
        CampoM = new JTextField(50);
        CampoM.setFont(Fuente);
        MsjModificar = new JLabel("MODIFICAR CLIENTE");
        MsjModificar.setFont(Fuent);
        TipoM = new JComboBox();
        TipoM.addItem("-Seleccione-");
        TipoM.addItem("Primer Nombre");
        TipoM.addItem("Primer Apellido");
        TipoM.addItem("Cédula");
        TipoM.setFont(Fuente);

        RemplazarC = new ImageIcon("BuscarC.png");
        BuscarM = new JButton();
        BuscarM.setIcon(RemplazarC);
        BuscarM.setToolTipText("Buscar");
        BuscarM.setFont(Fuente);

        LNom1M = new JLabel("Primer Nombre:");
        LNom1M.setFont(Fuente);
        LNom2M = new JLabel("Segundo Nombre:");
        LNom2M.setFont(Fuente);
        LApe1M = new JLabel("Primer Apellido:");
        LApe1M.setFont(Fuente);
        LApe2M = new JLabel("Segundo Apellido:");
        LApe2M.setFont(Fuente);
        LDirM = new JLabel("Direccion:");
        LDirM.setFont(Fuente);
        LCeM = new JLabel("Cedula:");
        LCeM.setFont(Fuente);
        LTelM = new JLabel("Telefono:");
        LTelM.setFont(Fuente);
        LCorM = new JLabel("Correo:");
        LCorM.setFont(Fuente);
        LComM = new JLabel("Saldo Anual:");
        LComM.setFont(Fuente);
        LUlM = new JLabel("Ultima Compra:");
        LUlM.setFont(Fuente);
        LSalM = new JLabel("Saldo:");
        LSalM.setFont(Fuente);
        LnroM = new JLabel();
        LnroM.setFont(Fuente);

        TNom1M = new JTextField();
        TNom1M.setFont(Fuente);
        TNom2M = new JTextField();
        TNom2M.setFont(Fuente);
        TApe1M = new JTextField();
        TApe1M.setFont(Fuente);
        TApe2M = new JTextField();
        TApe2M.setFont(Fuente);
        TDirM = new JTextField();
        TDirM.setFont(Fuente);
        TCeM = new JTextField();
        TCeM.setFont(Fuente);
        TTelM = new JTextField();
        TTelM.setFont(Fuente);
        TCorM = new JTextField();
        TCorM.setFont(Fuente);
        TComM = new JTextField();
        TComM.setFont(Fuente);
        TUlM = new JTextField();
        TUlM.setFont(Fuente);
        TSalM = new JTextField();
        TSalM.setFont(Fuente);

        EnvM = new JButton();
        EnvM.setIcon(GuardarN);
        EnvM.setToolTipText("Guardar");
        EnvM.setFont(Fuente);
        BorM = new JButton();
        BorM.setIcon(Borrar);
        BorM.setToolTipText("Borrar");
        BorM.setFont(Fuente);

        MsjModificar.setBounds(500, 5, 350, 50);
        LnroM.setBounds(300, 160, 50, 30);
        LNom1M.setBounds(300, 200, 100, 30);
        TNom1M.setBounds(410, 200, 200, 30);
        LNom2M.setBounds(270, 240, 120, 30);
        TNom2M.setBounds(410, 240, 200, 30);
        LApe1M.setBounds(300, 280, 100, 30);
        TApe1M.setBounds(410, 280, 200, 30);
        LApe2M.setBounds(290, 320, 110, 30);
        TApe2M.setBounds(410, 320, 200, 30);
        LDirM.setBounds(320, 360, 60, 30);
        TDirM.setBounds(410, 360, 200, 30);
        LCeM.setBounds(330, 400, 60, 30);
        TCeM.setBounds(410, 400, 200, 30);
        LTelM.setBounds(650, 220, 60, 30);
        TTelM.setBounds(750, 220, 200, 30);
        LCorM.setBounds(650, 260, 60, 30);
        TCorM.setBounds(750, 260, 200, 30);
        LComM.setBounds(640, 300, 90, 30);
        TComM.setBounds(750, 300, 200, 30);
        LUlM.setBounds(630, 340, 100, 30);
        TUlM.setBounds(750, 340, 200, 30);
        LSalM.setBounds(660, 380, 60, 30);
        TSalM.setBounds(750, 380, 200, 30);

        EnvM.setBounds(600, 440, 50, 50);
        BorM.setBounds(705, 440, 50, 50);

        panel7.add(LNom1M);
        panel7.add(TNom1M);
        panel7.add(LNom2M);
        panel7.add(TNom2M);
        panel7.add(LApe1M);
        panel7.add(TApe1M);
        panel7.add(LApe2M);
        panel7.add(TApe2M);
        panel7.add(LDirM);
        panel7.add(TDirM);
        panel7.add(LCeM);
        panel7.add(TCeM);
        panel7.add(LTelM);
        panel7.add(TTelM);
        panel7.add(LCorM);
        panel7.add(TCorM);
        panel7.add(LComM);
        panel7.add(TComM);
        panel7.add(LUlM);
        panel7.add(TUlM);
        panel7.add(LSalM);
        panel7.add(TSalM);
        panel7.add(LnroM);
        panel7.add(MsjModificar);
        panel7.add(EnvM);
        panel7.add(BorM);

        CampoM.setBounds(500, 70, 150, 40);
        TipoM.setBounds(700, 70, 150, 40);
        BuscarM.setBounds(650, 140, 50, 50);

        panel7.add(CampoM);
        panel7.add(TipoM);
        panel7.add(BuscarM);

/////////////////////////////////////////////////////BUSCAR CLIENTE/////////////////////////////////////////////////////
        CampoBB = new JTextField(50);
        CampoBB.setFont(Fuente);
        MsjBuscar = new JLabel("BUSCAR CLIENTE");
        MsjBuscar.setFont(Fuent);
        TipoBB = new JComboBox();
        TipoBB.addItem("-Seleccione-");
        TipoBB.addItem("Primer Nombre");
        TipoBB.addItem("Primer Apellido");
        TipoBB.addItem("Cedula");

        TipoBB.setFont(Fuente);

        BuscarBB = new JButton();
        BuscarBB.setIcon(RemplazarC);
        BuscarBB.setToolTipText("Buscar");
        BuscarBB.setFont(Fuente);

        ResuBB = new JTextArea();
        ResuBB.setFont(Fuente);
        panelBB = new JScrollPane(ResuBB);

        MsjBuscar.setBounds(500, 5, 350, 50);
        CampoBB.setBounds(470, 70, 150, 40);
        TipoBB.setBounds(630, 70, 150, 40);
        BuscarBB.setBounds(620, 150, 50, 50);
        panelBB.setBounds(500, 210, 300, 160);

        panel8.add(CampoBB);
        panel8.add(TipoBB);
        panel8.add(BuscarBB);
        panel8.add(panelBB);
        panel8.add(MsjBuscar);

///////////////////////////////////////////////////////////////ELIMINAR CLIENTE/////////////////////////////////////////
        CampoE = new JTextField(50);
        CampoE.setFont(Fuente);
        MsjBuscar2 = new JLabel("ELIMINAR CLIENTE");
        MsjBuscar2.setFont(Fuent);
        TipoE = new JComboBox();
        nro = new JLabel();
        TipoE.addItem("-Seleccione-");
        TipoE.addItem("Primer Nombre");
        TipoE.addItem("Primer Apellido");;
        TipoE.addItem("Cedula");

        TipoE.setFont(Fuente);
        BuscarE = new JButton();
        BuscarE.setIcon(RemplazarC);
        BuscarE.setToolTipText("Buscar");
        BuscarE.setFont(Fuente);
        ResuE = new JTextArea();
        ResuE.setFont(Fuente);
        ResuE.setEditable(false);
        panelE = new JScrollPane(ResuE);
        Elim = new JButton();
        Elim.setIcon(Borrar);
        Elim.setToolTipText("Borrar");
        Elim.setFont(Fuente);

        MsjBuscar2.setBounds(500, 5, 350, 50);
        CampoE.setBounds(470, 70, 150, 40);
        TipoE.setBounds(630, 70, 150, 40);
        BuscarE.setBounds(620, 150, 50, 50);
        panelE.setBounds(500, 210, 300, 160);
        Elim.setBounds(620, 390, 50, 50);

        panel9.add(CampoE);
        panel9.add(TipoE);
        panel9.add(BuscarE);
        panel9.add(panelE);
        panel9.add(Elim);
        panel9.add(MsjBuscar2);

        ////////////////////////////////////////////////////////////////////////////////////////USUARIOS/////////////////////////////////////////////////////////////////////////////////////////// 
        crear = new JLabel("Crear Usuario");
        crear.setFont(Fuent);
        borraru = new JLabel("Borrar Usuario");
        borraru.setFont(Fuent);
        usuarioc = new JLabel("Usuario:");
        usuarioc.setFont(f);
        clavec = new JLabel("Clave:");
        clavec.setFont(f);
        usuariob = new JLabel("Usuario:");

        usuariob.setFont(f);

        tusuarioc = new JTextField("");
        tusuarioc.setFont(Fuente);
        tclavec = new JPasswordField("");
        tclavec.setFont(Fuente);
        tusuariob = new JTextField("");
        tusuariob.setFont(Fuente);

        borrarc = new JButton("Crear");
        borrarc.setFont(Fuente);
        borrarb = new JButton("Borrar");
        borrarb.setFont(Fuente);

        crear.setBounds(350, 50, 200, 40);
        borraru.setBounds(600, 50, 250, 40);

        usuarioc.setBounds(400, 100, 80, 40);
        tusuarioc.setBounds(400, 150, 120, 40);
        clavec.setBounds(400, 200, 80, 40);
        tclavec.setBounds(400, 250, 120, 40);
        borrarc.setBounds(400, 300, 100, 40);

        usuariob.setBounds(650, 100, 80, 40);
        tusuariob.setBounds(650, 150, 120, 40);
        borrarb.setBounds(650, 200, 100, 40);

        panel10.add(crear);
        panel10.add(borraru);
        panel10.add(usuarioc);
        panel10.add(clavec);
        panel10.add(usuariob);
        panel10.add(tusuarioc);
        panel10.add(tclavec);
        panel10.add(tusuariob);
        panel10.add(borrarc);
        panel10.add(borrarb);

        ////////////////////////////////////////////////////////////////////////////////////////USUARIOS///////////////////////////////////////////////////////////////////////////////////////////  
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
