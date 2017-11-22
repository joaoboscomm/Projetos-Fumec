package dados;

import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class CelularCartao extends Celular {
	private double creditos;

	public CelularCartao(String numero, GregorianCalendar data, double creditos) {
		super(numero, data);
		this.creditos = creditos;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	
	public String toString() {
		return
			super.toString() +
			"\n \t Creditos: " + LtpUtil.formatarValor(creditos, "R$#,##0.00");
	}
	
	public int getTipo() {
		return CELULARCARTAO;
	}
}
