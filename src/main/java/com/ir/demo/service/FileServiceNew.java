package com.ir.demo.service;

import com.ir.demo.Util.IterableConverter;
import com.ir.demo.models.File;
import com.ir.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceNew {

    @Autowired
    FileRepository fileRepository;

    public File insert(File file) {
        return this.fileRepository.save(file);
    }

    public List<File> getAll() {
        return IterableConverter.toList(this.fileRepository.findAll());
    }

    public File findByName(String name) {

        List<File> list = getAll();

        for (File f: list) {
            if(f.getName().equals(name)) {
                return f;
            }
        }
        return null;
    }

    public File find(Integer id) {
        return this.fileRepository.findOne(id);
    }

}
