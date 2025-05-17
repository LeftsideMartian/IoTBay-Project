<%@page import="iotbay.model.Product"%>
<%@page import="iotbay.helper.ProjectConstants"%>
<%@page import="iotbay.model.Category"%>
<html>
    <%
        Product product = (Product) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_CURRENTLY_SELECTED_PRODUCT);
    %>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Product: <%=product.getProductName()%> details</title>
    </head>
    <body>
        <div class="gridContainer">
            <jsp:include page="header.jsp"/>

            <div class="contentWrapper">
                <div class="centerContent">
                    <form action="/servlet/productDetails" method="POST">
                        <div class="formWrapper manageProductForm">
                            <h1><%=product.getProductName()%></h1>
                            <hr>

                            <label class="inputHeading" for="description">Description</label>
                            <textarea class="inputField" placeholder="Example: Apple Watch can do what your other devices can't because it's on your wrist..." name="description" id="description" required><%=product.getDescription()%></textarea>

                            <div class="formSection">
                                <div class="inputSection">
                                    <label class="inputHeading" for="price">Price ($)</label>
                                    <input class="inputField" value="<%=String.format("%.2f", product.getPrice())%>" type="number" name="price" id="price" required>
                                </div>
                                <div class="inputSection">
                                    <label class="inputHeading" for="stock">Stock</label>
                                    <input class="inputField" value="<%=product.getQuantity()%>" type="number" name="stock" id="stock" required>
                                </div>
                            </div>

                            <label class="inputHeading">Category</label>
                            <select class="inputField" name="category">
                                <% for (Category cat: Category.values()) { %>
                                    <% if (product.getCategory() == cat) { %>
                                        <option selected><%=cat.toString()%></option>
                                    <% } else { %>
                                        <option><%=cat.toString()%></option>
                                    <% } %>
                                <% } %>
                            </select>

                            <hr>

                            <div class="formSection buttonSection">
                                <a href="manageProducts.jsp" class="button medBtn">Cancel</a>
                                <button type="submit" class="button medBtn button-blue">Save</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
