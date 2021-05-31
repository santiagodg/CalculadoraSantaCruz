/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eyap.f;


/**
 * Utilizamos las librerías AWT, Swing y java.time para implementar la solución. 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
import java.text.*;
import java.time.*;

/**
 * EyaPF
 * 
 * Clase principal de la calculadora.
 * @author jchv99, santiagodg
 */
public class EyAPF extends JFrame {
    
	/**
	 * Declaración de variables.
	 * 
	 * 
	 */
    private JButton Pedidos, AgregarP, AgregarM, EditarP, EditarM, EliminarP, EliminarM, ListaP, ListaM, Guardar, Salir;
	private JLabel AgregarPL, dia, mes, anio, mesesAtraso, totalInteres, totalLetrasPagadas, intereses, restanteInicial, liquidoPrimeraLetra;
	
	private JLabel ID, Nombre, Cantidad, Precio, Tela, CantidadT, tip, tip1; 
	//private JTextField IDPedidos;
	private JButton GuardarCambios, Revisar, Si, No;
	private JScrollPane Scroll;
	
	private JLabel IDP, NombreP, CantidadP, PrecioP, linea, linea2;
	
	
	private int id = 0, CantFin, idm = 0, IDARR, CantidadRevisar, IDRevisar;
	private double PrecioFin, CantMatFin;
	private String NombreFin, TelaFin, MaterialesCant, Text, TextTenemos, TextNecesitamos, dato, dato2;
	
