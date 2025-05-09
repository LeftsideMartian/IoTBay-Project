<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Checkout - lolBay</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 20px;
      background-color: #f9fcff;
    }
    h1 {
      font-size: 2em;
      border-bottom: 2px solid #eee;
    }
    .summary, .form-container {
      display: inline-block;
      vertical-align: top;
      margin-top: 20px;
    }
    .summary {
      width: 45%;
    }
    .form-container {
      width: 50%;
      background-color: #eaf4ff;
      padding: 20px;
      border-radius: 10px;
    }
    table {
      width: 100%;
      margin-top: 10px;
      border-collapse: collapse;
    }
    th, td {
      padding: 8px;
      text-align: left;
    }
    td:last-child {
      text-align: right;
    }
    .buttons {
      margin-top: 20px;
    }
    button {
      padding: 10px 20px;
      margin-right: 10px;
      border-radius: 5px;
      border: none;
    }
    .place-order {
      background-color: gray;
      color: white;
    }
    .cancel-order {
      background-color: white;
      border: 2px solid black;
    }
  </style>
</head>
<body>

  <h1>Checkout</h1>

  <div class="summary">
    <h3><em>Summary</em></h3>
    <table>
      <tr><th>Item</th><th>Price</th><th>Qty</th><th>Total</th></tr>
      <tr>
        <td><div style="width: 50px; height: 60px; background-color: #eee;"></div></td>
        <td>$100</td>
        <td>2</td>
        <td>$200</td>
      </tr>
    </table>
    <p><em>Subtotal</em>: $200</p>
    <p><em>Shipping</em>: $20</p>
    <p><strong>Total</strong>: $220</p>
  </div>

  <div class="form-container">
    <form id="checkout-form">
      <p><strong><em>Personal Information</em></strong></p>
      <input type="text" placeholder="First Name" name="firstName" required />
      <input type="text" placeholder="Last Name" name="lastName" required /><br/><br/>

      <p><strong><em>Delivery Address</em></strong></p>
      <input type="text" placeholder="Address" name="address" required style="width: 90%;" /><br/><br/>

      <p><strong><em>Credit Card Info</em></strong></p>
      <input type="text" placeholder="Card Number" name="cardNumber" required /><br/><br/>

      <div class="buttons">
        <button type="submit" class="place-order">Place Order</button>
        <button type="button" class="cancel-order" onclick="cancelOrder()">Cancel Order</button>
      </div>
    </form>
  </div>

  <script>
    document.getElementById("checkout-form").addEventListener("submit", function (e) {
      e.preventDefault();
      alert("Order placed successfully!");
      this.reset();
    });

    function cancelOrder() {
      if (confirm("Are you sure you want to cancel the order?")) {
        document.getElementById("checkout-form").reset();
      }
    }
  </script>

</body>
</html>
