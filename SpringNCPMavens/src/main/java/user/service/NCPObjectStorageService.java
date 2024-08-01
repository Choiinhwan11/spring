package user.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.conf.NaverConfiguration;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
public class NCPObjectStorageService implements ObjectStorageService {

    final AmazonS3 s3;

    public NCPObjectStorageService(NaverConfiguration naverConfiguration) {
        s3 = AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder
                                .EndpointConfiguration(naverConfiguration.getEndPoint(),
                                naverConfiguration.getRegionName())
                )
                .withCredentials(new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(naverConfiguration.getAccessKey(),
                                        naverConfiguration.getSecretKey())
                        )
                )
                .build();
    }


    @Override
    public String uploadFile(String bucketName, String directoryPath, MultipartFile img) {
        if(img.isEmpty()) return null;
        
        try(InputStream fileIn = img.getInputStream()){

            // 둘중에 하나 쓰면된다.
            //String fileName = img.getOriginalFilename(); 얘는 오리지날 파일명
            String fileName = UUID.randomUUID().toString(); // 얜 UUID 형식으로

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(img.getContentType());

            PutObjectRequest putObjectRequest =
                    new PutObjectRequest(bucketName
                            , directoryPath + fileName
                            , fileIn
                            , objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead);

            s3.putObject(putObjectRequest); // 실제로 올라가는

            return fileName;

        }catch (Exception e){
            throw new RuntimeException("파일 업로드 에러 " + e);// 강제로 Exception 발생시키는 throw
           // e.printStackTrace(); // return 타입이 String 이기때문에 e.print~는 안된다. String을 리턴하지 않기때문에
        }
    }

    @Override
    public void deleteFile(String bucketName, String directoryPath, String imageFileName) {
        s3.deleteObject(bucketName, directoryPath+imageFileName);
    }

    @Override
    public void deleteFile(String bucketName, String directoryPath, List<String> list) {
        for(String imageFileName : list){
            s3.deleteObject(bucketName, directoryPath+imageFileName);
        }
    }
}
