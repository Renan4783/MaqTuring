/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maqturing;

import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class MaqTuring {

    private final StringBuilder cadeia;
    private final ArrayList<Estado> estados;
    private final String alfabeto;
    private final Estado estadoInicial;
    private final ArrayList<Estado> aceita;
    private final ArrayList<Estado> rejeita;

    public MaqTuring(StringBuilder cadeia, ArrayList<Estado> estados, String alfabeto, Estado estadoInicial, ArrayList<Estado> aceita, ArrayList<Estado> rejeita) {
        this.cadeia = cadeia;
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.aceita = aceita;
        this.rejeita = rejeita;
    }

    private String leitura() {
        Estado estadoAtual = estadoInicial;
        String estadoFinal = null;
        boolean parada = false;
        int i = 0;
        mostraCadeia(estadoAtual);
        while (parada == false) {
            if (parada == false) {
                for (int j = 0; j < estadoAtual.getTransicoes().size(); j++) {
                    if ((cadeia.charAt(i) == estadoAtual.getTransicoes().get(j).getLeitura())) {
                        if (estadoAtual.getTransicoes().get(j).getDirecao() == 'd') {
                            cadeia.setCharAt(i, estadoAtual.getTransicoes().get(j).getReescrita());
                            i++;
                            estadoAtual = estadoAtual.getTransicoes().get(j).getEstadoTransicao();
                        } else if (estadoAtual.getTransicoes().get(j).getDirecao() == 'e') {
                            cadeia.setCharAt(i, estadoAtual.getTransicoes().get(j).getReescrita());
                            i--;
                            estadoAtual = estadoAtual.getTransicoes().get(j).getEstadoTransicao();
                        }
                    }
                    mostraCadeia(estadoAtual);
                }
            }
            if (aceitacao(estadoAtual)) {
                parada = true;
                estadoFinal = "aceita";
            } else if (rejeicao(estadoAtual)) {
                parada = true;
                estadoFinal = "rejeita";
            }
        }
        return estadoFinal;
    }

    private boolean aceitacao(Estado estadoAtual) {
        for (int i = 0; i < aceita.size(); i++) {
            return estadoAtual.getNomeEstado() == aceita.get(i).getNomeEstado();
        }
        return false;
    }

    private boolean rejeicao(Estado estadoAtual) {
        for (int i = 0; i < rejeita.size(); i++) {
            return estadoAtual.getNomeEstado() == rejeita.get(i).getNomeEstado();
        }
        return false;
    }

    private void mostraCadeia(Estado estadoAtual) {
        System.out.println(cadeia + " " + "q" + estadoAtual.getNomeEstado());
    }

    public void rodaMaquina() {
        System.out.println("Configuração da maquina (7-tupla):");
        System.out.print("Estados: ");
        for (int i = 0; i < estados.size(); i++) {
            System.out.print("q" + estados.get(i).getNomeEstado() + " ");
        }
        System.out.println("");
        System.out.print("Alfabeto de entrada: " + alfabeto);
        System.out.println("");
        System.out.print("Alfabeto da fita: " + alfabeto + "$");
        System.out.println("");
        System.out.println("Estado inicial: " + "q" + estadoInicial.getNomeEstado());
        System.out.print("Aceitacao: ");
        for (int i = 0; i < aceita.size(); i++) {
            System.out.print("q" + aceita.get(i).getNomeEstado() + " ");
        }
        System.out.println("");
        System.out.print("Rejeicao: ");
        for (int i = 0; i < rejeita.size(); i++) {
            System.out.print("q" + rejeita.get(i).getNomeEstado() + " ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Fita: ");
        System.out.println(leitura());
    }
}
