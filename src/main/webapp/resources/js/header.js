window.addEventListener('load', function () {
/* Toggle DM */
const link = document.querySelector("#dm-switch");
const theme = document.querySelector("#theme-link");
const prefersDarkScheme = window.matchMedia("(prefers-color-scheme: dark)");
const currentTheme = localStorage.getItem("theme");

if(currentTheme=="resources/css/dark-mode.css"){
	theme.href="resources/css/dark-mode.css";
	}else{
	theme.href="resources/css/light-mode.css";
}

//if (prefersDarkScheme.matches) {
//  theme.href = "resources/css/dark-mode.css";
//} else {
//  theme.href = "resources/css/light-mode.css";
//}

link.addEventListener("click", function() {
	if (theme.getAttribute("href") == "resources/css/light-mode.css") {
    theme.href = "resources/css/dark-mode.css";
  } else {
    theme.href = "resources/css/light-mode.css";
  }
  localStorage.setItem("theme", theme)
});

const toggle = document.querySelector(".toggle");
const menu = document.querySelector(".menu");
const items = document.querySelectorAll(".item");
/* Toggle mobile menu */
function toggleMenu() {
  if (menu.classList.contains("active")) {
    menu.classList.remove("active");
    toggle.querySelector("a").innerHTML = "<i class='fas fa-bars'></i>";
  } else {
    menu.classList.add("active");
    toggle.querySelector("a").innerHTML = "<i class='fas fa-times'></i>";
  }
}
/* Activate Submenu */
function toggleItem() {
  if (this.classList.contains("submenu-active")) {
    this.classList.remove("submenu-active");
  } else if (menu.querySelector(".submenu-active")) {
    menu.querySelector(".submenu-active").classList.remove("submenu-active");
    this.classList.add("submenu-active");
  } else {
    this.classList.add("submenu-active");
  }
}
/* Close Submenu From Anywhere */
function closeSubmenu(e) {
  if (menu.querySelector(".submenu-active")) {
    let isClickInside = menu
      .querySelector(".submenu-active")
      .contains(e.target);
    if (!isClickInside && menu.querySelector(".submenu-active")) {
      menu.querySelector(".submenu-active").classList.remove("submenu-active");
    }
  }
}
/* Event Listeners */
toggle.addEventListener("click", toggleMenu, false);
for (let item of items) {
  if (item.querySelector(".submenu")) {
    item.addEventListener("click", toggleItem, false);
  }
  item.addEventListener("keypress", toggleItem, false);
}
document.addEventListener("click", closeSubmenu, false);
})