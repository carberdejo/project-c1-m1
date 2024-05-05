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

public class DialogoCuotDiaria extends JDialog implements ActionListener {

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
	public DialogoCuotDiaria() {
		setTitle("Configurar cantidad \u00F3ptima ");
		setBounds(100, 100, 450, 117);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCantOptim = new JLabel("Cuota diaria esperada (S/.)");
		lblCantOptim.setBounds(10, 29, 155, 14);
		contentPanel.add(lblCantOptim);
		
		txtCantOptim = new JTextField();
		txtCantOptim.setBounds(159, 23, 127, 23);
		contentPanel.add(txtCantOptim);
		txtCantOptim.setColumns(10);
		numeroCO();
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 44, 89, 23);
		contentPanel.add(btnCancelar);
	}
	void numeroCO(){
		this.txtCantOptim.setText(String.valueOf(Tienda.cuotaDiaria));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(e);
		}
	}
	protected void do_btnAceptar_actionPerformed(ActionEvent e) {
		String newPrecio = this.txtCantOptim.getText();
		Tienda.cuotaDiaria = Double.valueOf(newPrecio);
		System.out.println(Tienda.cuotaDiaria);
		//Tienda.cuotaDiaria=Integer.parseInt(txtCantOptim.getText());
	}
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		dispose();
	}
}


