# Inventory and Order Control System

This repository contains the implementation of an inventory and order control system in Java, as specified below:

## Part 1 - Administrator Actor
- Supplier registration
- Product registration, relating them to suppliers
- Maintenance of product inventory

For each registration, the following functionalities were implemented:
- Inclusion
- Change
- Deletion
- Query (by code and by name)

In the first part of the project, arrays were used to contain the objects. In the second part, the arrays were replaced by Lists.

## Part 2 - Customer Actor
- Product query screen (with search) and order placement
- Shopping cart
- Order query screen
- Query by order number or date range

### Sales rules:
- Items can only be sold if they are in stock
- Items with ZERO stock are shown as unavailable in the query
- Placing an order reduces the stock quantity
- If the customer wants to buy more than is in stock, they receive an error message offering the maximum available quantity
- The total value of the order must be calculated and displayed to the customer

Screen for querying orders placed by store management (Internal Actor):
- Query by order number or order date

The application implements all the requirements specified in the document, following as a standard behavior websites such as Amazon, Mercado Livre, or AliExpress. The system is used by two actors: Internal and Customer, accessing the functionalities through menus.

## Class Model:
The class model of the proposed application is present in the source code.

## Work Division:
The work was divided into two parts. The first consisted of implementing the functionalities of registering Products (with Inventory), Customers (with Address), and Suppliers (with Address). The second part, with the complete application, was delivered at the end of the semester.

In the second part of the project, all data was saved in files and recovered at each program execution, simulating an application that uses databases. It was also necessary to use exceptions programmed by the developer, such as in the case of an insufficient quantity of products to place an order.

## Running the Program

To initialize the project on your computer, follow the steps below:

### Cloning the Repository

Open the terminal and navigate to the directory where you want to clone the repository. Then, execute the following command:

```bash
git clone https://github.com/luishvanni/trabalho-final-poo.git
```

### Setting up the Development Environment
Make sure you have the Java Development Kit (JDK) installed on your computer. You can check the installation using the java -version command. Open the project in a Java IDE, such as Eclipse or IntelliJ IDEA.


## Authors

- [@luishvanni](https://www.github.com/luishvanni)
