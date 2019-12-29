package com.keny.api.modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

import com.keny.api.modal.enums.ModalEnum;
import com.keny.api.modal.enums.UfEnum;

@Entity(name = "transportadora")
public class Transportadora implements Serializable {

	private static final long serialVersionUID = -535792016041898627L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Preenchimento obrigatorio")
	@CNPJ
	private String cnpj;
	
	@Email(message = "E-mail inválido")
	private String email;
	
	@NotNull(message = "Preenchimento obrigatorio")
	private String nome;
	
	@NotNull(message = "Preenchimento obrigatorio")
	private String empresa;
	private String telefone;
	
	@NotNull(message = "Preenchimento obrigatorio")
	@Enumerated(EnumType.STRING)
	private ModalEnum modal;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UfEnum uf;
	private String cep;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ModalEnum getModal() {
		return modal;
	}

	public void setModal(ModalEnum modal) {
		this.modal = modal;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UfEnum getUf() {
		return uf;
	}

	public void setUf(UfEnum uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Transportadora [id=" + id + ", cnpj=" + cnpj + ", email=" + email + ", nome=" + nome + ", empresa="
				+ empresa + ", telefone=" + telefone + ", modal=" + modal + ", rua=" + rua + ", numero=" + numero
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]";
	}

}
