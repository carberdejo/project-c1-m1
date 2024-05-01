package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoCantOptima extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantOptim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoCantOptima dialog = new DialogoCantOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoCantOptima() {
		setTitle("Configurar cantidad \u00F3ptima ");
		setBounds(100, 100, 450, 117);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCantOptim = new JLabel("Cantidad Optima de Unidades Vendidas");
		lblCantOptim.setBounds(10, 29, 216, 14);
		contentPanel.add(lblCantOptim);
		
		txtCantOptim = new JTextField();
		txtCantOptim.setBounds(227, 23, 59, 23);
		contentPanel.add(txtCantOptim);
		txtCantOptim.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 41, 89, 23);
		contentPanel.add(btnCancelar);
	}
}

