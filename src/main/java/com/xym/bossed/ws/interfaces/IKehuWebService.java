package com.xym.bossed.ws.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2013-08-01T13:11:19.170+08:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://interfaces.ws.bossed.xym.com/", name = "IKehuWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface IKehuWebService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getKehuNameByKehuTelNo", targetNamespace = "http://interfaces.ws.bossed.xym.com/", className = "com.xym.bossed.ws.interfaces.GetKehuNameByKehuTelNo")
    @WebMethod
    @ResponseWrapper(localName = "getKehuNameByKehuTelNoResponse", targetNamespace = "http://interfaces.ws.bossed.xym.com/", className = "com.xym.bossed.ws.interfaces.GetKehuNameByKehuTelNoResponse")
    public java.lang.String getKehuNameByKehuTelNo(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
