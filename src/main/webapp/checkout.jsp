<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CD Lists</title>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
</head>
<body>
<h1>Thanks for buying!</h1>
<p>Total Amount: $${cart.cartTotal}</p>
<form action="cart" method="post">
    <input type="hidden" name="action" value="shop">
    <input type="submit" value="Continue Shopping">
</form>
</body>
</html>