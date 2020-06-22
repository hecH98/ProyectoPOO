//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: Texto
//Proyecto: Java Paint

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Texto extends Figura {
	
	//Atributos
	private String texto;
	private Font font;
	
	public Texto(String texto, int x1, int y1,Font font,Color color) {
		super(x1,y1,x1,y1,color);
		this.texto=texto;
		this.font=font;
	}

	public void pinta(Graphics g) {
		g.setColor(super.color);
		g.setFont(this.font);
		g.drawString(this.texto, super.x1, super.y1);
		
	}
	
	public String toString() {
		return "Texto,"+this.x1+","+this.y1+",\""+this.texto+"\","+this.font.getFontName()+","+this.font.getSize()+","+this.color.getRed()+","+this.color.getGreen()+","+this.color.getBlue();
	}
}
