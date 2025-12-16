package com.nfy.guide_atomic_d.ui.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nfy.guide_atomic_d.ui.atoms.AtomTitleText
import com.nfy.guide_atomic_d.ui.molecules.MoleculeInfoCard

// Model data sederhana untuk konten carousel
data class GuideItem(val title: String, val desc: String)

// ORGANISME: Carousel Horizontal (Kumpulan Molekul)
@Composable
fun OrganismGuideCarousel(
    sectionTitle: String,
    items: List<GuideItem>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Menggunakan Atom untuk judul section
        AtomTitleText(
            text = sectionTitle,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Carousel (LazyRow) berisi Molekul
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier // Apply modifier to the Column, not LazyRow directly if it's meant for the whole organism
        ) {
            items(items) { item ->
                MoleculeInfoCard(
                    title = item.title,
                    description = item.desc,
                    buttonText = "Pelajari",
                    onButtonClick = { /* Aksi dummy */ },
                    // Modifier correction:
                    // Removed .weight(1f).matchParentSize() as it might conflict with LazyRow item sizing.
                    // Explicitly set width as intended.
                    modifier = Modifier.width(280.dp)
                )
            }
        }
    }
}
