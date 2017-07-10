/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maqturing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Renan
 */
public class LeitorPath {

    private String path;

    public LeitorPath(String path) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while (in.ready()) {
                String str = in.readLine();
                this.path = str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }
}
