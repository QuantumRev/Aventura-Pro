/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import sonido.MusicPlayer;
import enemigos.SoldadoSerpiente;
import interfaz.HUD;
import interfaz.Ventana;
import enemigos.Enemigo;
import enemigos.Goblin;
import enemigos.Ladron;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author 1DAM
 */
public class Juego implements Runnable {
    EscenarioTemp esc = new EscenarioTemp();
    Thread backGroundMusic;
    MusicPlayer plains;
    HUD hud;
    private volatile boolean exit = false;
    
    public Thread getBackGroundMusic() {
        return backGroundMusic;
    }

    public void setBackGroundMusic(Thread backGroundMusic) {
        this.backGroundMusic = backGroundMusic;
    }
    public void compruebaCasilla(Personaje per) throws InterruptedException{
        try {
            Casilla cas = this.esc.casillas[per.getPosPer()[0]][per.getPosPer()[1]];
            switch(cas.getVisual()){
                case "G":
                    plains.stop();
                    Enemigo en=(Enemigo) cas.getEl();
                    MusicPlayer alert=new MusicPlayer("alert");
                    alert.run();
                    MusicPlayer TOGT=new MusicPlayer("TOTG");
                    new Thread(TOGT).start();
                    while((per.vivo==true)&&(en.getHp()>0)){
                    	per.combate(en);
                    }
                    TOGT.stop();
                    plains=new MusicPlayer("plains");
                    backGroundMusic=new Thread(plains);
                    backGroundMusic.start();
                    this.esc.guardCas="#";
                    break;
                case "$":
                	hud.getTp().setText("Has obtenido 10 de oro!");
                    per.setOro(per.getOro()+10);
                    this.esc.guardCas="#";
                    break;
                case ")":
                    Arma ar=(Arma) cas.getEl();
                    per.getInventario().add(new Arma(7,2,true,3,20,"Arco"));
                    hud.getTp().setText("Has obtenido un Arco! ");
                    this.esc.guardCas="#";
                    break;
                case "S":
                    Enemigo en2=(Enemigo) cas.getEl();
                    per.combate(en2);
                    this.esc.guardCas="#";
                    break;
                case "L":
                    Enemigo en3=(Ladron) cas.getEl();
                    per.combate(en3);
                    this.esc.guardCas="#";
                    break;
                case "T":
                    Tienda td=(Tienda) cas.getEl();
                    td.vender(per);
                    this.esc.guardCas="T";
                    break;   
            }
        } catch (JavaLayerException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int[] moverPer(Personaje per, char mov,MusicPlayer music) throws InterruptedException{
        int[] posPer=per.getPosPer();
        switch(mov){
            case 'w':{
            esc.casillas[posPer[0]][posPer[1]].setVisual(esc.guardCas);
            posPer[0]-=1;
            if(posPer[0]==-1){
                posPer[0]=esc.casillas.length-1;
            }
            esc.guardCas=esc.casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            esc.casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 's':{
            esc.casillas[posPer[0]][posPer[1]].setVisual(esc.guardCas);
            posPer[0]+=1;
            if(posPer[0]==esc.casillas.length){
                posPer[0]=0;
            }
            esc.guardCas=esc.casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            esc.casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 'a':{
            esc.casillas[posPer[0]][posPer[1]].setVisual(esc.guardCas);
            posPer[1]-=1;
            if(posPer[1]==-1){
                posPer[1]=esc.casillas.length-1;
            }
            esc.guardCas=esc.casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            esc.casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 'd':{
            esc.casillas[posPer[0]][posPer[1]].setVisual(esc.guardCas);
            posPer[1]+=1;
            if(posPer[1]==esc.casillas.length){
                posPer[1]=0;
            }
            esc.guardCas=esc.casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            esc.casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 'e':{
        	hud.getTp().setText(per.muestaPagPer()+"\n");
            break;
        }
        case 'i':{
            per.abreInventario();
            break;
        }
        }
        
        return posPer;
    
    }
    
    @Override
    public void run(){
        while(!exit){
            Ventana ventanaJuego = new Ventana();
            hud = new HUD(esc);
            try {
				plains=new MusicPlayer("plains");
			} catch (JavaLayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            backGroundMusic=new Thread(plains);
            
            Scanner sca = new Scanner(System.in);
            int[] posPer = {0,0};
            char mov;
            Arma espadaCorta = new Arma(4,2,false,2,10,"Espada corta");
            Personaje per = new Personaje("Pepe","Normal",3,3,3,15,15,1,0,10,espadaCorta,posPer,hud);
            esc.hasPersonje(per);
            esc.setVisualCasilla("T", 4, 4);
            esc.getCasillas()[4][4].setEl(new Tienda(hud));
            esc.setVisualCasilla("G", 0, 3);
            esc.getCasillas()[0][3].setEl(new Goblin(5,5,10,1,20,"Goblin",false,hud));
            esc.setVisualCasilla("G", 1, 4);
            esc.getCasillas()[1][4].setEl(new Goblin(5,5,10,1,20,"Goblin",false,hud));
            esc.setVisualCasilla(")", 0, 4);
            esc.getCasillas()[0][4].setEl(new Arma(7,2,true,3,20,"Arco"));
            esc.setVisualCasilla("S", 2, 4);
            esc.getCasillas()[2][4].setEl(new SoldadoSerpiente(10,10,20,5,50,"Soldado Serpiente",true,hud));
            esc.setVisualCasilla("L", 3, 1);
            esc.getCasillas()[3][1].setEl(new Ladron(0,5,10,25,3,20,"Ladron",false,hud));
            esc.setVisualCasilla("$", 2, 2);
            hud.updateMap(esc);
            ventanaJuego.setHud(hud);
            
            backGroundMusic.start();
            hud.left.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent arg0) {
    				try {
						per.setPosPer(moverPer(per,'a',plains));
						int x=per.getPosPer()[0];
	                    int y=per.getPosPer()[1];
	                    esc.hasPersonje(per);
						hud.updateMap(esc);
		                ventanaJuego.setHud(hud);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
    			}
    		});
            hud.right.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent arg0) {
    				try {
						per.setPosPer(moverPer(per,'d',plains));
						int x=per.getPosPer()[0];
	                    int y=per.getPosPer()[1];
	                    esc.hasPersonje(per);
						hud.updateMap(esc);
		                ventanaJuego.setHud(hud);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
    			}
    		});
            hud.up.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent arg0) {
    				try {
						per.setPosPer(moverPer(per,'w',plains));
						int x=per.getPosPer()[0];
	                    int y=per.getPosPer()[1];
	                    esc.hasPersonje(per);
						hud.updateMap(esc);
		                ventanaJuego.setHud(hud);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
    			}
    		});
            hud.down.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent arg0) {
    				try {
						per.setPosPer(moverPer(per,'s',plains));
						int x=per.getPosPer()[0];
	                    int y=per.getPosPer()[1];
	                    esc.hasPersonje(per);
						hud.updateMap(esc);
		                ventanaJuego.setHud(hud);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
    			}
    		});
            /*while(per.isVivo()==true){
            	hud.updateMap(esc);
                ventanaJuego.setHud(hud);
                System.out.println("W: Arriba, S: Abajo, A: Izquierda, D: Derecha, E: Pagina de personaje, I: Inventario");
                //hud.getTp().setText("W: Arriba, S: Abajo, A: Izquierda, D: Derecha, E: Pagina de personaje, I: Inventario");
                mov=sca.nextLine().charAt(0);
                per.setPosPer(moverPer(per,mov,plains));
                int x=per.getPosPer()[0];
                int y=per.getPosPer()[1];
                esc.hasPersonje(per);
            }*/
            
            //plains.stop();
            this.stop();
           
        } 
        
        
    }
    public void stop(){
        exit=true;
    }
}
