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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class DialogoVender extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox cboModelo;
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
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(134, 8, 140, 20);
		contentPanel.add(cboModelo);
		{
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(134, 33, 140, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(134, 58, 140, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(335, 7, 89, 23);
		contentPanel.add(btnVender);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(335, 32, 89, 23);
		contentPanel.add(btnCerrar);
	}
		
		JScrollPane scpPane = new JScrollPane();
		scpPane.setBounds(10, 93, 414, 167);
		contentPanel.add(scpPane);
		
		JTextArea txtS = new JTextArea();
		scpPane.setViewportView(txtS);
}
}