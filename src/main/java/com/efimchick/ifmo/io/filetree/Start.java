package com.efimchick.ifmo.io.filetree;

public class Start {
    public static void start(){
        Processors processors = new Processors();
        View view = new View();
        view.allSout(processors.scanningFile());
    }
}
