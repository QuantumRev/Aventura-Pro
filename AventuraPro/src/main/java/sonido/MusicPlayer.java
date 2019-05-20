/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonido;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author 1DAM
 */
public class MusicPlayer implements Runnable {
    String cancion;
    Player mp3;
    public void run(){
        
            try {
                try {
                    mp3=new Player(new FileInputStream("./audio/"+this.cancion+".mp3"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.mp3.play();
        } catch (JavaLayerException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void stop(){
        this.mp3.close();
    }
    
    public MusicPlayer(String cancion) throws JavaLayerException {
            this.cancion = cancion;       
    }
    
  
    
}
