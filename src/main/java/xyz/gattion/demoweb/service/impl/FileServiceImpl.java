package xyz.gattion.demoweb.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.gattion.demoweb.json.FileJson;
import xyz.gattion.demoweb.service.FileService;

import java.io.*;
import java.util.logging.Logger;

@Service
public class FileServiceImpl implements FileService {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Value("${file.basepath}")
    private String basePath;

    @Override
    public FileJson getFile(String path) {
        logger.info(path);
        if(path == null) path = "";
        String filePath = basePath + path.replace("/", "\\\\");
        File file = new File(filePath);
        if(!file.exists()) {
            file = new File(basePath);
            path = "";
        }
        FileJson fileJson = new FileJson();
        if (file.isDirectory()) {
            File[] childs = file.listFiles();
            for (File c : childs) {
                fileJson.getFiles().put(c.getName(), path + "/" + c.getName());
            }
        } else {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String s;
                while ((s = reader.readLine()) != null) content.append(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fileJson.setContent(content.toString());
        }
        return fileJson;
    }
}
