package org.djulb.store.io;

import io.minio.*;
import io.minio.errors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinioReader {
    public String read(String bucketName, String identifier) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        MinioClient client = MinioClient.builder()
                .endpoint("http://localhost:9000")
                .credentials("test1234", "test1234")
                .build();

        try (InputStream stream =
                     client.getObject(
                             GetObjectArgs.builder()
                                     .bucket(bucketName)
                                     .object(identifier)
                                     .build()
                     )) {
            return byteToString(stream);
        }



//        client.uploadObject(
//                UploadObjectArgs.builder()
//                        .bucket("asiatrip")
//                        .object("asiaphotos-2015.zip")
//                        .filename("/home/user/Photos/asiaphotos.zip")
//                        .build());

    }

    public String byteToString(InputStream inputStream) throws IOException {
        //creating an InputStreamReader object
        InputStreamReader isReader = new InputStreamReader(inputStream);
        //Creating a BufferedReader object
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        while((str = reader.readLine())!= null){
            sb.append(str);
        }
        return sb.toString();
    }
}
