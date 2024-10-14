insert into usuario values('0a232a0e-82e8-4d6a-bd3b-f629fc2e8f80','guih.smi2@gmail.com','$2a$10$mv3sE8fvLKRR85AoC1NPN.sPsFaDYrSPKijFaaxVr1lsVnYZLRi1W',NULL,'Guilherme Gois Braga de Medeiros');

insert into tip_desp_fixa values('ee122e7d-e1e8-4ded-822b-2ea4accbe092','0a232a0e-82e8-4d6a-bd3b-f629fc2e8f80',1,'Fatura Claro');
--insert into tip_desp_fixa values('02643520-60db-4cb9-9c60-864e31ba26ce','0a232a0e-82e8-4d6a-bd3b-f629fc2e8f80',2,'Nubank - Cartão');

insert into type_balance values(1,'Iti Itaú','Conta corrente do iti itau.',true);
insert into type_balance values(2,'Banco Inter','Conta corrente do Inter.',true);

insert into balance values('4545e64c-446d-4d2a-ba9e-711fde482995','0a232a0e-82e8-4d6a-bd3b-f629fc2e8f80',1,-24.59,CURRENT_TIMESTAMP);
insert into balance values('ae7cf29e-744a-4979-8e5d-449dedad0ba8','0a232a0e-82e8-4d6a-bd3b-f629fc2e8f80',1,57.23,CURRENT_TIMESTAMP);


insert into stock values('e4557f86-5770-45f5-ac90-327c2e48e1b4','VALE3','Vale Brasil','SA',true);
insert into stock values('6d4a2098-2dcb-474a-a262-afacd99fb67e','BBAS3','Banco do Brasil','SA',true);
insert into stock values('6583fac0-732c-4d2d-940d-8cf851709175','HASH11','Hash Crypto','SA',true);
insert into stock values('2ac0bfe8-68bc-45a0-80ba-ef485dc71eb3','MXRF11','Fundo IFIX','SA',true);
insert into stock values('8fa10054-1e6c-4378-b0b9-11f274262917','USIM5','Fundo IFIX','SA',true);