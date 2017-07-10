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
public class Main {

    public static void main(String[] args) {
        String local;
        String path = "path.txt";          
        StringBuilder cadeia = null;
        String alfabeto = null;
        ArrayList<Transicao> teste = null;
        ArrayList<Estado> estados = new ArrayList<>();
        ArrayList<Estado> aceitacao = new ArrayList<>();
        ArrayList<Estado> rejeicao = new ArrayList<>();
        LeitorPath caminho = new LeitorPath(path);
        local = caminho.getPath();
        LeitorConfigs read = new LeitorConfigs(local, estados, alfabeto, aceitacao, rejeicao, cadeia);
        alfabeto = read.getAlfabeto();
        cadeia = read.getCadeia();
        MaqTuring turing = new MaqTuring(cadeia, estados, alfabeto, estados.get(0), aceitacao, rejeicao);
        turing.rodaMaquina();
    }   
}
