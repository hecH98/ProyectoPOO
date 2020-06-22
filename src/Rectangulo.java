//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: Rectangulo
//Proyecto: Java Paint

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends Figura{

	private boolean relleno;

	public Rectangulo(int x1, int y1, Color color) {
		super(x1, y1,0,0, color);
		this.relleno=false;
	}
	
	//Setter	
	public void setRelleno(boolean relleno) {
		this.relleno=relleno;
	}

	public void pinta(Graphics g) {
		
		g.setColor(this.color);
		//g.fillRect(this.x1, this.y1, this.x2-this.x1, this.y2-this.y1);
		if(this.relleno) {
			g.fillRect(this.x1, this.y1, this.x2-this.x1, this.y2-this.y1);
		}
		else {
			g.drawRect(this.x1, this.y1, this.x2-this.x1, this.y2-this.y1);
		}
	}
	
	public String toString() {
		return "Rectangulo,"+this.x1+","+this.y1+","+this.x2+","+this.y2+","+this.color.getRed()+","+this.color.getGreen()+","+this.color.getBlue()+","+this.relleno;
	}
			

}
