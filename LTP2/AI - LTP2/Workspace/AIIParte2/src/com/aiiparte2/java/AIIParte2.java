package com.aiiparte2.java;

import java.util.*;

import java.io.*;

public class AIIParte2 {

	public static class tipoPessoa{

		String CPF;
		String nome;
		int telefone;
		String rua;
		int numero;
		String bairro;
		String cidade;
		String siglaEstado;
		long CEP;
	}

	public static class tipoVendas {
		int ID; //pode ser autoincremento
		String CPF;
		String nomeCliente;
		int IDProduto; //Esse tipo poderá ser IDProduto ou IDServico
		String nomeProduto;
		int quantidade;
		double valor;
	}

	public static class tipoProduto{

		int codigoProduto;
		String nomeProduto;
		double valorProduto;


	}


	public static void cadastroCliente(){

		tipoPessoa cliente = new tipoPessoa();
		Scanner leia = new Scanner (System.in);
		boolean valido, verificaCPF;
		int	a;
		String validaTel;



		verificaCPF = false;

		do{
			do{
				System.out.println("Informe o CPF do Cliente: ");
				cliente.CPF = leia.next();
				valido = true;

				for(a=0; a<cliente.CPF.length() ; a++){

					if(cliente.CPF.length() != 11){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

					if(cliente.CPF.charAt(a) < '0' || cliente.CPF.charAt(a) > '9'){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

				}
			}while(!valido);

			verificaCPF = verificarCliente(cliente.CPF);


		}while(verificaCPF);

		do{

			System.out.println("Informe o nome do Cliente: ");
			cliente.nome = leia.next();

			valido = true;
			for(a=0; a<cliente.nome.length();a++){

				if(Character.toUpperCase(cliente.nome.charAt(a)) < 'A' || Character.toUpperCase(cliente.nome.charAt(a)) > 'Z'){
					System.out.println("Digite apenas letras.");
					valido = false;
					break;

				}
			}


		}while(!valido);


		do{	
			try{
				System.out.println("Informe o telefone do Cliente: ");
				cliente.telefone = leia.nextInt();
				valido = true;
				validaTel = String.valueOf(cliente.telefone);

				if(validaTel.length() != 8){

					System.out.println("Digite 8 números.");
					valido = false;

				}

			}catch(InputMismatchException e){

				System.out.println("Digite apenas números.");
				valido = false;

			}

		}while(!valido);



		System.out.println("Informe a rua do Cliente: ");
		cliente.rua = leia.next();

		do{
			try{
				System.out.println("Informe o numero da casa: ");
				cliente.numero = leia.nextInt();
				valido = true;

			}catch(InputMismatchException e){

				System.out.println("Digite apenas números.");
				valido = false;
			}
		}while(!valido);




		System.out.println("Informe o bairro do Cliente: ");
		cliente.bairro = leia.next();



		System.out.println("Informe a cidade do Cliente: ");
		cliente.cidade = leia.next();



		do{


			System.out.println("Informe a sigla do Estado do Cliente: ");
			cliente.siglaEstado = leia.next();

			valido = true;

			for(a=0; a<cliente.siglaEstado.length() ;a++){



				if (cliente.siglaEstado.length() >2){

					System.out.println("Sigla invalida! Entre com apenas 2 caracteres!");
					valido = false;
					break;
				}

				else if( Character.toUpperCase(cliente.siglaEstado.charAt(a)) < 'A' || Character.toUpperCase(cliente.siglaEstado.charAt(a)) > 'Z'){

					System.out.println("Digite apenas letras.");
					valido = false;
					break;

				}


			}

		}while(!valido);


		String StringCEP;



		do{


			System.out.println("Informe o CEP do Cliente: ");
			cliente.CEP = leia.nextLong();
			valido = true;

			StringCEP = "" + cliente.CEP ;


			for(a=0; a < StringCEP.length() ; a++){


				if(StringCEP.length() != 8){

					valido = false;
					System.out.println("Digite um valor válido. (8 números)");
					break;
				}

				if(StringCEP.charAt(a) < '0' || StringCEP.charAt(a) > '9'){

					valido = false;
					System.out.println("Digite um valor válido. (8 números)");
					break;

				}



			}
		}while(!valido);




		gravarArquivoCliente(cliente);

	}


	public static void cadastroProduto(){

		tipoProduto prod = new tipoProduto();
		Scanner leia = new Scanner (System.in);
		boolean valido, verificaProduto = true;


		do{

			do{

				valido= true;

				try{

					System.out.println("Informe o codigo do produto: ");
					prod.codigoProduto = leia.nextInt();

				}catch(InputMismatchException e){

					System.out.println("Digite apenas números.");
					valido = false;

				}

				leia.nextLine();

			}while(!valido);


			verificaProduto = verificarProduto(prod.codigoProduto);

		}while(verificaProduto);			

		do{

			System.out.println("Informe o nome do produto: ");
			prod.nomeProduto = leia.next();

			valido = true;

			for(int a=0; a<prod.nomeProduto.length();a++){

				if(Character.toUpperCase(prod.nomeProduto.charAt(a)) < 'A' || Character.toUpperCase(prod.nomeProduto.charAt(a)) > 'Z'){
					System.out.println("Digite apenas letras.");
					valido = false;
					break;

				}
			}

		}while(!valido);

		do{

			try{					

				System.out.println("Informe o valor do produto: ");
				prod.valorProduto = leia.nextDouble();

			}catch(InputMismatchException e){

				System.out.println("Digite apenas números.");
				valido = false;
			}

		}while(!valido);



		gravarArquivoProduto(prod);		

	}

	public static boolean verificarCliente(String CPF) {

		boolean encontrou = false;
		tipoPessoa cliente = new tipoPessoa();
		RandomAccessFile arquivo;


		try {

			arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
			while (true) {
				cliente.CPF = arquivo.readUTF();
				cliente.nome = arquivo.readUTF();
				cliente.telefone = arquivo.readInt();
				cliente.rua = arquivo.readUTF();
				cliente.numero = arquivo.readInt();
				cliente.bairro = arquivo.readUTF();
				cliente.cidade = arquivo.readUTF();
				cliente.siglaEstado = arquivo.readUTF();
				cliente.CEP = arquivo.readLong();

				if (CPF.equals(cliente.CPF)) {
					System.out.println("Cliente já cadastrado!\n");
					encontrou = true;
					break;
				}
				else{
					encontrou = false;
				}
			}

			arquivo.close();

		} catch (EOFException e) {

			encontrou = false;

		} catch (IOException e) {

			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		} catch (NullPointerException e){

			System.out.println("CPF não encontrado!");
			encontrou = false;

		}

		return encontrou;
	}

	public static void gravarArquivoCliente(tipoPessoa cliente) {
		char confirmacao;
		Scanner leia = new Scanner (System.in);
		RandomAccessFile arquivo;

		do {
			System.out.print("\nConfirma a gravação dos dados (S/N) ? ");
			confirmacao = leia.next().charAt(0);
			confirmacao = Character.toUpperCase(confirmacao);
			if (confirmacao == 'S') {
				try {
					arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
					arquivo.seek(arquivo.length()); // posiciona no final do
					// arquivo (EOF)
					arquivo.writeUTF(cliente.CPF);
					arquivo.writeUTF(cliente.nome);
					arquivo.writeInt(cliente.telefone);
					arquivo.writeUTF(cliente.rua);
					arquivo.writeInt(cliente.numero);
					arquivo.writeUTF(cliente.bairro);
					arquivo.writeUTF(cliente.cidade);
					arquivo.writeUTF(cliente.siglaEstado);
					arquivo.writeLong(cliente.CEP);
					arquivo.close();
					System.out.println("Dados gravados com sucesso !\n");
				} catch (IOException e) {
					System.out.println("Erro na gravaçao do registro - programa será finalizado");
					System.exit(0);
				}
			}
		} while (confirmacao != 'S' && confirmacao != 'N');

	}

	public static boolean verificarProduto(int CodigoProd) {

		boolean encontrou = false;
		tipoProduto prod = new tipoProduto();
		RandomAccessFile arquivo;


		try {
			arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
			while (true) {
				prod.codigoProduto = arquivo.readInt();
				prod.nomeProduto = arquivo.readUTF();
				prod.valorProduto = arquivo.readDouble();


				if (CodigoProd == prod.codigoProduto) {

					System.out.println("Produto já cadastrado! \n");
					encontrou = true;
					break;
				}
			}
			arquivo.close();
		} catch (EOFException e) {
			encontrou = false;
		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		return encontrou;
	}

	public static void gravarArquivoProduto(tipoProduto produto) {
		char confirmacao;
		Scanner leia = new Scanner (System.in);
		RandomAccessFile arquivo;

		do {
			System.out.print("\nConfirma a gravação dos dados (S/N) ? ");
			confirmacao = leia.next().charAt(0);
			confirmacao = Character.toUpperCase(confirmacao);
			if (confirmacao == 'S') {
				try {
					arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
					arquivo.seek(arquivo.length()); // posiciona no final do
					// arquivo (EOF)
					arquivo.writeInt(produto.codigoProduto);
					arquivo.writeUTF(produto.nomeProduto);
					arquivo.writeDouble(produto.valorProduto);

					arquivo.close();
					System.out.println("Dados gravados com sucesso !\n");
				} catch (IOException e) {
					System.out.println("Erro na gravaçao do registro - programa será finalizado");
					System.exit(0);
				}
			}
		} while (confirmacao != 'S' && confirmacao != 'N');

	}

	public static void cadastrarVenda(){

		tipoVendas venda = new tipoVendas();
		Scanner leia = new Scanner (System.in);
		boolean  verificaCPF = true, verificaProduto, valido;

		int idVenda = 0;
		double valorProduto = 0, valorVenda = 0;
		char opcao;

		RandomAccessFile arquivo;

		try {
			arquivo = new RandomAccessFile("VENDA.DAT", "rw");
			while (true) {
				venda.ID = arquivo.readInt();
				venda.CPF = arquivo.readUTF();
				venda.nomeCliente = arquivo.readUTF();
				venda.IDProduto = arquivo.readInt();
				venda.nomeProduto = arquivo.readUTF();
				venda.quantidade = arquivo.readInt();
				venda.valor = arquivo.readDouble();

				idVenda = venda.ID;

			}



		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}


		idVenda++;



		System.out.println("Cadastro de Vendas: ");

		System.out.println("O ID dessa venda é: " + idVenda);
		venda.ID = idVenda;



		do{
			do{
				System.out.println("Informe o cpf do Cliente: ");
				venda.CPF = leia.next(); 
				valido = true;

				for(int a=0; a<venda.CPF.length() ; a++){

					if(venda.CPF.length() != 11){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

					if(venda.CPF.charAt(a) < '0' || venda.CPF.charAt(a) > '9'){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

				}
			}while(!valido);


			verificaCPF = verificarCliente(venda.CPF);

			if(verificaCPF != true){

				System.out.println("Não foi encontrado nenhuma cliente com esse CPF");
			}

		}while(!verificaCPF);

		System.out.println("Nome do cliente: " + PesquisarNomeCliente(venda.CPF));
		venda.nomeCliente =  PesquisarNomeCliente(venda.CPF);


		do{
			System.out.println("Deseja listar os produto? (S/N)");
			opcao = leia.next().toUpperCase().charAt(0);

			if(opcao !='S' && opcao !='N'){

				System.out.println("Opção invalida! Entre com S/N");

			}
		}while(opcao !='S' && opcao !='N');

		if(opcao == 'S')
		{
			ListagemProdutos();
		}


		do{
			do{
				try{

					valido = true;
					System.out.println("Informe a id do produto: ");
					venda.IDProduto = leia.nextInt();

				}catch(InputMismatchException e){

					System.out.println("Use apenas numeros!");
					valido = false;
				}

			}while(!valido);

			verificaProduto = verificarProduto(venda.IDProduto);

			if(verificaProduto == false)
			{
				System.out.println("Produto não encontrado!");
			}

		}while(verificaProduto == false);

		System.out.println("Nome do produto: " + pesquisaNomeProduto(venda.IDProduto));
		venda.nomeProduto = pesquisaNomeProduto(venda.IDProduto);




		System.out.println("Valor do produto:  " + pesquisaValorProduto(venda.IDProduto));
		valorProduto = pesquisaValorProduto(venda.IDProduto);



		do{
			try{

				valido = true;
				System.out.println("Informe a quantidade do produto: ");
				venda.quantidade = leia.nextInt();

			}catch(InputMismatchException e){

				System.out.println("Use apenas numeros!");
				valido = false;
			}

		}while(!valido);

		valorVenda = venda.quantidade * valorProduto;
		System.out.println("Valor total da venda: R$" + valorVenda);
		venda.valor = valorVenda;


		gravarArquivoVenda(venda);

	}

	public static void gravarArquivoVenda(tipoVendas venda) {
		char confirmacao;
		Scanner leia = new Scanner (System.in);
		RandomAccessFile arquivo;

		do {
			System.out.print("\nConfirma a gravação dos dados (S/N) ? ");
			confirmacao = leia.next().charAt(0);
			confirmacao = Character.toUpperCase(confirmacao);
			if (confirmacao == 'S') {
				try {
					arquivo = new RandomAccessFile("VENDA.DAT", "rw");
					arquivo.seek(arquivo.length()); // posiciona no final do
					// arquivo (EOF)
					arquivo.writeInt(venda.ID);
					arquivo.writeUTF(venda.CPF);
					arquivo.writeUTF(venda.nomeCliente);
					arquivo.writeInt(venda.IDProduto);
					arquivo.writeUTF(venda.nomeProduto);
					arquivo.writeInt(venda.quantidade);
					arquivo.writeDouble(venda.valor);
					arquivo.close();
					System.out.println("Dados gravados com sucesso !\n");
				} catch (IOException e) {
					System.out.println("Erro na gravaçao do registro - programa será finalizado");
					System.exit(0);
				}
			}
		} while (confirmacao != 'S' && confirmacao != 'N');

	}

	public static String PesquisarNomeCliente(String CPF) {

		String nomeCliente = "";
		tipoPessoa cliente = new tipoPessoa();
		RandomAccessFile arquivo;


		try {
			arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
			while (true) {
				cliente.CPF = arquivo.readUTF();
				cliente.nome = arquivo.readUTF();
				cliente.telefone = arquivo.readInt();
				cliente.rua = arquivo.readUTF();
				cliente.numero = arquivo.readInt();
				cliente.bairro = arquivo.readUTF();
				cliente.cidade = arquivo.readUTF();
				cliente.siglaEstado = arquivo.readUTF();
				cliente.CEP = arquivo.readLong();

				if (CPF.equals(cliente.CPF)  && cliente.CPF != "" ) {

					nomeCliente = cliente.nome;

					break;
				}




			}
			arquivo.close();
		} catch (EOFException e) {
			System.out.println("Nao foi encontrado nenhum nome com esse codigo!");


		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}



		return nomeCliente;
	}

	public static String pesquisaNomeProduto(int CodigoProd) {


		tipoProduto prod = new tipoProduto();
		RandomAccessFile arquivo;
		String nomeProduto = "";

		try {
			arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
			while (true) {
				prod.codigoProduto = arquivo.readInt();
				prod.nomeProduto = arquivo.readUTF();
				prod.valorProduto = arquivo.readDouble();


				if (CodigoProd == prod.codigoProduto && prod.codigoProduto != 0) {
					nomeProduto = prod.nomeProduto;
					break;
				}
			}
			arquivo.close();
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		return nomeProduto;
	}

	public static double pesquisaValorProduto(int CodigoProd) {


		tipoProduto prod = new tipoProduto();
		RandomAccessFile arquivo;
		double ValorProduto = 0;

		try {
			arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
			while (true) {
				prod.codigoProduto = arquivo.readInt();
				prod.nomeProduto = arquivo.readUTF();
				prod.valorProduto = arquivo.readDouble();


				if (CodigoProd == prod.codigoProduto) {
					ValorProduto = prod.valorProduto;
					break;
				}
			}
			arquivo.close();
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		return ValorProduto;
	}

	public static void ListagemProdutos() {


		tipoProduto prod = new tipoProduto();
		RandomAccessFile arquivo;



		try {
			arquivo = new RandomAccessFile("PRODUTO.DAT", "r");
			while (true) {
				prod.codigoProduto = arquivo.readInt();
				prod.nomeProduto = arquivo.readUTF();
				prod.valorProduto = arquivo.readDouble();
				if(prod.codigoProduto != 0){
					System.out.println("Codigo do produto: " + prod.codigoProduto );
					System.out.println("Nome do produto: " + prod.nomeProduto);
					System.out.println("Valor do produto: R$" + prod.valorProduto );
					System.out.println("---------------------------------------------");
				}
			}


		} catch (EOFException e) {

			System.out.println("Listagem concluida!");

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}



	}

	public static void ListarClientes() {


		tipoPessoa cliente = new tipoPessoa();
		RandomAccessFile arquivo;


		try {
			arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
			while (true) {
				cliente.CPF = arquivo.readUTF();
				cliente.nome = arquivo.readUTF();
				cliente.telefone = arquivo.readInt();
				cliente.rua = arquivo.readUTF();
				cliente.numero = arquivo.readInt();
				cliente.bairro = arquivo.readUTF();
				cliente.cidade = arquivo.readUTF();
				cliente.siglaEstado = arquivo.readUTF();
				cliente.CEP = arquivo.readLong();
				if(!cliente.CPF.equals("invalidocpf")){
					System.out.println("CPF do cliente: " + cliente.CPF);
					System.out.println("Nome do cliente: " + cliente.nome);
					System.out.println("Telefone do cliente: " + cliente.telefone);
					System.out.println("Rua do cliente: " + cliente.rua);
					System.out.println("Numero do cliente: " +  cliente.numero);
					System.out.println("Bairro do cliente: " + cliente.bairro);
					System.out.println("Cidade do cliente: " + cliente.cidade);
					System.out.println("Estado do cliente: " + cliente.siglaEstado);
					System.out.println("CEP do cliente: " + cliente.CEP);
					System.out.println("--------------------------------------------");
				}


			}

		} catch (EOFException e) {
			System.out.println("Listagem concluida!");

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}


	}

	public static void AlterarArquivoCliente() {
		char confirmacao;
		Scanner leia = new Scanner (System.in);
		RandomAccessFile arquivo;
		String cpfCliente;
		tipoPessoa cliente = new tipoPessoa();
		tipoPessoa Novocliente = new tipoPessoa();
		int opcao = 0;
		boolean verificaCPF = true, valido;

		long ponteiro = 0;

		do{

			verificaCPF = false;


			do{


				System.out.println("Informe o CPF do Cliente que deseja alterar: ");
				cpfCliente = leia.next();
				valido = true;

				for(int a=0; a<cpfCliente.length() ; a++){

					if(cpfCliente.length() != 11){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

					if(cpfCliente.charAt(a) < '0' || cpfCliente.charAt(a) > '9'){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

				}
			}while(!valido);


			verificaCPF = verificarCliente(cpfCliente);


			if(verificaCPF != true)
			{
				System.out.println("CPF não encontrado!");
			}

		}while(!verificaCPF);

		try {
			arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
			while (true) {

				ponteiro = arquivo.getFilePointer();
				cliente.CPF = arquivo.readUTF();
				cliente.nome = arquivo.readUTF();
				cliente.telefone = arquivo.readInt();
				cliente.rua = arquivo.readUTF();
				cliente.numero = arquivo.readInt();
				cliente.bairro = arquivo.readUTF();
				cliente.cidade = arquivo.readUTF();
				cliente.siglaEstado = arquivo.readUTF();
				cliente.CEP = arquivo.readLong();


				if (cpfCliente.equals(cliente.CPF)) {

					break;
				}

			}
			arquivo.close();
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}


		do{	

			do{

				valido = true;	

				try{

					System.out.println("Escolhar a opcao que deseja alterar:  1 - Nome  2 - Telefone  3 - Rua  4 - Numero   5 - Bairro  6 - Cidade  7 - Estado  8 - CEP  0 - Sair");
					opcao = leia.nextInt();

				}catch(InputMismatchException e){

					System.out.println("Digite apenas números.");
					valido = false;

				}



			}while(!valido);

			if (opcao == 0){

				break;
			}

			if(opcao == 1)
			{
				do{

					System.out.println("Informe o novo nome: ");
					Novocliente.nome = leia.next();
					valido = true;
					for(int a=0; a<Novocliente.nome.length();a++){

						if(Character.toUpperCase(Novocliente.nome.charAt(a)) < 'A' || Character.toUpperCase(Novocliente.nome.charAt(a)) > 'Z' ){
							System.out.println("Digite apenas letras.");
							valido = false;
							break;

						}
					}

				}while(!valido);


			}
			else
			{
				Novocliente.nome = cliente.nome;
			}
			if(opcao == 2)
			{
				do{
					try{

						valido = true;
						System.out.println("Informe o telefone: ");
						Novocliente.telefone = leia.nextInt();

						String validaTel = String.valueOf(Novocliente.telefone);

						if(validaTel.length() != 8){

							System.out.println("Digite 8 números.");
							valido = false;

						}

					}catch(InputMismatchException e){

						System.out.println("Informe apenas numeros!");
						valido = false;
					}
				}while(!valido);
			}
			else
			{
				Novocliente.telefone = cliente.telefone;
			}
			if(opcao == 3)
			{
				System.out.println("Informe a rua:");
				Novocliente.rua = leia.next();

			}else{
				Novocliente.rua = cliente.rua;
			}

			if(opcao == 4)
			{
				do{
					try{
						valido = true;
						System.out.println("Informe o numero:");
						Novocliente.numero = leia.nextInt();
					}catch(InputMismatchException e){

						System.out.println("Informe apenas numeros!");
						valido = false;
					}
				}while(!valido);
			}
			else{
				Novocliente.numero = cliente.numero;
			}

			if(opcao == 5)	{

				System.out.println("Informe o bairro:");
				Novocliente.bairro = leia.next();

			}
			else{
				Novocliente.bairro = cliente.bairro;
			}
			if(opcao == 6)
			{
				System.out.println("Informe a cidade: ");
				Novocliente.cidade = leia.next();

			}
			else
			{
				Novocliente.cidade  = cliente.cidade;
			}
			if(opcao == 7)
			{

				//do{


				System.out.println("Informe a sigla do Estado: ");
				Novocliente.siglaEstado = leia.next();

				valido = true;
				/*	for(int a=0; a<Novocliente.siglaEstado.length() ;a++){

						char sigla = Novocliente.nome.charAt(a);

						if( Character.toUpperCase(sigla) < 'A' || Character.toUpperCase(sigla) > 'Z'){

							System.out.println("Digite apenas letras.");
							valido = false;
							break;

						}

						else if (Novocliente.siglaEstado.length() >2){

							System.out.println("Sigla invalida! Entre com apenas 2 caracteres!");
							valido = false;
							break;
						}
					}

				}while(!valido);*/

			}
			else
			{
				Novocliente.siglaEstado = cliente.siglaEstado;
			}

			if(opcao == 8)
			{

				String StringCEP;


				do{


					System.out.println("Informe o CEP do Cliente: ");
					Novocliente.CEP = leia.nextLong();
					valido = true;

					StringCEP = "" + cliente.CEP ;


					for(int a=0; a < StringCEP.length() ; a++){


						if(StringCEP.length() != 8){

							valido = false;
							System.out.println("Digite um valor válido. (8 números)");
							break;
						}

						if(StringCEP.charAt(a) < '0' || StringCEP.charAt(a) > '9'){

							valido = false;
							System.out.println("Digite um valor válido. (8 números)");
							break;

						}



					}
				}while(!valido);
			}
			else
			{
				Novocliente.CEP = cliente.CEP;
			}

		}while(opcao !=0);

		Novocliente.CPF = cpfCliente;
		cliente.CPF = "invalidocpf";


		do {
			System.out.print("\nConfirma a alteracao dos dados (S/N) ? ");
			confirmacao = leia.next().charAt(0);
			confirmacao = Character.toUpperCase(confirmacao);
			if (confirmacao == 'S') {
				try {
					arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
					arquivo.seek(ponteiro); 

					arquivo.writeUTF(cliente.CPF);
					arquivo.seek(arquivo.length());

					arquivo.writeUTF(Novocliente.CPF);
					arquivo.writeUTF(Novocliente.nome);
					arquivo.writeInt(Novocliente.telefone);
					arquivo.writeUTF(Novocliente.rua);
					arquivo.writeInt(Novocliente.numero);
					arquivo.writeUTF(Novocliente.bairro);
					arquivo.writeUTF(Novocliente.cidade);
					arquivo.writeUTF(Novocliente.siglaEstado);
					arquivo.writeLong(Novocliente.CEP);
					arquivo.close();
					System.out.println("Dados gravados com sucesso !\n");
				} catch (IOException e) {
					System.out.println("Erro na gravaçao do registro - programa será finalizado");
					System.exit(0);
				}
			}
		} while (confirmacao != 'S' && confirmacao != 'N');

	}

	public static void AlterarArquivoProduto() {

		char confirmacao;
		Scanner leia = new Scanner (System.in);
		RandomAccessFile arquivo;

		tipoProduto produto = new tipoProduto();
		tipoProduto novoproduto = new tipoProduto();
		int codProduto = 0;
		int opcao = 0;
		boolean verificaProduto = true, valido;
		long ponteiro = 0;

		do{

			do{

				valido= true;

				try{

					System.out.println("Informe o codigo do produto: ");
					codProduto = leia.nextInt();

				}catch(InputMismatchException e){

					System.out.println("Digite apenas números.");
					valido = false;

				}



			}while(!valido);

			verificaProduto = verificarProduto(codProduto);

			if(verificaProduto != true)
			{
				System.out.println("Codigo não encontrado! Digite novamente.");
			}

		}while(verificaProduto != true);


		try {
			arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
			while (true) {
				ponteiro = arquivo.getFilePointer();
				produto.codigoProduto = arquivo.readInt();
				produto.nomeProduto = arquivo.readUTF();
				produto.valorProduto =  arquivo.readDouble();



				if (codProduto == produto.codigoProduto) {

					break;
				}

			}
			arquivo.close();
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}


		do{
			do{
				valido = true;
				try{
					System.out.println("Escolhar a opcao que deseja alterar: \n 1 - Nome do Produto \n 2 - Valor do produto \n 3 - Sair");
					opcao = leia.nextInt();
				}catch(InputMismatchException e){

					System.out.println("Digite um número válido.");
					valido = true;

				}
				if(opcao < 0 || opcao > 3){

					System.out.println("Digite um número válido.");
					valido = false;

				}
			}while(!valido);

			if(opcao == 3)
			{
				break;
			}
			if(opcao == 1)
			{


				do{

					System.out.println("Informe o novo nome do produto:");
					novoproduto.nomeProduto = leia.next();

					valido = true;

					for(int a=0; a<novoproduto.nomeProduto.length();a++){

						if(Character.toUpperCase(novoproduto.nomeProduto.charAt(a)) < 'A' || Character.toUpperCase(novoproduto.nomeProduto.charAt(a)) > 'Z'){
							System.out.println("Digite apenas letras.");
							valido = false;


						}
					}

				}while(!valido);


			}
			else
			{
				novoproduto.nomeProduto = produto.nomeProduto;
			}
			if(opcao == 2)

			{


				do{

					try{					

						System.out.println("Informe o novo valor do produto:");
						novoproduto.valorProduto = leia.nextDouble(); 

					}catch(InputMismatchException e){

						System.out.println("Digite apenas números.");
						valido = false;
					}

				}while(!valido);
			}
			else
			{
				novoproduto.valorProduto = produto.valorProduto;
			}

		}while(opcao != 3);

		novoproduto.codigoProduto = produto.codigoProduto;
		produto.codigoProduto = 0;


		do {

			System.out.print("\nConfirma a alteracao dos dados (S/N) ? ");
			confirmacao = leia.next().charAt(0);
			confirmacao = Character.toUpperCase(confirmacao);
			if (confirmacao == 'S') {
				try {
					arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
					arquivo.seek(ponteiro); 
					arquivo.writeInt(produto.codigoProduto);
					arquivo.seek(arquivo.length());
					arquivo.writeInt(novoproduto.codigoProduto);
					arquivo.writeUTF(novoproduto.nomeProduto);
					arquivo.writeDouble(novoproduto.valorProduto);

					arquivo.close();
					System.out.println("Dados gravados com sucesso !\n");
				} catch (IOException e) {
					System.out.println("Erro na gravaçao do registro - programa será finalizado");
					System.exit(0);
				}
			}
		} while (confirmacao != 'S' && confirmacao != 'N');

	}

	public static void InativarProduto() {
		char confirmacao;
		Scanner leia = new Scanner (System.in);
		RandomAccessFile arquivo;

		tipoProduto produto = new tipoProduto();
		int codProduto = 0;
		boolean verificaProduto = true, valido;


		long ponteiro = 0;



		do{
			do{
				valido = true;
				try{
					System.out.println("Digite o codigo do produto que deseja excluir.");
					codProduto = leia.nextInt();

				}catch(InputMismatchException e){

					System.out.println("Informe um valor válido.");
					valido = false;

				}
			}while(!valido);


			verificaProduto = verificarProduto(codProduto);

			if(verificaProduto != true)
			{
				System.out.println("Produto não encontrado!");
			}

		}while(!verificaProduto);

		try {
			arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
			while (true) {
				ponteiro = arquivo.getFilePointer();
				produto.codigoProduto = arquivo.readInt();
				produto.nomeProduto = arquivo.readUTF();
				produto.valorProduto =  arquivo.readDouble();



				if (codProduto == produto.codigoProduto) {

					break;
				}

			}
			arquivo.close();
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		produto.codigoProduto = 0;
		do {
			System.out.print("\nConfirma a exclusao desse produto (S/N) ? ");
			confirmacao = leia.next().charAt(0);
			confirmacao = Character.toUpperCase(confirmacao);
			if (confirmacao == 'S') {
				try {
					arquivo = new RandomAccessFile("PRODUTO.DAT", "rw");
					arquivo.seek(ponteiro); // posiciona no final do
					// arquivo (EOF)
					arquivo.writeInt(produto.codigoProduto);


					arquivo.close();
					System.out.println("Dados gravados com sucesso !\n");
				} catch (IOException e) {
					System.out.println("Erro na gravaçao do registro - programa será finalizado");
					System.exit(0);
				}
			}
		} while (confirmacao != 'S' && confirmacao != 'N');

		;

	}

	public static void InativarCliente() {
		char confirmacao;
		Scanner leia = new Scanner (System.in);
		RandomAccessFile arquivo;
		String cpfCliente;
		tipoPessoa cliente = new tipoPessoa();
		boolean verificaCPF = true, valido;
		long ponteiro = 0;


		do{

			verificaCPF = false;


			do{


				System.out.println("Digite o CPF do cliente que deseja excluir.");
				cpfCliente = leia.next();
				valido = true;

				for(int a=0; a<cpfCliente.length() ; a++){

					if(cpfCliente.length() != 11){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

					if(cpfCliente.charAt(a) < '0' || cpfCliente.charAt(a) > '9'){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

				}

				verificaCPF = verificarCliente(cpfCliente);

			}while(!valido);

			if(verificaCPF != true)
			{
				System.out.println("Cliente nao encontrado com esse CPF!");
			}

		}while(!verificaCPF);


		try {
			arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
			while (true) {
				ponteiro = arquivo.getFilePointer();
				cliente.CPF = arquivo.readUTF();
				cliente.nome = arquivo.readUTF();
				cliente.telefone = arquivo.readInt();
				cliente.rua = arquivo.readUTF();
				cliente.numero = arquivo.readInt();
				cliente.bairro = arquivo.readUTF();
				cliente.cidade = arquivo.readUTF();
				cliente.siglaEstado = arquivo.readUTF();
				cliente.CEP = arquivo.readLong();


				if (cpfCliente.equals(cliente.CPF)) {

					break;
				}

			}
			arquivo.close();
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		cliente.CPF = "invalidocpf";

		do {
			System.out.print("\nConfirma a exclusão dos dados (S/N) ? ");
			confirmacao = leia.next().charAt(0);
			confirmacao = Character.toUpperCase(confirmacao);
			if (confirmacao == 'S') {
				try {
					arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
					arquivo.seek(ponteiro); // posiciona no final do
					// arquivo (EOF)
					arquivo.writeUTF(cliente.CPF);

					arquivo.close();
					System.out.println("Dados gravados com sucesso !\n");
				} catch (IOException e) {
					System.out.println("Erro na gravaçao do registro - programa será finalizado");
					System.exit(0);
				}
			}
		} while (confirmacao != 'S' && confirmacao != 'N');
		;
	}

	public static void PesquisaProdutoPessoa() {

		Scanner leia = new Scanner (System.in);

		tipoVendas venda = new tipoVendas();
		RandomAccessFile arquivo;
		String clienteCPF;
		boolean verificaCPF = true,valido;
		double soma = 0;
		int cont= 0;



		do{

			verificaCPF = false;

			do{

				System.out.println("Informe o CPF que deseja a pesquida:");
				clienteCPF = leia.next();
				valido = true;

				for(int a=0; a<clienteCPF.length() ; a++){

					if(clienteCPF.length() != 11){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

					if(clienteCPF.charAt(a) < '0' || clienteCPF.charAt(a) > '9'){

						valido = false;
						System.out.println("Digite um valor válido. (11 números)");
						break;

					}

				}
			}while(!valido);

			verificaCPF = verificarCliente(clienteCPF);

			if(verificaCPF != true){
				System.out.println("Não foi encontrado nenhuma cliente com esse CPF");
			}

		}while(!verificaCPF);

		try {
			arquivo = new RandomAccessFile("VENDA.DAT", "rw");
			while (true) {
				venda.ID = arquivo.readInt();
				venda.CPF = arquivo.readUTF();
				venda.nomeCliente = arquivo.readUTF();
				venda.IDProduto = arquivo.readInt();
				venda.nomeProduto = arquivo.readUTF();
				venda.quantidade = arquivo.readInt();
				venda.valor = arquivo.readDouble();
				if(venda.CPF.equals(clienteCPF))
				{
					cont++;
				}
			}

		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		int i = 0;
		String prod[] = new String[cont];
		boolean verifica = false;
		try {
			arquivo = new RandomAccessFile("VENDA.DAT", "rw");
			while (true) {
				venda.ID = arquivo.readInt();
				venda.CPF = arquivo.readUTF();
				venda.nomeCliente = arquivo.readUTF();
				venda.IDProduto = arquivo.readInt();
				venda.nomeProduto = arquivo.readUTF();
				venda.quantidade = arquivo.readInt();
				venda.valor = arquivo.readDouble();

				if(venda.CPF.equals(clienteCPF))
				{
					verifica = false;
					soma += venda.valor;

					for(int y = 0; y <= cont-1; y++)
					{

						if(venda.nomeProduto.equals(prod[y]))
						{
							verifica = true;

						}

					}



				}
				if(verifica == false)
				{
					prod[i] = venda.nomeProduto;
				}
				i++;

			}



		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		System.out.println("Produtos Comprados:");
		for(int x = 0; x < prod.length; x++)
		{
			if(prod[x] != null){
				System.out.print(prod[x] + " , ");
			}
		}
		System.out.println("\nTotal gasto: " + soma);
		System.out.println("-------------------------");

	}

	public static void RelatorioQtdeClienteCadastrada(){

		tipoPessoa cliente = new tipoPessoa();
		RandomAccessFile arquivo;
		int cont = 0;


		try {
			arquivo = new RandomAccessFile("CLIENTE.DAT", "rw");
			while (true) {
				cliente.CPF = arquivo.readUTF();
				cliente.nome = arquivo.readUTF();
				cliente.telefone = arquivo.readInt();
				cliente.rua = arquivo.readUTF();
				cliente.numero = arquivo.readInt();
				cliente.bairro = arquivo.readUTF();
				cliente.cidade = arquivo.readUTF();
				cliente.siglaEstado = arquivo.readUTF();
				cliente.CEP = arquivo.readLong();
				cont++;



			}

		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		System.out.println("Total de clientes cadastrados:" + cont);


	}

	public static void RelatorioQtdeProdutoCadastrado(){


		tipoProduto prod = new tipoProduto();
		RandomAccessFile arquivo;
		int cont = 0;


		try {
			arquivo = new RandomAccessFile("PRODUTO.DAT", "r");
			while (true) {
				prod.codigoProduto = arquivo.readInt();
				prod.nomeProduto = arquivo.readUTF();
				prod.valorProduto = arquivo.readDouble();
				cont++;
			}


		} catch (EOFException e) {

			System.out.println("Listagem concluida!");

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		System.out.println("O total de produtos cadastrador é: " +cont);
	}

	public static void RelatorioClienteMaisGastou(){

		tipoVendas venda = new tipoVendas();
		RandomAccessFile arquivo;
		double maiorValor = 0;
		String nomeMaior = "";

		try {
			arquivo = new RandomAccessFile("VENDA.DAT", "rw");
			while (true) {
				venda.ID = arquivo.readInt();
				venda.CPF = arquivo.readUTF();
				venda.nomeCliente = arquivo.readUTF();
				venda.IDProduto = arquivo.readInt();
				venda.nomeProduto = arquivo.readUTF();
				venda.quantidade = arquivo.readInt();
				venda.valor = arquivo.readDouble();

				if(venda.valor > maiorValor)
				{
					maiorValor =  venda.valor;
					nomeMaior = venda.nomeCliente;

				}




			}



		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		System.out.println("*****O cliente que mais gastou na empresa é:" + nomeMaior);
		System.out.println("------------------------------------------------------------------------------");
	}

	public static void RelatorioProdVendidoTotalFaturado(){

		tipoVendas venda = new tipoVendas();
		RandomAccessFile arquivo;
		double soma = 0;
		int cont = 0;
		try {
			arquivo = new RandomAccessFile("VENDA.DAT", "rw");
			while (true) {
				venda.ID = arquivo.readInt();
				venda.CPF = arquivo.readUTF();
				venda.nomeCliente = arquivo.readUTF();
				venda.IDProduto = arquivo.readInt();
				venda.nomeProduto = arquivo.readUTF();
				venda.quantidade = arquivo.readInt();
				venda.valor = arquivo.readDouble();

				cont++;





			}



		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}
		String prod[] = new String[cont];
		int i = 0;
		try {
			arquivo = new RandomAccessFile("VENDA.DAT", "rw");
			while (true) {
				venda.ID = arquivo.readInt();
				venda.CPF = arquivo.readUTF();
				venda.nomeCliente = arquivo.readUTF();
				venda.IDProduto = arquivo.readInt();
				venda.nomeProduto = arquivo.readUTF();
				venda.quantidade = arquivo.readInt();
				venda.valor = arquivo.readDouble();

				boolean verifica = false;
				soma += venda.valor;

				//se já existe esse produto o verifica recebe true e nao preenche o vetor prod, pois
				// esse produto ja existe
				for(int y = 0; y <= cont-1; y++)
				{

					if(venda.nomeProduto.equals(prod[y]))
					{
						verifica = true;

					}

				}

				if(verifica != true)
				{
					prod[i] = venda.nomeProduto;
				}
				i++;





			}



		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Erro na abertura do arquivo - programa será finalizado");
			System.exit(0);
		}

		System.out.println("Produtos Vendidos:");
		for(int x = 0; x < prod.length; x++)
		{
			if(prod[x] != null){
				System.out.print(prod[x] + " , ");
			}
		}



		System.out.println("\nTotal faturado: " + soma);




	}

	public static void main(String[] args) {


		// TODO Auto-generated method stub
		Scanner leia = new Scanner (System.in);

		char	menu,
		menu2;


		System.out.println("\tBem vindo! Escolha umas das opções abaixo:");


		for(;;){

			do{
				System.out.println("\n 1- Cadastros\n 2- Alterar\n 3- Excluir\n 4- Listagem\n 5- Pesquisa\n 6- Relatorios\n 7- Encerrar\n");
				menu = leia.next().charAt(0);

				if(menu < '1' || menu > '7'){

					System.out.println("Digite uma opção válida.");

				}

			}while(menu < '1' || menu > '7');

			if(menu == '1')
			{
				for(;;){

					System.out.println("\tMenu de Cadastros! Escolha umas das opções abaixo!\n");

					do{
						System.out.println(" 1- Cadastros de Pessoas \n 2- Cadastro de Produtos \n 3- Cadastro de Venda \n 4- Voltar");
						menu2 = leia.next().charAt(0);
						if(menu2 < '1' || menu2 > '4'){

							System.out.println("Digite uma opção válida.");
						}
					}while(menu2 < '1' || menu2 > '4');

					if(menu2 == '1')
					{
						System.out.println("Opção escolhida: Cadastro de Pessoas");
						cadastroCliente();


					}
					else if(menu2 == '2')
					{
						System.out.println("Opção escolhida: Cadastro de Produtos");
						cadastroProduto();


					}
					else if(menu2 == '3')
					{
						System.out.println("Opção escolhida: Cadastro de Vendas");
						cadastrarVenda();
					}
					else{
						break;
					}
				}
			}

			else if(menu == '2')
			{

				for(;;){

					System.out.println("\tMenu de Alteração! Escolha umas das opções abaixo!\n");

					do{
						System.out.println(" 1- Alterar Cliente\n 2- Alterar Produto \n 3- Voltar");
						menu2 = leia.next().charAt(0);

						if(menu2 < '1' || menu2 > '3'){

							System.out.println("Digite uma opção válida.");

						}

					}while(menu2 < '1' || menu2 > '3');


					if(menu2 == '1')
					{
						System.out.println("Opção escolhida: Alterar Cliente");
						AlterarArquivoCliente();
					}

					else if(menu2 == '2')
					{
						System.out.println("Opção escolhida: Alterar Produto");
						AlterarArquivoProduto();
					}
					else{
						break;
					}
				}
			}

			else if(menu == '3')
			{
				for(;;){

					System.out.println("\t Menu de Exclusão! Escolha umas das opções abaixo!\n");

					do{
						System.out.println(" 1- Excluir Cliente \n 2- Excluir Produto \n 3- Voltar");
						menu2 = leia.next().charAt(0);

						if(menu2 < '1' || menu2 > '3'){

							System.out.println("Digite uma opção válida.");

						}

					}while(menu2 < '1' || menu2 > '3');


					if(menu2 == '1'){
						System.out.println("Opção escolhida: Excluir Cliente");
						InativarCliente();

					}
					else if(menu2 == '2'){
						System.out.println("Opção escolhida: Excluir Produto");
						InativarProduto();

					}
					else{
						break;
					}

				}
			}

			else if(menu == '4')
			{
				for(;;)
				{
					System.out.println("\tMenu de Listagem! Escolha umas das opções abaixo!\n");

					do{
						System.out.println(" 1- Listar Cliente \n 2- Listar Produto \n 3- Voltar");
						menu2 = leia.next().charAt(0);

						if(menu2 < '1' || menu2 > '3'){

							System.out.println("Digite uma opção válida.");

						}

					}while(menu2 < '1' || menu2 > '3');


					if(menu2 == '1'){
						System.out.println("Opção escolhida: Listar Clientes");
						ListarClientes();

					}
					else if(menu2 == '2'){
						System.out.println("Opção escolhida: Listar Produtos");
						ListagemProdutos();

					}
					else{
						break;
					}

				}
			}

			else if(menu == '5')
			{
				for(;;)
				{
					System.out.println("\tPesquisar produtos de um cliente! Escolha umas das opções abaixo!\n");

					do{
						System.out.println(" 1- Pesquisar  \n 2- Voltar");
						menu2 = leia.next().charAt(0);

						if(menu2 < '1' || menu2 > '2'){

							System.out.println("Digite uma opção válida.");

						}

					}while(menu2 < '1' || menu2 > '2');
					if(menu2 == '1'){
						System.out.println("Opção escolhida: Pesquisar");
						PesquisaProdutoPessoa();

					}

					else{
						break;
					}

				}
			}
			else if(menu == '6')
			{
				for(;;)
				{
					System.out.println("\tMenu de Relatorios! Escolha umas das opções abaixo!\n");

					do{
						System.out.println(" 1- Total de cliente cadastrados\n 2- Total de produtos cadastrados\n 3- Qual cliente gastou mais \n 4- Todos os produtos vendidos e total faturado \n 5- Voltar");
						menu2 = leia.next().charAt(0);

						if(menu2 < '1' || menu2 > '5'){

							System.out.println("Digite uma opção válida.");

						}

					}while(menu2 < '1' || menu2 > '5');

					if(menu2 == '1'){
						System.out.println("Opção escolhida: Total de cliente cadastrados");
						RelatorioQtdeClienteCadastrada();

					}
					else if(menu2 == '2'){
						System.out.println("Opção escolhida: Total de produtos cadastrados");
						RelatorioQtdeProdutoCadastrado();

					}
					else if(menu2 == '3'){
						System.out.println("Opção escolhida: Qual cliente gastou mais");
						RelatorioClienteMaisGastou();

					}
					else if(menu2 == '4'){
						System.out.println("Opção escolhida: Todos os produtos vendidos e total faturado");
						RelatorioProdVendidoTotalFaturado();

					}
					else {
						break;
					}

				}
			}

			else if(menu == '7')
			{
				System.out.println("*** Programa Encerrado ***");
				leia.nextLine();
				System.exit(0);
			}


		}



	}

}