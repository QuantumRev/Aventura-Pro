/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextPane;

import interfaz.HUD;

/**
 *
 * @author 1DAM
 */
public class Tienda extends Elemento {
    ArrayList<Objeto> inventario;
    HUD consola;

    public Tienda(HUD consola) {
        ArrayList<Objeto> inv = new ArrayList<>();
        inv.add(new Objeto(98,10,"Pocion"));
        inv.add(new Objeto(97,5,"Bomba de humo"));
        inv.add(new Arma(10,3,false,3,25,"Hacha de guerra"));
        this.consola=consola;
        this.inventario = inv;
    }

    public ArrayList<Objeto> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Objeto> inventario) {
        this.inventario = inventario;
    }
    
    public void vender(Personaje per){
        Objeto salir = new Objeto(99,0,"Salir");
                    this.getInventario().add(salir);
                    consola.mostrarTexto("Tienda: \n");
                    Scanner scaObj = new Scanner(System.in);
                    for(int i=0;i<this.getInventario().size();i++){
                        consola.mostrarTexto(i+" "+this.getInventario().get(i).getNombre());
                    }
                    
                    consola.mostrarTexto("\nComprar objeto (id): ");
                    int op=scaObj.nextInt();
                    switch(this.getInventario().get(op).getNombre()){
                        case "Pocion":
                            if(per.getOro()>=this.inventario.get(op).getValue()){
                                per.setOro(per.getOro()-this.inventario.get(op).value);
                                per.getInventario().add(this.inventario.get(op));
                                consola.mostrarTexto(per.getNombre()+" ha comprado una "+this.inventario.get(op).getNombre()+"!");
                            }else{
                                consola.mostrarTexto(per.getNombre()+" no tiene suficiente oro!");
                            }
                            break;
                        case "Hacha de guerra":
                            if(per.getOro()>=this.inventario.get(op).getValue()){
                                per.setOro(per.getOro()-this.inventario.get(op).value);
                                per.getInventario().add(this.inventario.get(op));
                                consola.mostrarTexto(per.getNombre()+" ha comprado una "+this.inventario.get(op).getNombre()+"!");
                            }else{
                                consola.mostrarTexto(per.getNombre()+" no tiene suficiente oro!");
                            }
                            break;
                        case "Bomba de humo":
                            if(per.getOro()>=this.inventario.get(op).getValue()){
                                per.setOro(per.getOro()-this.inventario.get(op).value);
                                per.getInventario().add(this.inventario.get(op));
                                consola.mostrarTexto(per.getNombre()+" ha comprado una "+this.inventario.get(op).getNombre()+"!");
                            }else{
                                consola.mostrarTexto(per.getNombre()+" no tiene suficiente oro!");
                            }
                            break;
                        case "Salir":
                            break;
                    }
                    this.getInventario().remove(salir);
    }
    
}
