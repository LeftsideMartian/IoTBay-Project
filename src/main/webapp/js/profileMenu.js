const profileMenu = document.getElementById("profileMenu");
const onProfileMenuClick = () => {
    profileMenu.classList.toggle("profileMenuWrapperOpen");
}

const profileIcon = document.getElementById("profileIcon");
profileIcon.addEventListener("click", onProfileMenuClick);