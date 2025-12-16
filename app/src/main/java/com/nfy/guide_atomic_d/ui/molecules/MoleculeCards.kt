package com.nfy.guide_atomic_d.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nfy.guide_atomic_d.ui.atoms.AtomBodyText
import com.nfy.guide_atomic_d.ui.atoms.AtomButton
import com.nfy.guide_atomic_d.ui.atoms.AtomTitleText

// MOLEKUL: Kartu Penjelasan (Judul + Deskripsi + Tombol Aksi)
@Composable
fun MoleculeInfoCard(
    title: String,
    description: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            AtomTitleText(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            AtomBodyText(text = description)
            Spacer(modifier = Modifier.height(16.dp))
            AtomButton(text = buttonText, onClick = onButtonClick)
        }
    }
}