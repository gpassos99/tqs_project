# EatsDelivery




# Project Abstract
EatsDelivery is an app like Uber Eats that allows users to order food from restaurants near their location that will be delivered by a rider.

# Project Team

Team Coordinator - Marta Ferreira
Product Owner - Luís Valentim
DevOps Master - Gonçalo Passos
QA Engineer - João Vasconcelos, Rita Ferrolho

# Instructions

## 1st: On terminal:

/sudo mysql --password

mysql> create db eatsdelivery;


## 2nd: To run each project, go to each project directory and use command /mvn spring-boot:run

## 3rd: Insert a few orders:

mysql> insert into orders(id, active, client, coordinates_client, coordinates_pick_up, courier_id, pick_up_name) values (1, 1, "Jorge", 60, 40, "0", "KFC");<br>
mysql> insert into orders(id, active, client, coordinates_client, coordinates_pick_up, courier_id, pick_up_name) values (2, 1, "Manuel", 40, 20, "0", "McDonalds Aveiro");

## 4th: Insert restaurants:

mysql> insert into restaurant (restaurant_id, restaurant_name, lat, lon, image) values (1, "McDonalds Aveiro", 50.0, 50.0, "/images/restaurants/mcdonalds.png");<br>
mysql> insert into restaurant (restaurant_id, restaurant_name, lat, lon, image) values (2, "KFC Glicínias", 100.0, 60.0, "/images/restaurants/kfc.png");<br>
mysql> insert into restaurant (restaurant_id, restaurant_name, lat, lon, image) values (3, "Burger King Glicínias", 40.63, -8.65, "/images/restaurants/bk.jpg");<br>
mysql> insert into restaurant (restaurant_id, restaurant_name, lat, lon, image) values (4, "Pizza Hut Fórum Aveiro", 40.64, -8.65, "/images/restaurants/pizzahut.png");


## 5th: Insert products:

mysql> insert into products (product_id, product_name, price, description, restaurant_id, image) values (1, "CheeseBurger", 1, "Hamburguer", 1, "/images/mcdonalds/t-mcdonalds-Cheeseburger.jpg");
mysql> insert into products (product_id, product_name, price, description, restaurant_id, image) values (2, "Big Tasty", 1.50, "Hamburguer", 2, "/images/mcdonalds/006_bigtasty_04_double_label.png");

# Documentation
[Product Specification Report](https://www.google.com) <br>
[QA Manual](https://www.google.com) <br>
[Shared Google Drive](https://drive.google.com/drive/folders/1zjzcV6-d80Iu5UTQMAQvateI-lRDypWi) <br>

# API Documentation
[API Endpoints](https://www.google.com)

# EatsDelivery Endpoints:

GET / - Login page
GET /register_client - Register page<br>
POST /register_client - Gets a valid Client profile and registers it within the database.<br>
POST /login_client - Gets credentials, verifies them and if they’re correct redirects to the home page.<br>
GET /{username}/EatsDelivery/home - Home page.<br>
GET /{username}/EatsDelivery/home/{keyword} - Search restaurant by {keyword}.<br>
GET /{username}/EatsDelivery/home/restaurants/{restaurant_id} - Gives all available products for a restaurant with {restaurant_id}.<br>
GET /{username}/EatsDelivery/home/restaurants/{restaurant_id}/{keyword} - Searches for a specific item {keyword} within a certain restaurant with {restaurant_id}.<br>
GET /{username}/EatsDelivery/user - User active orders and orders history.<br>

# Couriers API Endpoints:

GET /api/courier - Courier Login page. <br>
GET /api/courier/register_courier - Courier register page. <br>
POST /api/courier/register_courier - Gets a valid Courier profile and registers it within the database. <br>
POST /api/courier/login_courier - Courier Logs in. <br>
GET /api/courier/home/{courier_id}  -  Retrieves a list with all active orders. <br>
GET /api/courier/orders/{courier_id}  -  Retrieves a list with the orders of a particular courier with {courier_id}. <br>






