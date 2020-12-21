BEGIN;

DROP TABLE IF EXISTS customer_tbl1 CASCADE;
CREATE TABLE `customer_tbl1`
(
    `customer_id` int(11) NOT NULL AUTO_INCREMENT,
    `name_fld`    varchar(255) NOT NULL,
    PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into customer_tbl1 (name_fld) value ('John'), ('Poll'),('Garry'),('Klint');

DROP TABLE IF EXISTS product_tbl CASCADE;
CREATE TABLE `product_tbl1`
(
    `product_id` bigint(15) NOT NULL AUTO_INCREMENT,
    `title_fld`  varchar(255) NOT NULL,
    `cost_fld`   int(11) DEFAULT NULL,
    PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
insert into product_tbl (title_fld, cost_fld) value ('Boots',1299),
('Hat',3),
('Car',4),
('Cookies',2),
('Phone',5),
('Glasses',4);

DROP TABLE IF EXISTS customer_product_tbl CASCADE;
CREATE TABLE `customer_product_tbl`
(
    `customer_fld` int(11) DEFAULT NULL,
    `product_fld`  bigint(15) DEFAULT NULL,
    KEY            `product_id_fk_idx` (`product_fld`),
    KEY            `customer_id_fk_idx` (`customer_fld`),
    CONSTRAINT `customer_id_fk` FOREIGN KEY (`customer_fld`) REFERENCES `customer_tbl` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `product_id_fk` FOREIGN KEY (`product_fld`) REFERENCES `product_tbl` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into customer_product_tbl (customer_fld, product_fld) value (1,2),
(1,3),
(1,4),
(2,2),
(2,5),
(2,4);

COMMIT;