package com.nfy.guide_atomic_d.presentation.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nfy.guide_atomic_d.ui.organisms.GuideItem
import com.nfy.guide_atomic_d.ui.organisms.OrganismGuideCarousel
import com.nfy.guide_atomic_d.ui.templates.TemplateMainScreen

@Composable
fun HomePage() {
    // Data Dummy untuk Konten Aplikasi
    val atomicData = listOf(
        GuideItem("Atom", "Komponen terkecil. Contoh: Button, Label, Icon."),
        GuideItem("Molekul", "Gabungan atom. Contoh: Search Bar (Input + Button)."),
        GuideItem("Organisme", "Bagian kompleks UI. Contoh: Header, Carousel ini."),
        GuideItem("Template", "Kerangka halaman tanpa data nyata."),
        GuideItem("Page", "Wujud akhir dengan data (Seperti halaman ini).")
    )

    val composeData = listOf(
        GuideItem("State", "Menyimpan data yang bisa berubah."),
        GuideItem("Modifier", "Mengatur layout dan gaya."),
        GuideItem("Composable", "Fungsi UI dasar di Android.")
    )

    // Menggunakan Template dan menyisipkan Organisme
    TemplateMainScreen(topBarTitle = "Panduan Atomic Design") {

        Spacer(modifier = Modifier.height(16.dp))

        // Organisme 1: Penjelasan Konsep
        OrganismGuideCarousel(
            sectionTitle = "Konsep Atomic Design",
            items = atomicData
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Organisme 2: Penjelasan Compose
        OrganismGuideCarousel(
            sectionTitle = "Info Jetpack Compose",
            items = composeData
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}