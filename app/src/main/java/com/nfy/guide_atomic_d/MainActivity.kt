package com.nfy.guide_atomic_d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
// Import OrganismGuideCarousel
import com.nfy.guide_atomic_d.ui.organisms.OrganismGuideCarousel
import com.nfy.guide_atomic_d.ui.organisms.GuideItem
import com.nfy.guide_atomic_d.ui.theme.Guide_Atomic_DTheme

// Atoms
@Composable
fun AtomButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = text)
    }
}

@Composable
fun AtomInput(label: String, modifier: Modifier = Modifier) {
    androidx.compose.material3.OutlinedTextField(
        value = "",
        onValueChange = { /* TODO */ },
        label = { Text(label) },
        modifier = modifier
    )
}

@Composable
fun AtomCarousel(items: List<String>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier.height(150.dp)) {
        items(items) {
            item -> Card(modifier = Modifier.size(130.dp).padding(8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
                Text(text = item, modifier = Modifier.padding(16.dp).fillMaxSize()) // Placeholder content
            }
        }
    }
}

@Composable
fun AtomSlider(modifier: Modifier = Modifier) {
    Text("Slider Placeholder", modifier = modifier.padding(16.dp))
}

@Composable
fun AtomCard(title: String, description: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp))
        {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

// Molecules
@Composable
fun MoleculeLoginInput(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AtomInput(label = "Username", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        AtomInput(label = "Password", modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun MoleculeLoginButton(modifier: Modifier = Modifier) {
    AtomButton(text = "Login", onClick = { /* TODO: Implement login */ }, modifier = modifier.fillMaxWidth())
}

// Organisms
@Composable
fun OrganismLoginForm(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        MoleculeLoginInput(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        MoleculeLoginButton(modifier = Modifier.fillMaxWidth())
    }
}

// Organism Sections (contoh jika Anda ingin memisahkannya)
// Jika OrganismSections.kt ada di folder yang sama, importnya akan seperti ini
// import com.nfy.guide_atomic_d.ui.organisms.OrganismGuideCarousel

// Dummy HomePage and AtomDetailPage for compilation, replace with your actual implementations
@Composable
fun HomePage(modifier: Modifier = Modifier, onAtomClick: (String) -> Unit) { // Added onAtomClick parameter
    Column(modifier = modifier.padding(16.dp)) {
        Text("Home Page", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        AtomButton(text = "Go to Detail", onClick = { onAtomClick("someAtomId") }) // Example of using onAtomClick
        Spacer(modifier = Modifier.height(16.dp))
        // Add other home page components here
        OrganismGuideCarousel(
            sectionTitle = "Featured Guides",
            items = listOf(
                GuideItem("Atom", "Smallest UI elements"),
                GuideItem("Molecule", "Combinations of Atoms"),
                GuideItem("Organism", "Complex UI parts")
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// AtomDetailPage now accepts atomId
@Composable
fun AtomDetailPage(atomId: String?, modifier: Modifier = Modifier, onBackClick: () -> Unit) { // Added atomId and onBackClick parameters
    Column(modifier = modifier.padding(16.dp)) {
        Text("Atom Detail Page for: $atomId", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        AtomButton(text = "Back to Home", onClick = onBackClick)
    }
}


@Composable
fun OrganismHomeContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("Featured Items", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        AtomCarousel(items = listOf("Item 1", "Item 2", "Item 3"), modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(24.dp))

        Text("Quick Actions", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        AtomSlider(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(24.dp))

        Text("Highlights", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        AtomCard(title = "Card 1", description = "This is the first card.", modifier = Modifier.fillMaxWidth())
        AtomCard(title = "Card 2", description = "This is the second card.", modifier = Modifier.fillMaxWidth())
    }
}

// Templates (or Pages)
@Composable
fun TemplateLoginScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        paddingValues -> OrganismLoginForm(modifier = modifier.padding(paddingValues).fillMaxSize())
    }
}

@Composable
fun TemplateHomeScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        paddingValues -> OrganismHomeContent(modifier = modifier.padding(paddingValues))
    }
}

// Main Activity - now uses state to navigate between HomePage and AtomDetailPage
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Guide_Atomic_DTheme {
                // State sederhana untuk mengatur halaman mana yang tampil
                var currentScreen by remember { mutableStateOf("home") }
                var selectedAtomId by remember { mutableStateOf<String?>(null) } // State untuk menyimpan ID atom yang dipilih

                when (currentScreen) {
                    "home" -> {
                        HomePage(
                            onAtomClick = { atomId ->
                                selectedAtomId = atomId // Simpan ID atom yang diklik
                                currentScreen = "detail_atom" // Pindah ke halaman detail
                            }
                        )
                    }
                    "detail_atom" -> {
                        AtomDetailPage(
                            atomId = selectedAtomId, // Kirim ID atom ke halaman detail
                            onBackClick = { // Panggil fungsi kembali
                                currentScreen = "home" // Kembali ke halaman home
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Guide_Atomic_DTheme {
        TemplateHomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Guide_Atomic_DTheme {
        TemplateLoginScreen()
    }
}
