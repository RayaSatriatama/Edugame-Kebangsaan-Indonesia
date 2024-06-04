-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2024 at 05:08 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edun`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(155) DEFAULT NULL,
  `password` varchar(155) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `crossword_puzzle`
--

CREATE TABLE `crossword_puzzle` (
  `id` int(11) NOT NULL COMMENT 'Primary Key',
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `upload_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `crossword_puzzle`
--

INSERT INTO `crossword_puzzle` (`id`, `question`, `answer`, `upload_time`) VALUES
(208, 'Ibu kota provinsi Bali?', 'DENPASAR', '2024-06-03 17:28:51'),
(209, 'Laut di sebelah utara Indonesia?', 'LAUTCINASELATAN', '2024-06-03 17:28:51'),
(210, 'Sungai di Pulau Kalimantan?', 'MAHAKAM', '2024-06-03 17:28:51'),
(211, 'Gunung tertinggi di Jawa?', 'SEMERU', '2024-06-03 17:28:51'),
(212, 'Raja terakhir Majapahit?', 'BRAWIJAYA', '2024-06-03 17:28:51'),
(213, 'Hari pahlawan diperingati pada bulan?', 'NOVEMBER', '2024-06-03 17:28:51'),
(214, 'Penulis novel Laskar Pelangi?', 'ANDREAHIRATA', '2024-06-03 17:28:51'),
(215, 'Tari tradisional dari Bali?', 'KECAK', '2024-06-03 17:28:51'),
(216, 'Presiden kedua Indonesia?', 'SOEHARTO', '2024-06-03 17:28:51'),
(217, 'Perang terbesar di Aceh?', 'PERANGACEH', '2024-06-03 17:28:51'),
(218, 'Pusat pemerintahan kerajaan Sriwijaya?', 'PALEMBANG', '2024-06-03 17:28:51'),
(219, 'Mata uang Indonesia?', 'RUPIAH', '2024-06-03 17:28:51'),
(220, 'Pakaian adat dari Jawa Barat?', 'KEBAYA', '2024-06-03 17:28:51'),
(221, 'Tempat kelahiran Bung Karno?', 'BLITAR', '2024-06-03 17:28:51'),
(222, 'Hewan khas Kalimantan?', 'ORANGUTAN', '2024-06-03 17:28:51'),
(223, 'Nama candi di Jawa Tengah?', 'BOROBUDUR', '2024-06-03 17:28:51'),
(224, 'Pelabuhan terbesar di Indonesia?', 'TANJUNGPRIOK', '2024-06-03 17:28:51'),
(225, 'Presiden Indonesia saat ini?', 'JOKOWI', '2024-06-03 17:28:51'),
(226, 'Nama kapal perang Indonesia?', 'KRI', '2024-06-03 17:28:51'),
(227, 'Ibukota provinsi Papua?', 'JAYAPURA', '2024-06-03 17:28:51'),
(228, 'Danau vulkanik di Sumatera?', 'TOBA', '2024-06-03 17:28:51'),
(229, 'Gubernur pertama Jakarta?', 'SUPRAPTO', '2024-06-03 17:28:51'),
(230, 'Pahlawan dari Makassar?', 'HASANUDDIN', '2024-06-03 17:28:51'),
(231, 'Makanan khas Bandung?', 'SEBLAK', '2024-06-03 17:28:51'),
(232, 'Festival budaya di Bali?', 'NYEPI', '2024-06-03 17:28:51'),
(233, 'Kota terbesar kedua di Indonesia?', 'SURABAYA', '2024-06-03 17:28:51'),
(234, 'Pulau di selatan Bali?', 'NUSAPENIDA', '2024-06-03 17:28:51'),
(235, 'Kerajaan terbesar di Sumatera?', 'SRIWIJAYA', '2024-06-03 17:28:51'),
(236, 'Presiden ketiga Indonesia?', 'HABIBIE', '2024-06-03 17:28:51'),
(237, 'Ibukota provinsi Jawa Barat?', 'BANDUNG', '2024-06-03 17:28:51'),
(238, 'Ibu kota provinsi Bali?', 'DENPASAR', '2024-06-03 17:28:51'),
(239, 'Sungai di Pulau Kalimantan?', 'MAHAKAM', '2024-06-03 17:28:51'),
(240, 'Gunung tertinggi di Jawa?', 'SEMERU', '2024-06-03 17:28:51'),
(241, 'Raja terakhir Majapahit?', 'BRAWIJAYA', '2024-06-03 17:28:51'),
(242, 'Hari pahlawan diperingati pada bulan?', 'NOVEMBER', '2024-06-03 17:28:51'),
(243, 'Penyusun naskah Sumpah Pemuda?', 'YAMIN', '2024-06-03 17:28:51'),
(244, 'Tari tradisional dari Bali?', 'KECAK', '2024-06-03 17:28:51'),
(245, 'Presiden kedua Indonesia?', 'SOEHARTO', '2024-06-03 17:28:51'),
(246, 'Perang terbesar di Aceh?', 'PERANGACEH', '2024-06-03 17:28:51'),
(247, 'Pusat pemerintahan kerajaan Sriwijaya?', 'PALEMBANG', '2024-06-03 17:28:51'),
(248, 'Mata uang Indonesia?', 'RUPIAH', '2024-06-03 17:28:51'),
(249, 'Pakaian adat dari Jawa Barat?', 'KEBAYA', '2024-06-03 17:28:51'),
(250, 'Tempat kelahiran Bung Karno?', 'BLITAR', '2024-06-03 17:28:51'),
(251, 'Hewan khas Kalimantan?', 'ORANGUTAN', '2024-06-03 17:28:51'),
(252, 'Nama candi di Jawa Tengah?', 'BOROBUDUR', '2024-06-03 17:28:51'),
(253, 'Pelabuhan di Jawa Timur?', 'TANJUNGPERAK', '2024-06-03 17:28:51'),
(254, 'Presiden Indonesia saat ini?', 'JOKOWI', '2024-06-03 17:28:51'),
(255, 'Nama kapal perang Indonesia?', 'KRI', '2024-06-03 17:28:51'),
(256, 'Ibukota provinsi Papua?', 'JAYAPURA', '2024-06-03 17:28:51'),
(257, 'Danau vulkanik di Sumatera?', 'TOBA', '2024-06-03 17:28:51'),
(258, 'Gubernur pertama Jakarta?', 'SUPRAPTO', '2024-06-03 17:28:51'),
(259, 'Pahlawan dari Makassar?', 'HASANUDDIN', '2024-06-03 17:28:51'),
(260, 'Makanan khas Bandung?', 'SEBLAK', '2024-06-03 17:28:51'),
(261, 'Festival budaya di Bali?', 'NYEPI', '2024-06-03 17:28:51'),
(262, 'Kota terbesar kedua di Indonesia?', 'SURABAYA', '2024-06-03 17:28:51'),
(263, 'Pulau di selatan Bali?', 'NUSAPENIDA', '2024-06-03 17:28:51'),
(264, 'Kerajaan terbesar di Sumatera?', 'SRIWIJAYA', '2024-06-03 17:28:51'),
(265, 'Presiden ketiga Indonesia?', 'HABIBIE', '2024-06-03 17:28:51'),
(266, 'Ibukota provinsi Jawa Barat?', 'BANDUNG', '2024-06-03 17:28:51'),
(267, 'Laut di antara Sumatera dan Jawa?', 'SELATSUNDA', '2024-06-03 17:28:51');

