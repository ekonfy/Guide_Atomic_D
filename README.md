# ⚛️ Atomic Design Guide App (Android)

Aplikasi Android sederhana yang berfungsi sebagai **panduan interaktif** untuk memahami metodologi *Atomic Design*. 

Uniknya, aplikasi ini dibangun dengan **menerapkan struktur Atomic Design itu sendiri** pada kodenya. Ini adalah proyek "Learning by Doing" di mana struktur folder dan komponen UI mencerminkan teori yang dijelaskan di dalam aplikasi.

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=google-play&logoColor=white)

## 📱 Fitur Aplikasi

* **Home Dashboard:** Penjelasan konsep dasar (Atom, Molekul, Organisme) menggunakan Carousel.
* **Interactive Showcase:** Halaman detail yang mendemonstrasikan komponen UI secara langsung.
* **Atomic Codebase:** Struktur kode yang terorganisir rapi sesuai metodologi Brad Frost.

## 🏗️ Struktur Arsitektur (The Core Concept)

Proyek ini memisahkan komponen UI berdasarkan tingkat kompleksitasnya, mengikuti folder structure berikut:

```text
com.nfy.guide_atomic_d
├── presentation
│   └── pages          # Halaman akhir yang dilihat user (mengisi data ke Template)
│       ├── HomePage.kt
│       └── AtomDetailPage.kt
└── ui
    ├── atoms          # Komponen terkecil (Button, Text, Icon)
    │   ├── AtomButton.kt
    │   ├── AtomTitleText.kt
    │   └── ...
    ├── molecules      # Gabungan atom (Card, Input Field, Showcase Item)
    │   ├── MoleculeInfoCard.kt
    │   └── MoleculeShowcase.kt
    ├── organisms      # Bagian kompleks (Carousel, Header, Form)
    │   └── OrganismGuideCarousel.kt
    ├── templates      # Kerangka layout halaman (Scaffold, TopBar)
    │   └── TemplateMainScreen.kt
    └── theme          # Warna, Typography, dan Tema Material 3


