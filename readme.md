# Hackathon 2019

## How to initialize
1. Open your terminal (or git bash or whatever) and navigate to the folder you want to store your project in.
2. Clone this project
3. Open IntelliJ and import project with external model and maven. Remember to import maven. This can be done by clicking the pop’up and selecting `import`. Else you can right click the `pom.xml` file and select `maven` and `import`
4. Add new configuration in the top of IntelliJ. Select `tomcat` → `local` and click `fix` in the bottom where you have a warning. 
5. make a copy of `config.dist.json` called `config.json` and change the values to your database credentials.
6. Open a connection to you MySQL database (can be done directly through the terminal, or Workbench or Sequel Pro ) and run the `init.sql` script which can be found in the resources folder.
7. Run your server
8. If everything works as it should you can go to `localhost:8080/customers` which should retrieve one customer.

## Fix the To Do’s 
In IntelliJ you can select the TODO tab in the bottom (or search for TODO) which will list all the items, that you have to complete. 

You can get inspiration from the already finished `getCustomers` which is done in both the database and the controller. 

## Handle multiple tellers/clients
Find a way to implement support for multiple tellers accessing the same server at the same time. This should be implemented in all functions, where you might experience conflicts.

Hint: look into the exercise regarding scalability.  

## Client
Next up is build you client, which can be found here <github-link>
