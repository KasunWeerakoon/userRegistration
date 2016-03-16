package com.springapp.mvc.Services;

import javax.servlet.http.Cookie;

/**
 * Created by kasunb on 3/11/2016.
 */
public class CookieManager {
    private static Cookie cookie;

    private CookieManager() {


    }
    public static Cookie getCookie(){
        if(cookie==null)
            cookie=new Cookie("userCookie",""+new java.util.Date().getTime());
        cookie.setMaxAge(10*60*1000);

        return cookie;
    }



}
