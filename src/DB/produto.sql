create database supermercado;
use supermercado;

create table produto(
	id bigint auto_increment primary key,
    nome varchar(255),
    marca varchar(255),
    dataValidade date,
    tipo varchar(255),
    quantidade bigint);
    
insert into produto(nome, marca, dataValidade, tipo, quantidade) values
	("Produto X","Marca A",'2018-02-06',"Tipo 1",10),
    ("Produto Y","Marca B",'2018-02-06',"Tipo 2",100),
    ("Produto Z","Marca C",'2018-02-06',"Tipo 3",1000);    