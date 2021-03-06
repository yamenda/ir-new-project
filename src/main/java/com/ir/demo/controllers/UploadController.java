package com.ir.demo.controllers;

import com.ir.demo.models.File;
import com.ir.demo.models.TextInfo;
import com.ir.demo.service.FileServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("uploadFiles")
public class UploadController {

    @Autowired
    private FileServiceNew fileServiceNew;


    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "E:\\github-project\\ir-new-project\\src\\uploads\\";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @RequestMapping(value = "/upload" , method = RequestMethod.POST) // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            addFile(file.getOriginalFilename());

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadFiles/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }


    public void addFile(String name) {
        File file = new File();
        file.setName(name);
        fileServiceNew.insert(file);
    }

}
