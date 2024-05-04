use master

drop database CinemaDatabase

create database CinemaDatabase

use CinemaDatabase

create table TaiKhoan(
	maTK varchar(20) primary key,
	tenDangNhap varchar(50),
	matKhau varchar(50),
	nhanVien varchar(20),
	quyen varchar(20),
)

create table NhanVien(
	maNV varchar(20) primary key,
	tenNV varchar(50),
	ngaySinh Date,
	cccd varchar(20),
	noiCuTru varchar(50),
	sdt varchar(20),
	trinhDo varchar(20),
	email varchar(50),
	ngayTuyenDung Date,
	luong decimal(10,2),
	chucVu varchar(20),
	quanLy varchar(20),
)

create table Rap(
	maRap varchar(20) primary key,
	tenRap varchar(50),
	diaChi varchar(50),
	sdtRap varchar(20)
)

create table PhongChieu(
	maPC varchar(20) primary key,
	tenPC varchar(50),
	loaiPC varchar(20),
	rap varchar(20)
)

create table Phim(
	maPhim varchar(20) primary key,
	tenPhim varchar(50),
	trangThai varchar(20),
	gia decimal(10,2),
	theLoai varchar(50),
	gioiHanTuoi varchar(20)
)

create table Ghe(
	maGhe varchar(20) primary key,
	loaiGhe varchar(20),
	giaGhe decimal(20),
	coTheDat bit,
	phongChieu varchar(20)
)

create table SuatChieu(
	maSC varchar(20) primary key,
	thoiGianBatDau DateTime,
	thoiGianKetThuc DateTime,
	phim varchar(20),
	phongChieu varchar(20)
)


create table Ve(
	maVe varchar(20) primary key,
	thoiGianIn DateTime,
	phim varchar(20),
	suatChieu varchar(20),
	ghe varchar(20),
	phongChieu varchar(20),
	hoaDon varchar(20)
)

create table HoaDon(
	maHD varchar(20) primary key,
	soTien decimal(10,2),
	thoiGianXuat DateTime,
	phuongThucThanhToan varchar(20),
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