package com.ir.demo.repository;

import com.ir.demo.models.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Integer> {
}
