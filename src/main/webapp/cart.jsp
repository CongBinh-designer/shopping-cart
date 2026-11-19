<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
</head>
<body>
<h1>Your cart</h1>
<table>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
        <th></th>
    </tr>

    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>

                <form action="cart" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="code" value="${item.product.code}">
                    <input type="number" name="quantity" value="${item.quantity}" min="1" style="width: 50px;">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>${item.product.name}</td>
            <td>$${item.product.price}</td>
            <td>$${item.total}</td>
            <td>

                <form action="cart" method="post">
                    <input type="hidden" name="action" value="cart">
                    <input type="hidden" name="code" value="${item.product.code}">
                    <input type="hidden" name="quantity" value="0">
                    <input type="submit" value="Remove Item">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<p>Total: $${cart.cartTotal}</p>

<p>To change the quantity, enter the new quantity and click on the Update button.</p>

<section class="buttons">
    <form action="cart" method="post">
        <input type="hidden" name="action" value="shop">
        <input type="submit" value="Continue Shopping">
    </form>
    <form action="cart" method="post">
        <input type="hidden" name="action" value="checkout">
        <input type="submit" value="Checkout">
    </form>
</section>
</body>
</html>