SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';



DROP SCHEMA IF EXISTS `ReporteOCR_1` ;

CREATE SCHEMA IF NOT EXISTS `ReporteOCR_1` DEFAULT CHARACTER SET latin1 ;

USE `ReporteOCR_1` ;



-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`sedes`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`sedes` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`sedes` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `sigla` VARCHAR(5) NOT NULL unique ,

  `nombre` VARCHAR(30) NOT NULL unique ,

  PRIMARY KEY (`id`) )

ENGINE = InnoDB

AUTO_INCREMENT = 0

DEFAULT CHARACTER SET = latin1;

INSERT INTO `reporteocr_1`.`sedes`(`sigla`,`nombre`)
VALUES('GND', 'Gendarmería Nacional');
INSERT INTO `reporteocr_1`.`sedes`(`sigla`,`nombre`)
VALUES('OSN', 'Obras Sanitarias de la Nacion');




-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`idc`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`idc` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`idc` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idVolumen` INT(11) NOT NULL ,
  -- ojo !
  -- idSede , no id_sede

  `idSede` INT(11) NOT NULL ,

  `nombre_idc` VARCHAR(45) NOT NULL  Unique,

  `papeles` INT(11) NULL DEFAULT NULL ,

  `pap_validos` INT(11) NULL DEFAULT NULL ,

  `pap_invalidos` INT(11) NULL DEFAULT NULL ,

  `cant_caratulas` INT(11) NULL DEFAULT NULL ,

  `imagenes` INT(11) NOT NULL ,

  `anversos` INT(11) NOT NULL ,

  `reversos` INT(11) NOT NULL ,

  `estado` VARCHAR(25) NOT NULL ,

  PRIMARY KEY (`id`) ,

  INDEX `fk_idc_vols` (`idVolumen` ASC) )

ENGINE = InnoDB

AUTO_INCREMENT = 0

DEFAULT CHARACTER SET = latin1;


-- ALTER TABLE `reporteocr_1`.`idc` 

--  ADD UNIQUE INDEX `nombre_idc_UNIQUE` (`nombre_idc` ASC) ;




-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`campos`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`campos` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`campos` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idSede` INT(11) NOT NULL ,

  `idIdc` INT(11) NOT NULL ,

  `campos` INT(11) NULL DEFAULT NULL ,

  `campos_valid` INT(11) NULL DEFAULT NULL ,

  `campos_invalid` INT(11) NULL DEFAULT NULL ,

  `campos_invalidDB` INT(11) NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) ,

  -- INDEX `fk_est_sede` (`idSede` ASC) ,

 --  INDEX `fk_est_idc` (`idSede` ASC) ,

 -- INDEX `fk_sede` (`idSede` ASC) ,

  INDEX `fk_idcs` (`idIdc` ASC) ,

 -- CONSTRAINT `fk_sede`

 --   FOREIGN KEY (`idSede` )

  --  REFERENCES `ReporteOCR_1`.`sedes` (`id` )

  --  ON DELETE cascade 

 --   ON UPDATE cascade ,

  CONSTRAINT `fk_idcs`

    FOREIGN KEY (`idIdc` )

    REFERENCES `ReporteOCR_1`.`idc` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE)

ENGINE = InnoDB

AUTO_INCREMENT = 0

DEFAULT CHARACTER SET = latin1;



-- ALTER TABLE `reporteocr_1`.`campos` DROP FOREIGN KEY `fk_sede` ;

ALTER TABLE `reporteocr_1`.`campos` 

  ADD CONSTRAINT `fk_sede`

  FOREIGN KEY (`idSede` )

  REFERENCES `reporteocr_1`.`sedes` (`id` )

  ON DELETE CASCADE

  ON UPDATE CASCADE;

