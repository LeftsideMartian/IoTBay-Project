class LoggedOutHeader extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <header>
            <div class="innerHeader">
                <div class="logoContainer">
                    <a href="index.jsp">
                        <img src="css/iotbayLogo.png" alt="">
                    </a>
                </div>

                <div class="menuItems">
                    <a class="button" href="">Browse products</a>
                    <a class="button" href="login.jsp">Log in</a>
                    <a class="button button-blue" href="register.jsp">Create account</a>
                </div>
            </div>
        </header>
        `
    }
}

class LoggedInHeader extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <header>
            <div class="innerHeader">
                <div class="logoContainer">
                    <a href="index.jsp">
                        <img src="css/iotbayLogo.png" alt="">
                    </a>
                </div>

                <div class="menuItems">
                    <a class="button" href="">Browse products</a>
                    <img class="profileIcon" id="profileIcon" src="css/profileIcon.svg">

                    <div class="profileMenuWrapper" id="profileMenu">
                        <form action="login" method="POST" class="profileMenu">
                            <h2 class="profileMenuUserName">User name here</h2>
                            <hr>
                            <a href="">Edit account details</a>
                            <button type="submit">Logout</button>
                        </form>
                    </div>
                </div>
            </div>
        </header>
        `
    }
}

customElements.define('logged-out-header', LoggedOutHeader)
customElements.define('logged-in-header', LoggedInHeader)