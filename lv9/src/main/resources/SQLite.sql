create table grad(id number, naziv varchar2(50), broj_stanovnika number, drzava number);
Create table drzava(id number, naziv varchar2(50), glavni_grad number);
insert into grad(id,naziv,broj_stanovnika,drzava) values(1,'Sarajevo',300000,1);
insert into drzava(id,naziv,glavni_grad) values(1,'Bosna i Hercegovina',1);
insert into grad(id,naziv,broj_stanovnika,drzava) values(2,'Beograd',500000,2);
insert into drzava(id,naziv,glavni_grad) values(2,'Srbija',2);