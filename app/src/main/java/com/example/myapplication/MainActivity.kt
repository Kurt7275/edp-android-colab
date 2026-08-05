package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        GroceryListApp()
      }
    }
  }
}

@Composable
fun GroceryListApp() {

  // ── 1. STATE ──────────────────────────────
  var newItem by remember { mutableStateOf("") }
  val groceries = remember { mutableStateListOf<String>() }

  Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text(text = "My Grocery List", fontSize = 24.sp)

    Spacer(modifier = Modifier.height(16.dp))

    // ── 2. INPUT + ADD EVENT ──────────────
    Row(verticalAlignment = Alignment.CenterVertically) {
      OutlinedTextField(
          value = newItem,
          onValueChange = { newItem = it },
          label = { Text("Enter an item") },
          modifier = Modifier.weight(1f),
      )

      Spacer(modifier = Modifier.width(8.dp))

      // Part B — Challenge 1: ignore empty items
      Button(
          onClick = {
            if (newItem.isNotBlank()) {
              groceries.add(newItem.trim())
              newItem = ""
            }
          }
      ) {
        Text("Add")
      }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Part B — Challenge 2: live item count
    Text(
        text = "Total items: ${groceries.size}",
        fontSize = 16.sp,
    )

    // Optional Bonus: Clear All button
    if (groceries.isNotEmpty()) {
      TextButton(onClick = { groceries.clear() }) {
        Text("Clear All")
      }
    }

    Spacer(modifier = Modifier.height(8.dp))

    HorizontalDivider()

    Spacer(modifier = Modifier.height(8.dp))

    // ── 3. LIST + DELETE EVENT ────────────
    LazyColumn {
      items(groceries) { item ->
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(text = item, fontSize = 18.sp)

          IconButton(onClick = { groceries.remove(item) }) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete $item",
            )
          }
        }
      }
    }
  }
}
