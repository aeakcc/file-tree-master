package com.efimchick.ifmo.io.filetree;

import java.io.File;
import java.util.List;

public class View {
    private static List<String> allInfo;

    private static final String BYTE = "bytes";

    Processors processors = new Processors();

    public void allSout(File file){
        long size = processors.fileOrDirectory(file);
        System.out.println(file.getName() + " " + size + " " + BYTE);
        for(int i = 0; i < allInfo.size(); i++){
            System.out.print(allInfo.get(i));
            if(allInfo.get(i).contains("bytes")){
                System.out.println("");
            }
        }
    }
    public static List<String> getAllInfo() {
        return allInfo;
    }

    public static void setAllInfo(List<String> allInfo) {
        View.allInfo = allInfo;
    }
}
