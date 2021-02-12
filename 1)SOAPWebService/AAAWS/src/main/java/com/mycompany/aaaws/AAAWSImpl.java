/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aaaws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface= "com.mycompany.aaaws.AAAWSInterface")
public class AAAWSImpl implements AAAWSInterface{
    
    private Map<Integer, Client> clients = new HashMap<Integer, Client>();

    public AAAWSImpl() {
        clients.put(1, new Client("Massimo", "Mecella"));
        clients.put(2, new Client("Maurizio", "Lenzerini"));
        clients.put(3, new Client("Bruno", "Ciciani"));
        clients.put(4, new Client("Fabrizio", "D'Amore"));
        clients.put(5, new Client("Alessandro", "Pellegrini"));
    }

    @Override
    public ArrayList<String> getClients() {
        
        Iterator<Map.Entry<Integer, Client>> it = clients.entrySet().iterator();
        ArrayList<String> ciccio = new ArrayList<String>();
        
        while(it.hasNext()){
            Map.Entry coppia = (Map.Entry) it.next();
            String  result = String.valueOf(coppia.getKey());
            Client client = (Client) coppia.getValue();
            result += ", "+ client.getName() + client.getSurname();
            ciccio.add(result);
            
        }
        
        return ciccio;       
        
    }
    
   
    
}
