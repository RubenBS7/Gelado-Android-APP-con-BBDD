# Gelado-Android-APP-con-BBDD
Gelado es una ampliación de gestión de productos comestibles orientada al ámbito empresarial, su fácil uso hace que sea accesible para usuario estándar. Visualmente es una aplicación intuitiva y fácil de manejar

DESCRIPCION DE LA APLICACIÓN

Gelado es una ampliación de gestión de productos comestibles orientada al ámbito empresarial, su fácil uso hace que sea accesible para usuario estándar. Visualmente es una aplicación intuitiva y fácil de manejar.  

Su funcionamiento se basa en recopilar información de los distintos productos, estos se crean rellenado una tabla con sus características: Nombre del producto, precio, cantidad, nombre proveedor, Teléfono y e-mail del proveedor 

Al final de la creación de cada producto se puede añadir una Imagen para representar dicho producto. Esto hace visualmente sea sencillo ver cada uno de ellos en la lista, agilizando el trabajo.

los productos de la lista pueden ser creados, modificados (cantidad de stock) y borrados.

Esta aplicación contiene una base de datos basada en 
SQLite, almacena el listado de productos en ella.
La base de datos se actualiza con las acciones de crear, modificar y borrar. Garantizando una conexión y segura estable de todos los movimientos realizados.


PRINCIPALES CLASES IMPLEMTADAS

La aplicación es creada con Android Studio a continuación nombraremos las clases principales que tienen mayor importancia:


1º MainActivity: es la clase donde se cargan los datos creados por defecto en la base de datos para poder ser usados en nuestra aplicación. Pero también los datos creados por el mismo usuario desde la aplicación. Además, es donde se muestra el stock y las unidades vendidas de cada producto.


2º DetailslActivity:  en esta clase es donde se incrementan y decrementan el Stock de los artículos y se actualizan. También es donde se muestran las opciones del ActionBar, así como sus funciones (confirmar para eliminar o modificar un producto). Por último, se recogen los valores de los productos para cargarlos en la base de datos, por ello también es donde se borran y actualizan. 


3ºStockAdapter: Es donde se cargan los datos de la base de datos en la lista 


4ºStockContract:  Es donde se define el esquema de la base de datos, como los nombres de las tablas y columnas de la base de datos.



