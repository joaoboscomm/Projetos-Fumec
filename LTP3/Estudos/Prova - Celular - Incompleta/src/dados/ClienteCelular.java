package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import erros.CelularException;
import utilitarios.LtpUtil;

public class ClienteCelular implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String nome;
	
	private GregorianCalendar data;
	
	private static ArrayList<Celular> listaCelulares;

	public ClienteCelular(String cpf, String nome, GregorianCalendar data, ArrayList<Celular> listaCelulares) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		ClienteCelular.listaCelulares = listaCelulares;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public ArrayList<Celular> getListaCelulares() {
		return listaCelulares;
	}

	public void setListaCelulares(ArrayList<Celular> listaCelulares) {
		ClienteCelular.listaCelulares = listaCelulares;
	}
	
	public static Celular getCelularByNumero(String numeroCelular) throws CelularException {
		Celular celular = new Celular("", new GregorianCalendar());
		
		for(Celular cel : listaCelulares){
			if(cel.getNumero().equals(numeroCelular)){
				celular = cel;
			}
		}
		
		if(celular.getNumero() == null){
			throw new CelularException("\n \tNUMERO INVALIDO! Não existe celular com esse numero!");
		}
		
		return celular;
	}
	
	public void addCelular(Celular celular){
		listaCelulares.add(celular);
	}
	
	public void deleteCelular(Celular celular){
		listaCelulares.remove(celular);
	}

	@Override
	public String toString() {
		return "\n \tNome: " + nome + "\n \tCPF:" + cpf + "\n \t Data:" + LtpUtil.formatarData(data, "dd/MM/yyyy") + "\n \tCelulares:" + listaCelulares;
	}
}