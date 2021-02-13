/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zzrestdbexam;

import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */

@XmlRootElement(name = "Movie")
public class Movie {
    
    private int id;
    private int director_id;
    private String title;
    private String year;

    public Movie() {
    }

    public Movie(int id, int director_id, String title, String year) {
        this.id = id;
        this.director_id = director_id;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    @XmlElement(name="Id")
    public void setId(int id) {
        this.id = id;
    }

    public int getDirector_id() {
        return director_id;
    }

    @XmlElement(name="IdDirector")
    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name="Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    @XmlElement(name="Year")
    public void setYear(String year) {
        this.year = year;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        hash = 73 * hash + this.director_id;
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.year);
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
        final Movie other = (Movie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.director_id != other.director_id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", director_id=" + director_id + ", title=" + title + ", year=" + year + '}';
    }
    
    
    
    
    
    
}
