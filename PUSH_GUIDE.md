# 🚀 Cara Push Project ke Branch Tertentu di GitHub

Dokumentasi ini menjelaskan langkah-langkah untuk melakukan inisialisasi Git dan push project ke branch tertentu (misalnya `playwright`) di GitHub.

---

## ✅ Langkah 1: Inisialisasi Git (Jika Belum)

Masuk ke folder project kamu:

```bash
git init
```

---

## ✅ Langkah 2: Buat dan Pindah ke Branch Target

Misalnya kita ingin push ke branch `playwright`:

```bash
git checkout -b playwright
```

---

## ✅ Langkah 3: Tambahkan Remote Origin

Tambahkan remote ke repositori GitHub kamu:

```bash
git remote add origin https://github.com/example-user/framework_automation.git
```

> Ganti `example-user/framework_automation.git` dengan URL GitHub kamu sendiri.

---

## ✅ Langkah 4: Tambahkan dan Commit File

```bash
git add .
git commit -m "Initial commit on playwright branch"
```

---

## ✅ Langkah 5: Push ke Branch GitHub

```bash
git push -u origin playwright
```

> `-u` artinya Git akan mengingat remote & branch default, sehingga ke depan cukup gunakan `git push`.

---

## 🔁 Cek Branch

### Lihat branch lokal:
```bash
git branch
```

### Lihat branch remote:
```bash
git branch -r
```

---

## 📌 Catatan

- Jika repo di GitHub masih kosong, pastikan **belum ada file README atau `.gitignore`** agar push tidak ditolak.
- Jika sudah terlanjur commit di branch `main`, kamu bisa buat branch baru dari situ:
  
  ```bash
  git checkout -b playwright
  git push -u origin playwright
  ```

---

## ✅ Contoh URL Remote (Dummy)

```bash
git remote add origin https://github.com/example-user/framework_automation.git
```

---

Silakan sesuaikan nama branch sesuai kebutuhan seperti `dev`, `staging`, `feature/login`, dll.

---

# Panduan Push File Baru ke Git

Berikut langkah-langkah untuk menambahkan dan push file baru saja ke repository Git:

## 1. Cek Status File Baru
```bash
git status
```
File baru akan muncul di bagian "Untracked files" (merah).

## 2. Tambahkan File Baru Saja
Misal file baru bernama `file-baru.txt`:
```bash
git add file-baru.txt
```
Atau untuk beberapa file baru:
```bash
git add file1.js file2.ts
```

## 3. Commit Perubahan
Beri pesan commit yang jelas:
```bash
git commit -m "Add file baru: file-baru.txt"
```

## 4. Push ke Remote Repository
```bash
git push origin <branch-anda>
```
Ganti `<branch-anda>` dengan nama branch yang sedang aktif (misal: `main` atau `develop`).

## Tips
- **Jangan gunakan `git add .` jika hanya ingin push file baru tertentu.**
- Selalu cek file yang akan di-commit dengan `git status` sebelum push.
- Jika file baru ada di folder, tambahkan dengan path lengkap, misal:
  ```bash
  git add helpers/homepage-admin.ts
  ```

---

Jika ada file yang tidak ingin di-push, pastikan file tersebut tidak di-add atau sudah masuk `.gitignore`. 