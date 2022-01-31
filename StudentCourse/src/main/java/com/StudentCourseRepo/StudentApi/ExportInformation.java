package com.StudentCourseRepo.StudentApi;

// importing the required classes to work with s3 and aws.

public class ExportInformation {
	
	
	public String UploadToS3(int cid) {
		CreateS3Bucket bucket = new CreateS3Bucket();
		String bucketLocation = bucket.CreateS3Bucket(cid);
		System.out.println("The location of bucket:- "+bucketLocation);
		
		return bucketLocation;
	}
	
	
}
