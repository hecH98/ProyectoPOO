//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: Ventana
//Proyecto: Java Paint

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	public Ventana() {
		// TODO Auto-generated constructor stub
		super("Java Paint");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Panel p = new Panel();
		ControlFig cf=new ControlFig(p);
		this.add(cf,BorderLayout.WEST);
		this.add(new ControlArchivo(p),BorderLayout.SOUTH);
		p.setControlFig(cf);
		this.add(p);
		this.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		super.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Ventana a=new Ventana();
	}

}
