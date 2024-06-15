-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2024 a las 08:09:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payment`
--

CREATE TABLE `payment` (
  `idPayment` int(11) NOT NULL,
  `idVehicle` int(11) NOT NULL,
  `idReservation` int(11) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `payment`
--

INSERT INTO `payment` (`idPayment`, `idVehicle`, `idReservation`, `idUser`) VALUES
(1, 3, 2, 4),
(2, 1, 1, 3),
(3, 3, 1, 1),
(4, 1, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservations`
--

CREATE TABLE `reservations` (
  `idReservation` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idVehicle` int(11) DEFAULT NULL,
  `reservationInit` datetime DEFAULT NULL,
  `reservationFinal` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservations`
--

INSERT INTO `reservations` (`idReservation`, `name`, `price`, `description`, `idUser`, `idVehicle`, `reservationInit`, `reservationFinal`) VALUES
(1, 'Ejemplo 1', 100.5, 'Descripción del primer registro', 1, 2, '2024-06-15 10:00:00', '2024-06-15 12:00:00'),
(2, 'Ejemplo 2', 75.25, 'Descripción del segundo registro', 2, 1, '2024-06-15 14:00:00', '2024-06-15 16:00:00'),
(3, 'Ejemplo 3', 120.75, 'Descripción del tercer registro', 3, 4, '2024-06-15 18:00:00', '2024-06-15 20:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `idUser` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`idUser`, `name`, `email`, `telephone`) VALUES
(1, 'Valeria Gutierrez', 'valeria@gmail.com', '315282530'),
(2, 'Juliana Hernandez', 'juliana@gmail.com', '3113445865'),
(3, 'Luis Arango', 'luis@gmail.com', '3214567899'),
(4, 'Maria Villa', 'ana@example.com', '3203428491'),
(5, 'Alejandro Marin', 'alejandro@gmail.com', '3006751297');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicles`
--

CREATE TABLE `vehicles` (
  `idVehicle` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `available` varchar(10) NOT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehicles`
--

INSERT INTO `vehicles` (`idVehicle`, `name`, `available`, `price`, `type`) VALUES
(1, 'Toyota Camry', 'Yes', 75000000, 'Sedán'),
(2, 'Honda CR-V', 'Yes', 96000000, 'SUV'),
(3, 'Ford Mustang', 'No', 135000000, 'Deportivo'),
(4, 'Nissan Rogue', 'Yes', 84000000, 'Crossover'),
(5, 'Chevrolet Silverado', 'No', 114000000, 'Camioneta');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`idPayment`);

--
-- Indices de la tabla `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`idReservation`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idUser`);

--
-- Indices de la tabla `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`idVehicle`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
