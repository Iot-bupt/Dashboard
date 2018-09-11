CREATE TABLE IF NOT EXISTS `dashboard` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `tenant_id` INT,
    `customer_id` INT,
	`name` varchar(31),
	PRIMARY KEY(`id`),
	KEY `relation_tenantId` (`tenant_id`),
	KEY `relation_customerId` (`customer_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `dashboard`
ADD CONSTRAINT `dashboard_tenantId` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`);

ALTER TABLE `dashboard`
ADD CONSTRAINT `dashboard_customerId` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

CREATE TABLE IF NOT EXISTS `widget_entity` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `dashboard_id` INT,
	`device_id` varchar(31),
	`name` varchar(31),
	`entity_type` varchar(31),
	`position` varchar(255),
	PRIMARY KEY(`id`),
	KEY `relation_dashboardId` (`dashboard_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `widget_entity`
ADD CONSTRAINT `widget_entity_dashboardId` FOREIGN KEY (`dashboard_id`) REFERENCES `dashboard` (`id`);
