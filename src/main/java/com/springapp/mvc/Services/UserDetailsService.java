package com.springapp.mvc.Services;

import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kasunb on 3/9/2016.
 */
public class UserDetailsService {

    public static JSONObject getJSONObj(List data){
        List<String> userData = Arrays.asList(data.toString().replaceAll("\\[","").replaceAll("\\]","").split(","));
        System.out.println("submit"+data);

        JSONObject obj=new JSONObject();
        obj.put("name",userData.get(0));
        obj.put("age",userData.get(1));
        obj.put("addr",userData.get(2));
        obj.put("email",userData.get(3));
        obj.put("tpNo",userData.get(4));
        obj.put("NIC",userData.get(5));
//        String s = obj.toJSONString();
//        System.out.println(s);
//        response.setContentType("application/json");
//        PrintWriter writer = response.getWriter();
//        writer.print(s);
//        writer.flush();
        return obj;

    }
}
