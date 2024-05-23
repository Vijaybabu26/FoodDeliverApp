create database FoodDeliveryApp;
use FoodDeliveryApp;

CREATE TABLE User_Details (
    User_Id INT AUTO_INCREMENT,
    User_Name VARCHAR(50),
    Password VARCHAR(100),
    Email_Id VARCHAR(100),
    Phone_No VARCHAR(20),
    Address VARCHAR(250),
    Profile_Picture BLOB,
    Registration_Date DATE,
    PRIMARY KEY (User_Id)
);

CREATE TABLE Restaurant_Details (
    Restaurant_Id INT AUTO_INCREMENT,
    Restaurant_Name VARCHAR(100),
    Restaurant_Description VARCHAR(300),
    Restaurant_Address VARCHAR(250),
    Restaurant_Phone_No VARCHAR(20),
    Restaurant_Opening_Hours VARCHAR(10),
    Restaurant_Average_Rating VARCHAR(10),
    Restaurant_Delivery_Fee DOUBLE(12 , 2 ),
    Restaurant_Logo BLOB,
    PRIMARY KEY (Restaurant_Id)
);

CREATE TABLE Menu_Items (
    Item_Id INT AUTO_INCREMENT,
    Restaurant_Id INT,
    Item_Name VARCHAR(100),
    Item_Description VARCHAR(300),
    Item_Price DOUBLE(12 , 2 ),
    Category VARCHAR(30),
    Item_Available ENUM('AVAILABLE', 'NOT AVAILABLE'),
    Item_Image BLOB,
    PRIMARY KEY (Item_Id),
    FOREIGN KEY (Restaurant_Id)
        REFERENCES Restaurant_Details (Restaurant_Id)
);

CREATE TABLE Order_Details (
    Order_Id VARCHAR(100),
    User_Id INT,
    Restaurant_Id INT,
    Order_Date DATETIME,
    Total_Amount DOUBLE(12 , 2 ),
    Delivery_Address VARCHAR(300),
    Order_Status ENUM('CONFIRMED', 'DELIVERED', 'PENDING'),
    Delivery_Time DATETIME,
    PRIMARY KEY (Order_Id),
    FOREIGN KEY (Restaurant_Id)
        REFERENCES Restaurant_Details (Restaurant_Id),
    FOREIGN KEY (User_Id)
        REFERENCES User_Details (User_Id)
);

CREATE TABLE Order_Items (
    Order_Item_Id INT AUTO_INCREMENT,
    Order_Id VARCHAR(100),
    Item_Id INT,
    Order_Quantity INT,
    Order_Price DOUBLE(12 , 2 ),
    Order_Special_Description VARCHAR(300),
    PRIMARY KEY (Order_Item_Id),
    FOREIGN KEY (Order_Id)
        REFERENCES Order_Details (Order_Id),
    FOREIGN KEY (Item_Id)
        REFERENCES Menu_Items (Item_Id)
);

CREATE TABLE Payment_Details (
    Payment_Id VARCHAR(100),
    User_Id INT,
    Order_Id VARCHAR(100),
    Payment_Date DATETIME,
    Amount DOUBLE(12 , 2 ),
    Payment_Method VARCHAR(30),
    Transaction_Id VARCHAR(100),
    PRIMARY KEY (Payment_Id),
    FOREIGN KEY (User_Id)
        REFERENCES User_Details (User_Id),
    FOREIGN KEY (Order_Id)
        REFERENCES Order_Details (Order_Id)
);

CREATE TABLE Delivery_Details (
    Delivery_Id VARCHAR(100),
    Order_Id VARCHAR(100),
    Delivery_Driver_Id INT,
    Delivery_Status ENUM('PENDING', 'IN TRANSIT', 'DELIVERED'),
    Delivery_Date DATETIME,
    Estimated_Time_Arrival TIME,
    Actual_Time_Arrival TIME,
    FOREIGN KEY (Delivery_Driver_Id)
        REFERENCES Delivery_Partner_Details (Delivery_Partner_Id),
    FOREIGN KEY (Order_Id)
        REFERENCES Order_Details (Order_Id)
);

CREATE TABLE Delivery_Partner_Details (
    Delivery_Partner_Id INT AUTO_INCREMENT,
    Delivery_Partner_Name VARCHAR(100),
    Delivery_Partner_Email_Id VARCHAR(250),
    Delivery_Partner_Phone_No VARCHAR(20),
    Delivery_Partner_Vechical_Type VARCHAR(50),
    Delivery_Partner_CurrLocation VARCHAR(200),
    PRIMARY KEY (Delivery_Partner_Id)
);
