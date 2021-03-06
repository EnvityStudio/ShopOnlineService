/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

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
@WebService(serviceName = "Product")
public class ProductService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "products")
    public String getAllProducts(){
        List<Product> list = DataBaseAccess.newInstance().getAllProduct();
        String listString = GsonUtil.newInstance().gson().toJson(list);
        return listString;
    }
}