	private JTextField dia1, mes1, anio1, dia2, mes2, anio2, letrasPagar, montoLetra, porcentajeDesc, IDPedidos, montoInicial, abonoPrevio;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EyAPF x = new EyAPF();
        x.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        
        x.setVisible(true);
    }
    
    EyAPF() {
		setSize(800, 700);

		//Titulo de la ventana
		setTitle("Calculadora Santa Cruz");

		// libreria apra interactuar con la ventana
		// en este caso se utiliza para conocer el tama�o
		// de la pantalla y centrar la ventana
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size. width/2 - getWidth()/2,
		size. height/2 - getHeight()/2);
		
		// Agregamos un panel
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c. fill = GridBagConstraints. HORIZONTAL;
						
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		JPanel botonesPnl = new JPanel();
		botonesPnl.setLayout(new GridBagLayout());
						
		AgregarPL = new JLabel ("Fecha de hoy:", JLabel.LEFT);
		c.gridheight = 1;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.7;
		panel.add(AgregarPL, c);
								
		dia = new JLabel ("Día", JLabel.CENTER);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(dia, c);
						
		mes = new JLabel ("Mes", JLabel.CENTER);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(mes, c);
							
		anio = new JLabel ("Año", JLabel.CENTER);
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 1;
		panel.add(anio, c);

		dia1 = new JTextField(16);
		dia1.setBorder(border);
		c. fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 0;
		c. gridy = 2;
		panel.add(dia1, c);
							
		mes1 = new JTextField(34);
		mes1.setBorder(border);
		c. fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c. gridx = 1;
		c. gridy = 2;
		panel.add(mes1, c);
							
		anio1 = new JTextField(16);
		anio1.setBorder(border);
		c. fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 2;
		c. gridy = 2;
		panel.add(anio1, c);
								
		AgregarPL = new JLabel ("Fecha de vencimiento de primera letra por pagar:", JLabel.LEFT);
		c.gridheight = 1;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(AgregarPL, c);
								
		dia = new JLabel ("Día", JLabel.CENTER);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(dia, c);
						
		mes = new JLabel ("Mes", JLabel.CENTER);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(mes, c);
							
		anio = new JLabel ("Año", JLabel.CENTER);
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 4;
		panel.add(anio, c);
							
		dia2 = new JTextField(16);
		dia2.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 0;
		c. gridy = 5;
		panel.add(dia2, c);
							
		mes2 = new JTextField(16);
		mes2.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 1;
		c. gridy = 5;
		panel.add(mes2, c);
							
		anio2 = new JTextField(16);
		anio2.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 2;
		c. gridy = 5;
		panel.add(anio2, c);
							
		anio = new JLabel ("Monto de la letra:", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 0;
		c. gridy = 6;
		panel.add(anio, c);
							
		montoLetra = new JTextField(16);
		montoLetra.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 2;
		c. gridy = 6;
		panel.add(montoLetra, c);
							
		anio = new JLabel ("Porcentaje de descuento en moratorios:", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 0;
		c. gridy = 7;
		panel.add(anio, c);

		anio = new JLabel ("Abono previo:", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 0;
		c. gridy = 8;
		panel.add(anio, c);

		abonoPrevio = new JTextField(16);
		abonoPrevio.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 2;
		c. gridy = 8;
		panel.add(abonoPrevio, c);
							
		porcentajeDesc = new JTextField(16);
		porcentajeDesc.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 2;
		c. gridy = 7;
		panel.add(porcentajeDesc, c);
							
		anio = new JLabel ("Número de letras por pagar:", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 0;
		c. gridy = 10;
		panel.add(anio, c);
							
		letrasPagar = new JTextField(16);
		letrasPagar.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c. gridx = 2;
		c. gridy = 10;
		panel.add(letrasPagar, c);

		anio = new JLabel ("              ", JLabel.CENTER);
		c.gridwidth = 1;
		c. gridx = 3;
		c. gridy = 9;
		panel.add(anio, c);
							
		anio = new JLabel ("                    ", JLabel.CENTER);
		c.gridwidth = 1;
		c. gridx = 5;
		c. gridy = 9;
		panel.add(anio, c);

		anio = new JLabel ("Monto sugerido:", JLabel.LEFT);
		c.gridwidth = 1;
		c. gridx = 4;
		c. gridy = 10;
		panel.add(anio, c);
							
		montoInicial = new JTextField(16);
		montoInicial.setBorder(border);
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 2;
		c. gridx = 5;
		c. gridy = 10;
		panel.add(montoInicial, c);
		
		anio = new JLabel (" ", JLabel.LEFT);
		c.gridwidth = 4;
		c. gridx = 0;
		c. gridy = 13;
		panel.add(anio, c);
		
		anio = new JLabel (" ", JLabel.LEFT);
		c.gridwidth = 4;
		c. gridx = 0;
		c. gridy = 11;
		panel.add(anio, c);

		liquidoPrimeraLetra = new JLabel ("", JLabel.LEFT);
		c.gridwidth = 4;
		c. gridx = 0;
		c. gridy = 14;
		panel.add(liquidoPrimeraLetra, c);

		mesesAtraso = new JLabel ("", JLabel.LEFT);
		c.gridwidth = 4;
		c. gridx = 0;
		c. gridy = 15;
		panel.add(mesesAtraso, c);
							
		totalInteres = new JLabel ("", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 0;
		c. gridy = 16;
		panel.add(totalInteres, c);
							
		totalLetrasPagadas = new JLabel ("", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 0;
		c. gridy = 17;
		panel.add(totalLetrasPagadas, c);
							
		// Revisar 2
		anio = new JLabel(" ", JLabel.LEFT);
		c.gridwidth = 4;
		c. gridx = 3;
		c. gridy = 13;
		panel.add(anio, c);

		intereses = new JLabel ("", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 4;
		c. gridy = 14;
		panel.add(intereses, c);
							
		restanteInicial = new JLabel ("", JLabel.LEFT);
		c.gridwidth = 2;
		c. gridx = 4;
		c. gridy = 15;
		panel.add(restanteInicial, c);
							
		AgregarP = new JButton ("Cálculo 2");
		AgregarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (dia2.getText().isEmpty() || mes2.getText().isEmpty() || anio2.getText().isEmpty()
						|| montoLetra.getText().isEmpty() || porcentajeDesc.getText().isEmpty()|| montoInicial.getText().isEmpty()) {
									
					JFrame Pedidos = new JFrame();
					Pedidos.setSize(600, 300);
					Pedidos.setTitle("Revisar");
					
					Toolkit tool=Pedidos.getToolkit();
					Dimension size= tool.getScreenSize();
					
					Pedidos.setLocation(size.width/2- Pedidos.getWidth()/2 +50, size.height/2 - Pedidos.getHeight()/2);
					GridBagConstraints c =new GridBagConstraints();
					JPanel display=new JPanel();
					display.setLayout(new GridBagLayout());
					Pedidos.getContentPane().add(display);
									
					JPanel botones =  new JPanel();
					botones.setLayout(new GridBagLayout());
					Border border = BorderFactory.createLineBorder(Color.BLACK);
					
					Scroll = new JScrollPane();
					Scroll.setBounds(200, 200, 200, 200);
					
					// Si faltan datos aparece este mensaje
					Text = "Faltan datos, favor de introducirlos";
																	
					anio = new JLabel ("Faltan datos, favor de introducirlos", JLabel.CENTER);
					c.gridwidth = 4;
					c. gridx = 0;
					c. gridy = 0;
					panel.add(anio, c);
					botones.add(anio, c);
												
					Salir = new JButton ("Salir");
					Salir.addActionListener(new ActionListener()
					{
					public void actionPerformed(ActionEvent event)
					{
							Pedidos.dispose();

					} });
					c. fill = GridBagConstraints. CENTER;
					c.gridwidth = 4;
					c. gridx = 1;
					c. gridy = 1;
					botones.add(Salir, c);

					Scroll.setViewportView(botones);

					
					Pedidos.add(Scroll);
					Pedidos.setVisible(true);
				} else {

					mesesAtraso.setText("");
					liquidoPrimeraLetra.setText("");
					totalInteres.setText("");
					totalLetrasPagadas.setText("");

					LocalDate fechaHoy;
					if (dia1.getText().isEmpty() && mes1.getText().isEmpty() && anio1.getText().isEmpty()) {
						fechaHoy = LocalDate.now();
					} else {
						fechaHoy = LocalDate.of(Integer.parseInt(anio1.getText()), Integer.parseInt(mes1.getText()), Integer.parseInt(dia1.getText()));
					}

					LocalDate fechaCarta = LocalDate.of(Integer.parseInt(anio2.getText()), Integer.parseInt(mes2.getText()), Integer.parseInt(dia2.getText()));
					Period interval = Period.between(fechaCarta, fechaHoy);
						
					// cantMeses = mesesAtraso
					
					int cantMeses =  interval.getMonths() + (interval.getYears() * 12);
															
					if (interval.getDays() > 7) {
						cantMeses++;
					}
					
					double desc = Double.parseDouble(porcentajeDesc.getText());
					double mensualidad = Double.parseDouble(montoLetra.getText());
					double abonado = Double.parseDouble(abonoPrevio.getText());

					double montoIn = Double.parseDouble(montoInicial.getText());
					
					double totalLetra = 0;
					double interes = 0;
					double restante = montoIn + abonado;
					double totalFinal = 0;

					if (desc > 0) {
						interes = (mensualidad * 0.03) * (1 - desc / 100);
						interes = round(interes, 3);
						intereses.setText("Interés moratorio por mes con descuento: $ " + round(interes, 3));
					} else {
						interes = round((mensualidad * 0.03), 3);
						intereses.setText("Interés moratorio por mes: $ " + round(interes, 3));
					}

					String temp = "";
					int i = 0;
					boolean primera = true;
					while (restante >= 0) {
						i++;
						totalLetra = mensualidad + (interes * cantMeses);
						restante -= totalLetra; 
						temp += "\nMeses de atraso: " + cantMeses;

						if (primera) {
							temp += "\nTotal de letra (" + i + "): $ " + round(totalLetra - abonado, 3) + "\n";
							primera = false;
						} else {
							temp += "\nTotal de letra (" + i + "): $ " + round(totalLetra, 3) + "\n";
						}
						
						if (cantMeses <= 0) {
							cantMeses = 0;
						} else {
							cantMeses -= 1;
						}
						
						totalFinal += totalLetra;
						
						if(restante < totalLetra){
							double totalLetraSig;
							if (cantMeses == 0) {
								totalLetraSig = totalLetra - restante;
							} else {
								totalLetraSig = (totalLetra - interes) - restante;
							}

							temp += "\nSiguiente letra:" + "\n";
							temp += "Abono a próxima letra: $ " + round(restante, 3)  + "\n";
							
							if (cantMeses == 0) {
								temp += "Total de proxima letra: $ " + round(totalLetra, 3) + "\n";
							} else {
								temp += "Total de proxima letra: $ " + round(totalLetra - interes, 3) + "\n";
							}
							
							temp += "Total para liquidar la proxima letra: $ " + round(totalLetraSig, 3) + "\n";
							temp += "\n---------------------------" + "\n";
							temp += "\nTotal pagado: $ " + round(montoIn, 3) + "\n";
							
							break;
						}
						
					}
					// System.out.println(temp);
					restanteInicial.setText("<html>" + temp.replaceAll("\n", "<br/>") + "</html>");					
				}
								
			}
		});

		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 2;
		c. gridx = 4;
		c. gridy = 12;
		panel.add(AgregarP, c);
				
		Pedidos = new JButton ("Cálculo 1");
		Pedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (dia2.getText().isEmpty() || mes2.getText().isEmpty() || anio2.getText().isEmpty()
						|| montoLetra.getText().isEmpty() || porcentajeDesc.getText().isEmpty()|| letrasPagar.getText().isEmpty()) {
					
					JFrame Pedidos = new JFrame();
					Pedidos.setSize(600, 300);
					Pedidos.setTitle("Revisar");
					
					Toolkit tool=Pedidos.getToolkit();
					Dimension size= tool.getScreenSize();
					
					Pedidos.setLocation(size.width/2- Pedidos.getWidth()/2 +50, size.height/2 - Pedidos.getHeight()/2);
					GridBagConstraints c =new GridBagConstraints();
					JPanel display=new JPanel();
					display.setLayout(new GridBagLayout());
					Pedidos.getContentPane().add(display);
									
					JPanel botones =  new JPanel();
					botones.setLayout(new GridBagLayout());
					Border border = BorderFactory.createLineBorder(Color.BLACK);
					
					Scroll = new JScrollPane();
					Scroll.setBounds(200, 200, 200, 200);
					
					//Si faltan datos aparece este mensaje
					Text = "Faltan datos, favor de introducirlos";
																	
					anio = new JLabel ("Faltan datos, favor de introducirlos", JLabel.CENTER);
					c.gridwidth = 4;
					c. gridx = 0;
					c. gridy = 0;
					panel.add(anio, c);
					botones.add(anio, c);
												
					Salir = new JButton ("Salir");
					Salir.addActionListener(new ActionListener()
					{
					public void actionPerformed(ActionEvent event)
					{
							Pedidos.dispose();

					} });
					c. fill = GridBagConstraints. CENTER;
					c.gridwidth = 4;
					c. gridx = 1;
					c. gridy = 1;
					botones.add(Salir, c);
					
					
					
					Scroll.setViewportView(botones);

					Pedidos.add(Scroll);
					Pedidos.setVisible(true);
	
				} else {

					intereses.setText("");
					restanteInicial.setText("");
										
					LocalDate fechaHoy;
					if (dia1.getText().isEmpty() && mes1.getText().isEmpty() && anio1.getText().isEmpty()) {
						fechaHoy = LocalDate.now();
					} else {
						fechaHoy = LocalDate.of(Integer.parseInt(anio1.getText()), Integer.parseInt(mes1.getText()), Integer.parseInt(dia1.getText()));
					}

					LocalDate fechaCarta = LocalDate.of(Integer.parseInt(anio2.getText()), Integer.parseInt(mes2.getText()), Integer.parseInt(dia2.getText()));
					Period interval = Period.between(fechaCarta, fechaHoy);
						
					int cantMeses =  interval.getMonths() + (interval.getYears() * 12);
					int meses2 = 0;
					int numL = Integer.parseInt(letrasPagar.getText())-1;
					double totalLetra = 0;
															
					if(interval.getDays()>7){
						cantMeses++;
					}

					if (Integer.parseInt(letrasPagar.getText()) > 1) {
						
						for (int i = Integer.parseInt(letrasPagar.getText()); i > 0; i--) {
							if (cantMeses >= numL) {
								meses2 += cantMeses - numL;
							}
							numL--;
						}
					}else{
						meses2 = cantMeses;
					}
					
					if (cantMeses <= 0) {
						meses2 = 0;
					}
					
					mesesAtraso.setText("Número de meses atrasados: " + meses2); 
					double desc = Integer.parseInt(porcentajeDesc.getText());
					double mensualidad = Integer.parseInt(montoLetra.getText());
					double interes = 0;
					double abonado = Double.parseDouble(abonoPrevio.getText());

					if (desc > 0) {
						interes = (mensualidad * 0.03) * (1 - desc/100);
						interes = round(interes, 3);
						liquidoPrimeraLetra.setText("Liquidó primera letra con: $ " + round(mensualidad + (interes * cantMeses) - abonado, 3));
						totalInteres.setText("Total intereses moratorios con descuento: $ " + round(interes * meses2, 3));
						totalLetra = ((mensualidad * Integer.parseInt(letrasPagar.getText())) + (interes * meses2));
					}else{
						interes = round((mensualidad * 0.03), 3);
						liquidoPrimeraLetra.setText("Liquidó primera letra con: $ " + round(mensualidad + (interes * cantMeses) - abonado, 3));
						totalInteres.setText("Total intereses moratorios: $ " + round(interes * meses2, 3));
						totalLetra = ((mensualidad * Integer.parseInt(letrasPagar.getText())) + (interes * meses2));
					}
					
					totalLetrasPagadas.setText("Total por pagar: $ " + round(totalLetra - abonado, 3));
					
					
				}
			}
		});
		c. fill = GridBagConstraints. HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 12;
		panel.add(Pedidos, c);
    }
    
    public static double round(double num, int digits) {

		// epsilon correction
		double n = Double.longBitsToDouble(Double.doubleToLongBits(num) + 1);
		double p = Math.pow(10, digits);
		return Math.round(n * p) / p;
	}
    
}
