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

select DISTINCT a.num_matricula_supervisor, b.nom_empregado
	from empregado a JOIN empregado b
	ON a.num_matricula_supervisor = b.num_matricula

--  Listar todos os empregados e o nome do respectivo supervisor (para quem tiver supervisor,
--  caso contrário, será listado NULL!)select a.nom_empregado, b.nom_empregado	from empregado a LEFT JOIN empregado b	ON a.num_matricula_supervisor = b.num_matricula	--Listar todos os empregados e o departamento que ele gerencia se o empregado for
--gerente (usar função ISNULL para substituir NULL por “não encontrado”)select  e.nom_empregado,  ISNULL (d.nom_depto, ('nao encontrado')) as 'departamento_que_gerencia' 	from empregado e JOIN departamento d	ON e.num_matricula = d.num_matricula_gerente	--Listar todos os empregados e os dependentes se o empregado tiver dependenteselect  a.nom_empregado, b.nom_dependente	from empregado a LEFT JOIN dependente b	ON a.num_matricula = b.num_matricula	ORDER BY a.nom_empregado --Listar o nome de todos os departamentos. Para os departamentos que tiverem
-- empregado, exibir também o nome dos empregadosselect D.nom_depto, e.nom_empregado	from departamento d	LEFT JOIN empregado e	ON e.cod_depto = d.cod_depto--. Listar os projetos sem alocação (usar algum OUTER join – LEFT, RIGHT ou FULL)select p.cod_projeto, p.nom_projeto	from alocacao a RIGHT JOIN projeto p	ON a.cod_projeto = p.cod_projeto 	WHERE a.cod_projeto IS NULL--Listar os empregados que não são gerente (usar algum OUTER join)select a.num_matricula, a.nom_empregado	from empregado a LEFT JOIN departamento d	ON a.num_matricula = d.num_matricula_gerente 	WHERE d.num_matricula_gerente IS NULL--Listar a matrícula, o nome dos empregados, o nome do departamento de cada um, a
-- matrícula e o nome do gerente do departamento.select e.num_matricula, e.nom_empregado, d.nom_depto, d.num_matricula_gerente,  g.nom_empregado AS gerente 	from empregado e 	JOIN departamento d	ON e.cod_depto = d.cod_depto		INNER JOIN empregado g	ON d.num_matricula_gerente = g.num_matricula--. Listar os departamentos, o gerente do departamento e os locais do departamento.select d.nom_depto, g.nom_empregado as gerente ,dl.nom_local	from departamento d 		FULL JOIN departamento_local dl	ON d.cod_depto = dl.cod_depto		INNER JOIN empregado g	ON d.num_matricula_gerente = g.num_matricula--Listar os projetos, o nome do departamento que controla o projeto, os funcionários
--alocados no projeto e o número de horas de cada um deles.select p.nom_projeto, d.nom_depto as 'Depto que controla o projeto', e.nom_empregado, a.num_horas as 'Horas alocadas'	from projeto p 		JOIN departamento d 	ON d.cod_depto = p.cod_depto	JOIN empregado e	ON e.cod_depto = d.cod_depto	JOIN alocacao a	ON e.num_matricula = a.num_matricula
--Listar o empregado, o respectivo departamento, o gerente do departamento, as horas
--alocadas em projetos, o nome do projeto e o respectivo departamento do projeto.

select E.nom_empregado, d.nom_depto, g.nom_empregado, a.num_matricula, p.nom_projeto, d.nom_depto	from empregado e		LEFT JOIN departamento d	ON e.cod_depto = d.cod_depto
 
	INNER JOIN empregado g	ON d.num_matricula_gerente = g.num_matricula

	JOIN alocacao a
	on a.num_matricula = e.num_matricula

	INNER JOIN projeto p
	ON p.cod_depto = d.cod_depto

	



---Listar o empregado, o respectivo departamento, o gerente do departamento, as horas
--alocadas em projetos, o nome do projeto e o respectivo departamento do projeto para os
--empregados que estão alocados em projetos controlados por outros departamentosselect e.nom_empregado, d.nom_depto, g.nom_empregado, a.num_horas, p.nom_projeto, d2.nom_depto	from empregado e  		INNER JOIN departamento d  	ON e.cod_depto = d.cod_depto	FULL JOIN empregado g	ON g.num_matricula = d.num_matricula_gerente	JOIN alocacao a	ON e.num_matricula = a.num_matricula	JOIN projeto p	ON d.cod_depto = p.cod_depto	JOIN departamento d2	ON d.cod_depto != d.cod_depto--DESAFIO EXTRA: Listar o nome de todos os empregados e o respectivo supervisor (se o
--nome do supervisor NÃO começar com 'José%')
select	from 	ON


