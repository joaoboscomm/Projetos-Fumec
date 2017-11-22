package dados;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Lancamento {

	public static final int ENTRADA = 1;
	public static final int SAIDA = 2;
	
	private static int auto_increment;
	
	private int numero;
	private int tipo;
	private GregorianCalendar dataLancamento;
	private String descricao;
	private double valor;
	
	public Lancamento(int tipo, GregorianCalendar dataLancamento, String descricao, double valor) {
		numero = ++auto_increment;
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
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\n\nNumero: "+numero);
		sb.append("\nTipo: "+tipo);
		sb.append("\nData Lançamento: "+new SimpleDateFormat("dd/MM/yyyy HH:mm EEEE").format(dataLancamento.getTime()));
		sb.append("\nDescricao: "+descricao);
		sb.append("\nValor: "+valor);
		
		return new String(sb);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Lancamento))
			return false;
		
		return ((Lancamento) o).getNumero() == this.numero;
	}

}
