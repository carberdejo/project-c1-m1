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
import java.awt.Color;

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
			lblVersion.setFont(new Font("Dubai Medium", Font.BOLD, 30));
			lblVersion.setBounds(116, 11, 193, 36);
			contentPanel.add(lblVersion);
		}
		{
			JLabel lblAnho = new JLabel("2024");
			lblAnho.setForeground(Color.BLACK);
			lblAnho.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnho.setFont(new Font("Consolas", Font.BOLD, 30));
			lblAnho.setBounds(168, 164, 96, 36);
			contentPanel.add(lblAnho);
		}
		{
			JLabel lblLugar = new JLabel("SJL, Lima, Peru");
			lblLugar.setHorizontalAlignment(SwingConstants.CENTER);
			lblLugar.setBounds(148, 203, 135, 14);
			contentPanel.add(lblLugar);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setBackground(Color.LIGHT_GRAY);
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(174, 221, 89, 23);
			contentPanel.add(btnCerrar);
		}
		
		JLabel lblA = new JLabel("Autores");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblA.setBounds(198, 46, 46, 14);
		contentPanel.add(lblA);
		
		JLabel lblPersona = new JLabel("Cristhian  Cotrina Huaman");
		lblPersona.setForeground(Color.DARK_GRAY);
		lblPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersona.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		lblPersona.setBounds(0, 71, 214, 14);
		contentPanel.add(lblPersona);
		
		JLabel lblNewLabel = new JLabel("Carlos Berdejo Pareja");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(234, 71, 174, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aaron Jorge Ram\u00EDrez");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 96, 178, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Frank Antony Martel P\u00E9rez");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(234, 98, 174, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblRamirezYauriKevin = new JLabel("Ramirez Yauri Kevin");
		lblRamirezYauriKevin.setForeground(Color.DARK_GRAY);
		lblRamirezYauriKevin.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 13));
		lblRamirezYauriKevin.setHorizontalAlignment(SwingConstants.CENTER);
		lblRamirezYauriKevin.setBounds(116, 127, 193, 14);
		contentPanel.add(lblRamirezYauriKevin);
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
