package br.com.prova.cwi.moeda;

import java.util.Date;

public class Cotacao {

	private Date dataCotacao;
	private String tipo;
	private Double paridadeCompra;
	private String siglaMoeda;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getParidadeCompra() {
		return paridadeCompra;
	}

	public void setParidadeCompra(Double paridadeCompra) {
		this.paridadeCompra = paridadeCompra;
	}

	public Date getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(Date dataCotacao) {
		this.dataCotacao = dataCotacao;
	}

	public String getSiglaMoeda() {
		return siglaMoeda;
	}

	public void setSiglaMoeda(String siglaMoeda) {
		this.siglaMoeda = siglaMoeda;
	}

	
}
