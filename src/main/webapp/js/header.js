class IoTBayHeader extends HTMLElement {
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

customElements.define('iotbay-header', IoTBayHeader)