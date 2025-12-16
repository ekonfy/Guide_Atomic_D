package com.nfy.guide_atomic_d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

// Dummy HomePage and AtomDetailPage for compilation, replace with your actual implementations
@Composable
fun HomePage(modifier: Modifier = Modifier, onNavigateToDetail: (String) -> Unit) { // Renamed for clarity
    Column(modifier = modifier.padding(16.dp)) {
        Text("Home Page", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        AtomButton(text = "Go to Detail", onClick = { onNavigateToDetail("someAtomId") }) // Example of using navigation
        Spacer(modifier = Modifier.height(16.dp))

        OrganismGuideCarousel(
            sectionTitle = "Featured Guides",
            items = listOf(
                GuideItem("Atom", "Smallest UI elements"),
                GuideItem("Molecule", "Combinations of Atoms"),
                GuideItem("Organism", "Complex UI parts")
            ),
            onItemClick = { title -> onNavigateToDetail(title) }, // Pass title to callback
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// AtomDetailPage now accepts atomId and displays relevant info
@Composable
fun AtomDetailPage(atomId: String?, modifier: Modifier = Modifier, onBackClick: () -> Unit) { // Added onBackClick parameter
    Column(modifier = modifier.padding(16.dp).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        // Displaying title based on atomId
        val title = when (atomId) {
            "Atom" -> "Guide to Atoms"
            "Molecule" -> "Guide to Molecules"
            "Organism" -> "Guide to Organisms"
            else -> "Details for $atomId"
        }
        Text(title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Use a Card to contain the detailed content for better visual separation
        Card(modifier = Modifier.fillMaxWidth(0.9f), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                val description = when (atomId) {
                    "Atom" -> "Atoms are the basic building blocks of matter. In UI design, they represent the smallest indivisible UI elements like buttons, input fields, icons, etc."
                    "Molecule" -> "Molecules are groups of Atoms bonded together. They are simple UI components composed of atoms, like a search form (label + input + button)."
                    "Organism" -> "Organisms are relatively complex UI components composed of Molecules and/or Atoms. They form distinct sections of an interface, like a header, footer, or a complex data display."
                    else -> "Details for $atomId"
                }
                Text(description, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))

                // Displaying examples and copyable code
                when (atomId) {
                    "Atom" -> {
                        ExampleSection(
                            title = "Examples",
                            codeSnippet = """ // Example: AtomButton 
@Composable
fun AtomButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = text)
    }
}

// Usage:
// AtomButton(text = "Click Me", onClick = { /* do something */ })""",
                            content = { // Content to be displayed interactively
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    AtomButton(text = "Sample Atom Button", onClick = { /* Placeholder action */ })
                                    Spacer(modifier = Modifier.height(8.dp))
                                    AtomInput(label = "Sample Atom Input", modifier = Modifier.fillMaxWidth())
                                }
                            }
                        )
                    }
                    "Molecule" -> {
                        ExampleSection(
                            title = "Examples",
                            codeSnippet = """ // Example: MoleculeLoginInput 
@Composable
fun MoleculeLoginInput(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AtomInput(label = "Username", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        AtomInput(label = "Password", modifier = Modifier.fillMaxWidth())
    }
}

// Usage:
// MoleculeLoginInput()
""",
                            content = { // Content to be displayed interactively
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    MoleculeLoginInput(modifier = Modifier.fillMaxWidth())
                                }
                            }
                        )
                    }
                    "Organism" -> {
                        ExampleSection(
                            title = "Examples",
                            codeSnippet = """ // Example: OrganismLoginForm 
@Composable
fun OrganismLoginForm(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        MoleculeLoginInput(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        MoleculeLoginButton(modifier = Modifier.fillMaxWidth())
    }
}

// Usage:
// OrganismLoginForm()
""",
                            content = { // Content to be displayed interactively
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    OrganismLoginForm(modifier = Modifier.fillMaxWidth())
                                }
                            }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        AtomButton(text = "Back to Home", onClick = onBackClick)
    }
}

// Helper composable to display code snippets and interactive examples
@Composable
fun ExampleSection(
    title: String,
    codeSnippet: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        
        // Card for the code snippet
        Card( 
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Text(
                text = codeSnippet,
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                modifier = Modifier.padding(12.dp).fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        
        // Content display (interactive example)
        Text("Interactive Example:", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Card( 
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                content()
            }
        }
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
fun TemplateHomeScreen(modifier: Modifier = Modifier, navigateToDetail: (String) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        paddingValues -> HomePage(modifier = modifier.padding(paddingValues), onNavigateToDetail = navigateToDetail)
    }
}

// Main Activity - now uses state to navigate between HomePage and AtomDetailPage
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Guide_Atomic_DTheme {
                var currentScreen by remember { mutableStateOf("home") }
                var selectedAtomId by remember { mutableStateOf<String?>(null) }

                when (currentScreen) {
                    "home" -> {
                        TemplateHomeScreen(
                            navigateToDetail = { atomTitle ->
                                selectedAtomId = atomTitle
                                currentScreen = "detail_atom"
                            }
                        )
                    }
                    "detail_atom" -> {
                        AtomDetailPage(
                            atomId = selectedAtomId,
                            onBackClick = { currentScreen = "home" }
                        )
                    }
                }
            }
        }
    }
}

// Assuming OrganismGuideCarousel and GuideItem are defined in ui.organisms package
// Example definitions if they are not in separate files:

// Define GuideItem if not already defined
data class GuideItem(val title: String, val desc: String)

// Organism: Carousel
@Composable
fun OrganismGuideCarousel(
    sectionTitle: String,
    items: List<GuideItem>,
    onItemClick: (String) -> Unit, // Callback for item clicks
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(sectionTitle, style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items) {
                item ->
                // Simulate a clickable card for each guide item
                Card(
                    modifier = Modifier
                        .width(280.dp)
                        .clickable { onItemClick(item.title) }, // Trigger callback on click
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(item.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(item.desc, style = MaterialTheme.typography.bodyMedium)
                        // Adding a placeholder button to mimic the image, but click is on the whole card
                        Button(onClick = { onItemClick(item.title) }, modifier = Modifier.padding(top = 8.dp)) {
                            Text("Pelajari")
                        }
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
        TemplateHomeScreen(navigateToDetail = { /* no-op */ })
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Guide_Atomic_DTheme {
        TemplateLoginScreen()
    }
}
