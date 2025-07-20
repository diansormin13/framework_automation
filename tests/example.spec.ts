import { test } from '@playwright/test';
import { HomePageAdmin } from '../helpers/homepage-admin';
import admin from '../fixtures/admin.json';

test('admin login and sign out', async ({ page }) => {
  const homePage = new HomePageAdmin(page);
  await homePage.goto();
  await homePage.login(admin.username, admin.password);
  await homePage.signOut();
}); 