-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 04, 2021 at 10:23 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QuanLyKho`
--

-- --------------------------------------------------------

--
-- Table structure for table `auth`
--

CREATE TABLE `auth` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `permision` bit(1) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `auth`
--

INSERT INTO `auth` (`id`, `role_id`, `menu_id`, `permision`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 1, 1, b'1', b'1', '2021-01-04 07:41:17', '2021-01-04 07:41:17'),
(2, 1, 2, b'1', b'1', '2020-12-17 19:23:26', '2020-11-30 19:23:24'),
(3, 1, 3, b'1', b'1', '2020-12-17 19:23:30', '2020-11-30 19:23:27'),
(4, 1, 4, b'0', b'1', '2021-01-04 07:42:19', '2021-01-04 07:42:18'),
(5, 1, 5, b'1', b'1', '2020-12-17 19:23:35', '2020-11-30 19:23:33'),
(6, 1, 6, b'1', b'1', '2020-12-17 19:23:38', '2020-11-30 19:23:36'),
(7, 1, 7, b'1', b'1', '2020-12-17 19:23:43', '2020-11-30 19:23:42'),
(8, 1, 8, b'1', b'1', '2020-12-17 19:23:41', '2020-11-30 19:23:39'),
(9, 1, 9, b'1', b'1', '2020-12-17 19:23:49', '2020-11-30 19:23:47'),
(10, 1, 10, b'1', b'1', '2020-12-17 19:23:46', '2020-11-30 19:23:44'),
(11, 1, 11, b'1', b'1', '2020-12-17 19:23:52', '2020-11-30 19:23:50'),
(12, 1, 12, b'1', b'1', '2020-12-17 19:23:55', '2020-11-30 19:23:52'),
(13, 1, 13, b'1', b'1', '2020-12-17 19:23:57', '2020-11-30 19:23:55'),
(14, 1, 14, b'1', b'1', '2020-12-17 19:23:59', '2020-11-30 19:23:58'),
(15, 1, 15, b'1', b'1', '2020-12-17 19:24:01', '2020-11-30 19:24:00'),
(16, 1, 16, b'1', b'1', '2021-01-04 01:31:00', '2020-11-30 19:24:02'),
(17, 1, 17, b'1', b'1', '2020-12-17 19:24:44', '2020-11-30 19:24:04'),
(26, 2, 1, b'1', b'1', '2021-01-04 07:09:13', '2021-01-04 07:09:13'),
(27, 2, 2, b'1', b'1', '2021-01-04 07:09:22', '2021-01-04 07:09:22'),
(28, 2, 4, b'1', b'1', '2021-01-04 07:11:12', '2021-01-04 07:11:12'),
(29, 2, 3, b'1', b'1', '2021-01-04 08:25:41', '2021-01-04 08:25:41');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `code`, `description`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 'Galaxy101', 'SamSung1122', 'Dien Thoai 1', b'1', '2020-12-30 09:18:11', '2020-12-30 09:18:11'),
(2, 'Iphone 1', 'Apple', 'Dien Thoai 2', b'1', '2020-12-20 09:55:55', '2020-12-20 09:51:10'),
(3, 'Xiaomi 4', 'XiaoMi', 'Dien Thoai 3', b'1', '2020-12-30 09:30:50', '2020-12-30 09:30:50'),
(4, 'Nokia 1', 'Nokia', 'Dien Thoai 4', b'1', '2020-12-24 02:07:25', '2020-12-20 09:57:26'),
(5, 'Galaxy 2', 'SamSung2', 'Dien Thoai 1', b'1', '2020-12-25 01:49:38', '2020-12-25 01:49:38'),
(6, 'LALA28', 'LALA', 'this is a phone', b'1', '2020-12-25 03:06:59', '2020-12-25 03:06:59'),
(7, 'khiem', 'Hihi', 'lal la ', b'1', '2020-12-29 07:54:22', '2020-12-29 07:54:22');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `action_name` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` date NOT NULL DEFAULT current_timestamp(),
  `update_date` date NOT NULL DEFAULT '0000-00-00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `product_id`, `action_name`, `type`, `qty`, `price`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 1, 'Sale', 1, 2, '2000.00', b'1', '2020-12-22', '2020-12-21'),
