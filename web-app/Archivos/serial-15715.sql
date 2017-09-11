-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-12-2016 a las 16:37:22
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `crmdev`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serial`
--

CREATE TABLE IF NOT EXISTS `serial` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `num_serial` varchar(20) DEFAULT NULL,
  `vencimiento_id` bigint(20) NOT NULL,
  `eliminado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCA01FDF4A6749B6A` (`vencimiento_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcado de datos para la tabla `serial`
--

INSERT INTO `serial` (`id`, `num_serial`, `vencimiento_id`, `eliminado`) VALUES
(1, 'A564231', 25, 0),
(2, 'A315645', 25, 0),
(3, 'A231256', 25, 0),
(4, 'A564231', 86, 0),
(5, 'A315645', 86, 0),
(6, 'A231256', 86, 0),
(7, 'A564231', 89, 0),
(8, 'A315645', 89, 0),
(9, 'A231256', 89, 0),
(10, 'A564231', 90, 0),
(11, 'A315645', 90, 0),
(12, 'A231256', 90, 0),
(13, 'ASERIAL1', 92, 0),
(14, 'ASERIAL2', 92, 0),
(15, 'ASERIAL3', 92, 0),
(16, 'ASERIAL4', 92, 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `serial`
--
ALTER TABLE `serial`
  ADD CONSTRAINT `FKCA01FDF4A6749B6A` FOREIGN KEY (`vencimiento_id`) REFERENCES `vencimientos` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
