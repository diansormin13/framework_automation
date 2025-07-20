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