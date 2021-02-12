/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankws;

import java.util.ArrayList;
import javax.jws.WebService;


/**
 *
 * @author studente
 */
@WebService
public interface BankInterface {
    
    
    ArrayList<String> getOperationsByClientID (int ClientID);
    java.lang.String getOperationDetailsByID(int OpID);
    
}
