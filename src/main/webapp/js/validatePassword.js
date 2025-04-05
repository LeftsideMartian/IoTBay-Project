const passwordInput = document.getElementById("password");
const confirmPasswordInput = document.getElementById("confirmPassword");

const minPasswordLength = 12

const doesPasswordStartWithACapital = password => /^[A-Z].*/.test(password)
const doesPasswordContainALetter = password => /.*[a-zA-Z]{2,}.*/.test(password)
const doesPasswordContainANumber = password => /.*\d.*/.test(password)
const doesPasswordContainASpecialChar = password => /.*\W.*/.test(password)

const validatePassword = () => {
    password = passwordInput.value

    // Check length is at least 12 characters long
    if (password.length < minPasswordLength) {
        passwordInput.setCustomValidity(`Passwords must be at least ${minPasswordLength} characters long.`);
    }
    else if (!doesPasswordStartWithACapital(password)) {
        passwordInput.setCustomValidity(`Password must begin with a capital. Click the ⓘ for password requirements`);
    } else if (!doesPasswordContainALetter(password)) {
        passwordInput.setCustomValidity(`Password must contain another letter. Click the ⓘ for password requirements`);
    } else if (!doesPasswordContainANumber(password)) {
        passwordInput.setCustomValidity(`Password must contain a number. Click the ⓘ for password requirements`);
    } else if (!doesPasswordContainASpecialChar(password)) {
        passwordInput.setCustomValidity(`Password must contain a special character. Click the ⓘ for password requirements`);
    }
    // Confirm password
    else if (passwordInput.value !== confirmPasswordInput.value) {
        passwordInput.setCustomValidity("")
        confirmPasswordInput.setCustomValidity("Passwords do not match.");
    } else {
        confirmPasswordInput.setCustomValidity("");
    }
}

passwordInput.onkeyup = validatePassword;
confirmPasswordInput.onkeyup = validatePassword;