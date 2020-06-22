//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: Figura
//Proyecto: Java Paint

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	
	//Atributos
	protected Color color;
	
	protected int x1,
				y1,
				x2,
				y2;

	public Figura(int x1, int y1, int x2, int y2, Color color) {
		// TODO Auto-generated constructor stub
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.color=color;
	}
	
	public void setInicial(int x, int y) {
		this.x1=x;
		this.y1=y;
	}
	
	public void setFinal(int x, int y) {
		this.x2=x;
		this.y2=y;
	}
	
	public abstract void pinta(Graphics g);

}
