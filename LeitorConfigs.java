/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maqturing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Renan
 */
public class LeitorConfigs {

    private ArrayList<Estado> estados;
    private String alfabeto;
    private ArrayList<Estado> aceitacao;
    private ArrayList<Estado> rejeicao;
    private StringBuilder cadeia;

    public LeitorConfigs(String local, ArrayList<Estado> estados, String alfabeto, ArrayList<Estado> aceitacao, ArrayList<Estado> rejeicao, StringBuilder cadeia) {
        try {
            this.estados = estados;
            this.aceitacao = aceitacao;
            this.rejeicao = rejeicao;
            BufferedReader in = new BufferedReader(new FileReader(local));
            boolean estado = false;
            boolean alfa = false;
            boolean trans = false;
            boolean aceita = false;
            boolean rejeita = false;
            boolean cad = false;
            while (in.ready()) {
                String str = in.readLine();
                if (str.equals("estados")){
                    estado = true;
                }else if (str.equals("alfabeto")){
                    estado = false;
                    alfa = true;
                } else if (str.equals("transicoes")) {
                    alfa = false;
                    trans = true;
                } else if (str.equals("aceitacao")){
                    trans = false;
                    aceita = true;
                } else if (str.equals("rejeicao")){
                    aceita = false;
                    rejeita = true;
                } else if (str.equals("cadeia")){
                    rejeita = false;
                    cad = true;
                }
                else {
                    if (estado == true){
                        Estado q = new Estado(str);
                        estados.add(q);
                    } else if (alfa == true){
                        this.alfabeto = str;
                    } else if (trans == true){
                        String[] transit = str.split(",");
                        Estado q = null;
                        Estado tr = null;
                        for (int i = 0; i < estados.size(); i++) {
                            if (estados.get(i).getNomeEstado().equals(transit[0])){
                                q = estados.get(i);
                            }
                        }
                        for (int i = 0; i < estados.size(); i++) {
                            if (estados.get(i).getNomeEstado().equals(transit[2])){
                                tr = estados.get(i);
                            }
                        }
                        Transicao t = new Transicao(transit[1].charAt(0), tr, transit[3].charAt(0), transit[4].charAt(0));
                        q.addTransicao(t);
                    } else if (aceita == true){
                        Estado q = null;
                        for (int i = 0; i < estados.size(); i++) {
                            if (estados.get(i).getNomeEstado().equals(str)){
                                q = estados.get(i);
                            }
                        }
                        aceitacao.add(q);
                    } else if (rejeita == true){
                        Estado q = null;
                        for (int i = 0; i < estados.size(); i++) {
                            if (estados.get(i).getNomeEstado().equals(str)){
                                q = estados.get(i);
                            }
                        }
                        rejeicao.add(q);
                    } else if (cad == true){
                        StringBuilder cade = new StringBuilder(str);
                        this.cadeia = cade;
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
    public String getAlfabeto(){
        return alfabeto;
    }

    /**
     * @return the cadeia
     */
    public StringBuilder getCadeia() {
        return cadeia;
    }
}
