package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.EStatusVeiculo;
import model.Modelo;
import model.Veiculo;

public class CatalogoController implements Serializable {

	private static final long serialVersionUID = -72557671006294137L;

	private Map<String, Modelo> modelos;
	private Map<String, Veiculo> veiculos;

	public CatalogoController() {

		modelos = new TreeMap<>();
	}

	public void addModelo(String nome, int anoModelo, String fabricante) {
		modelos.put(nome, new Modelo(nome, anoModelo, fabricante)); // insere novo objeto categoria no map modelos
		MainController.save();
	}

	public Set<String> getModelos() {
		return modelos.keySet(); // retorna lista das chaves do map modelos
	}

	public void addVeiculo(String placa, int anoFabricacao, String cor, EStatusVeiculo statusVeiculo, int quilometragem,
			String modelo) {

		Modelo modelo1 = modelos.get(modelo); // retorna objeto Modelo para chave do map

		Veiculo veiculo = new Veiculo(placa, cor, anoFabricacao, modelo1);
		veiculo.setQuilometragem(quilometragem);
		veiculo.setStatus(statusVeiculo);

		System.out.printf("%s\n", modelo1.getNome());
		veiculos.put(veiculo.getPlaca(), veiculo);

		if (modelo1 != null)
			modelo1.addVeiculo(veiculo);

		MainController.save();
	}

	public List<String> getVeiculos() {

		List<String> lista = new ArrayList<>();

		for (Veiculo veiculo : veiculos.values())
			lista.add(String.format("%s\t%d\t%s\t%s\t%d\t%s\t", veiculo.getPlaca(), veiculo.getAnoFabricacao(),
					veiculo.getCor(), veiculo.getStatus().name(), veiculo.getQuilometragem(),
					veiculo.getModelo().getNome()));

		return lista;
	}

	public List<String> getVeiculos(String nomeModelo) {

		Modelo modelo = modelos.get(nomeModelo);

		List<String> lista = new ArrayList<>();

		for (Veiculo veiculo : modelo.getVeiculos())
			lista.add(String.format("%s\t%d\t%s\t%s\t%d\t%s\t", veiculo.getPlaca(), veiculo.getAnoFabricacao(),
					veiculo.getCor(), veiculo.getStatus().name(), veiculo.getQuilometragem(),
					veiculo.getModelo().getNome()));

		return lista;
	}

}