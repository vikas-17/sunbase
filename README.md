This is a simple project which performs the crud operations(insert,update,delete) in database using api.

Spring Boot – Back End Application
Angular – Front End Application
MySql- Database


# Database

if you are using existing database table then you must set this property as update in "application.properties" file-

"spring.jpa.hibernate.ddl-auto=update"

if not then set it as create so it will create new table each time

"spring.jpa.hibernate.ddl-auto=create" after running project you must change it to "update"  otherwise everytime it will create the new table with the specified name and it will delete the table if it already exist so your data will be lost. 


# Frontend
Installing Angular CLI by command:

-npm install -g @angular/cli

After that create the new Project of Angular running by the following command:
-ng new frontend --no-standalone --routing --ssr=false (Select the SCSS Style for the Advanced CSS and Press )

after this Creating a new Component Student Crud

-ng g c customer 

After that install the Bootstrap by typing the following command

-npm i bootstrap

After installed you have to set the path in to style.scss file

@import "bootstrap/dist/css/bootstrap.css";

# To Run
Backend-
Up the backend server by running it.

frontend- on command line type command:
-ng serve


# How works-

In the front page you will see the form to register the customer which has fields like 
first_name,last_name, street, address, city, state, email, phone.

after filling the fields click on "submit" button then alert message will appear "customer Registered Successfully" and the saved data will appear in table below.

update and delete:-

In the table there will be 2 options available "edit" and "delete":

Update-if we click on edit then the selected row data will appear on the form and we can edit the data in the fields and click on submit to submit the customer and alert will appear like "customer Registered Updated".

delete- if we click on delete button the selected row data will get deleted from the database and alert will appear like "customer Deleted"


