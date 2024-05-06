package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoCantOptima extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantOptim;
	private JButton btnAceptar;
	private JButton btnCancelar;

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
		txtCantOptim.setText(String.valueOf(Tienda.cantidadOptima));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 41, 89, 23);
		contentPanel.add(btnCancelar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(arg0);
		}
	}
	protected void do_btnAceptar_actionPerformed(ActionEvent arg0) {
		//declaracion de variables
		String nuevoPrec;
		//Leer datos de entrada
		nuevoPrec=this.txtCantOptim.getText();
		//Asignar nuevo valor
		Tienda.cantidadOptima = Integer.valueOf(nuevoPrec);
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}

