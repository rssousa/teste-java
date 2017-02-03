package br.com.prova.cwi.conversor;

public class ConversorMoedaUSD {

	public Double converterEmDolarUSD(String tipoMoeda, Double paridadeCompra, Double valorUnitario) {

		Double valorEmDolarUSD = null;

		if (tipoMoeda.equals("A")) {

			valorEmDolarUSD = valorUnitario / paridadeCompra;
		} else if (tipoMoeda.equals("B")) {

			valorEmDolarUSD = valorUnitario * paridadeCompra;
		}
		return valorEmDolarUSD;
	}

	public Double converterDolarUSDEmOutraMoeda(String tipoMoeda, Double paridadeCompra, Double valorUnitario) {
		Double valorEmOutraMoeda = null;
		if (tipoMoeda.equals("A")) {
			valorEmOutraMoeda = valorUnitario * paridadeCompra;
		} else if (tipoMoeda.equals("B")) {
			valorEmOutraMoeda = valorUnitario / paridadeCompra;
		}
		return valorEmOutraMoeda;
	}
}
