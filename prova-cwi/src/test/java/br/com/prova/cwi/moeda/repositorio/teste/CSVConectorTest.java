package br.com.prova.cwi.moeda.repositorio.teste;

import static org.hamcrest.CoreMatchers.not;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Assert;
import org.junit.Test;

import br.com.prova.cwi.moeda.repositorio.CSVConector;

public class CSVConectorTest {

	@Test
	public void obterLinhas() {
		final String caminhoArquivo = "/home/romulo/Downloads/20170102.csv";

		CSVConector csvConector = new CSVConector(caminhoArquivo);

		List<String> linhasArquivo = csvConector.obterLinhas();

		Assert.assertThat(linhasArquivo, not(IsEmptyCollection.empty()));
	}
}
