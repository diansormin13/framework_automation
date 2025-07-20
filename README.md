# Playwright UI Automation Setup

Dokumentasi instalasi dan setup Playwright untuk pengujian otomatis website [http://localhost/elms/](http://localhost/elms/)

## Prasyarat
- Node.js & npm sudah terinstal di komputer Anda
- Akses ke terminal/command prompt

## Langkah Instalasi

1. **Inisialisasi Project Node.js**
   ```bash
   npm init -y
   ```
   (Lewati langkah ini jika sudah ada file `package.json`)

2. **Instalasi Playwright**
   ```bash
   npm install --save-dev playwright
   ```

3. **Instalasi Browser Dependencies Playwright**
   ```bash
   npx playwright install
   ```
   Perintah ini akan mengunduh browser Chromium, Firefox, dan Webkit yang diperlukan untuk pengujian.

## Cara Menjalankan Test Playwright

1. **Jalankan semua test:**
   ```bash
   npx playwright test
   ```
2. **Jalankan test pada file tertentu:**
   ```bash
   npx playwright test tests/example.spec.ts
   # atau untuk file JS
   npx playwright test tests/example-js.spec.js
   ```
3. **Jalankan test dengan browser tampil (mode headed):**
   ```bash
   npx playwright test --headed
   ```

## Cara Melihat Report Hasil Test

1. **Setelah test selesai, generate report HTML dengan:**
   ```bash
   npx playwright show-report
   ```
2. **Atau buka file `reports/index.html` di browser.**

## Cara Record Web Menggunakan Playwright

1. **Buka terminal di folder project Anda.**
2. Jalankan perintah berikut:
   ```bash
   npx playwright codegen http://localhost/elms/
   ```
   Ganti URL sesuai alamat web yang ingin direkam.
3. Akan terbuka dua jendela:
   - **Browser Playwright:** lakukan aksi (klik, isi form, dsb) di sini.
   - **Jendela codegen/editor:** kode otomatis akan muncul sesuai aksi yang dilakukan.
4. Setelah selesai merekam, **salin kode dari jendela codegen** dan tempelkan ke file pengujian Anda (misal: `tests/example.spec.js`).

### Tips:
- Untuk langsung menyimpan hasil rekaman ke file, gunakan:
  ```bash
  npx playwright codegen http://localhost/elms/ --output=tests/hasil-record.spec.js
  ```
- Untuk memilih bahasa hasil rekaman:
  - JavaScript: `--target=js`
  - TypeScript: `--target=ts`

## Tips: Test Suite di Playwright

### Membuat Test Suite
- Gunakan `test.describe('Nama Suite', () => { ... })` untuk mengelompokkan beberapa test case.

Contoh:
```ts
import { test, expect } from '@playwright/test';

test.describe('Admin Login Suite', () => {
  test('login berhasil', async ({ page }) => {
    // ... langkah test login berhasil
  });

  test('login gagal', async ({ page }) => {
    // ... langkah test login gagal
  });
});
```

### Menjalankan Satu Test Suite
- Jalankan semua test di satu file suite:
  ```bash
  npx playwright test tests/admin-suite.spec.ts
  ```
- Jalankan suite berdasarkan nama:
  ```bash
  npx playwright test -g "Admin Login Suite"
  ```

### Menjalankan Satu Test Case di Dalam Suite
- Jalankan test case tertentu berdasarkan nama:
  ```bash
  npx playwright test -g "login berhasil"
  ```

---

## Struktur Folder Project Pengujian

```
pw/
│
├── tests/                # Folder utama untuk semua file pengujian (test cases)
│   ├── example.spec.ts   # Contoh file pengujian TypeScript
│   ├── example-js.spec.js # Contoh file pengujian JavaScript
│   └── ...               # Tambahkan file pengujian lain di sini
│
├── helpers/              # (Opsional) Fungsi utilitas/helper & Page Object Model
│   └── homepage-admin.ts
│
├── fixtures/             # (Opsional) Data dummy atau data uji (test data)
│   └── admin.json
│
├── reports/              # (Otomatis) Hasil laporan pengujian (HTML, dsb)
├── test-results/         # (Otomatis) Hasil run test Playwright (trace, dsb)
├── node_modules/         # Folder dependensi npm (otomatis)
├── package.json          # Konfigurasi npm & dependensi
├── package-lock.json     # Lock file npm
├── playwright.config.ts  # Konfigurasi Playwright (baseURL, reporter, dsb)
├── README.md             # Dokumentasi project
└── PUSH_GUIDE.md         # Panduan git push file baru
```

---

### Penjelasan folder/file yang sering dipakai:
- `tests/` : Tempat semua file pengujian Playwright (`*.spec.js`/`*.spec.ts`).
- `helpers/` : Untuk Page Object Model dan fungsi bantu.
- `fixtures/` : Untuk data uji, misal data user, produk, dsb.
- `reports/` : Tempat hasil laporan pengujian (HTML).
- `test-results/` : Hasil run test Playwright (trace, dsb).
- `playwright.config.ts` : File konfigurasi Playwright (baseURL, reporter, dsb).

---

© 2025 [diansamuel13](https://github.com/diansormin13)