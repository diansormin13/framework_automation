# 🧾 Overview

Ini adalah Katalon Studi test automation framework untuk pengembangan project Aplikasi SMILE BPJS Ketenagakerjaan

## 🚀 Setup & Requirements

### 📌 Tools & Versi

- Katalon Studio: 12.0.1
- Java JDK: versi 8
- Web Browser: Chrome/Firefox/Edge
- WebDriver: Sesuai browser

### 📁 Langkah Instalasi & Jalankan

1. Clone repository ke lokal:
```bash
git clone https://git.bpjsketenagakerjaan.go.id/pti/smile/devsecops/automation/web-application.git
```

2. Buka project di Katalon Studio:
   - File > Open Project > pilih folder SMILE

3. Jalankan test:
   - Pilih Profile > Pilih Test Case > Run

## 🔁 Cara Commit, Push, dan Penamaan Branch

### 📥 Commit & Push

1. Tambahkan perubahan:
```bash
git add .
```

2. Commit perubahan:
```bash
git commit -m "your-commite-message"
```

3. List commit:
   - feat: fitur baru
   - fix: perbaikan bug
   - refactor: perubahan tanpa ubah fungsionalitas
   - test: penambahan/perubahan test
   - docs: dokumentasi

   Contoh:
   - your-committe-message → feat: penambahan testcase 001

4. Push ke repository:
```bash
git push origin feat/test-nama-branch
```

   Contoh:
   - branch baru → feat/test-todolist

5. Branch:
   - feat/test-nama-branch
   - Nama Branch disesuaikan dengan nama branch pengembangan fitur yang ada pada repository developer 

> 💡 Jangan lupa untuk selalu git pull dari branch MASTER untuk menghindari conflict ketika dilakukan merge
> 💡 Gunakan format branch: feat/test-(nama-branch) untuk penamaan fitur atau test baru.

## 🗂️ Project Structure

```
SMILE/
├── .git/                      # Git repository files
├── .gradle/                   # Gradle build system files
├── .settings/                 # Project settings
├── .vscode/                   # VS Code settings
├── .cache/                    # Cache files
├── bin/                       # Compiled files
├── build/                     # Build output directory
├── Checkpoints/              # Test checkpoints
├── Data Files/               # Test data files
├── Drivers/                  # WebDriver executables
├── Include/                  # Include files
├── Keywords/                 # Custom keywords and functions
├── Libs/                     # External libraries
├── Object Repository/        # Page objects and elements
├── Plugins/                  # Katalon plugins
├── Profiles/                 # Environment profiles
├── Reports/                  # Test execution reports
├── Screenshots/             # Test execution screenshots
├── Scripts/                  # Utility scripts
├── settings/                 # Project settings
├── Test Cases/              # Test case files
│   ├── 01-Login/           # Login test cases
│   └── 02-Menu/            # Menu test cases
├── Test Listeners/          # Test listeners
├── Test Suites/             # Test suites
│   └── 03-Collection/      # Test collections
├── .classpath               # Classpath configuration
├── .gitignore              # Git ignore rules
├── .project                # Project configuration
├── build.gradle            # Gradle build configuration
├── console.properties      # Console properties
├── README.md               # Project documentation
└── SMILE.prj               # Katalon project file
```

## ⚙️ Profile

Profile adalah fitur untuk menyimpan kumpulan variabel global (GlobalVariables) yang bisa digunakan di seluruh test case, test suite, dan keyword

### Contoh default.profile

```groovy
GlobalVariable.username = 'admin'
GlobalVariable.password = 'pass1'
GlobalVariable.ENABLE_MAIN_LISTENER = true
GlobalVariable.AUTO_LOGIN = true
```

- 🔧 ENABLE_MAIN_LISTENER = true → listener diaktifkan
- 🔐 AUTO_LOGIN = true → login otomatis saat test dijalankan
- 🎯 Ubah AUTO_LOGIN = false untuk test yang tidak butuh login seperti pengujian lupa password
- 🔧 Penamaan = disesuiakan dengan nama branch fitur yang ada pada repository developer
- 🔐 AUTO_LOGIN, ENABLE_MAIN_LISTENER → global variabel yang wajib ada disetiap profile 
- 🎯 username, password → global variabel yang wajib ada disetiap profile jika pengujian membutuhkan login ke aplikasi SMILE

## 📚 Test Case, Test Suite, Test Collection

### 🔹 Penamaan Folder & Test Case

- Folder: Test Case/Menu Utama SMILE/Sub Menu Langsung sesuai Project
- Test Case: SMTC_Nama Project_XX-fitur_Failed/Success
  - Status Failed: Negative Case
  - Status Success: Positive Case
  - Contoh: folder login → fitur login → success
    - 01-Login/ → SMTC_Login_01-LoginValidUser_Success

