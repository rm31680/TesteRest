package br.agrego.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.util.Base64;
import java.util.StringTokenizer;

@Path("/r")
public class OlaWeb2 {

	@Context
	private HttpServletRequest request;

	@GET
	@Path("/basic2")
	@Produces(MediaType.TEXT_PLAIN)
	public String authenticateHTTPHeader() {

		String decoded="";
		try {
			// Get the Authorisation Header from Request
			String header = request.getHeader("authorization");

			// Header is in the format "Basic 3nc0dedDat4"
			// We need to extract data before decoding it back to original string
			String data = header.substring(header.indexOf(" ") + 1);
			//String data = header.replaceFirst("Basic" + " ", "");
      
     // byte[] decodedBytes = Base64.getDecoder().decode(data);
			//decoded = new String(decodedBytes, "UTF-8");
			try {
			byte[] decodedBytes = Base64.getDecoder().decode(data);
			decoded = new String(decodedBytes, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		final	StringTokenizer tokenizer = new StringTokenizer(decoded, ":");
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		decoded=password;
			// Decode the data back to original string
			//byte[] bytes = new BASE64Decoder().decodeBuffer(data);
		// 	decoded = new String(bytes);
		//decoded = data;

		// 	System.out.println(decoded);

		} catch (Exception e) {
			e.printStackTrace();
			decoded = "No/Invalid authentication information provided";
		}

		return decoded + "aad2";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/ola2")
	public String ola() {
		System.out.println("teste");
		return "Teste de ws Rest para CronApp2";
	}
}
