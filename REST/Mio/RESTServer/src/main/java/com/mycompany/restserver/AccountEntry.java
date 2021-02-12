/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restserver;

import java.util.Objects;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */
@XmlRootElement(name = "AccountEntry")
public class AccountEntry {
    
    private int id;
    private String holder;

    public AccountEntry(int id, String holder) {
        this.id = id;
        this.holder = holder;
    }

    public AccountEntry() {
    }

    public int getId() {
        return id;
    }
    
    @XmlElement(name = "Id")
    public void setId(int id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    @XmlElement(name = "holder")
    public void setHolder(String holder) {
        this.holder = holder;
    }
    
    
   @GET
   @Path("{id_inside}")
   public int  Prova3(@PathParam("id_inside")int id){
       return id;
       
   }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.holder);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccountEntry other = (AccountEntry) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.holder, other.holder)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccountEntry{" + "id=" + id + ", holder=" + holder + '}';
    }
    
    
    
    
    
}
