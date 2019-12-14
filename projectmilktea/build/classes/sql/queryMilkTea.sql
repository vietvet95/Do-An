use master
go
create database DataMilkTeaManager
use DataMilkTeaManager
go

create table Position(
PositionID varchar(10),
PositionName nvarchar(50),
CONSTRAINT PK_Position  primary key(PositionID)
);
create table Employee(
EmpID varchar(10),
EmpName Nvarchar(50) not null,
EmpPass varchar(50) ,
PositionID varchar(10) not null,
EmpBirthday date not null,
EmpGender varchar(20) not null,
EmpPhoneNumber varchar(50) not null,
EmpAddress nvarchar(100) not null,
EmpEmail varchar(50),
EmpDayAtWork date,
CONSTRAINT PK_Emp primary key(EmpID),
CONSTRAINT FK_Emp foreign key(PositionID)
references Position(PositionID),
CONSTRAINT check_epmBirthday check (EmpBirthday < getdate()),
constraint check_EmpDayAtWork check (EmpBirthday < dateadd(year,-18,EmpDayAtWork)),
constraint check_EmpGender check(EmpGender = 'Female' or EmpGender = 'Male' or EmpGender ='third gender')
)
alter table Employee
ADD constraint check_EmpDayAtWork check (EmpBirthday < dateadd(year,-18,EmpDayAtWork))


create table Manager(
MngID varchar(10),
MngName Nvarchar(50) not null,
MngPass varchar(50) ,
PositionID varchar(10) not null,
MngBirthday date not null,
MngGender varchar(20) not null,
MngPhoneNumber varchar(50) not null,
MngAddress varchar(100) not null,
MngEmail varchar(50),
MngDayAtWork date,
CONSTRAINT PK_Mng primary key(MngID),
CONSTRAINT FK_Mng foreign key(PositionID)
references Position(PositionID),
CONSTRAINT check_MngBirthday check (MngBirthday < getdate()),
constraint check_MngDayAtWork check (MngBirthday < dateadd(year,-18,MngDayAtWork)),
constraint check_MngGender check(MngGender = 'Female' or MngGender = 'Male' or MngGender ='third gender')
)
create table productType(
productTypeID varchar(10),
productTypeName Nvarchar(50) not null,
constraint PK_productType primary key(productTypeID)
);
create table products(
productID varchar (10),
productName Nvarchar(50) not null,
productTypeID varchar(10) not null,
amountRemaining int,
price money not null,
constraint PK_product primary key(productID),
constraint FK_product foreign key (productTypeID)
references productType(productTypeID)
)
create table RawMaterial(
countRawMaterial int identity(1,1),
RMaterialID varchar(10),
RMaterialName Nvarchar(50),
DateAdded date,
RMaterialPrice money,
amountAdd int,
unit Nvarchar(50)
constraint PK_RawMaterial primary key (countRawMaterial)
)
create table Recipe(
countRecipe int identity(1,1),
productID varchar (10) not null,
RMaterialID varchar(10) not null,
amountMaterial int not null,
constraint PK_Recipe primary key (countRecipe),
constraint FK_ProductRecipe foreign key (productID)
references products(productID)
);
create table Combo(
countCombo int identity(1,1),
ComboID varchar(10) not null,
productID varchar (10) not null,
ComboName Nvarchar(50) not null,
amountProduct int,
discountCombo float not null,
constraint PK_combo primary key (countCombo),
constraint FK_combo foreign key (productID)
references products(productID)
);
create table FOP (
FOPID varchar(10),
FOPName Nvarchar(50),
constraint PK_FOP primary key (FOPID)
)
create table ProductPromotion(
ProductPromotionID varchar (10),
FOPID varchar(10) not null,
discount float not null,
datePromotionStart date,
datePromotionEnd date,
constraint PK_ProductPromotion primary key (ProductPromotionID),
constraint FK_PPFOP foreign key (FOPID)
references FOP(FOPID)
)
create table Orders(
OrderID varchar(50) not null,
EmpID varchar(10) not null,
OrderDay date not null,
constraint PK_Order primary key(OrderID),
constraint FK_OrE foreign key(EmpID)
references Employee(EmpID)
)
create table OrderDetails (
OrderDetailID int identity(1,1),
productID  varchar (10) not null,
ComboID varchar(10) not null,
OrderID varchar(50) not null,
amount int not null,
ProductPromotionID varchar (10) not null,
constraint PK_OrderDetails primary key (OrderDetailID)
)

