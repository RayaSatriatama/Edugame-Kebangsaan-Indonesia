-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 02, 2024 at 10:34 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eduN`
--

-- --------------------------------------------------------

--
-- Table structure for table `modul`
--

CREATE TABLE `modul` (
  `id` int(15) NOT NULL,
  `tema` varchar(155) DEFAULT NULL,
  `materi` varchar(9999) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `modul`
--

INSERT INTO `modul` (`id`, `tema`, `materi`) VALUES
(1, 'Pancasila', 'Pendahuluan\r\nPancasila adalah dasar negara Republik Indonesia dan merupakan ideologi yang mempersatukan bangsa Indonesia. Ditetapkan pada tanggal 1 Juni 1945, Pancasila terdiri dari lima sila yang menjadi pedoman dalam kehidupan berbangsa dan bernegara.\r\nTujuan Pembelajaran\r\n1.	Memahami sejarah lahirnya Pancasila.\r\n2.	Menjelaskan makna dan nilai-nilai yang terkandung dalam setiap sila Pancasila.\r\n3.	Menerapkan nilai-nilai Pancasila dalam kehidupan sehari-hari.\r\nSejarah Lahirnya Pancasila\r\nPada tanggal 1 Juni 1945, Ir. Soekarno memperkenalkan konsep Pancasila dalam pidatonya di depan sidang BPUPKI. Pancasila kemudian disempurnakan dan ditetapkan sebagai dasar negara pada tanggal 18 Agustus 1945 oleh PPKI.\r\nLima Sila Pancasila\r\n1.	Ketuhanan Yang Maha Esa\r\no	Mengandung nilai religius dan penghormatan terhadap kepercayaan agama masing-masing.\r\no	Contoh penerapan: Menghormati perbedaan agama dan beribadah sesuai keyakinan.\r\n2.	Kemanusiaan yang Adil dan Beradab\r\no	Menekankan pentingnya perlakuan yang adil dan beradab terhadap sesama manusia.\r\no	Contoh penerapan: Membantu sesama tanpa memandang suku, agama, ras, atau golongan.\r\n3.	Persatuan Indonesia\r\no	Mengutamakan persatuan dan kesatuan bangsa di atas kepentingan pribadi atau golongan.\r\no	Contoh penerapan: Menjaga kerukunan dan keutuhan bangsa, serta menghindari konflik sosial.\r\n4.	Kerakyatan yang Dipimpin oleh Hikmat Kebijaksanaan dalam Permusyawaratan/Perwakilan\r\no	Menjunjung tinggi demokrasi yang berdasarkan musyawarah untuk mencapai mufakat.\r\no	Contoh penerapan: Mengambil keputusan bersama melalui musyawarah dan menghormati hasilnya.\r\n5.	Keadilan Sosial bagi Seluruh Rakyat Indonesia\r\no	Mewujudkan keadilan sosial dalam berbagai aspek kehidupan.\r\no	Contoh penerapan: Berpartisipasi dalam kegiatan sosial dan memperjuangkan kesejahteraan bersama.\r\nPenerapan Nilai-Nilai Pancasila dalam Kehidupan Sehari-Hari\r\n•	Di Lingkungan Keluarga: Menghormati orang tua, menjaga hubungan harmonis antar anggota keluarga, dan membantu pekerjaan rumah tangga.\r\n•	Di Lingkungan Sekolah: Bersikap sopan kepada guru dan teman, aktif dalam kegiatan sekolah, dan mematuhi peraturan sekolah.\r\n•	Di Lingkungan Masyarakat: Ikut serta dalam kegiatan gotong royong, menghormati tetangga, dan menjaga kebersihan lingkungan.\r\n•	Di Lingkungan Bangsa dan Negara: Menjaga persatuan dan kesatuan, mematuhi hukum dan peraturan yang berlaku, serta berpartisipasi dalam pembangunan negara.\r\nPenutup\r\nPancasila bukan hanya sekadar dasar negara, tetapi juga panduan moral dan etika bagi seluruh rakyat Indonesia. Dengan memahami dan menerapkan nilai-nilai Pancasila, kita dapat mewujudkan masyarakat yang adil, makmur, dan beradab.\r\n\r\n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `modul`
--
ALTER TABLE `modul`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `modul`
--
ALTER TABLE `modul`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
