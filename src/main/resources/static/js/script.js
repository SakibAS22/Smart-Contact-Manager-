console.log("Script loader");

// ! Change theme work
let currentTheme=getTheme();
// initial -->

document.addEventListener('DOMContentLoaded',()=>{
    changeTheme()
})


// TODO:
function changeTheme(){
    // set to web page

changePageTheme(currentTheme, currentTheme);
// set the listner to change theme button
const changeThemeButton= document.querySelector('#theme_change_button')
changeThemeButton.addEventListener("click",()=>{
    console.log("change theme button click");
    const oldTheme= currentTheme;
    if(currentTheme == "dark")
    {
        // theme ko light
        currentTheme= "light";
    }else{
        // theme ko dark
        currentTheme= "dark";
    }

    changePageTheme(currentTheme,oldTheme)
    
})
}
// Set theme to localStorage
function setTheme(theme){
    localStorage.setItem("theme", theme);
}

// get theme from localStorage
function getTheme(){
    let theme =  localStorage.getItem("theme");
    return theme ? theme : "light";
}

// Change current page theme
function changePageTheme(theme, oldTheme){
    // localStorage me update karenge
    setTheme(currentTheme);
    // remove the current theme
    document.querySelector('html').classList.remove(oldTheme);
    // set the current theme
    document.querySelector('html').classList.add(theme)

    // change the text of button
    document.querySelector('#theme_change_button').querySelector('span').textContent= theme=="light"? "Dark":"Light";
}

// ! Change page theme
