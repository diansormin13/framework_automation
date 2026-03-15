class CartPage {
  cartContentsContainer() { return cy.get('[data-test="cart-contents-container"]'); }

  productName(productName) { return cy.contains('[data-test="inventory-item-name"]', productName); }

  checkoutButton() { return cy.get('[data-test="checkout"]'); }

  assertLoaded() {
    cy.url().should('include', '/cart.html');
    this.cartContentsContainer().should('be.visible');
  }

  assertProductInCart(productName) {
    this.productName(productName).should('be.visible');
  }

  continueToCheckout() {
    this.checkoutButton().click();
  }
}

module.exports = new CartPage();