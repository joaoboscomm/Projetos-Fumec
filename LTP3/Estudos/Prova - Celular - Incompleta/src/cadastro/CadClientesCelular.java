package cadastro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import dados.ClienteCelular;
import erros.CelularException;

public class CadClientesCelular implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static HashMap<String, ClienteCelular> listaCelulares = new HashMap<String, ClienteCelular>();
	
	public static ClienteCelular getClienteByCpf(String cpf) throws CelularException {
		if (listaCelulares.containsKey(cpf)) {
			return listaCelulares.get(cpf);
		} else if(!listaCelulares.isEmpty()) {
			throw new CelularException("\n \t CPF INVALIDO! Não existe Cliente com esse CPF!");
		}else{
			return null;
		}
	}
	
	public static void incluirCliente(ClienteCelular clienteCelular){
		listaCelulares.put(clienteCelular.getCpf(), clienteCelular);
	}
	
	public static void exclurClienteByCpf(ClienteCelular clienteCelular) throws CelularException {
		if(!listaCelulares.isEmpty()) {
			listaCelulares.remove(clienteCelular.getCpf());
		}else {
			throw new CelularException("\n \tCPF INVALIDO! Não existe Cliente com esse CPF!");
		}
	}
	
	public static ClienteCelular getClienteByCelular(String numeroCelular) throws CelularException {
		try{
			for (ClienteCelular cliente : listaCelulares.values()) {
				if(ClienteCelular.getCelularByNumero(numeroCelular).getNumero() != null){
					return cliente;
				}
			}
		}catch(CelularException e){
			throw new CelularException("\n \tCPF INVALIDO! Não existe Cliente com esse CPF!");
		}
		
		return null;
	}
	
	public static ArrayList<ClienteCelular> getClienteByNome(String nome) throws CelularException {
		ArrayList<ClienteCelular> lista = new ArrayList<>();
		
		for(ClienteCelular celular : listaCelulares.values()) {
			if(celular.getNome().contains(nome)){
				lista.add(celular);
			}
		}
		
		if (lista.isEmpty()) {
			throw new CelularException("\n \tNOME INVALIDO! Não existe Cliente com esse nome!");
		} else {
			Collections.sort(lista, new Comparator<ClienteCelular>() {

				@Override
				public int compare(ClienteCelular obj1, ClienteCelular obj2) {
					return obj1.getNome().compareTo(obj2.getNome());
				}
			});
			return lista;
		}
	}
}