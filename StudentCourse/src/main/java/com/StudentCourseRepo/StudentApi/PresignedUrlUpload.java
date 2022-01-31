package com.StudentCourseRepo.StudentApi;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.io.File;
import javax.net.ssl.HttpsURLConnection;
import org.joda.time.DateTime;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

public class PresignedUrlUpload {
	
	private Regions region = Regions.AP_SOUTH_1;
	private String bucketName = "fe-backup-bucket";
	private String access_key = "AKIAQID3PYRIG7XB7F4W";
	private String secret_key = "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";
//	private String objectKey = "C:/blazeclan/FormsExpress/DB-testing/Tables";
	private String objectKey = "116";
	private BasicAWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
	private AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withRegion(region)
			.build();
	private Date expirationTime;
	private Calendar date = Calendar.getInstance();

	
	public PresignedUrlUpload() {
		super();
		// TODO Auto-generated constructor stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		long timeInMillis = date.getTimeInMillis();
		expirationTime =new Date(timeInMillis + (60*60*1000));
		System.out.println("Expiration time:- "+date.getTime());
		System.out.println("Expiration time:- "+timeInMillis);
		System.out.println("Expiration time:- "+expirationTime);
		System.out.println("Here begins the creating of expiring url....");
		System.out.println("The Presigned Url Generated:- "+generatingPreSignedUrl());
	}
	
	
	public URL generatingPreSignedUrl() {
		GeneratePresignedUrlRequest preSignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
				.withMethod(HttpMethod.PUT)
				.withExpiration(expirationTime);
		URL url = s3Client.generatePresignedUrl(preSignedUrlRequest);
		try {
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			System.out.println(connection);
			System.out.println(connection.getResponseCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (url);
		
	}
	
	
}


//
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.HttpMethod;
//import com.amazonaws.SdkClientException;
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
//import com.amazonaws.services.s3.model.S3Object;
//
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class GeneratePresignedUrlAndUploadObject {
//
//    public static void main(String[] args) throws IOException {
//        Regions clientRegion = Regions.DEFAULT_REGION;
//        String bucketName = "*** Bucket name ***";
//        String objectKey = "*** Object key ***";
//
//        try {
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withCredentials(new ProfileCredentialsProvider())
//                    .withRegion(clientRegion)
//                    .build();
//
//            // Set the pre-signed URL to expire after one hour.
//            java.util.Date expiration = new java.util.Date();
//            long expTimeMillis = expiration.getTime();
//            expTimeMillis += 1000 * 60 * 60;
//            expiration.setTime(expTimeMillis);
//
//            // Generate the pre-signed URL.
//            System.out.println("Generating pre-signed URL.");
//            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
//                    .withMethod(HttpMethod.PUT)
//                    .withExpiration(expiration);
//            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
//
//            // Create the connection and use it to upload the new object using the pre-signed URL.
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoOutput(true);
//            connection.setRequestMethod("PUT");
//            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//            out.write("This text uploaded as an object via presigned URL.");
//            out.close();
//
//            // Check the HTTP response code. To complete the upload and make the object available, 
//            // you must interact with the connection object in some way.
//            connection.getResponseCode();
//            System.out.println("HTTP response code: " + connection.getResponseCode());
//
//            // Check to make sure that the object was uploaded successfully.
//            S3Object object = s3Client.getObject(bucketName, objectKey);
//            System.out.println("Object " + object.getKey() + " created in bucket " + object.getBucketName());
//        } catch (AmazonServiceException e) {
//            // The call was transmitted successfully, but Amazon S3 couldn't process 
//            // it, so it returned an error response.
//            e.printStackTrace();
//        } catch (SdkClientException e) {
//            // Amazon S3 couldn't be contacted for a response, or the client  
//            // couldn't parse the response from Amazon S3.
//            e.printStackTrace();
//        }
//    }
//}
//
