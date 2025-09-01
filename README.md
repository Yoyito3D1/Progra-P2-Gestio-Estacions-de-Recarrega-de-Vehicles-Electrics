# ⚡️ Electric Vehicle Charging Station Management

## 📋 Project Description
This Java project manages a list of electric vehicle charging stations.  
It allows reading data from a CSV file and provides multiple functionalities such as removing stations from a given city, finding the closest one to a specific location, filtering by charging speed type, and displaying the stations with the largest capacity or closest distance.

## 🚀 Main Features
- Read data from a CSV file containing up to 418 stations.  
- Interactive menu to select different operations:  
  - Remove stations from a city.  
  - Find the first station in a province and compare distances.  
  - Count stations by charging speed type.  
  - Show the station with the highest number of available slots.  
  - Show the nearest stations to a location with a configurable radius.  
  - Display all loaded stations.  
- Geographic distance calculation to determine proximity.  

## 🛠️ Usage
When executing the program, the user is asked how many lines from the file should be read (up to 418).  
The program reads data from the file `EstacionsRecarregaReduit.csv`.  
An interactive menu is displayed with different options to manipulate and query the stations.  
The user selects an option, and the program performs the corresponding action.  
The menu repeats until the user decides to exit.  

## 💻 How to Compile and Run
Make sure you have **Java JDK 8 or higher** installed.  

Compile the project (from the root folder where your `.java` files are located):  

javac -d bin aplicacio/UsaLlistaEstacionsVE.java

Run the program:  

java -cp bin aplicacio.UsaLlistaEstacionsVE

## 📂 Project Structure
- aplicacio/                     : Package containing the main class  
- dades/                         : Classes defining and managing stations  
- EstacionsRecarregaReduit.csv   : CSV file with station data  

## 📋 Requirements
- A valid CSV file located in the project root.  
- Java JDK 8 or higher.
