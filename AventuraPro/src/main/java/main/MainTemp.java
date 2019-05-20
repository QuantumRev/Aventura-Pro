/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import interfaz.Ventana;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.Juego;
import javazoom.jl.decoder.JavaLayerException;
/**
 *
 * @author 1DAM
 */
public class MainTemp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            /*
            EscenarioTemp esc = new EscenarioTemp();
            Scanner sca = new Scanner(System.in);
            int[] posPer = {0,0};
            char mov;
            Arma espadaCorta = new Arma(4,2,false,2,10,"Espada corta");
            Personaje per = new Personaje("Pepe","Normal",3,3,3,15,15,1,0,10,espadaCorta,posPer);
            esc.hasPersonje(per);
            esc.setVisualCasilla("T", 4, 4);
            esc.setVisualCasilla("G", 0, 3);
            esc.getCasillas()[0][3].setEl(new Goblin(5,5,10,1,20,"Goblin"));
            esc.setVisualCasilla("G", 1, 4);
            esc.getCasillas()[1][4].setEl(new Goblin(5,5,10,1,20,"Goblin"));
            esc.setVisualCasilla(")", 0, 4);
            esc.getCasillas()[0][4].setEl(new Arma(7,2,true,3,20,"Arco"));
            esc.setVisualCasilla("S", 2, 4);
            esc.getCasillas()[2][4].setEl(new SoldadoSerpiente(10,10,20,5,50,"Soldado Serpiente"));
            esc.setVisualCasilla("L", 3, 1);
            esc.setVisualCasilla("$", 2, 2);
            consola.mostrarTexto(esc.imprimeEscenario());
            
            while(per.isVivo()){
            consola.mostrarTexto("W: Arriba, S: Abajo, A: Izquierda, D: Derecha, E: Pagina de personaje");
            mov=sca.nextLine().charAt(0);
            per.setPosPer(esc.moverPer(per,mov));
            int x=per.getPosPer()[0];
            int y=per.getPosPer()[1];
            esc.hasPersonje(per);
            consola.mostrarTexto(esc.imprimeEscenario());
            }
            */
    		//Ventana principal = new Ventana();
            Thread t = new Thread(new Juego());
            t.start();
            
        
        
        
    }
    
}
