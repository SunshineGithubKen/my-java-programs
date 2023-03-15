-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 13, 2022 at 10:56 AM
-- Server version: 10.5.10-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `practice`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL COMMENT '注文番号',
  `user_id` int(11) NOT NULL COMMENT 'ユーザー番号',
  `payment` varchar(20) NOT NULL,
  `created` datetime NOT NULL DEFAULT current_timestamp() COMMENT '注文日',
  `updated` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新処理が行われた日'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='注文一覧テーブル';

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `payment`, `created`, `updated`) VALUES
(1, 1, 'クレジット', '2022-12-11 15:19:52', '2022-12-11 22:07:16'),
(2, 2, 'クレジット', '2022-12-11 15:23:25', '2022-12-11 15:23:25'),
(3, 3, '代金引換', '2022-12-11 15:23:25', '2022-12-11 15:23:25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '注文番号', AUTO_INCREMENT=10000;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
