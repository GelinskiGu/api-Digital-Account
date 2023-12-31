CREATE TABLE `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `euatax_address` varchar(255) DEFAULT NULL,
  `addition_address` varchar(50) DEFAULT NULL,
  `back_photo_document` varchar(255) NOT NULL,
  `cell_phone_number` varchar(16) NOT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `city_address` varchar(50) NOT NULL,
  `city_birth` varchar(50) NOT NULL,
  `country_birth` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `date_birth` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `front_photo_document` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `income` decimal(38,2) NOT NULL,
  `investments` decimal(38,2) DEFAULT NULL,
  `issuer_document` varchar(255) NOT NULL,
  `marital_status` varchar(10) NOT NULL,
  `moveable_assets` decimal(38,2) DEFAULT NULL,
  `neighborhood` varchar(50) NOT NULL,
  `number_address` varchar(5) NOT NULL,
  `number_document` varchar(11) NOT NULL,
  `other_nationality` varchar(50) DEFAULT NULL,
  `other_patrimonies` decimal(38,2) DEFAULT NULL,
  `profession` varchar(50) NOT NULL,
  `real_estate_properties` decimal(38,2) DEFAULT NULL,
  `retirement_funds` decimal(38,2) DEFAULT NULL,
  `selfie_photo` varchar(255) NOT NULL,
  `state_address` varchar(20) NOT NULL,
  `state_birth` varchar(20) NOT NULL,
  `type_document` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
);