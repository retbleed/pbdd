-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 15-11-2022 a las 23:44:57
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `omnilife`
--
DROP DATABASE IF EXISTS omnilife;
CREATE DATABASE IF NOT EXISTS `omnilife` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `omnilife`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventarioomnilife`
--
DROP TABLE IF EXISTS `inventarioSyO`;
CREATE TABLE IF NOT EXISTS `inventarioSyO` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nomProducto` varchar(200) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `presentacion` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `contenido` varchar(100) NOT NULL,
  `stock` float NOT NULL,
  `marca` varchar(50) NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categpríasSt`
--

DROP TABLE IF EXISTS `categoriaSt`;
CREATE TABLE IF NOT EXISTS `categoriaSt` (
  `idCategoria` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombreCategoria` varchar(50)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaOm`
--

DROP TABLE IF EXISTS `categoriaOm`;
CREATE TABLE IF NOT EXISTS `categoriaOm` (
  `idCategoria` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombreCategoria` varchar(50)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `ID_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nom_Cliente` varchar(200) NOT NULL,
  `correo_Cliente` varchar(200) NOT NULL,
  `fNac_Cliente` date NOT NULL,
  `edad_Cliente` int(2) NOT NULL,
  `celular_Cliente` bigint(10) NOT NULL,
  `inv_Cliente` varchar(100) NOT NULL,
  `nip_Cliente` int(6) NOT NULL,
  `fecha_Registro`  date NOT NULL,
  `tarjeta_Cliente` bigint(16) NOT NULL,
  PRIMARY KEY (`ID_Cliente`),
  UNIQUE KEY `correo_Cliente` (`correo_Cliente`),
  UNIQUE KEY `tarjeta_Cliente` (`tarjeta_Cliente`),
  UNIQUE KEY `nip_Cliente` (`nip_Cliente`),
  UNIQUE KEY `celular_Cliente` (`celular_Cliente`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaClientes`
--

DROP TABLE IF EXISTS `categoriaClientes`;
CREATE TABLE IF NOT EXISTS `categoriaClientes` (
  `idCategoria` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombreCategoria` varchar(50),
  `comprasRequeridas` INT
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;


--  ----------------------------------------------------------

--
-- Estructura de tabla para la tabla `afiliados`
--

DROP TABLE IF EXISTS `afiliados`;
CREATE TABLE IF NOT EXISTS `afiliados` (
  `ID_Afiliado` int(11) NOT NULL AUTO_INCREMENT,
  `nom_Afiliado` varchar(200) NOT NULL,
  `correo_Afiliado` varchar(200) NOT NULL,
  `fNac_Afiliado` date NOT NULL,
  `edad_Afiliado` int(2) NOT NULL,
  `celular_Afiliado` bigint(10) NOT NULL,
  `inv_Afiliado` varchar(100) NOT NULL,
  `nip_Afiliado` int(6) NOT NULL,
  `fecha_Afiliación`  date NOT NULL,
  `tarjeta_Afiliado` bigint(16) NOT NULL,
  PRIMARY KEY (`ID_Afiliado`),
  UNIQUE KEY `correo_Afiliado` (`correo_Afiliado`),
  UNIQUE KEY `tarjeta_Afiliado` (`tarjeta_Afiliado`),
  UNIQUE KEY `nip_Afiliado` (`nip_Afiliado`),
  UNIQUE KEY `celular_Afiliado` (`celular_Afiliado`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriaAfiliados`
--

DROP TABLE IF EXISTS `descuentoAfiliados`;
CREATE TABLE IF NOT EXISTS `descuentoAfiliados` (
  `idDescuento` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `tipoDescuento` varchar(50),
  `ventasRequeridas` INT
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;




DROP PROCEDURE IF EXISTS spInsertarProducto;
DELIMITER $$
CREATE PROCEDURE spInsertarProducto(
IN paramNomProducto varchar(200),
IN paramDescripcion varchar(500),
IN paramPresentacion varchar(50),
IN paramPrecio float,
IN paramContenido varchar(100),
IN paramStock int,
IN paramMarca varchar(50))
BEGIN
	
    DECLARE varCategoria VARCHAR(100);
    
    IF paramNomProducto != (SELECT EXISTS (SELECT nomProducto FROM inventarioSyO WHERE nomProducto = paramNomProducto)) THEN
    
		SELECT 'Este producto ya existe' AS Mensaje;
    
    ELSE
		
        INSERT INTO inventarioSyO(nomProducto,
		descripcion,
		presentacion,
        categoria,
		precio,
		contenido,
		stock,
		marca)
		VALUES (paramNomProducto, 
		paramDescripcion, 
		paramPresentacion,
        varCategoria,
		paramPrecio,
		paramContenido,
		paramStock,
		paramMarca);
			
		SELECT 'Se registro el producto correctamente.' AS Mensaje;
		 
		 SELECT * FROM inventarioSyO;

    END IF;

END$$


DROP PROCEDURE IF EXISTS spInsertarClientes;
DELIMITER $$
CREATE PROCEDURE spInsertarClientes(
IN paramNom_Cliente varchar(200),
IN paramCorreo_Cliente varchar(200),
IN paramFNac_Cliente date,
IN paramEdad_Cliente int(2),
IN paramCelular_Cliente bigint(10),
IN paramInv_Cliente varchar(100),
IN paramNip_Cliente int(6),
IN paramFecha_Registro  date,
IN paramTarjeta_Cliente bigint(16))
BEGIN
	
    IF paramNom_Cliente != (SELECT EXISTS (SELECT nom_Cliente FROM clientes WHERE nom_Cliente = paramNom_Cliente)) THEN
    
		SELECT 'Este Cliente ya esta registrado' AS Mensaje;
    
    ELSE
		INSERT INTO clientes(nom_Cliente, 
		correo_Cliente, 
		fNac_Cliente, 
		edad_Cliente,
		celular_Cliente,
		inv_Cliente,
		nip_Cliente,
        fecha_Registro,
        tarjeta_Cliente)
		VALUES (paramNom_Cliente,
		paramCorreo_Cliente,
		paramFNac_Cliente,
		paramEdad_Cliente,
		paramCelular_Cliente,
		paramInv_Cliente,
		paramNip_Cliente,
        paramFecha_Registro,
        paramTarjeta_Cliente);
			
		SELECT 'Se registro el Cliente correctamente' AS Mensaje;
		 
		 SELECT * FROM clientes;

    END IF;

END$$


DROP PROCEDURE IF EXISTS spInsertarAfiliado;
DELIMITER $$
CREATE PROCEDURE spInsertarAfiliado(
IN paramNom_Afiliado varchar(200),
IN paramCorreo_Afiliado varchar(200),
IN paramFNac_Afiliado date,
IN paramEdad_Afiliado int(2),
IN paramCelular_Afiliado bigint(10),
IN paramInv_Afiliado varchar(100),
IN paramNip_Afiliado int(6),
IN paramFecha_Afiliación date,
IN paramTarjeta_Afiliado bigint(16))
BEGIN
	
    IF paramNom_Afiliado != (SELECT EXISTS (SELECT nom_Afiliado FROM afiliados WHERE nom_Afiliado = paramNom_Afiliado)) THEN
    
		SELECT 'Esta persona ya esta Afiliada' AS Mensaje;
    
    ELSE
    
    
    
    
    
    
    
		INSERT INTO afiliados(nom_Afiliado, 
		correo_Afiliado, 
		fNac_Afiliado, 
		edad_Afiliado,
		celular_Afiliado,
		inv_Afiliado,
		nip_Afiliado,
        fecha_Afiliación,
        tarjeta_Afiliado)
		VALUES (paramNom_Afiliado,
		paramCorreo_Afiliado,
		paramFNac_Afiliado,
		paramEdad_Afiliado,
		paramCelular_Afiliado,
		paramInv_Afiliado,
		paramNip_Afiliado,
        paramFecha_Afiliación,
        paramTarjeta_Afiliado);
			
		SELECT 'Se registro al Afiliado correctamente' AS Mensaje;
		 
		 SELECT * FROM afiliados;

    END IF;

END$$

DROP PROCEDURE IF EXISTS spEliminarProducto;
DELIMITER $$
CREATE PROCEDURE spEliminarProducto(
IN paramIdProducto INT)
BEGIN
	
    IF paramIdProducto = (SELECT EXISTS (SELECT idProducto FROM inventarioSyO)) THEN
    
		SELECT 'El Producto que desea eliminar no EXISTE' AS Mensaje;
        
    ELSE
		
        DELETE FROM inventarioSyO WHERE idProducto = paramIdProducto;
		SELECT 'Se elimino el producto del inventario CORRECTAMENTE' AS Mensaje;
		SELECT * FROM inventarioSyO;
		

    END IF;

END$$

DROP PROCEDURE IF EXISTS spEliminarClientes;
DELIMITER $$
CREATE PROCEDURE spEliminarClientes(
IN paramIdCliente INT)
BEGIN
	
    IF paramIdCliente = (SELECT EXISTS (SELECT ID_Cliente FROM clientes)) THEN
    
		SELECT 'El Cliente que desea eliminar no EXISTE' AS Mensaje;
        
    ELSE
		
        DELETE FROM clientes WHERE ID_Cliente = paramIdCliente;
		SELECT 'Se eliminaron los datos del Cliente CORRECTAMENTE' AS Mensaje;
		SELECT * FROM clientes;
		

    END IF;

END$$

DROP PROCEDURE IF EXISTS spEliminaraAfiliado;
DELIMITER $$
CREATE PROCEDURE spEliminaraAfiliado(
IN paramIdAfiliado INT)
BEGIN
	
    IF paramIdAfiliado = (SELECT EXISTS (SELECT ID_Afiliado FROM afiliados)) THEN
    
		SELECT 'El Afiliado que desea eliminar no EXISTE' AS Mensaje;
        
    ELSE
		
        DELETE FROM afiliados WHERE ID_Afiliado = paramIdAfiliado;
		SELECT 'Se eliminaron los datos del Afiliado CORRECTAMENTE' AS Mensaje;
		SELECT * FROM afiliados;
		

    END IF;

END$$

DROP PROCEDURE IF EXISTS spActualizarDatosInventario;
DELIMITER $$
CREATE PROCEDURE spActualizarDatosInventario(
IN paramNombreColumna varchar(100),
IN paramDatoNuevo varchar(100),
IN paramIdentificador INT)
BEGIN
	
    case
    
		WHEN paramNombreColumna = 'Nombre' THEN
			
            UPDATE inventarioSyO SET nomProducto = paramDatoNuevo WHERE idProducto = paramIdentificador;
            SELECT * FROM inventarioSyO;
            SELECT 'Se actualizo el nombre CORRECTAMENTE' AS Mensaje;
		
        WHEN  paramNombreColumna = 'Descripcion' THEN
        
			UPDATE inventarioSyO SET descripcion = paramDatoNuevo WHERE idProducto = paramIdentificador;
            SELECT * FROM inventarioSyO;
            SELECT 'Se actualizo la descripcion CORRECTAMENTE' AS Mensaje;
            
		WHEN  paramNombreColumna = 'Presentacion'  THEN
        
			UPDATE inventarioSyO SET presentacion = paramDatoNuevo WHERE idProducto = paramIdentificador;
            SELECT * FROM inventarioSyO;
            SELECT 'Se actualizo la presentacion CORRECTAMENTE' AS Mensaje;
            
		WHEN  paramNombreColumna = 'Contenido'  THEN
        
			UPDATE inventarioSyO SET contenido = paramDatoNuevo WHERE idProducto = paramIdentificador;
            SELECT * FROM inventarioSyO;
            SELECT 'Se actualizo contenido CORRECTAMENTE' AS Mensaje;
            
		WHEN  paramNombreColumna = 'Marca' THEN
        
			UPDATE inventarioSyO SET marca = paramDatoNuevo WHERE idProducto = paramIdentificador;
            SELECT * FROM inventarioSyO;
            SELECT 'Se actualizo la marca CORRECTAMENTE' AS Mensaje;
        
    END case;
    
    


END$$


DROP PROCEDURE IF EXISTS spActualizarStocks;
DELIMITER $$
CREATE PROCEDURE spActualizarStocks(
IN paramStockNuevo float,
IN paramIdentificador INT)
BEGIN
	
	UPDATE inventarioSyO SET stock = paramStockNuevo WHERE idProducto = paramIdentificador;
	SELECT 'Se actualizaron las existencias CORRECTAMENTE' AS Mensaje;
    SELECT * FROM inventarioSyO;
    


END$$

DROP PROCEDURE IF EXISTS spActualizarPrecios;
DELIMITER $$
CREATE PROCEDURE spActualizarPrecios(
IN paramPrecioNuevo float,
IN paramIdentificador INT)
BEGIN
	
	UPDATE inventarioSyO SET precio = paramPrecioNuevo WHERE idProducto = paramIdentificador;
	SELECT 'Se actualizaron los Precios CORRECTAMENTE' AS Mensaje;
    SELECT * FROM inventarioSyO;
    


END$$

DROP PROCEDURE IF EXISTS spActualizarDatosNombresyCorreos;
DELIMITER $$
CREATE PROCEDURE spActualizarDatosNombresyCorreos(
IN paramNombreTabla varchar(100),
IN paramNombreColumna varchar(100),
IN paramDatoNuevo varchar(100),
IN paramIdentificador INT)
BEGIN
	
    case
    
		WHEN paramNombreColumna = 'Nombre' AND paramNombreTabla = 'Afiliados' THEN
			
            UPDATE afiliados SET nom_Afiliado = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
            SELECT * FROM afiliados;
            SELECT 'Se actualizo el NOMBRE del Afiliado CORRECTAMENTE' AS Mensaje;
		
        WHEN  paramNombreColumna = 'Correo' AND paramNombreTabla = 'Afiliados' THEN
        
			UPDATE afiliados SET correo_Afiliado = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
            SELECT * FROM afiliados;
            SELECT 'Se actualizo el CORREO del Afiliado CORRECTAMENTE' AS Mensaje;
            
		WHEN paramNombreColumna = 'Nombre' AND paramNombreTabla = 'Clientes' THEN
			
            UPDATE clientes SET nom_Cliente = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
            SELECT * FROM clientes;
            SELECT 'Se actualizo el NOMBRE del Cliente CORRECTAMENTE' AS Mensaje;
		
        WHEN  paramNombreColumna = 'Correo' AND paramNombreTabla = 'Clientes' THEN
        
			UPDATE clientes SET correo_Cliente = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
            SELECT * FROM clientes;
            SELECT 'Se actualizo el CORREO del Cliente CORRECTAMENTE' AS Mensaje;
            
		END CASE;
    


END$$

DROP PROCEDURE IF EXISTS spActualizarFechas;
DELIMITER $$
CREATE PROCEDURE spActualizarFechas(
IN paramNombreTabla varchar(100),
IN paramNombreColumna varchar(100),
IN paramDatoNuevo date,
IN paramIdentificador INT)
BEGIN
	
	case
    
			WHEN  paramNombreColumna = 'Fecha de Nacimiento' AND paramNombreTabla = 'Afiliados' THEN
			
				UPDATE afiliados SET fNac_Afiliado = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
				SELECT * FROM afiliados;
				SELECT 'Se actualizo la FECHA DE NACIEMIENTO del Afiliado CORRECTAMENTE' AS Mensaje;
                
			WHEN  paramNombreColumna = 'Fecha de Afiliacion' AND paramNombreTabla = 'Afiliados' THEN
			
				UPDATE afiliados SET fecha_Afiliación  = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
				SELECT * FROM afiliados;
				SELECT 'Se actualizo la FECHA DE AFILIACION CORRECTAMENTE' AS Mensaje;
              
              
			WHEN  paramNombreColumna = 'Fecha de Nacimiento' AND paramNombreTabla = 'Clientes' THEN
			
				UPDATE clientes SET fNac_Cliente = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
				SELECT * FROM clientes;
				SELECT 'Se actualizo la FECHA DE NACIEMIENTO del Cliente CORRECTAMENTE' AS Mensaje;
                
			WHEN  paramNombreColumna = 'Fecha de Registro' AND paramNombreTabla = 'Clientes' THEN
			
				UPDATE clientes SET fecha_Registro = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
				SELECT * FROM clientes;
				SELECT 'Se actualizo la FECHA DE REGISTRO del Cliente CORRECTAMENTE' AS Mensaje;
			
    END case;

END$$

DROP PROCEDURE IF EXISTS spActualizarEdades;
DELIMITER $$
CREATE PROCEDURE spActualizarEdades(
IN paramNombreTabla varchar(100),
IN paramNombreColumna varchar(100),
IN paramDatoNuevo varchar(100),
IN paramIdentificador INT)
BEGIN
	
    IF paramDatoNuevo >= 18 THEN
		case
		
			WHEN  paramNombreColumna = 'Edad' AND paramNombreTabla = 'Afiliados' THEN
					
						UPDATE afiliados SET edad_Afiliado = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
						SELECT * FROM afiliados;
						SELECT 'Se actualizo la EDAD del Afiliado CORRECTAMENTE' AS Mensaje;
						
			WHEN  paramNombreColumna = 'Edad' AND paramNombreTabla = 'Clientes' THEN
					
						UPDATE clientes SET edad_Cliente = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
						SELECT * FROM clientes;
						SELECT 'Se actualizo la EDAD del Cliente CORRECTAMENTE' AS Mensaje;
			
				
				
		END case;
	
    else
		SELECT 'La Edad introducida debe ser MAYOR a 18 años' AS Mensaje;
    
    END IF;
	

END$$


DROP PROCEDURE IF EXISTS spActualizarNumCelular;
DELIMITER $$
CREATE PROCEDURE spActualizarNumCelular(
IN paramNombreTabla varchar(100),
IN paramNombreColumna varchar(100),
IN paramDatoNuevo varchar(100),
IN paramIdentificador INT)
BEGIN
	
    case
    
		WHEN  paramNombreColumna = 'Celular' AND paramNombreTabla = 'Afiliados' THEN
		
			UPDATE afiliados SET celular_Afiliado = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
			SELECT * FROM afiliados;
			SELECT 'Se actualizo el numero de CELULAR del Afiliado CORRECTAMENTE' AS Mensaje;
            
		WHEN  paramNombreColumna = 'Celular' AND paramNombreTabla = 'Clientes' THEN
		
			UPDATE clientes SET celular_Cliente = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
			SELECT * FROM clientes;
			SELECT 'Se actualizo el numero de CELULAR del Cliente CORRECTAMENTE' AS Mensaje;
		
        
		
    END CASE;
	

END$$


DROP PROCEDURE IF EXISTS spActualizarTargetaNip;
DELIMITER $$
CREATE PROCEDURE spActualizarTargetaNip(
IN paramNombreTabla varchar(100),
IN paramNombreColumna varchar(100),
IN paramDatoNuevo BIGINT,
IN paramIdentificador INT)
BEGIN
	
    case
    
		WHEN  paramNombreColumna = 'Nip' AND paramNombreTabla = 'Afiliados' THEN
			
			UPDATE afiliados SET nip_Afiliado = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
			SELECT * FROM afiliados;
			SELECT 'Se actualizo el NIP del Afiliado CORRECTAMENTE' AS Mensaje;
            
		WHEN  paramNombreColumna = 'Nip' AND paramNombreTabla = 'Clientes' THEN
			
			UPDATE clientes SET nip_Cliente = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
			SELECT * FROM clientes;
			SELECT 'Se actualizo el NIP del Cliente CORRECTAMENTE' AS Mensaje;
            
		WHEN  paramNombreColumna = 'Tarjeta' AND paramNombreTabla = 'Afiliados' THEN
			
			UPDATE afiliados SET tarjeta_Afiliado = paramDatoNuevo WHERE ID_Afiliado = paramIdentificador;
			SELECT * FROM afiliados;
			SELECT 'Se actualizo el numero de TARJETA del Afiliado CORRECTAMENTE' AS Mensaje;
            
		WHEN  paramNombreColumna = 'Tarjeta' AND paramNombreTabla = 'Clientes' THEN
			
			UPDATE clientes SET tarjeta_Cliente  = paramDatoNuevo WHERE ID_Cliente = paramIdentificador;
			SELECT * FROM clientes;
			SELECT 'Se actualizo el numero de TARJETA del Cliente CORRECTAMENTE' AS Mensaje;
        
		
    END CASE;
	

END$$


DROP PROCEDURE IF EXISTS spBuscarDatos;
DELIMITER $$
CREATE PROCEDURE spBuscarDatos(
IN paramNombreTabla varchar(100),
IN paramIdentificador INT)
BEGIN
	
    case
    
		WHEN  paramNombreTabla = 'Inventario' THEN
			
			SELECT * FROM inventarioSyO WHERE idProducto = paramIdentificador;
            
		WHEN  paramNombreTabla = 'Clientes' THEN
			
			SELECT * FROM clientes WHERE ID_Cliente = paramIdentificador;
            
		WHEN  paramNombreTabla = 'Afiliados' THEN
			
			SELECT * FROM afiliados WHERE ID_Afiliado = paramIdentificador;
            
    END CASE;
    
END$$




/* call spInsertarProducto('Fibern´n Plus Supreme', 'Suplemento alimenticio con inulina de agave, sabor durazno con endulzante de origen natural, estevia.', 'Caja', 550, '30 sobres de 450g', 100, 'OMNILIFE');
call spInsertarProducto('Cafezzino Plus', 'Suplemento alimenticio que contiene café colombiano, extracto de café verde, cromo e inulina. Con endulzante de origen natural, estevia.', 'Caja', 500, '30 sobres de 150g', 150, 'OMNILIFE');
call spInsertarProducto('OMNILIFE Shake Supreme', 'Polvo para preparar bebida, sabor a fresa, que contiene proteína, carbohidratos, inulina, vitamina A, complejo B, además de minerales: calcio, hierro, yodo, magnesio, zinc, cobre y molibdeno. Con endulzante de origen natural, estevia.', 'Caja', 505, '12 sobres de 600g', 163, 'OMNILIFE');
call spInsertarProducto('Labial líquido Mate Pa´Su Mecha KV', 'Acabado mate, alta cobertura, resistencia al agua, secado rápido, pigmento intenso que permanecerá intacto por horas. ', 'Labial', 285, '1 Labial liquido (Color morado metálico).', 100, 'SEYTÚ');


call spInsertarClientes('Olga Marina García Herrera', 'omgh_mary6584@gmail.com', '2000-06-28', 22, 6127862602, '', 499759, '2021-02-03', 9980856960446148);
call spInsertarClientes('Rene Leonel Cruz Romero ', 'rene_rom3298@gmail.com', '1990-04-06', 32, 6123546211, '', 985187, '2019-05-29', 2290754775497099);
call spInsertarAfiliado('Alejandro Méndez García', 'alem_Garz@gmail.com', '1968-10-02', 54, 491570006, '', 645913, '2020-08-21', 8860500001000004);
call spInsertarAfiliado('César Augusto Noriega Morales', 'ces_nrg846@gmail.com', '1994-08-03', 28, 1800160401, '', 938714, '2018-04-15', 6210470001370055);


call spEliminarProducto(21);
call spEliminarClientes(21);
call spEliminaraAfiliado(21);


call spActualizarDatosInventario ('Nombre', 'Cremita', 21);
call spActualizarDatosInventario ('Descripcion', 'Cremita pa la carita', 21);
call spActualizarDatosInventario ('Presentacion', 'Cremita en bote', 21);
call spActualizarDatosInventario ('Contenido', 'Cremita', 21);
call spActualizarDatosInventario ('Marca', 'ofnilaif', 21);


call spActualizarStocks (230, 21);


call spActualizarPrecios(5000, 21);
call spActualizarPrecios(1012, 22);


call spActualizarDatosNombresyCorreos('Afiliados', 'Nombre', 'Pepito', 21);
call spActualizarDatosNombresyCorreos('Afiliados', 'Correo', 'Pepito@gmail.com', 21);
call spActualizarDatosNombresyCorreos('Clientes', 'Nombre', 'Poncho', 21);
call spActualizarDatosNombresyCorreos('Clientes', 'Correo', 'Panocho@gmail.com', 21);


call spActualizarFechas('Afiliados', 'Fecha de Nacimiento','2010-10-10', 21);
call spActualizarFechas('Afiliados', 'Fecha de Afiliacion', '2022-11-05', 21);
call spActualizarFechas('Clientes', 'Fecha de Nacimiento', '1999-12-15', 21);
call spActualizarFechas('Clientes', 'Fecha de Registro', '2015-01-24', 21);


call spActualizarEdades('Afiliados', 'Edad', '50', 21);
call spActualizarEdades('Afiliados', 'Edad', '32', 22);
call spActualizarEdades('Clientes', 'Edad', '30', 21);
call spActualizarEdades('Clientes', 'Edad', '18', 22);


call spActualizarNumCelular('Afiliados', 'Celular', '6121500412', 21);
call spActualizarNumCelular('Afiliados', 'Celular', '6121055403', 22);
call spActualizarNumCelular('Clientes', 'Celular', '6121727367', 21);
call spActualizarNumCelular('Clientes', 'Celular', '6121319203', 22);


call spActualizarTargetaNip('Afiliados', 'Nip', 123456, 21);
call spActualizarTargetaNip('Afiliados', 'Tarjeta', 1112131415161718, 22);
call spActualizarTargetaNip('Clientes', 'Nip', '281002', 21);
call spActualizarTargetaNip('Clientes', 'Tarjeta', 2122232425262728, 22);


call spBuscarDatos('Inventario', 21);
call spBuscarDatos('Inventario', 22);
call spBuscarDatos('Clientes', 21);
call spBuscarDatos('Clientes', 22);
call spBuscarDatos('Afiliados', 21);
call spBuscarDatos('Afiliados', 22); */



INSERT INTO `categoriaSt` (`nombreCategoria`) VALUES
('LABIALES'),
('ESMALTES'),
('SOMBRAS'),
('MAQUILLAJE LÍQUIDO'),
('MAQUILLAJE COMPACTO'),
('CORRECTORES'),
('COMPACTOS'),
('POLVOS'),
('DELINEADORES'),
('SETS'),
('PESTAÑAS'),
('APLICADORES');



INSERT INTO `categoriaOm` (`nombreCategoria`) VALUES
('POLVOS'),
('BOTELLINES'),
('BOTELLAS'),
('LATAS'),
('BOTES'),
('GALLETAS');


INSERT INTO `categoriaClientes` (`idCategoria`, `nombreCategoria`, `comprasRequeridas`) VALUES
(1, 'NUEVO', 0),
(2, 'ACTIVO', 5),
(3, 'INACTIVO', 1),
(4, 'POTENCIAL', 10),
(5, 'PERIODICO', 2);

INSERT INTO `descuentoAfiliados` (`idDescuento`, `tipoDescuento`, `ventasRequeridas` ) VALUES
(1, '20', 0),
(2, '25', 50),
(3, '30', 100),
(4, '35', 175),
(5, '40', 250);