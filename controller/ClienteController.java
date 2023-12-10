package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Endereco;
import model.PessoaFisica;
import model.PessoaJuridica;

public class ClienteController implements Serializable {

	private static final long serialVersionUID = -2986449868123120251L;

	private Map<String, Endereco> enderecos;
	private Map<String, PessoaFisica> pessoasFisicas;
	private Map<String, PessoaJuridica> pessoasJuridicas;

	public ClienteController() {

		enderecos = new TreeMap<>();
		pessoasFisicas = new TreeMap<>();
		pessoasJuridicas = new TreeMap<>();
	}

	public void addEndereco(String rua, int numero, String bairro, String cidade, String complemento) {
		enderecos.put(rua, new Endereco(rua, numero, bairro, cidade, complemento));
		MainController.save();
	}

	public Set<String> getEnderecos() {
		return enderecos.keySet(); // retorna lista das chaves do map modelos
	}

	public void addPessoaFisica(String nome, String email, long telefone, String endereco, long cpf, long cnh,
			Date valCNH) {
		Endereco endereco1 = enderecos.get(endereco); // retorna objeto Categoria para chave do map

		PessoaFisica pessoa = new PessoaFisica(cpf, cnh, valCNH, nome, telefone, email, endereco1);

		pessoasFisicas.put(pessoa.getNome(), pessoa);

		MainController.save();
	}

	public Set<String> getPessoasFisicas() {
		return pessoasFisicas.keySet(); // retorna lista das chaves do map modelos
	}

	public void addPessoaJuridica(String nome, String email, long telefone, String endereco, long cnpj,
			String contato) {
		Endereco endereco1 = enderecos.get(endereco); // retorna objeto Categoria para chave do map

		PessoaJuridica pessoa = new PessoaJuridica(cnpj, contato, nome, telefone, email, endereco1);

		pessoasJuridicas.put(pessoa.getNome(), pessoa);

		MainController.save();
	}

	public Set<String> getPessoasJuridicas() {
		return pessoasJuridicas.keySet(); // retorna lista das chaves do map modelos
	}
}
