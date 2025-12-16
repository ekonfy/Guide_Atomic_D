package com.nfy.guide_atomic_d.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nfy.guide_atomic_d.ui.atoms.AtomBodyText

// MOLEKUL: Menampilkan contoh komponen (kiri) dan penjelasannya (kanan)
@Composable
fun MoleculeShowcase(
    label: String,
    component: @Composable () -> Unit // Slot untuk memasukkan Atom apapun
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Bagian Kiri: Penjelasan
        AtomBodyText(text = label, modifier = Modifier.weight(1f))

        Spacer(modifier = Modifier.width(16.dp))

        // Bagian Kanan: Komponen Atom yang didemonstrasikan
        // Kita beri kotak background tipis agar terlihat rapi
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            component()
        }
    }
}