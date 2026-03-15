class InventoryPage {
  inventoryContainer() { return cy.get('[data-test="inventory-container"]'); }

  addToCartButton(productSlug) { return cy.get(`[data-test="add-to-cart-${productSlug}"]`); }

  cartLink() { return cy.get('[data-test="shopping-cart-link"]'); }

  sortDropdown() { return cy.get('[data-test="product-sort-container"]'); }

  cartBadge() { return cy.get('[data-test="shopping-cart-badge"]'); }

  productName(productName) { return cy.contains('[data-test="inventory-item-name"]', productName); }

  assertLoaded() {
    cy.url().should('include', '/inventory.html');
    this.inventoryContainer().should('be.visible');
  }

  addProductToCart(productSlug) {
    this.addToCartButton(productSlug).click();
  }

  openCart() {
    this.cartLink().click();
  }

  sortBy(value) {
    this.sortDropdown().select(value);
  }

  assertProductVisible(productName) {
    this.productName(productName).should('be.visible');
  }

  assertCartBadgeCount(count) {
    this.cartBadge().should('have.text', String(count));
  }
}

module.exports = new InventoryPage();