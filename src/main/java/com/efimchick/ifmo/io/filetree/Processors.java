package com.efimchick.ifmo.io.filetree;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Processors {
    public File scanningFile(){
        Scanner scanner = new Scanner(System.in);
        String directory = scanner.nextLine();
        File file = new File(directory);
        return file;
    }
    public long sorting(File file, int depth, long size, List<String> list) {
        File[] arr = file.listFiles();
        for (int i = 0; i < arr.length; i++) {
            for(int l = 0; l < depth; l++){
                list.add("│\t");
                View.setAllInfo(list);
            }

            if (i == arr.length - 1) {
                list.add("└─ ");
                View.setAllInfo(list);
            }
            else {
                list.add("├─ ");
                View.setAllInfo(list);
            }

            if (arr[i].isDirectory()) {
                list.add(arr[i].getName());
                list.add("\n");
                View.setAllInfo(list);
                size += arr[i].length();
                sorting(arr[i], depth + 1, size, list);
            }
            else {
                list.add(arr[i].getName() + " " + arr[i].length() + " bytes");
                View.setAllInfo(list);
                size += arr[i].length();
            }
        }
        return size;
    }
    public long fileOrDirectory(File file){
        if (file.isFile()) {
//            System.out.println(file.getName() + " " + file.length() + " bytes");
            return file.length();
        } else {
            List<String> arr = new ArrayList<>();
            long size = sorting(file, 0, 0, arr);
            return size;
        }
    }
}
