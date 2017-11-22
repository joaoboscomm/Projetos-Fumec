package Cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Dados.Celular;
import Dados.ClienteCelular;
import Erros.CelularException;

public class CadClientesCelular {
	ArrayList<ClienteCelular> listaClientesCelular = new ArrayList<ClienteCelular>();
	
	public void incluirCliente(ClienteCelular cliente) throws CelularException {
		for (ClienteCelular obj : listaClientesCelular) {
			if (obj.getCpf().equals(cliente.getCpf()))
				throw new CelularException("\n \t CPF INVALIDO! Já existe um cliente cadastrado esse CPF!");
		}
		listaClientesCelular.add(cliente);
	}
	
	public void excluirClienteCpf(String cpf) throws CelularException {
		for (ClienteCelular obj : listaClientesCelular) {
			if (obj.getCpf().equals(cpf)) {
				listaClientesCelular.remove(obj);
				return;
			}
		}
		throw new CelularException("\n \t CPF INVALIDO! Nao existe cliente cadastrado para o CPF!");
	}
	
	public ClienteCelular consultarClienteCPF(String cpf) throws CelularException {
		for (ClienteCelular obj : listaClientesCelular) {
			if (obj.getCpf().equals(cpf))
				return obj;
		}
		throw new CelularException("\n \t CPF INVALIDO! Nao existe cliente cadastrado para o CPF!");
	}
	
	public ClienteCelular consultarClienteNumero(String numero) throws CelularException {
		for (ClienteCelular obj : listaClientesCelular) {
			for (Celular objCel : obj.getListaCelulares()) {
				if (objCel.getNumero().equals(numero)) {
					return obj;
				}
			}
		}
		throw new CelularException("\n \t CELULAR INVALIDO! Nao existe cliente cadastrado para o numero!");
	}
	
	public ArrayList<ClienteCelular> consultarClienteNome(String nome) throws CelularException {
		ArrayList<ClienteCelular> lista = new ArrayList<ClienteCelular>();
		
		for (ClienteCelular obj : listaClientesCelular) {
			if (obj.getNome().toUpperCase().contains(nome.toUpperCase()))
				lista.add(obj);
		}
		
		if (lista.isEmpty())
			throw new CelularException("\n \t CLIENTE INVALIDO! Nao existe celular cadastrado para o cliente!");
		else {
			Collections.sort(lista, new Comparator<ClienteCelular>() {

				@Override
				public int compare(ClienteCelular o1, ClienteCelular o2) {
					return
						o1.getNome().compareToIgnoreCase(o2.getNome());
				}
				
			});
			
			return lista;
		}
	}
	
	public void incluirCelular(ClienteCelular cliente, Celular celular) throws CelularException {
		for (ClienteCelular obj : listaClientesCelular) {
			for (Celular objCel : obj.getListaCelulares()) {
				if (objCel.getNumero().equalsIgnoreCase(celular.getNumero()))
					throw new CelularException("\n \t NUMERO INVALIDO! Já existe um cliente cadastrado esse numero!");
			}
		}
		cliente.incluirCelular(celular);
	}
	
	public void excluirCelular(ClienteCelular cliente, String numero) throws CelularException {
		cliente.excluirCelular(numero);
	}
}
