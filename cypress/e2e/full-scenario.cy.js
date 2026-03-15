const inventoryPage = require('../pages/InventoryPage');
const cartPage = require('../pages/CartPage');
const checkoutPage = require('../pages/CheckoutPage');

describe('Sauce Demo end-to-end flow', () => {
  let testData;

  before(() => {
    cy.fixture('testData').then((data) => {
      testData = data;
    });
  });

  it('completes a full purchase flow with two products', () => {
    cy.loginByStandardUser();

    inventoryPage.assertLoaded();
    inventoryPage.assertProductVisible(testData.products.primary.name);
    inventoryPage.assertProductVisible(testData.products.secondary.name);
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.addProductToCart(testData.products.secondary.slug);
    inventoryPage.assertCartBadgeCount(2);
    inventoryPage.openCart();

    cartPage.assertLoaded();
    cartPage.assertProductInCart(testData.products.primary.name);
    cartPage.assertProductInCart(testData.products.secondary.name);
    cartPage.continueToCheckout();

    checkoutPage.assertInformationStepLoaded();
    checkoutPage.fillInformation(
      testData.checkout.firstName,
      testData.checkout.lastName,
      testData.checkout.postalCode
    );
    checkoutPage.continue();

    checkoutPage.assertOverviewStepLoaded();
    cartPage.assertProductInCart(testData.products.primary.name);
    cartPage.assertProductInCart(testData.products.secondary.name);
    checkoutPage.finish();
    checkoutPage.assertCompleteStepLoaded();
  });
});