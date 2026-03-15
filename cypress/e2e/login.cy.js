describe('Login test case', () => {
  it('logs in successfully with a valid account', () => {
    cy.loginByStandardUser();
  });
});