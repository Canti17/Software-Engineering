/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zzrestdbexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author studente
 */

@Path("/movies")
@Produces("text/xml")
public class MovieAdapter {
    
    private Connection conn;
    
  
    
    @GET
    @Path("")
    @Produces("text/xml")
    public CollectionMovies getListMovies(){
        
        LinkedList<Movie> listanuova = null;
        
        CollectionMovies collection;
        PreparedStatement stat;
        try {
             stat = conn.prepareStatement("SELECT * FROM MOVIES");
        
        
        listanuova = new LinkedList<>();
        ResultSet rs = stat.executeQuery();
        
        while(rs.next()) {
            
            
            Movie movie = new Movie(rs.getInt("Id"), rs.getInt("directorID"), rs.getString("title"), rs.getString("year"));
            
            System.out.println(movie.toString());
            listanuova.add(movie);
        
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(MovieAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return new CollectionMovies(listanuova);
    }
    
    
    
    @GET
    @Path("{id}")
    public Director getDirector(@PathParam("id") int id){
        Director dir = null;
        PreparedStatement stat2;
        try {
             
             stat2 = conn.prepareStatement("SELECT * FROM DIRECTORS WHERE ID = ?");
             stat2.setString(1, String.valueOf(id));
             
             ResultSet rs2 = stat2.executeQuery();
             
             
             
             dir = new Director(id, rs2.getString("name"), rs2.getString("yearOfBirth"));
             
             System.out.println(dir.toString());
             
             } catch (SQLException ex) {
            Logger.getLogger(MovieAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dir;

    }
    
    
    

    void setConnection(String ue) {
         try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MovieAdapter.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection("jdbc:sqlite:"+ue);
        } catch (SQLException ex) {
            Logger.getLogger(MovieAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
    

