/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maqturing;

import java.util.*;

/**
 *
 * @author Renan
 */
public class Estado {
    private final String nomeEstado;
    private final ArrayList<Transicao> transicoes = new ArrayList<>();

    public Estado (String nomeEstado){
        this.nomeEstado = nomeEstado;
    }
    
    /**
     * @return the nomeEstado
     */
    public String getNomeEstado() {
        return nomeEstado;
    }

    public void addTransicao (Transicao transicao){
        getTransicoes().add(transicao);
    }

    /**
     * @return the transicoes
     */
    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }
}
