const inventoryPage = require('../pages/InventoryPage');

describe('Inventory test case', () => {
  let testData;

  before(() => {
    cy.fixture('testData').then((data) => {
      testData = data;
    });
  });

  it('adds a product to cart from the inventory page', () => {
    cy.loginByStandardUser();

    inventoryPage.assertLoaded();
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.assertCartBadgeCount(1);
  });
});