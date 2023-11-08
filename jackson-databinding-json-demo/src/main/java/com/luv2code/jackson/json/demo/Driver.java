package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read json file and map and convert to POJO
			//File is placed at /data/sample-full.json
			
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print the firstname and lastName 
			System.out.println(theStudent.getFirstName());
			System.out.println(theStudent.getLastName());
			
			//print out the address
			
			Address tempAddress = theStudent.getAddress();
			System.out.println("street :" + tempAddress.getStreet());
			System.out.println("city :" + tempAddress.getCity());
			
			
			//print the languages 
			for(String tempLanguages : theStudent.getLanguages()) {
				System.out.println(tempLanguages);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
