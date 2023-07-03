package com.web.test.Controller;


import com.web.test.DO.Research;
import com.web.test.DO.Student;
import com.web.test.Mapper.FileMapper;
import com.web.test.Mapper.UserMapper;
import com.web.test.Util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin-api/file")
public class FileUploadController {

    @Value("${file.upload-path}")
    private String uploadPath;

    @Value("${file.allowed-types}")
    private String allowedTypes;

    @Value("${file.max-size}")
    private long maxFileSize;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());








    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(@RequestHeader("Authorization") String authHeader , @RequestParam("file") MultipartFile file) throws IOException {

        System.out.println("上传文件");

        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        logger.info(username);
        Student student= userMapper.findByUsername(username);

        Research research=userMapper.rfindBysid(student.getId());

        if (file == null || file.isEmpty()) {
            return "上传文件不能为空";
        }

        if (!StringUtils.hasText(uploadPath)) {
            return "文件上传路径未配置";
        }

        if (!isFileTypeAllowed(file)) {
            return "不允许上传该文件类型";
        }
/*
        if (!isFileContentValid(file)) {
            return "文件内容不合法";
        }

 */

        if (file.getSize() > maxFileSize) {
            return "文件大小超过限制";
        }

        try {
            String fileName = generateUniqueFileName(file.getOriginalFilename());

            String filePath = uploadPath + File.separator + fileName;
            System.out.println(filePath);
            File dest = new File(filePath);
            file.transferTo(dest);

            if (research == null) {
                // Research record not found for the student
                research = new Research();
                research.setStudentId(student.getId());
                research.setFilePath(filePath);
                // Set other properties of research object if needed
                fileMapper.insertr(research); // Assuming the insertResearch() method in userMapper takes Research object as a parameter
            } else {
                research.setFilePath(filePath);
                fileMapper.updater(research);
            }
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("文件上传失败");
        }
    }

    private boolean isFileTypeAllowed(MultipartFile file) {
        String fileExtension = getFileExtension(file.getOriginalFilename());
        if (fileExtension != null) {
            List<String> allowedExtensions = Arrays.asList(allowedTypes.split(","));
            return allowedExtensions.contains(fileExtension.toLowerCase());
        }
        return false;
    }

    private boolean isFileContentValid(MultipartFile file) throws IOException {
        // 验证文件类型是否为图像类型
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            return false;
        }

        // 进一步验证文件内容，例如使用文件头、魔术数字等方式

        // 示例：验证文件内容为图片（JPEG 或 PNG）
        byte[] fileBytes = file.getBytes();

        // JPEG 文件的文件头：FF D8 FF E0
        // PNG 文件的文件头：89 50 4E 47 0D 0A 1A 0A
        if (fileBytes.length >= 4) {
            byte[] jpegHeader = {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF, (byte) 0xE0};
            byte[] pngHeader = {(byte)0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};

            return startsWith(fileBytes, jpegHeader) || startsWith(fileBytes, pngHeader);
        }

        return false;
    }

    private boolean startsWith(byte[] array, byte[] prefix) {
        if (array.length < prefix.length) {
            return false;
        }
        for (int i = 0; i < prefix.length; i++) {
            if (array[i] != prefix[i]) {
                return false;
            }
        }
        return true;
    }

    private String generateUniqueFileName(String originalFileName) {
        String fileExtension = getFileExtension(originalFileName);
        String uniqueFileName = UUID.randomUUID().toString();
        if (fileExtension != null) {
            uniqueFileName += "." + fileExtension;
        }
        return uniqueFileName;
    }

    private String getFileExtension(String fileName) {
        if (StringUtils.hasText(fileName)) {
            int dotIndex = fileName.lastIndexOf(".");
            if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
                return fileName.substring(dotIndex + 1);
            }
        }
        return null;
    }




    @GetMapping("/{fileId}")
    public ResponseEntity<String> getFile(@PathVariable("fileId") int fileId) {
        // 根据 fileId 获取文件路径
        String filePath = fileMapper.findFilePathById(fileId);

        if (filePath == null) {
            // 文件不存在，返回 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // 返回文件的URL
        String fileUrl = "/static/" + Paths.get(filePath).getFileName().toString();
        System.out.println(fileUrl);
        return ResponseEntity.ok(fileUrl);
    }



    /*
    @GetMapping("/{fileId}")
    public ResponseEntity<String> getFile(@PathVariable("fileId") int fileId) {
        // 根据 fileId 获取文件路径
        String filePath = fileMapper.findFilePathById(fileId);

        if (filePath == null) {
            // 文件不存在，返回 404 Not Found
            return ResponseEntity.notFound().build();
        }

        try {
            FileSystemResource fileSystemResource = new FileSystemResource(filePath);
            byte[] bytes = StreamUtils.copyToByteArray(fileSystemResource.getInputStream());
            String base64 = Base64.getEncoder().encodeToString(bytes);
            //System.out.println(base64);
            return ResponseEntity.ok(base64);
        } catch (IOException e) {
            e.printStackTrace();
            // 处理 IO 异常
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "文件读取失败", e);
        }
    }
*/



    /*


    @GetMapping("/{fileId}")
    public ResponseEntity<Resource> getFile(@PathVariable("fileId") int fileId) throws IOException {
        // 根据 fileId 获取文件路径
        String filePath = fileMapper.findFilePathById(fileId);

        if (filePath == null) {
            // 文件不存在，返回 404 Not Found
            return ResponseEntity.notFound().build();
        }

        try {
            File file = new File(filePath);

            System.out.println(filePath);
            // 创建 Resource 对象
            Resource resource = (Resource) new UrlResource(file.toURI());

            if (resource.exists()) {
                String mimeType = Files.probeContentType(Paths.get(filePath));
                if (mimeType == null) {
                    mimeType = "application/octet-stream"; // Use a default MIME type
                }


                // 返回文件响应
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(mimeType))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);

            } else {
                // 文件不存在，返回 404 Not Found
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // 处理 URL 格式错误异常
            throw new IOException("获取文件失败");
        }
    }


     */

}

