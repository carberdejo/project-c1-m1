package proyecto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoGenReportes extends JDialog implements ActionListener {
	private JComboBox cboTipo;
	private JTextArea txtS;

	String ventModel,ventOptima,precProm,promMayMen,tipReporte;
	private JButton btnCerrar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoGenReportes dialog = new DialogoGenReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoGenReportes() {
		setBounds(100, 100, 520, 300);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDeReporte = new JLabel("Tipo de reporte ");
		lblTipoDeReporte.setBounds(10, 11, 89, 14);
		getContentPane().add(lblTipoDeReporte);
		
		cboTipo = new JComboBox();
		cboTipo.addActionListener(this);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima", "Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores"}));
		cboTipo.setBounds(109, 8, 227, 20);
		getContentPane().add(cboTipo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(381, 7, 89, 23);
		getContentPane().add(btnCerrar);
		
		JScrollPane scpPane = new JScrollPane();
		scpPane.setBounds(10, 50, 484, 200);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		mostrarReporte1();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == cboTipo) {
			do_cboTipo_actionPerformed(arg0);
		}
	}
	protected void do_cboTipo_actionPerformed(ActionEvent arg0) {
		//Declaracion de variables
		int tipo;
		
		//Leer datos de entrada
		mostrarReporte1();
		mostrarReporte2();
		mostrarReporte3();
		mostrarReporte4();
		tipo = getTipo();
		
		//calcular y mostrar Resultado
		switch (tipo) {
		case 0:
			mostrarReporte1();			
			break;
		case 1:
			mostrarReporte2();					
			break;
		case 2:
			mostrarReporte3();			
			break;
		default:
			mostrarReporte4();			
		}
	}
	int getTipo(){
		return cboTipo.getSelectedIndex();
	}
	
	
	void mostrarReporte1(){
		txtS.setText("");
		txtS.append("VENTAS POR MODELO"+'\n');
		txtS.append("Modelo : "+Tienda.modelo0+'\n');
		txtS.append("Cantidad de ventas : "+DialogoVender.TotalVent0+'\n');
		txtS.append("Cantidad de unidades vendidas : "+DialogoVender.TotalVent1+'\n');
		txtS.append("Importe total vendido : "+DialogoVender.impTotal0+'\n');
		txtS.append("Aporte a la cuota diaria : "+Tienda.modelo0+'\n');
	}
	void mostrarReporte2(){
		txtS.setText("");
		txtS.append("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA"+Tienda.modelo0+'\n');
		txtS.append("Modelo"+'\n');
		txtS.append("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA"+'\n');
		txtS.append("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA"+'\n');
		
	}
	void mostrarReporte3(){
		txtS.setText("");
		txtS.append("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO"+Tienda.modelo0+'\n');
		txtS.append("VPRECIOS EN RELACIÓN AL PRECIO PROMEDIO"+'\n');
		txtS.append("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO"+'\n');
		txtS.append("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO"+'\n');		
	}
	void mostrarReporte4(){
		txtS.setText("");
		txtS.append("PROMEDIOS, MENORES Y MAYORES"+Tienda.modelo0+'\n');
		txtS.append("PROMEDIOS, MENORES Y MAYORES"+'\n');
		txtS.append("PROMEDIOS, MENORES Y MAYORES"+'\n');
		txtS.append("PROMEDIOS, MENORES Y MAYORES"+'\n');
		
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
