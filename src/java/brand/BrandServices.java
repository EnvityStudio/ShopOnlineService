/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brand;

import Model.Brand;
import Model.DataBaseAccess;
import Model.Product;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import util.GsonUtil;

/**
 *
 * @author PC
 */
@WebService(serviceName = "BrandServices")
public class BrandServices {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "brands")
    public String getAllBrand(){
        List<Brand> list = DataBaseAccess.newInstance().getAllBrand();
        String listString = GsonUtil.newInstance().gson().toJson(list);
        return listString;
    }
}
