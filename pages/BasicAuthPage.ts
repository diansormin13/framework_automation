import { Page, Locator } from '@playwright/test';
import { BasePage } from './BasePage';

export class BasicAuthPage extends BasePage {
  readonly successMessage: Locator;
  readonly pageHeading: Locator;
  readonly pageContent: Locator;

  private readonly baseUrl: string = 'https://the-internet.herokuapp.com/basic_auth';

  constructor(page: Page) {
    super(page);
    this.successMessage = page.locator('p');
    this.pageHeading = page.locator('h3');
    this.pageContent = page.locator('.example');
  }

  async navigateWithAuth(username: string = 'admin', password: string = 'admin') {
    // Create URL with basic auth credentials
    const urlWithAuth = `https://${username}:${password}@the-internet.herokuapp.com/basic_auth`;
    await this.navigateTo(urlWithAuth);
    await this.waitForPageLoad();
  }

  async navigateWithoutAuth() {
    await this.navigateTo(this.baseUrl);
  }

  async getSuccessMessage(): Promise<string | null> {
    try {
      return await this.successMessage.textContent();
    } catch {
      return null;
    }
  }

  async getHeading(): Promise<string | null> {
    try {
      return await this.pageHeading.textContent();
    } catch {
      return null;
    }
  }

  async isSuccessMessageVisible(): Promise<boolean> {
    try {
      return await this.successMessage.isVisible();
    } catch {
      return false;
    }
  }

  async isPageContentVisible(): Promise<boolean> {
    try {
      return await this.pageContent.isVisible();
    } catch {
      return false;
    }
  }
}