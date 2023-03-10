package com.mouse.maps.services;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class MinioFileUploader implements FileService {

    @Autowired
    public MinioClient minioClient;

    public String upload(MultipartFile file) {
        val fileName = UUID.randomUUID().toString();
        try {
            minioClient
                .putObject(
                    PutObjectArgs
                        .builder()
                        .bucket("maps")
                        .object(fileName)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
                    );

            return fileName;
        } catch (ErrorResponseException
             | InsufficientDataException
             | InternalException
             | InvalidResponseException
             | InvalidKeyException
             | NoSuchAlgorithmException
             | IOException
             | XmlParserException
             | ServerException e
        ) {
            throw new RuntimeException(e);
        }
    }
}
