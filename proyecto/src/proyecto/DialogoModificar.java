package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DialogoModificar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtPrecio;
	private JButton btnCerrar;
	private JTextField txtFondo;
	private JTextField txtQuemadores;

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
		
		JComboBox cboCodigo = new JComboBox();
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboCodigo.setBounds(105, 11, 155, 20);
		contentPanel.add(cboCodigo);
		
		txtTitulo = new JTextField();
		txtTitulo.addActionListener(this);
		txtTitulo.setBounds(105, 49, 155, 20);
		contentPanel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(105, 74, 155, 20);
		contentPanel.add(txtAutor);
		txtAutor.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(105, 99, 155, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		
		txtFondo = new JTextField();
		txtFondo.setBounds(105, 124, 155, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setBounds(105, 147, 155, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);
		btnCerrar.setBounds(335, 10, 89, 23);
		contentPanel.add(btnCerrar);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(335, 43, 89, 23);
		contentPanel.add(btnGrabar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == txtTitulo) {
			do_txtTitulo_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			btnCerrarActionPerformed(arg0);
		}
	}
	protected void btnCerrarActionPerformed(ActionEvent arg0) {
		dispose();
	}
	protected void do_txtTitulo_actionPerformed(ActionEvent arg0) {
		
		
		
		
		
	}
}
