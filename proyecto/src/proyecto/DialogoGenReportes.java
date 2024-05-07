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
		double[] datos = {Tienda.precio0,Tienda.precio1,Tienda.precio2,Tienda.precio3,Tienda.precio4};
		double menorprom = datos[0];
		double mayorprom = datos[0];
		double sumaprom = 0;
		double promediopre=0;
		
		double[] datosAnch = {Tienda.ancho0,Tienda.ancho1,Tienda.ancho2,Tienda.ancho3,Tienda.ancho4};
		double menorAnch = datos[0];
		double mayorAnch = datos[0];
		double sumaAnch = 0;
		double promedioAnch=0;
		
		//Calcular promedio,mayor menor precio
		for(double dato:datos){
			sumaprom+=dato;

			if(dato<menorprom){
				menorprom = dato;
			}
			if(dato>mayorprom)
				mayorprom=dato;
		}
		promediopre = sumaprom/datos.length;
		
		//Calcular promedio,mayor menor precio
		for(double datoA : datosAnch){
			sumaAnch+=datoA;
			if(datoA<menorAnch){
				menorAnch = datoA;
			}
			if(datoA>mayorAnch){
				mayorAnch = datoA;
			}
		}
		promedioAnch=sumaAnch/datosAnch.length;
		System.out.println(mayorAnch);
		//calcular cantidad optima
		CantOptiF0=calcularCanOpt0();
		CantOptiF1=calcularCanOpt1();
		CantOptiF2=calcularCanOpt2();
		CantOptiF3=calcularCanOpt3();
		CantOptiF4=calcularCanOpt4();
		
		//calcular precio promedio
		promPrecio0 = calcularPP0(promediopre);
		promPrecio1 = calcularPP1(promediopre);
		promPrecio2 = calcularPP2(promediopre);
		promPrecio3 = calcularPP3(promediopre);
		promPrecio4 = calcularPP4(promediopre);
		
		//generar reportes
		mostrarReporte1();
		mostrarReporte2();
		mostrarReporte3();
		mostrarReporte4(promediopre,menorprom,mayorprom,promedioAnch,menorAnch,mayorAnch);
		
		
		//calcular resultado de combo box
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
			mostrarReporte4(promediopre,menorprom,mayorprom,promedioAnch,menorAnch,mayorAnch);			
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
	
	String calcularPP0(double promediopre){
		if(Tienda.precio0>promediopre)
			return "(Mayor al promedio)";
		else if(Tienda.precio0==promediopre)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";

	}
	String calcularPP1(double promediopre){
		if(Tienda.precio1>promediopre)
			return "(Mayor al promedio)";
		else if(Tienda.precio1==promediopre)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";
	}
	String calcularPP2(double promediopre){
		if(Tienda.precio2>promediopre)
			return "(Mayor al promedio)";
		else if(Tienda.precio2==promediopre)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";
	}
	String calcularPP3(double promediopre){
		if(Tienda.precio3>promediopre)
			return "(Mayor al promedio)";
		else if(Tienda.precio3==promediopre)
			return "(Igual al promedio)";
		else
			return "(Menor al promedio)";
	}
	String calcularPP4(double promediopre){
		if(Tienda.precio4>promediopre)
			return "(Mayor al promedio)";
		else if(Tienda.precio4==promediopre)
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
	void mostrarReporte4(double promediopre,double menorprom,double mayorprom,double promedioAnch,double menorAnch,double mayorAnch){
		txtS.setText("");
		txtS.append("PROMEDIOS, MENORES Y MAYORES"+'\n'+'\n');
		txtS.append("Precio promedio: S/. "+promediopre+'\n');
		txtS.append("Precio menor\t: S/. "+menorprom+'\n');
		txtS.append("Precio mayor\t: S/. "+mayorprom+'\n'+'\n');
		txtS.append("Ancho promedio: S/. "+promedioAnch+'\n');
		txtS.append("Ancho menor\t: S/. "+menorAnch+'\n');
		txtS.append("Ancho mayor\t: S/. "+mayorAnch+'\n'+'\n');
		
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
