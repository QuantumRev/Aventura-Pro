/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author 1DAM
 */
public class Casilla {
    int[] posCasilla;
    String visual;
    Elemento el;

    public Casilla(int[] posCasilla,String visual) {
        this.posCasilla = posCasilla;
        this.visual=visual;
    }

    public int[] getPosCasilla() {
        return posCasilla;
    }

    public void setPosCasillaX(int[] posCasilla) {
        this.posCasilla = posCasilla;
    }

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public Elemento getEl() {
        return el;
    }

    public void setEl(Elemento el) {
        this.el = el;
    }
    
    
}
