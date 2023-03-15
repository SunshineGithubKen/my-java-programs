-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 13, 2022 at 10:55 AM
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
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL COMMENT '伝票番号',
  `order_id` int(11) NOT NULL COMMENT '注文番号',
  `item_id` int(11) NOT NULL COMMENT '商品番号',
  `amount` int(11) NOT NULL,
  `created` datetime NOT NULL DEFAULT current_timestamp() COMMENT '注文日時を表す',
  `updated` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新処理日時を表す'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='受注明細テーブル';

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`id`, `order_id`, `item_id`, `amount`, `created`, `updated`) VALUES
(1, 1, 1, 3, '2022-12-11 17:53:19', '2022-12-11 17:53:19'),
(2, 1, 2, 1, '2022-12-11 17:53:19', '2022-12-11 17:53:19'),
(3, 1, 3, 4, '2022-12-11 17:53:19', '2022-12-11 17:53:19'),
(4, 2, 1, 1, '2022-12-11 17:53:19', '2022-12-11 17:53:19'),
(5, 2, 2, 1, '2022-12-11 17:53:19', '2022-12-11 17:53:19'),
(6, 2, 4, 4, '2022-12-11 17:53:19', '2022-12-11 17:53:19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `item_id` (`item_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '伝票番号', AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