-- --------------------------------------------------------

--
-- Table structure for table `jigsaw_puzzle`
--

CREATE TABLE `jigsaw_puzzle` (
  `id` int(11) NOT NULL COMMENT 'Primary Key',
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `upload_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `opt1` varchar(255) NOT NULL,
  `opt2` varchar(255) NOT NULL,
  `opt3` varchar(255) NOT NULL,
  `opt4` varchar(255) NOT NULL,
  `answers` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `name`, `opt1`, `opt2`, `opt3`, `opt4`, `answers`) VALUES
('1', 'Sebutkan Sila Pertama Pancasila!?', 'Kemanusiaan yang Adil dan Beradab', 'Ketuhanan yang Maha Esa', 'Persatuan Indonesia', 'Kerakyatan yang Dipimpin oleh Hikmat Kebijaksanaan dan Permusyawaratan/Perwakilan', 'Ketuhanan yang Maha Esa'),
('2', 'Siapa yang pertama kali mengusulkan konsep Pancasila dalam sidang BPUPKI', 'Moh. Hatta', 'Sutan Sjahrir', 'Ir. Soekarno', 'Mohammad Yamin', 'Ir. Soekarno'),
('3', 'Pada tanggal berapa Pancasila ditetapkan sebagai dasar negara Indonesia?', '17 Agustus 1945', '18 Agustus 1945', '1 Juni 1945', '17 Juli 1945', '18 Agustus 1945'),
('4', 'Apa lambang dari sila kedua Pancasila', 'Pohon Beringin', 'Kepala Banteng', 'Bintang', 'Rantai', 'Rantai'),
('5', 'Apa Makna dari sila ketiga, \"Persatuan Indonesia\"?', 'Menjaga kerukunan antar umat beragama', 'Menjaga persatuan dan kesatuan nasional', 'Melakukan musyawarah untuk mufakat', 'Menghormati hak asasi manusia', 'Menjaga persatuan dan kesatuan nasional');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(155) NOT NULL,
  `name` varchar(155) DEFAULT NULL,
  `marks` int(155) DEFAULT NULL,
  `game_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `marks`, `game_type`) VALUES
(1, 'jaja', 5, 'tts'),
(2, 'haha', NULL, NULL),
(3, 'hahah', NULL, NULL),
(4, 'jajaja', 0, 'tts'),
(5, 'jaja', 5, 'gambar'),
(6, 'rara', 5, 'gambar'),
(7, 'jajaja', 0, 'quiz'),
(8, 'jajaja', 0, 'quiz'),
(9, 'hahaha', 1, 'tts'),
(10, 'jajajaj', 5, 'gambar'),
(11, 'jaja', NULL, NULL),
(12, 'jajaj', 5, 'gambar'),
(13, 'Ivann', 2, 'tts');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `crossword_puzzle`
--
ALTER TABLE `crossword_puzzle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jigsaw_puzzle`
--
ALTER TABLE `jigsaw_puzzle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `modul`
--
ALTER TABLE `modul`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `crossword_puzzle`
--
ALTER TABLE `crossword_puzzle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key', AUTO_INCREMENT=268;

--
-- AUTO_INCREMENT for table `jigsaw_puzzle`
--
ALTER TABLE `jigsaw_puzzle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key', AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `modul`
--
ALTER TABLE `modul`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(155) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
