package com.ir.demo.models;

import javax.persistence.*;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String word;

    private int frequence;

    @ManyToOne
    @JoinColumn(name = "file")
    private File file;

    public Word() {
    }

    public Word(String word, int frequence, File file) {
        this.word = word;
        this.frequence = frequence;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
}
