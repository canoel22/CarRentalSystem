package controller;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable {

	
	private static final long serialVersionUID = -8234175931152872866L;

	private static MainController instance;

	private CatalogoController catalogoController;
	private ClienteController clienteController;
	private LocacaoController locacaoController;
	
	private MainController() {
		
		catalogoController = new CatalogoController();
		clienteController = new ClienteController();
		locacaoController = new LocacaoController();		
	}
	
	public static MainController getInstance() {
		return instance;
	}
	
	public static CatalogoController getCatalogoController() {
		return instance.catalogoController;
	}
	
	public static ClienteController getClienteController() {
		return instance.clienteController;
	}
	
	public static LocacaoController getLocacaoController() {
		return instance.locacaoController;
	}
	
	
	public static void load() {

		instance = Serializer.readFile();

		if (instance == null) {
			instance = new MainController();
		}
	}

	public static void save() {
		Serializer.writeFile(instance);
	}

	
}
