package usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import cadastro.CadastroContas;
import dados.Conta;
import dados.Lancamento;
import erros.CaixaException;
import utilitarios.Console;

public class Usuario {

	public static void main(String[] args) {
		int opcao = 0;
		do{
			opcao = menu();
			
			switch(opcao){
			case 1:
				cadastrarConta();
				break;
			case 2:
				excluirConta();
				break;
			case 3:
				imprimeContaPeloCodigo();
				break;
			case 4:
				imprimeContasPeloNome();
				break;
			case 5:
				incluirLancamentoNaConta();
				break;
			case 6:
				excluirLancamentoDaConta();
				break;
			default: 
				break;
			}
			
		}while(opcao != 0);
	}

	private static void cadastrarConta() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		Conta c = new Conta(Console.readLine("Digite o Nome"), Console.readDouble("Digite o Saldo"), gc, new ArrayList<Lancamento>());
		CadastroContas.incluirConta(c);
		System.out.println("Cadastrado com sucesso!");
	}

	private static void excluirConta() {
		try {
			Conta c = CadastroContas.getContaByCodigo(Console.readInt("Digite o Codigo da Conta que deseja excluir"));
			if(Console.readInt("Tem certeza que deseja excluir? 1 para SIM, 2 para NAO") == 2)
				return;
			
			CadastroContas.excluirConta(c);
			System.out.println("Removido com sucesso");
		} catch (CaixaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void imprimeContaPeloCodigo() {
		try {
			System.out.println(CadastroContas.getContaByCodigo(Console.readInt("Digite o codigo da conta")));
		} catch (CaixaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void imprimeContasPeloNome() {
		try {
			ArrayList<Conta> list = CadastroContas.getContasPeloNome(Console.readLine("Digite o nome da conta"));
			for(Conta c : list)
				System.out.println(c);
		} catch (CaixaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void incluirLancamentoNaConta() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		try {
			Conta c = CadastroContas.getContaByCodigo(Console.readInt("Digite o codigo da conta"));
			Lancamento lancamento = new Lancamento(Console.readInt("Digite o tipo de lancamento: 1 para ENTRADA e 2 para SAIDA"), 
					gc, Console.readLine("Digite a descricao"), Console.readDouble("Informe o valor"));
			
			c.incluirLancamento(lancamento);
			
			System.out.println("Incluido com sucesso!");
			
		} catch (CaixaException e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	private static void excluirLancamentoDaConta() {
		try {
			Conta c = CadastroContas.getContaByCodigo(Console.readInt("Digite o codigo da conta"));
			Lancamento lancamento = c.getLancamentoByNumero(Console.readInt("Digite o numero do lancamento"));
			if(Console.readInt("Tem certeza que deseja excluir? 1 para SIM, 2 para NAO") == 2)
				return;
			
			c.excluirLancamento(lancamento);
			System.out.println("Removido com sucesso");
			
		} catch (CaixaException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static int menu() {

		System.out.println("\n\n\n1 - Cadastrar Conta");
		System.out.println("2 - Excluir Conta");
		System.out.println("3 - Consultar conta pelo codigo");
		System.out.println("4 - Consultar contas pelo nome");
		System.out.println("5 - Incluir lançamento pra conta");
		System.out.println("6 - Excluir lançamento da conta");
		System.out.println("0 - Sair");
		
		return Console.readInt("");
	}
}
