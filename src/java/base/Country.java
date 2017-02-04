/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco
 */
@XmlRootElement

public class Country {

    private int id;
    private String name;
    private String capital;

    public Country(int id, String name, String capital) {
        this.id = id;
        this.name = name;
        this.capital = capital;
    }

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public Country() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

}
