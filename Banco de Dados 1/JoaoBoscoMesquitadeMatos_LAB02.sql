--Listar o nome dos empregados da UF=’MG’

select nom_empregado
	from empregado
	where sig_uf='MG'

/*Listar o nome e a data de nascimento de todos os empregados em ordem ascendente de
data de nascimento*/

select nom_empregado, dat_nascimento
	from empregado
	order by empregado.dat_nascimento ASC	


--Listar o nome e o local de todos os projetos.

select nom_projeto, nom_local
	from projeto


--Listar o nome de todas as cidades e UFs distintas dos empregados.

select distinct nom_cidade, sig_uf
	from empregado


--Listar todos os departamentos cujo gerente começou após ‘2007-01-01’

select * from departamento
	where dat_inicio_gerente = '2007-01-01'


--Listar o nome dos empregados e o salário ordenando por ordem decrescente de salário.select nom_empregado, val_salario	
	from empregado	
	order by val_salario DESC	
	
--Listar o nome e o parentesco de todos os dependente do sexo masculino

select nom_dependente, dsc_parentesco
	from dependente
	where dependente.sex_dependente='M'

--Listar os empregados sem supervisor e da UF igual a ‘MG’

select * from empregado
	where empregado.num_matricula_supervisor IS NULL AND
			empregado.sig_uf ='MG'


--Listar os departamentos sem gerente

select * from departamento
	where num_matricula_gerente IS NULL


--Listar os empregados do sexo feminino e com salário maior do que R$ 1.500,00

select * from empregado
	where empregado.sex_empregado = 'F' AND 
			empregado.val_salario > 1500

--Listar o nome dos projetos controlados pelo departamento 2.

select nom_projeto	
	from projeto
	where projeto.cod_depto = '2'


--Listar o código e o nome dos projetos cujo local é 'BH', 'RJ' ou 'SP'.

select cod_projeto, nom_projeto
	from projeto
	where projeto.nom_local = 'BH' OR
	projeto.nom_local = 'RJ' OR
	projeto.nom_local = 'SP'


/*Listar o nome distintos dos locais dos projetos cujo nome do projeto possui o texto 'novo'
ou 'nova'.*/

select distinct nom_local
	from projeto
	where nom_projeto LIKE '%nova%' OR
	nom_projeto LIKE '%novo%' 


--Listar o nome dos projetos cujo nome começa com 'criar' ou termina com '2005'
select nom_projeto
	from projeto
	where nom_projeto LIKE 'CRIAR%' OR
	nom_projeto LIKE '%2005'


/*Listar o nome e o salário do empregado de 'MG' que recebe o maior salário (Obs: sem usar
MAX)*/

select TOP 1 nom_empregado, val_salario
	from empregado
	where empregado.sig_uf = 'MG'