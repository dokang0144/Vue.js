-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.11.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- mydb 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `mydb`;
CREATE DATABASE IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `mydb`;

-- 테이블 mydb.board 구조 내보내기
DROP TABLE IF EXISTS `board`;
CREATE TABLE IF NOT EXISTS `board` (
  `IDX` int(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(50) DEFAULT NULL,
  `CONTENTS` text DEFAULT NULL,
  `AUTHOR` varchar(50) NOT NULL,
  `CREATED_AT` datetime NOT NULL,
  PRIMARY KEY (`IDX`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 mydb.board:~24 rows (대략적) 내보내기
DELETE FROM `board`;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` (`IDX`, `TITLE`, `CONTENTS`, `AUTHOR`, `CREATED_AT`) VALUES
	(1, '게시글 제목1', '게시글 내용1', '작성자1', '2022-02-18 23:24:00'),
	(2, '게시글 제목2', '게시글 내용2', '작성자2', '2022-02-18 23:24:00'),
	(3, '게시글 제목3', '게시글 내용3', '작성자3', '2022-02-18 23:24:00'),
	(4, '게시글 제목4', '게시글 내용4', '작성자4', '2022-02-18 23:24:00'),
	(5, '게시글 제목5', '게시글 내용5', '작성자5', '2022-02-18 23:24:00'),
	(6, '게시글 제목6', '게시글 내용6', '작성자6', '2022-02-18 23:24:00'),
	(7, '게시글 제목7', '게시글 내용7', '작성자7', '2022-02-18 23:24:00'),
	(8, '게시글 제목8', '게시글 내용8', '작성자8', '2022-02-18 23:24:00'),
	(9, '게시글 제목9', '게시글 내용9', '작성자9', '2022-02-18 23:24:00'),
	(10, '게시글 제목10', '게시글 내용10', '작성자10', '2022-02-18 23:24:00'),
	(11, '게시글 제목11', '게시글 내용11', '작성자11', '2022-02-18 23:24:00'),
	(12, '게시글 제목12', '게시글 내용12', '작성자12', '2022-02-18 23:24:00'),
	(13, '게시글 제목13', '게시글 내용13', '작성자13', '2022-02-18 23:24:00'),
	(14, '게시글 제목14', '게시글 내용14', '작성자14', '2022-02-18 23:24:00'),
	(15, '게시글 제목15', '게시글 내용15', '작성자15', '2022-02-18 23:24:00'),
	(16, '게시글 제목16', '게시글 내용16', '작성자16', '2022-02-18 23:24:00'),
	(17, '게시글 제목17', '게시글 내용17', '작성자17', '2022-02-18 23:24:00'),
	(18, '게시글 제목18', '게시글 내용18', '작성자18', '2022-02-18 23:24:00'),
	(19, '게시글 제목19', '게시글 내용19', '작성자19', '2022-02-18 23:24:00'),
	(20, '게시글 제목20', '게시글 내용20', '작성자20', '2022-02-18 23:24:00'),
	(21, '나는 문어', '꿈속에서는 무엇이든지 될 수 있어', '꿈을 꾸는 문어', '2023-03-16 14:45:53'),
	(23, '아', '아', '아', '2023-03-29 10:39:49'),
	(25, '123', '123', '123', '2023-04-05 14:02:15'),
	(29, 'qqq', '안녕\n안녀아\n아너ㅏㄹ이ㅓ\nㄴ아ㅣ러ㅣㅏ\nㄴㅇ러ㅏㅣ\n', 'qqq', '2023-04-05 15:23:37');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;

-- 테이블 mydb.comment 구조 내보내기
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `IDX` int(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `COMMENT` text DEFAULT NULL,
  `board` int(20) DEFAULT NULL,
  PRIMARY KEY (`IDX`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 mydb.comment:~21 rows (대략적) 내보내기
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`IDX`, `USER_NAME`, `COMMENT`, `board`) VALUES
	(1, '김유강', '안녕', 1),
	(2, '박재우', '안녕안녕', 1),
	(3, '김유강', '하이', 2),
	(4, '박재우', '하이하이', 2),
	(5, '문시영', '하이하이하이', 2),
	(20, '김김김', '124', 1),
	(21, '김유강', '응 아니야', 1),
	(26, '김김김', '안녕하세요', 25),
	(27, '김김', 'ㅁㅇ러ㅏㅣㅁㄴㅇㄹㅇ라ㅣ', 29),
	(28, '안녕', '안녕', 29),
	(29, '안녕', 'ㅈㅁㄴㅇ', 29),
	(30, '김유강', '안녕', 4),
	(31, '김유강', '안녕', 25),
	(32, '박재우', '하이', 25),
	(45, '1', '안녕', 29),
	(46, '이름', '17번 댓글입니다', 17),
	(48, 'ㅇㅇ', 'ㅎㅇ', 29),
	(49, '안녕', '아아', 23),
	(50, 'ㅇㅇ', '아', 23),
	(51, 'ㅇㅇ', '안녕', 20),
	(52, 'ㅇㅇ', 'ㅎㅇㅎㅇ', 20);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- 테이블 mydb.replies 구조 내보내기
DROP TABLE IF EXISTS `replies`;
CREATE TABLE IF NOT EXISTS `replies` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) NOT NULL,
  `REPLIES` text NOT NULL,
  `COMMENT` int(11) NOT NULL,
  PRIMARY KEY (`IDX`) USING BTREE,
  KEY `comment` (`COMMENT`) USING BTREE,
  CONSTRAINT `replies_ibfk_1` FOREIGN KEY (`COMMENT`) REFERENCES `comment` (`IDX`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 mydb.replies:~11 rows (대략적) 내보내기
DELETE FROM `replies`;
/*!40000 ALTER TABLE `replies` DISABLE KEYS */;
INSERT INTO `replies` (`IDX`, `USER_NAME`, `REPLIES`, `COMMENT`) VALUES
	(1, '김김다', 'ㅎㅇ', 27),
	(2, '김김다', 'ㅎㅇgd', 27),
	(4, 'ㅇㅇ', '안녕', 27),
	(5, 'ㅇㅇ', '너도 안녕', 28),
	(6, 'ㅇㅇ', 'ㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎㅇㅎ', 28),
	(7, 'ㅇㅇ', 'ㅎㅇㅎㅇㄶㄶㅁㅎㄶㄴㅁㅎㅁㅇㅎ', 29),
	(8, 'ㅇㅇ', '김김아', 27),
	(9, 'ㅇㅇ', '안녕하세여', 27),
	(10, 'ㅇㅇ', '안녕', 49),
	(11, 'ㅇㅇ', 'ㅎㅇ', 51),
	(12, 'ㅇㅇ', '안녕', 45);
/*!40000 ALTER TABLE `replies` ENABLE KEYS */;

-- 테이블 mydb.user 구조 내보내기
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `IDX` int(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(50) DEFAULT NULL,
  `USER_PW` varchar(100) DEFAULT NULL,
  `USER_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDX`) USING BTREE,
  UNIQUE KEY `USER_ID` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 mydb.user:~4 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`IDX`, `USER_ID`, `USER_PW`, `USER_NAME`) VALUES
	(1, 'dokang', '$2a$10$WPrKf1yIP25ZH8iInQ8zGutg/XOUXjVmxdYK0v8GZ4fYBk7lQrYAq', '김유강'),
	(2, '123', '$2a$10$V0KXoq41ddFjVoRQZ0v18OsXSH5F7HzcXglmzUSyTcHBYMLcZPXKC', '123'),
	(4, 'wasd', '$2a$10$D1qHR9lc8gDNsoRwhHPrTOE3pGy1v5SQNHVGpLXs5Dq2GZ68ZrIva', 'wasd'),
	(5, '1234', '$2a$10$Jf/fWuWDxtLBoxOD3U8toO0VpXDPMZIbkXDRSfZQWpxLqZPJJPbvG', '1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
