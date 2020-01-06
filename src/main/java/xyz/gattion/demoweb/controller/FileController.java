package xyz.gattion.demoweb.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.gattion.demoweb.json.FileJson;
import xyz.gattion.demoweb.json.ReturnJson;
import xyz.gattion.demoweb.service.FileService;


@RestController
public class FileController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private FileService fileService;

    @GetMapping("/file")
    private FileJson getFile(@RequestParam(value = "path", required = false) String path) {
        return fileService.getFile(path);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    private ReturnJson exceptionHandler(Exception e) {
        logger.error(this.getClass().getName(), e);
        return ReturnJson.fail();
    }

}
