package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAcercaDe extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAcercaDe dialog = new DialogoAcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAcercaDe() {
		setTitle("Acerda De");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblVersion = new JLabel("Tienda 1.0");
			lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
			lblVersion.setFont(new Font("Castellar", Font.BOLD, 18));
			lblVersion.setBounds(134, 26, 149, 14);
			contentPanel.add(lblVersion);
		}
		{
			JLabel lblAutor = new JLabel("Hecho por \r\nCarlos B,Aroon,Cristhian C,Frank,Mathew");
			lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutor.setFont(new Font("Magneto", Font.PLAIN, 14));
			lblAutor.setBounds(10, 61, 414, 52);
			contentPanel.add(lblAutor);
		}
		{
			JLabel lblAnho = new JLabel("2024");
			lblAnho.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnho.setFont(new Font("Consolas", Font.BOLD, 30));
			lblAnho.setBounds(167, 112, 96, 36);
			contentPanel.add(lblAnho);
		}
		{
			JLabel lblLugar = new JLabel("SJL, Lima, Peru");
			lblLugar.setBounds(180, 159, 83, 14);
			contentPanel.add(lblLugar);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(174, 211, 89, 23);
			contentPanel.add(btnCerrar);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			btnCerrarActionPerformed(e);
		}
	}
	protected void btnCerrarActionPerformed(ActionEvent e) {
		dispose();

	}
}
