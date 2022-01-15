package spring.boot.skying.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.skying.club.service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@CrossOrigin
@RequestMapping("/images")
@RestController
public class ImageController {
  @Autowired
  private FileService imageService;

  @GetMapping("/{fileName:.*}")
  public ResponseEntity<byte[]> getImage(@PathVariable String fileName, HttpServletRequest http)
      throws IOException {
    return imageService.getImage(fileName,http);
  }

//  @PostMapping("/upload")
//  public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
//    return response(imageService.upload(file, fileName));
//  }
}
