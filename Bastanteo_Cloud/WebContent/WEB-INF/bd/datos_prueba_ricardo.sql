use bd_bastanteo;

insert into tipo_empresa(c_tipo_empresa, nombre, abreviatura) values
(100, 'SOCIEDAD ANONIMA CERRADA', 'S.A.C.'), 
(101, 'SOCIEDAD ANONIMA', 'S.A.'), 
(102, 'SOCIEDAD DE RESPONSABILIDAD LIMITADA', 'S.R.L.');

insert into empresa(c_empresa, ruc, razon_social, c_tipo_empresa, fecha_inicio_oper, cant_empleado) values
(100, '10254123650', 'EMPRESA FICTICA # 1', 100, '2000-01-01', 100),
(101, '10254123580', 'EMPRESA FICTICA # 2', 101, '2005-10-01', 50),
(102, '10254123890', 'EMPRESA FICTICA # 3', 102, '2010-01-15', 10);

insert into grupo_bastanteo(c_empresa, c_grupo_bastanteo, descripcion, abreviatura) values
(100, 1, 'GRUPO A', 'A'), 
(100, 2, 'GRUPO B', 'B'), 
(100, 3, 'GRUPO C', 'C'), 
(101, 1, 'GRUPO A', 'A'), 
(101, 2, 'GRUPO B', 'B'), 
(101, 3, 'GRUPO C', 'C'), 
(102, 1, 'GRUPO A', 'A'), 
(102, 2, 'GRUPO B', 'B'), 
(102, 3, 'GRUPO C', 'C');

insert into poder(c_poder, nombre, tipo_poder) values
('CHCO', 'COBRO DE CHEQUES', 'S'), 
('EFRE', 'RETIRO EN EFECTIVO', 'S');

insert into tipo_intervencion(c_tipo_intervencion, nombre) values
(100, 'TIPO DE INTERVENCION # 1'), 
(101, 'TIPO DE INTERVENCION # 2'), 
(102, 'TIPO DE INTERVENCION # 3');

select * from tipo_empresa;
select * from empresa;
select * from grupo_bastanteo;
select * from poder;
select * from tipo_intervencion;
