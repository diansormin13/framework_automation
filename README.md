# framework_automation
this is my personal project for testing example website local host

## Playwright Testing Framework

This project uses Playwright for end-to-end testing.

### Available Commands

```bash
# Run all tests
npm test

# Run tests with browser UI visible (headed mode)
npm run test:headed

# Run tests in interactive UI mode
npm run test:ui

# Show the HTML test report
npm run test:report

# Run tests in a specific browser
npx playwright test --project=chromium
npx playwright test --project=firefox
npx playwright test --project=webkit

# Run a specific test file
npx playwright test tests/example.spec.ts

# Run tests in debug mode
npx playwright test --debug

# Generate code (Record actions in browser)
npx playwright codegen
```

### Project Structure

```
framework_automation/
├── tests/              # Test files
│   └── example.spec.ts
├── playwright.config.ts # Playwright configuration
├── package.json
└── README.md
```

### Installation

The project already has Playwright installed. If you need to reinstall:

```bash
npm install
npx playwright install
```
