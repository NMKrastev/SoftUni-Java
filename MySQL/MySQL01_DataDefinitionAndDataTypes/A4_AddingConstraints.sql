#4. Adding Constraints
#Create the connection via foreign key between the "products" and "categories" tables that you've created earlier. Make "category_id" foreign key linked to "id" in the "categories" table.

use gamebar;
alter table products
add constraint FK_CategoriesProducts
foreign key (category_id) references categories(id);