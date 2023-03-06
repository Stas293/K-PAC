-- -----------------------------------------------------
-- Schema k-pac
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `k-pac` DEFAULT CHARACTER SET utf8 collate utf8_unicode_ci;
USE `k-pac` ;

-- -----------------------------------------------------
-- Table `k-pac`.`knowledge_package`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `k-pac`.`knowledge_package` ;

CREATE TABLE IF NOT EXISTS `k-pac`.`knowledge_package` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(250) NOT NULL,
  `description` VARCHAR(2000) NOT NULL,
  `creation` DATE NOT NULL DEFAULT(CURRENT_DATE),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `k-pac`.`knowledge_package_set`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `k-pac`.`knowledge_package_set` ;

CREATE TABLE IF NOT EXISTS `k-pac`.`knowledge_package_set` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `k-pac`.`knowledge_package_has_knowledge_package_set`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `k-pac`.`knowledge_package_has_knowledge_package_set` ;

CREATE TABLE IF NOT EXISTS `k-pac`.`knowledge_package_has_knowledge_package_set` (
  `knowledge_package_id` BIGINT(20) UNSIGNED NOT NULL,
  `knowledge_package_set_id` BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`knowledge_package_id`, `knowledge_package_set_id`),
  INDEX `fk_knowledge_package_has_knowledge_package_set_knowledge_pa_idx` (`knowledge_package_set_id` ASC) VISIBLE,
  INDEX `fk_knowledge_package_has_knowledge_package_set_knowledge_pa_idx1` (`knowledge_package_id` ASC) VISIBLE,
  CONSTRAINT `fk_knowledge_package_has_knowledge_package_set_knowledge_pack`
    FOREIGN KEY (`knowledge_package_id`)
    REFERENCES `k-pac`.`knowledge_package` (`id`)
    ON DELETE cascade
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_knowledge_package_has_knowledge_package_set_knowledge_pack1`
    FOREIGN KEY (`knowledge_package_set_id`)
    REFERENCES `k-pac`.`knowledge_package_set` (`id`)
    ON DELETE cascade
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
