import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws InterruptedException, IOException {



        String bucketName = "fc-dev-s3";
        String folderName = "/Oms/OrderCheckout/filehandlerservice/EXTERNAL_REPORT_OMS_ONDECK/PG/BDK_PG/2020/06/27/DOWNLOAD";
        String fileNameInS3 = "demo.txt";
        String local_dst="abhi"; // Write privilege

        Downloader.download(bucketName,folderName,fileNameInS3,local_dst);
        System.out.println("Downloading Done :");






    }


}
