# ExampleRESTJava

Example of a REST web service in Java with CRUD operations over an object stored in a simple MySQL table of countries that's made up of three fields:

- id
- name
- capital

It's a Netbeans project so it's better to test it using that IDE. [Insomnia](https://insomnia.rest) is a great REST tester if you don't have one already. The Netbeans' tester is not very good. Also I used Netbeans 8.2 which includes Glassfish 4.1.1

This example web service includes basic authentication. In order to test it you'll need to edit the realm of your Glassfish server and add  roles as well as users for those roles. This project has two roles: USER and ADMIN. You can add any users as long as they are associated to either of these roles.

It includes a **webclient** at **client.jsp** with HTML and jQuery. It doesn't have to be a JSP, it would work in PHP or any other language except for a call to a Java method to get the full path of the URL.

Before doing anything make sure that you have Glassfish and that it works well. Create a blank web project and test that the server displays a web page and that you can access the Glassfish dashboard (by default it should be http://localhost:4848). If it doesn't work check Services -> Servers on Netbeans right click and click Start. 