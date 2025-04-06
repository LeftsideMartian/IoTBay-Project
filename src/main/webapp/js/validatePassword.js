const passwordInput = document.getElementById("password");
const confirmPasswordInput = document.getElementById("confirmPassword");

const lengthReqLi = document.getElementById("lengthReq");
const capitalReqLi = document.getElementById("capitalReq");
const numberReqLi = document.getElementById("numberReq");
const specialCharReqLi = document.getElementById("specialCharReq");

const minPasswordLength = 12

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

const confirmPassword = () => {
    if (passwordInput.value !== confirmPasswordInput.value) {
        confirmPasswordInput.setCustomValidity("Passwords do not match.");
    } else {
        confirmPasswordInput.setCustomValidity("");
    }
}

passwordInput.onkeyup = validatePassword;
confirmPasswordInput.onkeyup = confirmPassword;