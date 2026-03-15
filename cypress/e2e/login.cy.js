import loginPage from '../pages/LoginPage';
import inventoryPage from '../pages/InventoryPage';

describe('Login test Scenarios', () => {
  let accounts;

  before(() => {
    cy.fixture('accounts').then((data) => {
      accounts = data;
    });
  });

  beforeEach(() => {
    loginPage.visit();
  });

  it('logs in successfully with a valid account', () => {
    loginPage.login(accounts.standardUser.username, accounts.standardUser.password);
    loginPage.assertLoginSuccess();
  });

  it('logs out successfully after login', () => {
    loginPage.login(accounts.standardUser.username, accounts.standardUser.password);
    loginPage.assertLoginSuccess();
    inventoryPage.logout();
    cy.url().should('include', '/');
    loginPage.loginButton().should('be.visible').and('be.enabled');
  });

  it('shows an error when username is empty', () => {
    loginPage.login('', accounts.standardUser.password);
    loginPage.assertUsernameRequiredError();
  });

  it('shows an error when password is empty', () => {
    loginPage.login(accounts.standardUser.username, '');
    loginPage.assertPasswordRequiredError();
  });

  it('shows an error when username and password are empty', () => {
    loginPage.login('', '');
    loginPage.assertUsernameRequiredError();
  });
});