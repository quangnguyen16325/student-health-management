USE [master]
GO
CREATE DATABASE [QLSKSV]
GO
ALTER DATABASE [QLSKSV] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLSKSV].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLSKSV] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLSKSV] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLSKSV] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLSKSV] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLSKSV] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLSKSV] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLSKSV] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLSKSV] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLSKSV] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLSKSV] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLSKSV] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLSKSV] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLSKSV] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLSKSV] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLSKSV] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLSKSV] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLSKSV] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLSKSV] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLSKSV] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLSKSV] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLSKSV] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLSKSV] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLSKSV] SET RECOVERY FULL 
GO
ALTER DATABASE [QLSKSV] SET  MULTI_USER 
GO
ALTER DATABASE [QLSKSV] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLSKSV] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLSKSV] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLSKSV] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLSKSV] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLSKSV] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLSKSV', N'ON'
GO
ALTER DATABASE [QLSKSV] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLSKSV] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLSKSV]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[details](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[studentCode] [varchar](20) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[birth] [varchar](50) NOT NULL,
	[gender] [varchar](20) NOT NULL,
	[CCCD] [varchar](50) NOT NULL,
	[URL] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[emergencyContact](
	[studentCode] [varchar](20) NOT NULL,
	[fullNameContact] [nvarchar](50) NULL,
	[relationshipContact] [nvarchar](20) NULL,
	[phoneContact] [varchar](20) NULL,
	[addressContact] [nvarchar](100) NULL
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[healths](
	[studentCode] [varchar](20) NOT NULL,
	[height] [float] NULL,
	[weight] [float] NULL,
	[bmi] [float] NULL,
	[bloodType] [varchar](20) NULL,
	[healthCode] [varchar](50) NULL,
	[healthStatus] [nvarchar](50) NULL,
	[note] [nvarchar](200) NULL
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[requestFromUsers](
	[email] [varchar](100) NOT NULL,
	[firstName] [nvarchar](50) NULL,
	[lastName] [nvarchar](50) NOT NULL,
	[roleUser] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[firstName] [nvarchar](50) NULL,
	[lastName] [nvarchar](50) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[roleUser] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[details] ON 

INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (1, N'23IT.EB080', N'Nguyễn Ngọc Quang', N'07/02/2005', N'Male', N'066205001329', N'C:\Users\quang\Pictures\Saved Pictures\image6.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (2, N'23IT.EB036', N'Nguyễn Huỳnh Hoan', N'29/05/2005', N'Male', N'049205005045', N'C:\Users\quang\Pictures\Saved Pictures\hhoan.png')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (3, N'23IT.EB065', N'Nguyễn Văn A', N'23/12/2005', N'Female', N'066205001899', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (4, N'23CE.B003', N'Phan Đình Cường', N'27/10/2005', N'Male', N'066205001329', N'C:\Users\quang\Pictures\Saved Pictures\image10.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (5, N'23IT.EB062', N'Nguyễn Thanh Thiên Ngân', N'18/07/2005', N'Female', N'066205005846', N'C:\Users\quang\Pictures\Saved Pictures\image2.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (6, N'23IT.EB104', N'Lê Quang Thọ', N'25/07/2005', N'Male', N'066205003265', N'C:\Users\quang\Pictures\Saved Pictures\image5.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (12, N'23IT.EB532', N'Lê Công Quốc Mỹ', N'16/05/2005', N'Male', N'016467794271', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (13, N'22SE013', N'Nguyễn Trần Văn Nam', N'05/11/2005', N'Male', N'012574185543', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (14, N'22GIT680', N'Võ Văn Minh', N'17/08/2004', N'Male', N'037423948364', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (15, N'21GBA350', N'Trần Tố Quyên', N'12/12/2003', N'Female', N'015256732323', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (16, N'21EL345', N'Đoàn Trần Thu Trang', N'30/04/2003', N'Female', N'056823583325', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (17, N'23SE475', N'Phạm Tấn Tinh Khuê', N'05/10/2004', N'Male', N'024892385415', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (18, N'23BA234', N'Trần Lê Thu Trang', N'22/10/2003', N'Female', N'046689232786', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (19, N'23IT1088', N'Nguyễn Thanh Huân', N'22/12/2005', N'Male', N'056146587325', N'C:\Users\quang\Pictures\Saved Pictures\image6.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (20, N'22NS1175', N'Trần Lê Thu Dung', N'23/11/2004', N'Female', N'023648912368', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (21, N'21AI087', N'Lương Văn Mạnh', N'02/05/2003', N'Male', N'064863683875', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (22, N'22AI038', N'Nguyễn Hùng Anh', N'24/12/2004', N'Male', N'023638948954', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (23, N'23IT3B034', N'Trần Thị Vy', N'12/04/2005', N'Female', N'038734563455', N'C:\Users\quang\Pictures\Saved Pictures\image1.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (24, N'21BA157', N'Lê Trần Bảo Trân', N'16/11/2003', N'Female', N'036478923789', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (26, N'23IT.EB123', N'Nguyễn Văn Thái', N'22/02/2005', N'Male', N'066205001235', N'C:\Users\quang\Pictures\Saved Pictures\image8.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (28, N'23IT.EB512', N'Test', N'15/12/2005', N'Male', N'0662051124', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (29, N'23IT1584', N'Nguyen Ngoc Quang', N'12/02/2005', N'Male', N'06620515420', N'C:\Users\quang\Pictures\Saved Pictures\image8.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (38, N'23GIT665', N'Nguyen Dinh Cuong', N'27/10/2005', N'Male', N'066205003261', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
INSERT [dbo].[details] ([id], [studentCode], [fullName], [birth], [gender], [CCCD], [URL]) VALUES (41, N'23IT.EB550', N'Nguyen Hoang Anhh', N'14/12/2005', N'Male', N'06620533261', N'C:\Users\quang\Pictures\Saved Pictures\image7.jpg')
SET IDENTITY_INSERT [dbo].[details] OFF
GO
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB080', N'Nguyễn Anh', N'Bố', N'0389318934', N'63 Thôn 1 Cuôr Knia Buôn Đôn Đắk Lắk')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB036', N'Huỳnh Thị Phúc', N'Mẹ', N'0386583836', N'Cù Lao Chàm')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB065', N'', N'', N'', N'')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23CE.B003', N'Nguyên A', N'Bố', N'035694582', N'Nghệ An')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB062', N'Nguyễn Đăng Tùng', N'Bố', N'0386708895', N'Đà Nẵng')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB104', N'Nguyen A', N'', N'', N'')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB550', N'ANHH', N'Bo', N'032151321', N'DN')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB533', N'Lê Quốc Ca', N'Bố', N'0666852147', N'Huế')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'22SE013', N'Lê Thị Thúy', N'Mẹ', N'046912338458', N'Thành phố Đông Hà-Quảng Trị')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'22GIT680', N'Võ Văn Nam', N'Bố', N'05687812658', N'Sơn Trà -Đà Nẵng')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'21GBA350', N'Lê Ngọc Thủy', N'Mẹ', N'026863545', N'Thanh Khê-Đà Nẵng')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'21EL345', N'Trần Tân', N'Bố', N'025632489', N'Bố Trạch-Quảng Bình')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23BA234', N'Lê Văn Tuấn', N'Bố', N'0566568823', N'Thanh Khê-Đà Nẵng')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT1088', N'Nguyễn Thanh Long', N'Ông', N'0564682168', N'45 Quang Trung,Hải Châu ,Đà Nẵng')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'22NS1175', N'Trần Viết Tuấn', N'Bố', N'0656821314', N'13 Nguyễn Chí Thanh,Đà Nẵng')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'21AI087', N'Lương Tấn Phát', N'Bố', N'0265873558', N'Thanh Hóa')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'22AI038', N'Nguyễn Hồng Hậu', N'Mẹ', N'026899237', N'Hà Nội')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT3B034', N'Trần Thị Trinh', N'Mẹ', N'048573847', N'Nghệ An')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'21BA157', N'Lê Gia Bảo', N'Chú', N'0328978354', N'Hà Tĩnh')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB123', N'', N'', N'', N'')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT.EB512', N'NGuyen A', N'Bo', N'0386708854', N'VN')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23IT1584', N'Nguyen A', N'Bo', N'0386708851', N'VN')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'', N'', N'', N'', N'')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23GIT665', N'AAA', N'', N'', N'')
INSERT [dbo].[emergencyContact] ([studentCode], [fullNameContact], [relationshipContact], [phoneContact], [addressContact]) VALUES (N'23SE475', N'Nguyễn Thị Lành', N'Mẹ', N'056498123', N'Liên Chiểu-Đà Nẵng')
GO
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB080', 172, 52, 17.58, N'Group A', N'DK26668948', N'Sức khỏe tốt', N'Cần luyện tập thêm thể thao')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB036', 175, 65, 21.22, N'Group O', N'DK26568487', N'Sức khỏe tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB065', 167, 50, 20, N'Group A', N'DK58984875', N'Sức khỏe tốt', N'Luyện tập thể thao.')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23CE.B003', 170, 50, 20, N'Group B', N'DK54485120', N'Sức khỏe trung bình', N'Cần tập gym.')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB062', 153, 48, 20.5, N'Group A', N'DK265484215', N'Sức khỏe rất tốt', N'Cần luyện tập thể thao')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB104', 165, 67, 24.61, N'Group AB', N'DK549846132', N'Sức khỏe tốt', N'Cần luyện tập thể thao')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB550', 172, 55, 18.59, N'Group A', N'DK5465121231', N'Sức khỏe tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB533', 168, 65, 23.03, N'Group AB', N'DK2548845245', N'Sức khỏe khá', N'Cần luyện tập sức khỏe')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'22SE013', 165, 70, 25.71, N'Group O', N'DK59872635', N'Sức khỏe kém', N'Cần luyện tập gym,giảm ăn thịt ,các sản phẩm từ sữa và bơ.')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'22GIT680', 168, 70, 24.8, N'Group O', N'DK37925603', N'Sức khỏe trung bình', N'Càn ăn uống có chọn lọc nên ăn rau tránh các thực phẩm từ sữa và trứng')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'21GBA350', 176, 40, 12.91, N'Group B', N'DK79435346', N'Sức khỏe kém', N'-Luyện tập sức khỏe để tăng cân
-Ăn đầy đủ các chế độ dinh dưỡng')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'21EL345', 154, 55, 23.19, N'Group A', N'DK0234835863', N'Sức khỏe khá', N'-Nên ăn theo chế độ đã giao đẻ không bị các bệnh về đường ruột')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23BA234', 168, 46, 16.3, N'Group B', N'DK0574857896', N'Sức khỏe tốt', N'-Sức khỏe tốt nhưng cần hạn chế ăn những thức ăn làm từ đậu nành vì đang bị u tuyến giáp')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT1088', 170, 39, 13.49, N'Group O', N'DK023489335', N'Sức khỏe rất kém', N'-Cần chơi các môn thể thao để cân bằng sức khoẻ,ăn uống điều độ để tăng cân')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'22NS1175', 155, 45, 18.73, N'Group AB', N'DK034891468523', N'Sức khỏe rất tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'21AI087', 171, 60, 20.52, N'Group B', N'DK05487538', N'Sức khỏe tốt', N'-Tránh tiếp xúc với đồ ăn ngoài vì mới mổ ruột thừa')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'22AI038', 187, 50, 14.3, N'Group AB', N'Dk056579823', N'Sức khỏe kém', N'-Nên ăn các thực phẩm có đạm và các thực phẩm chức năng giúp tăng cân')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT3B034', 162, 58, 22.1, N'Group O', N'DK256487357359', N'Sức khỏe khá', N'-Nên chú ý các bệnh về da,tránh tiếp xúc với tia UV')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'21BA157', 167, 45, 16.14, N'Group B', N'DK45745856', N'Sức khỏe tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB123', 168, 53, 18.78, N'Group A', N'25IT4842121', N'Sức khỏe rất tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT.EB513', 172, 52, 17.58, N'Group A', N'DK111154', N'Sức khỏe rất tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23IT1584', 172, 52, 17.58, N'Group A', N'DK1534845612', N'Sức khỏe rất tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'', 0, 0, 0, N'Group A', N'', N'Sức khỏe rất tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23GIT665', 172, 52, 17.58, N'Group A', N'', N'Sức khỏe rất tốt', N'')
INSERT [dbo].[healths] ([studentCode], [height], [weight], [bmi], [bloodType], [healthCode], [healthStatus], [note]) VALUES (N'23SE475', 180, 90, 27.78, N'Group O', N'DK026584689', N'Sức khỏe trung bình', N'-Nên chơi các môn thể thao và ít tiếp xúc với máy tính để giảm độ cận và béo phì.')
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (2, N'', N'Supervisor', N'master', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'MASTER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (3, N'', N'Quang', N'admin', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (4, N'Nguyễn Huỳnh', N'Hoan', N'hoanhuynh@gmail.com', N'Pbh+6mmCYL2kD9vk9AvJXALurRg=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (5, N'Ngọc', N'Quangggg', N'user', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'USER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (21, N'Phan', N'Cường', N'phancuong@gmail.com', N'kdlXyOsD/LksYhiscoiu3uqfdK4=', N'USER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (23, N'Đặng Văn ', N'Rin', N'rin@gmail.com', N'LcN9DOxLhI7iCPpG8sOF6YlnMkU=', N'USER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (24, N'Ngô Văn ', N'Hiền', N'hien@gmail.com', N'Pbh+6mmCYL2kD9vk9AvJXALurRg=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (27, N'Nguyễn Ngọc', N'Quang', N'quangnguyen16325@gmail.com', N'mTiy4NNepJ6JlmX3FLdwdzWbDIU=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (29, N'Nguyễn Văn ', N'Ann', N'ann@gmail.com', N'M49pTzElLiVEAfXs8WjykboOz/4=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (58, N'Thiên', N'Ngân', N'ngan123@gmail.com', N'Pbh+6mmCYL2kD9vk9AvJXALurRg=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (62, N'Nguyen ', N'A', N'test', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (63, N'Hoan', N'Nguyen Huynh', N'hoanhuynh99@gmail.com', N'jH6h36MWokxniwdcZS3Nfc5XH1s=', N'ADMIN')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (72, N'Hoenn', N'Nguyen', N'hoan123', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'USER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (76, N'', N'MASTERJ1', N'masterj1', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'USER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (77, N'Nguyen', N'VAN A', N'vana123', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'USER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (78, N'Quang ', N'Nguyen', N'quangnnq163', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'USER')
INSERT [dbo].[users] ([id], [firstName], [lastName], [email], [password], [roleUser]) VALUES (79, N'Hoan', N'Nguyen', N'hoanclc@gmail.com', N'8+3FQjvx6o449kKNNyj/umS68Aw=', N'ADMIN')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
USE [master]
GO
ALTER DATABASE [QLSKSV] SET  READ_WRITE 
GO
