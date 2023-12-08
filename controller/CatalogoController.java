package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Modelo;

public class CatalogoController implements Serializable {


	private static final long serialVersionUID = -72557671006294137L;
	private Map<String, Modelo> modelos;

	public CatalogoController() {

		modelos = new TreeMap<>();
	}

	public void addModelo(String nome, int anoModelo, String fabricante) {
		modelos.put(nome, new Modelo(nome, anoModelo, fabricante)); // insere novo objeto categoria no map modelos
		MainController.save();
	}
	
	public Set<String> getModelos() {
		return modelos.keySet();	 // retorna lista das chaves do map categorias
	}
}