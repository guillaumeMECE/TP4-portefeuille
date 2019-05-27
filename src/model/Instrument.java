/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author helen
 */
public class Instrument {
    //attribut
    private ArrayList<Fond> valeursFonds;
    
    //constructor
    public Instrument()
    {
        valeursFonds = new ArrayList<>();
    }
    
    public Instrument(ArrayList<Fond> newFonds)
    {
        valeursFonds = newFonds;
    }
    /*public Instrument(ArrayList<Fond> newFonds)
    {
        valeursFonds = newFonds;
    }*/
    
    //getter et setter
    
    public void addFond(Fond f)
    {
        valeursFonds.add(f);
    }
    
    public ArrayList<Fond> getValeurFonds()
    {
        return valeursFonds;
    }
    
    public void setValeurFonds(ArrayList<Fond> newArrayListFonds)
    {
        valeursFonds = newArrayListFonds;
    }
    
    //tri 
    public void tri()
    {
        ///A CODER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
}

