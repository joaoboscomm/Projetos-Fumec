package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import dados.Conta;
import erros.CaixaException;

public class CadastroContas {

	public static HashMap<Integer, Conta> contas = new HashMap<Integer, Conta>();
	
	public static Conta getContaByCodigo(int codigo) throws CaixaException{
		if(contas.containsKey(codigo))
			return contas.get(codigo);
		else
			throw new CaixaException("Não existe nenhuma conta com esse codigo");
	}
	
	public static void incluirConta(Conta conta){
		contas.put(conta.getCodigo(), conta);
	}
	
	public static void excluirConta(Conta conta){
		contas.remove(conta.getCodigo());
	}
	
	public static ArrayList<Conta> getContasPeloNome(String nome) throws CaixaException{
		ArrayList<Conta> retorno = new ArrayList<Conta>();
		
		for(Conta c : contas.values()){
			if(c.getNome().equals(nome))
				retorno.add(c);
		}
		
		if(retorno.size() == 0)
			throw new CaixaException("Não existe nenhuma conta para esse nome");
		
		Collections.sort(retorno);
		return retorno;
	}
	
}
