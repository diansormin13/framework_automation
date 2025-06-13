# SMILE - Katalon Studio Test Automation Project

## 🧾 Overview
Ini adalah Katalon Studi test automation framework untuk pengembangan project Aplikasi SMILE BPJS Ketenagakerjaan

## 🚀 Setup & Requirements

### 📌 Tools & Versi
- Katalon Studio: versi 8.x ke atas
- Java JDK: versi 8
- Web Browser: Chrome/Firefox/Edge
- WebDriver: Sesuai browser

### 📦 Katalon
Version 12.0.1

### 📁 Langkah Instalasi & Jalankan
1. Clone repository ke lokal:
```bash
git clone https://git.bpjsketenagakerjaan.go.id/pti/smile/devsecops/automation/web-application.git
```

2. Buka project di Katalon Studio:
   - File > Open Project > pilih folder SMILE

3. Jalankan test suite awal:
   - Test Suites > SmokeTest > Run

## 🔁 Cara Commit, Push, dan Penamaan Repo

### 📥 Commit & Push
1. Tambahkan perubahan:
```bash
git add .
```

2. Commit perubahan:
```bash
git commit -m "feat: add test case for new dashboard module"
```

3. Konvensi commit:
- feat: fitur baru
- fix: perbaikan bug
- refactor: perubahan tanpa ubah fungsionalitas
- test: penambahan/perubahan test
- docs: dokumentasi

4. Push ke repository:
```bash
git push origin feat/test-nama-branch
```

💡 Jangan lupa untuk selalu git pull dari branch MASTER untuk menghindari conflict ketika dilakukan merge
💡 Gunakan format branch: `feat/test-(nama-branch)` untuk penamaan fitur atau test baru.

## 🗂️ Project Structure
```
SMILE/
├── Test Cases/
│   ├── 01-Login/
│   └── 02-Menu/
├── Profiles/
├── Test Suites/
├── Object Repository/
├── Keywords/
├── Reports/
├── settings/, lib/, build.gradle, README.md, etc.
```

## 📚 Struktur & Penamaan

### 🔹 Penamaan Folder & Test Case
- Folder: `Test Case/Menu Utama SMILE/Sub Menu Langsung sesuai Project`
- Test Case: `SMTC_Nama Project_XX-fitur_Failed/Success`

Contoh:
- `01-Login/` → `SMTC_Login_01-LoginValidUser_Success`

### 🔹 Struktur Test Case
Karena login dilakukan otomatis melalui Test Listener, maka test case tidak perlu memanggil ulang login.

```groovy
WebUI.click(findTestObject('Menu/btnDashboard'))
WebUI.verifyElementPresent(findTestObject('Dashboard/lblWelcome'), 10)
```

🎯 Jika ingin ganti user, cukup ubah `GlobalVariable.username` dan `GlobalVariable.password` di test case.

### 🔹 Cara Menjalankan Test Case
- Gunakan Run langsung dari test case, test suite, atau suite collection.
- Jangan lupa untuk mengganti jenis profile yang memuat semua kebutuhan test case
- Tidak perlu memanggil test case login secara eksplisit karena login dilakukan otomatis oleh listener.
- Jika ingin menjalankan sebagai user yang berbeda, cukup ubah `GlobalVariable.username` dan `GlobalVariable.password` di test case tersebut.

## ⚙️ Profile
Contoh default.profile
```groovy
GlobalVariable.username = 'admin'
GlobalVariable.password = 'pass1'
GlobalVariable.ENABLE_MAIN_LISTENER = true
GlobalVariable.AUTO_LOGIN = true
```

- 🔧 `ENABLE_MAIN_LISTENER = true` → listener diaktifkan
- 🔐 `AUTO_LOGIN = true` → login otomatis saat test dijalankan
- 🎯 Ubah `autoLogin = false` untuk test yang tidak butuh login seperti pengujian `lupa password`

## 🔁 Test Listeners

### Fungsi Listener
- Setup browser dan navigasi awal
- Login otomatis jika `autoLogin = true`
- Cleanup setelah test case
- Screenshot jika test gagal

### 📁 Lokasi Listener
Kode lengkap dapat dicek di folder:
`Test Listeners/TestListener.groovy`

## 📁 Test Suites dan Test Collection
- Folder Test Suites: `Test Suites/Menu Utama SMILE/Sub Menu Langsung sesuai Project`
- Test Suites: `SMTS_Nama Project_XX-fitur'
Contoh:
- `01-Login/` → `SMTS_Login_01-Login`

- Folder Test Collection : `Test Suites/03-Collection/Menu Utama`
- Test Collection: `SMTSC_Nama Project_XX-fitur'
Contoh:
- `01-Login/` → `SMTSC_Login_01-Login`

- SmokeTest: Validasi login dan akses awal
- RegressionSuite: Menjalankan seluruh modul utama
- RoleBasedSuite: Validasi akses sesuai role pengguna

## 📌 Tips
- Listener aktif jika `useListener = true`
- Login otomatis aktif jika `autoLogin = true`
- Untuk test login gagal, set `autoLogin = false`
- Tidak perlu memanggil ulang test case login
- Gunakan folder `Keywords/` untuk reusable functions
- Gunakan profile untuk switching user dan environment
- Hindari login berulang dengan mengandalkan listener

## ✅ Status
📍 Dokumen ini ditujukan untuk tim QA dan developer sebagai panduan pengembangan pengujian otomatisasi SMILE menggunakan Katalon Studio.

## 📄 License

© 2025 Tim QC SMILE. All rights reserved.
