package com.example.myapplication

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

private object ProfileDimensions {
    val AvatarSize = 120.dp
    val AvatarBorderWidth = 2.dp
    val HorizontalPadding = 24.dp
    val CardInternalPadding = 16.dp
    val IconSpacerWidth = 16.dp
    val InfoRowVerticalPadding = 8.dp
    val SmallSpacer = 8.dp
    val MediumSpacer = 16.dp
    val LargeSpacer = 24.dp
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    name: String = "Sean Ra",
    initials: String = "SR",
    course: String = "BSIT",
    section: String = "3-A",
    mobile: String = "+63 912 345 6789",
    email: String = "student@liceo.edu.ph"
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = ProfileDimensions.LargeSpacer),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(ProfileDimensions.AvatarSize)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .border(
                        width = ProfileDimensions.AvatarBorderWidth,
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = initials,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Spacer(modifier = Modifier.height(ProfileDimensions.MediumSpacer))

            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(ProfileDimensions.SmallSpacer))

            Text(
                text = "$course $section",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(ProfileDimensions.LargeSpacer))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = ProfileDimensions.HorizontalPadding),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(ProfileDimensions.CardInternalPadding)
                ) {
                    InfoRow(
                        icon = Icons.Default.Person,
                        label = "Name",
                        value = name
                    )
                    InfoRow(
                        icon = Icons.Default.School,
                        label = "Course",
                        value = course
                    )
                    InfoRow(
                        icon = Icons.Default.Badge,
                        label = "Section",
                        value = section
                    )
                    InfoRow(
                        icon = Icons.Default.Phone,
                        label = "Mobile Number",
                        value = mobile
                    )
                    InfoRow(
                        icon = Icons.Default.Email,
                        label = "Email Address",
                        value = email
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val rowModifier = modifier
        .fillMaxWidth()
        .then(
            if (onClick != null) Modifier.clickable(onClick = onClick)
            else Modifier
        )
        .padding(vertical = ProfileDimensions.InfoRowVerticalPadding)

    Row(
        modifier = rowModifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(ProfileDimensions.IconSpacerWidth))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(name = "Profile — Light", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ProfileScreenLightPreview() {
    MyApplicationTheme(darkTheme = false) {
        ProfileScreen()
    }
}

@Preview(name = "Profile — Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenDarkPreview() {
    MyApplicationTheme(darkTheme = true) {
        ProfileScreen()
    }
}

@Preview(name = "Profile — Accessibility (1.5x Font)", fontScale = 1.5f, showBackground = true)
@Composable
fun ProfileScreenAccessibilityPreview() {
    MyApplicationTheme {
        ProfileScreen()
    }
}
