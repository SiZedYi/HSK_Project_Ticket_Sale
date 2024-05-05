use master

drop database CinemaDatabase

create database CinemaDatabase

use CinemaDatabase

create table TaiKhoan(
	maTK nvarchar(20) primary key,
	tenDangNhap nvarchar(50),
	matKhau nvarchar(50),
	nhanVien nvarchar(20),
	quyen nvarchar(20),
)

create table NhanVien(
	maNV nvarchar(20) primary key,
	tenNV nvarchar(50),
	gioiTinh nvarchar(20),
	ngaySinh Date,
	cccd nvarchar(20),
	noiCuTru nvarchar(50),
	sdt nvarchar(20),
	trinhDo nvarchar(20),
	email nvarchar(50),
	ngayTuyenDung Date,
	luong float,
	quanLy nvarchar(20),
)

create table Rap(
	maRap nvarchar(20) primary key,
	tenRap nvarchar(50),
	diaChi nvarchar(50),
	sdtRap nvarchar(20)
)

create table PhongChieu(
	maPC nvarchar(20) primary key,
	tenPC nvarchar(50),
	loaiPC nvarchar(20),
	rap nvarchar(20)
)

create table Phim(
	maPhim nvarchar(20) primary key,
	tenPhim nvarchar(50),
	trangThai nvarchar(20),
	gia float,
	theLoai nvarchar(50),
	gioiHanTuoi nvarchar(20),
	hinhAnh nvarchar(50)
)

create table Ghe(
	maGhe nvarchar(20) primary key,
	loaiGhe nvarchar(20),
	giaGhe float(20),
	coTheDat bit,
	phongChieu nvarchar(20)
)

create table SuatChieu(
	maSC nvarchar(20) primary key,
	thoiGianBatDau DateTime,
	thoiGianKetThuc DateTime,
	phim nvarchar(20),
	phongChieu nvarchar(20)
)


create table Ve(
	maVe nvarchar(20) primary key,
	thoiGianIn DateTime,
	phim nvarchar(20),
	suatChieu nvarchar(20),
	ghe nvarchar(20),
	phongChieu nvarchar(20),
	hoaDon nvarchar(20)
)

create table HoaDon(
	maHD nvarchar(20) primary key,
	soTien float,
	thoiGianXuat DateTime,
	phuongThucThanhToan nvarchar(20),
	nhanVienPhuTrach nvarchar(20)
)

alter table TaiKhoan
add constraint fk_nhanVien_TaiKhoan
foreign key (nhanVien) references NhanVien(maNV)

alter table NhanVien
add constraint fk_quanLy_NhanVien
foreign key (quanLy) references NhanVien(maNV)

alter table PhongChieu
add constraint fk_rap_PhongChieu
foreign key (rap) references Rap(maRap)

alter table SuatChieu
add constraint fk_phim_SuatChieu
foreign key (phim) references Phim(maPhim)

alter table SuatChieu
add constraint fk_phongChieu_SuatChieu
foreign key (phongChieu) references PhongChieu(maPC)

alter table Ghe
add constraint fk_phongChieu_Ghe
foreign key (phongChieu) references PhongChieu(maPC)

alter table Ve
add constraint fk_phim_Ve
foreign key (phim) references Phim(maPhim)

alter table Ve
add constraint fk_suatChieu_Ve
foreign key (suatChieu) references SuatChieu(maSC)

alter table Ve
add constraint fk_ghe_Ve
foreign key (ghe) references Ghe(maGhe)

alter table Ve
add constraint fk_phongChieu_Ve
foreign key (phongChieu) references PhongChieu(maPC)

alter table Ve
add constraint fk_hoaDon_Ve
foreign key (hoaDon) references HoaDon(maHD)

alter table HoaDon
add constraint fk_nhanVienPhuTrach_NhanVien
foreign key (nhanVienPhuTrach) references NhanVien(maNV)


-- Insert into NhanVien table
INSERT INTO NhanVien (maNV, tenNV, gioiTinh, ngaySinh, cccd, noiCuTru, sdt, trinhDo, email, ngayTuyenDung, luong, quanLy)
VALUES 
('NV001', N'Nguyễn Văn Hội', N'Nam', '1990-01-01', '123456789', N'Hà Nội', '1234567890', 'Bachelor', 'nv1@example.com', '2020-01-01', 10000000, NULL),
('NV002', N'Nguyễn Thi Thi', N'Nữ', '1995-05-05', '987654321', N'Sài Gòn', '0987654321', 'Bachelor', 'nv2@example.com', '2020-01-01', 9000000, 'NV001'),
('NV003', N'Trần Văn Cù', N'Nam', '1992-02-02', '456789123', N'Hải Phòng', '0123456789', 'Bachelor', 'nv3@example.com', '2020-01-01', 8500000, 'NV001'),
('NV004', N'Trần Thị Dực', N'Nữ', '1993-03-03', '654321987', N'Khánh Hòa', '0112233445', 'Bachelor', 'nv4@example.com', '2020-01-01', 8000000, 'NV002'),
('NV005', N'Hoàng Văn Em', N'Nam', '1994-04-04', '321654987', N'Phan Thiết', '0192837465', 'Bachelor', 'nv5@example.com', '2020-01-01', 7500000, 'NV002');

