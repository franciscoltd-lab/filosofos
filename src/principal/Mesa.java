/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francisco
 */
public class Mesa {
    
    private boolean[] tenedores;
    
    public Mesa(int numTenedores){
        this.tenedores = new boolean[numTenedores];
    }
    
    public int tenedorIzquierda(int i){
        return i;
    }
    
    public int tenedorDerecha(int i){
        
        if(i==0){
            return this.tenedores.length - 1;
        }
        else{
            return i - 1;
        }
    }
    
    public synchronized void agarrarTenedores(int comensal){
        while(tenedores[tenedorIzquierda(comensal)] || tenedores[tenedorDerecha(comensal)]){
            try {
                wait();
                System.out.println("El filoso "+ (comensal + 1)+" está esperando...");
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
    }
    
    public synchronized void dejarTenedores(int comensal){
        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false;
        
        notifyAll();
    }
}
