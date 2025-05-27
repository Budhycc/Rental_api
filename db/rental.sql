-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 27, 2025 at 10:42 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_mobil`
--

CREATE TABLE `data_mobil` (
  `id_mobil` int NOT NULL,
  `merk` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `tahun` int NOT NULL,
  `plat_nomor` varchar(255) NOT NULL,
  `harga_sewa_per_hari` varchar(255) NOT NULL,
  `status` enum('tersedia','disewa') DEFAULT 'tersedia'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `data_mobil`
--

INSERT INTO `data_mobil` (`id_mobil`, `merk`, `model`, `tahun`, `plat_nomor`, `harga_sewa_per_hari`, `status`) VALUES
(1, 'Toyota', 'Avanza', 2022, 'B1234XYZ', '500000', 'disewa'),
(2, 'AA', 'bb', 2020, 'nfgfdgdfg', '70000', 'tersedia'),
(4, 'sdasd', 'nullasdasd', 424, 'nullifg', '10', 'tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `data_pelanggan`
--

CREATE TABLE `data_pelanggan` (
  `id_pelanggan` int NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `no_telepon` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `data_pelanggan`
--

INSERT INTO `data_pelanggan` (`id_pelanggan`, `nama`, `alamat`, `no_telepon`, `email`) VALUES
(1, 'budi', 'lapoa', '12345', 'email@email.com'),
(2, 'qq', 'fd kdi', '12233', 'dsdsd'),
(16, 'budhycc', 'tinanggea', '155', 'contoh'),
(17, 'budhycc123', 'kendaari', '77777', 'qwerty'),
(24, 'sadbaks', 'jdfnsjkdf', '654654', 'jkdbffsdf');

-- --------------------------------------------------------

--
-- Table structure for table `data_rental`
--

CREATE TABLE `data_rental` (
  `id_rental` int NOT NULL,
  `id_transaksi` int NOT NULL,
  `id_mobil` int NOT NULL,
  `id_pelanggan` int NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_batas` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `data_transaksi`
--

CREATE TABLE `data_transaksi` (
  `id_transaksi` int NOT NULL,
  `id_pelanggan` int NOT NULL,
  `id_mobil` int NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `total_harga` varchar(255) NOT NULL,
  `denda` varchar(255) DEFAULT NULL,
  `status` enum('berlangsung','selesai') DEFAULT 'berlangsung'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `data_transaksi`
--

INSERT INTO `data_transaksi` (`id_transaksi`, `id_pelanggan`, `id_mobil`, `tanggal_mulai`, `tanggal_selesai`, `total_harga`, `denda`, `status`) VALUES
(30, 2, 1, '2025-05-21', '2025-05-22', '20000', '200000.0', 'selesai'),
(31, 2, 2, '2025-05-21', '2025-05-22', '20000', '100000.0', 'selesai'),
(32, 1, 4, '2025-05-22', '2025-05-23', '10', '0', 'selesai'),
(33, 1, 4, '2025-05-20', '2025-05-22', '20', '100000.0', 'selesai'),
(34, 2, 2, '2025-05-18', '2025-05-20', '140000', '300000.0', 'selesai');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `name`) VALUES
(1, 'budhycc', '12345', 'budi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_mobil`
--
ALTER TABLE `data_mobil`
  ADD PRIMARY KEY (`id_mobil`),
  ADD UNIQUE KEY `plat_nomor` (`plat_nomor`);

--
-- Indexes for table `data_pelanggan`
--
ALTER TABLE `data_pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `data_rental`
--
ALTER TABLE `data_rental`
  ADD PRIMARY KEY (`id_rental`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_mobil` (`id_mobil`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Indexes for table `data_transaksi`
--
ALTER TABLE `data_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `id_mobil` (`id_mobil`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_mobil`
--
ALTER TABLE `data_mobil`
  MODIFY `id_mobil` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `data_pelanggan`
--
ALTER TABLE `data_pelanggan`
  MODIFY `id_pelanggan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `data_rental`
--
ALTER TABLE `data_rental`
  MODIFY `id_rental` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `data_transaksi`
--
ALTER TABLE `data_transaksi`
  MODIFY `id_transaksi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_rental`
--
ALTER TABLE `data_rental`
  ADD CONSTRAINT `data_rental_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `data_transaksi` (`id_transaksi`),
  ADD CONSTRAINT `data_rental_ibfk_2` FOREIGN KEY (`id_mobil`) REFERENCES `data_mobil` (`id_mobil`),
  ADD CONSTRAINT `data_rental_ibfk_3` FOREIGN KEY (`id_pelanggan`) REFERENCES `data_pelanggan` (`id_pelanggan`);

--
-- Constraints for table `data_transaksi`
--
ALTER TABLE `data_transaksi`
  ADD CONSTRAINT `data_transaksi_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `data_pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `data_transaksi_ibfk_2` FOREIGN KEY (`id_mobil`) REFERENCES `data_mobil` (`id_mobil`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
