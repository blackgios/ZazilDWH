drop table Empresa;
create table Empresa(
	rfcEmpresa varchar(12) not null,
	nombreEmpresa varchar(100) not null,
	empresaSISCAM integer,
	primary key(rfcEmpresa)
);
drop table SAT;
create table SAT(
	rfcEmpresa varchar(12) not null,
	accesoSAT varchar(20) not null,
	periodoUltaDecl varchar(6),
	periodoUltDiot varchar(6),
	primary key(rfcEmpresa)
);
drop table Banco;
create table Banco(
	bancoSISCAM integer,
	nombreBanco varchar(100),
	tipoBanco varchar(1),
	primary key(bancoSISCAM)
);
drop table EstadoCuenta;
create table EstadoCuenta(
	rfcEmpresa varchar(12) not null,
	bancoSISCAM integer not null,
	cuenta varchar(20) not null,
	periodo varchar(8) not null,
	SaldoInicial double,
	Entradas double,
	Salidas double,
	SaldoFinal double
);



