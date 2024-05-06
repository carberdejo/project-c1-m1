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

public class DialogoDescuento extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JButton btnAceptar;
	private JButton btnCancelar;

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
			txtPorcentaje1 = new JTextField();
			txtPorcentaje1.setBounds(126, 20, 86, 20);
			contentPanel.add(txtPorcentaje1);
			txtPorcentaje1.setColumns(10);
			txtPorcentaje1.setText(String.valueOf(Tienda.porcentaje1));
		}
		{
			txtPorcentaje2 = new JTextField();
			txtPorcentaje2.setBounds(126, 45, 86, 20);
			contentPanel.add(txtPorcentaje2);
			txtPorcentaje2.setColumns(10);
			txtPorcentaje2.setText(String.valueOf(Tienda.porcentaje2));
		}
		{
			txtPorcentaje3 = new JTextField();
			txtPorcentaje3.setBounds(126, 68, 86, 20);
			contentPanel.add(txtPorcentaje3);
			txtPorcentaje3.setColumns(10);
			txtPorcentaje3.setText(String.valueOf(Tienda.porcentaje3));
		}
		{
			txtPorcentaje4 = new JTextField();
			txtPorcentaje4.setBounds(126, 93, 86, 20);
			contentPanel.add(txtPorcentaje4);
			txtPorcentaje4.setColumns(10);
			txtPorcentaje4.setText(String.valueOf(Tienda.porcentaje4));
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 19, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 44, 89, 23);
			contentPanel.add(btnCancelar);
		}
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
		//Declarar variables locales
		String nuevoPor1,nuevoPor2,nuevoPor3,nuevoPor4;
		//Leer datos de entrada
		nuevoPor1 = txtPorcentaje1.getText();
		nuevoPor2 = txtPorcentaje2.getText();
		nuevoPor3 = txtPorcentaje3.getText();
		nuevoPor4 = txtPorcentaje4.getText();
		//Asignar nuevos valores
		Tienda.porcentaje1 = Double.valueOf(nuevoPor1);
		Tienda.porcentaje2 = Double.valueOf(nuevoPor2);
		Tienda.porcentaje3 = Double.valueOf(nuevoPor3);
		Tienda.porcentaje4 = Double.valueOf(nuevoPor4);


	}
	protected void do_btnCancelar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
