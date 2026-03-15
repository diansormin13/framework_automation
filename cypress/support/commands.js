const loginPage = require('../pages/LoginPage');

Cypress.Commands.add('loginByStandardUser', () => {
  cy.fixture('accounts').then(({ standardUser }) => {
    loginPage.visit();
    loginPage.login(standardUser.username, standardUser.password);
    loginPage.assertLoginSuccess();
  });
});