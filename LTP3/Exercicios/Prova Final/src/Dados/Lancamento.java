package Dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;


import utilitarios.LtpUtil;


public class Lancamento {
	
	public static final int ENTRADA = 1;
	public static final int SAIDA = 2;
	
	private int numero;
	private int tipo;
	private GregorianCalendar dataLancamento ;   
	private String descricao;
	private double valor; 
	
	
	

	
	public Lancamento(int numero, int tipo , GregorianCalendar dataLancamento, String descricao , 
			double valor) {
		
		this.numero = numero;
		this.tipo = tipo;
		this.dataLancamento = dataLancamento;
		this.descricao = descricao;
		this.valor = valor;
		
		
	
	}

	
	public int getNumero() {
		
		return numero;
	}

	public void setNumero(int numero) {
		
		this.numero = numero;
	}
	
	
	public int getTipo() {
		
		return tipo;
	}

	public void setTipo(int tipo) {
		
		this.tipo = tipo;
	}
	
	public GregorianCalendar getDataLancamento() {
		
		return dataLancamento;
	}

	public void setDataLancamento(GregorianCalendar dataLancamento) {
		
		this.dataLancamento = dataLancamento;
	}

		public String getDescricao() {
		
			return descricao;
	}

	public void setDescricao(String descricao) {
		
		this.descricao = descricao ;
	}

	
	public double getValor() {
		
		return valor;
	}

	public void setValor(double valor) {
		
		this.valor = valor ;
	}

	
	@Override
	
	public String toString() {
		
		return "\n \t Numero: " + numero +
				"\n \t Tipo: " + tipo + 
				"\n \t Data de Lancamento: " + LtpUtil.formatarData(dataLancamento, "dd/MM/yyyy") +
				"\n \t Descricao: " + descricao + 
				"\n \t Valor: " + valor;
	}
	
	
}
