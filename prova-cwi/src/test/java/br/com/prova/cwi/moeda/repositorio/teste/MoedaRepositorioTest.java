package br.com.prova.cwi.moeda.repositorio.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.prova.cwi.moeda.Cotacao;
import br.com.prova.cwi.moeda.repositorio.CSVConector;
import br.com.prova.cwi.moeda.repositorio.MoedaRepositorio;

public class MoedaRepositorioTest {

	@Test
	public void obterMoeda() {

		final String caminhoArquivo = "/home/romulo/Downloads/20170102.csv";

		CSVConector csvConector = new CSVConector(caminhoArquivo);

		MoedaRepositorio moedaRepositorio = new MoedaRepositorio(csvConector);

		Cotacao moeda = moedaRepositorio.obterCotacao("USD", "02/01/2017");

		Assert.assertNotNull(moeda);
		Assert.assertEquals("A", moeda.getTipo());
		Assert.assertNotNull(moeda.getParidadeCompra());
	}

	@Test(expected = IllegalArgumentException.class)
	public void obterMoedaInvalida() {

		final String caminhoArquivo = "/home/romulo/Downloads/20170102.csv";

		CSVConector csvConector = new CSVConector(caminhoArquivo);

		MoedaRepositorio moedaRepositorio = new MoedaRepositorio(csvConector);

		moedaRepositorio.obterCotacao("AAA", "02/01/2017");
	}

	@Test(expected = IllegalArgumentException.class)
	public void obterMoedaDataNaoDisponivel() {

		final String caminhoArquivo = "/home/romulo/Downloads/20170102.csv";

		CSVConector csvConector = new CSVConector(caminhoArquivo);

		MoedaRepositorio moedaRepositorio = new MoedaRepositorio(csvConector);

		moedaRepositorio.obterCotacao("USD", "07/01/2017");
	}

	@Test(expected = IllegalArgumentException.class)
	public void obterMoedaDataFormatoInvalido() {

		final String caminhoArquivo = "/home/romulo/Downloads/20170102.csv";

		CSVConector csvConector = new CSVConector(caminhoArquivo);

		MoedaRepositorio moedaRepositorio = new MoedaRepositorio(csvConector);

		moedaRepositorio.obterCotacao("USD", "02-01-2017");
	}

}
