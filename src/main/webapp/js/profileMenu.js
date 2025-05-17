// This script is for the profile menu functionality (Showing and hiding profile menu).

const profileMenu = document.getElementById("profileMenu");
const onProfileMenuClick = () => {
    profileMenu.classList.toggle("profileMenuWrapperOpen");
}

const profileIcon = document.getElementById("profileIcon");
profileIcon.addEventListener("click", onProfileMenuClick);