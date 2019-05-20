/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1DAM
 */
public class EscenarioTemp {
    public Casilla[][] casillas = new Casilla[5][5];
    public String guardCas="#";

    public EscenarioTemp() {
        creaEscenario();
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public String getGuardCas() {
        return guardCas;
    }

    public void setGuardCas(String guardCas) {
        this.guardCas = guardCas;
    }
    
    
    public void creaEscenario(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int[] posCas={i,j};
                this.casillas[i][j]=new Casilla(posCas,"#");
            }
        }
    }
    public String imprimeEscenario(){
        String fin="";
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                fin+=this.casillas[i][j].getVisual()+" ";
                ;
            }
            fin+="\n";
        }
        return fin;
    }
    public void hasPersonje(Personaje per){
        for(int i=0;i<this.casillas.length;i++){
            for(int j=0;j<casillas[i].length;j++){
                if((i==per.getPosPer()[0])&&(j==per.getPosPer()[1])){
                    casillas[i][j].setVisual("P");
                }
            }
        }   
    }
    public void setVisualCasilla(String visual,int pos1,int pos2){
        casillas[pos1][pos2].setVisual(visual);
    }
    /*
    public void compruebaCasilla(Personaje per){
        Casilla cas = casillas[per.getPosPer()[0]][per.getPosPer()[1]];
        switch(cas.getVisual()){
            case "G":
                Enemigo en=(Enemigo) cas.getEl();
                per.combate(en);
                this.guardCas="#";
                break;
            case "$":
                consola.mostrarTexto("Has obtenido 10 de oro!");
                per.setOro(per.getOro()+10);  
                this.guardCas="#";
                break;
            case ")":
                Arma ar=(Arma) cas.getEl();
                per.getInventario().add(new Arma(7,2,true,3,20,"Arco"));
                consola.mostrarTexto("Has obtenido un Arco! ");
                this.guardCas="#";
                break;
            case "S":
                Enemigo en2=(Enemigo) cas.getEl();
                per.combate(en2);
                this.guardCas="#";
                break;
        }
    }*/
    /*
    public int[] moverPer(Personaje per, char mov){
        int[] posPer=per.getPosPer();
        switch(mov){
            case 'w':{
            casillas[posPer[0]][posPer[1]].setVisual(this.guardCas);
            posPer[0]-=1;
            if(posPer[0]==-1){
                posPer[0]=casillas.length-1;
            }
            this.guardCas=casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 's':{
            casillas[posPer[0]][posPer[1]].setVisual(this.guardCas);
            posPer[0]+=1;
            if(posPer[0]==casillas.length){
                posPer[0]=0;
            }
            this.guardCas=casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 'a':{
            casillas[posPer[0]][posPer[1]].setVisual(this.guardCas);
            posPer[1]-=1;
            if(posPer[1]==-1){
                posPer[1]=casillas.length-1;
            }
            this.guardCas=casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 'd':{
            casillas[posPer[0]][posPer[1]].setVisual(this.guardCas);
            posPer[1]+=1;
            if(posPer[1]==casillas.length){
                posPer[1]=0;
            }
            this.guardCas=casillas[posPer[0]][posPer[1]].getVisual();
            compruebaCasilla(per);
            casillas[posPer[0]][posPer[1]].setVisual("P");
            break;
        }
        case 'e':{
            consola.mostrarTexto(per.muestaPagPer()+"\n");
            break;
        }
        case 'i':{
            per.abreInventario();
            break;
        }
        }
        
        return posPer;
    
    }*/
}
