-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-01-2021 a las 21:01:58
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `afa`
--
CREATE DATABASE IF NOT EXISTS `afa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `afa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `cuit` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`cuit`, `nombre`, `categoria`) VALUES
(11335599, 'Racing Club', 'A'),
(12344321, 'Atletico Tucuman', 'A'),
(12345678, 'River Plate', 'A'),
(87654321, 'Boca Juniors', 'A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_jugadores`
--

CREATE TABLE `historial_jugadores` (
  `id` int(11) NOT NULL,
  `dni_jugador` int(11) NOT NULL,
  `cuit_equipo` int(11) NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `posicion` enum('DELANTERO','DEFENSOR','MEDIOCAMPISTA','ARQUERO') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historial_jugadores`
--

INSERT INTO `historial_jugadores` (`id`, `dni_jugador`, `cuit_equipo`, `fecha_inicio`, `fecha_fin`, `posicion`) VALUES
(1, 123456, 11335599, '2019-11-04', '2020-11-03', 'DELANTERO'),
(2, 123456, 12345678, '2020-12-03', NULL, 'DELANTERO'),
(3, 112233, 12345678, '2017-11-03', NULL, 'DEFENSOR'),
(4, 445566, 12345678, '2019-02-02', NULL, 'DEFENSOR'),
(5, 147852, 12345678, '2019-10-25', '2021-01-28', 'DEFENSOR'),
(6, 963214, 87654321, '2019-11-03', NULL, 'DELANTERO'),
(7, 154632, 87654321, '2019-11-03', NULL, 'MEDIOCAMPISTA'),
(8, 125834, 87654321, '2019-11-03', NULL, 'DEFENSOR'),
(9, 789625, 87654321, '2019-11-03', NULL, 'ARQUERO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`dni`, `nombre`, `apellido`) VALUES
(112233, 'Paulo', 'Diaz'),
(123456, 'Rafael Santos', 'Borré'),
(125834, 'Lisandro Ezequiel', 'López'),
(147852, 'Javier Horacio', 'Pinola'),
(154632, 'Eduardo', 'Salvio'),
(445566, 'Gonzalo', 'Montiel'),
(789625, 'Esteban', 'Andrada'),
(963214, 'Carlos', 'Tevéz');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`cuit`);

--
-- Indices de la tabla `historial_jugadores`
--
ALTER TABLE `historial_jugadores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dni_jugador` (`dni_jugador`),
  ADD KEY `cuit_equipo` (`cuit_equipo`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_jugadores`
--
ALTER TABLE `historial_jugadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial_jugadores`
--
ALTER TABLE `historial_jugadores`
  ADD CONSTRAINT `historial_jugadores_ibfk_1` FOREIGN KEY (`dni_jugador`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `historial_jugadores_ibfk_2` FOREIGN KEY (`cuit_equipo`) REFERENCES `equipos` (`cuit`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
