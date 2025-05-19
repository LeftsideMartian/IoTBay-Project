// This script is for the cart and profile menu functionality (Showing and hiding menus in the heading).

// Cart menu
const cartMenu = document.getElementById("cartMenu");
const onCartMenuClick = () => {
    cartMenu.classList.toggle("cartMenuWrapperOpen");
}

const cartIcon = document.getElementById("cartIcon");
cartIcon.addEventListener("click", onCartMenuClick);

// For each product in the cart, add functionality to hide the item when the remove button is clicked
const removeButtons = document.querySelectorAll(".cartRemoveButton");
removeButtons.forEach(button => {
    button.addEventListener("click", (event) => {
        const productId = event.target.id.split(":")[1];

        const tableRow = document.getElementById(`tableRow:${productId}`);
        tableRow.remove();
    });
});

// Profile menu
const profileMenu = document.getElementById("profileMenu");
const onProfileMenuClick = () => {
    profileMenu.classList.toggle("profileMenuWrapperOpen");
}

const profileIcon = document.getElementById("profileIcon");
profileIcon.addEventListener("click", onProfileMenuClick);