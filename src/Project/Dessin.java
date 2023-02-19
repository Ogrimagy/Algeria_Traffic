//Mohammedi El hadi Groupe 4

package Project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Dessin extends JFrame {
	
	String city[]= {"          ----","Alger","Oran","Saida","Djelfa","Skikda","Biskra","Laghoat","Ouargla","Adrar","Illizi","Tamanrasset"};
	Point Orn = new Point(250,150);
	Point Sda = new Point(260,180);
	Point Alg = new Point(350,115);
	Point Lgt = new Point(350,190);
	Point Jlf = new Point(340,160);
	Point Skd = new Point(445,115);
	Point Bsk = new Point(435,170);
	Point Org = new Point(410,280);
	Point Adr = new Point(230,410);
	Point Ilz = new Point(490,480);
	Point Tms = new Point(410,560);
	private Dijskra t = new Dijskra();
	
	private int [][] matrice={  ///  ---	 	Alger	   Oran 	  Saida 	Djelfa 	   Skikda     Biskra     Lagouat   Ouargla      Adrar     Illizi   Tamanrasset
								 {    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     }, // ---
					           	 {    0     ,    0     ,d(Alg,Orn),    0     ,d(Alg,Jlf),d(Alg,Skd),d(Alg,Bsk),    0     ,    0     ,    0     ,    0     ,    0     }, //Alger
					           	 {    0     ,d(Orn,Alg),    0     ,d(Orn,Sda),d(Orn,Jlf),    0     ,    0     ,d(Orn,Lgt),    0     ,    0     ,    0     ,    0     }, //Oran
					           	 {    0     ,    0     ,d(Sda,Orn),    0     ,d(Sda,Jlf),    0     ,    0     ,d(Sda,Lgt),d(Sda,Org),d(Sda,Adr),    0     ,    0     }, //Saida
					           	 {    0     ,d(Jlf,Alg),d(Jlf,Orn),d(Jlf,Sda),    0     ,d(Jlf,Skd),d(Jlf,Bsk),d(Jlf,Lgt),    0     ,    0     ,    0     ,    0     }, //Djelfa
					           	 {    0     ,d(Skd,Alg),    0     ,    0     ,d(Skd,Jlf),    0     ,d(Skd,Bsk),    0     ,    0     ,    0     ,    0     ,    0     }, //Skikda
					           	 {    0     ,d(Bsk,Alg),    0     ,    0     ,d(Bsk,Jlf),d(Bsk,Skd),    0     ,d(Bsk,Lgt),d(Bsk,Org),    0     ,    0     ,    0     }, //Biskra
					           	 {    0     ,    0     ,d(Lgt,Orn),d(Lgt,Sda),d(Lgt,Jlf),    0     ,d(Lgt,Bsk),    0     ,d(Lgt,Org),d(Lgt,Adr),    0     ,    0     }, //Laghoat
					           	 {    0     ,    0     ,    0     ,d(Org,Sda),    0     ,    0     ,d(Org,Bsk),d(Org,Lgt),    0     ,d(Org,Adr),d(Org,Ilz),d(Org,Tms)}, //Ourgla 
					           	 {    0     ,    0     ,    0     ,d(Adr,Sda),    0     ,    0     ,    0     ,d(Adr,Lgt),d(Adr,Org),    0     ,d(Adr,Ilz),d(Adr,Tms)}, //Adrar
					           	 {    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,d(Ilz,Org),d(Ilz,Adr),    0     ,d(Ilz,Tms)}, //Illizi
					           	 {    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,    0     ,d(Tms,Org),d(Tms,Adr),d(Tms,Ilz),    0     }, //Tamanrasset
				             };

	public void dessin(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		
		Image  image=Toolkit.getDefaultToolkit().getImage("welcome.gif"); 
		g2.drawImage(image,700,50,600,80,this);
		
		g.setColor(new Color(159,203,238));
		g.fillRect(0,0,600,768);
		g.setColor(Color.black);
		g.drawRect(0,0,600,768);
		
		int[] p3= {  0, 60, 80, 90, 95,120,165,175,190,500,520,540,555,570,580,560,560,570,575,545,585,600,600,  0};
		int[] p4= {240,205,150,150,140,170,160,170,170,105, 90, 90,110,100,110,130,145,155,170,200,240,240,768,768};
		Polygon other = new Polygon(p3, p4, p3.length);
		g.setColor(new Color(231,227,203));
		g.fillPolygon(other);
		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.BOLD,15));
		g.drawString("Morroco",60,280);
		g.drawString("Tunisia",490,210);
		g.drawString("Mali",120,610);
		g.drawString("Libya",550,420);
		g.drawLine(600,240,520,340);
		g.drawPolygon(other);
		
		int[] p5= {  0, 40, 50, 80,100,125,150,170,185,190,210,230,260,240,  0};
		int[] p6= {100, 95, 95,130,130,115,110,120,105,120, 80, 80, 40,  0,  0};
		Polygon spain = new Polygon(p5, p6, p5.length);
		g.setColor(new Color(231,227,203));
		g.fillPolygon(spain);
		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.BOLD,15));
		g.drawString("Spain",100,80);
		g.drawPolygon(spain);
		
		int[] p1= {190,205,200,205,205,225,220,170,170,150,150,100,105, 45, 10, 10,290,290,310,320,350,350,420,600,590,570,550,545,525,540,540,525,515,500,490,470,490,500,490,500,480,470,460,450,440,410,400,360,355,335,330,290,250,240,230};
		int[] p2= {170,180,190,195,230,260,275,275,285,290,320,350,360,360,390,430,630,645,660,660,670,700,680,560,535,520,515,500,470,460,370,340,275,260,240,210,190,165,120,105,110,100,100,105,100,115,115,105,110,110,120,120,145,140,150};
		Polygon algerie = new Polygon(p1, p2, p2.length);
		g.setColor(new Color(103,254,86));
		g.fillPolygon(algerie);
		g.setColor(Color.black);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("Algeria",300,400);
		g.setFont(new Font("Arial",Font.BOLD,9));
		g.drawString("Oran",267,151);
		g.drawString("Saida",233,188);
		g.drawString("Alger",335,105);
		g.drawString("Djelfa",343,172);
		g.drawString("Laghoat",355,197);
		g.drawString("Skikda",445,115);
		g.drawString("Biskra",437,173);
		g.drawString("Ouargla",413,283);
		g.drawString("Adrar",205,412);
		g.drawString("Illizi",493,485);
		g.drawString("Tamanrasset",385,567);
		g.drawPolygon(algerie);
		
		g.setColor(Color.black);
		if(t.Mat[2][3] || t.Mat[3][2]) g.setColor(Color.red);
		g.drawLine((int)Orn.getX(),(int)Orn.getY() , (int)Sda.getX(),(int)Sda.getY());  //	Oran  	->  Saida
		g.setColor(Color.black);
		if(t.Mat[2][1] || t.Mat[1][2]) g.setColor(Color.red);
		g.drawLine((int)Orn.getX(),(int)Orn.getY() , (int)Alg.getX(),(int)Alg.getY());	//	Oran  	->  Alger
		g.setColor(Color.black);
		if(t.Mat[2][4] || t.Mat[4][2]) g.setColor(Color.red);
		g.drawLine((int)Orn.getX(),(int)Orn.getY() , (int)Jlf.getX(),(int)Jlf.getY());	//	Oran  	->  Djelfa
		g.setColor(Color.black);
		if(t.Mat[2][7] || t.Mat[7][2]) g.setColor(Color.red);
		g.drawLine((int)Orn.getX(),(int)Orn.getY() , (int)Lgt.getX(),(int)Lgt.getY());	//	Oran  	->  Laghoat
		g.setColor(Color.black);
		if(t.Mat[1][4] || t.Mat[4][1]) g.setColor(Color.red);
		g.drawLine((int)Alg.getX(),(int)Alg.getY() , (int)Jlf.getX(),(int)Jlf.getY());	// 	Alger 	->	Djelfa
		g.setColor(Color.black);
		if(t.Mat[1][5] || t.Mat[5][1]) g.setColor(Color.red);
		g.drawLine((int)Alg.getX(),(int)Alg.getY() , (int)Skd.getX(),(int)Skd.getY());	// 	Alger 	->	Skikda
		g.setColor(Color.black);
		if(t.Mat[1][6] || t.Mat[6][1]) g.setColor(Color.red);
		g.drawLine((int)Alg.getX(),(int)Alg.getY() , (int)Bsk.getX(),(int)Bsk.getY());	// 	Alger 	->	Biskra
		g.setColor(Color.black);
		if(t.Mat[3][9] || t.Mat[9][3]) g.setColor(Color.red);
		g.drawLine((int)Sda.getX(),(int)Sda.getY() , (int)Adr.getX(),(int)Adr.getY());	//	Saida	->	Adrar
		g.setColor(Color.black);
		if(t.Mat[4][3] || t.Mat[3][4]) g.setColor(Color.red);
		g.drawLine((int)Sda.getX(),(int)Sda.getY() , (int)Jlf.getX(),(int)Jlf.getY());	//	Saida  ->  Djelfa
		g.setColor(Color.black); 
		if(t.Mat[3][8] || t.Mat[8][3]) g.setColor(Color.red); 
		g.drawLine((int)Sda.getX(),(int)Sda.getY() , (int)Org.getX(),(int)Org.getY());	//	Saida 	->  Ouargla
		g.setColor(Color.black);
		if(t.Mat[7][9] || t.Mat[9][7]) g.setColor(Color.red);
		g.drawLine((int)Lgt.getX(),(int)Lgt.getY() , (int)Adr.getX(),(int)Adr.getY());	//  Laghoat ->  Adrar
		g.setColor(Color.black);
		if(t.Mat[4][7] || t.Mat[7][4]) g.setColor(Color.red);
		g.drawLine((int)Jlf.getX(),(int)Jlf.getY() , (int)Lgt.getX(),(int)Lgt.getY());	//	Djelfa 	->  Lagouat
		g.setColor(Color.black);
		if(t.Mat[7][8] || t.Mat[8][7]) g.setColor(Color.red); 
		g.drawLine((int)Lgt.getX(),(int)Lgt.getY() , (int)Org.getX(),(int)Org.getY());	//	Laghoat ->  Ouargla
		g.setColor(Color.black);
		if(t.Mat[8][10] || t.Mat[10][8]) g.setColor(Color.red);
		g.drawLine((int)Org.getX(),(int)Org.getY() , (int)Ilz.getX(),(int)Ilz.getY());	//	Ouargla	->	Illizi
		g.setColor(Color.black);
		if(t.Mat[10][11] || t.Mat[11][10]) g.setColor(Color.red);
		g.drawLine((int)Ilz.getX(),(int)Ilz.getY() , (int)Tms.getX(),(int)Tms.getY());	//	Illizi	->	Tamanrasset
		g.setColor(Color.black);
		if(t.Mat[9][11] || t.Mat[11][9]) g.setColor(Color.red);
		g.drawLine((int)Adr.getX(),(int)Adr.getY() , (int)Tms.getX(),(int)Tms.getY());	//	Adrar	->	Tamanrasset
		g.setColor(Color.black);
		if(t.Mat[9][10] || t.Mat[10][9]) { g.setColor(Color.red); }
		g.drawLine((int)Adr.getX(),(int)Adr.getY() , (int)Ilz.getX(),(int)Ilz.getY());	//	Adrar	->	Illizi
		g.setColor(Color.black);
		if(t.Mat[8][9] || t.Mat[9][8]) g.setColor(Color.red);
		g.drawLine((int)Org.getX(),(int)Org.getY() , (int)Adr.getX(),(int)Adr.getY());	//	Ouargla ->  Adrar
		g.setColor(Color.black);
		if(t.Mat[8][11] || t.Mat[11][8]) g.setColor(Color.red);
		g.drawLine((int)Org.getX(),(int)Org.getY() , (int)Tms.getX(),(int)Tms.getY());	//	Ouargla ->  Tamanrasset
		g.setColor(Color.black);
		if(t.Mat[6][7] || t.Mat[7][6]) g.setColor(Color.red);
		g.drawLine((int)Lgt.getX(),(int)Lgt.getY() , (int)Bsk.getX(),(int)Bsk.getY());	//	Laghoat	->  Biskra
		g.setColor(Color.black);
		if(t.Mat[6][8] || t.Mat[8][6]) g.setColor(Color.red);
		g.drawLine((int)Bsk.getX(),(int)Bsk.getY() , (int)Org.getX(),(int)Org.getY());	//	Biskra	->  Ouargla
		g.setColor(Color.black);
		if(t.Mat[7][9] || t.Mat[9][7]) g.setColor(Color.red);
		g.drawLine((int)Lgt.getX(),(int)Lgt.getY() , (int)Adr.getX(),(int)Adr.getY());	//	Laghoat	->  Adrar
		g.setColor(Color.black);
		if(t.Mat[4][6] || t.Mat[6][4]) g.setColor(Color.red);
		g.drawLine((int)Jlf.getX(),(int)Jlf.getY() , (int)Bsk.getX(),(int)Bsk.getY());	//	Djelfa	->  Biskra
		g.setColor(Color.black);
		if(t.Mat[5][6] || t.Mat[6][5]) g.setColor(Color.red);
		g.drawLine((int)Skd.getX(),(int)Skd.getY() , (int)Bsk.getX(),(int)Bsk.getY());	//	Skikda	->  Biskra
		g.setColor(Color.black);
		if(t.Mat[4][5] || t.Mat[5][4]) g.setColor(Color.red);
		g.drawLine((int)Jlf.getX(),(int)Jlf.getY() , (int)Skd.getX(),(int)Skd.getY());	// 	Djelfa 	->	Skikda
		g.setColor(Color.black);
		if(t.Mat[3][7] || t.Mat[7][3]) g.setColor(Color.red);
		g.drawLine((int)Sda.getX(),(int)Sda.getY() , (int)Lgt.getX(),(int)Lgt.getY());	// 	Saida 	->	Laghouat

			
	}
	
	public static int d(Point p1, Point p2){
		return (int) Math.sqrt(Math.pow(p2.getY()-p1.getY(), 2)+Math.pow(p2.getX()-p1.getX(), 2));
	}
	
	public Dijskra getT() {
		return t;
	}
	
	public int[][] getMatrice() {
		return matrice;
	}
	
}
