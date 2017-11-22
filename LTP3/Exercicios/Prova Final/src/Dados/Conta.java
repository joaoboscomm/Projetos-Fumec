package Dados;

import java.util.GregorianCalendar;

import java.util.ArrayList;

public class Conta {
	
	
		private int codigo = 0 ; // É UM NUMERO SEQUENCIAL
		private String nome;
		private double saldo;
		private GregorianCalendar dataRegistro ;		
		private  ArrayList<Lancamento> listaLancamentos = new ArrayList<>();
		
		
		
		public Conta (int codigo, String nome, double saldo, GregorianCalendar dataRegistro, 
				ArrayList<Lancamento> listaLancamentos ) {
			
			this.codigo = codigo;
			this.nome = nome;
			this.saldo = saldo;
			this.dataRegistro = dataRegistro;
			this.listaLancamentos = listaLancamentos;
		}
		
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int numConta) {
			
			codigo ++;
			
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		
		public ArrayList<Lancamento> getListaLancamentos() {
			return listaLancamentos;
		}
		
		public void setListaLancamentos(ArrayList<Lancamento> listaLancamentos) {
			
			this.listaLancamentos = listaLancamentos;
		}
		
		
	
		
		
		@Override
		public String toString() {
			
			String lancamentos = "Sem lancamentos";
			
			if (listaLancamentos != null) {
				lancamentos = listaLancamentos.toString();
			}
			
			return  "\n --------------- \n" + 
					"\n \t Codigo: " + codigo + 
					"\n \t Nome: " + nome + 
					"\n \t Saldo: " + saldo + 
					"\n \t Data de Registro: " + dataRegistro + 
					"\n \t Lista de Lancamentos: " + lancamentos + 
					"\n --------------- \n";
			
		}

		

}
