-- MySQL Script generated by MySQL Workbench
-- 12/02/14 22:16:00
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TEdASCoreDev
-- -----------------------------------------------------
-- Development DB for project TEd@S
DROP SCHEMA IF EXISTS `TEdASCoreDev` ;
CREATE SCHEMA IF NOT EXISTS `TEdASCoreDev` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema TEdASUserDEV
-- -----------------------------------------------------
USE `TEdASCoreDev` ;

-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_User` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_User` (
  `UserID` INT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `Address2` VARCHAR(45) NULL,
  `Address3` VARCHAR(45) NULL,
  `Address4` VARCHAR(45) NULL,
  `Postcode` VARCHAR(45) NOT NULL,
  `PersonalPhone` INT NULL,
  `PersonalMobile` INT NULL,
  `WorkEmail` VARCHAR(45) NULL,
  `PersonalEmail` VARCHAR(45) NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  `LastUpdated` DATE NOT NULL,
  PRIMARY KEY (`UserID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Roles` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Roles` (
  `RoleID` INT NULL,
  `RoleName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RoleID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_UserRoles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_UserRoles` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_UserRoles` (
  `RoleID` INT NOT NULL,
  `UserID` INT NOT NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  `LastUpdated` DATE NOT NULL,
  PRIMARY KEY (`RoleID`, `UserID`),
  INDEX `FK_Role_User_idx` (`UserID` ASC),
  CONSTRAINT `FK_User_Role`
    FOREIGN KEY (`RoleID`)
    REFERENCES `TEdASCoreDev`.`TB_Roles` (`RoleID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Role_User`
    FOREIGN KEY (`UserID`)
    REFERENCES `TEdASCoreDev`.`TB_User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_StudentExtraDetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_StudentExtraDetails` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_StudentExtraDetails` (
  `StudentID` INT NOT NULL,
  `EnglishLanguage` INT NULL,
  `IT` INT NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  `LastUpdated` DATE NOT NULL,
  PRIMARY KEY (`StudentID`),
  CONSTRAINT `FK_StudentEx`
    FOREIGN KEY (`StudentID`)
    REFERENCES `TEdASCoreDev`.`TB_User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Semester`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Semester` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Semester` (
  `SemesterID` INT NOT NULL,
  `StartDate` DATE NOT NULL,
  `EndDate` DATE NOT NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`SemesterID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_ExcludeDates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_ExcludeDates` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_ExcludeDates` (
  `SemesterID` INT NOT NULL,
  `ExcludeDate` DATE NOT NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`SemesterID`, `ExcludeDate`),
  CONSTRAINT `FK_Semester`
    FOREIGN KEY (`SemesterID`)
    REFERENCES `TEdASCoreDev`.`TB_Semester` (`SemesterID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Category` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Category` (
  `Cat_ID` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(45) NOT NULL,
  `CategoryNotes` VARCHAR(255) NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`Cat_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_ResourceFlags`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_ResourceFlags` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_ResourceFlags` (
  `AllocationID` INT NOT NULL,
  `ResourceReq` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AllocationID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Courses` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Courses` (
  `Category` INT NOT NULL,
  `Course_ID` INT NOT NULL AUTO_INCREMENT,
  `CourseName` VARCHAR(45) NOT NULL,
  `AcredBody` VARCHAR(45) NULL,
  `Level` VARCHAR(45) NULL,
  `RequiresResourceFlag` INT NOT NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  PRIMARY KEY (`Course_ID`),
  INDEX `FK_CatCourse_idx` (`Category` ASC),
  INDEX `FK_ResCourse_idx` (`RequiresResourceFlag` ASC),
  CONSTRAINT `FK_CatCourse`
    FOREIGN KEY (`Category`)
    REFERENCES `TEdASCoreDev`.`TB_Category` (`Cat_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ResCourse`
    FOREIGN KEY (`RequiresResourceFlag`)
    REFERENCES `TEdASCoreDev`.`TB_ResourceFlags` (`AllocationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Tutor_Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Tutor_Courses` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Tutor_Courses` (
  `TutorID` INT NOT NULL,
  `CourseID` INT NOT NULL,
  `TutorCourseID` INT NOT NULL AUTO_INCREMENT,
  `SemesterID` INT NOT NULL,
  `LastUpdated` DATE NOT NULL,
  INDEX `FK_TC_Course_idx` (`CourseID` ASC),
  INDEX `FK_TC_Semester_idx` (`SemesterID` ASC),
  PRIMARY KEY (`TutorCourseID`),
  CONSTRAINT `FK_TC_Tutor`
    FOREIGN KEY (`TutorID`)
    REFERENCES `TEdASCoreDev`.`TB_User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TC_Semester`
    FOREIGN KEY (`SemesterID`)
    REFERENCES `TEdASCoreDev`.`TB_Semester` (`SemesterID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TC_Course`
    FOREIGN KEY (`CourseID`)
    REFERENCES `TEdASCoreDev`.`TB_Courses` (`Course_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Room` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Room` (
  `Room_ID` INT NOT NULL,
  `RoomName` VARCHAR(45) NULL,
  `RoomCapacity` INT NULL,
  `PCQty` INT NULL,
  PRIMARY KEY (`Room_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_RoomType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_RoomType` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_RoomType` (
  `RoomTypeID` INT NOT NULL,
  `RoomType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RoomTypeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_TimeTable`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_TimeTable` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_TimeTable` (
  `Day` INT NOT NULL,
  `Start` TIME NOT NULL,
  `Finish` TIME NULL,
  `TutorCourse` INT NOT NULL,
  `RoomID` INT NOT NULL,
  `Archived` BIT NOT NULL,
  PRIMARY KEY (`Day`, `Start`, `TutorCourse`, `RoomID`),
  INDEX `FK_TimeTable_Room_idx` (`RoomID` ASC),
  INDEX `FK_TimeTable_TC_idx` (`TutorCourse` ASC),
  CONSTRAINT `FK_TimeTable_TC`
    FOREIGN KEY (`TutorCourse`)
    REFERENCES `TEdASCoreDev`.`TB_Tutor_Courses` (`TutorCourseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_TimeTable_Room`
    FOREIGN KEY (`RoomID`)
    REFERENCES `TEdASCoreDev`.`TB_Room` (`Room_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Student_Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Student_Courses` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Student_Courses` (
  `Student_ID` INT NOT NULL,
  `TutorCourseID` INT NOT NULL,
  `Grade` VARCHAR(45) NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  `LastUpdated` DATE NOT NULL,
  PRIMARY KEY (`Student_ID`, `TutorCourseID`),
  INDEX `FK_SC_TutorCID_idx` (`TutorCourseID` ASC),
  CONSTRAINT `FK_SC_StudentID`
    FOREIGN KEY (`Student_ID`)
    REFERENCES `TEdASCoreDev`.`TB_User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_SC_TutorCID`
    FOREIGN KEY (`TutorCourseID`)
    REFERENCES `TEdASCoreDev`.`TB_Tutor_Courses` (`TutorCourseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_Assignment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_Assignment` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_Assignment` (
  `AssignmentID` INT NOT NULL,
  `TutorCourseID` INT NOT NULL,
  `AssignmentName` VARCHAR(45) NOT NULL,
  `AssignmentDescription` VARCHAR(255) NULL,
  `LastUpdated` DATE NOT NULL,
  PRIMARY KEY (`AssignmentID`),
  INDEX `FK_Assign_TCId_idx` (`TutorCourseID` ASC),
  CONSTRAINT `FK_Assign_TCId`
    FOREIGN KEY (`TutorCourseID`)
    REFERENCES `TEdASCoreDev`.`TB_Tutor_Courses` (`TutorCourseID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TEdASCoreDev`.`TB_UserInterests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TEdASCoreDev`.`TB_UserInterests` ;

CREATE TABLE IF NOT EXISTS `TEdASCoreDev`.`TB_UserInterests` (
  `UserID` INT NOT NULL,
  `Interest` VARCHAR(255) NOT NULL,
  `Archived` BIT NOT NULL DEFAULT 0,
  `LastUpdated` DATE NOT NULL,
  INDEX `FK_UserInt_idx` (`UserID` ASC),
  CONSTRAINT `FK_UserInt`
    FOREIGN KEY (`UserID`)
    REFERENCES `TEdASCoreDev`.`TB_User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
