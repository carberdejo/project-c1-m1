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
	private JButton btnCerrar;
	
	String CantOptiF0,CantOptiF1,CantOptiF2,CantOptiF3,CantOptiF4;
	double suma = Tienda.precio0+Tienda.precio1+Tienda.precio2+Tienda.precio3+Tienda.precio4;
	double promedio = suma/5;
	String promPrecio0,promPrecio1,promPrecio2,promPrecio3,promPrecio4;
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
		tipo = getTipo();
		
		//generar reportes
		mostrarReporte1();
		mostrarReporte2();
		mostrarReporte3();
		mostrarReporte4();
		//calcular cantidad optima
		CantOptiF0=calcularCanOpt0();
		CantOptiF1=calcularCanOpt1();
		CantOptiF2=calcularCanOpt2();
		CantOptiF3=calcularCanOpt3();
		CantOptiF4=calcularCanOpt4();
		//calcular precio promedio
		promPrecio0 = calcularPP0();
		promPrecio1 = calcularPP1();
		promPrecio2 = calcularPP2();
		promPrecio3 = calcularPP3();
		promPrecio4 = calcularPP4();
		
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
	String calcularCanOpt0(){
		if(DialogoVender.TotalCant0==Tienda.cantidadOptima){
			return "(igual a la cantidad óptima)";
			
		}else if(DialogoVender.TotalCant0>Tienda.cantidadOptima){
			return DialogoVender.TotalCant0-Tienda.cantidadOptima+" más que la cantidad óptima";
		}else if(DialogoVender.TotalCant0==0){
			return " No compro nada ";
	}else 
		return Tienda.cantidadOptima-DialogoVender.TotalCant0+" menos que la cantidad óptima";
	}
	String calcularCanOpt1(){
		if(DialogoVender.TotalCant1==Tienda.cantidadOptima){
			return "(igual a la cantidad óptima)";
			
		}else if(DialogoVender.TotalCant1>Tienda.cantidadOptima){
			return DialogoVender.TotalCant1-Tienda.cantidadOptima+" más que la cantidad óptima";
			
		}else if(DialogoVender.TotalCant0==0){
			return " No compro nada ";
		}else{
			return Tienda.cantidadOptima-DialogoVender.TotalCant1+" menos que la cantidad óptima";
		}
	}
	String calcularCanOpt2(){
		if(DialogoVender.TotalCant2==Tienda.cantidadOptima){
			return "(igual a la cantidad óptima)";
			
		}else if(DialogoVender.TotalCant2>Tienda.cantidadOptima){
			return DialogoVender.TotalCant2-Tienda.cantidadOptima+" más que la cantidad óptima";
			
		}else if(DialogoVender.TotalCant0==0){
			return " No compro nada ";
		}else{
			return Tienda.cantidadOptima-DialogoVender.TotalCant2+" menos que la cantidad óptima";
		}
	}
	String calcularCanOpt3(){
		if(DialogoVender.TotalCant3==Tienda.cantidadOptima){
			return "(igual a la cantidad óptima)";
			
		}else if(DialogoVender.TotalCant3>Tienda.cantidadOptima){
			return DialogoVender.TotalCant3-Tienda.cantidadOptima+" más que la cantidad óptima";
			
		}else if(DialogoVender.TotalCant0==0){
			return " No compro nada ";
		}else{
			return Tienda.cantidadOptima-DialogoVender.TotalCant3+" menos que la cantidad óptima";
		}
	}
	String calcularCanOpt4(){
		if(DialogoVender.TotalCant4==Tienda.cantidadOptima){
			return "(igual a la cantidad óptima)";
			
		}else if(DialogoVender.TotalCant4>Tienda.cantidadOptima){
			return DialogoVender.TotalCant4-Tienda.cantidadOptima+" más que la cantidad óptima";
			
		}else if(DialogoVender.TotalCant0==0){
			return " No compro nada ";
		}else{
			return Tienda.cantidadOptima-DialogoVender.TotalCant4+" menos que la cantidad óptima";
		}
	}
	
	String calcularPP0(){
		if(Tienda.precio0>promedio)
			return "(Mayor al promedio)";
		else if(Tienda.precio0==promedio)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";

	}
	String calcularPP1(){
		if(Tienda.precio1>promedio)
			return "(Mayor al promedio)";
		else if(Tienda.precio1==promedio)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";
	}
	String calcularPP2(){
		if(Tienda.precio2>promedio)
			return "(Mayor al promedio)";
		else if(Tienda.precio2==promedio)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";
	}
	String calcularPP3(){
		if(Tienda.precio3>promedio)
			return "(Mayor al promedio)";
		else if(Tienda.precio3==promedio)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";
	}
	String calcularPP4(){
		if(Tienda.precio4>promedio)
			return "(Mayor al promedio)";
		else if(Tienda.precio4==promedio)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";
	}
	
	void mostrarReporte1(){
		txtS.setText("");
		txtS.append("VENTAS POR MODELO"+'\n');
		txtS.append("Modelo : "+Tienda.modelo0+'\n');
		txtS.append("Cantidad de ventas : "+DialogoVender.TotalVent0+'\n');
		txtS.append("Cantidad de  unidades vendidas : "+DialogoVender.TotalVent1+'\n');
		txtS.append("Importe total vendido : "+DialogoVender.impTotal0+'\n');
		txtS.append("Aporte a la cuota diaria : "+Tienda.modelo0+'\n'+'\n');
		txtS.append("VENTAS POR MODELO"+'\n');
		txtS.append("Modelo : "+Tienda.modelo0+'\n');
		txtS.append("Cantidad de ventas : "+DialogoVender.TotalVent0+'\n');
		txtS.append("Cantidad de unidades vendidas : "+DialogoVender.TotalVent1+'\n');
		txtS.append("Importe total vendido : "+DialogoVender.impTotal0+'\n');
		txtS.append("Aporte a la cuota diaria : "+Tienda.modelo0+'\n'+'\n');
		txtS.append("VENTAS POR MODELO"+'\n');
		txtS.append("Modelo : "+Tienda.modelo0+'\n');
		txtS.append("Cantidad de ventas : "+DialogoVender.TotalVent0+'\n');
		txtS.append("Cantidad de unidades vendidas : "+DialogoVender.TotalVent1+'\n');
		txtS.append("Importe total vendido : "+DialogoVender.impTotal0+'\n');
		txtS.append("Aporte a la cuota diaria : "+Tienda.modelo0+'\n'+'\n');
		txtS.append("VENTAS POR MODELO"+'\n');
		txtS.append("Modelo : "+Tienda.modelo0+'\n');
		txtS.append("Cantidad de ventas : "+DialogoVender.TotalVent0+'\n');
		txtS.append("Cantidad de unidades vendidas : "+DialogoVender.TotalVent1+'\n');
		txtS.append("Importe total vendido : "+DialogoVender.impTotal0+'\n');
		txtS.append("Aporte a la cuota diaria : "+Tienda.modelo0+'\n'+'\n');
	}
	void mostrarReporte2(){
		txtS.setText("");
		txtS.append("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA"+'\n'+'\n');
		txtS.append("Modelo\t\t\t:"+Tienda.modelo0+'\n');
		txtS.append("Cantidad de unidades vendidas\t\t: "+DialogoVender.TotalCant0+" ("+CantOptiF0+")"+'\n'+'\n');
		txtS.append("Modelo\t\t\t:"+Tienda.modelo0+'\n');
		txtS.append("Cantidad de unidades vendidas\t\t: "+DialogoVender.TotalCant1+" ("+CantOptiF1+")"+'\n'+'\n');
		txtS.append("Modelo\t\t\t:"+Tienda.modelo0+'\n');
		txtS.append("Cantidad de unidades vendidas\t\t: "+DialogoVender.TotalCant2+" ("+CantOptiF2+")"+'\n'+'\n');
		txtS.append("Modelo\t\t\t:"+Tienda.modelo0+'\n');
		txtS.append("Cantidad de unidades vendidas\t\t: "+DialogoVender.TotalCant3+" ("+CantOptiF3+")"+'\n'+'\n');
		txtS.append("Modelo\t\t\t:"+Tienda.modelo0+'\n');
		txtS.append("Cantidad de unidades vendidas\t\t: "+DialogoVender.TotalCant4+" ("+CantOptiF4+")"+'\n'+'\n');
		
	}
	void mostrarReporte3(){
		txtS.setText("");
		txtS.append("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO"+Tienda.modelo0+'\n');
		txtS.append("Modelo\t:"+Tienda.modelo0+'\n');
		txtS.append("Precio\t: S/."+Tienda.precio0+promPrecio0+'\n');
		txtS.append("Modelo\t:"+Tienda.modelo1+'\n');
		txtS.append("Precio\t: S/."+Tienda.precio1+promPrecio1+'\n');
		txtS.append("Modelo\t:"+Tienda.modelo2+'\n');
		txtS.append("Precio\t: S/."+Tienda.precio2+promPrecio2+'\n');
		txtS.append("Modelo\t:"+Tienda.modelo3+'\n');
		txtS.append("Precio\t: S/."+Tienda.precio3+promPrecio3+'\n');
		txtS.append("Modelo\t:"+Tienda.modelo4+'\n');
		txtS.append("Precio\t: S/."+Tienda.precio4+promPrecio4+'\n');
	}
	void mostrarReporte4(){
		txtS.setText("");
		txtS.append("PROMEDIOS, MENORES Y MAYORES"+Tienda.modelo0+'\n'+'\n');
		txtS.append("Precio promedio: S/. "+'\n');
		txtS.append("Precio menor\t: S/. "+'\n');
		txtS.append("Precio mayor\t: S/. "+'\n'+'\n');
		txtS.append("Ancho promedio: S/. "+'\n');
		txtS.append("Ancho menor\t: S/. "+'\n');
		txtS.append("Ancho mayor\t: S/. "+'\n'+'\n');
		
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
