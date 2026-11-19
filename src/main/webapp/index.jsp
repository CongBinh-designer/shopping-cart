<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CD Lists</title>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
</head>
<body>
<h1>CD Lists</h1>
<table>
    <tr>
        <th>Description</th>
        <th>Price</th>
        <th></th>
    </tr>
    <tr>
        <td>86 (the band) - True Life Songs and Pictures</td>
        <td>$14.95</td>
        <td>
            <form action="cart" method="post">
                <input type="submit" value="Add to Cart">
                <input type="hidden" name="code" value="1">
                <input type="hidden" name="action" value="cart">
            </form>
        </td>
    </tr>
    <tr>
        <td>Paddlefoot - The first CD</td>
        <td>$12.95</td>
        <td>
            <form action="cart" method="post">
                <input type="submit" value="Add to Cart">
                <input type="hidden" name="code" value="2">
                <input type="hidden" name="action" value="cart">
            </form>
        </td>
    </tr>
    <tr>
        <td>Paddlefoot - The Second CD</td>
        <td>$14.95</td>
        <td>
            <form action="cart" method="post">
                <input type="submit" value="Add to Cart">
                <input type="hidden" name="code" value="3">
                <input type="hidden" name="action" value="cart">
            </form>
        </td>
    </tr>
    <tr>
        <td>Joe Rut - Genuine Wood Grained Finish</td>
        <td>$14.95</td>
        <td>
            <form action="cart" method="post">
                <input type="submit" value="Add to Cart">
                <input type="hidden" name="code" value="4">
                <input type="hidden" name="action" value="cart">
            </form>
        </td>
    </tr>
</table>


</body>
</html>