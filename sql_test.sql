create database testdemo;

create table customers (
	id int auto_increment primary key,
	fullname varchar(50),
	address varchar(255),
	salary float,
	dob DATE,
	gender bit default 1
);

INSERT INTO customers (fullname, address, salary, dob, gender) VALUES
('Nguyễn Văn A', 'Hà Nội', 5000.00, '1990-01-01', 1),
('Trần Văn B', 'Đà Nẵng', 5500.00, '1991-02-02', 1),
('Lê Thị C', 'Hồ Chí Minh', 6000.00, '1992-03-03', 0),
('Phạm Văn D', 'Cần Thơ', 5200.00, '1993-04-04', 1),
('Vũ Thị E', 'Hải Phòng', 5300.00, '1994-05-05', 0),
('Đặng Văn F', 'Quảng Ninh', 5100.00, '1995-06-06', 1),
('Bùi Thị G', 'Nghệ An', 5400.00, '1996-07-07', 0),
('Ngô Văn H', 'Thừa Thiên Huế', 5700.00, '1997-08-08', 1),
('Dương Thị I', 'Khánh Hòa', 5600.00, '1998-09-09', 0),
('Lưu Văn J', 'Lâm Đồng', 5800.00, '1999-10-10', 1);


select * from testdemo.customers c2;



