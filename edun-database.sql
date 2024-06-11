-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2024 at 08:38 PM
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

--
-- Dumping data for table `jigsaw_puzzle`
--

INSERT INTO `jigsaw_puzzle` (`id`, `name`, `path`, `upload_time`) VALUES
(1, 'iiuidthedmhxa8yhcdxa.jpg', 'src\\main\\resources\\assets\\JigsawPuzzleImages\\iiuidthedmhxa8yhcdxa.jpg', '2024-06-11 18:34:44');

-- --------------------------------------------------------

--
-- Table structure for table `modul`
--

CREATE TABLE `modul` (
  `id` int(15) NOT NULL,
  `tema` varchar(155) DEFAULT NULL,
  `materi` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `modul`
--

INSERT INTO `modul` (`id`, `tema`, `materi`) VALUES
(1, 'Pancasila', 'Pancasila adalah dasar ideologi negara Indonesia yang terdiri dari lima prinsip fundamental yang menjadi panduan dalam kehidupan berbangsa dan bernegara. Diperkenalkan oleh Presiden Soekarno pada 1 Juni 1945, Pancasila berfungsi sebagai landasan filosofi yang mengarahkan kebijakan dan sikap negara dalam berbagai aspek kehidupan. \r\n\r\nPrinsip pertama adalah Ketuhanan Yang Maha Esa, yang menegaskan bahwa negara Indonesia mengakui dan menghormati kepercayaan kepada Tuhan Yang Maha Esa, dengan menjamin kebebasan beragama dan kepercayaan bagi seluruh rakyat Indonesia. Prinsip kedua, Kemanusiaan yang Adil dan Beradab, mencerminkan komitmen terhadap kemanusiaan yang beradab, menghormati hak asasi manusia, dan menjunjung tinggi nilai-nilai kemanusiaan serta keadilan sosial.\r\n\r\nPrinsip ketiga, Persatuan Indonesia, menekankan pentingnya menjaga persatuan dan kesatuan bangsa Indonesia yang terdiri dari berbagai suku, agama, ras, dan golongan, serta mempromosikan rasa kebangsaan dan cinta tanah air. Prinsip keempat, Kerakyatan yang Dipimpin oleh Hikmat Kebijaksanaan dalam Permusyawaratan/Perwakilan, mendukung sistem demokrasi yang berlandaskan pada musyawarah dan perwakilan, di mana keputusan diambil melalui proses deliberatif yang mencerminkan aspirasi seluruh rakyat.\r\n\r\nTerakhir, prinsip Keadilan Sosial bagi Seluruh Rakyat Indonesia, menekankan pentingnya keadilan sosial dan pemerataan kesejahteraan bagi seluruh rakyat Indonesia, serta mengatasi kesenjangan sosial dan ekonomi. Pancasila menjadi fondasi bagi negara Indonesia dalam menjaga keberagaman, memperkuat persatuan, dan memajukan kesejahteraan bersama.'),
(2, 'HAM', 'Hak Asasi Manusia (HAM) di Indonesia adalah prinsip-prinsip fundamental yang diakui dan dilindungi oleh negara untuk menjamin kebebasan dan hak setiap individu. Setelah kemerdekaan Indonesia pada tahun 1945, komitmen terhadap HAM mulai terlihat dalam UUD 1945 yang mencakup berbagai pasal yang melindungi hak-hak dasar warga negara, seperti hak atas hidup, kebebasan beragama, kebebasan berkumpul, dan hak atas pendidikan.\r\n\r\nPada era Reformasi setelah 1998, perlindungan HAM di Indonesia semakin diperkuat dengan berbagai perubahan konstitusi dan undang-undang yang lebih tegas. Salah satu langkah signifikan adalah pembentukan Komisi Nasional Hak Asasi Manusia (Komnas HAM) pada tahun 1993, yang berfungsi sebagai lembaga independen untuk memantau, menyelidiki, dan mengadvokasi pelanggaran HAM.\r\n\r\nIndonesia juga meratifikasi berbagai instrumen internasional HAM, seperti Konvensi Internasional tentang Hak Sipil dan Politik, serta Konvensi Internasional tentang Hak Ekonomi, Sosial, dan Budaya. Pemerintah berusaha untuk menyesuaikan hukum nasional dengan standar internasional ini, meskipun pelaksanaannya masih menghadapi berbagai tantangan.\r\n\r\nIsu-isu kontemporer HAM di Indonesia mencakup berbagai aspek, mulai dari kebebasan berpendapat dan berekspresi, hak-hak perempuan dan anak, hingga perlindungan terhadap minoritas dan kelompok rentan lainnya. Meskipun ada kemajuan, masalah pelanggaran HAM masih sering terjadi, terutama terkait dengan kebebasan pers, hak-hak masyarakat adat, dan penanganan kasus-kasus pelanggaran HAM masa lalu yang belum terselesaikan.\r\n\r\nPemerintah dan masyarakat sipil terus berupaya untuk meningkatkan pemahaman dan penegakan HAM melalui pendidikan, advokasi, dan reformasi hukum. Upaya ini bertujuan untuk memastikan bahwa setiap individu di Indonesia dapat menikmati hak-hak mereka secara penuh, tanpa diskriminasi dan dengan perlindungan yang memadai dari negara.'),
(3, 'Politik', 'Politik di Indonesia adalah sistem yang kompleks dan dinamis yang telah mengalami banyak perubahan sejak kemerdekaan pada tahun 1945. Setelah kemerdekaan, Indonesia memasuki masa Orde Lama di bawah Presiden Soekarno yang mempromosikan ideologi \"Nasakom\" (Nasionalisme, Agama, dan Komunisme). Periode ini berakhir dengan peristiwa G30S/PKI pada tahun 1965 dan jatuhnya Soekarno, yang kemudian digantikan oleh Soeharto.\r\n\r\nMasa Orde Baru (1966-1998) di bawah Presiden Soeharto ditandai dengan stabilitas politik dan pertumbuhan ekonomi yang signifikan, tetapi juga dengan otoritarianisme, pelanggaran hak asasi manusia, dan korupsi yang merajalela. Soeharto akhirnya lengser pada tahun 1998 setelah krisis ekonomi Asia dan tekanan dari gerakan reformasi.\r\n\r\nEra Reformasi yang dimulai pada tahun 1998 membawa perubahan besar menuju demokrasi. Kebebasan pers, pemilu multipartai, dan desentralisasi kekuasaan menjadi ciri utama era ini. Indonesia menyelenggarakan pemilu yang bebas dan adil secara berkala, dengan partai-partai politik seperti PDI-P, Golkar, dan Partai Demokrat menjadi pemain utama.\r\n\r\nSistem pemerintahan Indonesia adalah republik presidensial, di mana presiden dipilih langsung oleh rakyat dan berfungsi sebagai kepala negara dan kepala pemerintahan. Setelah reformasi, Indonesia juga menerapkan otonomi daerah yang memberikan kewenangan lebih besar kepada pemerintah daerah dalam pengelolaan administrasi dan keuangan.\r\n\r\nLembaga-lembaga negara terdiri dari eksekutif (presiden dan kabinet), legislatif (Dewan Perwakilan Rakyat dan Dewan Perwakilan Daerah yang membentuk Majelis Permusyawaratan Rakyat), dan yudikatif (Mahkamah Agung, Mahkamah Konstitusi, dan Komisi Yudisial).\r\n\r\nSaat ini, Indonesia masih menghadapi berbagai tantangan dalam politik, termasuk korupsi yang masih menjadi masalah besar meskipun ada upaya pemberantasan oleh KPK. Demokrasi dan kebebasan berpendapat terus berkembang, meskipun ada tantangan terhadap kebebasan pers dan hak-hak sipil. Politik berbasis identitas agama dan etnis masih mempengaruhi dinamika politik, sementara pemerintah berupaya meningkatkan pertumbuhan ekonomi dan mengurangi kesenjangan sosial. Politik Indonesia mencerminkan keragaman budaya, etnis, dan agama yang sangat kaya, dengan dinamika yang terus berkembang.');

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
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `id` int(11) NOT NULL COMMENT 'Primary Key',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT 'Create Time',
  `name` varchar(255) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL,
  `game_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`id`, `create_time`, `name`, `marks`, `game_type`) VALUES
(24, '2024-06-05 09:56:52', 'Alice', 85, 'TTS'),
(25, '2024-06-05 09:56:52', 'Charlie', 77, 'TTS'),
(26, '2024-06-05 09:56:52', 'Bob', 90, 'TTS'),
(27, '2024-06-05 09:56:52', 'Charlie', 75, 'QUIZ'),
(28, '2024-06-05 09:56:52', 'David', 80, 'QUIZ'),
(29, '2024-06-05 09:56:52', 'Eve', 95, 'QUIZ'),
(30, '2024-06-05 09:56:52', 'Frank', 70, 'QUIZ'),
(31, '2024-06-05 09:56:52', 'Eve', 95, 'GAMBAR'),
(32, '2024-06-05 09:56:52', 'Frank', 70, 'GAMBAR'),
(33, '2024-06-05 09:56:52', 'Charlie', 75, 'GAMBAR'),
(34, '2024-06-05 09:56:52', 'Grace', 88, 'GAMBAR'),
(35, '2024-06-05 09:56:52', 'Hank', 78, 'TTS'),
(46, '2024-06-09 12:31:37', 'asd', 0, 'quiz'),
(47, '2024-06-09 12:31:39', 'asd', 0, 'QUIZ'),
(48, '2024-06-10 06:00:37', 'asep', 4, 'quiz'),
(49, '2024-06-10 06:00:42', 'asep', 80, 'QUIZ'),
(50, '2024-06-10 06:02:07', NULL, 0, 'TTS'),
(51, '2024-06-10 09:02:21', 'abcde', 2, 'quiz'),
(52, '2024-06-11 04:09:42', 'raya', 38, 'GAMBAR'),
(53, '2024-06-11 05:04:03', 'raya', 37, 'TTS'),
(54, '2024-06-11 15:41:17', 'abcd', 14, 'TTS'),
(55, '2024-06-11 15:41:38', 'abcd', 0, 'GAMBAR'),
(56, '2024-06-11 15:42:01', 'abcd', 1, 'quiz'),
(57, '2024-06-11 15:42:03', 'abcd', 20, 'QUIZ'),
(58, '2024-06-11 18:25:29', 'rakan', 0, 'GAMBAR'),
(59, '2024-06-11 18:27:30', 'rakan', 100, 'TTS');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(155) NOT NULL,
  `name` varchar(155) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`) VALUES
(1, 'jaja'),
(18, 'fajar'),
(19, 'asd'),
(20, 'asd'),
(21, 'asd'),
(22, 'asep'),
(23, 'asep'),
(24, 'rafa'),
(25, 'rafa'),
(26, 'asd'),
(27, ''),
(28, 'abcd'),
(29, 'abcde'),
(30, 'abcde'),
(31, 'abcde'),
(32, 'abcde'),
(33, 'ABCDE'),
(34, 'ABCDE'),
(35, 'ABCDE'),
(36, 'raya'),
(37, 'raya'),
(38, 'rafa'),
(39, 'rafa'),
(40, 'rt'),
(41, 'raya'),
(42, 'rata'),
(43, 'raya'),
(44, 'y'),
(45, 'mn'),
(46, 'raya'),
(47, 'fajar'),
(48, 'gung'),
(49, 'abcd'),
(50, 'abcd'),
(51, 'a'),
(52, 'abcd'),
(53, 'abcd'),
(54, 'abcd'),
(55, 'rakan');

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
-- Indexes for table `score`
--
ALTER TABLE `score`
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
-- AUTO_INCREMENT for table `modul`
--
ALTER TABLE `modul`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key', AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(155) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
