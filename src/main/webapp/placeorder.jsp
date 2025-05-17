<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="css/index.css">
  <link rel="shortcut icon" href="css/iotbayIcon.ico">
  <title>Checkout - lolBay</title>
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700&display=swap');

    /* * {
      margin: 0;
      padding: 0;
      border: none;
      font-family: "Poppins", sans-serif;
      font-style: normal;
    } */

    body {
      background-color: #f2f8fc;
      padding: 0px;
    }

    body div.placeOrderFlexBox {
      padding: 20px;
    }

    .summary {
      padding: 1em 1.5em;
      border-radius: 25px;
      filter: drop-shadow(
        1px 2px 2px rgb(197, 197, 197)
      );
      background-color: #fff;
      width: 40rem;
    }

    .summaryHeading {
      font-size: clamp(1rem, 3vw, 1.5rem);
      font-weight: 700;
      padding: 1rem;
    }

    .placeOrderTable {
      width: 100%;
      margin-top: 10px;
      border-spacing: 0rem 0rem;
    }

    .formWrapper {
      margin-top: 2rem;
      background-color: #fff;
      padding: 2rem;
      border-radius: 25px;
      filter: drop-shadow(1px 2px 2px rgb(197, 197, 197));
      width: 42rem; 
      box-sizing: border-box;
    }

    .formSection {
      display: flex;
      gap: 1rem;
      margin-bottom: 1rem;
    }

    .inputSection {
      flex: 1;
    }

    .inputField {
      width: 100%;
      padding: 0.75rem;
      margin-bottom: 1rem;
      border-radius: 10px;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }

    .inputHeading, .formHeading {
      display: block;
      margin-top: 1rem;
      margin-bottom: 0.5rem;
      font-weight: 600;
    }


    th, td {
      padding: 1rem 1rem 1rem 0rem;
      text-align: left;
    }

    td:last-child {
      text-align: right;
    }

    .tableContainer {
      max-height: 300px;
      overflow-y: auto;
      margin-top: 10px;
    }


    .buttons {
      margin-top: 20px;
      display: flex;
      justify-content: space-evenly;
    }

    strong {
      font-size: 0.9rem;
      font-weight: 700;
      margin-bottom: 0.2rem;
    }

    .totalHeading {
      text-align: right;
    }
  </style>
</head>

<body>
  <jsp:include page="header.jsp"/>

  
  <div class="placeOrderFlexBox">
    <div class="">
      <h1>Checkout</h1>

      <div class="summary">
        <h3>Summary</h3>
        <div class="tableContainer">
        <table class="placeOrderTable">
          <tr>
            <th>Item</th>
            <th>Price</th>
            <th>Qty</th>
            <th class="totalHeading">Total</th>
          </tr>
          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

          <tr>
            <td>Product Name</td>
            <td>$100</td>
            <td>2</td>
            <td>$200</td>
          </tr>

        </table>
        </div>
        <hr>
        <p><em>Subtotal</em>: $200</p>
        <p><em>Shipping</em>: $20</p>
        <p><strong>Total</strong>: $220</p>
      </div>
    </div>
      <form id="checkout-form">
        <div class="formWrapper">
          <label class="formHeading">Personal Information</label>
          <div class="formSection">
            <div class="inputSection">
              <input class="inputField" type="text" placeholder="First Name" name="firstName" required />
            </div>
            <div class="inputSection">
              <input class="inputField" type="text" placeholder="Last Name" name="lastName" required />
            </div>
          </div>
  
          <label class="inputHeading"><strong>Delivery Address</strong></label>
          <input class="inputField" type="text" placeholder="Address" name="address" required />

          <label class="inputHeading"><strong>Credit Card Info</strong></label>
          <input class="inputField" type="text" placeholder="Card Number" name="cardNumber" required />
  
          <div class="buttons">
            <button type="submit" class="button button-blue">Place Order</button>
            <button type="button" class="button" onclick="cancelOrder()">Cancel Order</button>
          </div>
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
