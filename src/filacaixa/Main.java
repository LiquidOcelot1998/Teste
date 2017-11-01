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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista filaCaixa = new Lista();
        Random randP = new Random();
        int aux = 0;
        int aux2 = 0;
        int desistencia = 0;
        int pessoasAtendidas = 0;
        int tamanhoFila = 0;
        int pessoa = 0;
        int tempoEspera = 0;
        for (int i = 0; i < 180; i++) {
            pessoa = randP.nextInt(100) + 0;
            if (tamanhoFila <= 5) {
                if (pessoa <= 30) {
                    if (!filaCaixa.isVazia()) {
                        aux += 1;
                    }
                } else {
                    if (pessoa <= 70) {
                        filaCaixa.insere(pessoa, i);
                        tamanhoFila += 1;
                        aux += 1;
                    } else {
                        if (pessoa <= 95) {
                            filaCaixa.insere(pessoa, i);
                            pessoa = randP.nextInt(100) + 0;
                            filaCaixa.insere(pessoa, i);
                            tamanhoFila += 2;
                            aux += 1;
                        } else {
                            filaCaixa.insere(pessoa, i);
                            pessoa = randP.nextInt(100) + 0;
                            filaCaixa.insere(pessoa, i);
                            pessoa = randP.nextInt(100) + 0;
                            filaCaixa.insere(pessoa, i);
                            tamanhoFila += 3;
                            aux += 1;
                        }
                    }
                }
                filaCaixa.imprime();
                if (!filaCaixa.isVazia()) {
                    if (filaCaixa.primeiro.getTempoNoCaixa() == aux) {
                        if (aux2 > 0) {
                            tempoEspera += i - filaCaixa.primeiro.getTempoChegada() + 1;
                        }
                        aux = 0;
                        System.out.println("Cliente atendido: " + filaCaixa.remove(filaCaixa.primeiro.getItem()));
                        tamanhoFila -= 1;
                        pessoasAtendidas += 1;
                        aux2 += 1;
                    }
                }
            } else {
                if (pessoa <= 30) {
                    // nada a se fazer
                } else {
                    if (pessoa <= 70) {
                        desistencia += 1;
                    } else {
                        if (pessoa <= 95) {
                            desistencia += 2;
                        } else {
                            desistencia += 3;
                        }
                    }
                }
            }
        }
        System.out.println("Tamanho da fila: " + tamanhoFila + "\nClientes atendidos: " + pessoasAtendidas +
                "\nMédia de espera: " + (tempoEspera / (pessoasAtendidas - 1)) + " minutos" + "\nDesistência: " + desistencia);
    }   
}