insert into productType (productTypeID,productTypeName)
values ('PT01',N'Trà sữa'),
('PT02',N'Ăn vặt'),
('PT03',N'Sữa tươi')
insert into products(productID,productName,productTypeID,amountRemaining,price)
values('P01',N'Sữa tươi trân châu đường đen','PT03',50,29000),
('P02',N'Trà sữa socola truyền thống','PT01',30,21000),
('P03',N'Trà sữa Thái xanh truyền thống','PT01',50,29000),
('P04',N'Hồ lô','PT02',50,30000),
('P05',N'Cá viên chiên','PT02',50,19000)
//selete giá combo

select ComboID,ComboName,sum(priceCombo) as'pricecombo',discountCombo  from (
select ComboID,ComboName,(cb.amountProduct * p.price *(1 - cb.discountCombo)) as 'priceCombo',discountCombo from Combo cb 
join products p ON p.productID=cb.productID) as temp
group by ComboName,ComboID,discountCombo


select  from Combo join (
select cb.ComboName from Combo cb
join products p On p.productID = cb.productID
group by cb.ComboName) as Temp on Combo.ComboName = Temp.ComboName

select * from combo

select p.productID,P.productName,cb.amountProduct from products p 
JOIN Combo cb ON p.productID=cb.productID WHERE Cb.ComboID = 'CB01'

INSERT INTO FOP
VALUES('F01','Cai Gi Day'),
	  ('F02','Khong Biet Nua')
INSERT INTO ProductPromotion
VALUES('PP01','F01',0.2,'2019-11-11'),
	  ('PP02','F02',0.15,'2019-11-11')


select FOPID,FOPName from FOP 

select ProductPromotionID,discount,datePromotionStart,datePromotionStart from ProductPromotion

insert into FOP (FOPID,FOPName) 
values ('F04','Tết Nguyên Đán'),
('F05','Tết Tây'),
('F06','Ngưu Lang Chức Nữ'),
('F07','Tết Nguyên Tiêu')

INSERT INTO ProductPromotion(ProductPromotionID,FOPID,discount,datePromotionStart,datePromotionEnd)
values ('PP123','F05',0.14,'2019-11-11','2019-12-11')

select ProductPromotionID,discount,datePromotionStart,datePromotionEnd from ProductPromotion where ProductPromotionID = 'PP01'


insert into RawMaterial (RMaterialID,RMaterialName,amountAdd,RMaterialPrice,DateAdded,unit)
values ('RM01',N'Đường',45,23000,'2019-12-8','ký'),
('RM02',N'Sữa đặc',100,39000,'2019-12-8','lon'),
('RM03',N'Trân châu đen',45,30000,'2019-12-8','gói'),
('RM04',N'cà phê trung nguyên(bột)',35,49000,'2019-12-8','gói'),
('RM05',N'kem',99,6000,'2019-12-8','ký')

select RMaterialID,RMaterialName,amountAdd,RMaterialPrice,DateAdded,unit from RawMaterial 
select distinct DateAdded from RawMaterial

insert into Recipe(productID,RMaterialID,amountMaterial)
values('P01','RM01',3),
('P01','RM03',8),
('P01','RM998',2),
('P01','RM119',3),
('P02','RM03',5),
('P02','RM01',9),
('P03','RM998',6),
('P03','RM119',3)

select distinct r.productID,p.productName from Recipe r join products p ON r.productID = p.productID

select p.productID,P.productName,cb.amountProduct from products p 
JOIN Combo cb ON p.productID=cb.productID WHERE Cb.ComboID = 'CB01'




select rm.RMaterialID,rm.RMaterialName,r.amountMaterial,rm.unit
 from Recipe r join RawMaterial rm on r.RMaterialID = rm.RMaterialID where r.productID = 'P01'

 insert into Orders(OrderID,EmpID,OrderDay,TotalPrice) values
('OD01','NV01','2019-6-12',10000000),
('OD02','NV02','2019-6-11',8982620),
('OD03','NV02','2019-6-10',48123184152)
insert into OrderDetails(productID,OrderID,ComboID,amount,ProductPromotionID)values
('','OD01','CB556','2','PID01'),
('P01','OD01','CB112','2','PID02'),
('P01','OD02','CB004','2','PID01'),
('P02','OD02','C0','2','PID02')

select od.OrderID,od.amount , p.productID,p.price,o.OrderDay,e.EmpName,cb.ComboID from OrderDetails od join products p 
 ON p.productID=od.productID join Orders o on o.OrderID=od.OrderID join Employee e on e.EmpID=o.EmpID join Combo cb 
 on cb.productID=p.productID WHERE od.OrderID ='O002'
