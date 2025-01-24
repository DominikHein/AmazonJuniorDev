<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- TODO 12: set the title of the page to "Product List" and close the head tag -->
        <title>Product List</title>
        <!-- TODO 17: Add a link tag to include the product-styles.css file -->
        <link rel="stylesheet" type="text/css" href="/css/product-styles.css">
    </head>
    <body>
        <!-- TODO 13: add the body tag and a heading tag with the text "Available Products" -->
        <h1>Available Products</h1>
        <!-- TODO 14: add a table with headers for ID, Name, Description, and Price. Set the table’s border attribute to 1 -->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
            </thead>
            <!-- TODO 15: inside a tbody tag and use the JSTL forEach tag to iterate over the “products” list passed by the controller -->
            <tbody>
                <c:forEach var="product" items="${products}">
                    <!-- TODO 16: add a tr tag with td tags for the product’s ID, name, description, and price -->
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
