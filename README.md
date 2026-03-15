# framework_automation
This is my personal project for testing a local example website.

## Cypress Structure

- `cypress/pages`: page object model for each page
- `cypress/fixtures/accounts.json`: account credentials
- `cypress/fixtures/testData.json`: checkout and product test data
- `cypress/support/commands.js`: custom commands such as `cy.loginByStandardUser()`
- `cypress/e2e/full-scenario.cy.js`: one large end-to-end scenario
- `cypress/e2e/*.cy.js`: one file per test case

## Browser Configuration

- Only `chrome` and `edge` are allowed.

## Run Tests

- `npm run cypress:open`
- `npm run cypress:run`
- `npm run cypress:full`
- `npm run cypress:login`
- `npm run cypress:inventory`
- `npm run cypress:cart`
- `npm run cypress:checkout`

## Notes for Pulling the Cypress Branch on Another Device

If the `Cypress` branch is pulled on another laptop or PC, follow these steps:

1. Fetch the latest branch and check out the `Cypress` branch.

```bash
git fetch origin
git checkout Cypress
git pull origin Cypress
```

2. Install the project dependencies.

```bash
npm install
```

3. Verify that the Cypress binary is installed.

```bash
npx cypress verify
```

4. Run the tests as needed.

```bash
npm run cypress:open
# or
npm run cypress:run -- --browser chrome
npm run cypress:run -- --browser edge
```

Notes:
- The project configuration limits browsers to `chrome` and `edge`.
- For Linux or container environments, if Cypress fails to start because of missing OS dependencies, install the required system packages such as `xvfb` and related GUI libraries.
