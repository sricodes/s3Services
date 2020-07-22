import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Downloader {


    public static void download(String bucketName, String folderName,String fileNameInS3 ,String local_dst) throws IOException, InterruptedException {

       /* BasicAWSCredentials awsCreds = new BasicAWSCredentials(key,Token);
        AWSStaticCredentialsProvider amAwsStaticCredentialsProvider=  new AWSStaticCredentialsProvider(awsCreds);
        AmazonS3ClientBuilder standard = AmazonS3ClientBuilder.standard();
        standard.withCredentials(amAwsStaticCredentialsProvider);
        standard.withRegion(Regions.AP_SOUTH_1);
        AmazonS3 s3Client = standard.build();
*/
        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        TransferManager transferManager = TransferManagerBuilder.standard().withS3Client(s3Client).build();
        Download download = transferManager.download(bucketName,"filename", new File(local_dst));
        download.waitForCompletion();

        transferManager.shutdownNow();

        Path filePath = Paths.get(local_dst);
        long fileSize = Files.size(filePath);
        System.out.println(fileSize);

    }


}
