/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;

/**
 *
 * @author PC
 */
public class GsonUtil {
    private static GsonUtil gsonUtil;
    private static Gson gson;
    public static GsonUtil newInstance(){
        if (gsonUtil == null) {
            gsonUtil = new GsonUtil();
            gson = new Gson();
        }
        return gsonUtil;
    }
    
    public static Gson gson(){
        return gson;
    }
}
