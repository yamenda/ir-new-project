package com.ir.demo.models;

public class TextInfo {

    public String text;
    public String[] tokensArray;
    public String[] stemmingArray;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTokensArray() {
        return tokensArray;
    }

    public void setTokensArray(String[] tokensArray) {
        this.tokensArray = tokensArray;
    }

    public String[] getStemmingArray() {
        return stemmingArray;
    }

    public void setStemmingArray(String[] stemmingArray) {
        this.stemmingArray = stemmingArray;
    }
}
