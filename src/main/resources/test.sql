-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2024 a las 03:56:16
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
  `idPayment` int(25) NOT NULL,
  `idVehicle` int(25) NOT NULL,
  `idReservation` int(25) NOT NULL,
  `idUser` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservation`
--

CREATE TABLE `reservation` (
  `idReservation` int(25) NOT NULL,
  `name` int(25) NOT NULL,
  `price` int(25) NOT NULL,
  `description` int(25) NOT NULL,
  `idUser` int(25) NOT NULL,
  `idVehicle` int(25) NOT NULL,
  `reservationInit` datetime NOT NULL,
  `reservationFinal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD PRIMARY KEY (`idPayment`),
  ADD KEY `FK_Pagos_Reservas` (`idReservation`),
  ADD KEY `FK_Pagos_Usuarios` (`idUser`),
  ADD KEY `FK_Pagos_Vehiculos` (`idVehicle`);

--
-- Indices de la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`idReservation`),
  ADD KEY `FK_Reservas_Usuarios` (`idUser`),
  ADD KEY `FK_Reservas_Vehiculos` (`idVehicle`);

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

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reservation`
--
ALTER TABLE `reservation`
  MODIFY `idReservation` int(25) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FK_Pagos_Reservas` FOREIGN KEY (`idReservation`) REFERENCES `reservation` (`idReservation`),
  ADD CONSTRAINT `FK_Pagos_Usuarios` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`),
  ADD CONSTRAINT `FK_Pagos_Vehiculos` FOREIGN KEY (`idVehicle`) REFERENCES `vehicles` (`idVehicle`);

--
-- Filtros para la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK_Reservas_Usuarios` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`),
  ADD CONSTRAINT `FK_Reservas_Vehiculos` FOREIGN KEY (`idVehicle`) REFERENCES `vehicles` (`idVehicle`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
