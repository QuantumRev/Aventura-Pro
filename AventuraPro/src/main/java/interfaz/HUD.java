package interfaz;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import clases.Casilla;
import clases.EscenarioTemp;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HUD extends JPanel{
	private JLabel[][] casillas;
	private JPanel lblPanel;
	private JTextPane tp;
	public JButton up,down,left,right,atacar,huir,objetos;
	
	public void updateMap(EscenarioTemp esc) {
		Casilla[][] cas=esc.getCasillas();
		for(int i=0;i<casillas.length;i++) {
			for(int j=0;j<casillas[0].length;j++) {
				casillas[i][j].setText("        "+cas[i][j].getVisual());
			}
		}
	}
	public JTextPane getTp() {
		return this.tp;
	}
	public void mostrarTexto(String texto) {
		this.tp.setText(tp.getText()+"\n"+texto);
	}
	public HUD(EscenarioTemp esc) {
		Casilla[][] cas = esc.getCasillas();
		casillas=new JLabel[cas.length][cas[0].length];
		setBackground(Color.GRAY);
		setSize(650,450);
		setLayout(null);
		
		tp = new JTextPane();
		JScrollPane sp = new JScrollPane(tp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(25, 25, 290, 229);
		add(sp);
		
		lblPanel = new JPanel();
		lblPanel.setBounds(325, 25, 300, 300);
		add(lblPanel);
		lblPanel.setLayout(new GridLayout(5, 5, 0, 0));
		for(int i=0;i<casillas.length;i++) {
			for(int j=0;j<casillas[0].length;j++) {
				casillas[i][j]=new JLabel("        "+cas[i][j].getVisual());
				casillas[i][j].setName("lbl"+i+j);
				lblPanel.add(casillas[i][j]);
			}
		}
		
		atacar = new JButton("Atacar");
		
		atacar.setBounds(25, 269, 89, 23);
		add(atacar);
		
		objetos = new JButton("Objetos");
		objetos.setBounds(125, 269, 89, 23);
		add(objetos);
		
		huir = new JButton("Huir");
		huir.setBounds(226, 269, 89, 23);
		add(huir);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(25, 303, 89, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(125, 303, 89, 23);
		add(btnNewButton_4);
		
		left = new JButton("<");
		left.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		left.setBounds(25, 385, 89, 23);
		add(left);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(226, 303, 89, 23);
		add(btnNewButton_6);
		
		right = new JButton(">");
		
		right.setBounds(226, 385, 89, 23);
		add(right);
		
		up = new JButton("^");
		up.setBounds(125, 351, 89, 23);
		add(up);
		
		down = new JButton("v");
		down.setBounds(125, 416, 89, 23);
		add(down);
		
	
		
		
	}
}
