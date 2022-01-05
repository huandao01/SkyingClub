package spring.boot.skying.club.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


public interface FileService {

  ResponseEntity<byte[]> getImage(String fileName, HttpServletRequest httpServletRequest)
      throws IOException;


  Map<String,Object> upload(MultipartFile file, String fileName);

}
