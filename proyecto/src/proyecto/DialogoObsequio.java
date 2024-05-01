package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoObsequio extends JDialog {
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoObsequio dialog = new DialogoObsequio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoObsequio() {
		setTitle("Configurar Obsequio");
		setBounds(100, 100, 450, 154);
		getContentPane().setLayout(null);
		
		JLabel lblUni_1 = new JLabel("1 Unidad");
		lblUni_1.setBounds(10, 24, 103, 14);
		getContentPane().add(lblUni_1);
		
		JLabel lblUni2a5 = new JLabel("2 a 5 Unidades");
		lblUni2a5.setBounds(10, 49, 103, 14);
		getContentPane().add(lblUni2a5);
		
		JLabel lblUni6 = new JLabel("6 a m\u00E1s Unidades");
		lblUni6.setBounds(10, 74, 103, 14);
		getContentPane().add(lblUni6);
		
		txtObsequio1 = new JTextField();
		txtObsequio1.setText("Cafetera");
		txtObsequio1.setBounds(136, 21, 86, 20);
		getContentPane().add(txtObsequio1);
		txtObsequio1.setColumns(10);
		
		txtObsequio2 = new JTextField();
		txtObsequio2.setText("Licuadora");
		txtObsequio2.setBounds(136, 46, 86, 20);
		getContentPane().add(txtObsequio2);
		txtObsequio2.setColumns(10);
		
		txtObsequio3 = new JTextField();
		txtObsequio3.setText("Extractor");
		txtObsequio3.setBounds(136, 71, 86, 20);
		getContentPane().add(txtObsequio3);
		txtObsequio3.setColumns(10);
		
		JButton btnAcept = new JButton("Aceptar");
		btnAcept.setBounds(318, 20, 89, 23);
		getContentPane().add(btnAcept);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(318, 49, 89, 23);
		getContentPane().add(btnCancel);
	}
}
