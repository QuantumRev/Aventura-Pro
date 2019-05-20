/*
 * To change this license header, choose License Headers in Project Prothisties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import enemigos.Enemigo;
import enemigos.Ladron;
import interfaz.HUD;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextPane;

/**
 *
 * @author 1DAM
 */
public class Personaje {
    String nombre,status;
    int atk,spd,spdActual,hp,hpActual,lvl,exp,oro;
    Arma armaEq;
    ArrayList<Objeto> inventario;
    int[] posPer;
    boolean vivo,huir,combate;
    HUD consola;
    String acc="nada";
    

    public Personaje(String nombre, String status, int atk, int spd,int spdActual, int hp,int hpActual, int lvl, int exp, int oro, Arma armaEq, int[] posPer,HUD consola) {
        this.nombre = nombre;
        this.status = status;
        this.atk = atk;
        this.spd = spd;
        this.spdActual=spdActual;
        this.hp = hp;
        this.hpActual=hpActual;
        this.lvl = lvl;
        this.exp = exp;
        this.oro = oro;
        this.armaEq = armaEq;
        this.inventario = new ArrayList<>();
        this.inventario.add(new Objeto(98,5,"Pocion"));
        this.posPer = posPer; 
        this.vivo=true;
        this.huir=false;
        this.combate=false;
        this.consola=consola;
        
        consola.atacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				acc="Atacar";
			}
		});
        consola.objetos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				acc="Objetos";
			}
		});
        consola.huir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				acc="Huir";
			}
		});
    }

    //getter setter begin
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getSpdActual() {
        return spdActual;
    }

    public void setSpdActual(int spdActual) {
        this.spdActual = spdActual;
    }
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpActual() {
        return hpActual;
    }

    public void setHpActual(int hpActual) {
        this.hpActual = hpActual;
    }
    
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public Arma getArmaEq() {
        return armaEq;
    }

    public void setArmaEq(Arma armaEq) {
        this.armaEq = armaEq;
    }

    public ArrayList<Objeto> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Objeto> inventario) {
        this.inventario = inventario;
    }

    public int[] getPosPer() {
        return posPer;
    }

    public void setPosPer(int[] posPer) {
        this.posPer = posPer;
    }

    public boolean isVivo() {
        return vivo;
    }
    public void setAcc(String acc) {
    	this.acc=acc;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    
    //getter setter end
    
    public void cogerObjeto(Objeto obj){
        this.inventario.add(obj);
    }
    public void checkStatus(){
        switch(this.status){
            case "Poison":
                this.hpActual=hpActual-3;
                break;
            case "Paralized":
                this.spdActual=spdActual/2;
                break;
            case "Normal":
                this.spdActual=spd;
                break;
        }
    }
    public void comprar(Objeto obj){
        this.oro=this.oro-obj.getValue();
        this.inventario.add(obj);
    }
    public String muestaPagPer(){
        return "Nombre: "+this.nombre+" "+"HP: "+this.hp+"/"+this.hpActual+" Ataque: "+(this.atk+this.armaEq.getAtk())+"\n"+
               "Fuerza: "+this.atk+" Velocidad: "+this.spd+" Oro: "+this.oro;
                
    }
    
    public void atacar(Enemigo en){
        if((en.isRango()==true)&&(this.armaEq.isRango()==false)){
            consola.mostrarTexto("Necesitas un arma de rango!");
        }
        else{
            en.setHp(en.getHp()-(this.atk+this.armaEq.getAtk()));
            consola.mostrarTexto(en.getNombre()+" ha recibido "+(this.atk+this.armaEq.getAtk())+" de daño!");
        }  
    }
    public void abreInventario(){
                    Objeto salir = new Objeto(99,0,"Salir");
                    this.getInventario().add(salir);
                    consola.mostrarTexto("Inventario: \n");
                    Scanner scaObj = new Scanner(System.in);
                    for(int i=0;i<this.getInventario().size();i++){
                        consola.mostrarTexto(i+" "+this.getInventario().get(i).getNombre());
                    }
                    
                    consola.mostrarTexto("\nUsar objeto (id): ");
                    int op=scaObj.nextInt();
                    switch(this.getInventario().get(op).getNombre()){
                        case "Pocion":
                            this.setHpActual(this.getHpActual()+15);
                            consola.mostrarTexto(this.getNombre()+" se ha curado 15HP");
                            this.getInventario().remove(op);
                            break;
                        case "Bomba de humo":
                            if(this.combate){
                                this.huir=true;
                                consola.mostrarTexto(this.getNombre()+" ha usado una bomba de humo!");
                                this.getInventario().remove(op);
                            }
                            else{
                                consola.mostrarTexto(this.getInventario().get(op).getNombre()+" solo se puede usar en combate!");
                            }
                            break;
                        case "Arco":
                            this.getInventario().add(this.getArmaEq());
                            this.setArmaEq(new Arma(7,2,true,3,20,"Arco"));
                            this.getInventario().remove(op);
                            break;
                        case "Espada corta":
                            this.getInventario().add(this.getArmaEq());
                            this.setArmaEq(new Arma(4,2,false,2,10,"Espada corta"));
                            this.getInventario().remove(op);
                            break;
                        case "Hacha de guerra":
                            this.getInventario().add(this.getArmaEq());
                            this.setArmaEq(new Arma(10,3,false,3,25,"Hacha de guerra"));
                            this.getInventario().remove(op);
                            break;
                        case "Salir":
                            break;
                    }
                    this.getInventario().remove(salir);
    }
    
    public void combate(Enemigo en){
        this.combate=true;
        Ladron ld=null;
        this.huir=false;
        if(en.getNombre().equals("Ladron")){
            ld=(Ladron)en;
        }
        consola.mostrarTexto("Un "+en.getNombre()+" ataca!");
        
        
            consola.mostrarTexto("Elija una accion: ");
            consola.mostrarTexto("Atacar - Objetos - Huir\n");
            /*while (!acc.equals("Atacar")&&(!acc.equals("Objetos"))&&(!acc.equals("Huir"))){
                consola.mostrarTexto("Atacar - Objetos - Huir\n");
            }
            */
            switch(acc){
                case "Atacar":
                    atacar(en);
                    acc="";
                    break;
                case "Objetos":
                    abreInventario();
                    acc="";
                    break;
                case "Huir":
                    int rnd=(int) (Math.random()*100);
                    if(rnd<=40){
                    huir=true;
                    }
                    else{
                        consola.mostrarTexto(this.getNombre()+" no ha podido huir!");
                    }
                    acc="";
                    break;    
            }
            if(huir==true){
                    consola.mostrarTexto(this.getNombre()+" ha huido!");
            }
            else if(ld==null){
                if(en.getHp()>0){
                consola.mostrarTexto("\n");
                en.atacar(this);
                }
                else{
                    consola.mostrarTexto(en.getNombre()+" ha sido derrotado!");
                }
                if(this.hpActual<=0){
                    this.vivo=false;
                    consola.mostrarTexto(this.nombre+" ha muerto!");
                }
                
                consola.mostrarTexto("\n");
                
            }
            else{
                if(ld.getHp()>0){
                    if(ld.getOroRobado()==0){
                        ld.robarOro(this);
                    }
                    else{
                        int rnd=(int) (Math.random()*100);
                        consola.mostrarTexto(ld.getNombre()+" intenta escapar!");
                        if(rnd<=35){
                             this.huir=true;
                             consola.mostrarTexto(ld.getNombre()+" ha huido con "+ld.getOroRobado()+" de oro!");
                             consola.mostrarTexto("\n");
                        }else{
                            consola.mostrarTexto(ld.getNombre()+" no ha podido huir!");
                        }
                    }
                }
                else{
                 consola.mostrarTexto(en.getNombre()+" ha sido derrotado!");
                 this.oro=this.oro+ld.getOroRobado();
                    consola.mostrarTexto(this.nombre+" ha recuperado "+ld.getOroRobado()+" de oro!");
                }
                if(this.hpActual<=0){
                    this.vivo=false;
                    consola.mostrarTexto(this.nombre+" ha muerto!");
                }
                
                consola.mostrarTexto("\n");
                
        }
        this.combate=false;
        this.huir=false;
    }
    
    
    
    
    
    
    
    
    
}
