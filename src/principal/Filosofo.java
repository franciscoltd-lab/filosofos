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
public class Filosofo extends Thread {
    private Mesa mesa;
    private int comensal;
    private int indiceComensal;
    
    public Filosofo(Mesa mesa, int comensal){
        this.mesa = mesa;
        this.comensal = comensal;
        this.indiceComensal = comensal -1;
    }
    
    public void run(){
        while(true){
            this.pensando();
            this.mesa.agarrarTenedores(this.indiceComensal);
            this.comiendo();
            System.out.println("Filosofo "+comensal+" deja de comer!, tenedores libres " + (this.mesa.tenedorIzquierda(this.indiceComensal) + 1) + ", " + (this.mesa.tenedorDerecha(this.indiceComensal) + 1));
            this.mesa.dejarTenedores(this.indiceComensal);
        }
    }
    
    public void pensando() {

        System.out.println("Filosofo "+comensal+" está pensando...");

        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) {
        }
    }

    public void comiendo() {

        System.out.println("Filosofo "+comensal+" está comiendo...");
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) {
        }
    }
            
}
