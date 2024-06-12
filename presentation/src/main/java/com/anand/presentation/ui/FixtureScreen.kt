package com.anand.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anand.domain.model.Fixture

@Composable
fun FixtureScreen(
    viewModel: FixtureViewModel = hiltViewModel()
) {
    val fixtures by viewModel.fixtures.collectAsState()

    val isLoading by viewModel.isLoading.collectAsState()

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        if (isLoading && fixtures.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp) // Adjust the size as needed
                )
            }        } else {
            Column {
                LazyColumn {
                    items(fixtures) { fixture ->
                        FixtureItem(fixture)
                    }
                }
            }
        }
    }
}

@Composable
fun FixtureItem(fixture: Fixture) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), // Add padding to the card
        elevation = CardDefaults.cardElevation(2.dp) // Use CardDefaults.cardElevation instead of elevation
    ) {
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = fixture.name ?: "Unknown",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, color = Color.Black) // Bold text
            )
            Text(
                text = fixture.resultInfo ?: "No result info",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Red) // Bold text
            )
            Text(
                text = fixture.startingAt ?: "Unknown date",
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}





