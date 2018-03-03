drop database if exists st2;
create database st2;
use st2;

create table dados(
	id bigint auto_increment primary key,
    nome varchar(255),
    dataNascimento date,
    cpf char(3) unique,
    email varchar(255),
    senha varchar(255),
    telefone char(8),
    tipo long);
	## 1 - Usuário normal ## 2 - Vendedor ## 3 - Gerente 
    ## 4 - Administrador ## 5 - Entregador

insert into dados(nome, dataNascimento, cpf, email, senha, telefone, tipo) values
	("Luciana Karem",'1990-01-01',"123","lukarem","123", "12345678", 1),
    ("Mariana Karolyne",'1990-01-01',"124","mari","123", "12345678", 2),
    ("Samile Nicole",'1990-01-01',"125","samys", "123", "12345678", 3),
    ("José Germano",'1990-01-01',"126","germano","123", "12345678", 4),
    ("Kaio Guilherme", '1990-01-01',"127", "kaio", "123", "12345678", 5),
    ("Pessoa generica 1", '1990-01-01', "128", "pg1", "123", "12345678", 1),
    ("Pessoa generica 2", '1990-01-01', "129", "pg2", "123", "12345678", 1),
    ("Pessoa generica 3", '1990-01-01', "130", "pg3", "123", "12345678", 1),
    ("Pessoa generica 4", '1990-01-01', "131", "pg4", "123", "12345678", 1),
    ("Pessoa generica 5", '1990-01-01', "132", "pg5", "123", "12345678", 1),
    ("Pessoa generica 6", '1990-01-01', "133", "pg6", "123", "12345678", 1),
    ("Pessoa generica 7", '1990-01-01', "134", "pg7", "123", "12345678", 1),
    ("Pessoa generica 8", '1990-01-01', "135", "pg8", "123", "12345678", 1),
    ("Entregador generico 1", '1990-01-01', "136","eg1","123","12345678", 5),
    ("Entregador generico 2", '1990-01-01', "137","eg2","123","12345678", 5),
    ("Entregador generico 3", '1990-01-01', "138","eg3","123","12345678", 5),
    ("Entregador generico 4", '1990-01-01', "139","eg4","123","12345678", 5),
    ("Entregador generico 5", '1990-01-01', "140","eg5","123","12345678", 5),
    ("Entregador generico 6", '1990-01-01', "141","eg6","123","12345678", 5),
    ("Entregador generico 7", '1990-01-01', "142","eg7","123","12345678", 5),
    ("Vendedor generico 1", '1990-01-01', "143", "vg1", "123", "12345678", 2),
    ("Vendedor generico 2", '1990-01-01', "144", "vg2", "123", "12345678", 2),
    ("Vendedor generico 3", '1990-01-01', "145", "vg3", "123", "12345678", 2),
    ("Vendedor generico 4", '1990-01-01', "146", "vg4", "123", "12345678", 2),
    ("Vendedor generico 5", '1990-01-01', "147", "vg5", "123", "12345678", 2),
    ("Vendedor generico 6", '1990-01-01', "148", "vg6", "123", "12345678", 2),
    ("Vendedor generico 7", '1990-01-01', "149", "vg7", "123", "12345678", 2);
    
create table produto(
	id bigint auto_increment primary key,
    nome varchar(255),
    dataValidade date,
    tipo varchar(255),
    quantidade bigint,
    preco float);

insert into produto(nome, dataValidade, tipo, quantidade, preco) values
    ("Produto generico 1", '2222-12-31', "Tipo generico 1", 999 , 9.99),
    ("Produto generico 2", '2222-12-31', "Tipo generico 2", 999 , 9.99),
    ("Produto generico 3", '2222-12-31', "Tipo generico 3", 999 , 9.99),
    ("Produto generico 4", '2222-12-31', "Tipo generico 4", 999 , 9.99),
    ("Produto generico 5", '2222-12-31', "Tipo generico 5", 999 , 9.99),
    ("Produto generico 6", '2222-12-31', "Tipo generico 6", 999 , 9.99),
    ("Produto generico 7", '2222-12-31', "Tipo generico 7", 999 , 9.99),
    ("Produto generico 8", '2222-12-31', "Tipo generico 8", 999 , 9.99),
    ("Produto generico 9", '2222-12-31', "Tipo generico 9", 999 , 9.99),
    ("Produto generico 10", '2222-12-31', "Tipo generico 10", 999 , 9.99),
    ("Produto generico 11", '2222-12-31', "Tipo generico 11", 999 , 9.99),
    ("Produto generico 12", '2222-12-31', "Tipo generico 12", 999 , 9.99);        

create table vendas(
	id bigint auto_increment primary key,
    id_user bigint,
    id_vend bigint,
    id_produto bigint,
    qtd bigint,
    valor float,
    dataVenda date);
    
insert into vendas(id_user, id_vend, id_produto, qtd, valor, dataVenda) values
    (1,21,1,13,65, '2018-03-03'),
    (2,21,2,12,60, '2018-03-03'),
    (3,22,3,11,55, '2018-03-03'),
    (4,22,3,10,50, '2018-03-03'),
    (5,23,4,9,45, '2018-03-03'),
    (6,23,5,8,40, '2018-03-03'),
    (7,24,6,7,35, '2018-03-03'),
    (8,25,7,6,30, '2018-03-03'),
    (9,25,8,5,25, '2018-03-03'),
    (10,26,9,4,20, '2018-03-03'),
    (11,26,10,3,15, '2018-03-03'),
    (12,27,11,2,10, '2018-03-03'),
    (13,27,12,1,5, '2018-03-03');

insert into vendas(id_user, id_produto, qtd, valor, dataVenda) value
	(1,1,7,15.99,'2018-03-03'),
    (2,2,7,15.99,'2018-03-03'),
    (3,3,7,15.99,'2018-03-03'),
    (4,4,7,15.99,'2018-03-03'),
    (5,5,7,15.99,'2018-03-03');
    
create table entregas(
	id bigint auto_increment primary key,
    id_gerente bigint, ##Referencia gerente
    id_entregador bigint, ## == entregador
    id_produto bigint, ## == ID do Produto
    qtd bigint,
    dataPedido date,
    dataEntrega date,
    stt int); 
	## 1 - Aberto ## 2 - Pego
    ## 3 - Concluidos ## 4 - Negados
    
insert into entregas(id_gerente, id_entregador, id_produto, qtd, dataPedido, dataEntrega, stt) values
	(3,6,1, 10, '2018-01-10','2018-01-21',3),
    (3,6,1, 10, '2018-01-10','2018-01-10',4);
insert into entregas(id_gerente, id_entregador, id_produto, qtd, dataPedido, stt) values
	(3,6,2, 20, '2018-01-15',1),
    (3,6,2, 20, '2018-01-16',2);

    