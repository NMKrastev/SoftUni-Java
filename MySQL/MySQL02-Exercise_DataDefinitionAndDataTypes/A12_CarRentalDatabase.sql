#12. Car Rental Database
/*Using SQL queries create car_rental database with the following entities:
•	categories (id, category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
•	cars (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
•	employees (id, first_name, last_name, title, notes)
•	customers (id, driver_licence_number, full_name, address, city, zip_code, notes)
•	rental_orders (id, employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start,
kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes)
Set most appropriate data types for each column. Set primary key to each table.
Populate each table with 3 records. Make sure the columns
that are present in 2 tables would be of the same data type.
Consider which fields are always required and which are optional. */

create database car_rental;

create table `categories`
(
    id           INT         not null auto_increment,
    category     Varchar(30) not null,
    daily_rate   double      not null,
    weekly_rate  double,
    monthly_rate double,
    weekend_rate double,
    primary key (id)
);

insert into categories (category, daily_rate)
values ('Category One', 25.50),
       ('Category Two', 35.50),
       ('Category Three', 45.50);

create table `cars`
(
    id            INT         not null auto_increment,
    plate_number  Varchar(10) not null,
    make          Varchar(20) not null,
    model         Varchar(20) not null,
    car_year      year,
    category_id   INT,
    doors         INT,
    picture       longblob,
    car_condition Varchar(20),
    available     boolean,
    primary key (id)
);

insert into cars (plate_number, make, model, available)
values ('MMG 333', 'Mercedes', 'GT AMG', true),
       ('MMG 444', 'BMW', 'M5', true),
       ('MMG 555', 'Audi', 'RS6', true);

create table `employees`
(
    id         INT         not null auto_increment,
    first_name Varchar(20) not null,
    last_name  Varchar(20),
    title      Varchar(30) not null,
    notes      text,
    primary key (id)
);

insert into employees (first_name, title)
values ('Bob', 'Dealer'),
       ('Charlie', 'Accountant'),
       ('Randy', 'CEO');

create table `customers`
(
    id                    INT          not null auto_increment,
    driver_licence_number INT          not null,
    full_name             Varchar(50)  not null,
    address               Varchar(100) not null,
    city                  Varchar(20)  not null,
    zip_code              Varchar(20),
    notes                 text,
    primary key (id)
);

insert into customers (driver_licence_number, full_name, address, city)
values (555777999, 'Full Name One', 'Adress One', 'City One'),
       (555777999, 'Full Name Two', 'Adress Two', 'City Two'),
       (555777999, 'Full Name Three', 'Adress Three', 'City Three');

create table `rental_orders`
(
    id                INT not null auto_increment,
    employee_id       INT not null,
    customer_id       INT not null,
    car_id            INT not null,
    car_condition     Varchar(20),
    tank_level        double,
    kilometrage_start double,
    kilometrage_end   double,
    total_kilometrage double,
    start_date        date,
    end_date          date,
    total_days        INT,
    rate_applied      double,
    tax_rate          double,
    order_status      Varchar(20),
    notes             text,
    primary key (id)
);

insert into rental_orders (employee_id, customer_id, car_id)
values (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3);