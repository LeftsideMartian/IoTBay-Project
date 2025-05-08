<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Product: _____ details</title>
    </head>
    <body>
        <div class="gridContainer">
            <jsp:include page="header.jsp"/>

            <div class="contentWrapper">
                <div class="centerContent">
                    <form action="/servlet/login" method="GET">
                        <div class="formWrapper manageProductForm">
                            <h1>Product Name</h1>
                            <hr>

                            <label class="formHeading" for="description">Description</label>
                            <textarea class="inputField" placeholder="Example: Apple Watch can do what your other devices can’t because it’s on your wrist..." name="description" id="description" required></textarea>
                            
                            <label class="formHeading" for="price">Price ($)</label>
                            <div class="formSection">
                                <input class="inputField priceInput" type="number" name="price" id="price" required>
                            </div>

                            <label class="formHeading" for="price">Stock</label>
                            <div class="formSection">
                                <input class="inputField priceInput" type="number" name="price" id="price" required>
                            </div>

                            <hr>

                            <div class="formSection buttonSection">
                                <a href="index.jsp" class="button medBtn">Cancel</a>
                                <button type="submit" class="button medBtn button-blue">Save</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
