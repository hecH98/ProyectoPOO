//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: ControlFig
//Proyecto: Java Paint

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




public class ControlFig extends JPanel {

	private Panel p;
	
	private JRadioButton rbElipse,
						 rbRectangulo,
						 rbLinea,
						 rbTxt;
	
	private JCheckBox cbRelleno;
	private JTextField tfTexto;
	private JPanel pColor;
	private JComboBox cbFuentes,
					  cbSize;
	private String[] fuentes;
	private int[] Size;
	
	public ControlFig(Panel p) {
		super();
		this.setLayout(null);
		this.p=p;
		this.setPreferredSize(new Dimension(150,500));
		this.setBackground(Color.gray);
		//this.elipse.setControlFig(this);
		//this.rectangulo.setControlFig(this);
		
		//Radio Buttons
		this.rbElipse=new JRadioButton("Elipse", true);
		this.rbElipse.setBounds(10, 10, 100, 15);
		this.rbRectangulo=new JRadioButton("Rectangulo");
		this.rbRectangulo.setBounds(10, 30, 100, 15);
		this.rbLinea=new JRadioButton("Linea");
		this.rbLinea.setBounds(10, 50, 100, 15);
		this.rbTxt=new JRadioButton("Texto");
		this.rbTxt.setBounds(10, 70, 100, 15);
		ButtonGroup bg=new ButtonGroup();
		bg.add(this.rbElipse);
		bg.add(this.rbRectangulo);
		bg.add(this.rbLinea);
		bg.add(this.rbTxt);
		this.add(this.rbElipse);
		this.add(this.rbRectangulo);
		this.add(this.rbLinea);
		this.add(this.rbTxt);
		
		//CheckBox
		this.cbRelleno=new JCheckBox("Relleno");
		this.cbRelleno.setBounds(10, 90, 100, 15);
		this.add(this.cbRelleno);
		
		//Cuadro de Texto
		this.tfTexto=new JTextField("Escriba un texto.",10);
		this.tfTexto.setToolTipText("Escriba un texto");
		this.tfTexto.setBounds(10, 110, 125, 20);
		this.add(this.tfTexto);
		
		//Panel de Color 
		this.pColor=new JPanel();
		this.pColor.setBounds(25, 140, 100, 50);
		this.pColor.setPreferredSize(new Dimension(100,50));
		this.pColor.setBackground(Color.BLACK);
		this.pColor.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				Color slc=JColorChooser.showDialog(ControlFig.this.p, "Elige un Color", pColor.getBackground());
				pColor.setBackground(slc);
				p.setColor(slc);
			}
		});
		this.add(this.pColor);
		
		//Combo Box Size
		this.cbSize=new JComboBox();
		this.cbSize.setBounds(10, 200, 100, 20);
		this.cbSize.setToolTipText("Tamaño de fuente");
		for(int i=8;i<25;i++) {
			this.cbSize.addItem(i);
		}
		this.add(this.cbSize);
		
	
		//Combo Box Fuentes
		this.fuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();	
		this.cbFuentes=new JComboBox(this.fuentes);
		this.cbFuentes.setBounds(10, 230, 125, 20);
		this.cbFuentes.setToolTipText("Seleccione una fuente");
		this.cbFuentes.setPreferredSize(new Dimension(125,25));
		this.add(this.cbFuentes);
		
		//Font
		
		
	}
	
	//Getters
	public JTextField getTexto() {
		return this.tfTexto;
	}
	public boolean slcElipse() {
		return this.rbElipse.isSelected();
	}
	
	public boolean slcRectangulo() {
		return this.rbRectangulo.isSelected();
	}
	
	public boolean slcLinea() {
		return this.rbLinea.isSelected();
	}
	
	public boolean slcTexto() {
		return this.rbTxt.isSelected();
	}
	
	public boolean slcRelleno() {
		return this.cbRelleno.isSelected();
	}
	
	public String getTxt() {
		return this.tfTexto.getText();
	}
	
	public Font getFuente() {
		return new Font(String.valueOf(this.cbFuentes.getSelectedItem()),Font.PLAIN,Integer.parseInt(String.valueOf(this.cbSize.getSelectedItem())));
	}
	
	public int getNumber() {
		return this.cbSize.getSelectedIndex();
	}

}
