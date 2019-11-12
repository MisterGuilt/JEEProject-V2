# JEEProject-V2

This application requires a SQL database named "emanagement". Use the following script to generate the tables.

Employee login is empl, empl

Admin login is admin, admin

Javadoc can be generated from the comments

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `telhome` varchar(10) NOT NULL,
  `telmob` varchar(10) NOT NULL,
  `telpro` varchar(10) NOT NULL,
  `adress` varchar(150) NOT NULL,
  `postalcode` varchar(5) NOT NULL,
  `city` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `firstname`, `telhome`, `telmob`, `telpro`, `adress`, `postalcode`, `city`, `email`) VALUES
(6, 'Brown', 'Charlie', '0122456678', '0699854673', '0623445166', '140 avenue Foche', '90000', 'Nanterre', 'cbrown@live.com'),
(5, 'Woodpecker', 'Woody', '0187384987', '0622494256', '0674178654', '5 bvd des Picoreurs', '21000', 'Dijon', 'woody@mail.co.uk'),
(4, 'Mafalda', 'Querida', '0187611987', '0783334256', '0658878654', '6 rue de Buenos Aires', '75016', 'Paris', 'qmafalda@hotmail.ar'),
(3, 'Lagaffe', 'Gaston', '0187665987', '0623334256', '0654778654', '65 rue de la Paresse', '92700', 'Colombes', 'glagaffe@yahoo.fr'),
(1, 'Simpson', 'Homer', '0123456789', '0612345678', '0698765432', '2 avenue Duff', '92700', 'Colombes', 'hsimpson@gmail.com'),
(2, 'Simpson', 'Bart', '0145362787', '0645362718', '0611563477', '10 rue des Rebelles', '92270', 'Bois-colombes', 'bsimpson@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(25) NOT NULL,
  `PWD` varchar(25) NOT NULL,
  `RANK` varchar(25) NOT NULL DEFAULT 'employee',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `LOGIN`, `PWD`, `RANK`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'empl', 'empl', 'employee');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;