### 🔹 Struktur Test Case

```
Test Cases/
├── 01-Login/
│   ├── SMTC_Login_01-LoginValidUser_Success
│   └── SMTC_Login_02-LoginInvalidUser_Failed
├── 02-Dashboard/
│   ├── SMTC_Dashboard_01-VerifyMenu_Success
│   └── SMTC_Dashboard_02-VerifyWidget_Success
└── 03-Profile/
    ├── SMTC_Profile_01-UpdateData_Success
    └── SMTC_Profile_02-ChangePassword_Success
```

Karena login dilakukan otomatis melalui Test Listener, test case tidak perlu memanggil ulang login.

Selanjutnya masukkan langkah-langkah penggunaan fitur yang sedang diuji 

> 🎯 Jika ingin ganti user, cukup ubah GlobalVariable.username dan GlobalVariable.password di test case. Selebihnya akan dijelaskan pada bagian penggunaan listener pada bagian penjelasan listener dihalaman ini

### 🔹 Penamaan Folder & Test Suite

- Folder Test Suites: Test Suites/Menu Utama SMILE/Sub Menu Langsung sesuai Project
- Folder Menu Utama Smile dapat dilihat pada bagian Struktur Test Suites dibawah
- Test Suites: SMTS_Nama Project_XX-fitur
  - Contoh:
    - 01-Login/ → SMTS_Login_01-Login

### 🔹 Penamaan Folder & Test Suite Collection

- Folder Test Suites Collection: Test Suites/03-COllection/Sub Menu Langsung sesuai Project
- Test Suites: SMTS_Nama Project_XX-fitur
  - Contoh:
    - 01-Login/ → SMTS_Login_01-Login

### 🔹 Struktur Test Suites

```
Test Suites/
├── 01-Login/
│   ├── SMTS_Login_01-LoginValid
│   └── SMTS_Login_02-LoginInvalid
├── 02-Menu/
│   ├── 01-Executive Summary/
│   │   ├── SMTS_Executive_01-VerifyDashboard
│   │   └── SMTS_Executive_02-VerifyCharts
│   ├── 02-Data Management/
│   │   ├── SMTS_Data_01-ImportData
│   │   └── SMTS_Data_02-ExportData
│   ├── 03-User Management/
│   │   ├── SMTS_User_01-CreateUser
│   │   └── SMTS_User_02-UpdateUser
│   └── 04-Settings/
│       ├── SMTS_Settings_01-UpdateConfig
│       └── SMTS_Settings_02-ResetConfig
└── 03-Collection/
    ├── 01-Executive Summary/
    │   ├── SMTSC_Executive_01-Collection
    │   └── SMTSC_Executive_02-Collection
    ├── 02-Data Management/
    │   ├── SMTSC_Data_01-Collection
    │   └── SMTSC_Data_02-Collection
    ├── 03-User Management/
    │   ├── SMTSC_User_01-Collection
    │   └── SMTSC_User_02-Collection
    └── 04-Settings/
        ├── SMTSC_Settings_01-Collection
        └── SMTSC_Settings_02-Collection
```

### 🔹 Cara Menjalankan

- Gunakan Run langsung dari test case, test suite, atau suite collection.
- Jangan lupa untuk mengganti jenis profile yang memuat semua kebutuhan test case
- Tidak perlu memanggil test case login secara eksplisit karena login dilakukan otomatis oleh listener.
- Jika ingin menjalankan sebagai user yang berbeda, cukup ubah GlobalVariable.username dan GlobalVariable.password di test case tersebut.

## 🔁 Test Listeners

menjalankan kode secara otomatis sebelum, selama, atau setelah proses pengujian, tanpa harus menulis ulang di setiap test case atau test suite

### Fungsi Listener

- Listener aktif jika ENABLE_MAIN_LISTENER = true
- Setup browser dan navigasi awal
- Login otomatis jika AUTO_LOGIN = true
- lokasi : Test Listeners/TestListener.groovy

### 📌 Tips

- Listener aktif jika useListener = true
- Login otomatis aktif jika autoLogin = true
- Untuk test login gagal, set autoLogin = false
- Tidak perlu memanggil ulang test case login
- Gunakan folder Keywords/ untuk reusable functions
- Gunakan profile untuk switching user dan environment
- Hindari login berulang dengan mengandalkan listener

## ✅ Status

📍 Dokumen ini ditujukan untuk tim QA dan developer sebagai panduan pengembangan pengujian otomatisasi SMILE menggunakan Katalon Studio.

## 📄 License

© 2025 Tim QC SMILE. All rights reserved.
