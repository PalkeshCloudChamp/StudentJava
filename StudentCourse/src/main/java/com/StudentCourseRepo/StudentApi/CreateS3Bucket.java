package com.StudentCourseRepo.StudentApi;

import java.io.File;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.internal.MultipleFileUploadImpl;

public class CreateS3Bucket {

	Regions region = Regions.AP_SOUTH_1;
	String bucketName = "fe-backup-bucket";
	String access_key = "";
	String secret_key = "";
	
	BasicAWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
	AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(region)
			.build();
	public String CreateS3Bucket(int cid) {
        if (!s3Client.doesBucketExistV2(bucketName)) {
            // Because the CreateBucketRequest object doesn't specify a region, the
            // bucket is created in the region specified in the client.
            s3Client.createBucket(new CreateBucketRequest(bucketName));

            // Verify that the bucket was created by retrieving it and checking its location.   
        }
        String bucketLocation = s3Client.getBucketLocation(new GetBucketLocationRequest(bucketName));
        System.out.println("Bucket location: " + bucketLocation);
        TransferManager tm = TransferManagerBuilder.standard()
        		.withS3Client(s3Client)
        		.build();
        try {
        MultipleFileUpload uploadImpl = tm.uploadDirectory(bucketName, String.valueOf(cid), new File("C:/blazeclan/FormsExpress/DB-testing/Tables/"+cid), true);
        System.out.println("uploadImpl:- "+uploadImpl.getDescription());
        return "Upload Successfull";
        }
        catch (Exception e) {
			// TODO: handle exception
        	System.out.println("Some Error Occured while uploading information. Please try again. Process end with response: "+ e);
        	return "Error Occured. Process stoped with error: \n"+e;
		}
        
	}
}
