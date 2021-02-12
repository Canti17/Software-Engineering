/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankws;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface="com.mycompany.bankws.BankInterface")
public class BankImpl implements BankInterface{
    
    private final Map<Integer, Operation> operationDB = new TreeMap<Integer, Operation>();

    BankImpl() {
        operationDB.put(1, new Operation("1", 1, "2019-03-22", 130, "cena al ristorante"));
        operationDB.put(2, new Operation("2", 1, "2019-03-19", 30, "benzina autostrada"));
        operationDB.put(3, new Operation("3", 2, "2019-03-18", 1400, "riparazione motorino"));
        operationDB.put(4, new Operation("4", 2, "2019-03-17", 600, "festa"));
        operationDB.put(5, new Operation("5", 3, "2019-03-17", 45, "benzina autostrada"));
    }


    @Override
    public ArrayList<String> getOperationsByClientID(int ClientID) {
        Iterator it = operationDB.entrySet().iterator();
        ArrayList<String> lista = new ArrayList<String>();
        while(it.hasNext()){
            
            Map.Entry coppia = (Map.Entry) it.next();
            Operation operation = (Operation) coppia.getValue();
            if (operation.getClient_code() == ClientID){
                lista.add(operation.getOp_code());
                
            }
        }
        return lista;
    }
    
    

    @Override
    public String getOperationDetailsByID(int OpID) {
        Iterator it = operationDB.entrySet().iterator();
        ArrayList<String> lista = new ArrayList<String>();
        String ciccio = new String();
        while(it.hasNext()){
            Map.Entry coppia = (Map.Entry) it.next();
            Operation operation = (Operation) coppia.getValue();
            if (Integer.parseInt(operation.getOp_code()) == OpID){
                ciccio = operation.getOp_code() +", "+ operation.getClient_code() + ", "+ operation.getOp_date() + ", " + operation.getAmount() + " , "+ operation.getDescription();
                break;
            }
                
            }
        return ciccio;
    }
    
        
}
