/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aaaws;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author studente
 */
public class Client {
     private String name;
    private String surname;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    
    @XmlElement(name="name",required=true)
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement(name="surname",required=true)
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    
}
