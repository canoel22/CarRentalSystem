package controller;

import java.io.Serializable;

public class ClienteController implements Serializable {

	private static final long serialVersionUID = -2986449868123120251L;

//	public Cliente addCliente(String cpfString, String nome, String email, String telefoneString) throws NumberFormatException {
//		try {
//			long cpf = Long.parseLong(cpfString);
//			try {
//				long telefone = Long.parseLong(telefoneString);
//				Cliente newCliente = new Cliente(cpf, nome, email, telefone);
//				Cliente.put(cpf, newCliente);
//				return newCliente;
//				
//			}catch(NumberFormatException e) {
//				throw new NumberFormatException("O telefone informado nao e valido, digite somente numeros");
//			}
//		}catch(NumberFormatException e) {
//			throw new NumberFormatException("O cpf informado nao e valido, digite somente numeros");
//		}
//	}

}
