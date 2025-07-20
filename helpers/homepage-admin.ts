// Jika terjadi error import, pastikan sudah install @playwright/test dan types-nya
import type { Page } from '@playwright/test';
import { expect } from '@playwright/test';

export class HomePageAdmin {
  readonly page: Page;

  constructor(page: Page) {
    this.page = page;
  }

  // Getter satu baris untuk element
  get adminLoginLink() { return this.page.getByRole('link', { name: 'account_box Admin Login' }); }
  get usernameInput() { return this.page.locator('#username'); }
  get passwordInput() { return this.page.getByRole('textbox', { name: 'Password' }); }
  get signInButton() { return this.page.getByRole('button', { name: 'Sign in' }); }
  get signOutLink() { return this.page.getByRole('link', { name: 'exit_to_app Sign Out' }); }

  // Method/aksi
  async goto() {
    await this.page.goto('/'); // gunakan path relatif, baseURL dari config
  }

  async login(username: string, password: string) {
    await this.adminLoginLink.click();
    await this.usernameInput.click();
    await this.usernameInput.fill(username);
    await this.passwordInput.click();
    await this.passwordInput.fill(password);
    await this.signInButton.click();
  }

  async signOut() {
    await this.signOutLink.click();
  }

  async expectOnHome() {
    await expect(this.page).toHaveURL(/\/$/); // cek di root path
  }

  async expectSignOutVisible() {
    await expect(this.signOutLink).toBeVisible();
  }

  async expectSignOutNotVisible() {
    await expect(this.signOutLink).not.toBeVisible();
  }
} 