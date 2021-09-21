# CryptoKnights

## Project Description

Lightweight app for simulating buying, selling, and exchanging the most popular cryptocurrencies on the market. This project makes use of the CoinGecko API (https://www.coingecko.com/en/api). This is the REST API portion of this project. To view the single-page application portion of this project, please go here: https://github.com/210726-Enterprise/CryptoKnights-Webapp.

## Technologies Used

* Java 8
* Spring Boot
* Spring Data
* PostgreSQL
* Apache Maven
* JUnit 5
* Mockito

## Features

* Users can create and login to their account 
* Users can create and manage their portfolios
* Users can deposit and withdraw funds from their portfolios
* Users can purchase and sell crypto with their existing funds
* Users can exchange one type of crypto for another
* Users can view the total value of a portfolio

To-do list:
* Add a live ticker to track and view the current exchange rates of crypto
* Add support for additional types of crypto
* Add the ability to add a joint owner to a portfolio
* Add the ability to view the transaction history on a portfolio
* Stylize the webpages

## Getting Started
   
1. To start, please clone the project - git clone https://github.com/210726-Enterprise/CryptoKnights.git
2. Create a database and schema.
3. Open the back end project in IntelliJ.
4. Open the application.properties file, found in the resources folder.
5. Under Database Credentials, replace the information with the URL, username, and password for your database.
![Screenshot (133)](https://user-images.githubusercontent.com/23224121/133861838-28f6cf7a-1dc4-4222-8997-eddefeb06b09.png)
5. Under JPA Setting, "set spring.jpa.hibernate.ddl-auto" to true.
   * This will create all the tables in the database. After starting the application once, you may switch this to update if you would like to persist the data between sessions.
6. Open the CryptoKnightsApplication file and click the green arrow button on the left side of the screen next to "public class CryptoKnightsApplication". This will start a local Tomcat instance on the port http://localhost:8080/api.
![Screenshot (135)](https://user-images.githubusercontent.com/23224121/133862576-7707f2b9-5dd8-4ea7-8b88-b48a20032f12.png)
(What your console will look like if Tomcat was started up properly)
![Screenshot (136)](https://user-images.githubusercontent.com/23224121/133862727-38a9ca69-4c0c-42a0-bf83-60ed653efda1.png)

The REST API should now be active. To setup the web application, please reference the "Getting Started" section on the web application repo's README, which can be found here: https://github.com/210726-Enterprise/CryptoKnights-Webapp.

## Usage

To interface with the API through our web application, please reference the "Usage" section on the web application repo's README, which can be found here: https://github.com/210726-Enterprise/CryptoKnights-Webapp.

If you would like to use our API directly, you can make HTTP requests through Postman. The endpoints are listed below
* Portfolios 
   * http://localhost:8080/api/portfolios
      * supports GET, POST, and PUT requests
      * for POST and PUT requests, the body must have a JSON object, which may or may not contain these fields
         * portfolioId (required for PUT requests)
         * porfolio_name
         * bitcoin
         * ethereum
         * dogecoin
         * usd
         * transactions - a list of transaction id numbers
   * http://localhost:8080/api/portfolios/{id}
      * supports GET and DELETE requests
      * replace {id} with the id of the specific portfolio you're looking for 
* Users
   * http://localhost:8080/api/users/
      * supports GET, POST, and PUT requests
      * for POST and PUT requests, the body must have a JSON object, which may or may not contain these fields
         * userId (required for PUT requests)
         * username
         * password
         * firstName
         * lastName
         * email
         * portfolios - a list of portfolio id numbers
   * http://localhost:8080/api/users/{id}
      * supports GET and DELETE requests
      * replace {id} with the id of the specific user you're looking for
   * http://localhost:8080/api/users/username/{username}
      * supports GET requests
      * replace {username} with the username of the specific user you're looking for
* Transactions 
   * http://localhost:8080/api/transactions
      * supports GET and POST requests
      * for POST and PUT requests, the body must have a JSON object, which may or may not contain these fields 
         * transactionDateTime
         * transactionInCurrency
         * transactionInAmount
         * transactionOutCurrency
         * transactionOutAmount
         * portfolio - the portfolio id number that this transaction belongs to
   * http://localhost:8080/api/transactions/{portfolioId}
      * supports GET and DELETE requests
      * replace {id} with the id of the portfolio whose transaction history you'd like to view

## Contributors

* Victor Liu - https://github.com/cptvictor
* Jared Mullins - https://github.com/jwmullins92
* Jacob Brummett - https://github.com/Rufus1911
* Alwyn Zhang - https://github.com/AlwynZ

## License

The MIT License (MIT)
Copyright © 2021 Victor Liu, Jared Mullins, Jacob Brummett, Alwyn Zhang

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
