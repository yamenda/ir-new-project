package com.ir.demo.service;

import com.ir.demo.Util.IterableConverter;
import com.ir.demo.models.Word;
import com.ir.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {

    @Autowired
    WordRepository wordRepository;

    public Word insert(Word word) {
        return this.wordRepository.save(word);
    }

    public List<Word> getAll() {
        return IterableConverter.toList(this.wordRepository.findAll());
    }

    public Word find(Integer id) {
        return this.wordRepository.findOne(id);
    }

}