-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`caratulas`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`caratulas` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`caratulas` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idIdc` INT(11) NOT NULL ,

  `idVolumen` INT(11) NOT NULL ,

  `idSede` INT(11) NOT NULL ,

  `estado` VARCHAR(20) NOT NULL ,

  `tipo_doc` VARCHAR(10) NOT NULL ,

  `subtipo_doc` INT(11) NOT NULL ,

  `id_c1` VARCHAR(20) NULL DEFAULT NULL ,

  `id_c2` VARCHAR(20) NULL DEFAULT NULL ,

  `id_c3` VARCHAR(20) NULL DEFAULT NULL ,

  `id_c4` VARCHAR(20) NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) 
 
    )
    
    ENGINE = InnoDB

AUTO_INCREMENT = 0

DEFAULT CHARACTER SET = latin1;

     ALTER TABLE `reporteocr_1`.`caratulas` 
     -- no encuentro el problema con el idvolumen
     

  -- ADD CONSTRAINT `fk_crt_vol`

 --  FOREIGN KEY (`idVolumen` )
 
 --  REFERENCES `reporteocr_1`.`volumen` (`id` )

--   ON DELETE CASCADE

 --  ON UPDATE CASCADE, 

   ADD CONSTRAINT `fk_crt_idc`

   FOREIGN KEY (`idIdc` )

   REFERENCES `reporteocr_1`.`idc` (`id` )

   ON DELETE CASCADE

   ON UPDATE CASCADE, 

   ADD CONSTRAINT `fk_crt_sedes`

   FOREIGN KEY (`idSede` )
   REFERENCES `reporteocr_1`.`sedes` (`id` )

   ON DELETE CASCADE

   ON UPDATE CASCADE

 -- , ADD INDEX `fk_crt_vol` (`idVolumen` ASC) 

 , ADD INDEX `fk_crt_idc` (`idIdc` ASC) 

 , ADD INDEX `fk_crt_sedes` (`idSede` ASC) ;









-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`gnd_carat`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`gnd_crt` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`gnd_crt` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idSede` INT(11) NOT NULL ,

  `idIdc` INT(11) NOT NULL ,

  `id_c1` VARCHAR(45) NULL DEFAULT NULL ,

  `caja` VARCHAR(45) NULL DEFAULT NULL ,

  `anio` VARCHAR(45) NULL DEFAULT NULL ,

  `mes` VARCHAR(45) NULL DEFAULT NULL ,

  `liquidacion` VARCHAR(45) NULL DEFAULT NULL ,

  `unidad` VARCHAR(45) NULL DEFAULT NULL ,

  `id_c2` VARCHAR(45) NULL DEFAULT NULL ,

  `id_c3` VARCHAR(45) NULL DEFAULT NULL ,

  `id_c4` VARCHAR(45) NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) ,

  -- NDEX `fk_meta_gnd` (`idSede` ASC) ,

  -- INDEX `fk_idc` (`idIdc` ASC) ,

  INDEX `fk_sede_gnd_carat` (`idSede` ASC) ,

  INDEX `fk_idc_gnd_carat` (`idIdc` ASC) ,

  CONSTRAINT `fk_sede_gnd_carat`

    FOREIGN KEY (`idSede` )

    REFERENCES `ReporteOCR_1`.`sedes` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE,

  CONSTRAINT `fk_idc_gnd_carat`

    FOREIGN KEY (`idIdc` )

    REFERENCES `ReporteOCR_1`.`idc` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE)

ENGINE = InnoDB

AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;





-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`gnd_metadatos`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`gnd_metadatos` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`gnd_metadatos` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idSede` INT(11) NOT NULL ,

  `idIdc` INT(11) NOT NULL ,

  `grado_valid` INT(11) NULL DEFAULT NULL ,

  `grado_invalid` INT(11) NULL DEFAULT NULL ,

  `grado_invalidDB` INT(11) NULL DEFAULT NULL ,

  `codEst_valid` INT(11) NULL DEFAULT NULL ,

  `codEst_invalid` INT(11) NULL DEFAULT NULL ,

  `codEst_invalidDB` INT(11) NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) ,

  -- INDEX `fk_gnd_sede` (`idSede` ASC) ,
-- ojo porque tiene dos fk con idc
  -- INDEX `fk_gnd_idc` (`idIdc` ASC) ,

  INDEX `fk_gnd_idc_m` (`idIdc` ASC) ,

  INDEX `fk_gnd_sede_m` (`idSede` ASC) ,

  CONSTRAINT `fk_gnd_idc_m`

    FOREIGN KEY (`idIdc` )

    REFERENCES `ReporteOCR_1`.`idc` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE,

  CONSTRAINT `fk_gnd_sede_m`

    FOREIGN KEY (`idSede` )

    REFERENCES `ReporteOCR_1`.`sedes` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE)

ENGINE = InnoDB

AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;





-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`osn_crt`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`osn_crt` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`osn_crt` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idSede` INT(11) NOT NULL ,

  `idIdc` INT(11) NOT NULL ,

  `sumarias` INT(11) NULL DEFAULT NULL ,

  `id_c2` VARCHAR(45) NULL DEFAULT NULL ,

  `caja` VARCHAR(45) NULL DEFAULT NULL ,

  `banco` VARCHAR(45) NULL DEFAULT NULL ,

  `sucursal` VARCHAR(45) NULL DEFAULT NULL ,

  `fecha_presentacion` VARCHAR(45) NULL DEFAULT NULL ,

  `id_c3` VARCHAR(45) NULL DEFAULT NULL ,

  `id_c4` VARCHAR(45) NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) ,

  -- INDEX `fk_meta_osn` (`idSede` ASC) ,

  INDEX `fk_idc_osn_crt` (`idIdc` ASC) ,

  INDEX `fk_sede_osn_crt` (`idSede` ASC) ,

  CONSTRAINT `fk_idc_osn_crt`

    FOREIGN KEY (`idIdc` )

    REFERENCES `ReporteOCR_1`.`idc` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE,

  CONSTRAINT `fk_sede_osn_crt`

    FOREIGN KEY (`idSede` )

    REFERENCES `ReporteOCR_1`.`sedes` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE)

