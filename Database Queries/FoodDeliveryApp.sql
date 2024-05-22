create database FoodDeliveryApp;
use FoodDeliveryApp;

Create table User_Details(
User_Id int auto_increment,
User_Name Varchar(50),
Password Varchar(100),
Email_Id Varchar(100),
Phone_No Varchar(20),
Address Varchar(250),
Profile_Picture blob,
Registration_Date date,
primary key (User_Id)
);

Create table Restaurant_Details(
Restaurant_Id int auto_increment,
Restaurant_Name varchar(100),
Restaurant_Description varchar(300),
Restaurant_Address varchar(250),
Restaurant_Phone_No varchar(20),
Restaurant_Opening_Hours varchar(10),
Restaurant_Average_Rating varchar(10),
Restaurant_Delivery_Fee double(12,2),
Restaurant_Logo blob,
primary key(Restaurant_Id)
);

create table Menu_Items(
Item_Id int auto_increment,
Restaurant_Id int,
Item_Name Varchar(100),
Item_Description varchar(300),
Item_Price double(12,2),
Category varchar(30),
Item_Available enum('AVAILABLE','NOT AVAILABLE'),
Item_Image Blob,
primary key (Item_Id),
foreign key(Restaurant_Id) references Restaurant_Details(Restaurant_Id)
);

create table Order_Details(
Order_Id varchar(100),
User_Id int,
Restaurant_Id int,
Order_Date datetime,
Total_Amount double(12,2),
Delivery_Address varchar(300),
Order_Status enum('CONFIRMED','DELIVERED','PENDING'),
Delivery_Time datetime,
primary key(Order_Id),
foreign key(Restaurant_Id) references Restaurant_Details(Restaurant_Id),
foreign key(User_Id) references User_Details(User_Id)
);

create table Order_Items(
Order_Item_Id int auto_increment,
Order_Id varchar(100),
Item_Id int,
Order_Quantity int,
Order_Price double(12,2),
Order_Special_Description varchar(300),
primary key(Order_Item_Id),
foreign key(Order_Id) references Order_Details(Order_Id),
foreign key(Item_Id) references Menu_Items(Item_Id)
);

create table Payment_Details(
Payment_Id varchar(100),
User_Id int,
Order_Id varchar(100),
Payment_Date datetime,
Amount double(12,2),
Payment_Method Varchar(30),
Transaction_Id varchar(100),
primary key (Payment_Id),
foreign key(User_Id) references User_Details(User_Id),
foreign key(Order_Id) references Order_Details(Order_Id)
);

Create table Delivery_Details(
Delivery_Id varchar(100),
Order_Id varchar(100),
Delivery_Driver_Id int,
Delivery_Status enum('PENDING','IN TRANSIT','DELIVERED'),
Delivery_Date datetime,
Estimated_Time_Arrival time,
Actual_Time_Arrival time,
foreign key(Delivery_Driver_Id) references Delivery_Partner_Details(Delivery_Partner_Id),
foreign key(Order_Id) references Order_Details(Order_Id)
);

create table Delivery_Partner_Details(
Delivery_Partner_Id int auto_increment,
Delivery_Partner_Name varchar(100),
Delivery_Partner_Email_Id varchar(250),
Delivery_Partner_Phone_No varchar(20),
Delivery_Partner_Vechical_Type Varchar(50),
Delivery_Partner_CurrLocation varchar(200),
primary key(Delivery_Partner_Id)
);