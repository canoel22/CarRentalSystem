package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Categoria;
import model.EStatusVeiculo;
import model.Modelo;
import model.Seguro;
import model.Veiculo;

public class CatalogoController implements Serializable {

	private static final long serialVersionUID = -72557671006294137L;

	private Map<String, Modelo> modelos;
	private Map<String, Veiculo> veiculos;
	private Map<String, Categoria> categorias;
	private Map<String, Seguro> seguros;

	public CatalogoController() {

		modelos = new TreeMap<>();
		veiculos = new TreeMap<>();
		categorias = new TreeMap<>();
		seguros = new TreeMap<>();
	}

	public void addModelo(String nome, int anoModelo, String fabricante) {
		modelos.put(nome, new Modelo(nome, anoModelo, fabricante)); // insere novo objeto categoria no map modelos
		MainController.save();
	}

	public Set<String> getModelos() {
		return modelos.keySet(); // retorna lista das chaves do map modelos
	}

	public void addCategoria(String nome, double tarifaDiaria) {
		if (categorias == null) {
			categorias = new TreeMap<>();
		}
		categorias.put(nome, new Categoria(nome, tarifaDiaria)); // insere novo objeto categoria no map modelos
		MainController.save();
	}

	public Set<String> getCategorias() {
		if (categorias == null) {
			categorias = new TreeMap<>();
		}
		return categorias.keySet(); // retorna lista das chaves do map categorias

	}

	public void addSeguro(String descricao, int percentualTarifa) {
		if (seguros == null) {
			seguros = new TreeMap<>();
		}
		seguros.put(descricao, new Seguro(descricao, percentualTarifa)); // insere novo objeto categoria no map seguros
		MainController.save();
	}

	public Set<String> getSeguros() {
		if (seguros == null) {
			seguros = new TreeMap<>();
		}
		return seguros.keySet(); // retorna lista das chaves do map categorias

	}

	public void addVeiculo(String placa, int anoFabricacao, String cor, EStatusVeiculo statusVeiculo, int quilometragem,
			String modelo, String categoria) {

		if (veiculos == null) {
			veiculos = new TreeMap<>();
		}

		Modelo modelo1 = modelos.get(modelo); // retorna objeto Modelo para chave do map

		Categoria categoria1 = categorias.get(categoria); // retorna objeto Modelo para chave do map

		Veiculo veiculo = new Veiculo(placa, cor, anoFabricacao, modelo1);
		veiculo.setQuilometragem(quilometragem);
		veiculo.setStatus(statusVeiculo);

		// System.out.printf("%s\n", modelo1.getNome());
		veiculos.put(veiculo.getPlaca(), veiculo);

		if (modelo1 != null)
			modelo1.addVeiculo(veiculo);

		if (categoria1 != null)
			categoria1.addVeiculo(veiculo);

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

		System.out.printf("%s", modelo.getNome());

		List<String> lista = new ArrayList<>();

		for (Veiculo veiculo : modelo.getVeiculos())
			lista.add(String.format("%s\t%d\t%s\t%s\t%d\t%s\t", veiculo.getPlaca(), veiculo.getAnoFabricacao(),
					veiculo.getCor(), veiculo.getStatus().name(), veiculo.getQuilometragem(),
					veiculo.getModelo().getNome()));

		return lista;
	}

	public List<String> getVeiculosCat(String nomeCategoria) {

		Categoria categoria = categorias.get(nomeCategoria);

		System.out.printf("%s", categoria.getNome());

		List<String> lista = new ArrayList<>();

		for (Veiculo veiculo : categoria.getVeiculos())
			lista.add(String.format("%s\t%d\t%s\t%s\t%d\t%s\t", veiculo.getPlaca(), veiculo.getAnoFabricacao(),
					veiculo.getCor(), veiculo.getStatus().name(), veiculo.getQuilometragem(),
					veiculo.getModelo().getNome()));

		return lista;
	}

}