package spring.boot.core.storage;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.exception.BaseException;
import spring.boot.core.utils.DateUtils;
import spring.boot.core.utils.FileUtil;
import spring.boot.core.utils.StringUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;

@Service
public class FileSystemStorageService implements StorageService {
  private final Path rootLocation = Paths.get("uploads");

  @Override
  public void init() {
    try {
      Files.createDirectory(rootLocation);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file) {
    try {
      if(!Files.exists(rootLocation)){
        init();
        System.out.println("root not exist and create: "+ rootLocation);
      }
      System.out.println("root: "+ rootLocation);
      Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()),
          StandardCopyOption.REPLACE_EXISTING);
      System.out.println("root: "+ rootLocation);
      System.out.println("originFilename"+file.getOriginalFilename());
      System.out.println("originFilename"+this.rootLocation.resolve(file.getOriginalFilename()));


    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }


  @Override
  public FileInfo store(MultipartFile file, String... relativePath) {
    return store(file, null, relativePath);
  }

  @Override
  public FileInfo store(MultipartFile file, String[] extensions, String... relativePath) {
    return store(file, null, extensions, relativePath);
  }

  @Override
  public FileInfo store(MultipartFile file, String prefix, String[] extensions, String... relativePath) {
    if (file == null || file.isEmpty()) {
      throw new BaseException("không tìm thấy file");
    }

    String fileName = file.getOriginalFilename();

    if (fileName == null) {
      throw new BaseException("Không có tên file");
    }

    String extension = FileUtil.getExtension(fileName);

    if (StringUtil.isBlank(extension)) {
      throw new BaseException("Không tồn tại filename: " + fileName);
    }

    if (extensions != null && extensions.length > 0
            && Arrays.stream(extensions).noneMatch(extension::equals)) {
      throw new BaseException("extension exception");
    }

    fileName = (prefix == null ? "" : prefix) + StringUtil.cleanPath(fileName);

    Path location = resolve(relativePath)
            .resolve(DateUtils.formatDate(DateUtils.getToday()))
            .resolve(UUID.randomUUID().toString())
            .resolve(fileName);
    validatePath(location, rootLocation);

    try {
      if (!Files.exists(location.getParent())) {
        FileUtil.createDirectories(location.getParent());
      }

      file.transferTo(location);
      return getFileInfo(location);
    } catch (IOException e) {
      throw new BaseException("lỗi ioexception");
    }
  }

  protected FileInfo getFileInfo(Path path) {
    path = path.normalize();
    return new FileInfo(path.toAbsolutePath(), rootLocation.relativize(path), path.getFileName());
  }

  private Path resolve(String... relativePath) {
    Path location = rootLocation;
    if (relativePath != null && relativePath.length > 0) {
      for (String path : relativePath) {
        if (!StringUtil.isBlank(path)) {
          location = location.resolve(path);
        }
      }
    }
    return location;
  }

  private void validatePath(Path path, Path parent) {
    String name = parent.toAbsolutePath().normalize().relativize(path.toAbsolutePath().normalize()).toString();

    if (name.contains("..")) {
      throw new BaseException("path not valid");
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(rootLocation.toFile());
  }


}