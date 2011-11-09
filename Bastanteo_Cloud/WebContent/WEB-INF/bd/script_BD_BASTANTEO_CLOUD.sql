create database BD_BASTANTEO;

use BD_BASTANTEO;

-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`PERFIL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`PERFIL` (
  `C_PERFIL` INT NOT NULL ,
  `NOMBRE` VARCHAR(40) NOT NULL ,
  `FLAG_ACTIVO` CHAR(1) NULL DEFAULT '&' ,
  PRIMARY KEY (`C_PERFIL`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`USUARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`USUARIO` (
  `C_USUARIO` INT NOT NULL ,
  `CLAVE` VARCHAR(15) NOT NULL ,
  `LOGIN` VARCHAR(15) NOT NULL ,
  `NOMBRE` VARCHAR(80) NOT NULL ,
  `C_PERFIL` INT NOT NULL ,
  `FLAG_ACTIVO` CHAR(1) NULL DEFAULT '&' ,
  PRIMARY KEY (`C_USUARIO`) ,
  INDEX `FK_USUARIO_PERFIL` (`C_PERFIL` ASC) ,
  CONSTRAINT `fk_USUARIO_PERFIL1`
    FOREIGN KEY (`C_PERFIL` )
    REFERENCES `BD_BASTANTEO`.`PERFIL` (`C_PERFIL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`ACCESO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`ACCESO` (
  `C_PERFIL` INT NOT NULL ,
  `C_ACCESO` INT NOT NULL ,
  `NOMBRE` VARCHAR(100) NOT NULL ,
  `ORDEN` VARCHAR(11) NOT NULL ,
  `URL_ACCESO` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`C_PERFIL`, `C_ACCESO`) ,
  INDEX `fk_ACCESO_PERFIL1` (`C_PERFIL` ASC) ,
  CONSTRAINT `fk_ACCESO_PERFIL1`
    FOREIGN KEY (`C_PERFIL` )
    REFERENCES `BD_BASTANTEO`.`PERFIL` (`C_PERFIL` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`TIPO_EMPRESA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`TIPO_EMPRESA` (
  `C_TIPO_EMPRESA` INT NOT NULL ,
  `NOMBRE` VARCHAR(40) NOT NULL ,
  `ABREVIATURA` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`C_TIPO_EMPRESA`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`EMPRESA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`EMPRESA` (
  `C_EMPRESA` CHAR(8) NOT NULL ,
  `RUC` CHAR(11) NOT NULL ,
  `RAZON_SOCIAL` VARCHAR(100) NOT NULL ,
  `C_TIPO_EMPRESA` INT NOT NULL ,
  `FECHA_INICIO_OPER` DATE NULL ,
  `CANT_EMPLEADO` SMALLINT NULL DEFAULT 0 ,
  PRIMARY KEY (`C_EMPRESA`) ,
  INDEX `fk_EMPRESA_TIPO_EMPRESA1` (`C_TIPO_EMPRESA` ASC) ,
  CONSTRAINT `fk_EMPRESA_TIPO_EMPRESA1`
    FOREIGN KEY (`C_TIPO_EMPRESA` )
    REFERENCES `BD_BASTANTEO`.`TIPO_EMPRESA` (`C_TIPO_EMPRESA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`TIPO_DOC_ID`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`TIPO_DOC_ID` (
  `C_TIPO_DOC_ID` INT NOT NULL ,
  `NOMBRE` VARCHAR(40) NOT NULL ,
  `ABREVIATURA` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`C_TIPO_DOC_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`GRUPO_BASTANTEO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`GRUPO_BASTANTEO` (
  `C_EMPRESA` CHAR(8) NOT NULL ,
  `C_GRUPO_BASTANTEO` INT NOT NULL ,
  `DESCRIPCION` VARCHAR(100) NOT NULL ,
  `ABREVIATURA` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`C_EMPRESA`, `C_GRUPO_BASTANTEO`) ,
  INDEX `fk_GRUPO_BASTANTEO_EMPRESA1` (`C_EMPRESA` ASC) ,
  CONSTRAINT `fk_GRUPO_BASTANTEO_EMPRESA1`
    FOREIGN KEY (`C_EMPRESA` )
    REFERENCES `BD_BASTANTEO`.`EMPRESA` (`C_EMPRESA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`REPRESENTANTE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`REPRESENTANTE` (
  `C_EMPRESA` CHAR(8) NOT NULL ,
  `C_REPRESENTANTE` INT NOT NULL ,
  `APE_PATERNO` VARCHAR(20) NOT NULL ,
  `APE_MATERNO` VARCHAR(20) NOT NULL ,
  `NOMBRE` VARCHAR(40) NOT NULL ,
  `C_TIPO_DOC_ID` INT NOT NULL ,
  `NUM_DOC_ID` VARCHAR(15) NOT NULL ,
  `CARGO_EMPRESA` VARCHAR(50) NOT NULL ,
  `C_EMPRESA_FK` CHAR(8) NOT NULL ,
  `C_GRUPO_BASTANTEO_FK` INT NOT NULL ,
  PRIMARY KEY (`C_EMPRESA`, `C_REPRESENTANTE`) ,
  INDEX `FK_REPRESENTANTE_EMPRESA` (`C_EMPRESA` ASC) ,
  INDEX `FK_REPRESENTANTE_TIPO_DOC_ID` (`C_TIPO_DOC_ID` ASC) ,
  INDEX `fk_REPRESENTANTE_GRUPO_BASTANTEO1` (`C_EMPRESA_FK` ASC, `C_GRUPO_BASTANTEO_FK` ASC) ,
  CONSTRAINT `fk_REPRESENTANTE_EMPRESA1`
    FOREIGN KEY (`C_EMPRESA` )
    REFERENCES `BD_BASTANTEO`.`EMPRESA` (`C_EMPRESA` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REPRESENTANTE_TIPO_DOC_ID1`
    FOREIGN KEY (`C_TIPO_DOC_ID` )
    REFERENCES `BD_BASTANTEO`.`TIPO_DOC_ID` (`C_TIPO_DOC_ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_REPRESENTANTE_GRUPO_BASTANTEO1`
    FOREIGN KEY (`C_EMPRESA_FK` , `C_GRUPO_BASTANTEO_FK` )
    REFERENCES `BD_BASTANTEO`.`GRUPO_BASTANTEO` (`C_EMPRESA` , `C_GRUPO_BASTANTEO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`PODER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`PODER` (
  `C_PODER` CHAR(4) NOT NULL ,
  `NOMBRE` VARCHAR(40) NOT NULL ,
  `TIPO_PODER` CHAR(1) NOT NULL COMMENT 'VALORES:\n\nA = ACTIVO\nP = PASIVO' ,
  PRIMARY KEY (`C_PODER`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`TIPO_INTERVENCION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`TIPO_INTERVENCION` (
  `C_TIPO_INTERVENCION` INT NOT NULL ,
  `NOMBRE` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`C_TIPO_INTERVENCION`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`BASTANTEO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`BASTANTEO` (
  `C_EMPRESA` CHAR(8) NOT NULL ,
  `C_GRUPO_BASTANTEO` INT NOT NULL ,
  `C_PODER` CHAR(4) NOT NULL ,
  `C_TIPO_INTERVENCION` INT NOT NULL ,
  `IMPORTE_MIN` DECIMAL NOT NULL DEFAULT 0 ,
  `IMPORTE_MAX` DECIMAL NOT NULL DEFAULT 0 ,
  `FECHA_INI` DATETIME NOT NULL ,
  `FECHA_FIN` DATETIME NOT NULL ,
  PRIMARY KEY (`C_EMPRESA`, `C_GRUPO_BASTANTEO`, `C_PODER`) ,
  INDEX `fk_BASTANTEO_GRUPO_BASTANTEO1` (`C_EMPRESA` ASC, `C_GRUPO_BASTANTEO` ASC) ,
  INDEX `fk_BASTANTEO_TIPO_INTERVENCION1` (`C_TIPO_INTERVENCION` ASC) ,
  CONSTRAINT `fk_BASTANTEO_PODER1`
    FOREIGN KEY (`C_PODER` )
    REFERENCES `BD_BASTANTEO`.`PODER` (`C_PODER` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BASTANTEO_GRUPO_BASTANTEO1`
    FOREIGN KEY (`C_EMPRESA` , `C_GRUPO_BASTANTEO` )
    REFERENCES `BD_BASTANTEO`.`GRUPO_BASTANTEO` (`C_EMPRESA` , `C_GRUPO_BASTANTEO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BASTANTEO_TIPO_INTERVENCION1`
    FOREIGN KEY (`C_TIPO_INTERVENCION` )
    REFERENCES `BD_BASTANTEO`.`TIPO_INTERVENCION` (`C_TIPO_INTERVENCION` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_BASTANTEO`.`D_BASTANTEO_GRUPO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `BD_BASTANTEO`.`D_BASTANTEO_GRUPO` (
  `C_EMPRESA` CHAR(8) NOT NULL ,
  `C_GRUPO_BASTANTEO` INT NOT NULL ,
  `C_PODER` CHAR(4) NOT NULL ,
  `C_EMPRESA_FK` CHAR(8) NOT NULL ,
  `C_GRUPO_BASTANTEO_FK` INT NOT NULL ,
  PRIMARY KEY (`C_EMPRESA`, `C_GRUPO_BASTANTEO`, `C_PODER`) ,
  INDEX `fk_table1_GRUPO_BASTANTEO1` (`C_EMPRESA_FK` ASC, `C_GRUPO_BASTANTEO_FK` ASC) ,
  CONSTRAINT `fk_table1_BASTANTEO1`
    FOREIGN KEY (`C_EMPRESA` , `C_GRUPO_BASTANTEO` , `C_PODER` )
    REFERENCES `BD_BASTANTEO`.`BASTANTEO` (`C_EMPRESA` , `C_GRUPO_BASTANTEO` , `C_PODER` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_GRUPO_BASTANTEO1`
    FOREIGN KEY (`C_EMPRESA_FK` , `C_GRUPO_BASTANTEO_FK` )
    REFERENCES `BD_BASTANTEO`.`GRUPO_BASTANTEO` (`C_EMPRESA` , `C_GRUPO_BASTANTEO` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
