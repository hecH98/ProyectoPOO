//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: Elipse
//Proyecto: Java Paint

import java.awt.Color;
import java.awt.Graphics;

public class Elipse extends Figura {
	
	private boolean relleno;

	public Elipse(int x1, int y1, Color color) {
		super(x1, y1, x1, y1, color);
		this.relleno=false;
	}
	
	public void setRelleno(boolean relleno) {
		this.relleno=relleno;
	}
	
	public void pinta(Graphics g) {
		g.setColor(this.color);
		if(this.relleno) {
				g.fillOval(this.x1, this.y1, this.x2-this.x1, this.y2-this.y1);
		}
		else {
			g.drawOval(this.x1, this.y1, this.x2-this.x1, this.y2-this.y1);
		}
	}
	
	public String toString() {
		return "Elipse,"+this.x1+","+this.y1+","+this.x2+","+this.y2+","+this.color.getRed()+","+this.color.getGreen()+","+this.color.getBlue()+","+this.relleno;
	}

}
