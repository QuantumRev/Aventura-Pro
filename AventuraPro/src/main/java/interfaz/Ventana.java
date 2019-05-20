package interfaz;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import clases.Arma;
import clases.Casilla;
import clases.EscenarioTemp;
import clases.Juego;
import clases.Personaje;
import clases.Tienda;
import enemigos.Enemigo;
import enemigos.Goblin;
import enemigos.Ladron;
import enemigos.SoldadoSerpiente;
import javazoom.jl.decoder.JavaLayerException;
import sonido.MusicPlayer;



public class Ventana extends JFrame{
	public Ventana() {
		super();
		this.setTitle("Mi programa");
		this.setSize(650, 500);
		this.setContentPane(new HUD(new EscenarioTemp()));
		this.setResizable(false);
		this.setVisible(true);
	}
	public void setHud(HUD hud) {
		this.setContentPane(hud);
	}
}
