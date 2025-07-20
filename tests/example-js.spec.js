const { test } = require('@playwright/test');
const admin = require('../fixtures/admin.json');
const { HomePageAdmin } = require('../helpers/homepage-admin');

test.describe('Admin Login Suite (JS)', () => {
  test('login berhasil', async ({ page }) => {
    const homePage = new HomePageAdmin(page);
    await homePage.goto();
    await homePage.login(admin.username, admin.password);
    await homePage.expectSignOutVisible();
    await homePage.signOut();
  });

  test('login gagal', async ({ page }) => {
    const homePage = new HomePageAdmin(page);
    await homePage.goto();
    await homePage.login(admin.username, 'password_salah');
    await homePage.expectSignOutNotVisible();
  });
}); 