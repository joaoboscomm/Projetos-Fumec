--Listar o nome do projeto e o nome do departamento que o controla

select nom_projeto, nom_depto
	from projeto JOIN departamento
	ON departamento.cod_depto = projeto.cod_depto

--Listar a matrícula, o nome dos empregados e o nome do departamento de cada um.

select num_matricula, nom_empregado , nom_depto
	from empregado JOIN departamento
	ON empregado.cod_depto = departamento.cod_depto

-- Listar os gerentes e o departamento que eles gerenciam.

select nom_empregado, nom_depto
	from empregado JOIN departamento
	ON departamento.num_matricula_gerente = empregado.num_matricula

--Listar os empregados e os respectivos dependentes

select nom_empregado, nom_dependente
	from empregado JOIN dependente
	ON empregado.num_matricula = dependente.num_matricula

--Listar o nome do empregado e o respectivo supervisor.

select s.nom_empregado, e.nom_empregado as 'supervisor'
	from empregado e INNER JOIN empregado s
	ON e.num_matricula = s.num_matricula_supervisor

--Listar a matrícula, o nome dos empregados, o nome do departamento de cada um e a
--matrícula do gerente do departamento.

select num_matricula, nom_empregado, nom_depto, num_matricula_gerente
	from empregado JOIN departamento
 	ON empregado.cod_depto = departamento.cod_depto

-- Listar a matricula e o nome de todos os supervisores

select s.num_matricula_supervisor, s.nom_empregado
	from empregado e JOIN empregado s
	ON s.num_matricula_supervisor = e.num_matricula

-- VERIFICAR
