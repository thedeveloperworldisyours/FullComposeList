package  com.a.jetpackcomposelists.sectionstick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.a.jetpackcomposelists.ui.theme.JetpackComposeListsTheme
import com.example.listswithcompose.sectionstick.SectionStickViewModel

class SectionStickActivity : ComponentActivity() {

    private val viewModel by viewModels<SectionStickViewModel>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeListsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SectionStickScreen(groupByInitials = viewModel.getMap(this))
                }
            }
        }
    }
}

