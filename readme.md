Numbers = commit msg “*” = action taken under the last commit

0-Setting base environment

1- Install and set environment for the spring boot

2-Install web dependancies

3-Create application

4-Create controller

5-Set basic endpoints (get account, create account, delete accounts, update accounts) 
      *Started server and tested if comes with the desired response.

6-Added needed dependencies data-jpa, mysql-connector-java 	*Gone to “https://mvnrepository.com/“ and found the both of the extensions ( data-jpa, mysql-connector-java)

7-Configure application.properties file

8-Create the AccountDetailsRequestModel (model that will be accepted from request endpoints).

9-Create the AccountRest(“model” that will be returned as responses).

10-Create AccountDto (data transform objects and adding UUID support).

11-Implmenting the AccountDto and the AccountRest. To the create endpoint
 	  * imported BeanUtils to copy properties from the request to the AccountRest
  	* then used beanUtils again to copyProperies from the database.(not implemented yet)

12-Create AccountServiceImplmentation and AccountServiceInterface.
# Studying-Spring-small-project-
