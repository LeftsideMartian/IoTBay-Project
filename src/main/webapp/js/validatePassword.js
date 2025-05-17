/* 
Password validation logic for the registration form.
This script is purely for client-side validation and does not replace server-side validation.
It checks the following password requirements:
1. Password must be at least 12 characters long.
2. Password must start with a capital letter.
3. Password must contain at least one number.
4. Password must contain at least one special character.
5. Password and confirm password fields must match.
Unfulfilled requirements are indicated in the UI.
*/

// Fetch inputs from DOM
const passwordInput = document.getElementById("password");
const confirmPasswordInput = document.getElementById("confirmPassword");

// Fetch requirement indicators from DOM
const lengthReqLi = document.getElementById("lengthReq");
const capitalReqLi = document.getElementById("capitalReq");
const numberReqLi = document.getElementById("numberReq");
const specialCharReqLi = document.getElementById("specialCharReq");

const minPasswordLength = 12

// Helper functions for validation
const doesPasswordStartWithACapital = password => /^[A-Z].*/.test(password)
const doesPasswordContainANumber = password => /.*\d.*/.test(password)
const doesPasswordContainASpecialChar = password => /.*\W.*/.test(password)

const validatePassword = () => {
    password = passwordInput.value

    if (!doesPasswordStartWithACapital(password)) {
        capitalReqLi.classList.remove("validRequirement");
        capitalReqLi.classList.add("invalidRequirement");
    } else {
        capitalReqLi.classList.remove("invalidRequirement");
        capitalReqLi.classList.add("validRequirement");
    }
    if (!doesPasswordContainANumber(password)) {
        numberReqLi.classList.remove("validRequirement");
        numberReqLi.classList.add("invalidRequirement");
    } else {
        numberReqLi.classList.remove("invalidRequirement");
        numberReqLi.classList.add("validRequirement");
    }
    if (!doesPasswordContainASpecialChar(password)) {
        specialCharReqLi.classList.remove("validRequirement");
        specialCharReqLi.classList.add("invalidRequirement");
    } else {
        specialCharReqLi.classList.remove("invalidRequirement");
        specialCharReqLi.classList.add("validRequirement");
    }
    if (password.length < minPasswordLength) {
        lengthReqLi.classList.remove("validRequirement");
        lengthReqLi.classList.add("invalidRequirement");
    } else {
        lengthReqLi.classList.remove("invalidRequirement");
        lengthReqLi.classList.add("validRequirement");
    }
}

// Check if password and confirm password fields match
const confirmPassword = () => {
    if (passwordInput.value !== confirmPasswordInput.value) {
        confirmPasswordInput.setCustomValidity("Passwords do not match.");
    } else {
        confirmPasswordInput.setCustomValidity("");
    }
}

// Assign event listeners to inputs
passwordInput.onkeyup = validatePassword;
confirmPasswordInput.onkeyup = confirmPassword;