import cartPage from './CartPage';

class InventoryPage {
  inventoryContainer() { return cy.get('[data-test="inventory-container"]'); }
  menuButton() { return cy.get('[class="bm-burger-button"]'); }
  logoutSidebarLink() { return cy.get('[data-test="logout-sidebar-link"]'); }
  addToCartButton(productSlug) { return cy.get(`[data-test="add-to-cart-${productSlug}"]`); }
  removeFromCartButton(productSlug) { return cy.get(`[data-test="remove-${productSlug}"]`); }
  cartLink() { return cy.get('[data-test="shopping-cart-link"]'); }
  sortDropdown() { return cy.get('[data-test="product-sort-container"]'); }
  cartBadge() { return cy.get('[data-test="shopping-cart-badge"]'); }
  productName(productName) { return cy.contains('[data-test="inventory-item-name"]', productName); }

  addProductToCart(productSlug) {
    this.addToCartButton(productSlug).click();
  }

  removeProductFromInventory(productSlug) {
    this.removeFromCartButton(productSlug).should('be.visible').click();
  }

  openCart() {
    this.cartLink().should('be.visible');
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

  assertCartBadgeNotVisible() {
    cy.get('body').find('[data-test="shopping-cart-badge"]').should('not.exist');
  }

  processAddToChart(productSlug, productName, cartBadgeCount) {
    this.addProductToCart(productSlug);
    this.assertCartBadgeCount(cartBadgeCount);
    this.openCart();
    cartPage.assertCartPage();
    if (productName) {
      cartPage.assertProductInCart(productName);
    }
  }

  logout() {
    this.menuButton().should('be.visible').click();
    this.logoutSidebarLink().should('be.visible').click();
  }
}

export default new InventoryPage();