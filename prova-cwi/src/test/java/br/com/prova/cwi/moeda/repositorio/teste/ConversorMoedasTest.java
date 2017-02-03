package br.com.prova.cwi.moeda.repositorio.teste;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.prova.cwi.conversor.ConversorMoedaUSD;
import br.com.prova.cwi.conversor.ConversorMoedas;
import br.com.prova.cwi.moeda.repositorio.CSVConector;
import br.com.prova.cwi.moeda.repositorio.MoedaRepositorio;

public class ConversorMoedasTest {

	private static ConversorMoedas conversorMoedas;

	@BeforeClass
	public static void setup() {
		ConversorMoedaUSD conversorMoedaUSD = new ConversorMoedaUSD();

		final String caminhoArquivo = "/home/romulo/Downloads/20170102.csv";

		CSVConector csvConector = new CSVConector(caminhoArquivo);

		MoedaRepositorio moedaRepositorio = new MoedaRepositorio(csvConector);

		conversorMoedas = new ConversorMoedas(conversorMoedaUSD, moedaRepositorio);
	}

	
	
	
	@Test
	public void converterDolarUSDParaEURO() {

		final String from = "USD";
		final String to = "EUR";

		Double valorCalculado = conversorMoedas.currencyQuotation(from, to, 100, "02/01/2017").doubleValue();

		Assert.assertThat(95.50, equalTo(valorCalculado.doubleValue()));
	}

	@Test
	public void converterDolarUSDParaDolarAUD() {

		final String from = "USD";
		final String to = "AUD";

		Double valorCalculado = conversorMoedas.currencyQuotation(from, to, 100, "02/01/2017").doubleValue();

		Assert.assertThat(139.14, equalTo(valorCalculado.doubleValue()));
	}

	@Test
	public void converterDolarAUDParaEURO() {

		final String from = "AUD";
		final String to = "EUR";

		Double valorCalculado = conversorMoedas.currencyQuotation(from, to, 100, "02/01/2017").doubleValue();

		Assert.assertThat(68.64, equalTo(valorCalculado.doubleValue()));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void converterValorInavalido() {

		final String from = "AUD";
		final String to = "EUR";

		Double valorCalculado = conversorMoedas.currencyQuotation(from, to, -1, "02/01/2017").doubleValue();

		Assert.assertThat(68.64, equalTo(valorCalculado.doubleValue()));
	}
}
