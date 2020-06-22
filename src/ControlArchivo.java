//Jesus Aristoteles Pacheco Ramirez - A01262378
//Hector Humberto Herrera Macias - A01632115
//Clase: ControlArchivo
//Proyecto: Java Paint

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlArchivo extends JPanel{
	
	private Panel pd;
	
	private TextField tfBorrar,
					  tfMover,
					  tfMover2,
					  tfGuardar,
					  tfAbrir;
	
	private JButton btnBorrar,
				    btnMover,
				    btnGuardar,
				    btnAbrir;
	
	private JLabel lbBorrar,
				   lbMover,
				   lbA,
				   lbGuardar,
				   lbAbrir;
	
	
	public ControlArchivo(Panel pd) {
		super();
		this.setLayout(null);
		this.pd=pd;
		this.setPreferredSize(new Dimension(800,200));
		this.setBackground(Color.lightGray);
		
		//Comandos Borrar
		this.lbBorrar=new JLabel("Borrar");
		this.lbBorrar.setBounds(10, 28, 65, 14);
		this.add(lbBorrar);
		this.tfBorrar=new TextField(20);
		this.tfBorrar.setBounds(75, 25, 75, 25);
		this.add(this.tfBorrar);
		this.btnBorrar=new JButton("Borrar");
		this.btnBorrar.setBounds(300, 25, 150, 25);
		this.btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x=Integer.parseInt(tfBorrar.getText());
				pd.borrarArreglo(x);
				tfBorrar.setText("");
			}
		});
		this.add(btnBorrar);
		
		//Comandos Mover
		this.lbMover=new JLabel("Mover");
		this.lbMover.setBounds(10, 68, 65, 14);
		this.add(lbMover);
		this.tfMover=new TextField(20);
		this.tfMover.setBounds(75, 65,75, 25);
		this.add(tfMover);		
		this.lbA=new JLabel("A");
		this.lbA.setBounds(160, 68, 10, 14);
		this.add(lbA);
		this.tfMover2=new TextField(20);
		this.tfMover2.setBounds(180, 65, 75, 25);
		this.add(tfMover2);
		this.btnMover=new JButton("Mover");
		this.btnMover.setBounds(300, 65, 150, 25);
		this.btnMover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a=Integer.parseInt(tfMover.getText());
				int b=Integer.parseInt(tfMover2.getText());
				pd.setMover(a,b);
				tfMover.setText("");
				tfMover2.setText("");
			}
		});
		this.add(btnMover);
		
		//Comandos Guardar
		this.lbGuardar=new JLabel("Guardar");
		this.lbGuardar.setBounds(10, 108, 65, 14);
		this.add(lbGuardar);
		this.tfGuardar=new TextField(50);
		this.tfGuardar.setBounds(75, 105, 180, 25);
		this.add(tfGuardar);
		this.btnGuardar=new JButton("Guardar");
		this.btnGuardar.setBounds(300, 105, 150, 25);
		this.btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PrintWriter pw= new PrintWriter(new FileWriter(tfGuardar.getText()));
					for (int i = 0; i < pd.getCantidad(); i++) {
						if(pd.getFigura(i)!=null) {
							System.out.println(pd.getFigura(i));
							pw.println(pd.getFigura(i));
							
						}
					}
					tfGuardar.setText("");
					pw.close();
				}
				catch(IOException e) {
					System.out.println("No se puede escribir en el archivo");
				}
			}
		});
		this.add(btnGuardar);
		
		//Comandos Abrir
		this.lbAbrir=new JLabel("Abrir");
		this.lbAbrir.setBounds(10, 148, 65, 14);
		this.add(lbAbrir);
		this.tfAbrir=new TextField(50);
		this.tfAbrir.setBounds(75, 145, 180, 25);
		this.add(tfAbrir);
		this.btnAbrir=new JButton("Abrir");
		this.btnAbrir.setBounds(300, 145, 150, 25);
		this.btnAbrir.addActionListener(new ActionListener() {
			
			private Figura[] figuras;
			private Elipse elipse;
			private Rectangulo rectangulo;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					BufferedReader br=new BufferedReader(new FileReader(tfAbrir.getText()));
					
					String tmp;
					int contadortmp=0;
					BufferedReader br2=new BufferedReader(new FileReader(tfAbrir.getText()));
					while((tmp= br2.readLine())!=null) {
						contadortmp++;
					}
					br2.close();
					
					this.figuras=new Figura[contadortmp];
					
					String strElipse="Elipse";
					String strRectangulo="Rectangulo";
					String strLinea="Linea";
					String strRelleno="true";
					
					int contador=0;
					Color miColor;
					String linea;
					String texto, textoObjeto;
					String font, relleno;
					int x1, y1,
						x2, y2,
						red, green, blue,
						tamanio;
					StringTokenizer st;
					while((linea=br.readLine())!=null){
						st=new StringTokenizer(linea,",");
						texto=st.nextToken();
						if(texto.equals(strRectangulo) || texto.equals(strElipse)) {
							x1=Integer.parseInt(st.nextToken());
							y1=Integer.parseInt(st.nextToken());
							x2=Integer.parseInt(st.nextToken());
							y2=Integer.parseInt(st.nextToken());
							red=Integer.parseInt(st.nextToken());
							green=Integer.parseInt(st.nextToken());
							blue=Integer.parseInt(st.nextToken());
							relleno=st.nextToken();
							miColor=new Color(red, green, blue);
							
							if(texto.equals(strElipse)) {
								if(relleno.equals(strRelleno)) {
									this.figuras[contador]=new Elipse(x1,y1,miColor);
									this.elipse=(Elipse) this.figuras[contador];
									this.elipse.setRelleno(true);
									this.figuras[contador].setFinal(x2, y2);
								}
								else {
									this.figuras[contador]=new Elipse(x1,y1,miColor);
									this.figuras[contador].setFinal(x2, y2);
								}
							}
							else {
								if(relleno.equals(strRelleno)) {
									this.figuras[contador]=new Rectangulo(x1,y1,miColor);
									this.rectangulo=(Rectangulo) this.figuras[contador];
									this.rectangulo.setRelleno(true);
									this.figuras[contador].setFinal(x2, y2);
									
								}
								else {
									this.figuras[contador]=new Rectangulo(x1,y1,miColor);
									this.figuras[contador].setFinal(x2, y2);
								}
							}
							contador++;
						}
						else if(texto.equals(strLinea)){
							x1=Integer.parseInt(st.nextToken());
							y1=Integer.parseInt(st.nextToken());
							x2=Integer.parseInt(st.nextToken());
							y2=Integer.parseInt(st.nextToken());
							red=Integer.parseInt(st.nextToken());
							green=Integer.parseInt(st.nextToken());
							blue=Integer.parseInt(st.nextToken());
							miColor=new Color(red, green, blue);
							
							this.figuras[contador]=new Linea(x1,y1,miColor);
							this.figuras[contador].setFinal(x2, y2);
							contador++;

						}
						else {
							x1=Integer.parseInt(st.nextToken());
							y1=Integer.parseInt(st.nextToken());
							textoObjeto=st.nextToken();
							textoObjeto=textoObjeto.replaceAll("\"", "");
							font=st.nextToken();
							tamanio=Integer.parseInt(st.nextToken());
							red=Integer.parseInt(st.nextToken());
							green=Integer.parseInt(st.nextToken());
							blue=Integer.parseInt(st.nextToken());
							miColor=new Color(red, green, blue);
							Font fnt=new Font(font,Font.PLAIN , tamanio);
							
							this.figuras[contador]=new Texto(textoObjeto, x1, y1, fnt, miColor);
							contador++;
						}
						
					}
					pd.pintaFigura(figuras, contador);
					tfAbrir.setText("");
					br.close();
				}
				catch(IOException e) {
					System.out.println("No se pudo abrir el archivo");
				}
			}
		});
		this.add(btnAbrir);
	}
}
