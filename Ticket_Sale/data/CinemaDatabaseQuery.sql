

create database CinemaDatabase
go


use CinemaDatabase
go

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
	ngaySinh Date,
	cccd nvarchar(20),
	noiCuTru nvarchar(50),
	sdt nvarchar(20),
	trinhDo nvarchar(20),
	email nvarchar(50),
	ngayTuyenDung Date,
	luong decimal(10,2),
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
	gia decimal(10,2),
	theLoai nvarchar(50),
	gioiHanTuoi nvarchar(20),
	hinhAnh nvarchar(50)
)

create table Ghe(
	maGhe nvarchar(20) primary key,
	loaiGhe nvarchar(20),
	giaGhe decimal(20),
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
	soTien decimal(10,2),
	thoiGianXuat DateTime,
	phuongThucThanhToan nvarchar(20),
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

INSERT INTO HoaDon (maHD, soTien, thoiGianXuat, phuongThucThanhToan)
VALUES
    ('HD001', 100.50, '2024-05-04 10:30:00', 'MOMO'),
    ('HD002', 75.20, '2024-05-04 11:15:00', 'VNPAY'),
    ('HD003', 120.80, '2024-05-04 12:00:00', 'Zalo Pay'),
    ('HD004', 50.00, '2024-05-04 13:45:00', 'VNPAY'),
    ('HD005', 89.75, '2024-05-04 14:30:00', 'MOMO'),
    ('HD006', 65.30, '2024-05-04 15:20:00', 'Tiền mặt'),
    ('HD007', 150.00, '2024-05-04 16:10:00', 'Thẻ ngân hàng'),
    ('HD009', 78.90, '2024-05-04 18:30:00', 'MOMO'),
    ('HD010', 95.40, '2024-05-04 19:15:00', 'MOMO');

﻿-- TaiKhoan
INSERT INTO TaiKhoan (maTK, tenDangNhap, matKhau, nhanVien, quyen) VALUES
('TK001', 'user1', 'password1', 'NV001', 'admin'),
('TK002', 'user2', 'password2', 'NV002', 'staff'),
('TK003', 'user3', 'password3', 'NV003', 'staff');

-- NhanVien
INSERT INTO NhanVien (maNV, tenNV, ngaySinh, cccd, noiCuTru, sdt, trinhDo, email, ngayTuyenDung, luong, quanLy) VALUES
('NV001', N'Nguyen Van A', '1990-01-01', '123456789', 'Hanoi', '123456789', 'Bachelor', 'nvA@example.com', '2020-01-01', 5000000, NULL),
('NV002', N'Tran Thi B', '1995-05-05', '987654321', 'Hanoi', '987654321', 'Bachelor', 'nvB@example.com', '2020-01-01', 4500000, 'NV001'),
('NV003', N'Le Van C', '1998-10-10', '456123789', 'Hanoi', '456123789', 'Bachelor', 'nvC@example.com', '2020-01-01', 4000000, 'NV001');

-- Rap
INSERT INTO Rap (maRap, tenRap, diaChi, sdtRap) VALUES
('R001', N'Rạp A', 'Hanoi', '123456789'),
('R002', N'Rạp B', 'Hanoi', '987654321');

-- PhongChieu
INSERT INTO PhongChieu (maPC, tenPC, loaiPC, rap) VALUES
('PC001', N'Phòng 1', 'BASIC', 'R001'),
('PC002', N'Phòng 2', 'BASIC', 'R001'),
('PC003', N'Phòng 3', 'BASIC', 'R002');

-- Phim
INSERT INTO Phim (maPhim, tenPhim, trangThai, gia, theLoai, gioiHanTuoi, hinhAnh) VALUES
('P001', N'Nobita và vùng đất trên bầu trời', 'DANG_CHIEU', 90000, 'HOAT_HINH', 'P', './image/nobita.png'),
('P002', N'Lật mặt 7: Một điều ước', 'DANG_CHIEU', 90000, 'TINH_CAM', 'K', './image/lat-mat-7.jpg'),
('P003', N'Kung fu Panda', 'DANG_CHIEU', 80000, 'HOAT_HINH', 'P', './image/jpnpanda-dai-nao-lanh-dia-vua-su-tu.jpg'),
('P004', N'Vây Hàm', 'DANG_CHIEU', 90000, 'HANH_DONG', 'T16', './image/Vay-ham.jpg'),
('P005', N'Tarot', 'DANG_CHIEU', 90000, 'TINH_CAM', 'T18', './image/tarot.jpg');
-- Ghe
INSERT INTO Ghe (maGhe, loaiGhe, giaGhe, coTheDat, phongChieu) VALUES
('A001', 'GHETIEUCHUAN', 50000, 1, 'PC001'),
('A002', 'GHETIEUCHUAN', 100000, 1, 'PC001'),
('A003', 'GHETIEUCHUAN', 50000, 1, 'PC002'),
('A004', 'GHETIEUCHUAN', 50000, 1, 'PC003');

-- SuatChieu
INSERT INTO SuatChieu (maSC, thoiGianBatDau, thoiGianKetThuc, phim, phongChieu) VALUES
('SC001', '2024-05-05 10:00:00', '2024-05-05 12:00:00', 'P001', 'PC001'),
('SC002', '2024-05-05 14:00:00', '2024-05-05 16:00:00', 'P002', 'PC002');

-- Ve
INSERT INTO Ve (maVe, thoiGianIn, phim, suatChieu, ghe, phongChieu, hoaDon) VALUES
('V004', '2024-05-05 09:00:00', 'P001', 'SC001', 'A001', 'PC001', 'HD001'),
('V005', '2024-05-05 09:00:00', 'P001', 'SC001', 'A002', 'PC001', 'HD001'),
('V006', '2024-05-05 13:00:00', 'P002', 'SC002', 'A003', 'PC002', 'HD002');

-- HoaDon
INSERT INTO HoaDon (maHD, soTien, thoiGianXuat, phuongThucThanhToan) VALUES
('HD001', 150000, '2024-05-05 09:30:00', 'CASH'),
('HD002', 100000, '2024-05-05 13:30:00', 'MOMO');


