/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankws;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;


/**
 *
 * @author studente
 */
public class Operation{
    
    private String op_code;
    private int client_code, amount;
    private String description;
    private LocalDate op_date;

    public Operation() {
    }

    Operation(String op_code, int client_code, String op_date, int amount, String description) {
        this.op_code = op_code;
        this.client_code = client_code;
        this.amount = amount;
        this.description = description;
        this.op_date = LocalDate.parse(op_date);
    }

    public String  getOp_code() {
        return op_code;
    }
    
    @XmlElement(name="operationcode",required=true)
    public void setOp_code(String op_code) {
        this.op_code = op_code;
    }

    public int getClient_code() {
        return client_code;
    }
    
    @XmlElement(name="clientcode", required = true)
    public void setClient_code(int client_code) {
        this.client_code = client_code;
    }

    public int getAmount() {
        return amount;
    }
    
    @XmlElement(name="amount",required=true)
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }
    
    @XmlElement(name="description")
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getOp_date() {
        return op_date;
    }

    
    @XmlElement(name="operationdate",required=true)
    public void setOp_date(LocalDate op_date) {
        this.op_date = op_date;
    }
    
    
    

    

    
}
