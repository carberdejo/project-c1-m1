package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoListar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JButton btnListar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoListar dialog = new DialogoListar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoListar() {
		setTitle("Listar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(135, 227, 89, 23);
			contentPanel.add(btnListar);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(238, 227, 89, 23);
			contentPanel.add(btnCerrar);
		}
		
		JScrollPane scpPane = new JScrollPane();
		scpPane.setBounds(10, 11, 414, 199);
		contentPanel.add(scpPane);
		
		 txtS = new JTextArea();
		scpPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			btnCerrarActionPerformed(e);
		}
	}
	protected void btnCerrarActionPerformed(ActionEvent e) {
		dispose();

	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		mostrarResultados();	
	}
	void mostrarResultados(){

        txtS.setText("");
        imprimir("LISTADO DE COCINAS");
        imprimir("Modeo\t:"+Tienda.modelo0);
        imprimir("Precio\t:"+Tienda.precio0);
        imprimir("Ancho\t:"+Tienda.ancho0);
        imprimir("Alto\t:"+Tienda.alto0);
        imprimir("Fondo\t:"+Tienda.fondo0);
        imprimir("Quemadores'\t:"+Tienda.quemadores0);


        imprimir("Modeo\t:"+Tienda.modelo1);
        imprimir("Precio\t:"+Tienda.precio1);
        imprimir("Ancho\t:"+Tienda.ancho1);
        imprimir("Alto\t:"+Tienda.alto1);
        imprimir("Fondo\t:"+Tienda.fondo1);
        imprimir("Quemadores'\t:"+Tienda.quemadores1);

        imprimir("Modeo\t:"+Tienda.modelo2);
        imprimir("Precio\t:"+Tienda.precio2);
        imprimir("Ancho\t:"+Tienda.ancho2);
        imprimir("Alto\t:"+Tienda.alto2);
        imprimir("Fondo\t:"+Tienda.fondo2);
        imprimir("Quemadores'\t:"+Tienda.quemadores2);

        imprimir("Modeo\t:"+Tienda.modelo3);
        imprimir("Precio\t:"+Tienda.precio3);
        imprimir("Ancho\t:"+Tienda.ancho3);
        imprimir("Alto\t:"+Tienda.alto3);
        imprimir("Fondo\t:"+Tienda.fondo3);
        imprimir("Quemadores'\t:"+Tienda.quemadores3);

        imprimir("Modeo\t:"+Tienda.modelo4);
        imprimir("Precio\t:"+Tienda.precio4);
        imprimir("Ancho\t:"+Tienda.ancho4);
        imprimir("Alto\t:"+Tienda.alto4);
        imprimir("Fondo\t:"+Tienda.fondo4);
        imprimir("Quemadores'\t:"+Tienda.quemadores4);


    }
    void imprimir(String texto){
        txtS.append(texto+'\n');
  }
}
