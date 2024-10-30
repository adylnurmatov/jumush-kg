package kg.soft.jumushkg.service;


import kg.soft.jumushkg.domain.entity.userInfo.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image uploadFile(MultipartFile file);

    void uploadFileToS3Bucket(MultipartFile file);

    byte[] downloadFile(String fileName);

    void deleteFile(Long id);

    Image showById(Long id);
}
