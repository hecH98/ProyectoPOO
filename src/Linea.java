//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: Linea
//Proyecto: Java Paint

import java.awt.Color;
import java.awt.Graphics;

public class Linea extends Figura{

	
	public Linea(int x1, int y1, Color color) {
		super(x1, y1, 0, 0, color);
	}

	public void pinta(Graphics g) {
		g.setColor(super.color);	
		g.drawLine(super.x1, super.y1, super.x2, super.y2);
	}
	
	public String toString() {

		return "Linea,"+this.x1+","+this.y1+","+this.x2+","+this.y2+","+this.color.getRed()+","+this.color.getGreen()+","+this.color.getBlue();

	}


}
