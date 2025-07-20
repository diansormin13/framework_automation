import { defineConfig } from '@playwright/test';

export default defineConfig({
  use: {
    baseURL: 'http://localhost/elms',
    // browser: 'chromium', // bisa diubah ke 'firefox' atau 'webkit' jika perlu
    headless: true, // jalankan browser tanpa UI
    // viewport: { width: 1280, height: 720 },
    // screenshot: 'only-on-failure',
    // video: 'retain-on-failure',
  },
  testDir: './tests', // folder test case
  reporter: [
    ['list'], // tampilkan di terminal
    ['html', { outputFolder: 'reports' }], // hasil HTML di folder 'reports'
  ],
}); 