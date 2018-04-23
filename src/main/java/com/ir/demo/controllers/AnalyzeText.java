package com.ir.demo.controllers;


import com.ir.demo.models.TextInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rita.RiTa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("analyzeText")
public class AnalyzeText {


    final String PATH = "E:\\github-project\\ir-new-project\\src\\uploads\\";
    File uploadsFolder = new File(PATH);

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String allfile(Model model) {
        String[] filesName = filesName();
        model.addAttribute("files", filesName);
        return "allfiles";
    }

    @RequestMapping(value = "/file/{filename}" , method = RequestMethod.GET)
    public String fileInfo(Model model, @PathVariable String filename) {
        File file = new File(PATH + filename + ".txt");

        String fileText = "oooooops";
        TextInfo tFile = new TextInfo();
        tFile.setText(fileText);

        try{
            tFile = readLines(file);
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] tokenize = RiTa.tokenize(tFile.getText());

        tFile.setTokensArray(tokenize);

        List<String> withOutStopWords = removeStopWords(tokenize);

        List<String> stemmingArray = getStemming(withOutStopWords);

        model.addAttribute("filetext", tFile.getText());
        model.addAttribute("tokesArray", tFile.getTokensArray());
        model.addAttribute("wothOutStopWords", withOutStopWords);
        model.addAttribute("stemmingArray", stemmingArray);

        return "fileinfo";
    }

    public String[] filesName() {

        String[] files = uploadsFolder.list();

        return files;
    }

    public TextInfo readLines(File f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String fileText = "";
        while((line = br.readLine()) != null) {
            fileText += line;
        }

        TextInfo tInfo = new TextInfo();

        tInfo.setText(fileText);

        return tInfo;
    }

    public List<String> removeStopWords(String[] texts) {
        String[] stopWords =  RiTa.STOP_WORDS;
        List<String> stopWordList = new ArrayList<>();

        for (String s: stopWords) {
            stopWordList.add(s);
        }

        List<String> list = new ArrayList<>();

        for (String word:texts) {
            if(!stopWordList.contains(word)) {
                list.add(word);
            }
        }

        return list;
    }

    public List<String> getStemming(List<String> texts) {
        List<String> list = new ArrayList<>();

        for (String s: texts) {
            list.add(RiTa.stem(s));
        }
        return list;
    }

}
