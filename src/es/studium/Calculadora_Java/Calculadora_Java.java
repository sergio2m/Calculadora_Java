package es.studium.Calculadora_Java;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Calculadora_Java extends Frame implements WindowListener, ActionListener
{
	//creacion de los distintos componentes
	//barra de menus
	MenuBar barra = new MenuBar();
	//menus
	Menu Ver = new Menu("Ver");
	Menu Edicion = new Menu("Edición");
	Menu Ayuda = new Menu("Ayuda");
	//item de los menus
	MenuItem VerEstandar = new MenuItem("Estandar");
	MenuItem VerCientifica = new MenuItem("Cientifica");
	MenuItem VerProgramador = new MenuItem("Programador");
	MenuItem VerEstadistica = new MenuItem("Estadística");
	MenuItem VerHistorial = new MenuItem("Historial");
	MenuItem VerNdigitos = new MenuItem("Número de dígitos en grupo");
	MenuItem VerBasicas = new MenuItem("Básicas");
	MenuItem VerConUnidades = new MenuItem("Conversión de unidades");
	MenuItem VerCalFecha = new MenuItem("Cálculo de fecha");
	MenuItem VerHojCalulo = new MenuItem("Hojas de Cálculo");
	MenuItem EdiCp = new MenuItem("Copiar");
	MenuItem EdiPg = new MenuItem("Pegar");
	MenuItem EdiHist = new MenuItem("Historial");
	MenuItem AyVer = new MenuItem("Ver la ayuda");
	MenuItem AyACer = new MenuItem("Acerca de calculadora");
	//texto
	TextField texto = new TextField();
	//panel
	Panel botones = new Panel(new GridLayout(5,4,3,8));
	//botones
	Button b0 = new Button("0");
	Button b1 = new Button("1");
	Button b2 = new Button("2");
	Button b3 = new Button("3");
	Button b4 = new Button("4");
	Button b5 = new Button("5");
	Button b6 = new Button("6");
	Button b7 = new Button("7");
	Button b8 = new Button("8");
	Button b9 = new Button("9");
	Button bPunto = new Button(".");
	Button bIgual = new Button("=");
	Button bSuma = new Button("+");
	Button bProducto = new Button("*");
	Button bDivision = new Button("/");
	Button bResta = new Button("-");
	Button bReset = new Button("C");
	Button bPotencia = new Button("Potencia");
	Button bRaiz = new Button("Raiz");
	Button bBorrar = new Button("Borrar");
	//variables para el calculo
	double numero1, numero2, resultado;
	// variable tipo de operacion
	String tipoOperacion;
	//variable de control si es la primera operacion o posterior
	boolean controlOperacion=false;
	//variable de control punto decimal
	boolean controlDecimal=false;
	
	public Calculadora_Java()
	{
		setVisible(true);//el frame esta visible
		setSize(250,200);//dimension del frame
		setResizable(false);//fijar el tamaño del frame antes indicado
		setTitle("CALCULADORA");//titulo del frame
		setLayout(new BorderLayout());//nueva distribucion del frame
		setMenuBar(barra);//añadir la barra de menu
		//añadir los menus a la barra de menus
		barra.add(Ver);
		barra.add(Edicion);
		barra.add(Ayuda);
		//añadir los item a los menus
		Ver.add(VerEstandar);
		Ver.add(VerCientifica);
		Ver.add(VerProgramador);
		Ver.add(VerEstadistica);
		Ver.addSeparator();		
		Ver.add(VerHistorial);
		Ver.add(VerNdigitos);
		Ver.add(VerBasicas);
		Ver.add(VerConUnidades);
		Ver.addSeparator();
		Ver.add(VerCalFecha);
		Ver.add(VerHojCalulo);
		Edicion.add(EdiCp);
		Edicion.add(EdiPg);
		Edicion.add(EdiHist);
		Ayuda.add(AyVer);
		Ayuda.add(AyACer);
		add("North",texto);
		add("Center",botones);
		//añadir botones
		botones.add(b1);
		botones.add(b2);
		botones.add(b3);
		botones.add(bSuma);
		botones.add(b4);
		botones.add(b5);
		botones.add(b6);
		botones.add(bResta);
		botones.add(b7);
		botones.add(b8);
		botones.add(b9);
		botones.add(bProducto);
		botones.add(bPunto);
		botones.add(b0);
		botones.add(bIgual);
		botones.add(bDivision);
		botones.add(bReset);
		botones.add(bPotencia);
		botones.add(bRaiz);
		botones.add(bBorrar);
		//escuchadores
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bSuma.addActionListener(this);
		bResta.addActionListener(this);
		bProducto.addActionListener(this);
		bDivision.addActionListener(this);
		bIgual.addActionListener(this);
		bPunto.addActionListener(this);
		bReset.addActionListener(this);
		bPotencia.addActionListener(this);
		bRaiz.addActionListener(this);
		bBorrar.addActionListener(this);
		addWindowListener(this);
	}
	public static void main(String[] args)
	{
		 new Calculadora_Java();
	}
	public void windowActivated(WindowEvent arg0)
	{
		
	}
	public void windowClosed(WindowEvent arg0)
	{
		
	}
	public void windowClosing(WindowEvent we)
	{
		System.exit(0);//cierra el frame pulsando el simbolo de cierre del frame
	}
	public void windowDeactivated(WindowEvent arg0)
	{
		
	}
	public void windowDeiconified(WindowEvent arg0) 
	{
		
	}
	public void windowIconified(WindowEvent arg0)
	{
		
	}
	public void windowOpened(WindowEvent arg0) 
	{
		
	}
	public void actionPerformed(ActionEvent ae)
	{		
		switch (ae.getActionCommand())
		{
			case "0":
				if (controlOperacion==false) //control si es la primera operacion
				{
					texto.setText(texto.getText()+"0");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"0");
					controlOperacion=false;
				}
			break;
			case "1":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"1");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"1");
					controlOperacion=false;
				}
			break;
			case "2":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"2");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"2");
					controlOperacion=false;
				}
				break;
			case "3":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"3");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"3");
					controlOperacion=false;
				}
				break;
			case "4":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"4");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"4");
					controlOperacion=false;
				}
				break;
			case "5":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"5");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"5");
					controlOperacion=false;
				}
				break;
			case "6":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"6");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"6");
					controlOperacion=false;
				}
				break;
			case "7":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"7");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"7");
					controlOperacion=false;
				}
				break;
			case "8":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"8");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"8");
					controlOperacion=false;
				}
				break;
			case "9":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+"9");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+"9");
					controlOperacion=false;
				}
				break;
			case ".":
				if (controlOperacion==false)
				{
					texto.setText(texto.getText()+".");
				}
				else
				{
					texto.setText("");
					texto.setText(texto.getText()+".");
					controlOperacion=false;
				}
				controlDecimal=false;
				bPunto.removeActionListener(this);
				break;
			case "C":
				texto.setText("");
				numero1=0;
				numero2=0;	
				resultado=0;
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "Potencia":
				tipoOperacion="Potencia";
				numero1=Double.parseDouble(texto.getText());
				controlOperacion=true;
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "Raiz":
				numero1=Double.parseDouble(texto.getText());
				if (numero1<0)
				{
					texto.setText("Operacion no permitida");					
				}
				else
				{
					resultado=Math.sqrt(numero1);
					texto.setText(Double.toString(resultado));
					controlOperacion=true;
				}
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "Borrar":
				String texto2=texto.getText();
				if ((texto2.length()>0))
				{
					String texto3=texto2.substring(0,(texto2.length())-1);
					texto.setText(texto3);
				}
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "*":
				tipoOperacion="*";
				numero1=Double.parseDouble(texto.getText());
				controlOperacion=true;
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "+":
				tipoOperacion="+";
				numero1=Double.parseDouble(texto.getText());
				controlOperacion=true;
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "-":
				tipoOperacion="-";
				numero1=Double.parseDouble(texto.getText());
				controlOperacion=true;
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "/":
				tipoOperacion="/";
				numero1=Double.parseDouble(texto.getText());
				controlOperacion=true;
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
			case "=":
				numero2=Double.parseDouble(texto.getText());
				switch (tipoOperacion)
				{
					case "*":
						resultado=numero1*numero2;
						texto.setText(Double.toString(resultado));
						break;
					case "+":
						resultado=numero1+numero2;
						texto.setText(Double.toString(resultado));
						break;
					case "-":
						resultado=numero1-numero2;
						texto.setText(Double.toString(resultado));
						break;
					case "/":
						if (numero2==0)
						{
							texto.setText("Infinito");
						}
						else
						{
							resultado=numero1/numero2;
							texto.setText(Double.toString(resultado));
						}
						break;
					case "Potencia":
						resultado=Math.pow(numero1,numero2);
						texto.setText(Double.toString(resultado));
						break;
				}
				numero1=0;
				numero2=0;	
				resultado=0;
				controlOperacion=true;
				if (controlDecimal==false)
				{
					controlDecimal=true;
					bPunto.addActionListener(this);
				}
				break;
		}
	}
}

