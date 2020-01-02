CREATE TABLE transportadora (
	id int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	cnpj varchar(14) NOT NULL UNIQUE,
	email varchar(100),
	nome varchar(100) NOT NULL,
	empresa varchar(100) NOT NULL,
	telefone varchar(11) NOT NULL,
	modal varchar(11) NOT NULL,
	rua varchar(100) NOT NULL,
	numero integer NOT NULL,
	bairro varchar(50) NOT NULL,
	cidade varchar(50) NOT NULL,
	uf char(2) NOT NULL,
	cep varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 