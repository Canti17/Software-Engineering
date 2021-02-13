/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zzrestdbexam;

import java.util.LinkedList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */

@XmlRootElement( name = "CollectionsOfMovies" )
public class CollectionMovies {
    
    
    private LinkedList<Movie> list;

    public CollectionMovies() {
    }

    public CollectionMovies(LinkedList<Movie> list) {
        this.list = list;
    }

    public LinkedList<Movie> getList() {
        return list;
    }
    @XmlElement(name="Movie")
    public void setList(LinkedList<Movie> list) {
        this.list = list;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.list);
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
        final CollectionMovies other = (CollectionMovies) obj;
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CollectionMovies{" + "list=" + list + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
