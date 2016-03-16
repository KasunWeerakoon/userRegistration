package com.springapp.mvc.Services;

import org.springframework.web.servlet.resource.ResourceResolver;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by kasunb on 3/10/2016.
 */
public class InterlizationService {
//    String language = new String("en");
//    String country = new String("US");
    Locale currentLocale;
    ResourceBundle messages;


    public ResourceBundle interlize(String langCode,String countryCode) {
        currentLocale = new Locale(langCode, countryCode);

        messages = ResourceBundle.getBundle("com.springapp.mvc.Resources.InterlizeBundle", currentLocale);
        System.out.println(messages.getString("line1"));
        return messages;

    }
}
