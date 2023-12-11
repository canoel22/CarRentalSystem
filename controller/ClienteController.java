package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Cliente;
import model.Endereco;
import model.PessoaFisica;
import model.PessoaJuridica;

public class ClienteController implements Serializable {

	private static final long serialVersionUID = -2986449868123120251L;

	private Map<String, Endereco> enderecos;
	private Map<String, Cliente> clientes;
	private Map<String, PessoaFisica> pessoasFisicas;
	private Map<String, PessoaJuridica> pessoasJuridicas;

	public ClienteController() {

		enderecos = new TreeMap<>();
		clientes = new TreeMap<>();
		pessoasFisicas = new TreeMap<>();
		pessoasJuridicas = new TreeMap<>();
	}

	public void addEndereco(String rua, int numero, String bairro, String cidade, String complemento) {
		enderecos.put(rua, new Endereco(rua, numero, bairro, cidade, complemento));
		MainController.save();
	}

	public Endereco getEnderecos(String rua, int numero, String bairro, String cidade, String complemento) {

		Endereco endereco = new Endereco(rua, numero, bairro, cidade, complemento);

		return endereco;
	}

	public List<String> getClientes() {
		List<String> lista = new ArrayList<>();

		for (Cliente cliente : clientes.values())
			lista.add(String.format("%s\t%s\t", cliente.getNome()));

		return lista;
	}

	public void addPessoaFisica(String nome, String email, String telefone, Endereco endereco, String cpf, String cnh,
			String valCNH) {

		PessoaFisica pessoa = new PessoaFisica(cpf, cnh, valCNH, nome, telefone, email, endereco);

		pessoasFisicas.put(pessoa.getNome(), pessoa);

		MainController.save();
	}

	public List<String> getPessoasFisicas() {
		List<String> lista = new ArrayList<>();

		for (PessoaFisica pessoaFisica : pessoasFisicas.values())
			lista.add(String.format("%s\t%s\t", pessoaFisica.getNome(), pessoaFisica.getCpf()));

		return lista;
	}

	public void addPessoaJuridica(String nome, String email, String telefone, Endereco endereco, String cnpj,
			String contato) {

		PessoaJuridica pessoa = new PessoaJuridica(cnpj, contato, nome, telefone, email, endereco);

		pessoasJuridicas.put(pessoa.getNome(), pessoa);

		MainController.save();
	}

	public List<String> getPessoasJuridicas() {
		List<String> lista = new ArrayList<>();

		for (PessoaJuridica pessoaJuridica : pessoasJuridicas.values())
			lista.add(String.format("%s\t%s\t", pessoaJuridica.getNome(), pessoaJuridica.getCnpj()));

		return lista;
	}
}
