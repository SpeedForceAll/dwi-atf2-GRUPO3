<%-- 
    Document   : actualizar
    Created on : 14 oct 2024, 4:05:11?p.m.
    Author     : JUAN ALDAIR
--%>

<html>
<head>
    <title>Actualizar Producto Electrónico</title>
</head>
<body>
    <h1>Actualizar Producto Electrónico</h1>
    <form action="productos" method="POST">
        ID: <input type="text" name="id" value="${producto.id}" readonly /><br />
        Nombre: <input type="text" name="nombre" value="${producto.nombre}" /><br />
        Tipo: <input type="text" name="tipo" value="${producto.tipo}" /><br />
        Precio: <input type="text" name="precio" value="${producto.precio}" /><br />
        <input type="submit" value="Actualizar Producto" />
    </form>
</body>
</html>

