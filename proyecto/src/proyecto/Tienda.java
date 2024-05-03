package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Tienda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntSalir;
	private JMenuItem mntConsultar;
	private JMenuItem mntListar;
	private JMenuItem mntAcercaDe;
	private JMenu mnuConfiguracion;
	private JMenu mnuVentas;
	private JMenuItem mntConfObsequio;
	private JMenuItem mntCantOptim;
	private JMenuItem mntCuoDiaria;
	private JMenuItem mntVender;
	private JMenuItem mntGenRepor;
	private JMenuItem mntModificar;
	private JMenuItem mntConfDscto;

	//DEclaracion de variables globales
	// Datos mínimos de la primera cocina
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	// Datos mínimos de la segunda cocina
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	// Datos mínimos de la tercera cocina
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	// Datos mínimos de la cuarta cocina
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	// Datos mínimos de la quinta cocina
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 30;
	// Cuota diaria
	public static double cuotaDiaria = 75000;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		
		JMenuBar mnbBar = new JMenuBar();
		setJMenuBar(mnbBar);
		
		JMenu mnuArchivo = new JMenu("Archivo");
		mnbBar.add(mnuArchivo);
		
		mntSalir = new JMenuItem("Salir");
		mntSalir.addActionListener(this);
		mnuArchivo.add(mntSalir);
		
		JMenu mnuMantenimiento = new JMenu("Mantenimiento");
		mnbBar.add(mnuMantenimiento);
		
		mntConsultar = new JMenuItem("Consultar cocina");
		mntConsultar.addActionListener(this);
		mnuMantenimiento.add(mntConsultar);
		
		mntListar = new JMenuItem("Listar cocina");
		mntListar.addActionListener(this);
		
		mntModificar = new JMenuItem("Modificar cocina");
		mntModificar.addActionListener(this);
		mnuMantenimiento.add(mntModificar);
		mnuMantenimiento.add(mntListar);
		
		mnuVentas = new JMenu("Ventas");
		mnbBar.add(mnuVentas);
		
		mntVender = new JMenuItem("Vender");
		mntVender.addActionListener(this);
		mnuVentas.add(mntVender);
		
		mntGenRepor = new JMenuItem("Generar reportes");
		mntGenRepor.addActionListener(this);
		mnuVentas.add(mntGenRepor);
		
		mnuConfiguracion = new JMenu("Configuracion");
		mnbBar.add(mnuConfiguracion);
		
		mntConfObsequio = new JMenuItem("Configurar obsequio");
		mntConfObsequio.addActionListener(this);
		
		mntConfDscto = new JMenuItem("Configurar descuento");
		mntConfDscto.addActionListener(this);
		mnuConfiguracion.add(mntConfDscto);
		mnuConfiguracion.add(mntConfObsequio);
		
		mntCantOptim = new JMenuItem("Configurar cantidad optima");
		mntCantOptim.addActionListener(this);
		mnuConfiguracion.add(mntCantOptim);
		
		mntCuoDiaria = new JMenuItem("Configurar cuota diaria");
		mntCuoDiaria.addActionListener(this);
		mnuConfiguracion.add(mntCuoDiaria);
		
		JMenu mnuAyuda = new JMenu("Ayuda");
		mnbBar.add(mnuAyuda);
		
		mntAcercaDe = new JMenuItem("Acerca De");
		mntAcercaDe.addActionListener(this);
		mnuAyuda.add(mntAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntConfDscto) {
			do_mntConfDscto_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntModificar) {
			do_mntModificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntGenRepor) {
			do_mntGenRepor_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntVender) {
			do_mntVender_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntCuoDiaria) {
			do_mntCuoDiaria_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntCantOptim) {
			do_mntCantOptim_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntConfObsequio) {
			do_mntConfObsequio_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntAcercaDe) {
			mntAcercaDeActionPerformed(arg0);
		}
		if (arg0.getSource() == mntListar) {
			mntListarActionPerformed(arg0);
		}
		if (arg0.getSource() == mntConsultar) {
			mntConsultarActionPerformed(arg0);
		}
		if (arg0.getSource() == mntSalir) {
			mntSalirActionPerformed(arg0);
		}
	}
	protected void mntSalirActionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
	protected void mntConsultarActionPerformed(ActionEvent arg0) {
		DialogoConsultar dialogoCon=new DialogoConsultar();
		dialogoCon.setLocationRelativeTo(this);
		dialogoCon.setVisible(true);
	
	}
	protected void mntListarActionPerformed(ActionEvent arg0) {
		DialogoListar dialogoLis=new DialogoListar();
		dialogoLis.setLocationRelativeTo(this);
		dialogoLis.setVisible(true);
	}
	protected void mntAcercaDeActionPerformed(ActionEvent arg0) {
		DialogoAcercaDe dialogoAD=new DialogoAcercaDe();
		dialogoAD.setLocationRelativeTo(this);
		dialogoAD.setVisible(true);
	}
	protected void do_mntConfObsequio_actionPerformed(ActionEvent arg0) {
		DialogoObsequio  dialogoCO=new DialogoObsequio();
		dialogoCO.setLocationRelativeTo(this);
		dialogoCO.setVisible(true); 
}
	protected void do_mntCantOptim_actionPerformed(ActionEvent arg0) {
		DialogoCantOptima  dialogoCOPTI=new DialogoCantOptima();
		dialogoCOPTI.setLocationRelativeTo(this);
		dialogoCOPTI.setVisible(true); 
}
	protected void do_mntCuoDiaria_actionPerformed(ActionEvent arg0) {
		DialogoCuotDiaria  dialogoCD=new DialogoCuotDiaria();
		dialogoCD.setLocationRelativeTo(this);
		dialogoCD.setVisible(true); 
	}
	protected void do_mntVender_actionPerformed(ActionEvent arg0) {
		DialogoVender  dialogoVEN=new DialogoVender();
		dialogoVEN.setLocationRelativeTo(this);
		dialogoVEN.setVisible(true); 
	}
	protected void do_mntGenRepor_actionPerformed(ActionEvent arg0) {
		DialogoGenReportes  dialogoREP=new DialogoGenReportes();
		dialogoREP.setLocationRelativeTo(this);
		dialogoREP.setVisible(true); 
		
	}
	protected void do_mntModificar_actionPerformed(ActionEvent arg0) {
		DialogoModificar  dialogoMOD=new DialogoModificar();
		dialogoMOD.setLocationRelativeTo(this);
		dialogoMOD.setVisible(true); 
	}
	protected void do_mntConfDscto_actionPerformed(ActionEvent arg0) {
		DialogoDescuento  dialogoDSCTO=new DialogoDescuento();
		dialogoDSCTO.setLocationRelativeTo(this);
		dialogoDSCTO.setVisible(true); 
	}
	
	}

