-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 01-11-2023 a las 02:01:59
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectorestaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallemesas`
--

CREATE TABLE `detallemesas` (
  `idDetalleMesas` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idPedidos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepedidos`
--

CREATE TABLE `detallepedidos` (
  `idDetallePedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallepedidos`
--

INSERT INTO `detallepedidos` (`idDetallePedido`, `idProducto`, `idPedido`, `Cantidad`) VALUES
(150, 7, 112, 1),
(151, 6, 112, 1),
(152, 15, 112, 1),
(153, 10, 112, 1),
(154, 7, 113, 1),
(155, 15, 113, 1),
(157, 7, 113, 1),
(158, 7, 114, 1),
(159, 16, 115, 1),
(160, 7, 116, 1),
(161, 14, 116, 1),
(162, 7, 117, 1),
(163, 16, 117, 1),
(169, 7, 118, 1),
(170, 4, 119, 1),
(171, 13, 119, 1),
(173, 7, 119, 1),
(174, 7, 120, 1),
(175, 15, 120, 1),
(176, 18, 121, 1),
(177, 16, 121, 1),
(178, 6, 121, 1),
(179, 4, 122, 1),
(180, 16, 122, 2),
(181, 9, 122, 1),
(182, 17, 123, 5),
(183, 4, 123, 1),
(184, 18, 124, 1),
(185, 9, 124, 1),
(186, 9, 125, 1),
(187, 15, 125, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas`
--

CREATE TABLE `mesas` (
  `idMesa` int(11) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `Estado` varchar(30) NOT NULL,
  `Actividad` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesas`
--

INSERT INTO `mesas` (`idMesa`, `Capacidad`, `Estado`, `Actividad`) VALUES
(1, 5, 'LIBRE', 1),
(2, 5, 'LIBRE', 1),
(3, 10, 'LIBRE', 1),
(4, 7, 'LIBRE', 1),
(5, 6, 'LIBRE', 1),
(6, 7, 'LIBRE', 1),
(7, 5, 'LIBRE', 1),
(8, 8, 'LIBRE', 1),
(9, 6, 'LIBRE', 1),
(10, 6, 'LIBRE', 1),
(11, 8, 'LIBRE', 1),
(12, 6, 'LIBRE', 1),
(13, 10, 'LIBRE', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `meseros`
--

CREATE TABLE `meseros` (
  `idMesero` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  `Acceso` int(11) NOT NULL,
  `Contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `meseros`
--

INSERT INTO `meseros` (`idMesero`, `Nombre`, `Apellido`, `DNI`, `Estado`, `Acceso`, `Contraseña`) VALUES
(1, 'Emiliano', 'Stuer', 33067131, 1, 1, '123123'),
(2, 'Mariano Matias', 'Perez', 11111111, 1, 2, '1234'),
(3, 'Agustin Ivan', 'Stuer', 11123123, 1, 2, '1234'),
(5, 'Mariano Nahuel', 'Lopez', 22222222, 1, 2, '1234'),
(6, 'Carlos', 'Weimman', 33222111, 1, 2, '1234'),
(7, 'Matias', 'Ferraro', 11333444, 1, 2, '1234'),
(8, 'Victor Alberto', 'Martinez', 22333666, 1, 2, '1234'),
(9, 'Mauricio', 'Gomez', 11122333, 1, 2, '1234'),
(10, 'Fernando', 'Alberich', 22222333, 1, 2, '1234'),
(11, 'Enzo', 'Miranda', 55555555, 1, 2, '1234'),
(12, 'Samuel Martin', 'Barrios', 12234567, 1, 2, '1234'),
(13, 'Cala', 'Stuer', 66666666, 1, 2, '1234'),
(14, 'Marcos', 'Mota', 12312123, 1, 2, '1234'),
(15, 'Fabian', 'Silva', 12311112, 1, 2, '1234'),
(16, 'Cesar', 'Rivarola', 12345678, 0, 2, '1234'),
(17, 'Martin', 'Peralta', 12312345, 1, 2, '1234'),
(18, 'Martin', 'Lopez', 12300123, 1, 2, '1234'),
(19, 'Ezequiel', 'Montero', 12312344, 0, 2, '1234'),
(20, 'Micaela', 'Cortez', 12311123, 1, 2, '1234'),
(21, 'Rick', 'Morty', 12121212, 1, 2, '1234'),
(22, 'Carlos', 'Montero', 12312312, 1, 2, '1234'),
(23, 'Carlitos', 'Azcona', 12000000, 1, 2, '1234'),
(24, 'asdd', 'asdasda', 12312300, 1, 2, '1234'),
(26, 'Emito', 'Pelucardi', 44444123, 1, 2, '1234'),
(27, 'Martin', 'Cologne', 12332144, 1, 2, '1234'),
(28, 'Matias', 'Estupia', 12312399, 1, 2, '1234'),
(29, 'Raul', 'Pastrana', 45123888, 1, 2, '1234'),
(30, 'Catriel', 'Mapu', 55000222, 1, 2, '1234'),
(31, 'Pepe', 'Argento', 12388976, 1, 2, '1234'),
(32, 'Carolina', 'Resch', 67812346, 1, 2, '1234'),
(33, 'Lucas', 'Rojas', 65348123, 1, 2, '1234'),
(34, 'Coca', 'Sarli', 12312377, 1, 2, '1234'),
(35, 'Mikel', 'Matienzo', 12376456, 1, 2, '1234'),
(36, 'Marcela Fabiana', 'Miracola', 20332324, 1, 2, '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `idPedido` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idMesero` int(11) NOT NULL,
  `FechaPedido` date NOT NULL,
  `HoraPedido` time NOT NULL,
  `importe` double NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `Actividad` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`idPedido`, `idMesa`, `idMesero`, `FechaPedido`, `HoraPedido`, `importe`, `estado`, `Actividad`) VALUES
(17, 2, 5, '2023-10-26', '15:23:06', 250, 0, 'COBRADA'),
(18, 2, 5, '2023-10-26', '15:23:49', 6000, 0, 'COBRADA'),
(19, 3, 5, '2023-10-26', '15:28:10', 250, 0, 'COBRADA'),
(20, 3, 5, '2023-10-26', '15:28:35', 1500, 0, 'COBRADA'),
(23, 4, 5, '2023-10-26', '15:52:48', 3000, 0, 'COBRADA'),
(61, 5, 5, '2023-10-27', '01:14:29', 16000, 0, 'COBRADA'),
(62, 7, 5, '2023-10-27', '01:16:41', 6900, 0, 'COBRADA'),
(66, 1, 5, '2023-10-27', '11:32:19', 2800, 0, 'COBRADA'),
(67, 2, 5, '2023-10-27', '11:53:51', 4100, 0, 'COBRADA'),
(68, 4, 8, '2023-10-27', '13:09:30', 4900.4, 0, 'COBRADA'),
(69, 3, 10, '2023-10-27', '13:23:50', 3250, 0, 'COBRADA'),
(70, 5, 8, '2023-10-27', '13:55:50', 6301.2, 0, 'COBRADA'),
(71, 4, 8, '2023-10-27', '14:41:29', 3600.4, 0, 'COBRADA'),
(72, 4, 8, '2023-10-27', '14:43:27', 1300, 0, 'COBRADA'),
(73, 4, 8, '2023-10-27', '14:46:38', 1300, 0, 'COBRADA'),
(74, 4, 8, '2023-10-27', '14:49:27', 1300, 0, 'COBRADA'),
(75, 4, 8, '2023-10-27', '14:52:47', 1300, 0, 'COBRADA'),
(76, 4, 8, '2023-10-27', '14:54:01', 500, 0, 'COBRADA'),
(77, 4, 8, '2023-10-27', '14:57:54', 1300, 0, 'COBRADA'),
(78, 4, 8, '2023-10-27', '15:00:02', 800.4, 0, 'COBRADA'),
(79, 4, 8, '2023-10-27', '15:03:13', 7500, 0, 'COBRADA'),
(80, 4, 8, '2023-10-27', '15:05:26', 1500, 0, 'COBRADA'),
(81, 4, 8, '2023-10-27', '15:15:13', 1500, 0, 'COBRADA'),
(82, 4, 8, '2023-10-27', '15:16:09', 1500, 0, 'COBRADA'),
(87, 4, 8, '2023-10-27', '15:30:58', 11000, 0, 'COBRADA'),
(88, 9, 8, '2023-10-27', '15:32:15', 4400, 0, 'COBRADA'),
(103, 4, 5, '2023-10-28', '19:12:04', 0, 0, 'CANCELADA'),
(104, 5, 5, '2023-10-29', '00:33:45', 1800, 0, 'COBRADA'),
(105, 5, 8, '2023-10-29', '03:12:33', 6300, 0, 'COBRADA'),
(106, 1, 8, '2023-10-29', '03:13:50', 2500, 0, 'COBRADA'),
(107, 4, 5, '2023-10-29', '19:27:32', 5900, 0, 'COBRADA'),
(108, 4, 5, '2023-10-29', '19:28:46', 3500, 0, 'COBRADA'),
(109, 4, 5, '2023-10-29', '19:30:49', 2000, 0, 'COBRADA'),
(110, 7, 5, '2023-10-29', '19:31:54', 3000, 0, 'COBRADA'),
(111, 1, 2, '2023-10-29', '23:42:16', 7300, 0, 'COBRADA'),
(112, 1, 2, '2023-10-31', '00:25:21', 6300, 0, 'FACTURADA'),
(113, 2, 5, '2023-10-31', '12:52:05', 3500, 0, 'FACTURADA'),
(114, 3, 5, '2023-10-31', '13:09:47', 500, 0, 'CANCELADA'),
(115, 4, 5, '2023-10-31', '13:14:57', 1500, 0, 'FACTURADA'),
(116, 2, 5, '2023-10-31', '14:43:26', 2500, 0, 'FACTURADA'),
(117, 2, 5, '2023-10-31', '16:00:32', 2000, 0, 'FACTURADA'),
(118, 3, 5, '2023-10-31', '16:13:31', 500, 0, 'FACTURADA'),
(119, 7, 8, '2023-10-31', '19:09:31', 3800, 0, 'CANCELADA'),
(120, 9, 8, '2023-10-31', '19:11:12', 3000, 0, 'FACTURADA'),
(121, 2, 36, '2023-10-31', '21:24:15', 3800, 0, 'FACTURADA'),
(122, 5, 36, '2023-10-31', '21:25:16', 6300, 0, 'FACTURADA'),
(123, 8, 36, '2023-10-31', '21:25:46', 4300, 0, 'FACTURADA'),
(124, 2, 5, '2023-10-31', '21:42:39', 2800, 0, 'FACTURADA'),
(125, 6, 5, '2023-10-31', '21:42:53', 4500, 0, 'CANCELADA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Categoria` varchar(30) NOT NULL,
  `Precio` double NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `Nombre`, `Cantidad`, `Categoria`, `Precio`, `Estado`) VALUES
(1, 'Pizza Especial', 200, 'ALIMENTO', 2400, 1),
(2, 'Agua Mineral 500Ml', 20, 'BEBIDA', 700, 0),
(3, 'Tiramisu', 10, 'ALIMENTO', 800.4, 1),
(4, 'Coca Cola 2.5Lt', 30, 'BEBIDA', 1300, 1),
(5, 'Pizza Muzzarella', 100, 'ALIMENTO', 1500, 1),
(6, 'Cerveza Heineken 1Lt', 24, 'BEBIDA', 1500, 1),
(7, 'Agua Mineral 500ml', 50, 'ALIMENTO', 500, 1),
(8, 'Pizza Napolitana', 100, 'ALIMENTO', 2200, 1),
(9, 'Cerveza Andes IPA 1Lt', 36, 'BEBIDA', 2000, 1),
(10, 'Sorrentinos con salsa rosada', 100, 'ALIMENTO', 1800, 1),
(11, 'Ravioles con salsa bolognesa', 100, 'ALIMENTO', 1900, 1),
(12, 'Milanesa a Caballo', 100, 'BEBIDA', 2000, 0),
(13, 'Milanesa Napolitana', 100, 'ALIMENTO', 2000, 1),
(14, 'Milanesa con Pure', 100, 'ALIMENTO', 2000, 1),
(15, 'Milanesa con Papas Fritas', 100, 'ALIMENTO', 2500, 1),
(16, 'Choripan', 10, 'ALIMENTO', 1500, 1),
(17, 'Empanada de Pollo', 100, 'ALIMENTO', 600, 1),
(18, '7Up 500ml', 500, 'BEBIDA', 800, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `idReserva` int(11) NOT NULL,
  `NombreCliente` varchar(30) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  `idMesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detallemesas`
--
ALTER TABLE `detallemesas`
  ADD PRIMARY KEY (`idDetalleMesas`),
  ADD KEY `idMesa` (`idMesa`),
  ADD KEY `idPedidos` (`idPedidos`);

--
-- Indices de la tabla `detallepedidos`
--
ALTER TABLE `detallepedidos`
  ADD PRIMARY KEY (`idDetallePedido`),
  ADD KEY `idPedido` (`idPedido`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD PRIMARY KEY (`idMesa`);

--
-- Indices de la tabla `meseros`
--
ALTER TABLE `meseros`
  ADD PRIMARY KEY (`idMesero`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idMesa` (`idMesa`),
  ADD KEY `idMesero` (`idMesero`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`idReserva`),
  ADD UNIQUE KEY `DNI` (`DNI`),
  ADD KEY `idMesa` (`idMesa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detallemesas`
--
ALTER TABLE `detallemesas`
  MODIFY `idDetalleMesas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detallepedidos`
--
ALTER TABLE `detallepedidos`
  MODIFY `idDetallePedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=188;

--
-- AUTO_INCREMENT de la tabla `mesas`
--
ALTER TABLE `mesas`
  MODIFY `idMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `meseros`
--
ALTER TABLE `meseros`
  MODIFY `idMesero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallemesas`
--
ALTER TABLE `detallemesas`
  ADD CONSTRAINT `detallemesas_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesas` (`idMesa`),
  ADD CONSTRAINT `detallemesas_ibfk_2` FOREIGN KEY (`idPedidos`) REFERENCES `pedidos` (`idPedido`);

--
-- Filtros para la tabla `detallepedidos`
--
ALTER TABLE `detallepedidos`
  ADD CONSTRAINT `detallepedidos_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`),
  ADD CONSTRAINT `detallepedidos_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesas` (`idMesa`),
  ADD CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`idMesero`) REFERENCES `meseros` (`idMesero`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesas` (`idMesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
