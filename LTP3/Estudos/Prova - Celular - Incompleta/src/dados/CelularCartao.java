package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class CelularCartao extends Celular implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double creditos;

	public CelularCartao(String numero, GregorianCalendar data) {
		super(numero, data);
	}

	public CelularCartao(String numero, GregorianCalendar data, Double creditos) {
		super(numero, data);
		this.creditos = creditos;
	}

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}
	
	public int getTipo(){
		return CELULARCARTAO;
	}

	@Override
	public String toString() {
		return "\n \tNumero do Celular: " + numero + "\n \tCreditos:" + creditos + "\n \tData: " + LtpUtil.formatarData(data, "dd/MM/yyyy");
	}
	
}