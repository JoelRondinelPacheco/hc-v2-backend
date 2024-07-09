INSERT INTO role (name) VALUES ('CLIENT');
INSERT INTO role (name) VALUES ('EMPLOYEE');
INSERT INTO role (name) VALUES ('ADMINISTRATOR');
INSERT INTO role (name) VALUES ('ASSISTANT_OWNER');
INSERT INTO role (name) VALUES ('OWNER');

INSERT INTO module_table (name, base_path) VALUES ('CLIENT', '/client');
INSERT INTO module_table (name, base_path) VALUES ('PAYMENT METHOD', '/payment-method');
INSERT INTO module_table (name, base_path) VALUES ('SALE', '/sale');
INSERT INTO module_table (name, base_path) VALUES ('SERVICE', '/service');
INSERT INTO module_table (name, base_path) VALUES ('CATEGORY', '/category'); -- 5
INSERT INTO module_table (name, base_path) VALUES ('EMPLOYEE', '/employee');
INSERT INTO module_table (name, base_path) VALUES ('AUTH', '/auth');
INSERT INTO module_table (name, base_path) VALUES ('SECURITY', '/security');

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_CLIENT', '', 'POST', false, 1);
-- TODO VER SI ES NECESARIO ESPECIFICAR LOS QUERY PARAM EN LA PAGINACION
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_CLIENT', '', 'GET', false, 1);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_ONE_CLIENT_BY_USERNAME','/[aA-zZ]*', 'GET', false, 1);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_ONE_CLIENT_BY_ID','/[0-9]*', 'GET', false, 1);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('UPDATE_ONE_CLIENT','/[0-9]*', 'PUT', false, 1); -- id 5
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('DELETE_ONE_CLIENT_BY_ID','/[0-9]*', 'DELETE', false, 1);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_ONE_PAYMENT_METHOD','', 'POST', false, 2);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_PAYMENT_METHOD','', 'GET', true, 2);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('UPDATE_ONE_PAYMENT_METHOD','', 'PUT', false, 2);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_SALE','', 'POST', false, 3); -- id 10
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_SALE','', 'GET', false, 3);
-- TODO VER COMO ESPECIFICAR DATE
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_SALE_BY_MONTH','', 'GET', false, 3);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_SALE_BY_DAY','', 'GET', false, 3);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_SERVICE','', 'POST', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_SERVICE','', 'GET', false, 4); -- id 15
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_ONE_SERVICE_BY_ID','/[0-9]*', 'GET', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('UPDATE_SERVICE','/[0-9]*', 'PUT', false, 4);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('DELETE_SERVICE','/[0-9]*', 'DELETE', false, 4);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_CATEGORY','', 'POST', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_CATEGORY','', 'GET', false, 5); -- id 20
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_ONE_CATEGORY_BY_ID','/[0-9]*', 'GET', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_SERVICES_BY_CATEGORY','', 'GET', false, 5);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('UPDATE_CATEGORY','/[0-9]*', 'PUT', false, 5);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_EMPLOYEE','','POST', false, 6);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_EMPLOYEE','','GET', false, 6); -- id 25
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_ONE_EMPLOYEE_BY_ID','/[0-9]*','GET', false, 6);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('UPDATE_EMPLOYEE','/[0-9]*','PUT', false, 6);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('LOGIN','/authenticate','POST', true, 7);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('LOGOUT','/logout','POST', true, 7);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('REFRESH','/refresh','POST', true, 7);

INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_MODULE','/module','POST', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_MODULE','/module','GET', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_OPERATION','/operation','POST', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_OPERATION','/operation','GET', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_GRANTED_PERMISSION','/granted-permission','POST', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_GRANTED_PERMISSION','/granted-permission','GET', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('CREATE_ROLE','/role','POST', false, 8);
INSERT INTO operation (name, path, http_method, permit_all, module_id) VALUES ('READ_PAGE_ROLE','/role','GET', false, 8);



INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 1);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 2);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 3);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 4);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 8);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 10);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 11);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 12);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 13);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 15);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 16);
INSERT INTO granted_permission (role_id, operation_id) VALUES (2, 20);

INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 1);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 2);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 3);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 4);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 5);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 6);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 7);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 8);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 9);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 10);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 11);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 12);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 13);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 14);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 15);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 16);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 17);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 18);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 19);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 20);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 21);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 22);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 23);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 24);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 25);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 26);
INSERT INTO granted_permission (role_id, operation_id) VALUES (3, 27);

-- CREACIÓN DE PERMISOS PARA RETO SECCION 11
