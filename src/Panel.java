//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: Panel
//Proyecto: Java Paint


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseMotionListener, MouseListener{
	
	private Color color;
	
	private ControlFig cf;
	private Elipse elipse;
	private Rectangulo rectangulo;
	private Figura[] figuras;
	private int cantidad;

	public Panel() {
		super();
		this.setPreferredSize(new Dimension(600,500));
		this.setBackground(Color.pink);
		this.addMouseMotionListener(this);
		this.color=Color.BLACK;
		this.addMouseListener(this);
		this.figuras=new Figura[10];
		this.cantidad=0;
	}
	
	public void borrarArreglo(int x) {
	  for (int i = x-1; i < figuras.length-1; i++) {
		  this.figuras[i]=this.figuras[i+1];
		}
	  	  this.figuras[figuras.length-1]=null;
	  	  cantidad--;
	      repaint();
  	}
  
  	public void setMover(int a, int b) {
	  	Figura tmp=this.figuras[a-1];
	  	this.figuras[a-1]=this.figuras[b-1];
	  	this.figuras[b-1]=tmp;
	  	repaint();
  	}
  	
  	public int getCantidad() {
		return this.figuras.length;
	}
	
	public void expanderArreglo(int cantidad) {
		double prueba = (double)cantidad/this.figuras.length;
		if(prueba >= 0.9) {
			Figura[] tmp=new Figura[this.figuras.length*2];
			for (int i = 0; i < figuras.length; i++) {
				tmp[i]=this.figuras[i];
			}
			this.figuras=tmp;
		}
	}
  
  	public void pintaFigura(Figura[] figura, int contador) {
	  	expanderArreglo(contador);
	  	for(int i=0; i<contador;i++) {
		 	this.figuras[i]=figura[i];
		  	this.cantidad++;
	  	}
	  
	  	this.repaint();
  	}

  	public Figura getFigura(int x) {
	  	return this.figuras[x];
  	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public void setControlFig(ControlFig cf) {
		this.cf=cf;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(this.figuras[0]!=null) {
			for(int i=0;i<this.cantidad;i++) {
				if(this.figuras[i]!=null) {
					this.figuras[i].pinta(g);
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		if(cf.slcElipse()) {
			this.figuras[cantidad]=new Elipse(e.getX(),e.getY(),this.color);
			this.elipse=(Elipse) this.figuras[cantidad];
			this.elipse.setRelleno(this.cf.slcRelleno());
		}
		else if(cf.slcRectangulo()){
			this.figuras[cantidad]=new Rectangulo(e.getX(),e.getY(),this.color);
			this.rectangulo=(Rectangulo) this.figuras[cantidad];
			this.rectangulo.setRelleno(this.cf.slcRelleno());
		}
		else if(cf.slcLinea()) {
			this.figuras[cantidad]=new Linea(e.getX(),e.getY(),this.color);
		}
		else {
			this.figuras[cantidad]=new Texto(this.cf.getTxt(),e.getX(),e.getY(),this.cf.getFuente(),this.color);
			repaint();
		}
		cantidad++;
		expanderArreglo(this.cantidad);
	}

	public void mouseDragged(MouseEvent e) {
		if(cf.slcTexto()==false) {
			this.figuras[cantidad-1].setFinal(e.getX(), e.getY());
			this.repaint();
		}
	}
	public void mouseMoved(MouseEvent arg0) {	
	}
	public void mouseEntered(MouseEvent arg0) {	
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {	
	}
}



