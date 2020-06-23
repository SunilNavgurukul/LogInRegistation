DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_user;

CREATE TABLE auth_role (
  auth_role_id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(255) DEFAULT NULL,
  role_desc varchar(255) DEFAULT NULL,
  PRIMARY KEY (auth_role_id)
);
INSERT INTO auth_role VALUES (1,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO auth_role VALUES (2,'SITE_USER','This user has access to site, after login - normal user');

CREATE TABLE auth_user (
  auth_user_id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  date_of_birth varchar(255) NOT NULL,
  mobile varchar(255) NOT NULL,
  unique_id varchar(255) NOT NULL,
  PRIMARY KEY (auth_user_id)
);

CREATE TABLE auth_user_role (
  auth_user_id int(11) NOT NULL,
  auth_role_id int(11) NOT NULL,
  PRIMARY KEY (auth_user_id,auth_role_id),
  KEY FK_user_role (auth_role_id),
  CONSTRAINT FK_auth_user FOREIGN KEY (auth_user_id) REFERENCES auth_user (auth_user_id),
  CONSTRAINT FK_auth_user_role FOREIGN KEY (auth_role_id) REFERENCES auth_role (auth_role_id)
) ;
