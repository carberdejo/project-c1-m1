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
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DialogoModificar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JButton btnCerrar;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JComboBox cboCodigo;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConsultar dialog = new DialogoConsultar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoModificar() {
		setTitle("Modificar Cocina");
		setBounds(100, 100, 450, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(10, 14, 65, 14);
		contentPanel.add(lblModelo);
		
		JLabel lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 52, 65, 14);
		contentPanel.add(lblPrecio);
		
		JLabel lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 77, 65, 14);
		contentPanel.add(lblAncho);
		
		JLabel lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 102, 65, 14);
		contentPanel.add(lblAlto);
		
		JLabel lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 127, 65, 14);
		contentPanel.add(lblFondo);
		
		JLabel lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 150, 65, 14);
		contentPanel.add(lblQuemadores);
		
		cboCodigo = new JComboBox();
		cboCodigo.addActionListener(this);
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboCodigo.setBounds(105, 11, 155, 20);
		contentPanel.add(cboCodigo);
		
		txtPrecio = new JTextField();
		txtPrecio.addActionListener(this);
		txtPrecio.setBounds(105, 49, 155, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setText(String.valueOf(this.getPrecio(this.getModelo())));

		
		txtAncho = new JTextField();
		txtAncho.setBounds(105, 74, 155, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		txtAncho.setText(String.valueOf(this.getAncho(this.getModelo())));

		
		txtAlto = new JTextField();
		txtAlto.setBounds(105, 99, 155, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);
		txtAlto.setText(String.valueOf(this.getAlto(this.getModelo())));

		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		
		txtFondo = new JTextField();
		txtFondo.setBounds(105, 124, 155, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);
		txtFondo.setText(String.valueOf(this.getFondo(this.getModelo())));

		
		txtQuemadores = new JTextField();
		txtQuemadores.setBounds(105, 147, 155, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);
		txtQuemadores.setText(String.valueOf(this.getQuemadores(this.getModelo())));

		btnCerrar.setBounds(335, 10, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(335, 43, 89, 23);
		contentPanel.add(btnGrabar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGrabar) {
			do_btnGrabar_actionPerformed(arg0);
		}
		if (arg0.getSource() == cboCodigo) {
			do_cboCodigo_actionPerformed(arg0);
		}
		
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
	}
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		dispose();
	}
	
	protected void do_cboCodigo_actionPerformed(ActionEvent arg0) {
		//Declaracion y leer datos
		int modelo = getModelo();
		double precio = getPrecio(modelo);
		double ancho = getAncho(modelo);
		double alto = getAlto(modelo);
		double fondo = getFondo(modelo);
		int quemadores = getQuemadores(modelo);
		
		//Devolver valor a la caja de texto
		this.txtPrecio.setText(String.valueOf(precio));
		this.txtAncho.setText(String.valueOf(ancho));
		this.txtAlto.setText(String.valueOf(alto));
		this.txtFondo.setText(String.valueOf(fondo));
		this.txtQuemadores.setText(String.valueOf(quemadores));
	}
	
	int getModelo(){
		return cboCodigo.getSelectedIndex();
	}
	
	// Asignar valores a la caja de texto
	double getPrecio(int modelo){
		switch(modelo){
		case 0: return Tienda.precio0;
		case 1: return Tienda.precio1;
		case 2: return Tienda.precio2;
		case 3: return Tienda.precio3;
		default: return Tienda.precio4;		
		}
	}
	double getAncho(int modelo){
		switch(modelo){
		case 0: return Tienda.ancho0;
		case 1: return Tienda.ancho1;
		case 2: return Tienda.ancho2;
		case 3: return Tienda.ancho3;
		default: return Tienda.ancho4;		
		}
	}
	double getAlto(int modelo){
		switch(modelo){
		case 0: return Tienda.alto0;
		case 1: return Tienda.alto1;
		case 2: return Tienda.alto2;
		case 3: return Tienda.alto3;
		default: return Tienda.alto4;
		}
	}
	double getFondo(int modelo){
		switch(modelo){
		case 0: return Tienda.fondo0;
		case 1: return Tienda.fondo1;
		case 2: return Tienda.fondo2;
		case 3: return Tienda.fondo3;
		default: return Tienda.fondo4;
		}
	}
	int getQuemadores(int modelo){
		switch(modelo){
		case 0: return Tienda.quemadores0;
		case 1: return Tienda.quemadores1;
		case 2: return Tienda.quemadores2;
		case 3: return Tienda.quemadores3;
		default: return Tienda.quemadores4;
		}
	}
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		try {
			
		//Declarar Variables
		String newPrice,newAlto,newAncho,newFondo,newQuemadores;
		int index;
		//Leer datos de entrada
		newPrice = this.txtPrecio.getText();
		newAlto = this.txtAlto.getText();
		newAncho = this.txtAncho.getText();
		newFondo = this.txtFondo.getText();
		newQuemadores = this.txtQuemadores.getText();
		index = this.cboCodigo.getSelectedIndex();
		
		System.out.println(newPrice);
		System.out.println(index);
		//PROCESO DE CALCULO
		switch (index) {
		case 0:
			Tienda.precio0 = Double.valueOf(newPrice);
			Tienda.alto0 = Double.valueOf(newAlto);
			Tienda.ancho0 = Double.valueOf(newAncho);
			Tienda.fondo0 = Double.valueOf(newFondo);
			Tienda.quemadores0 = Integer.valueOf(newQuemadores);
			break;
		case 1:
			Tienda.precio1 = Double.valueOf(newPrice);
			Tienda.alto1 = Double.valueOf(newAlto);
			Tienda.ancho1 = Double.valueOf(newAncho);
			Tienda.fondo1 = Double.valueOf(newFondo);
			Tienda.quemadores1 = Integer.valueOf(newQuemadores);
			break;
		case 2:
			Tienda.precio2 = Double.valueOf(newPrice);
			Tienda.alto2 = Double.valueOf(newAlto);
			Tienda.ancho2 = Double.valueOf(newAncho);
			Tienda.fondo2 = Double.valueOf(newFondo);
			Tienda.quemadores2 = Integer.valueOf(newQuemadores);
			break;
		case 3:
			Tienda.precio3 = Double.valueOf(newPrice);
			Tienda.alto3 = Double.valueOf(newAlto);
			Tienda.ancho3 = Double.valueOf(newAncho);
			Tienda.fondo3 = Double.valueOf(newFondo);
			Tienda.quemadores3 = Integer.valueOf(newQuemadores);
			break;
		default:
			Tienda.precio4 = Double.valueOf(newPrice);
			Tienda.alto4 = Double.valueOf(newAlto);
			Tienda.ancho4 = Double.valueOf(newAncho);
			Tienda.fondo4 = Double.valueOf(newFondo);
			Tienda.quemadores4 = Integer.valueOf(newQuemadores);
			}
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "¡Cuidado! Necesitas llenar correctamente todos los inputs.", "Advertencia", JOptionPane.WARNING_MESSAGE);		}
	}
}		

