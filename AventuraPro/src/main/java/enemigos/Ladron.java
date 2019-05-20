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
public class Ladron extends Enemigo{
    int oroRobado;
    HUD consola;
    public Ladron(int oroRobado, int atk, int spd, int hp, int lvl, int expDrop, String nombre, boolean rango,HUD consola) {
        super(atk, spd, hp, lvl, expDrop, nombre, rango,consola);
        this.oroRobado = oroRobado;
    }

    public int getOroRobado() {
        return oroRobado;
    }

    public void setOroRobado(int oroRobado) {
        this.oroRobado = oroRobado;
    }
    
    public void robarOro(Personaje per){
        int rnd=(int) (Math.random()*100);
        consola.mostrarTexto(this.nombre+" intenta robar a "+per.getNombre()+"!");
        if(rnd<=80){
            this.oroRobado=per.getOro()/2;
            per.setOro(this.oroRobado);
            consola.mostrarTexto(this.nombre+" ha robado "+this.oroRobado+" de oro!");        
        }else{
            consola.mostrarTexto(this.nombre+" no ha podido robar nada!");
        }
    }
    
}
