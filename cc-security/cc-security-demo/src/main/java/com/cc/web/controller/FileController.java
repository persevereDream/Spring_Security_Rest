package com.cc.web.controller;

import com.cc.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {

    private String folder = "F:\\Study\\Spring_Security_Rest\\cc-security\\cc-security-demo\\src\\uploadFile";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName()); // 获取参数名
        System.out.println(file.getOriginalFilename()); //获取文件原始名
        System.out.println(file.getSize()); //获取文件大小

        File localFile = new File(folder,new Date().getTime()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
             OutputStream outputStream = response.getOutputStream();)
        {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");//下载时的文件名

            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }

}
