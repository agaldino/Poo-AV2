create table FUNCIONARIO
(
	CODFUNCIONARIO INTEGER  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
	NOME VARCHAR(500),
	DATANASC DATE,
	ESPECIALIDADE VARCHAR(500),
	CARGO VARCHAR(255),
	SALARIO DECIMAL(5),
	SEXO CHAR(1),
	B_ATIVO int,
        constraint ck check(b_ativo in (0,1))
)

create table PROJETO
(
	CODPROJETO INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
	NOMEPROJETO VARCHAR(500),
	FINANCIADO VARCHAR(500),
	DTINICIO DATE,
	DTENCERRAMENTO DATE,
	INVESTIMENTO DECIMAL(5),
	RESPONSAVEL VARCHAR(255)
)


create table ALOCACAO
(
	CODPROJETO INTEGER,
	CODFUNCIONARIO INTEGER,
	DATAALOCACAO DATE,
        constraint fk1 foreign key (codprojeto) references projeto(codprojeto),
        constraint fk2 foreign key (codfuncionario) references funcionario(codfuncionario),
        constraint pk primary key (codprojeto,codfuncionario)
)