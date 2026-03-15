const inventoryPage = require('../pages/InventoryPage');
const cartPage = require('../pages/CartPage');
const checkoutPage = require('../pages/CheckoutPage');

describe('Checkout test case', () => {
  let testData;

  before(() => {
    cy.fixture('testData').then((data) => {
      testData = data;
    });
  });

  it('completes checkout for a single product', () => {
    cy.loginByStandardUser();

    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.openCart();
    cartPage.continueToCheckout();

    checkoutPage.assertInformationStepLoaded();
    checkoutPage.fillInformation(
      testData.checkout.firstName,
      testData.checkout.lastName,
      testData.checkout.postalCode
    );
    checkoutPage.continue();
    checkoutPage.assertOverviewStepLoaded();
    checkoutPage.finish();
    checkoutPage.assertCompleteStepLoaded();
  });
});