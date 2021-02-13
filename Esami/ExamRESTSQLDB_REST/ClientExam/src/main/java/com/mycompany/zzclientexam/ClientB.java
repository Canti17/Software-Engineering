/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zzclientexam;


import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import javax.ws.rs.client.Client;
/**
 *
 * @author studente
 */
public class ClientB {
    
    public static void main(String[] args) throws Exception {
        
        Client client = ClientBuilder.newClient();
        String baseUrl = "http://localhost:8080/movies";
        WebTarget webTarget = client.target(baseUrl);
        
        Invocation.Builder ib = webTarget.request("text/xml");
        Response res;
  
        CollectionMovies movies = ib.accept(MediaType.TEXT_XML).get(CollectionMovies.class);
        System.out.println("RICHIESTA GET: "+movies.toString()+"\n");
        
        
        for(Movie mov : movies.getList()){
            
            int id = mov.getDirector_id();
            
            
            WebTarget webTarget2 = client.target(baseUrl+"/"+String.valueOf(id));
            Invocation.Builder ib2 = webTarget2.request("text/xml");
            
            Director dir =  ib2.accept(MediaType.TEXT_XML).get(Director.class);
            
            
            System.out.println("Caratteristiche Movie:  NOME: "+mov.getTitle()+"---- YEAR: "+mov.getYear() + "----- DIRECTOR: "+dir.getName() + " ----YEARofBIRTH: "+dir.getYear());
            
            
            
            
        }
        
        
    }
}
