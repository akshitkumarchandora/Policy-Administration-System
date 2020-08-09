CREATE TABLE Consumer(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    DOB VARCHAR(20) NOT NULL,
    Business_Name VARCHAR(50) NOT NULL,
    PAN_Details VARCHAR(12) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Phone VARCHAR(10) NOT NULL,
    Website VARCHAR(40) NOT NULL,
    Business_Overview VARCHAR(150) NOT NULL,
    Validity_of_Consumer VARCHAR(30) NOT NULL,
    Agent_Name VARCHAR(50) NOT NULL,
    Agent_ID  BIGINT NOT NULL
  
);

CREATE TABLE Property(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	Business_ID BIGINT NOT NULL,
    Consumer_ID BIGINT NOT NULL,
    Insurance_Type VARCHAR(30) NOT NULL,
    Building_Sqft VARCHAR(30) NOT NULL,
    Building_Type VARCHAR(7) NOT NULL,
    Building_Storeys VARCHAR(10) NOT NULL,
    Building_Age BIGINT NOT NULL,
    Property_Value BIGINT NOT NULL,
    Cost_of_the_asset BIGINT NOT NULL,
    Salvage_value BIGINT NOT NULL,
    Useful_Life_of_the_Asset BIGINT NOT NULL
);

create table Business(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY, 
	Consumer_ID BIGINT NOT NULL,
	Business_Category VARCHAR(40) NOT NULL,
	Business_Type VARCHAR(40) NOT NULL,
	Business_Turnover BIGINT NOT NULL,
	Capital_Invested BIGINT NOT NULL,
	Total_Employees BIGINT NOT NULL,
	Business_Value BIGINT NOT NULL,
	Business_Age BIGINT NOT NULL
);

CREATE TABLE Business_Master (
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Business_Category  VARCHAR(40) NOT NULL,
Business_Type  VARCHAR(40) NOT NULL,
Total_Employees BIGINT NOT NULL,
Business_age BIGINT NOT NULL
);


CREATE TABLE Property_Master(
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Insurance_Type varchar(30) NOT NULL,
Property_Type varchar(30) NOT NULL,
Building_Type varchar(7) NOT NULL,
Building_Age BIGINT NOT NULL
);


	
