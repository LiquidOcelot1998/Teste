/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filacaixa;

/**
 *
 * @author gabri
 */
public class Lista {
    private Cliente pos, ultimo;
    public Cliente primeiro;
    
    public Lista() { //cria uma lita vazia
        this.primeiro = null;
        this.ultimo = null;
        this.pos = null;
    }
    
    public boolean isVazia() {
        return (this.primeiro == null);
    }
    
    public void insere(int x, int tempoChegada) {
        Cliente p = new Cliente(x, tempoChegada);
        if(this.isVazia()) {
            this.primeiro = this.ultimo = p;
        } else {
            this.ultimo.setProx(p);
            this.ultimo = p;
        }
    }
    
    public Cliente busca(int chave) {
        for (Cliente aux = this.primeiro; aux != null; aux = aux.getProx()) {
            if (aux.getItem().equals(chave)) {
                return aux;
            }
        }
        return null;
    }
    
    public void imprime() {
        System.out.println("\n[");
        for (Cliente aux = primeiro; aux != null; aux = aux.getProx()) {
            System.out.println(" Cliente número: " + aux.getItem() + "\tTempo necessário: " + aux.getTempoNoCaixa() + "\tTempo chegada: " + aux.getTempoChegada());
        }
        System.out.println("]");
    }
    
    public Object remove(Object x) {
        if(this.isVazia() || x == null) {
            return null;
        }
        if(this.primeiro.getItem().equals(x)) {
            Object aux = this.primeiro.getItem();
            this.primeiro = this.primeiro.getProx();
            return aux;
        }
        Cliente ant;
        Cliente rem;
        for (ant = this.primeiro, rem = this.primeiro.getProx(); rem != null && !rem.getItem().equals(x); ant = rem, rem = rem.getProx());
            if(rem == null) {
                return null;
            }
            if(rem.getProx() == null) {
                ultimo = ant;
            }
            ant.setProx(rem.getProx());
            return rem.getItem();
    }
}
