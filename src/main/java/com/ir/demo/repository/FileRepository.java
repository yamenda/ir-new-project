package com.ir.demo.repository;

import com.ir.demo.models.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, Integer> {
}
