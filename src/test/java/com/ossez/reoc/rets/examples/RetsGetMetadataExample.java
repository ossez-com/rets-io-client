package com.ossez.reoc.rets.examples;

import java.net.MalformedURLException;

import com.ossez.reoc.rets.client.*;
import com.ossez.reoc.rets.common.metadata.types.MClass;
import com.ossez.reoc.rets.common.metadata.types.MResource;
import com.ossez.reoc.rets.common.metadata.types.MSystem;

/**
 * Simple Example performing a GetMetadata and iterating of the results
 *
 */
public class RetsGetMetadataExample {

	public static void main(String[] args) throws MalformedURLException {

		//Create a RetsHttpClient (other constructors provide configuration i.e. timeout, gzip capability)
		RetsHttpClient httpClient = new CommonsHttpClient();
		RetsVersion retsVersion = RetsVersion.RETS_1_7_2;
		String loginUrl = "http://neren.rets.paragonrels.com/rets/fnisrets.aspx/NEREN/login";

		//Create a RetesSession with RetsHttpClient
		RetsSession session = new RetsSession(loginUrl, httpClient, retsVersion);    

		String username = "prurets1";
		String password = "boyd070110";

		//Set method as GET or POST
		session.setMethod("POST");
		try {
			//Login
			LoginResponse loginResponse = session.login(username, password);

			System.out.println(">>>" + loginResponse.getSessionId());
		} catch (RetsException e) {
			e.printStackTrace();
		}

		try {
			MSystem system = session.getMetadata().getSystem();
			System.out.println(
					"SYSTEM: " + system.getSystemID() + 
					" - " + system.getSystemDescription());

			for(MResource resource: system.getMResources()) {

				System.out.println(
						"    RESOURCE: " + resource.getResourceID());

				for(MClass classification: resource.getMClasses()) {
					System.out.println(
							"        CLASS: " + classification.getClassName() +
							" - " + classification.getDescription());
				}
			}
		}
		catch (RetsException e) {
			e.printStackTrace();
		} 	
		finally {
			if(session != null) { 
				try {
					session.logout(); 
				} 
				catch(RetsException e) {
					e.printStackTrace();
				}
			}
		}
	}	
}
