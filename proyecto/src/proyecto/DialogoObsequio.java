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

public class DialogoObsequio extends JDialog implements ActionListener {
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnAcept;
	private JButton btnCancel;

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
		
		JLabel lblUnidad1 = new JLabel("1 Unidad");
		lblUnidad1.setBounds(10, 24, 103, 14);
		getContentPane().add(lblUnidad1);
		
		JLabel lblUnidad2a5 = new JLabel("2 a 5 Unidades");
		lblUnidad2a5.setBounds(10, 49, 103, 14);
		getContentPane().add(lblUnidad2a5);
		
		JLabel lblUnidad6 = new JLabel("6 a m\u00E1s Unidades");
		lblUnidad6.setBounds(10, 74, 103, 14);
		getContentPane().add(lblUnidad6);
		
		txtObsequio1 = new JTextField();
		txtObsequio1.setBounds(136, 21, 86, 20);
		getContentPane().add(txtObsequio1);
		txtObsequio1.setColumns(10);
		txtObsequio1.setText(Tienda.obsequio1);
		
		txtObsequio2 = new JTextField();
		txtObsequio2.setBounds(136, 46, 86, 20);
		getContentPane().add(txtObsequio2);
		txtObsequio2.setColumns(10);
		txtObsequio2.setText(Tienda.obsequio2);
		
		txtObsequio3 = new JTextField();
		txtObsequio3.setBounds(136, 71, 86, 20);
		getContentPane().add(txtObsequio3);
		txtObsequio3.setColumns(10);
		txtObsequio3.setText(Tienda.obsequio3);
		
		btnAcept = new JButton("Aceptar");
		btnAcept.addActionListener(this);
		btnAcept.setBounds(318, 20, 89, 23);
		getContentPane().add(btnAcept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(318, 49, 89, 23);
		getContentPane().add(btnCancel);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAcept) {
			do_btnAcept_actionPerformed(arg0);
		}
	}
	protected void do_btnAcept_actionPerformed(ActionEvent arg0) {
		//Declarar variables locales
		String nuevoObs1,nuevoObs2,nuevoObs3;
		//Leer datos de entrada
		nuevoObs1 = txtObsequio1.getText();
		nuevoObs2 = txtObsequio2.getText();
		nuevoObs3 = txtObsequio3.getText();
		//asignar nuevos valores
		Tienda.obsequio1 = nuevoObs1;
		Tienda.obsequio2 = nuevoObs2;
		Tienda.obsequio3 = nuevoObs3;
	}
	protected void do_btnCancel_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
