create schema Loja_POO;
use loja_POO;



create table produtos(
idProduto int not null AUTO_INCREMENT,
nomeProduto varchar(40) not null,
valorUnitario double not null,
tipoUnidade varchar(5) not null,
qtdEstoque int not null,
primary key(idProduto)
);

create table venda(
idVenda int not null AUTO_INCREMENT,
idCliente int,
nomeCliente varchar(20),
dataVenda varchar(10),
valorVenda double,
primary key(idVenda)
);

create table itensProduto(
idItens int not null AUTO_INCREMENT,
fk_idVenda int not null,
fk_idProduto int not null,
qtdVendida int not null,
primary key(idItens),
foreign key (fk_idVenda) references venda(idVenda), 
foreign key (fk_idProduto) references produtos(idProduto)
);


select * from produtos;


insert into produtos(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values('Cabo de redes',9.90,'metro',5);

insert into produtos(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values('Conector rj45',1.50,'un',200);

insert into produtos(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values('Placa de rede',109.00,'un',10);

insert into produtos(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values('Notebook dell g3',5500.00,'un',100);

insert into produtos(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values('Placa de video Geforce 1050 Ti 4 GB',1200.00,'un',50);

insert into produtos(nomeProduto,valorUnitario,TipoUnidade,qtdEstoque) values('Leitor de Dvd-rw samsung',90.00,'un',1);


delete from produtos where nomeProduto ='Leitor de Dvd-rw samsung'; 

update produtos set qtdEstoque = qtdEstoque + 100 where idProduto =4;

update produtos set qtdEstoque = qtdEstoque - 1 where idProduto =4;


drop schema Loja_Poo;
