package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoDescuento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoDescuento dialog = new DialogoDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoDescuento() {
		setTitle("Configurar porcentajes de descuentos");
		setBounds(100, 100, 450, 162);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblUni1_5 = new JLabel("1 a 5 unidades");
			lblUni1_5.setBounds(10, 23, 94, 14);
			contentPanel.add(lblUni1_5);
		}
		{
			JLabel lblUni6_10 = new JLabel("6 a 10 unidades");
			lblUni6_10.setBounds(10, 48, 94, 14);
			contentPanel.add(lblUni6_10);
		}
		{
			JLabel lblUni11_15 = new JLabel("11 a 15 unidades");
			lblUni11_15.setBounds(10, 71, 94, 14);
			contentPanel.add(lblUni11_15);
		}
		{
			JLabel lblUni15 = new JLabel("Mas de 15 unidades");
			lblUni15.setBounds(10, 96, 106, 14);
			contentPanel.add(lblUni15);
		}
		{
			textField = new JTextField();
			textField.setBounds(126, 20, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(126, 45, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(126, 68, 86, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(126, 93, 86, 20);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(335, 19, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(335, 44, 89, 23);
			contentPanel.add(btnCancelar);
		}
	}

}
