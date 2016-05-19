drop DATABASE eclub;

CREATE OR REPLACE DATABASE eclub 
USE eclub;

CREATE OR REPLACE TABLE empresa_divulgador (
  nome_Emp varchar(70) NOT NULL DEFAULT '',
  telefone_Emp varchar(13) DEFAULT NULL,
  email_Emp varchar(50) DEFAULT NULL,
  tipo_Emp varchar(20) DEFAULT NULL,
  senha_Emp varchar(20) DEFAULT NULL,
  cnpj_Emp varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (nome_Emp,cnpj_Emp)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE OR REPLACE TABLE endereco (
  cidade varchar(20) DEFAULT NULL,
  bairro varchar(20) DEFAULT NULL,
  cep varchar(12) DEFAULT NULL,
  rua varchar(50) DEFAULT NULL,
  numero int(11) DEFAULT NULL,
  latitude varchar(30) DEFAULT NULL,
  longetude varchar(30) DEFAULT NULL,
  Estado varchar(2) DEFAULT NULL,
  id_Endereco int(11) NOT NULL,
  PRIMARY KEY (id_Endereco)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE OR REPLACE TABLE evento (
  qntHomem int(11) DEFAULT NULL,
  valorEntrada double DEFAULT NULL,
  qntMulher int(11) DEFAULT NULL,
  qntMaxPessoas int(11) DEFAULT NULL,
  idEvento int(11) NOT NULL,
  nome_Evento varchar(30) DEFAULT NULL,
  foto_Evento blob,
  tipo_Evento varchar(30) DEFAULT NULL,
  data_Evento date DEFAULT NULL,
  hora_Evento time DEFAULT NULL,
  descrição_Evento varchar(300) DEFAULT NULL,
  id_Endereco int(11) DEFAULT NULL,
  nome_Emp varchar(70) DEFAULT NULL,
  cnpj_Emp varchar(20) DEFAULT NULL,
  PRIMARY KEY (idEvento),
  KEY id_Endereco (id_Endereco),
  KEY nome_Emp (nome_Emp,cnpj_Emp),
  CONSTRAINT evento_ibfk_1 FOREIGN KEY (id_Endereco) REFERENCES endereco (id_Endereco),
  CONSTRAINT evento_ibfk_2 FOREIGN KEY (nome_Emp, cnpj_Emp) REFERENCES empresa_divulgador (nome_Emp, cnpj_Emp)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE OR REPLACE TABLE participa (
  redeSocial varchar(30) DEFAULT NULL,
  idEvento int(11) DEFAULT NULL,
  KEY redeSocial (redeSocial),
  KEY idEvento (idEvento),
  CONSTRAINT participa_ibfk_1 FOREIGN KEY (redeSocial) REFERENCES usuario (redeSocial),
  CONSTRAINT participa_ibfk_2 FOREIGN KEY (idEvento) REFERENCES evento (idEvento)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE OR REPLACE TABLE amigos(
KEY usuario (redeSocial)
KEY amigo (redeSocial)
CONSTRAINT amigos_ibfk_1 FOREIGN KEY (redeSocial) REFERENCES usuario (redeSocial),
CONSTRAINT amigos_ibfk_2 FOREIGN KEY (redeSocial) REFERENCES usuario (redeSocial),
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE OR REPLACE TABLE tem (
  id_Endereco int(11) DEFAULT NULL,
  nome_Emp varchar(70) DEFAULT NULL,
  cnpj_Emp varchar(20) DEFAULT NULL,
  KEY nome_Emp (nome_Emp,cnpj_Emp),
  KEY id_Endereco (id_Endereco),
  CONSTRAINT tem_ibfk_2 FOREIGN KEY (id_Endereco) REFERENCES endereco (id_Endereco),
  CONSTRAINT tem_ibfk_1 FOREIGN KEY (nome_Emp, cnpj_Emp) REFERENCES empresa_divulgador (nome_Emp, cnpj_Emp)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE OR REPLACE TABLE usuario (
  dataNascimento date DEFAULT NULL,
  redeSocial varchar(30) NOT NULL,
  sexo tinyint(1) DEFAULT NULL,
  nome_User varchar(30) DEFAULT NULL,
  telefone_User varchar(13) DEFAULT NULL,
  foto_User blob,
  email_User varchar(50) DEFAULT NULL,
  PRIMARY KEY (redeSocial)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;