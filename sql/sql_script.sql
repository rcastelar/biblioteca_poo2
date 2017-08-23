-- MySQL Script generated by MySQL Workbench
-- 08/23/17 10:18:07
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`local` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  `posicao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`sub_divisao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`sub_divisao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  `local_id` INT NOT NULL,
  PRIMARY KEY (`id`, `local_id`),
  CONSTRAINT `fk_sub_divisao_local1`
    FOREIGN KEY (`local_id`)
    REFERENCES `biblioteca`.`local` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_sub_divisao_local1_idx` ON `biblioteca`.`sub_divisao` (`local_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`editora` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`livro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `codigo` INT NOT NULL,
  `status` SMALLINT NOT NULL,
  `editora_id` INT NOT NULL,
  `sub_divisao_id` INT NOT NULL,
  `sub_divisao_local_id` INT NOT NULL,
  PRIMARY KEY (`id`, `editora_id`, `sub_divisao_id`, `sub_divisao_local_id`),
  CONSTRAINT `fk_livro_editora`
    FOREIGN KEY (`editora_id`)
    REFERENCES `biblioteca`.`editora` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_sub_divisao1`
    FOREIGN KEY (`sub_divisao_id` , `sub_divisao_local_id`)
    REFERENCES `biblioteca`.`sub_divisao` (`id` , `local_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_livro_editora_idx` ON `biblioteca`.`livro` (`editora_id` ASC);

CREATE INDEX `fk_livro_sub_divisao1_idx` ON `biblioteca`.`livro` (`sub_divisao_id` ASC, `sub_divisao_local_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`autor` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`heteronimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`heteronimo` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `autor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_heteronimo_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `biblioteca`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_heteronimo_autor1_idx` ON `biblioteca`.`heteronimo` (`autor_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`genero` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `descricao` LONGTEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`estado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sigla` VARCHAR(4) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `sigla_UNIQUE` ON `biblioteca`.`estado` (`sigla` ASC);

CREATE UNIQUE INDEX `nome_UNIQUE` ON `biblioteca`.`estado` (`nome` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `estado_id` INT NOT NULL,
  PRIMARY KEY (`id`, `estado_id`),
  CONSTRAINT `fk_cidade_estado1`
    FOREIGN KEY (`estado_id`)
    REFERENCES `biblioteca`.`estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cidade_estado1_idx` ON `biblioteca`.`cidade` (`estado_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rg` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `rua` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `cep` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `cidade_id` INT NOT NULL,
  `cidade_estado_id` INT NOT NULL,
  `tipo` SMALLINT NULL,
  PRIMARY KEY (`id`, `cidade_id`, `cidade_estado_id`),
  CONSTRAINT `fk_usuario_cidade1`
    FOREIGN KEY (`cidade_id` , `cidade_estado_id`)
    REFERENCES `biblioteca`.`cidade` (`id` , `estado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `rg_UNIQUE` ON `biblioteca`.`usuario` (`rg` ASC);

CREATE INDEX `fk_usuario_cidade1_idx` ON `biblioteca`.`usuario` (`cidade_id` ASC, `cidade_estado_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`livro_has_genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`livro_has_genero` (
  `livro_id` INT NOT NULL,
  `genero_id` INT NOT NULL,
  PRIMARY KEY (`livro_id`, `genero_id`),
  CONSTRAINT `fk_livro_has_genero_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `biblioteca`.`livro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livro_has_genero_genero1`
    FOREIGN KEY (`genero_id`)
    REFERENCES `biblioteca`.`genero` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_livro_has_genero_genero1_idx` ON `biblioteca`.`livro_has_genero` (`genero_id` ASC);

CREATE INDEX `fk_livro_has_genero_livro1_idx` ON `biblioteca`.`livro_has_genero` (`livro_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`emprestimos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`emprestimos` (
  `usuario_id` INT NOT NULL,
  `livro_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`, `livro_id`),
  CONSTRAINT `fk_usuario_has_livro_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `biblioteca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_livro_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `biblioteca`.`livro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_has_livro_livro1_idx` ON `biblioteca`.`emprestimos` (`livro_id` ASC);

CREATE INDEX `fk_usuario_has_livro_usuario1_idx` ON `biblioteca`.`emprestimos` (`usuario_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`autor_has_livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`autor_has_livro` (
  `autor_id` INT NOT NULL,
  `livro_id` INT NOT NULL,
  PRIMARY KEY (`autor_id`, `livro_id`),
  CONSTRAINT `fk_autor_has_livro_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `biblioteca`.`autor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autor_has_livro_livro1`
    FOREIGN KEY (`livro_id`)
    REFERENCES `biblioteca`.`livro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_autor_has_livro_livro1_idx` ON `biblioteca`.`autor_has_livro` (`livro_id` ASC);

CREATE INDEX `fk_autor_has_livro_autor1_idx` ON `biblioteca`.`autor_has_livro` (`autor_id` ASC);


-- -----------------------------------------------------
-- Table `biblioteca`.`espera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`espera` (
  `usuario_id` INT NOT NULL,
  `livro_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`, `livro_id`),
  CONSTRAINT `fk_usuario_has_livro_usuario2`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `biblioteca`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_livro_livro2`
    FOREIGN KEY (`livro_id`)
    REFERENCES `biblioteca`.`livro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_has_livro_livro2_idx` ON `biblioteca`.`espera` (`livro_id` ASC);

CREATE INDEX `fk_usuario_has_livro_usuario2_idx` ON `biblioteca`.`espera` (`usuario_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;