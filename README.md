# App Produk Toko
Aplikasi desktop JavaFX untuk mencatat daftar produk toko.

## Fitur
- Form untuk menambahkan produk (kode, nama, kategori, harga, dan gambar opsional).
- Tabel yang menampilkan kode, nama, kategori, dan harga (format rupiah).
- Pencarian berdasarkan nama produk lewat tombol Cari (tidak peduli huruf besar/kecil) dan tombol Reset.
- Tombol Lihat Detail membuka halaman detail untuk produk yang dipilih di tabel.
- Validasi: nama produk tidak boleh kosong dan harga harus lebih dari nol. Pesan kesalahan tampil di layar.
- Data disimpan di memori selama aplikasi berjalan (tanpa database).

## screenshoot
### Halaman Daftar Produk (halaman utama)
<img width="1920" height="1080" alt="Screenshot 2026-11-09 202103" src="https://github.com/user-attachments/assets/5b4c70f2-a297-4b86-a3f7-b9315bc66490" />

### Halaman Tambah Produk
<img width="1920" height="1080" alt="Screenshot 2026-11-09 202128" src="https://github.com/user-attachments/assets/fee627f1-e807-46a5-ac77-eb6801ef166a" />

### - Jika nama produk tidak diisi
<img width="1920" height="1080" alt="Screenshot 2026-11-09 202202" src="https://github.com/user-attachments/assets/d7cbd2e4-4bbb-4959-a901-9c2ac9306fb0" />

### - Jika harga produk tidak diisi
<img width="1920" height="1080" alt="Screenshot 2026-11-09 202249" src="https://github.com/user-attachments/assets/6d8f4562-9225-4c81-9a46-0ac5cff35031" />

### Halaman Detail Produk
<img width="1920" height="1080" alt="Screenshot 2026-11-09 202422" src="https://github.com/user-attachments/assets/dd97e0d1-48f8-4ad6-8e1b-62ee72d18d42" />

### Fitur Cari
<img width="1920" height="1080" alt="Screenshot 2026-11-09 202347" src="https://github.com/user-attachments/assets/d9898eb7-ddc9-4915-adc8-ac85e6193c95" />
<img width="1920" height="1080" alt="Screenshot 2026-11-09 202405" src="https://github.com/user-attachments/assets/77b83223-6f62-4019-ad20-d7c6c3f39235" />


## Cara menjalankan
### Lewat NetBeans
1. Clone atau unduh repository ini.
2. Buka NetBeans, pilih File → Open Project, lalu pilih folder AppProdukToko.
3. Klik kanan proyek → Clean and Build.
4. Klik kanan proyek → Run.

### Lewat Terminal
```bash
git clone <url-repository-ini>
cd AppProdukToko
mvn clean javafx:run```
