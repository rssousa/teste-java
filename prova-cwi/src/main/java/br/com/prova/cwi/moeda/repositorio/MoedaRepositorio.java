package br.com.prova.cwi.moeda.repositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.prova.cwi.moeda.Cotacao;

public class MoedaRepositorio {

	private CSVConector csvConector;

	public MoedaRepositorio(CSVConector csvConector) {
		super();
		this.csvConector = csvConector;
	}

	public Cotacao obterCotacao(String moedaSigla, String dataSolicitada) {
		Cotacao cotacao = null;

		boolean isSiglaValida = Boolean.FALSE;

		for (String linha : csvConector.obterLinhas()) {
			if (linha.indexOf(moedaSigla) > -1) {

				isSiglaValida = Boolean.TRUE;

				String[] colunasLinha = linha.split(";");

				Date dataSolicitadaTmp = converterToDate(dataSolicitada);
				Date dataCotacao = converterToDate(colunasLinha[0]);

				if (dataCotacao.equals(dataSolicitadaTmp)) {
					cotacao = new Cotacao();
					cotacao.setTipo(colunasLinha[2]);
					cotacao.setParidadeCompra(Double.parseDouble(colunasLinha[6].replaceAll(",", ".")));
					cotacao.setSiglaMoeda(colunasLinha[3]);
				}
			}
		}

		if (!isSiglaValida) {
			throw new IllegalArgumentException("moeda inválida");
		}

		if (isSiglaValida && cotacao == null) {
			throw new IllegalArgumentException("data da cotação não disponível");
		}

		return cotacao;
	}

	public void setCsvConector(CSVConector csvConector) {
		this.csvConector = csvConector;
	}

	private Date converterToDate(String data) {

		Calendar calendario = Calendar.getInstance();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataTmp = null;
		try {
			dataTmp = simpleDateFormat.parse(data);
			calendario.setTime(dataTmp);

			if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				calendario.add(Calendar.DAY_OF_WEEK, 2);
				return calendario.getTime();
			}

			if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				calendario.add(Calendar.DAY_OF_WEEK, 1);
				return calendario.getTime();
			}

		} catch (ParseException e) {
			throw new IllegalArgumentException("Data inválida");
		}
		return dataTmp;
	}

}
