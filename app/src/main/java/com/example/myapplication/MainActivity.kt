package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        ProfileScreen()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
  Scaffold(
      topBar = {
        TopAppBar(
            title = {
              Text(
                  "My Profile",
                  style = MaterialTheme.typography.titleLarge,
                  fontWeight = FontWeight.Bold,
              )
            },
            navigationIcon = {
              IconButton(onClick = {}) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
              }
            },
            actions = {
              IconButton(onClick = {}) {
                Icon(Icons.Default.MoreVert, contentDescription = "More")
              }
            },
            colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
        )
      },
      floatingActionButton = {
        FloatingActionButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
        ) {
          Icon(Icons.Default.Add, contentDescription = "Add")
        }
      },
  ) { innerPadding ->
    Column(
        modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
      // Region B & C: Avatar + Badge + Name & Role
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.BottomEnd) {
          Image(
              painter = painterResource(id = R.drawable.profile_pic),
              contentDescription = "Avatar",
              modifier =
                  Modifier.size(100.dp)
                      .clip(CircleShape)
                      .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape),
              contentScale = ContentScale.Crop,
          )
          // Status Badge
          Surface(
              modifier =
                  Modifier.size(24.dp).border(2.dp, MaterialTheme.colorScheme.surface, CircleShape),
              color = Color.Green,
              shape = CircleShape,
          ) {}
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Kurt Xierick Bautista",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = "IT Student",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
      }

      // Region D: Action Buttons
      Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        Button(
            onClick = {},
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(8.dp),
        ) {
          Text("Follow")
        }
        OutlinedButton(
            onClick = {},
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(8.dp),
            colors =
                ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.secondary
                ),
        ) {
          Text("Message")
        }
      }

      // Region E: Stats Card
      Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors =
              CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
      ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
          StatItem("Posts", "69")
          StatItem("Followers", "1M+")
          StatItem("Following", "1")
        }
      }

      // Region F: Contact Info Card
      Card(
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(16.dp),
          colors =
              CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
      ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
          ContactInfoRow(Icons.Default.Email, "kbautista99931@liceo.edu.ph")
          ContactInfoRow(Icons.Default.Phone, "09628960301")
          ContactInfoRow(Icons.Default.LocationOn, "Zone 1 Sta.Ana Tagoloan")
        }
      }
    }
  }
}

@Composable
fun StatItem(label: String, count: String) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = count, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
    Text(
        text = label,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
  }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Icon(
        icon,
        contentDescription = null,
        modifier = Modifier.size(20.dp),
        tint = MaterialTheme.colorScheme.primary,
    )
    Spacer(modifier = Modifier.width(12.dp))
    Text(text = text, style = MaterialTheme.typography.bodyMedium)
  }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun ProfilePreview() {
  MyApplicationTheme(darkTheme = false) {
    ProfileScreen()
  }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun ProfileDarkPreview() {
  MyApplicationTheme(darkTheme = true) {
    ProfileScreen()
  }
}
