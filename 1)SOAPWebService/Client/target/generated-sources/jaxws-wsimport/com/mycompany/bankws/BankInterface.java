
package com.mycompany.bankws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BankInterface", targetNamespace = "http://bankws.mycompany.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BankInterface {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOperationsByClientID", targetNamespace = "http://bankws.mycompany.com/", className = "com.mycompany.bankws.GetOperationsByClientID")
    @ResponseWrapper(localName = "getOperationsByClientIDResponse", targetNamespace = "http://bankws.mycompany.com/", className = "com.mycompany.bankws.GetOperationsByClientIDResponse")
    @Action(input = "http://bankws.mycompany.com/BankInterface/getOperationsByClientIDRequest", output = "http://bankws.mycompany.com/BankInterface/getOperationsByClientIDResponse")
    public List<String> getOperationsByClientID(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOperationDetailsByID", targetNamespace = "http://bankws.mycompany.com/", className = "com.mycompany.bankws.GetOperationDetailsByID")
    @ResponseWrapper(localName = "getOperationDetailsByIDResponse", targetNamespace = "http://bankws.mycompany.com/", className = "com.mycompany.bankws.GetOperationDetailsByIDResponse")
    @Action(input = "http://bankws.mycompany.com/BankInterface/getOperationDetailsByIDRequest", output = "http://bankws.mycompany.com/BankInterface/getOperationDetailsByIDResponse")
    public String getOperationDetailsByID(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}