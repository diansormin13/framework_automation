import inventoryPage from '../pages/InventoryPage';
import cartPage from '../pages/CartPage';

describe('Inventory test case', () => {
  let testData;
  let cartBadgeCount;

  before(() => {
    cy.fixture('testData').then((data) => {
      testData = data;
      cartBadgeCount = 1;
    });
  });

  beforeEach(() => {
    cy.loginByStandardUser();
  });

  it('adds a product to cart and shows it in the cart page', () => {
    inventoryPage.processAddToChart(
      testData.products.primary.slug,
      testData.products.primary.name,
      cartBadgeCount
    );
  });

  it('adds one item then removes it on inventory page and cart badge disappears', () => {
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.assertCartBadgeCount(1);

    inventoryPage.removeProductFromInventory(testData.products.primary.slug);
    inventoryPage.assertCartBadgeNotVisible();
  });

  it('removes a product from cart and the product is no longer displayed', () => {
    inventoryPage.processAddToChart(
      testData.products.primary.slug,
      testData.products.primary.name,
      cartBadgeCount
    );

    cartPage.removeProductFromCart(testData.products.primary.slug);
    cartPage.assertProductNotInCart(testData.products.primary.name);
  });

  it('adds two items to cart and shows both items in the cart page', () => {
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.addProductToCart(testData.products.secondary.slug);
    inventoryPage.assertCartBadgeCount(2);
    inventoryPage.openCart();

    cartPage.assertCartPage();
    cartPage.assertProductInCart(testData.products.primary.name);
    cartPage.assertProductInCart(testData.products.secondary.name);
  });

  it('adds two items then removes one item from cart detail page', () => {
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.addProductToCart(testData.products.secondary.slug);
    inventoryPage.assertCartBadgeCount(2);
    inventoryPage.openCart();

    cartPage.assertCartPage();
    cartPage.removeProductFromCart(testData.products.primary.slug);
    inventoryPage.assertCartBadgeCount(1);
    cartPage.assertProductNotInCart(testData.products.primary.name);
    cartPage.assertProductInCart(testData.products.secondary.name);
  });

  it('decreases cart count when remove is clicked on inventory page', () => {
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.addProductToCart(testData.products.secondary.slug);
    inventoryPage.assertCartBadgeCount(2);

    inventoryPage.removeProductFromInventory(testData.products.primary.slug);
    inventoryPage.assertCartBadgeCount(1);
  });

  it('adds two items then removes both items from cart detail page', () => {
    inventoryPage.addProductToCart(testData.products.primary.slug);
    inventoryPage.addProductToCart(testData.products.secondary.slug);
    inventoryPage.assertCartBadgeCount(2);
    inventoryPage.openCart();

    cartPage.assertCartPage();
    cartPage.removeProductFromCart(testData.products.primary.slug);
    cartPage.removeProductFromCart(testData.products.secondary.slug);

    inventoryPage.assertCartBadgeNotVisible();
    cartPage.assertProductNotInCart(testData.products.primary.name);
    cartPage.assertProductNotInCart(testData.products.secondary.name);
  });
});