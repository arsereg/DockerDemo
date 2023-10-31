![Logo universidad Cenfotec](https://ucenfotec.ac.cr/wp-content/uploads/2021/12/Logo-Ucenfotec-250-105-.png)
![Logo Docker](https://upload.wikimedia.org/wikipedia/commons/4/4e/Docker_%28container_engine%29_logo.svg)
# Docker como herramienta para la optimización de portabilidad

## Qué es esta aplicación?

Esta aplicación simula un negocio que tiene como necesidad una forma de calcular facturas para sus pizzas dependiendo del tamaño y los ingredientes que se le agregan a la misma.

### Tamaño de pizzas

| Tamaño      | Multiplicador de precio |
|-------------|-------------------------|
| SMALL       | 0.8                     |
| MEDIUM      | 1.0                     |
| LARGE       | 1.5                     |
| EXTRA_LARGE | 2.0                     |

### Ingredientes

| Ingrediente | Precio |
|-------------|--------|
| MARGHERITA  | 10.000 |
| PEPPERONI   | 13.000 |
| FOUR_CHEESE | 14.000 |
| HAWAIIAN    | 12.500 |


## Cómo ejecutar la aplicación?

Esta aplicación utiliza Docker como herramienta de contenerización para incrementar su portabilidad.

### Pasos
1- Se debe tener instalado Docker en el equipo y ejecutar el siguiente comando:

```bash
docker build -t docker_demo -f Dockerfile .    
```

Esto compila la aplicación y crea una imagen de docker llamada `docker_demo` la cual utilizaremos luego para lanzar instancias de la aplicación.

2- Luego de que la imagen se haya creado, se puede lanzar una instancia de la aplicación con el siguiente comando:

```bash
docker run -p 8080:8080 docker_demo
```

Este comando crea un contenedor de docker a partir de la imagen `docker_demo` y lo ejecuta en el puerto 8080 de la máquina local.

3- Finalmente, se puede acceder a la aplicación desde el navegador en la siguiente dirección:

```bash
http://localhost:8080/graphiql
```

La aplicación cuenta con una interfaz gráfica llamada GraphiQL que permite realizar consultas a la API de la aplicación, la cual está creada con GraphQL


## Dónde se ejecutan las pruebas?

Las pruebas se ejecutan en la primera etapa del Dockerfile. En esta etapa, el código fuente de la aplicación se copia al contenedor y se ejecutan las pruebas.
_Si las pruebas no pasan, el contenedor no se crea y se muestra un mensaje de error._

## Ejemplo de request


## Mutación para obtener el precio de una lista de pizzas


### Request
```graphql
mutation orderPizza($pizzas: [PizzaOrder!]!){
  orderPizza(pizzas: $pizzas){
    tax
    subTotal
    total
    pizzas{
      pizzaSize
      pizzaFlavor
    }
  }
}
```

### Variables
```json
{
  "pizzas": [
    {
      "pizzaSize": "EXTRA_LARGE",
      "pizzaFlavor": "FOUR_CHEESE"
    },
    {
      "pizzaSize": "EXTRA_LARGE",
      "pizzaFlavor": "FOUR_CHEESE"
    },
    {
      "pizzaSize": "EXTRA_LARGE",
      "pizzaFlavor": "FOUR_CHEESE"
    }
  ]
}
```


## Query para obtener las opciones
```graphql
query getElements{
  sizes
  flavors
}
```