(2, 2, 'Buy', 1, 10, '3000.00', b'1', '2020-12-22', '2020-12-21'),
(3, 3, 'Sale', 1, 10, '1000.00', b'1', '2020-12-22', '2020-12-21'),
(4, 1, 'Buy', 10, 10, '10000.00', b'0', '2020-12-22', '2020-12-21'),
(5, 1, 'Sale', 0, 0, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(6, 2, 'Buy', 0, 0, '100.00', b'1', '2020-12-22', '2020-12-22'),
(7, 2, 'Sale', 0, 0, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(8, 3, 'Buy', 0, 2802, '1999.00', b'1', '2020-12-22', '2020-12-22'),
(9, 3, 'Sale', 0, 1802, '1999.00', b'1', '2020-12-22', '2020-12-22'),
(10, 3, 'Sale', 0, 600, '1999.00', b'1', '2020-12-22', '2020-12-22'),
(11, 3, 'Sale', 0, 300, '1999.00', b'1', '2020-12-22', '2020-12-22'),
(12, 3, 'Buy', 0, 100, '1999.00', b'1', '2020-12-22', '2020-12-22'),
(13, 3, 'Sale', 0, 150, '1999.00', b'1', '2020-12-22', '2020-12-22'),
(14, 1, 'Sale', 0, 1500, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(15, 1, 'Sale', 0, 100, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(16, 1, 'Sale', 0, 100, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(17, 1, 'Sale', 0, 100, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(18, 1, 'Sale', 0, 150, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(19, 1, 'Buy', 0, 1950, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(20, 2, 'Buy', 0, 50, '2000.00', b'1', '2020-12-22', '2020-12-22'),
(21, 2, 'Sale', 0, 100, '2000.00', b'1', '2020-12-22', '2020-12-22'),
(22, 3, 'Sale', 0, 20, '1999.00', b'1', '2020-12-22', '2020-12-22'),
(23, 1, 'Sale', 0, 0, '1000.00', b'1', '2020-12-22', '2020-12-22'),
(24, 2, 'Buy', 0, 12, '31.00', b'1', '2020-12-24', '2020-12-24'),
(25, 1, 'Buy', 0, 18001, '1000.00', b'1', '2020-12-25', '2020-12-25'),
(26, 1, 'Buy', 0, 200000, '1000.00', b'1', '2020-12-29', '2020-12-29'),
(27, 2, 'Sale', 0, 0, '1000.00', b'1', '2020-12-29', '2020-12-29');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `product_id`, `code`, `type`, `qty`, `price`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 3, 'IV01', 1, 1, '1000.00', b'1', '2020-12-29 09:54:45', '2020-12-29 09:54:45'),
(2, 2, 'IV02', 1, 2, '3000.00', b'1', '2020-12-23 03:27:55', '2020-12-23 03:27:55'),
(3, 3, 'IV03', 0, 3, '12000.00', b'1', '2020-12-21 17:10:52', '2020-12-21 02:31:51'),
(4, 3, 'IV04', 1, 10, '3000.00', b'1', '2020-12-23 03:29:41', '2020-12-23 03:29:12'),
(5, 3, 'IV04', 1, 10, '3000.00', b'1', '2020-12-23 03:29:44', '2020-12-23 03:29:12'),
(6, 4, 'IV05', 0, 32, '1000.00', b'1', '2020-12-23 03:30:55', '2020-12-23 03:30:55'),
(7, 4, 'IV05', 0, 32, '1000.00', b'1', '2020-12-23 03:30:50', '2020-12-23 03:30:50');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `order_index` int(11) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `parent_id`, `url`, `name`, `order_index`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 0, '/product', 'Sản phẩm', 1, b'1', '2020-12-17 19:24:51', '2020-11-30 19:24:48'),
(2, 0, '/stock', 'Kho', 2, b'1', '2020-12-17 19:24:54', '2020-11-30 19:24:52'),
(3, 0, '/management', 'Quản lý', 3, b'1', '2020-12-17 19:25:00', '2020-11-30 19:24:55'),
(4, 1, '/product-info/list', 'Danh sách sản phẩm', 2, b'1', '2020-12-17 19:25:05', '2020-11-30 19:25:01'),
(5, 1, '/category/list', 'Danh sách category', 1, b'1', '2020-12-17 19:25:08', '2020-11-30 19:25:06'),
(6, 1, '/category/edit', 'Sửa', -1, b'1', '2020-12-17 19:25:11', '2020-11-30 19:25:09'),
(7, 1, '/category/view', 'Xem', -1, b'1', '2020-12-17 19:25:18', '2020-11-30 19:25:15'),
(8, 1, '/category/add', 'Thêm mới', -1, b'1', '2020-12-17 19:25:14', '2020-11-30 19:25:12'),
(9, 1, '/category/save', 'Lưu', -1, b'1', '2020-12-17 19:25:24', '2020-11-30 19:25:22'),
(10, 1, '/category/delete', 'Xoá', -1, b'1', '2020-12-17 19:25:21', '2020-11-30 19:25:19'),
(11, 2, '/goods-recept/list', 'Danh sách nhập kho', 1, b'1', '2020-12-17 19:25:31', '2020-12-01 19:25:28'),
(12, 2, '/goods-issue/list', 'Danh sách xuất kho', 2, b'1', '2020-12-17 19:25:35', '2020-11-30 19:25:32'),
(13, 2, '/product-in-stock/list', 'Sản phẩm trong kho', 3, b'1', '2020-12-17 19:25:38', '2020-11-30 19:25:36'),
(14, 2, '/history', 'Lịch sử kho', 4, b'1', '2020-12-17 19:25:40', '2020-11-30 19:25:38'),
(15, 3, '/user/list', 'Danh sách user', 1, b'1', '2020-12-17 19:25:44', '2020-11-30 19:25:41'),
(16, 3, '/menu/list', 'Danh sách menu', 2, b'1', '2021-01-04 01:20:23', '2020-12-01 19:25:44'),
(17, 3, '/role/list', 'Danh sách quyền', 3, b'1', '2020-12-31 01:46:34', '2020-11-30 19:25:48');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `cate_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `img_url` varchar(200) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `cate_id`, `name`, `code`, `description`, `img_url`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 1, 'sdgdf', 'vv', 'ertert', '/resources/images/galaxy2.jpeg', b'1', '2020-12-25 02:59:21', '2020-12-21 16:00:22'),
(2, 1, 'sdgdf', 'vv', 'ertert', '/resources/images/galaxy2.jpeg', b'1', '2020-12-25 02:59:24', '2020-12-22 01:40:48'),
(3, 2, 'adsad', 'vcv', 'tertet', '/resources/images/galaxy4.jpeg', b'1', '2020-12-22 01:17:40', '2020-12-21 16:07:05'),
(4, 3, 'asdads', 'XIao', '123123', '/resources/images/galaxy4.jpeg', b'1', '2020-12-21 14:09:26', '2020-12-21 14:08:06'),
(5, 4, 'Nokia 1', 'NK1', 'AAAA', '/resources/images/galaxy3.jpeg', b'1', '2020-12-21 13:42:15', '2020-12-21 10:19:11'),
(6, 3, 'Iphone 10', 'IP2', 'AAAA', '/resources/images/galaxy1.jpeg', b'0', '2020-12-21 17:10:03', '2020-12-21 14:35:33');

-- --------------------------------------------------------

--
-- Table structure for table `product_in_stock`
--

CREATE TABLE `product_in_stock` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_in_stock`
--

INSERT INTO `product_in_stock` (`id`, `product_id`, `qty`, `price`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 2, 220001, '1000', b'1', '2020-12-29 06:49:37', '2020-12-29 06:49:37'),
(2, 1, 301, '3000', b'1', '2020-12-22 02:47:27', '2020-12-22 02:47:27'),
(3, 3, 10, '3000', b'1', '2020-12-21 17:10:23', '2020-12-21 10:26:38'),
(4, 2, 32, '4000', b'1', '2020-12-21 17:10:29', '2020-12-21 02:26:09'),
(5, 1, 10, '4000', b'0', '2020-12-21 16:01:26', '2020-12-21 14:35:33'),
(6, 2, 0, '0', b'0', '2020-12-22 03:07:25', '2020-12-22 03:07:25'),
(7, 3, 0, '0', b'0', '2020-12-22 03:07:33', '2020-12-22 03:07:33'),
(8, 3, 0, '1', b'0', '2020-12-22 03:10:32', '2020-12-22 03:10:32'),
(9, 2, 28, '1000', b'1', '2020-12-22 06:17:09', '2020-12-22 06:17:09'),
(10, 3, 30, '1999', b'1', '2020-12-22 07:49:00', '2020-12-22 07:49:00'),
(11, 2, 0, '2000', b'0', '2020-12-22 07:13:29', '2020-12-22 07:13:29'),
(12, 2, 12, '31', b'0', '2020-12-24 06:35:13', '2020-12-24 06:35:13');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `role_name`, `description`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 'admin', 'Admin of system', b'1', '2020-12-31 08:08:30', '2020-12-31 08:08:30'),
(2, 'staff', 'Staff of system', b'1', '2020-12-17 15:59:36', '2020-12-01 15:59:33'),
(12, 'Employee', 'Employee', b'1', '2020-12-31 08:07:20', '2020-12-31 08:07:20');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `name`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 'khiem', 'eJvR+tl9IvZC58Hh2UvBWrafzuEQdAlR', 'khiemld28@gmail.com', 'Le Dinh Khiem1', b'1', '2021-01-04 07:07:59', '2021-01-04 08:30:02'),
(24, 'nhan', '5orIFT3Pkv3eJKp/EZM18VPx55PTxNE/', 'hongnhanlt28@gmail.com', 'Le Thi Hong Nhan', b'1', '2021-01-04 07:09:55', '2021-01-04 08:30:08');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `active_flag` bit(1) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `user_id`, `role_id`, `active_flag`, `create_date`, `update_date`) VALUES
(1, 1, 1, b'1', '2020-12-30 10:14:35', '2020-12-30 10:14:31'),
(18, 24, 2, b'1', '2021-01-04 07:09:55', '2021-01-04 07:09:55');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_role_auth` (`role_id`),
  ADD KEY `fk_menu_auth` (`menu_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_history` (`product_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_invoice` (`product_id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_category_product` (`cate_id`);

--
-- Indexes for table `product_in_stock`
--
ALTER TABLE `product_in_stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_product_in_stock` (`product_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Users` (`user_id`),
  ADD KEY `fk_Roles` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auth`
--
ALTER TABLE `auth`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `product_in_stock`
--
ALTER TABLE `product_in_stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auth`
--
ALTER TABLE `auth`
  ADD CONSTRAINT `fk_menu_auth` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  ADD CONSTRAINT `fk_role_auth` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `fk_product_history` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `fk_product_invoice` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_category_product` FOREIGN KEY (`cate_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `product_in_stock`
--
ALTER TABLE `product_in_stock`
  ADD CONSTRAINT `fk_product_in_stock` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_Roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `fk_Users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
