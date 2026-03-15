class CartPage {
  cartContentsContainer() { return cy.get('[data-test="cart-contents-container"]'); }
  checkoutButton() { return cy.get('[data-test="checkout"]'); }
  removeFromCartButton(productSlug) { return cy.get(`[data-test="remove-${productSlug}"]`); }
  productName(productName) { return cy.contains('[data-test="inventory-item-name"]', productName); }

  assertCartPage() {
    cy.url().should('include', '/cart.html');
    this.cartContentsContainer().should('be.visible');
  }

  assertProductInCart(productName) {
    this.productName(productName).should('be.visible');
  }

  removeProductFromCart(productSlug) {
    this.removeFromCartButton(productSlug).should('be.visible').click();
  }

  assertProductNotInCart(productName) {
    this.productName(productName).should('not.exist');
  }

  continueToCheckout() {
    this.checkoutButton().should('be.visible');
    this.checkoutButton().click();
  }
}

export default new CartPage();