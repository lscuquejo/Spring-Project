# Technest-Spring-Boot-Rest-Exercise

## How to run application.



Numbers = commit msg 

-----

“*” = action taken under the last commit

-----

0-Setting base environment

1- Install and set environment for the spring boot

2-Install web dependancies

3-Create application

4-Create controller

5-Set basic endpoints (get account, create account, delete accounts, update accounts) 	
*Started server and tested if comes with the desired response.

6-Added needed dependencies data-jpa, mysql-connector-java 	
*Gone to “https://mvnrepository.com/“ and found the both of the extensions ( data-jpa, mysql-connector-java)

7-Configure application.properties file

8-Create the AccountDetailsRequestModel (model that will be accepted from request endpoints).

9-Create the AccountRest(“model” that will be returned as responses).

10-Create AccountDto (data transform objects and adding UUID support).

11-Implmenting the AccountDto and the AccountRest. To the create endpoint
 	*imported BeanUtils to copy properties from the request to the AccountRest
  	then used beanUtils again to copyProperies from the database.(not implemented yet)

12-Create AccountServiceImplmentation and AccountServiceInterface.

13-Create the AccountEntity to be the model given to the database.
	*set some parameter such as (nullable and length)
	
14-Create the AccountRepository (that will be handling everything from standards queries to te database)

15-Create function for the AccountServiceImplementation to handle the save into database 	*test it and it fails… 		*find error

16- Fix error temporarily that need to set id and it’s not auto generating.
	*test it and it passes. 17- checks if name is a full name (creation endpoint).

18- sets the only currency accepted from the bank (EUR it was not specified so I set it at the model to make it a little easier).

19- create the unique id generator using the secure bundle from java.utils

20-change the name field to be unique (Entity modification);

21- Create the get account endpoint (not working yet).

22- Create the get account by UId at the account service

23- Create the find by UId at the account Repository
 	*test it and find bugs
	
24- Add the Uid to be shown at the accountRest

25- Added dependency to handle both json and xml (Jackson-dataformat)

26- implemented the dependency into my controller.
        *test now it works both xml and json
	
27- create the error messages enum. (With the constants that I think I’m going to use for error handling)

28 - Added fast test of exception handler (account controller)

29 - Added an general exception handler (but it’s just giving me an exception with a string not json).

30- Created Customized ErrorMessage object and implemented it to 

31- Added the general exception handler to all api.

32 - Added the logic for the functionality of the updateAccount (not working cuz the repository does not have the needed function yet)

33 - fixed some naming problem and added uuid as a parameter for the function (not created yet).

34 - added update account functionality into account service implementation class.
	*tested it found bugs and fixed it
	
35 - created functionality, model and enum for the delete endpoint (not working yet need to apply the dele into the repository)

36 - Made the delete functionality and added to the  controller with a custom response

37 - started the logic for the list accounts (at the controller using pagination) not working yet need to apply the AccountRepository functionality

38- fixed list functionality and modified the repository to handle pagination
    * tested and it works like shine :)
    
39-  fixed that currency is set to eur only.

40-  adding new exception to the enum and implementing it

41 - added check if name already exists and if it does return exception.

42 - finish logic for end point transfer

43 - finish the logic that if teasurary its possible to have negative balance

44 -  created first test using mokito framwork

45 - dockerization
