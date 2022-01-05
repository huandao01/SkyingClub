package vn.isofh.medical.education.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.controller.BaseResponseController;
import spring.boot.core.dto.ResponseDTO;
import spring.boot.skying.club.service.FileService;

@RestController
@RequestMapping(path = "/file")
@RequiredArgsConstructor
public class FileController extends BaseResponseController {

    @Getter(AccessLevel.PROTECTED)
    private final FileService service;

    @PostMapping("/upload")
    public ResponseDTO upload(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        return response(getService().upload(file, fileName));
    }
}
