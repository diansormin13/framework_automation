import { test, expect } from '@playwright/test';
import { BasicAuthPage } from '../pages/BasicAuthPage';

test.describe('Basic Authentication Tests', () => {
  let basicAuthPage: BasicAuthPage;

  test.beforeEach(async ({ page }) => {
    basicAuthPage = new BasicAuthPage(page);
  });

  test('should successfully authenticate with valid credentials', async ({ page }) => {
    await basicAuthPage.navigateWithAuth('admin', 'admin');
    
    // Add your assertions here
    await expect(basicAuthPage.pageHeading).toBeVisible();
    // await expect(basicAuthPage.successMessage).toContainText('Congratulations');
  });

  test('should display correct page title after authentication', async ({ page }) => {
    await basicAuthPage.navigateWithAuth();
    
    // Add your assertions here
    // const title = await basicAuthPage.getPageTitle();
    // await expect(title).toContain('The Internet');
  });

  test('should handle authentication failure gracefully', async ({ page }) => {
    // This test can be used to verify behavior without credentials
    // You can implement the specific assertions based on requirements
    await basicAuthPage.navigateWithAuth('invalid', 'invalid');
    
    // Add your assertions here
  });
});