ENGINE = InnoDB

AUTO_INCREMENT = 0

DEFAULT CHARACTER SET = latin1;





-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`osn_metadatos`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`osn_metadatos` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`osn_metadatos` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idSede` INT(11) NOT NULL ,

  `idIdc` INT(11) NOT NULL ,

  `distrito_valid` INT(11) NULL DEFAULT NULL ,

  `distrito_invalid` INT(11) NULL DEFAULT NULL ,

  `partida_valid` INT(11) NULL DEFAULT NULL ,

  `partida_invalid` INT(11) NULL DEFAULT NULL ,

  `subcuenta_valid` INT(11) NULL DEFAULT NULL ,

  `subcuenta_invalid` INT(11) NULL DEFAULT NULL ,

  `digito_valid` INT(11) NULL DEFAULT NULL ,

  `digito_invalid` INT(11) NULL DEFAULT NULL ,

  `anio_valid` INT(11) NULL DEFAULT NULL ,

  `anio_invalid` INT(11) NULL DEFAULT NULL ,

  `bimestre_valid` INT(11) NULL DEFAULT NULL ,

  `bimestre_invalid` INT(11) NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) ,

  INDEX `fk_osn_sede` (`idSede` ASC) ,

  INDEX `fk_osn_idc` (`idIdc` ASC) ,

  CONSTRAINT `fk_osn_idc`

    FOREIGN KEY (`idIdc` )

    REFERENCES `ReporteOCR_1`.`idc` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE,

  CONSTRAINT `fk_osn_sede`

    FOREIGN KEY (`idSede` )

    REFERENCES `ReporteOCR_1`.`sedes` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE)

ENGINE = InnoDB

AUTO_INCREMENT = 0

DEFAULT CHARACTER SET = latin1;





-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`volumen`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`volumen` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`volumen` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idSede` INT(11) NOT NULL ,

  `volumen` VARCHAR(45) NOT NULL unique ,

  `cantidad_idcs` INT(11) NULL DEFAULT NULL COMMENT 'Fecha reporte: dato sobre el momento en que se realizo el reporte ' ,

  `fecha_reporte` DATE NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) ,

 -- INDEX `fk_sede_sedes` (`idSede` ASC) ,

  INDEX `fk_sede_vols` (`idSede` ASC) ,

  CONSTRAINT `fk_sede_vols`

    FOREIGN KEY (`idSede` )

    REFERENCES `ReporteOCR_1`.`sedes` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE)

ENGINE = InnoDB

AUTO_INCREMENT = 0

DEFAULT CHARACTER SET = latin1;

-- ALTER TABLE `reporteocr_1`.`volumen` 

-- ADD UNIQUE INDEX `volumen_UNIQUE` (`volumen` ASC) ;



-- -----------------------------------------------------

-- Table `ReporteOCR_1`.`totales`

-- -----------------------------------------------------

DROP TABLE IF EXISTS `ReporteOCR_1`.`totales` ;



CREATE  TABLE IF NOT EXISTS `ReporteOCR_1`.`totales` (

  `id` INT(11) NOT NULL AUTO_INCREMENT ,

  `idVolumen` INT(11) NOT NULL ,

  `idSede` INT(11) NOT NULL ,

  `papeles` INT(11) NULL DEFAULT NULL ,

  `pap_validos` INT(11) NULL DEFAULT NULL ,

  `pap_invalidos` INT(11) NULL DEFAULT NULL ,

  `imagenes` INT(11) NULL DEFAULT NULL ,

  `anversos` INT(11) NULL DEFAULT NULL ,

  `reversos` INT(11) NULL DEFAULT NULL ,

  `campos` INT(11) NULL DEFAULT NULL ,

  `campos_valid` INT(11) NULL DEFAULT NULL ,

  `campos_invalid` INT(11) NULL DEFAULT NULL ,

  `campos_invalidDb` INT(11) NULL DEFAULT NULL ,

  `estado_validacion` VARCHAR(45) NULL DEFAULT NULL ,

  PRIMARY KEY (`id`) ,

 -- INDEX `fk_ttvol_vols` (`idVolumen` ASC) ,

  INDEX `fk_sede_vol` (`idSede` ASC) ,

  INDEX `fk_volumen` (`idVolumen` ASC) ,

  CONSTRAINT `fk_sede_vol`

    FOREIGN KEY (`idSede` )

    REFERENCES `ReporteOCR_1`.`sedes` (`id` )

    ON DELETE cascade

    ON UPDATE cascade,

  CONSTRAINT `fk_volumen`

    FOREIGN KEY (`idVolumen` )

    REFERENCES `ReporteOCR_1`.`volumen` (`id` )

    ON DELETE CASCADE

    ON UPDATE CASCADE)

ENGINE = InnoDB

AUTO_INCREMENT =0

DEFAULT CHARACTER SET = latin1;







SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
rangos_qs
