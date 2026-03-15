class LoginPage {
  usernameInput() { return cy.get('[data-test="username"]'); }

  passwordInput() { return cy.get('[data-test="password"]'); }

  loginButton() { return cy.get('[data-test="login-button"]'); }

  errorMessage() { return cy.get('[data-test="error"]'); }

  inventoryContainer() { return cy.get('[data-test="inventory-container"]'); }

  visit() {
    cy.visit('/');
  }

  assertLoginSuccess() {
    cy.url().should('include', '/inventory.html');
    this.inventoryContainer().should('be.visible');
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
    this.typeUsername(username);
    this.typePassword(password);
    this.submit();
  }

  assertErrorMessage(message) {
    this.errorMessage().should('be.visible').and('contain', message);
  }
}

module.exports = new LoginPage();