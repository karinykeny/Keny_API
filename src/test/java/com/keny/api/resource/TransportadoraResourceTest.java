package com.keny.api.resource;

import org.hamcrest.Matchers;
import org.junit.Assume;
import org.junit.Test;

import com.google.gson.Gson;
import com.keny.api.BaseTest;
import com.keny.api.modal.Transportadora;
import com.keny.api.modal.enums.ModalEnum;
import com.keny.api.modal.enums.UfEnum;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TransportadoraResourceTest extends BaseTest {
	
	@Test
	public void devSaveTransportadora() throws Exception {
		
		Response response = RestAssured.request(Method.GET, "/transportadoras/1");

		Assume.assumeTrue("Tabela não está vazia", response.statusCode() == 404);

		Transportadora transportadora = new Transportadora();

		transportadora.setCnpj("33200056000149");
		transportadora.setBairro("Rio Doce");
		transportadora.setEmail("karinykeny@gmail.com");
		transportadora.setNome("Kariny Keny");
		transportadora.setEmpresa("Empresa Kariny");
		transportadora.setTelefone("81996912471");
		transportadora.setModal(ModalEnum.AEREO);
		transportadora.setRua("Rua da Laareira");
		transportadora.setNumero(66);
		transportadora.setBairro("Rio Doce");
		transportadora.setCidade("Olinda");
		transportadora.setUf(UfEnum.PE);
		transportadora.setCep("53080310");

		Gson gson = new Gson();
		String json = gson.toJson(transportadora);
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(json)
						.log().body()
					.when()
						.post("/transportadoras")
					.then()
						.assertThat().statusCode(201)
						.log().body()
					;									
	}
	
	@Test
	public void devConsultarTransportadora() throws Exception{
		
		RestAssured.given()
					.when()
						.get("/transportadoras/1")
					.then()
						.log().body()
						.assertThat().statusCode(200)
						.body("cnpj", Matchers.is("33200056000149"))
					;		
		
	}
	
	@Test
	public void devConsultarTransportadorFail() throws Exception{
		
		RestAssured.given()
					.when()
						.get("/transportadoras/5")
					.then()
						.log().body()
						.assertThat().statusCode(404)
					;		
		
	}

}
