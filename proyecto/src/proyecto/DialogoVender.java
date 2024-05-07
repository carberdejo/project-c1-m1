package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoVender extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox cboModelo;
	private JButton btnVender;
	private JTextArea txtS;
	
	//Declaracion de variables publicas
	public static int TotalCant0;
	public static int TotalCant1;
	public static int TotalCant2;
	public static int TotalCant3;
	public static int TotalCant4;
	public static int TotalVent0;
	public static int TotalVent1;
	public static int TotalVent2;
	public static int TotalVent3;
	public static int TotalVent4;
	public static double impTotal0;
	public static double impTotal1;
	public static double impTotal2;
	public static double impTotal3;
	public static double impTotal4;
	public static int modelo;
	public static int totalCV = 0;
	
	//Declaracion de variables globales
	
	double totalIC;
	private JButton btnCerrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoVender dialog = new DialogoVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoVender() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Vender");
		setBounds(100, 100, 450, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 86, 14);
		contentPanel.add(lblModelo);
		
		JLabel lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 36, 86, 14);
		contentPanel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 61, 86, 14);
		contentPanel.add(lblCantidad);
		
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(134, 8, 140, 20);
		contentPanel.add(cboModelo);
		{
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(134, 33, 140, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setText(String.valueOf(this.getPrecio(this.getModelo())));

		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(134, 58, 140, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(335, 7, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 32, 89, 23);
		contentPanel.add(btnCerrar);
	}
		
		JScrollPane scpPane = new JScrollPane();
		scpPane.setBounds(10, 93, 414, 167);
		contentPanel.add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnVender) {
			do_btnVender_actionPerformed(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			do_cboModelo_actionPerformed(arg0);
		}
	}
	
	//Metodo combo box
	protected void do_cboModelo_actionPerformed(ActionEvent arg0) {
		//Leer datos de entrada
		modelo = getModelo();
		double comPrecio = getPrecio(modelo);
		txtPrecio.setText(String.valueOf(comPrecio));
	}
	int getModelo(){
		return cboModelo.getSelectedIndex();
	}
	double getPrecio(int modelo){
		switch(modelo){
		case 0: return Tienda.precio0;
		case 1: return Tienda.precio1;
		case 2: return Tienda.precio2;
		case 3: return Tienda.precio3;
		default: return Tienda.precio4;		
		}
	}
	//boton procesar
	protected void do_btnVender_actionPerformed(ActionEvent arg0) {
		try {
			//Delcaracion de variables
			int cantidad;
			double iCompra,iDscto,iPagar;
			String obsequio,tipoModelo;
			
			//Leer datos de entrada
			cantidad=getCantidad();
			double precio = Double.valueOf(this.txtPrecio.getText());
			
			//Proceso de calculo
			iCompra=calcularIC(modelo,cantidad);
			iDscto=calcularID(iCompra,cantidad);
			iPagar=calcularIP(iCompra,iDscto);
			obsequio=calcularOb(cantidad);
			tipoModelo=calcularTP(modelo);
			//Calcular acumulador
			incrementadorAcum(modelo,cantidad,iCompra);
			//Advertencia
			
			//Mostrar resultado
			System.out.println(cantidad);
			System.out.println(precio);
			
			totalCV++;
			totalIC+=iCompra;
			double porcetCuotDia=100*totalIC/Tienda.cuotaDiaria;
			System.out.println(porcetCuotDia);
			mostrarResultados(tipoModelo,precio,cantidad,iCompra,iDscto,iPagar,obsequio);
			
			if(this.totalCV %5 == 0){
				JOptionPane.showMessageDialog(null, "Venta numero  "+totalCV+"\nImporte Total general acumulado :  "+totalIC+"\nPorcentaje de la cuota diaria :"+porcetCuotDia+"%", "Advertencia", JOptionPane.WARNING_MESSAGE);			
			}
		} catch (Exception e) {
			
	        JOptionPane.showMessageDialog(null, "¡Cuidado! Necesitas llenar correctamente todos los inputs.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	int getCantidad(){
		return Integer.parseInt(txtCantidad.getText());
	}
	
	//calcular icompra
	double calcularIC(int modelo,int cantidad){
		switch(modelo){
			case 0: return Tienda.precio0*cantidad;
			case 1: return Tienda.precio1*cantidad;
			case 2: return Tienda.precio2*cantidad;
			case 3: return Tienda.precio3*cantidad;
			default: return Tienda.precio4*cantidad;
		}
	}
	
	//Calcular descuento
	double calcularID(double iCompra,int cantidad){
		if(cantidad<=5)
			return iCompra*Tienda.porcentaje1/100;
		else if(cantidad<=10)
			return iCompra*Tienda.porcentaje2/100;
		else if(cantidad<=15)
			return iCompra*Tienda.porcentaje3/100;
		else
			return iCompra*Tienda.porcentaje4/100;
			
	}
	//Calcular iPagar
	double calcularIP(double iCompra,double iDscto){
		return iCompra-iDscto;
	}
	//Calcular obsequio
	String calcularOb(int cantidad){
		if(cantidad==1)
			return Tienda.obsequio1;
		else if(cantidad<=5)
			return Tienda.obsequio2;
		else
			return Tienda.obsequio3;
	}
	
	
	
	//calcularTipo de Modelo
	String calcularTP(int modelo){
		switch(modelo){
			case 0: return Tienda.modelo0;
			case 1: return Tienda.modelo1;
			case 2: return Tienda.modelo2;
			case 3: return Tienda.modelo3;
			default: return Tienda.modelo4;
		}
	}
	//Contador y acumulador del Total de ventas,total de cantidades y total de importe
	
	void incrementadorAcum(int modelo,int cantidad,double iCompra){
		switch(modelo){
		case 0: TotalVent0++;
		 		TotalCant0+=cantidad;  //CantTotal=CantTotal+cantidad
				impTotal0+=iCompra;
				break;
		case 1: TotalVent1++;
				TotalCant1+=cantidad;
				impTotal1+=iCompra;
				break;
		case 2: TotalVent2++;
				TotalCant2+=cantidad;
				impTotal2+=iCompra;
				break;
		case 3: TotalVent3++;
				TotalCant3+=cantidad;
				impTotal3+=iCompra;
				break;
		default:TotalVent4++;
		  		TotalCant4+=cantidad;
		  		impTotal4+=iCompra;		
		}
	}
	
	void mostrarResultados(String tipoModelo,double precio,int cantidad,double iCompra,double iDscto,double iPagar,String obsequio){
		txtS.setText("");
		imprimir("Modelo : /S. "+tipoModelo);
		imprimir("Precio : /S. "+precio);
		imprimir("Cantidad : /S. "+cantidad);
		imprimir("Importe compra : /S. "+iCompra);
		imprimir("Importe de descuento : /S. "+iDscto);
		imprimir("Importe a pagar : /S. "+iPagar);
		imprimir("Obsequio : "+obsequio);
	}
	void imprimir(String texto){
		txtS.append(texto+'\n');
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}