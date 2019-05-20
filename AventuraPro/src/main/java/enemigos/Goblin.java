/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemigos;

import javax.swing.JTextPane;

import clases.Personaje;
import interfaz.HUD;

/**
 *
 * @author 1DAM
 */
public class Goblin extends Enemigo{
	HUD consola;
    public Goblin(int atk, int spd, int hp, int lvl, int expDrop, String nombre, boolean rango, HUD consola) {
		super(atk, spd, hp, lvl, expDrop, nombre, rango, consola);
	}

	public void ataqueParalisis(Personaje per){
        per.setHpActual(per.getHpActual()-(this.getAtk()/2));
        int rnd=(int) (Math.random()*100);
        if(rnd<=40){
            per.setStatus("Paralized");
        }
    }
}
