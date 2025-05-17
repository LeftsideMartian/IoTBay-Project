<%@page import="iotbay.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="iotbay.helper.ProjectConstants"%>
<%@page import="iotbay.service.ProductService"%>
<%@page import="java.sql.Connection"%>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <link rel="shortcut icon" href="css/iotbayIcon.ico">
        <title>Manage products</title>
    </head>
    <body>
        <%
            List<Product> products = (List<Product>) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_PRODUCT_LIST);
        %>
        <div class="gridContainer">
            <jsp:include page="header.jsp"/>
            <div class="contentWrapper">
                <div class="centerContent">
                    <%
                        String successMessage = (String) session.getAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE);
                        if (successMessage != null) {
                            session.removeAttribute(ProjectConstants.SESSION_ATTRIBUTE_SUCCESS_MESSAGE);
                    %>
                        <div class="popup"><%= successMessage %></div>
                    <% } %>
                    <div class="manageStockTableWrapper">
                        <div class="scrollableTable">
                            <form method="GET" action="/servlet/manageProducts">
                                <table class="manageStockTable">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Category</th>
                                            <th>Price</th>
                                            <th>Stock</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Product product : products) { %>
                                            <tr>
                                                <td><%=product.getProductName()%></td>
                                                <td><%=product.getCategory()%></td>
                                                <td>$<%=String.format("%.2f", product.getPrice())%></td>
                                                <td><%=product.getQuantity()%></td>
                                                <td><button class="button smlBtn" name="productId" value="<%=product.getProductId()%>">View</button></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
