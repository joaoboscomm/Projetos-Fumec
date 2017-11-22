package Cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import Cadastro.ContaPorNome;
import Dados.Conta;
import Erros.CaixaException;



public class Cadastro {
	

public static HashMap<Integer, Conta> listaContas = new HashMap<Integer, Conta>();


public static Conta consultarContaCodigo(int numCodigo) throws CaixaException {
	if (listaContas.containsKey(numCodigo)) { 
		
		for (Conta objCodigo : listaContas.values()) {
			
			if (objCodigo.getCodigo() == numCodigo){
				
				return objCodigo;
			}
		}			
	}
	
	throw new CaixaException("Nao existe Conta para o codigo informado!");
}
	
	public static void incluirConta(Conta objConta) {
		
		if (objConta.getCodigo() >= 0 && objConta.getListaLancamentos() == null) {
			listaContas.put(objConta.getCodigo(), objConta);	
			
					}
				
	}
	
	public static void excluirConta(Conta objConta) throws CaixaException {
		if (objConta.getSaldo() >= 0 && objConta.getListaLancamentos() == null) {
			listaContas.remove(objConta);
		} 
		
		else {
			throw new CaixaException("Conta nao pode ser excluida!");
		}
	}
	
	
	public static Conta consultarContaNome(int nome) throws CaixaException {
		if (listaContas.containsKey(nome)) { 
			for (Conta objNome : listaContas.values()) {
				if (objNome.getCodigo() == nome){
					return objNome;
				}
			}			
		}
		throw new CaixaException("Nao existe Conta para o nome informado!");
	}
	
	public static ArrayList<Conta> listarContaNome(String nome) throws CaixaException {
		ArrayList<Conta> retorno = new ArrayList<Conta>();
		for (Conta objConta : listaContas.values()) {
			if (objConta.getNome().contains(nome)) {
				retorno.add(objConta);
			}
		} 
		
		
		Collections.sort(retorno, new ContaPorNome());
		if (retorno.size() != 0) {
			return retorno;
		} else throw new CaixaException("Não existe conta para o nome.");		
	}
}

class ContaPorNome implements Comparator<Conta> {
	public int compare(Conta o1, Conta o2) {
		return o1.getNome().compareTo(o2.getNome());
	}	
	
	
}
