package dados;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import erros.CaixaException;

public class Conta implements Comparable<Conta> {

	private static int auto_increment;

	private int codigo;
	private String nome;
	private double saldo;
	private GregorianCalendar dataRegistro;
	private ArrayList<Lancamento> listaDeLancamentos;
	
	public Conta(String nome, double saldo, GregorianCalendar dataRegistro, ArrayList<Lancamento> listaDeLancamentos) {
		this.codigo = ++auto_increment;
		this.nome = nome;
		this.saldo = saldo;
		this.dataRegistro = dataRegistro;
		this.listaDeLancamentos = listaDeLancamentos;
	}
	
	public Lancamento getLancamentoByNumero(int numero) throws CaixaException{
		for(Lancamento lanc : listaDeLancamentos){
			if(lanc.getNumero() == numero){
				return lanc;
			}
		}
		
		throw new CaixaException("Esta conta não possui um lancamento com esse numero");
	}
	
	public void excluirLancamento(Lancamento lancamento){
		Lancamento lanc = listaDeLancamentos.get(listaDeLancamentos.indexOf(lancamento));
		listaDeLancamentos.remove(lanc);
		saldo -= lanc.getTipo() == 1 ? lanc.getValor() : lanc.getValor() * (-1);
	}
	
	public void incluirLancamento(Lancamento lancamento){
		listaDeLancamentos.add(lancamento);
		saldo += lancamento.getTipo() == 1 ? lancamento.getValor() : lancamento.getValor() * (-1);
	}

	public int getCodigo() {
		return codigo;
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

	public GregorianCalendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(GregorianCalendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public ArrayList<Lancamento> getListaDeLancamentos() {
		return listaDeLancamentos;
	}

	public void setListaDeLancamentos(ArrayList<Lancamento> listaDeLancamentos) {
		this.listaDeLancamentos = listaDeLancamentos;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\n\nCodigo: "+codigo);
		sb.append("\nNome: "+nome);
		sb.append("\nSaldo: "+saldo);
		sb.append("\nData Registro: "+new SimpleDateFormat("dd/MM/yyyy HH:mm EEEE").format(dataRegistro.getTime()));
		sb.append("\n\n");
		listaDeLancamentos.forEach(lancamento -> sb.append(lancamento));
		
		return new String(sb);
	}

	@Override
	public int compareTo(Conta o) {
		return this.nome.compareTo(o.getNome());
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Conta))
			return false;
		
		return ((Conta) o).getCodigo() == this.codigo;
	}
	
}
