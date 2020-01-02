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
	public void deveSaveTransportadora() throws Exception {
		
		Response response = RestAssured.request(Method.GET, "/transportadoras/6");

		Assume.assumeTrue("Obteve status code diferente 404", response.statusCode() == 404);

		Transportadora transportadora = new Transportadora();

		transportadora.setCnpj("59291534000167");
		transportadora.setBairro("Rio Doce");
		transportadora.setEmail("testeteste@gmail.com");
		transportadora.setNome("Teste6");
		transportadora.setEmpresa("Empresa Test6");
		transportadora.setTelefone("81996999999");
		transportadora.setModal(ModalEnum.AEREO);
		transportadora.setRua("Rua teste6");
		transportadora.setNumero(7);
		transportadora.setBairro("teste6");
		transportadora.setCidade("teste6");
		transportadora.setUf(UfEnum.PE);
		transportadora.setCep("50000000");

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
	public void deveConsultarTransportadora() throws Exception{
		
		RestAssured.given()
					.when()
						.get("/transportadoras/1")
					.then()
						.log().body()
						.assertThat().statusCode(200)
						.body("cnpj", Matchers.is("61189288000189"))
					;		
		
	}
	
	@Test
	public void deveConsultarTransportadorFail() throws Exception{
		
		RestAssured.given()
					.when()
						.get("/transportadoras/7")
					.then()
						.log().body()
						.assertThat().statusCode(404)
					;				
	}
	
	@Test
	public void deveAlterarTransportadora() throws Exception {
		
		Response response = RestAssured.request(Method.GET, "/transportadoras/1");
		Gson gson = new Gson();
		Transportadora transportadora = gson.fromJson(response.asString(), Transportadora.class);
		transportadora.setEmail("kariny2020@gmail.com");
		
		String json = gson.toJson(transportadora);
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(json)
					.when()
						.put("/transportadoras")
					.then()
						.log().body()
						.assertThat().statusCode(200)
						.body("email", Matchers.is("kariny2020@gmail.com"))
					;				
	}
	
	@Test
	public void deveObterUmaListaDeTransportadoras() throws Exception {
		
		RestAssured.given()
					.when()
						.get("/transportadoras")
					.then()
						.log().body()
						.assertThat().statusCode(200)
					;
	}
	
	@Test
	public void deveExcluirTransportadora() throws Exception {
		
		RestAssured.given()
					.with()
						.delete("transportadoras/2")
					.then()
						.assertThat().statusCode(204)
					;		
	}
	
	@Test
	public void deveFiltrarTransportadoraPeloNome() throws Exception {
		
		RestAssured.given()
					.log().body()
					.with()
						.get("transportadoras?filter&nome=Teste1")
					.then()
						.log().body()
						.assertThat().statusCode(200)
						.body("nome", Matchers.hasItem("Teste1"))
					;		
	}
	
	@Test
	public void deveFiltrarTransportadoraPeloUf() throws Exception {
		
		RestAssured.given()
					.log().body()
					.with()
						.get("transportadoras?filter&uf=PE")
					.then()
						.log().body()
						.assertThat().statusCode(200)
						.body("uf", Matchers.hasItem("PE"))
					;		
	}
	
	@Test
	public void deveFiltrarTransportadoraPelaCidade() throws Exception {
		
		RestAssured.given()
					.log().body()
					.with()
						.get("transportadoras?filter&cidade=Teste1")
					.then()
						.log().body()
						.assertThat().statusCode(200)
						.body("cidade", Matchers.hasItem("teste1"))
					;		
	}
	
	@Test
	public void deveValidarCnpjExitenteNaBaseDeDados() throws Exception {

		Transportadora transportadora = new Transportadora();

		transportadora.setCnpj("61189288000189");
		transportadora.setBairro("Rio Doce");
		transportadora.setEmail("testeteste7@gmail.com");
		transportadora.setNome("Teste7");
		transportadora.setEmpresa("Empresa Test7");
		transportadora.setTelefone("81996999999");
		transportadora.setModal(ModalEnum.AEREO);
		transportadora.setRua("Rua teste7");
		transportadora.setNumero(7);
		transportadora.setBairro("teste7");
		transportadora.setCidade("teste7");
		transportadora.setUf(UfEnum.PE);
		transportadora.setCep("50000000");

		Gson gson = new Gson();
		String json = gson.toJson(transportadora);
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(json)
						.log().body()
					.when()
						.post("/transportadoras")
					.then()
						.assertThat().statusCode(406)
						.log().body()
					;									
	}
	
	@Test
	public void deveValidarTransportadoraCamposObrigatorios() throws Exception {

		Transportadora transportadora = new Transportadora();

		transportadora.setCnpj("19940591000105");
		transportadora.setBairro("teste8");
		transportadora.setEmail("testeteste8@gmail.com");
		transportadora.setEmpresa("Empresa Test8");
		transportadora.setTelefone("81996999999");
		transportadora.setModal(ModalEnum.AEREO);
		transportadora.setRua("Rua teste8");
		transportadora.setNumero(7);
		transportadora.setBairro("teste8");
		transportadora.setCidade("teste8");
		transportadora.setUf(UfEnum.PE);
		transportadora.setCep("50000000");

		Gson gson = new Gson();
		String json = gson.toJson(transportadora);
		
		RestAssured.given()
						.contentType(ContentType.JSON)
						.body(json)
						.log().body()
					.when()
						.post("/transportadoras")
					.then()
						.assertThat().statusCode(406)
						.log().body()
					;									
	}

}
