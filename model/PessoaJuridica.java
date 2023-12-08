package model;

public class PessoaJuridica extends Cliente {
	
		private final long cnpj;
		private String nomePessoaContato;
		
		public PessoaJuridica (long cnpj) {
			this.cnpj = cnpj;
		}
		
		public long getCnpj() {
			return cnpj;
		}

		public String getNomePessoaContato() {
			return nomePessoaContato;
		}

		public void setNomePessoaContato(String nomePessoaContato) {
			this.nomePessoaContato = nomePessoaContato;
		}

		
	}
