class LoginPage {
  // getter
  usernameInput() { return cy.get('[data-test="username"]'); }
  passwordInput() { return cy.get('[data-test="password"]'); }
  loginButton() { return cy.get('[data-test="login-button"]'); }
  errorMessage() { return cy.get('[data-test="error"]'); }
  errorButton() { return cy.get('[data-test="error-button"]'); }
  inventoryContainer() { return cy.get('[data-test="inventory-container"]'); }
  swagLogo() { return cy.get('.app_logo'); }

  visit() {
    cy.visit('/');
    cy.url().should('include', '/');
    this.usernameInput().should('be.visible');
    this.passwordInput().should('be.visible');
    this.loginButton().should('be.visible').and('be.enabled');
  }

  typeUsername(username) {
    this.usernameInput().clear().type(username);
}

  typePassword(password) {
    this.passwordInput().clear().type(password, { log: false });
  }

  submit() {
    this.loginButton().click();
  }

  login(username, password) {
    if (username) {
      this.typeUsername(username);
    }

    if (password) {
      this.typePassword(password);
    }

    this.submit();
  }

  assertErrorMessage(message) {
    this.errorMessage().should('be.visible').and('contain', message);
  }

  assertUsernameRequiredError() {
    this.assertErrorMessage('Epic sadface: Username is required');
    this.errorButton().should('be.visible');
  }

  assertPasswordRequiredError() {
    this.assertErrorMessage('Epic sadface: Password is required');
    this.errorButton().should('be.visible');
  }

  assertSwagLogoVisible() {
    this.swagLogo().should('be.visible');
  }

  assertLoginSuccess() {
    cy.url().should('include', '/inventory.html');
    this.inventoryContainer().should('be.visible');
    this.assertSwagLogoVisible();
  }
}

export default new LoginPage();