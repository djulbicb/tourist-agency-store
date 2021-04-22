package org.djulb.store.io;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringBufferInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinioWriter {
    public void write (String bucketName, String identifier, String writer) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://localhost:9000")
                .credentials("test1234", "test1234")
                .build();

        ifBucketDoesntExistCreateIt(bucketName, minioClient);

        byte[] bytes = writer.getBytes();
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(identifier)
                        .stream(new StringBufferInputStream(writer), bytes.length, -1)
                        .contentType("application/json")
                        .build());
    }

    private byte[] objectToBytes(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }

    private void ifBucketDoesntExistCreateIt(String bucketName, MinioClient client) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        boolean found =  client.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found) {
            client.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }
}
