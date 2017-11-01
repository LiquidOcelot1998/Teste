/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filacaixa;
import java.util.Random;
/**
 *
 * @author gabri
 */
public class Cliente {
    private int item;
    private int tempoChegada;
    private int tempoNoCaixa;
    private Cliente prox;
    private Random rand = new Random();
    
    public Cliente(int item, int tempoChegada) {
        this.item = item;
        this.prox = null;
        this.tempoChegada = tempoChegada;
        this.tempoNoCaixa = rand.nextInt(100) + 0;
        if (this.tempoNoCaixa <= 15) {
            this.tempoNoCaixa = 1;
        } else {
            if (this.tempoNoCaixa <= 65) {
                this.tempoNoCaixa = 2;
            } else {
                if (this.tempoNoCaixa <= 90 ) {
                    this.tempoNoCaixa = 3;
                } else {
                   this.tempoNoCaixa = 5; 
                }
            }
        }      
    }
    public void setItem(int item) {
        this.item = item;
    }
    public void setProx(Cliente prox) {
        this.prox = prox;
    }
    public Object getItem() {
        return item;
    }
    public Cliente getProx() {
        return prox;
    }
    public int getTempoChegada() {
        return tempoChegada;
    }
    public int getTempoNoCaixa() {
        return tempoNoCaixa;
    }   
}
