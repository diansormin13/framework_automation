# SMILE - Katalon Studio Test Automation Project

## 🧾 Overview
SMILE adalah proyek otomatisasi pengujian end-to-end berbasis Katalon Studio yang digunakan untuk menguji aplikasi web secara dinamis dan efisien. Proyek ini mendukung login berdasarkan role, profile switching, test listener otomatis, serta pengelolaan data berbasis .profile.

## 🚀 Setup & Requirements

### 📌 Tools & Versi
- Katalon Studio: versi 8.x ke atas
- Java JDK: versi 8
- Web Browser: Chrome
- WebDriver: Sesuai browser

### 📦 Plugin Katalon
Pastikan plugin berikut sudah terpasang:
- Basic Report
- Excel Keywords (opsional)

### 📁 Langkah Instalasi & Jalankan
1. Clone repository ke lokal:
```bash
git clone https://github.com/namamu/SMILE-Automation.git
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
- Folder: `XX-NamaFitur/`
- Test Case: `TC_XX_NamaSingkat`

Contoh:
- `01-Login/` → `TC_01_LoginValidUser`

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
GlobalVariable.useListener = true
GlobalVariable.autoLogin = true
GlobalVariable.retryCount = 2
```

- 🔧 `useListener = true` → listener diaktifkan
- 🔐 `autoLogin = true` → login otomatis saat test dijalankan
- 🎯 Ubah `autoLogin = false` untuk test yang tidak butuh login

## 🔁 Test Listeners

### Fungsi Listener
- Setup browser dan navigasi awal
- Login otomatis jika `autoLogin = true`
- Cleanup setelah test case
- Screenshot jika test gagal

### 📁 Lokasi Listener
Kode lengkap dapat dicek di folder:
`Test Listeners/TestListener.groovy`

### 💡 Tips
- Listener aktif jika `useListener = true`
- Login otomatis aktif jika `autoLogin = true`
- Untuk test login gagal, set `autoLogin = false`
- Tidak perlu memanggil ulang test case login

## 📁 Test Suites
- SmokeTest: Validasi login dan akses awal
- RegressionSuite: Menjalankan seluruh modul utama
- RoleBasedSuite: Validasi akses sesuai role pengguna

## 📌 Tips Tambahan
- Gunakan `retryCount` untuk retry otomatis saat test gagal
- Gunakan folder `Keywords/` untuk reusable functions
- Gunakan profile untuk switching user dan environment
- Hindari login berulang dengan mengandalkan listener

## ✅ Status
📍 Dokumen ini ditujukan untuk tim QA dan developer sebagai panduan pengembangan otomatisasi SMILE.
