--liquibase formatted sql
--changeset cleiton.sena:V001_create_person_table

CREATE TABLE revinfo
(
    id          int NOT NULL AUTO_INCREMENT,
    `timestamp`    BIGINT,
    auditor     VARCHAR(50),
    CONSTRAINT pk_tb_person_rev PRIMARY KEY (id)
);

--rollback drop table `revinfo`