-- Insert into TaiKhoan table
INSERT INTO TaiKhoan (maTK, tenDangNhap, matKhau, nhanVien, quyen)
VALUES 
('TK001', 'username1', 'password1', 'NV001', N'Nhân viên'),
('TK002', 'username2', 'password2', 'NV002', N'Quản lý'),
('TK003', 'username3', 'password3', 'NV003', N'Nhân viên'),
('TK004', 'username4', 'password4', 'NV004', N'Nhân viên'),
('TK005', 'username5', 'password5', 'NV005', N'Nhân viên');

-- Insert into Rap table
INSERT INTO Rap (maRap, tenRap, diaChi, sdtRap)
VALUES 
('R001', N'Rạp 1', '123 ABC Street, Hanoi', '0123456789'),
('R002', N'Rạp 2', '456 XYZ Street, Hanoi', '0987654321'),
('R003', N'Rạp 3', '789 DEF Street, Hanoi', '0123456789'),
('R004', N'Rạp 4', '101 GHI Street, Hanoi', '0987654321'),
('R005', N'Rạp 5', '111 JKL Street, Hanoi', '0123456789');

-- Insert into PhongChieu table
INSERT INTO PhongChieu (maPC, tenPC, loaiPC, rap)
VALUES 
('PC001', N'Phòng 1', 'Cơ bản', 'R001'),
('PC002', N'Phòng 2', 'Cơ bản', 'R001'),
('PC003', N'Phòng 3', '4D', 'R002'),
('PC004', N'Phòng 4', 'Premium Cinema', 'R002'),
('PC005', N'Phòng 5', 'Premium Cinema', 'R003');

-- Insert into Phim table
INSERT INTO Phim (maPhim, tenPhim, trangThai, gia, theLoai, gioiHanTuoi, hinhAnh)
VALUES 
('P001', N'Phim 1', N'Đang chiếu', 100000, N'Hành động', 'K', 'phim1.jpg'),
('P002', N'Phim 2', N'Đang chiếu', 90000, N'Tình cảm', 'T13', 'phim2.jpg'),
('P003', N'Phim 3', N'Đang chiếu', 80000, N'Hài huớc', 'T16', 'phim3.jpg'),
('P004', N'Phim 4', N'Sắp chiếu', 95000, N'Lãng mạn', 'T18', 'phim4.jpg'),
('P005', N'Phim 5', N'Sắp chiếu', 85000, N'Hoạt hình', 'P', 'phim5.jpg');

-- Insert into Ghe table
INSERT INTO Ghe (maGhe, loaiGhe, giaGhe, coTheDat, phongChieu)
VALUES 
('G001', N'Ghế tiêu chuẩn', 50000, 1, 'PC001'),
('G002', N'Ghế VIP', 100000, 1, 'PC001'),
('G003', N'Ghế COUPLE', 50000, 1, 'PC002'),
('G004', N'Ghế COUPLE', 100000, 1, 'PC002'),
('G005', N'Ghế COUPLE', 50000, 1, 'PC003');

-- Insert into SuatChieu table
INSERT INTO SuatChieu (maSC, thoiGianBatDau, thoiGianKetThuc, phim, phongChieu)
VALUES 
('SC001', '2024-05-05 09:00:00', '2024-05-05 11:00:00', 'P001', 'PC001'),
('SC002', '2024-05-05 11:30:00', '2024-05-05 13:30:00', 'P002', 'PC002'),
('SC003', '2024-05-05 14:00:00', '2024-05-05 16:00:00', 'P003', 'PC003'),
('SC004', '2024-05-05 16:30:00', '2024-05-05 18:30:00', 'P004', 'PC004'),
('SC005', '2024-05-05 19:00:00', '2024-05-05 21:00:00', 'P005', 'PC005');

-- Insert into Ve table
INSERT INTO Ve (maVe, thoiGianIn, phim, suatChieu, ghe, phongChieu, hoaDon)
VALUES 
('V001', '2024-05-05 08:30:00', 'P001', 'SC001', 'G001', 'PC001', NULL),
('V002', '2024-05-05 11:00:00', 'P002', 'SC002', 'G003', 'PC002', NULL),
('V003', '2024-05-05 13:30:00', 'P003', 'SC003', 'G005', 'PC003', NULL),
('V004', '2024-05-05 16:00:00', 'P004', 'SC004', 'G002', 'PC004', NULL),
('V005', '2024-05-05 18:30:00', 'P005', 'SC005', 'G004', 'PC005', NULL);

-- Insert into HoaDon table
INSERT INTO HoaDon (maHD, soTien, thoiGianXuat, phuongThucThanhToan, nhanVienPhuTrach)
VALUES 
('HD001', 100000, '2024-05-05 09:30:00', N'MOMO', 'NV001'),
('HD002', 90000, '2024-05-05 12:00:00', N'Tiền mặt', 'NV002'),
('HD003', 80000, '2024-05-05 14:30:00', N'Thẻ ngân hàng', 'NV003'),
('HD004', 95000, '2024-05-05 17:00:00', N'VNPAY', 'NV004'),
('HD005', 85000, '2024-05-05 19:30:00', N'Zalo Pay', 'NV005');

Select * from Phim where gia = 100000

select * from Phim