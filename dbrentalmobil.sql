-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220920.2076d52480
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Des 2022 pada 05.19
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbrentalmobil`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobil`
--

CREATE TABLE `mobil` (
  `idMobil` int(10) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `tipe` varchar(30) NOT NULL,
  `tahun` varchar(6) NOT NULL,
  `noPol` varchar(12) NOT NULL,
  `hargaSewa` int(10) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `mobil`
--

INSERT INTO `mobil` (`idMobil`, `merk`, `tipe`, `tahun`, `noPol`, `hargaSewa`, `status`) VALUES
(1, 'Toyota', 'Avanza', '2012', 'N 1234 AC', 200000, 'Tersedia'),
(3, 'Daihatsu', 'Xenia x.i', '2012', 'B 4321 DE', 180000, 'Tidak Tersedia'),
(4, 'Toyota', 'Inova', '2016', 'AG 12 GH', 240000, 'Tidak Tersedia'),
(5, 'Toyota', 'Hiace', '2020', 'B 5123 CK', 900000, 'Tersedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjam`
--

CREATE TABLE `peminjam` (
  `idPeminjam` int(10) NOT NULL,
  `noKtp` varchar(20) NOT NULL,
  `nama` varchar(60) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `telp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(10) NOT NULL,
  `tglPeminjaman` date NOT NULL,
  `tglPengembalian` date NOT NULL,
  `lamaPinjam` int(10) NOT NULL,
  `Total` int(10) NOT NULL,
  `idMobil` int(10) NOT NULL,
  `idPeminjam` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `tglPeminjaman`, `tglPengembalian`, `lamaPinjam`, `Total`, `idMobil`, `idPeminjam`) VALUES
(1, '0000-00-00', '0000-00-00', 8, 5000000, 1, 0),
(2, '2022-12-01', '2022-12-01', 8, 1440000, 3, 1),
(3, '2022-12-10', '2022-12-12', 2, 400000, 1, 1),
(4, '2022-12-01', '2022-12-04', 3, 600000, 1, 1),
(5, '2022-12-01', '2022-12-03', 2, 400000, 1, 1),
(6, '2022-12-10', '2022-12-12', 2, 360000, 3, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`idUser`, `nama`, `email`, `username`, `password`) VALUES
(2, 'Reno', 'reno@gmail.com', 'reno', 'reno'),
(3, 'eko', 'eko@gmail.com', 'eko', 'eko');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`idMobil`);

--
-- Indeks untuk tabel `peminjam`
--
ALTER TABLE `peminjam`
  ADD PRIMARY KEY (`idPeminjam`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `mobil`
--
ALTER TABLE `mobil`
  MODIFY `idMobil` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `peminjam`
--
ALTER TABLE `peminjam`
  MODIFY `idPeminjam` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
