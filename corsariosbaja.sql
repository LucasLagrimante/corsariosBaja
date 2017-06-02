-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 01/06/2017 às 22:57
-- Versão do servidor: 5.7.18-0ubuntu0.16.04.1
-- Versão do PHP: 7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `corsariosbaja`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `arquitetura`
--

DROP TABLE IF EXISTS `arquitetura`;
CREATE TABLE IF NOT EXISTS `arquitetura` (
  `idArquitetura` int(11) NOT NULL,
  `caminhoImagem` varchar(100) NOT NULL,
  `FK_automovel` int(11) NOT NULL,
  PRIMARY KEY (`idArquitetura`),
  KEY `FK_automovel_arquitetura` (`FK_automovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `arquitetura`
--

INSERT INTO `arquitetura` (`idArquitetura`, `caminhoImagem`, `FK_automovel`) VALUES
(1, 'images/01', 1),
(2, 'images/02', 2),
(3, 'images/03', 3),
(4, 'images/04', 4),
(5, 'images/05', 5),
(6, 'images/06', 6),
(7, 'images/07', 7),
(8, 'images/08', 8),
(9, 'images/09', 9),
(10, 'images/010', 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `automovel`
--

DROP TABLE IF EXISTS `automovel`;
CREATE TABLE IF NOT EXISTS `automovel` (
  `idAutomovel` int(11) NOT NULL,
  `cor` varchar(15) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `dataTerminoProjeto` varchar(30) NOT NULL,
  `pesoCarro` float NOT NULL,
  `pesoChassi` float NOT NULL,
  `custoTotal` float NOT NULL,
  PRIMARY KEY (`idAutomovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `automovel`
--

INSERT INTO `automovel` (`idAutomovel`, `cor`, `nome`, `dataTerminoProjeto`, `pesoCarro`, `pesoChassi`, `custoTotal`) VALUES
(1, 'verde', 'Changan', '2018-05-04', 20, 50, 50),
(2, 'azul', 'Dodge', '2019-01-04', 40, 10, 40),
(3, 'marrom', 'Chevrolet', '2000-02-04', 70, 70, 20),
(4, 'rosa', 'Fiat', '2018-01-04', 80, 10, 29),
(5, 'preto', 'Yoshi', '2015-05-04', 90, 90, 119),
(6, 'rosa', 'Cayman', '2014-05-04', 5, 45, 5),
(7, 'preto', 'Boxer', '2011-05-02', 7, 245, 25),
(8, 'laranja', 'Actyon', '2014-05-04', 82, 5, 35),
(9, 'transparente', 'Audi', '2013-01-04', 60, 5, 9),
(10, 'prata', 'BMW', '2014-04-01', 5, 8, 35);

-- --------------------------------------------------------

--
-- Estrutura para tabela `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
CREATE TABLE IF NOT EXISTS `avaliacao` (
  `idAvaliacao` int(11) NOT NULL,
  `frequencia` int(11) NOT NULL,
  `comparecimento` varchar(50) NOT NULL,
  `data` varchar(30) NOT NULL,
  `FK_integrante` int(11) NOT NULL,
  PRIMARY KEY (`idAvaliacao`),
  KEY `FK_integrante_avaliacao` (`FK_integrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `avaliacao`
--

INSERT INTO `avaliacao` (`idAvaliacao`, `frequencia`, `comparecimento`, `data`, `FK_integrante`) VALUES
(1, 10, 'regular', '2012-10-02', 1),
(2, 20, 'otimo', '2013-10-17', 2),
(3, 30, 'pessimo', '2013-10-07', 3),
(4, 40, 'medio', '2013-10-01', 4),
(5, 50, 'medio', '2013-11-02', 5),
(6, 60, 'otimo', '2011-05-01', 6),
(7, 70, 'otimo', '2012-06-01', 7),
(8, 80, 'regular', '2013-07-01', 8),
(9, 90, 'pessimo', '2014-08-01', 9),
(10, 100, 'regular', '2015-09-01', 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `competicao`
--

DROP TABLE IF EXISTS `competicao`;
CREATE TABLE IF NOT EXISTS `competicao` (
  `idCompeticao` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `data` varchar(30) NOT NULL,
  `hora` varchar(8) NOT NULL,
  `FK_tipopista` int(11) NOT NULL,
  `local` varchar(40) NOT NULL,
  PRIMARY KEY (`idCompeticao`),
  KEY `FK_tipopista_competicao` (`FK_tipopista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `competicao`
--

INSERT INTO `competicao` (`idCompeticao`, `nome`, `data`, `hora`, `FK_tipopista`, `local`) VALUES
(1, 'Juiz de fora road', '04-10-2016', '10:00', 1, 'Juiz de fora'),
(2, 'Goianá road', '03-11-2016', '12:00', 2, 'Juiz de fora'),
(3, 'Maresp 2023', '2016-12-06', '10:00', 3, 'India'),
(4, 'Master Tecs', '07-03-2011', '16:00', 4, 'Siberia'),
(5, 'Julios Julios Global', '24-11-2012', '00:00', 5, 'Hawaii'),
(6, 'No name', '11-12-2013', '00:00', 6, 'Etiopia'),
(7, 'Corrida Verão', '11-11-2014', '00:00', 7, 'Goianá'),
(8, 'Minas road 2000', '21-1-2015', '00:00', 8, 'Florianopolis'),
(9, 'Corrida só', '30-11-2016', '00:00', 9, 'São Paulo'),
(10, 'Mario Kart', '21-09-2017', '00:00', 10, 'Aleatório');

-- --------------------------------------------------------

--
-- Estrutura para tabela `desempenho`
--

DROP TABLE IF EXISTS `desempenho`;
CREATE TABLE IF NOT EXISTS `desempenho` (
  `idDesempenho` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `data` varchar(30) NOT NULL,
  `hora` varchar(8) NOT NULL,
  `aceleracaoMedia` float NOT NULL,
  `velocidadeMedia` float NOT NULL,
  `tempoPista` varchar(10) NOT NULL,
  `frenagem` float NOT NULL,
  `FK_automovel` int(11) NOT NULL,
  `FK_tipopista` int(11) NOT NULL,
  `FK_motorista` int(11) NOT NULL,
  PRIMARY KEY (`idDesempenho`),
  KEY `FK_automovel_desempenho` (`FK_automovel`),
  KEY `FK_tipopista_desempenho` (`FK_tipopista`),
  KEY `FK_integrante_desempenho` (`FK_motorista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `desempenho`
--

INSERT INTO `desempenho` (`idDesempenho`, `nome`, `data`, `hora`, `aceleracaoMedia`, `velocidadeMedia`, `tempoPista`, `frenagem`, `FK_automovel`, `FK_tipopista`, `FK_motorista`) VALUES
(1, 'JFFFF', '2014-12-02', '16:00', 6, 33, '35', 9, 1, 1, 1),
(2, 'Fast Fast', '2015-10-02', '18:00', 7, 35, '30', 8, 2, 2, 2),
(3, 'Badumtis', '2012-09-02', '20:00', 8, 40, '50', 7, 3, 3, 3),
(4, 'JaCaGay', '2020-10-02', '22:00', 7, 32, '60', 6, 4, 4, 4),
(5, 'Esse nao deu', '2010-01-01', '22:00', 120, 32, '03:33', 120, 5, 5, 5),
(6, '123123', '2016-12-06', '03:39', 1231240, 1.2312, '03:34', 123123, 6, 6, 6),
(7, 'Esse deu', '2011-05-12', '22:00', 120, 32, '03:31', 120, 7, 7, 7),
(8, 'Floresta', '2012-01-25', '22:00', 120, 32, '03:34', 120, 8, 8, 8),
(9, 'Com, chuva', '2013-03-16', '22:00', 120, 32, '03:32', 120, 9, 9, 9),
(10, 'Terreno', '2014-02-18', '22:00', 120, 32, '03:38', 120, 10, 10, 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `desempenhoteste`
--

DROP TABLE IF EXISTS `desempenhoteste`;
CREATE TABLE IF NOT EXISTS `desempenhoteste` (
  `idDesempenhoTeste` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `data` varchar(30) NOT NULL,
  `hora` varchar(8) NOT NULL,
  `velocidadeMedia` float NOT NULL,
  `aceleracaoMedia` float NOT NULL,
  `tempoPista` varchar(8) NOT NULL,
  `frenagem` float NOT NULL,
  `FK_automovel` int(11) NOT NULL,
  `FK_tipopista` int(11) NOT NULL,
  `FK_motorista` int(11) NOT NULL,
  PRIMARY KEY (`idDesempenhoTeste`),
  KEY `FK_automovel_desempenhoteste` (`FK_automovel`),
  KEY `FK_tipopista_desempenhoteste` (`FK_tipopista`),
  KEY `FK_integrante_desempenhoteste` (`FK_motorista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `desempenhoteste`
--

INSERT INTO `desempenhoteste` (`idDesempenhoTeste`, `nome`, `data`, `hora`, `velocidadeMedia`, `aceleracaoMedia`, `tempoPista`, `frenagem`, `FK_automovel`, `FK_tipopista`, `FK_motorista`) VALUES
(1, 'JFFFF TESTE', '2014-12-02', '16:00', 6, 33, '01:33', 9, 1, 1, 1),
(2, 'Fast Fast TESTE', '2015-10-02', '18:00', 7, 35, '02:33', 8, 2, 2, 2),
(3, 'Badumtis TESTE', '2012-09-02', '20:00', 8, 40, '00:33', 7, 3, 3, 3),
(4, 'JaCaGay TESTE', '2020-10-02', '22:00', 7, 32, '02:33', 6, 4, 4, 4),
(5, 'Esse nao deu TESTE', '2010-01-01', '22:00', 120, 32, '03:33', 120, 5, 5, 5),
(6, '123123 TESTE', '2016-12-06', '03:39', 1231240, 1.2312, '03:34', 123123, 6, 6, 6),
(7, 'Esse deu TESTE', '2011-05-12', '22:00', 120, 32, '03:31', 120, 7, 7, 7),
(8, 'Floresta TESTE', '2012-01-25', '22:00', 120, 32, '03:34', 120, 8, 8, 8),
(9, 'Com, chuva TESTE', '2013-03-16', '22:00', 120, 32, '03:32', 120, 9, 9, 9),
(10, 'Terreno TESTE', '2014-02-18', '22:00', 120, 32, '03:38', 120, 10, 10, 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `design`
--

DROP TABLE IF EXISTS `design`;
CREATE TABLE IF NOT EXISTS `design` (
  `idDesign` int(11) NOT NULL,
  `caminhoImagem` varchar(100) NOT NULL,
  `FK_automovel` int(11) NOT NULL,
  PRIMARY KEY (`idDesign`),
  KEY `FK_automovel_design` (`FK_automovel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `design`
--

INSERT INTO `design` (`idDesign`, `caminhoImagem`, `FK_automovel`) VALUES
(1, 'images/01', 1),
(2, 'images/02', 2),
(3, 'images/03', 3),
(4, 'images/04', 4),
(5, 'images/05', 5),
(6, 'images/06', 6),
(7, 'images/07', 7),
(8, 'images/08', 8),
(9, 'images/09', 9),
(10, 'images/010', 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `frequencia`
--

DROP TABLE IF EXISTS `frequencia`;
CREATE TABLE IF NOT EXISTS `frequencia` (
  `idFrequencia` int(11) NOT NULL,
  `data` varchar(30) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `FK_integrante` int(11) NOT NULL,
  PRIMARY KEY (`idFrequencia`),
  KEY `FK_integrante_frequencia` (`FK_integrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `frequencia`
--

INSERT INTO `frequencia` (`idFrequencia`, `data`, `estado`, `FK_integrante`) VALUES
(1, '05/10/2016', 'presente', 1),
(2, '06/10/2016', 'ausente', 2),
(3, '07/11/2016', 'presente', 3),
(4, '08/11/2016', 'ausente', 4),
(5, '09/12/2016', 'presente', 5),
(6, '1012/2016', 'ausente', 6),
(7, '11/01/2016', 'presente', 7),
(8, '12/01/2016', 'ausente', 8),
(9, '2016-12-06', 'ausente', 9),
(10, '2016-12-06', 'ausente', 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `integrante`
--

DROP TABLE IF EXISTS `integrante`;
CREATE TABLE IF NOT EXISTS `integrante` (
  `matricula` int(6) NOT NULL,
  `cargaHorariaDisponivel` varchar(8) NOT NULL,
  `FK_pessoa` int(11) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `FK_pessoa_integrante` (`FK_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `integrante`
--

INSERT INTO `integrante` (`matricula`, `cargaHorariaDisponivel`, `FK_pessoa`) VALUES
(1, '10', 1),
(2, '20', 2),
(3, '30', 3),
(4, '40', 4),
(5, '50', 5),
(6, '60', 6),
(7, '11:22', 7),
(8, '05:34:00', 8),
(9, '05:34:00', 9),
(10, '05:34:00', 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `peca`
--

DROP TABLE IF EXISTS `peca`;
CREATE TABLE IF NOT EXISTS `peca` (
  `idPeca` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `modelo` varchar(40) NOT NULL,
  `precoCompra` float NOT NULL,
  `FK_tipopeca` int(11) NOT NULL,
  PRIMARY KEY (`idPeca`),
  KEY `FK_tipopeca_peca` (`FK_tipopeca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `peca`
--

INSERT INTO `peca` (`idPeca`, `quantidade`, `nome`, `modelo`, `precoCompra`, `FK_tipopeca`) VALUES
(1, 10, 'Turmo Socks', 'MRS4654', 500, 1),
(2, 2, 'WhatFu', 'MZX654', 100, 2),
(3, 5, 'Jolt', 'ASD4654', 150, 3),
(4, 16, 'BoleCag', 'MNN455', 654, 4),
(5, 16, 'EsquetMesst', '1g2J455', 654, 5),
(6, 16, 'Painels', '125MN45q', 654, 6),
(7, 16, 'Jpaisj', '12J475q', 654, 7),
(8, 16, 'Anything', '1NJ45a5', 654, 8),
(9, 16, 'Aname', '125MN55', 654, 9),
(10, 6, 'Sexri', 'sdfsdf', 565, 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE IF NOT EXISTS `pessoa` (
  `idPessoa` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `logradouro` varchar(40) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `bairro` varchar(40) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `numero` varchar(40) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `pessoa`
--

INSERT INTO `pessoa` (`idPessoa`, `nome`, `cpf`, `logradouro`, `cep`, `bairro`, `uf`, `numero`, `telefone`) VALUES
(1, 'Delfino', '100.289.589-00', 'Rua do Ze', '55093-500', 'Bairro do Ze', 'AC', '468', '32 9772-559'),
(2, 'Marquinho', '222.289.589-00', 'Rua do matão', '55093-500', 'Centro', 'SP', '654', '32 9977-559'),
(3, 'Seloco Junior', '999.289.589-00', 'Avenida 7', '55093-500', 'Centro', 'PE', '65', '32 9112-559'),
(4, 'Tião', '123.289.589-00', 'Esquina batata frita', '55093-500', 'Morro', 'BH', '879', '32 9972-559'),
(5, 'Julesca', '343.289.589-00', 'Logo ali', '55093-500', 'Morro', 'RJ', '79', '32 9972-229'),
(6, 'Maria', '999.289.456-00', 'Rua sem saída 99', '55093', 'Morro', 'MG', '654', '32 9973-453'),
(7, 'Lucas', '999.289.456-00', 'Rua sem saída 99', '55093', 'Morro', 'MG', '654', '32 9973-453'),
(8, 'Victor', '999.289.456-00', 'Rua sem saída 99', '55093', 'Morro', 'MG', '654', '32 9973-453'),
(9, 'Pablo', '999.289.456-00', 'Rua sem saída 99', '55093', 'Morro', 'MG', '654', '32 9973-453'),
(10, 'Tio Barnabé', '130.885.586-65', '65', '65656-556', 'sdfasdf', 'JK', '8686', '(00) 0000-0000');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipopeca`
--

DROP TABLE IF EXISTS `tipopeca`;
CREATE TABLE IF NOT EXISTS `tipopeca` (
  `idTipopeca` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  PRIMARY KEY (`idTipopeca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tipopeca`
--

INSERT INTO `tipopeca` (`idTipopeca`, `nome`) VALUES
(1, 'eixo'),
(2, 'parachoque'),
(3, 'paralama'),
(4, 'motor'),
(5, 'escapamento'),
(6, 'volante'),
(7, 'farol'),
(8, 'guidão'),
(9, 'injetor'),
(10, 'capô');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipopista`
--

DROP TABLE IF EXISTS `tipopista`;
CREATE TABLE IF NOT EXISTS `tipopista` (
  `idTipopista` int(11) NOT NULL,
  `nome` varchar(40) NOT NULL,
  PRIMARY KEY (`idTipopista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `tipopista`
--

INSERT INTO `tipopista` (`idTipopista`, `nome`) VALUES
(1, 'Pista de Terra'),
(2, 'Pista de Gelo'),
(3, 'Pista de Grama'),
(4, 'Pista Molhada'),
(5, 'Pista de Madeira'),
(6, 'Pista do Mario Kart'),
(7, 'Pista de Praia'),
(8, 'Pista de Lama'),
(9, 'Pista na Arvore'),
(10, 'Pista de Cavalo');

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `arquitetura`
--
ALTER TABLE `arquitetura`
  ADD CONSTRAINT `FK_arquitetura_automovel` FOREIGN KEY (`FK_automovel`) REFERENCES `automovel` (`idAutomovel`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD CONSTRAINT `FK_integrante_avaliacao` FOREIGN KEY (`FK_integrante`) REFERENCES `integrante` (`matricula`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `competicao`
--
ALTER TABLE `competicao`
  ADD CONSTRAINT `FK_tipopista_competicao` FOREIGN KEY (`FK_tipopista`) REFERENCES `tipopista` (`idTipopista`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `desempenho`
--
ALTER TABLE `desempenho`
  ADD CONSTRAINT `FK_automovel_desempenho` FOREIGN KEY (`FK_automovel`) REFERENCES `automovel` (`idAutomovel`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_integrante_desempenho` FOREIGN KEY (`FK_motorista`) REFERENCES `integrante` (`matricula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tipopista_desempenho` FOREIGN KEY (`FK_tipopista`) REFERENCES `tipopista` (`idTipopista`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `desempenhoteste`
--
ALTER TABLE `desempenhoteste`
  ADD CONSTRAINT `FK_automovel_desempenhoteste` FOREIGN KEY (`FK_automovel`) REFERENCES `automovel` (`idAutomovel`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_integrante_desempenhoteste` FOREIGN KEY (`FK_motorista`) REFERENCES `integrante` (`matricula`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_tipopista_desempenhoteste` FOREIGN KEY (`FK_tipopista`) REFERENCES `tipopista` (`idTipopista`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `design`
--
ALTER TABLE `design`
  ADD CONSTRAINT `FK_automovel_design` FOREIGN KEY (`FK_automovel`) REFERENCES `automovel` (`idAutomovel`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `frequencia`
--
ALTER TABLE `frequencia`
  ADD CONSTRAINT `FK_integrante_frequencia` FOREIGN KEY (`FK_integrante`) REFERENCES `integrante` (`matricula`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `integrante`
--
ALTER TABLE `integrante`
  ADD CONSTRAINT `FK_pessoa_integrante` FOREIGN KEY (`FK_pessoa`) REFERENCES `pessoa` (`idPessoa`) ON UPDATE CASCADE;

--
-- Restrições para tabelas `peca`
--
ALTER TABLE `peca`
  ADD CONSTRAINT `FK_tipopeca_peca` FOREIGN KEY (`FK_tipopeca`) REFERENCES `tipopeca` (`idTipopeca`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
