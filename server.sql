-- Connect to MySQL server
mysql -u <username> -p<password>

-- Create the database
CREATE DATABASE <database_name>;

-- Select the database
USE <database_name>;

-- Create the User table
CREATE TABLE User (
  Id INT PRIMARY KEY,
  Username VARCHAR(255),
  Password VARCHAR(255)
);

-- Create the Role table
CREATE TABLE Role (
  id INT PRIMARY KEY,
  role_name VARCHAR(255)
);

-- Create the User Role table
CREATE TABLE UserRole (
  id INT PRIMARY KEY,
  user_id INT,
  role_id INT
);

-- Create the Student Information table
CREATE TABLE Student (
  ID INT PRIMARY KEY,
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

-- Create the Personal Summary table
CREATE TABLE PersonalSummary (
  ID INT PRIMARY KEY,
  StudentId INT,
  PersonalSummaryContent TEXT
);

-- Create the Volunteer Service table
CREATE TABLE VolunteerService (
  ID INT PRIMARY KEY,
  StudentId INT,
  VolunteerServiceContent TEXT
);

-- Create the Research Information table
CREATE TABLE Research (
  ID INT PRIMARY KEY,
  StudentId INT,
  ResearchContent TEXT
);

-- Create the Student Leadership Positions table
CREATE TABLE StudentLeadership (
  ID INT PRIMARY KEY,
  StudentId INT,
  StudentLeadershipContent TEXT
);

-- Create the Social Practice table
CREATE TABLE SocialPractice (
  ID INT PRIMARY KEY,
  StudentId INT,
  SocialPracticeContent TEXT
);

-- Create the Grade Summary table
CREATE TABLE GradeSummary (
  ID INT PRIMARY KEY,
  StudentId INT,
  SocialPracticeGrade FLOAT,
  ResearchGrade FLOAT,
  VolunteerServiceGrade FLOAT,
  AcademicGrade FLOAT,
  StudentLeadershipGrade FLOAT,
  PersonalSummaryGrade FLOAT,
  SumGrade FLOAT
);
