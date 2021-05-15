package br.com.alura.loja.modelo;

import javax.persistence.Entity;

@Entity
public class Videogame extends Produto {

	private Integer arquitetura;
	private Integer anoLancamento;
	private String modelo;
	
	public Videogame() {}

	public Videogame(Integer arquitetura, Integer anoLancamento, String modelo) {
		this.arquitetura = arquitetura;
		this.anoLancamento = anoLancamento;
		this.modelo = modelo;
	}

	public Integer getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(Integer arquitetura) {
		this.arquitetura = arquitetura;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}