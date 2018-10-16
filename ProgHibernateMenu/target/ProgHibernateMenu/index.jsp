<<html>
<head>
    <link rel="stylesheet" type="text/css" href="/styles/styles.css"/>
</head>
<body>
<fieldset>
    <div id="logo">
        <u>MENU INTERFACE</u>
    </div>
    <div id="content">
        <br><form action="new_dish">
        <input type="submit" value="add new dish"/>
        </form>
        <form action="all_menu">
            <input type="submit" value="view all menu"/>
        </form>
        <form action="by_price">
            <input type="submit" value="select by price"/>
            <input type="number" name="from" min="0" placeholder="price FROM">
            <input type="number" name="to" min="0" placeholder="price TO">
        </form>
        <form action="discount">
            <input type="submit" value="with discount"/>
        </form>
        <form action="limit">
            <input type="submit" value="with a limit of 1 kg"/>
        </form>
    </div>
</fieldset>
</body>
</html>
