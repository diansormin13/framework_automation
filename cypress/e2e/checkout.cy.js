import inventoryPage from '../pages/InventoryPage';
import checkoutPage from '../pages/CheckoutPage';
import CartPage from '../pages/CartPage';
import LoginPage from '../pages/LoginPage';

describe('Checkout test case', () => {
  let testData;

  before(() => {
    cy.fixture('testData').then((data) => {
      testData = data;
    });
  });

  beforeEach(() => {
    cy.loginByStandardUser();
  });

  function goToCheckoutInformationStep() {
    inventoryPage.processAddToChart(
      testData.products.primary.slug,
      testData.products.primary.name,
      1
    );
    CartPage.continueToCheckout();
    checkoutPage.assertInformationStepLoaded();
  }

  it('completes checkout for a single product', () => {
    goToCheckoutInformationStep();
    checkoutPage.processToFinalCheckout(
      testData.checkout.firstName,
      testData.checkout.lastName,
      testData.checkout.postalCode
    );
    LoginPage.assertLoginSuccess();
  });

  it('shows an error when postal code is empty', () => {
    goToCheckoutInformationStep();
    checkoutPage.fillInformation(
      testData.checkout.firstName,
      testData.checkout.lastName,
      ''
    );
    checkoutPage.continue();
    checkoutPage.assertPostalCodeRequiredError();
  });

  it('shows an error when first name is empty', () => {
    goToCheckoutInformationStep();
    checkoutPage.fillInformation(
      '',
      testData.checkout.lastName,
      testData.checkout.postalCode
    );
    checkoutPage.continue();
    checkoutPage.assertFirstNameRequiredError();
  });

  it('shows an error when last name is empty', () => {
    goToCheckoutInformationStep();
    checkoutPage.fillInformation(
      testData.checkout.firstName,
      '',
      testData.checkout.postalCode
    );
    checkoutPage.continue();
    checkoutPage.assertLastNameRequiredError();
  });

  it('shows an error when first name, last name, and postal code are empty', () => {
    goToCheckoutInformationStep();
    checkoutPage.fillInformation('', '', '');
    checkoutPage.continue();
    checkoutPage.assertFirstNameRequiredError();
  });

  it('completes checkout for more than one item', () => {
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.addProductToCart(testData.products.secondary.slug);
    inventoryPage.assertCartBadgeCount(2);
    inventoryPage.openCart();

    CartPage.assertCartPage();
    CartPage.assertProductInCart(testData.products.primary.name);
    CartPage.assertProductInCart(testData.products.secondary.name);
    CartPage.continueToCheckout();

    checkoutPage.processToFinalCheckout(
      testData.checkout.firstName,
      testData.checkout.lastName,
      testData.checkout.postalCode
    );

    LoginPage.assertLoginSuccess();
  });
});