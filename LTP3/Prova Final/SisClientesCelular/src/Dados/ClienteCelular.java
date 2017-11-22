package Dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import utilitarios.LtpUtil;
import Erros.CelularException;

public class ClienteCelular {
	private String cpf, nome;
	private GregorianCalendar data;
	private ArrayList<Celular> listaCelulares = new ArrayList<Celular>();
	
	public ClienteCelular(String cpf, String nome, GregorianCalendar data, ArrayList<Celular> listaCelulares) {
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.listaCelulares = listaCelulares;
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
		this.listaCelulares = listaCelulares;
	}
	
	public void incluirCelular(Celular celular) {
		listaCelulares.add(celular);
	}
	
	public void excluirCelular(String numero) throws CelularException {
		for (Celular obj : listaCelulares) {
			if (obj.getNumero().equalsIgnoreCase(numero)) {
				listaCelulares.remove(obj);
				return;
			}
		}
		throw new CelularException("\n \t Nao existe esse numero nos registros!");
	}
	
	public String toString() {
		return
			
			"\n \t Nome: " + nome +
			"\n \t CPF: " + cpf + 
			"\n \t Data de Registro: " + LtpUtil.formatarData(data, "dd/MM/yyyy");
		}
}
