package com.nfy.guide_atomic_d.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nfy.guide_atomic_d.ui.atoms.AtomBodyText
import com.nfy.guide_atomic_d.ui.atoms.AtomButton
import com.nfy.guide_atomic_d.ui.atoms.AtomIcon
import com.nfy.guide_atomic_d.ui.atoms.AtomTitleText
import com.nfy.guide_atomic_d.ui.molecules.MoleculeShowcase
import com.nfy.guide_atomic_d.ui.templates.TemplateMainScreen

@Composable
fun AtomDetailPage(
    onBackClick: () -> Unit // Callback untuk kembali ke Home
) {
    // Kita reuse TemplateMainScreen
    TemplateMainScreen(topBarTitle = "Detail: Atom") {
        Column(modifier = Modifier.padding(16.dp)) {

            // 1. Definisi (Menggunakan Atom Text)
            AtomTitleText(text = "Apa itu Atom?")
            Spacer(modifier = Modifier.height(8.dp))
            AtomBodyText(
                text = "Atom adalah blok bangunan dasar dari antarmuka pengguna. " +
                        "Atom tidak bisa dipecah lagi tanpa kehilangan fungsinya. " +
                        "Dalam Android Development, ini setara dengan View dasar atau Composable sederhana."
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 2. Contoh Visual (Menggunakan MoleculeShowcase)
            AtomTitleText(text = "Contoh Komponen Atom")
            Spacer(modifier = Modifier.height(16.dp))

            // Showcase 1: Text
            MoleculeShowcase(label = "Atom Typography (Judul)") {
                AtomTitleText(text = "Judul")
            }

            // Showcase 2: Button
            MoleculeShowcase(label = "Atom Button (Tombol)") {
                AtomButton(text = "Klik Saya", onClick = {})
            }

            // Showcase 3: Icon
            MoleculeShowcase(label = "Atom Icon (Simbol)") {
                AtomIcon(imageVector = Icons.Default.Favorite, contentDescription = "Love")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Tombol Kembali (Navigasi manual untuk sementara)
            AtomButton(
                text = "Kembali ke Beranda",
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}