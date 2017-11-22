package usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import cadastro.CadClientesCelular;
import dados.Celular;
import dados.ClienteCelular;
import erros.CelularException;
import utilitarios.Console;
import utilitarios.LtpUtil;

public class Usuario {
	public static void main(String[] args) throws Exception {
		menu();
		System.out.println("\n \t \t PROGRAMA SERA ENCERRADO!");
		System.exit(0);
	}
	
	private static void menu() throws Exception {
		int opcao = 0;
		do {
			System.out.println("\n \t \t \t \t --- Sistema de Controle de Cadastro de Clientes de Telefones Celulares ---");
			
			System.out.println("\n \t 1 - Cadastrar clientes.");
			System.out.println("\n \t 2 - Excluir cliente.");
			System.out.println("\n \t 3 - Consulta por CPF. ");
			System.out.println("\n \t 4 - Consulta por numero. ");
			System.out.println("\n \t 5 - Consulta por nome.");
			System.out.println("\n \t 6 - Incluir celular.");
			System.out.println("\n \t 7 - Excluir celular.");
			System.out.println("\n \t 0 - Sair.");
			opcao = Console.readInt("\n \t Digite a Opção desejada: ");
			switch (opcao) {
				case 1:
					incluirCliente();
					break;
				case 2:
					excluirClienteByCPF();
					break;
				case 3:
					getClienteByCPF();
					break;
				case 4:
					getClienteByNumeroCelular();
					break;
				case 5:
					getClientesOrderByNome();
					break;
				case 6:
					incluirCelularParaCliente();
					break;
				case 7:
					excluirCelularParaCliente();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção escolhida é inválida!");
					break;
			}
		} while (opcao!=0);
	}
	
	private static void incluirCliente() throws CelularException {
		System.out.println("\n \n \t  --> Cadastro de Cliente <--\n");
		
		String cpf = Console.readLine("Digite o cpf do novo cliente (somente numeros): ");
		cpf = validarCPF(cpf);
		
		String nome = Console.readLine("Digite o nome do novo cliente: ");
		if(nome.equals("") || nome.split(" ").length < 2){
			do{
				nome = Console.readLine("Nome inválido. Digite o nome do novo cliente: ");
			}while(nome.split(" ").length < 2);
		}
		
		CadClientesCelular.incluirCliente(new ClienteCelular(cpf, nome, new GregorianCalendar(), null));
		
		System.out.println("\n Cliente cadastrado com sucesso!");
	}
	
	private static void excluirClienteByCPF() throws CelularException {
		System.out.println("\n Excluir Cliente via CPF do cliente \n");
		
		if(CadClientesCelular.listaCelulares.isEmpty()){
			System.out.println("Não é possível excluir clientes pois Não foi encontrado Clientes cadastrados!");
			return;
		}
		
		String cpf = Console.readLine("Digite o cpf do cliente a ser excluido (somente numeros): ");
		cpf = validarCPF(cpf);
		
		ClienteCelular cliente = CadClientesCelular.getClienteByCpf(cpf);
		if(cliente == null){
			do{
				cpf = Console.readLine("CPF Já cadastrado para outro cliente! Digite o cpf do novo cliente (digite 0 para voltar ao menu): ");
				if(cpf.equals("0")){
					return;
				}
				cpf = validarCPF(cpf);
				cliente = CadClientesCelular.getClienteByCpf(cpf);
			}while(cliente == null);
		}
		
		System.out.println(cliente.toString());
		
		String confirma = Console.readLine("Deseja excluir este cliente? (S/N): ").toUpperCase();
		if(confirma.equals("") || !(confirma.equals("S") || confirma.equals("N"))){
			do{
				confirma = Console.readLine("Opção inválida! Deseja excluir este cliente? (S/N): ").toUpperCase();
			}while(confirma.equals("") || !(confirma.equals("S") || confirma.equals("N")));
		}
		
		if(confirma.equals("S")){
			CadClientesCelular.exclurClienteByCpf(cliente);
			System.out.println("\n Cliente excluído com sucesso!");
		}
	}
	
