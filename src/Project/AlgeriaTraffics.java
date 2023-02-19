//Mohammedi El hadi Groupe 4

package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlgeriaTraffics extends JFrame {
	
	Dessin d =new Dessin();
	
	public AlgeriaTraffics(){
		setTitle("Algeria Map");
		setSize(1366, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.YELLOW);
		JLabel From = new JLabel("From :");
		JComboBox<String> from = new JComboBox<String>(d.city);
		p1.add(From);
		p1.add(from);
		p1.setBounds(750,130,250, 50);
		panel.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.YELLOW);
		JLabel To = new JLabel("To :");
		JComboBox<String> to = new JComboBox<String>(d.city);
		p2.add(To);
		p2.add(to);
		p2.setBounds(950,130,250, 50);
		panel.add(p2);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.YELLOW);
		JLabel resultat1 = new JLabel("");
		JLabel resultat2 = new JLabel("");
		JLabel resultat3 = new JLabel("");
		JButton valider = new JButton("valider");
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r1 = from.getSelectedIndex();
				int r2 = to.getSelectedIndex();
		        d.getT().dijkstra(d.getMatrice(), r1, r2);
		        resultat1.setForeground(Color.red);
				resultat1.setFont(new Font("Castellar",Font.BOLD,25));
				resultat1.setText("Resultat");
				resultat2.setFont(new Font("Arial",Font.ITALIC,15));
				resultat2.setText(d.getT().getMaChaine2());
				resultat3.setFont(new Font("Arial",Font.ITALIC,15));
				resultat3.setText(d.getT().getMaChaine3());
				if(r1==0 || r2==0 || r1 == r2){
					resultat1.setText("Erreur!");
					resultat2.setText("Select 2 diffrent cities");
					resultat3.setText("");
				}
				repaint();
			}
		});
		JButton reinitialiser = new JButton("reinitialiser");
		reinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultat1.setText("");
				resultat2.setText("");
				resultat3.setText("");
				from.setSelectedIndex(0);
				to.setSelectedIndex(0);
				d.getT().initialiser_matrice(12,12,d.getT().getMat());
				repaint();
			}
		});
		p3.add(valider);
		p3.add(reinitialiser);
		p3.setBounds(730,200,500,60);
		panel.add(p3);
		
		JPanel p4 = new JPanel();
		p4.setBackground(Color.YELLOW);
		p4.add(resultat1);
		p4.setBounds(850,275,300,30);
		panel.add(p4);
		
		JPanel p5 = new JPanel();
		p5.setBackground(Color.YELLOW);
		p5.add(resultat2);
		p5.setBounds(700,350,600,30);
		panel.add(p5);
		
		JPanel p6 = new JPanel();
		p6.setBackground(Color.YELLOW);
		p6.add(resultat3);
		p6.setBounds(700,390,600,30);
		panel.add(p6);
		
		JPanel p7 = new JPanel();
		p7.setBackground(Color.YELLOW);
		p7.setBounds(0,0,1366,768);
		panel.add(p7);
		
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g); //paint existe dans JFrame
		d.dessin(g);
	}
	
}
