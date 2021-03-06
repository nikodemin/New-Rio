package com.niko.prokat.Controller.usual;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@PropertySource("classpath:server.properties")
public class FilesController {
    @Value("${server.upload.dir}")
    private String UPLOAD_DIR;

    /**
     * get image from server
     * @param fileName filename
     * @param ext file extension
     * @return byte array containing image
     * @throws IOException exception getting image file
     */
    @GetMapping("/imgs/uploads/{file}.{ext}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "file") String fileName,
                           @PathVariable(value = "ext") String ext) throws IOException {

        File serverFile = new File(UPLOAD_DIR + "/" + fileName + "." + ext);
        return Files.readAllBytes(serverFile.toPath());
    }
}
