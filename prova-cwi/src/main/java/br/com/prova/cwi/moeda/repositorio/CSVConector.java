package br.com.prova.cwi.moeda.repositorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVConector {

	private String arquivo;

	public CSVConector(String arquivo) {
		super();
		this.arquivo = arquivo;
	}

	public List<String> obterLinhas() {
		List<String> linhasCSV = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(arquivo));

			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				linhasCSV.add(linha);
			}
		} catch (Exception e) {
			System.out.println("erro ao ler o arquivo!");
		}
		return linhasCSV;
	}
}
