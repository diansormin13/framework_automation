# framework_automation

A personal QA automation project using Cypress, testing the JPetStore Demo application. Includes test cases, bug reports, and QA automation documentation.

## Project Structure

```
framework_automation/
├── cypress/
│   ├── e2e/
│   │   ├── checkout.cy.js
│   │   ├── inventory.cy.js
│   │   └── login.cy.js
│   ├── fixtures/
│   │   ├── accounts.json
│   │   └── testData.json
│   ├── pages/
│   │   ├── CartPage.js
│   │   ├── CheckoutPage.js
│   │   ├── InventoryPage.js
│   │   └── LoginPage.js
│   ├── results/
│   ├── support/
│   │   ├── commands.js
│   │   └── e2e.js
│   └── videos/
├── scripts/
│   └── run-cypress-spec.cjs
├── section 1 - 3/
│   ├── HOW-TO-READ.md
│   ├── section-1.md
│   ├── section-2.md
│   └── section-3.md
├── cypress.config.js
├── package.json
└── README.md
```

## Browser Configuration

Only `chrome` and `edge` are allowed.

## Run Tests

```bash
npm run cypress:open
npm run cypress:run
npm run cypress:spec
npm run cypress:spec:headless
```

## Reports

```bash
npm run report:merge
npm run report:generate
npm run report
```

## Setup

```bash
git fetch origin
git checkout Cypress
git pull origin Cypress
npm install
npx cypress verify
```
