   use log4j1;
   CREATE TABLE `logs` (
`USER_ID` varchar(20) NOT NULL,
`DATED` varchar(100) NOT NULL,
`LOGGER` varchar(50) NOT NULL,
`LEVEL` varchar(10) NOT NULL,
`MESSAGE` varchar(1000) NOT NULL
)
select * from logs

use jdbcdemo1;
CREATE TABLE customer (
    id           int(11) AUTO_INCREMENT NOT NULL,
    firstname    varchar(45) NOT NULL,
    lastname     varchar(45) NOT NULL,
    PRIMARY KEY(id)
)

select * from customer;