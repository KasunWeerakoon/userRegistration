package com.springapp.mvc.Services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by kasunb on 3/9/2016.
 */
public class UserListService {
    static HashMap<String, List> dataMap = new HashMap<String, List>();

    public static  Map getList() throws IOException {


        Path path = Paths.get("C:\\apache-tomcat-7.0.68\\bin\\", "UserFile.txt");
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> datalist = Files.readAllLines(path, charset);
        System.out.println(datalist.get(0));
        System.out.println("data table" + SaveUserService.dataTable.get("123123"));


        List<String> line = new ArrayList<String>();
        List<String> data = new ArrayList<String>();
        List<String> name = new ArrayList<String>();

        Enumeration e = SaveUserService.dataTable.keys();
        while (e.hasMoreElements()) {


            String key = (String) e.nextElement();
//        System.out.println(key + " : " + UserServlet.dataTable.get(key));
//        System.out.println(Integer.parseInt("" + UserServlet.dataTable.get(key)));
            String s = datalist.get(Integer.parseInt(SaveUserService.dataTable.get(key).toString()) - 1);
//        System.out.println(s);
            line.add("" + Integer.parseInt("" + SaveUserService.dataTable.get(key)));
            data.add(s);

//        System.out.println(data);
            List<String> userDetails = Arrays.asList(s.split(","));
            name.add(userDetails.get(0));


            dataMap.put("nameList", name);
            dataMap.put("dataList", data);
            dataMap.put("lineList", line);


        }
        return dataMap;

    }
}
