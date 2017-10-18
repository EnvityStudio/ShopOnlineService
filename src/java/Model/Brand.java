/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PC
 */
public class Brand {
    private int idbrand;
    private String name;

    public Brand() {
    }

    
    
    public Brand(int idbrand, String name) {
        this.idbrand = idbrand;
        this.name = name;
    }

    
    
    
    public int getIdbrand() {
        return idbrand;
    }

    public void setIdbrand(int idbrand) {
        this.idbrand = idbrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
