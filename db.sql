-- Membuat database eduN
CREATE DATABASE eduN;

-- Menggunakan database eduN
USE eduN;

-- Membuat tabel admin
CREATE TABLE admin (
    username VARCHAR(155),
    password VARCHAR(155)
);

-- Menyisipkan data ke dalam tabel admin
INSERT INTO admin (username, password)
VALUES ("admin", "admin");
