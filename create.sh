#!/bin/bash

# Define the credentials and database name
username="<username>"
password="<password>"
database_name="studentdb"

# Run the MySQL commands
mysql -u $username -p$password <<EOF
CREATE DATABASE $database_name;
USE $database_name;

CREATE TABLE User (
  Id INT PRIMARY KEY AUTO_INCREMENT,
  Username VARCHAR(255),
  Password VARCHAR(255)
);

CREATE TABLE Role (
  id INT PRIMARY KEY AUTO_INCREMENT,
  role_name VARCHAR(255)
);

CREATE TABLE UserRole (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  role_id INT
);

CREATE TABLE Student (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  UserId INT,
  Name VARCHAR(255),
  StudentNumber VARCHAR(255),
  Gender VARCHAR(255),
  PhoneNumber VARCHAR(255),
  Email VARCHAR(255),
  Year INT,
  AcademyDictionary VARCHAR(255),
  MajorDictionary VARCHAR(255),
  PoliticalStatusDictionary VARCHAR(255),
  StudentTypeDictionary VARCHAR(255)
);

CREATE TABLE PersonalSummary (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  StudentId INT,
  PersonalSummaryContent TEXT
);

CREATE TABLE VolunteerService (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  StudentId INT,
  VolunteerServiceContent TEXT
);

CREATE TABLE Research (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  StudentId INT,
  ResearchContent TEXT
);

CREATE TABLE StudentLeadership (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  StudentId INT,
  StudentLeadershipContent TEXT
);

CREATE TABLE SocialPractice (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  StudentId INT,
  SocialPracticeContent TEXT
);

CREATE TABLE GradeSummary (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  StudentId INT,
  SocialPracticeGrade FLOAT,
  ResearchGrade FLOAT,
  VolunteerServiceGrade FLOAT,
  AcademicGrade FLOAT,
  StudentLeadershipGrade FLOAT,
  PersonalSummaryGrade FLOAT,
  SumGrade FLOAT
);
EOF