	private static void getClienteByCPF() throws CelularException {
		System.out.println("\n Consultar Cliente via CPF \n");
		
		if(CadClientesCelular.listaCelulares.isEmpty()){
			System.out.println("Não é possível consultar clientes pois Não foi encontrado Clientes cadastrados!");
			return;
		}
		
		String cpf = Console.readLine("Digite o cpf do cliente a ser consultado (somente numeros): ");
		cpf = validarCPF(cpf);
		
		ClienteCelular cliente = CadClientesCelular.getClienteByCpf(cpf);
		if(cliente == null){
			do{
				cpf = Console.readLine("CPF Já cadastrado para outro cliente! Digite o cpf do novo cliente (digite 0 para voltar ao menu): ");
				if(cpf.equals("0")){
					return;
				}
				cpf = validarCPF(cpf);
				cliente = CadClientesCelular.getClienteByCpf(cpf);
			}while(cliente == null);
		}
		
		System.out.println(cliente.toString());
	}
	
	private static void getClienteByNumeroCelular() throws CelularException {
		System.out.println("\n Consultar Cliente via nº do celular \n");
		
		if(CadClientesCelular.listaCelulares.isEmpty()){
			System.out.println("Não é possível consultar clientes pois Não foi encontrado Clientes cadastrados!");
			return;
		}
		
		String numero = Console.readLine("Digite o numero do celular do cliente a ser consultado (somente numeros): ");
		
		ClienteCelular cliente = CadClientesCelular.getClienteByCelular(numero);
		if(cliente == null){
			do{
				numero = Console.readLine("Nao encontrado! Digite o numero do celular do novo cliente (digite 0 para voltar ao menu): ");
				if(numero.equals("0")){
					return;
				}
				cliente = CadClientesCelular.getClienteByCelular(numero);
			}while(cliente == null);
		}
		
		System.out.println(cliente.toString());
	}
	
	private static void getClientesOrderByNome() throws CelularException {
		System.out.println("\n Consultar Cliente em ordem alfabética de nome \n");
		
		if(CadClientesCelular.listaCelulares.isEmpty()){
			System.out.println("Não é possível consultar clientes em ordem alfabetica pois não foi encontrado Clientes cadastrados!");
			return;
		}
		
		String nome = Console.readLine("Digite o nome do cliente ou pressione [enter] para imprimir todos em ordem alfabetica: ");
		
		ArrayList<ClienteCelular> listaClientes = (ArrayList<ClienteCelular>) CadClientesCelular.getClienteByNome(nome);
		
		for(ClienteCelular cliente : listaClientes) {
			System.out.println(cliente.toString());
		}
	}
	
	private static String validarCPF(String cpf) {
		if(!LtpUtil.validarCPF(cpf)){
			do{
				cpf = Console.readLine("CPF inválido. Digite o cpf do cliente (somente numeros): ");
			}while(!LtpUtil.validarCPF(cpf));
		}
		return cpf;
	}
	
	private static void incluirCelularParaCliente() throws CelularException {
		System.out.println("\n Cadastrar um Celular para um Cliente \n");
		
		if(CadClientesCelular.listaCelulares.isEmpty()){
			System.out.println("Não é possível cadastrar um celular para um cliente pois não foi encontrado Clientes cadastrados!");
			return;
		}
		
		String cpf = Console.readLine("Digite o cpf do cliente a ser incluido um celular (somente numeros): ");
		cpf = validarCPF(cpf);
		
		ClienteCelular cliente = CadClientesCelular.getClienteByCpf(cpf);
		
		String numeroCelular = Console.readLine("Digite o numero do celular a ser incluido: ");
		
		cliente.getListaCelulares().add(new Celular(numeroCelular, new GregorianCalendar()));
	}
	
	private static void excluirCelularParaCliente() throws CelularException {
		System.out.println("\n Excluir um Celular de um Cliente \n");
		
		if(CadClientesCelular.listaCelulares.isEmpty()){
			System.out.println("Não é possível excluir um celular para um cliente pois não foi encontrado Clientes cadastrados!");
			return;
		}
		
		String cpf = Console.readLine("Digite o cpf do cliente a ser excluido o celular (somente numeros): ");
		cpf = validarCPF(cpf);
		
		ClienteCelular cliente = CadClientesCelular.getClienteByCpf(cpf);
		
		String numeroCelular = Console.readLine("Digite o numero do celular a ser excluido: ");
		
		cliente.getListaCelulares().remove(ClienteCelular.getCelularByNumero(numeroCelular));
	}
}