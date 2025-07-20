export class HomePage {
  constructor(page) {
    this.page = page;
    this.url = 'http://localhost/elms/';
  }

  // Getter satu baris untuk element
  get header() { return this.page.locator('header'); }
  get loginButton() { return this.page.locator('text=Login'); }
  get searchInput() { return this.page.locator('input[name="search"]'); }

  // Function/method multi-baris
  async goto() {
    await this.page.goto(this.url);
  }

  async clickLogin() {
    await this.loginButton.click();
  }

  async search(text) {
    await this.searchInput.fill(text);
    await this.searchInput.press('Enter');
  }

  async expectHeaderVisible() {
    await expect(this.header).toBeVisible();
  }
} 