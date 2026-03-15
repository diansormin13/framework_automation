const inventoryPage = require('../pages/InventoryPage');
const cartPage = require('../pages/CartPage');

describe('Cart test case', () => {
  let testData;

  before(() => {
    cy.fixture('testData').then((data) => {
      testData = data;
    });
  });

  it('shows the selected product inside the cart', () => {
    cy.loginByStandardUser();

    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.openCart();

    cartPage.assertLoaded();
    cartPage.assertProductInCart(testData.products.primary.name);
  });
});