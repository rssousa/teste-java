package br.com.prova.cwi.conversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.prova.cwi.moeda.Cotacao;
import br.com.prova.cwi.moeda.repositorio.MoedaRepositorio;

public class ConversorMoedas {

	private ConversorMoedaUSD conversorMoedaUSD;

	private MoedaRepositorio moedaRepositorio;

	public ConversorMoedas(ConversorMoedaUSD conversorMoedaUSD, MoedaRepositorio moedaRepositorio) {
		super();
		this.conversorMoedaUSD = conversorMoedaUSD;
		this.moedaRepositorio = moedaRepositorio;
	}

	public BigDecimal currencyQuotation(String from, String to, Number value, String quotation) {

		if (value.doubleValue() < 0) {
			throw new IllegalArgumentException("Valor de conversão inválido");
		}

		Cotacao cotacaoOrigem = moedaRepositorio.obterCotacao(from, quotation);

		Cotacao cotacaoDestino = moedaRepositorio.obterCotacao(to, quotation);

		Double valorUnitarioDolarUSD = 1.0;
		if (!cotacaoOrigem.getSiglaMoeda().equals("USD")) {
			valorUnitarioDolarUSD = conversorMoedaUSD.converterEmDolarUSD(cotacaoOrigem.getTipo(),
					cotacaoOrigem.getParidadeCompra(), 1.0);
		}

		Double valorConvertido = 0.0;

		if (cotacaoDestino.getSiglaMoeda().equals("USD")) {
			valorConvertido = conversorMoedaUSD.converterEmDolarUSD(cotacaoOrigem.getTipo(),
					cotacaoOrigem.getParidadeCompra(), 1.0);
		} else {
			valorConvertido = conversorMoedaUSD.converterDolarUSDEmOutraMoeda(cotacaoDestino.getTipo(),
					cotacaoDestino.getParidadeCompra(), valorUnitarioDolarUSD);
		}
		Double valorTotalConvertido = valorConvertido * value.doubleValue();

		return new BigDecimal(valorTotalConvertido).setScale(2, RoundingMode.HALF_DOWN);
	}

	public MoedaRepositorio getMoedaRepositorio() {
		return moedaRepositorio;
	}

	public void setMoedaRepositorio(MoedaRepositorio moedaRepositorio) {
		this.moedaRepositorio = moedaRepositorio;
	}

}
