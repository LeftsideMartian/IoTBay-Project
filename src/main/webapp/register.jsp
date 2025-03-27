<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background: white;
            padding: 2rem;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }

        .container {
            display: flex;
            flex-direction: column;
            gap: 12px;
        }

        h1 {
            font-size: 24px;
            color: #333;
        }

        p {
            font-size: 14px;
            color: #666;
        }

        hr {
            border: none;
            height: 1px;
            background: #ddd;
            margin: 10px 0;
        }

        label {
            text-align: left;
            font-weight: 500;
            color: #333;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            outline: none;
            font-size: 14px;
            transition: 0.3s;
        }

        input:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
        }

        button {
            background: #007bff;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #0056b3;
        }

        .signin p {
            font-size: 14px;
        }

        .signin a {
            color: #007bff;
            text-decoration: none;
            font-weight: 500;
        }

        .signin a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <form action="action_page.php">
        <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>

            <label for="FirstName"><b>FirstName</b></label>
            <input type="text" placeholder="Enter First Name" name="First Name" id="FirstName" required>

            <label for="LastName"><b>LastName</b></label>
            <input type="text" placeholder="Enter Last Name" name="Last Name" id="LastName" required>
            
            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" id="email" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

            <label for="psw-repeat"><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
            <hr>

            <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
            <button type="submit" class="registerbtn">Register</button>
        </div>

        <div class="container signin">
            <p>Already have an account? <a href="#">Sign in</a>.</p>
        </div>
    </form>
</body>
</html>
