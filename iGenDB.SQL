SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema proyectodb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyectodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyectodb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `proyectodb` ;

-- -----------------------------------------------------
-- Table `proyectodb`.`rol_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`rol_usuario` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`rol_usuario` (
  `rol_usuario_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion_rol` VARCHAR(30) NULL,
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`rol_usuario_id`))
AUTO_INCREMENT=100
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectodb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`usuario` (
  `usuario_id` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(20) NULL,
  `apellido_usuario` VARCHAR(20) NULL,
  `direccion_usuario` VARCHAR(30) NULL,
  `telefono_usuario` VARCHAR(15) NULL,
  `email_usuario` VARCHAR(30) NULL,
  `usuario` VARCHAR(15) NULL,
  `password` VARCHAR(100) NULL,
  `rol_usuario_id` INT NOT NULL,
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`usuario_id`),
  UNIQUE INDEX `usuario_id_UNIQUE` (`usuario_id` ASC),
  INDEX `fk_tipo_tipo_usuario1_idx` (`rol_usuario_id` ASC),
  CONSTRAINT `fk_tipo_tipo_usuario1`
    FOREIGN KEY (`rol_usuario_id`)
    REFERENCES `proyectodb`.`rol_usuario` (`rol_usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT=100
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectodb`.`zona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`zona` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`zona` (
  `zona_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion_zona` VARCHAR(30) NULL,
  `pais` VARCHAR(30) NULL,
  `provincia` VARCHAR(30) NULL,
  `partido` VARCHAR(30) NULL,
  `barrio` VARCHAR(30) NULL,	
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`zona_id`))
AUTO_INCREMENT=100
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectodb`.`auditor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`auditor` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`auditor` (
  `auditor_id` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` INT NOT NULL,
  `zona_id` INT NOT NULL,
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`auditor_id`),
  INDEX `fk_auditor_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_auditor_zona1_idx` (`zona_id` ASC),
  CONSTRAINT `fk_auditor_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `proyectodb`.`usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_auditor_zona1`
    FOREIGN KEY (`zona_id`)
    REFERENCES `proyectodb`.`zona` (`zona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT=100
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `proyectodb`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`producto` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`producto` (
  `producto_id` INT NOT NULL AUTO_INCREMENT,
  `descripcion_producto` VARCHAR(100) NULL,
  `marca` VARCHAR(30) NULL,
  `categoria` VARCHAR(30) NULL,
  `canal` VARCHAR(30) NULL,
  `codigo_interno` VARCHAR(30) NULL,
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`producto_id`),
  UNIQUE INDEX `productoId_UNIQUE` (`producto_id` ASC))
AUTO_INCREMENT=100
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectodb`.`proyecto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`proyecto` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`proyecto` (
  `proyecto_id` INT NOT NULL AUTO_INCREMENT,
  `fecha_pedido` DATE NULL,
  `usuario_id` INT NOT NULL,
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`proyecto_id`),
  INDEX `fk_proyecto_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_proyecto_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `proyectodb`.`usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT=100
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectodb`.`reporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`reporte` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`reporte` (
  `reporte_id` INT NOT NULL AUTO_INCREMENT,
  `local_encuestado` VARCHAR(30) NULL, 
  `fecha_inicio` DATE NULL,
  `fecha_fin` DATE NULL,
  `proyecto_id` INT NOT NULL,
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`reporte_id`, `proyecto_id`),
  INDEX `fk_reporte_proyecto1_idx` (`proyecto_id` ASC),
  CONSTRAINT `fk_reporte_proyecto1`
    FOREIGN KEY (`proyecto_id`)
    REFERENCES `proyectodb`.`proyecto` (`proyecto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT=100
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyectodb`.`detalle_reporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyectodb`.`detalle_reporte` ;

CREATE TABLE IF NOT EXISTS `proyectodb`.`detalle_reporte` (
  `detalle_reporte_id` INT NOT NULL AUTO_INCREMENT,
  `pu` DECIMAL NULL,
  `presencia` TINYINT(1) NULL,
  `descrpicion_detalle` VARCHAR(50) NULL,
  `producto_id` INT NOT NULL,
  `reporte_id` INT NOT NULL,
  `usuario_creacion` VARCHAR(30) NULL,
  `fecha_creacion` DATE NULL,
  `usuario_modificacion` VARCHAR(30) NULL,
  `fecha_modificacion` DATE NULL,  
  PRIMARY KEY (`detalle_reporte_id`, `producto_id`, `reporte_id`),
  INDEX `fk_detalle_reporte_producto1_idx` (`producto_id` ASC),
  INDEX `fk_detalle_reporte_reporte1_idx` (`reporte_id` ASC),
  CONSTRAINT `fk_detalle_reporte_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `proyectodb`.`producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_reporte_reporte1`
    FOREIGN KEY (`reporte_id`)
    REFERENCES `proyectodb`.`reporte` (`reporte_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
AUTO_INCREMENT=100
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
