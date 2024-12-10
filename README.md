Dog CEO API
La Dog CEO API es un servicio gratuito y fácil de usar que proporciona acceso a imágenes y datos sobre diferentes razas de perros. Esta API te permite obtener información sobre razas específicas, obtener una lista de razas o acceder a imágenes aleatorias de perros.

Endpoints disponibles
1. Listar todas las razas de perros
URL: /breeds
Método: GET
Descripción: Obtiene una lista de todas las razas de perros disponibles.
Ejemplo de respuesta:
json
Copiar código
{
  "message": {
    "affenpinscher": [],
    "akita": [],
    "beagle": [],
    ...
  },
  "status": "success"
}
2. Listar subcategorías de una raza
URL: /breeds/{breed}/list
Método: GET
Parámetros:
breed (string): El nombre de la raza.
Descripción: Obtiene una lista de subcategorías (variedades) de una raza específica. Si no tiene subcategorías, se devuelve una lista vacía.
Ejemplo de respuesta:
json
Copiar código
{
  "message": ["boston", "english", "french"],
  "status": "success"
}
3. Obtener una imagen aleatoria de una raza
URL: /breed/{breed}/images/random
Método: GET
Parámetros:
breed (string): El nombre de la raza de perro.
Descripción: Obtiene una imagen aleatoria de una raza específica.
Ejemplo de respuesta:
json
Copiar código
{
  "message": "https://images.dog.ceo/breeds/akita/n02096585_3284.jpg",
  "status": "success"
}
4. Obtener una imagen aleatoria de cualquier perro
URL: /image/random
Método: GET
Descripción: Obtiene una imagen aleatoria de cualquier raza de perro.
Ejemplo de respuesta:
json
Copiar código
{
  "message": "https://images.dog.ceo/breeds/akita/n02096585_3284.jpg",
  "status": "success"
}
5. Obtener varias imágenes aleatorias de perros
URL: /images/random/{count}
Método: GET
Parámetros:
count (integer): El número de imágenes aleatorias que se desean obtener.
Descripción: Obtiene varias imágenes aleatorias de perros. El parámetro count especifica cuántas imágenes se deben devolver.
Ejemplo de respuesta:
json
Copiar código
{
  "message": [
    "https://images.dog.ceo/breeds/akita/n02096585_3284.jpg",
    "https://images.dog.ceo/breeds/beagle/n02096585_1123.jpg"
  ],
  "status": "success"
}
Uso
La API de Dog CEO es completamente gratuita y no requiere autenticación. Puedes realizar solicitudes HTTP para obtener imágenes o datos sobre razas de perros en formato JSON. Es ideal para aplicaciones o sitios web que desean incorporar imágenes de perros o datos relacionados con razas.

Requisitos previos
Una conexión a Internet.
Conocimientos básicos de cómo realizar solicitudes HTTP o trabajar con APIs REST.
Ejemplo de uso
Puedes realizar solicitudes a la API utilizando herramientas como Postman, curl o mediante código en diferentes lenguajes de programación como Python, JavaScript, etc.

Ejemplo con curl:
bash
Copiar código
curl https://dog.ceo/api/breeds/list
Ejemplo con JavaScript (fetch):
javascript
Copiar código
fetch('https://dog.ceo/api/breeds/list')
  .then(response => response.json())
  .then(data => console.log(data));
Documentación
La documentación completa de la API está disponible en Dog CEO API Docs.
