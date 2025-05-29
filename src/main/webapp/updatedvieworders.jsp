<%@ page import="java.util.*, yourpackage.Order, yourpackage.OrderItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Order order = (Order) request.getAttribute("order");
    if (order == null) {
        out.println("<h2>Order not found</h2>");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 2rem;
            background-color: #f8fafc;
        }
        .modal-content {
            background-color: white;
            border-radius: 1rem;
            padding: 2rem;
            max-width: 800px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            font-size: 2rem;
            margin-bottom: 1rem;
            text-align: center;
        }
        .grid {
            display: grid;
            grid-template-columns: 1fr 2fr;
            gap: 0.5rem 1rem;
            margin-bottom: 1.5rem;
        }
        .label {
            font-weight: bold;
            color: #374151;
        }
        .value {
            color: #1f2937;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1.5rem;
        }
        th, td {
            padding: 0.75rem;
            text-align: left;
            border-bottom: 1px solid #e5e7eb;
        }
        th {
            background-color: #f1f5f9;
            font-weight: 600;
        }
        .actions {
            display: flex;
            justify-content: flex-end;
            margin-top: 2rem;
        }
        .button {
            background-color: #ef4444;
            color: white;
            padding: 0.75rem 1.5rem;
            border: none;
            border-radius: 0.5rem;
            cursor: pointer;
            transition: background-color 0.2s ease-in-out;
        }
        .button:hover {
            background-color: #dc2626;
        }
    </style>
    <script>
        function confirmCancel(orderNo) {
            if (confirm("Are you sure you want to cancel this order?")) {
                window.location.href = "cancel-order?orderNo=" + orderNo;
            }
        }
    </script>
</head>
<body>
<div class="modal-content">
    <h2>Order Details</h2>
    <div class="grid">
        <div class="label">Order No:</div>
        <div class="value"><%= order.getOrderNo() %></div>

        <div class="label">Order Date:</div>
        <div class="value"><%= order.getOrderDate() %></div>

        <div class="label">Customer Name:</div>
        <div class="value"><%= order.getCustomerName() %></div>

        <div class="label">Contact Number:</div>
        <div class="value"><%= order.getContactNumber() %></div>

        <div class="label">Delivery Address:</div>
        <div class="value"><%= order.getDeliveryAddress() %></div>

        <div class="label">Order Status:</div>
        <div class="value"><%= order.getOrderStatus() %></div>
    </div>

    <table>
        <thead>
        <tr>
            <th>Item Name</th>
            <th>Price ($)</th>
            <th>Quantity</th>
            <th>Subtotal ($)</th>
        </tr>
        </thead>
        <tbody>
        <%
            double total = 0;
            for (OrderItem item : order.getOrderItems()) {
                double subtotal = item.getItemPrice() * item.getItemQuantity();
                total += subtotal;
        %>
        <tr>
            <td><%= item.getItemName() %></td>
            <td><%= String.format("%.2f", item.getItemPrice()) %></td>
            <td><%= item.getItemQuantity() %></td>
            <td><%= String.format("%.2f", subtotal) %></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3" style="text-align:right; font-weight:bold;">Total:</td>
            <td><%= String.format("%.2f", total) %></td>
        </tr>
        </tbody>
    </table>

    <% if ("Pending".equalsIgnoreCase(order.getOrderStatus())) { %>
    <div class="actions">
        <button class="button" onclick="confirmCancel('<%= order.getOrderNo() %>')">Cancel Order</button>
    </div>
    <% } %>
</div>
</body>
</html>
