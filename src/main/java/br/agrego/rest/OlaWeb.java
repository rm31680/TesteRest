package br.agrego.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class OlaWeb {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/ola")
	public String ola(){
		System.out.println("teste");
		return "Teste de ws Rest para CronApp";
	}
}
