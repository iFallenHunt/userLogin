# userLogin

This project performs the login and registration of new system users,

<img src="img\Screenshot_1.png" width="300">  <img src="img\Screenshot_2.png" width="317">


At this stage, the project is still in its beta version, and some improvements to the code are needed to make it as secure as possible.

 *How to log in*

The project used MySQL with some basic information:

- ID,
- NAME,
- LOGIN,
- PASSWORD
- EMAIL

**created as follows**

**CREATE SCHEMA `map` ;**

**CREATE TABLE `map`.`user` (**

  **`id` INT NOT NULL AUTO_INCREMENT,**

  **`name` VARCHAR(45) NULL,**

  **`login` VARCHAR(45) NULL,**

  **`password` VARCHAR(45) NULL,**

  **`email` VARCHAR(45) NULL,**

  **PRIMARY KEY (`id`));**

  
The first step in running this program requires the installation of [MySQL Conector 8.0.33](https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-8.1.0.zip)  if you are running NetBeans, but there is no need for other IDEs.

<img src="img\Screenshot_3.png" width="300">

When you clone the repository, you will notice that there is a package called mapaprogii.core.entity.dao.conexao;

in this package you need to insert the database `URL`, `USER` and `PASSWORD`.

<img src="img\Screenshot_4.png" width="300">

**Project in constant improvement, please feel free to contribute!**
