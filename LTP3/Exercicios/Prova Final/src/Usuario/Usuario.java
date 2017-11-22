package Usuario;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Cadastro.Cadastro;
import Dados.Conta;
import Dados.Lancamento;
import utilitarios.Console;
import Erros.CaixaException;


public class Usuario {

	
	public static void main(String[] args) throws Exception {
		menu();
		System.out.println("-------------------------------" + 
		"\n \t O Sistema sera Finalizado..." + 
		"-------------------------------");
		System.exit(0);
	}
	
	
	private static void menu() throws Exception{
    	Scanner leia = new Scanner(System.in);    
    	byte opcao = -1;
    	do {
			do {
    			System.out.println("\n \t \t --- Sistema de Controle de Caixa --- ");
    			System.out.println("\n \t Menu: ");
    			System.out.println("\n \t 1 - Cadastrar Conta");
    			System.out.println("\n \t 2 - Excluir Conta ");
    			System.out.println("\n \t 3 - Consulta Conta Pelo Codigo");
    			System.out.println("\n \t 4 - Consulta conta Pelo Nome ");
    			System.out.println("\n \t 5 - Incluir Lancamento ");
    			System.out.println("\n \t 6 - Excluir Lancamento ");
    			
    			
    			System.out.println("\n \t 0 - Finalizar ");
    			System.out.print("\n \t Digite a opção desejada: ");
    			try {
    				opcao = leia.nextByte();
        			if (opcao < 0 || opcao > 6) {
        				System.out.println("\n \t Opção inserida nao é valida! Entre com uma opcao: \n");
        			}
    			}catch (InputMismatchException e) {
    				System.out.println("Opção inserida nao é valida! Entre com um numero valido do menu: \n");
    				leia.nextLine();
    			}
    		}while (opcao < 0 || opcao > 6);
			
			switch (opcao) {
				case 0:					
					System.out.println("\n \t --- Programa foi Finalizado --- \n");
					break;
				case 1: 
					incluirConta();
					break;
				case 2:
					excluirConta();
					break;
				case 3: 
					consultarContaCodigo();
					break;
				case 4: 
					consultarContaNome();
					break;
				case 5:
					incluirLancamento();
					break;
				case 6:
					excluirLancamento();
					break;
				default:
    				System.out.println("Opção inserida nao é valida! Entre com um numero valido do menu:\n");
					break;
			}
    	} while ( opcao != 0 );
    	leia.close();
	}
	
	private static void incluirConta() throws CaixaException {
		System.out.println("\n \t -- Cadastrar Conta: -- \n");
		
		
		int codigo = codigo ++;
		
		
		String nome;
		while (true) {
			nome = Console.readLine("\n \t Nome: ").trim();
			if (nome.isEmpty()) {
				System.out.println("\n \t Nome nao inserido!.");
			} else break;
		}
		double saldo = Console.readDouble("Saldo: ");
		
		int tipo;
		do{	
			
			tipo = Console.readInt("\n \t Digite 1 (Entrada) \n \t ou \n \t Digite 2 (Saida ): ");
			if(tipo!= 1 && tipo!=2){
				System.out.println("\n \tTipo invalido!\n");
			
			}
	
	private static void consultarContaNome() throws CaixaException {
		
	}
		System.out.println("\n \t -- Listar Conta pelo Nome -- \n");
		String nome = Console.readLine("\n \t Entre com o  nome ou parte do nome desejado: ");
		ArrayList<Conta> resp = null;
		
}
