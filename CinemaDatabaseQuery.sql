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
