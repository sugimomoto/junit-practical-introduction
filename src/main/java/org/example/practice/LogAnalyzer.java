package org.example.practice;

import jdk.internal.org.objectweb.asm.tree.analysis.AnalyzerException;

import java.io.IOException;
import java.util.Map;

public class LogAnalyzer {

    LogLoader logLoader = new LogLoader();

    public Object analyze(String file){
        try{
            Map<String, String> rawData = logLoader.load(file);
            return doAnalyze(rawData);
        }catch (IOException ex){
            throw new AnalyzeException(ex);
        }
    }

    private Object doAnalyze(Map<String,String> rawData){
        // これは仮実装です。
        return new Object();
    }

    static class AnalyzeException extends RuntimeException{
        public AnalyzeException(Throwable cause){
            super(cause);
        }
    }
}
