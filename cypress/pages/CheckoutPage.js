class CheckoutPage {
  checkoutInfoContainer() { return cy.get('[data-test="checkout-info-container"]'); }

  firstNameInput() { return cy.get('[data-test="firstName"]'); }

  lastNameInput() { return cy.get('[data-test="lastName"]'); }

  postalCodeInput() { return cy.get('[data-test="postalCode"]'); }

  continueButton() { return cy.get('[data-test="continue"]'); }

  checkoutSummaryContainer() { return cy.get('[data-test="checkout-summary-container"]'); }

  finishButton() { return cy.get('[data-test="finish"]'); }

  completeHeader() { return cy.get('[data-test="complete-header"]'); }

  assertInformationStepLoaded() {
    cy.url().should('include', '/checkout-step-one.html');
    this.checkoutInfoContainer().should('be.visible');
  }

  fillInformation(firstName, lastName, postalCode) {
    this.firstNameInput().clear().type(firstName);
    this.lastNameInput().clear().type(lastName);
    this.postalCodeInput().clear().type(postalCode);
  }

  continue() {
    this.continueButton().click();
  }

  assertOverviewStepLoaded() {
    cy.url().should('include', '/checkout-step-two.html');
    this.checkoutSummaryContainer().should('be.visible');
  }

  finish() {
    this.finishButton().click();
  }

  assertCompleteStepLoaded() {
    cy.url().should('include', '/checkout-complete.html');
    this.completeHeader().should('contain', 'Thank you for your order');
  }
}

module.exports = new CheckoutPage();