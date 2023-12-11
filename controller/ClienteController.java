package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.Endereco;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;

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

	public List<String> getEnderecos(String Rua) {
		List<String> lista = new ArrayList<>();

		for (Endereco endereco : enderecos.values())
			lista.add(String.format("%s\t%d\t%s\t%s\t%d\t%s\t", endereco.getRua(), endereco.getNumero(),
					endereco.getBairro(), endereco.getCidade(), endereco.getComplemento()));

		return lista;
			}

	public void addPessoaFisica(String nome, String email, long telefone, String endereco, long cpf, long cnh,
			Date valCNH) {
		Endereco endereco1 = enderecos.get(endereco); // retorna objeto Categoria para chave do map

		PessoaFisica pessoa = new PessoaFisica(cpf, cnh, valCNH, nome, telefone, email, endereco1);

		pessoasFisicas.put(pessoa.getNome(), pessoa);

		MainController.save();
	}

	public List<String> getPessoasFisicas() {
		List<String> lista = new ArrayList<>();

		for (PessoaFisica pessoaFisica : pessoasFisicas.values())
			lista.add(String.format("%s\t%ld\t", pessoaFisica.getNome(), pessoaFisica.getCpf()));

		return lista;	}

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
