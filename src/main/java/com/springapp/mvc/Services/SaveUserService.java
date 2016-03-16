package com.springapp.mvc.Services;

import org.springframework.ui.ModelMap;

import java.io.*;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by kasunb on 3/9/2016.
 */
public class SaveUserService {
    static public Hashtable dataTable=new Hashtable();

    private static SaveUserService sUserService;
    private SaveUserService(){

    }


     public static SaveUserService getInstance(){
        if(sUserService==null)
            sUserService=new SaveUserService();
        return sUserService;
    }
    public  void saveUser(List list) throws IOException {
        File outFile = new File("UserFile.txt");
        FileWriter fw = new FileWriter(outFile,true);
        FileReader fileReader=new FileReader(outFile);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        BufferedWriter bw=new BufferedWriter(fw);
        if(!dataTable.contains(list.get(5))){
            bw.append(list.get(0) + "," + list.get(1) + "," + list.get(2) + "," +list.get(3) + "," + list.get(4)+","+list.get(5));
            bw.newLine();
            dataTable.put(list.get(5),getLineNum(bufferedReader));
        }else {
            dataTable.remove(list.get(5));
            dataTable.put(list.get(5),getLineNum(bufferedReader));
            bw.append(list.get(0) + "," + list.get(1) + "," + list.get(2) + "," + list.get(3) + "," + list.get(4)+","+list.get(5));
            bw.newLine();
        }
        bw.close();
        fw.close();
        System.out.println(outFile.getAbsolutePath());

    }
    public int getLineNum(BufferedReader reader) throws IOException {
        int lines = 0;
        while (reader.readLine() != null) lines++;
        System.out.println("lines "+lines);
        return lines+1;

    }

}
