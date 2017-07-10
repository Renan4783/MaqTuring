/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maqturing;

/**
 *
 * @author Renan
 */
public class Transicao {
    private final char leitura;
    private final Estado estadoTransicao;
    private final char direcao;
    private final char reescrita;

    public Transicao (char leitura, Estado estadoTransicao, char direcao, char reescrita){
        this.leitura = leitura;
        this.estadoTransicao = estadoTransicao;
        this.direcao = direcao;
        this.reescrita = reescrita;
    }
    
    /**
     * @return the leitura
     */
    public char getLeitura() {
        return leitura;
    }

    /**
     * @return the estadoTransicao
     */
    public Estado getEstadoTransicao() {
        return estadoTransicao;
    }

    /**
     * @return the direcao
     */
    public char getDirecao() {
        return direcao;
    }

    /**
     * @return the reescrita
     */
    public char getReescrita() {
        return reescrita;
    }

}
