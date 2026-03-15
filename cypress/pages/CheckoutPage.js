class CheckoutPage {
  checkoutInfoContainer() { return cy.get('[data-test="checkout-info-container"]'); }
  firstNameInput() { return cy.get('[data-test="firstName"]'); }
  lastNameInput() { return cy.get('[data-test="lastName"]'); }
  postalCodeInput() { return cy.get('[data-test="postalCode"]'); }
  continueButton() { return cy.get('[data-test="continue"]'); }
  errorMessage() { return cy.get('[data-test="error"]'); }
  errorButton() { return cy.get('[data-test="error-button"]'); }
  checkoutSummaryContainer() { return cy.get('[data-test="checkout-summary-container"]'); }
  finishButton() { return cy.get('[data-test="finish"]'); }
  completeHeader() { return cy.get('[data-test="complete-header"]'); }
  backHomeButton() { return cy.get('[data-test="back-to-products"]'); }

  assertInformationStepLoaded() {
    cy.url().should('include', '/checkout-step-one.html');
    this.checkoutInfoContainer().should('be.visible');
  }

  fillInformation(firstName, lastName, postalCode) {
    this.firstNameInput().clear();
    this.lastNameInput().clear();
    this.postalCodeInput().clear();

    if (firstName) {
      this.firstNameInput().type(firstName);
    }

    if (lastName) {
      this.lastNameInput().type(lastName);
    }

    if (postalCode) {
      this.postalCodeInput().type(postalCode);
    }
  }

  continue() {
    this.continueButton().should('be.enabled');
    this.continueButton().click();
  }

  assertOverviewStepLoaded() {
    cy.url().should('include', '/checkout-step-two.html');
    this.checkoutSummaryContainer().should('be.visible');
  }

  finish() {
    this.finishButton().should('be.visible');
    this.finishButton().click();
  }

  assertCompleteStepLoaded() {
    cy.url().should('include', '/checkout-complete.html');
    this.completeHeader().should('contain', 'Thank you for your order');
    this.assertBackHome();
  }

  assertBackHome() {
    this.backHomeButton().should('be.visible').and('contain', 'Back Home');
    this.backHomeButton().click();
  }

  assertErrorMessage(message) {
    this.errorMessage().should('be.visible').and('contain', message);
    this.errorButton().should('be.visible');
  }

  assertFirstNameRequiredError() {
    this.assertErrorMessage('Error: First Name is required');
  }

  assertLastNameRequiredError() {
    this.assertErrorMessage('Error: Last Name is required');
  }

  assertPostalCodeRequiredError() {
    this.assertErrorMessage('Error: Postal Code is required');
  }

  processToFinalCheckout(firstName, lastName, postalCode) {
    this.assertInformationStepLoaded();
    this.fillInformation(firstName, lastName, postalCode);
    this.continue();
    this.assertOverviewStepLoaded();
    this.finish();
    this.assertCompleteStepLoaded();
  }
}

export default new CheckoutPage();