package com.shu.complocaldemo.doc_compose.animation.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.material3Demo.BasicTextFieldChangeIterationSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldChangeReverseIterationSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldCustomInputTransformationSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldInputTransformationByValueChooseSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldInputTransformationByValueReplaceSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldInputTransformationChainingSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldOutputTransformationSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldUndoSample
import com.shu.complocaldemo.material3Demo.BasicTextFieldWithStringSample
import com.shu.complocaldemo.material3Demo.CreditCardSample
import com.shu.complocaldemo.material3Demo.MenuSample
import com.shu.complocaldemo.material3Demo.MenuWithScrollStateSample
import com.shu.complocaldemo.material3Demo.PlaceholderBasicTextFieldSample
import com.shu.complocaldemo.material3Demo.Screen
import com.shu.complocaldemo.material3Demo.SearchScreen
import com.shu.complocaldemo.material3Demo.SearchScreen2
import com.shu.complocaldemo.material3Demo.SearchViewModel
import com.shu.complocaldemo.material3Demo.SearchViewModel2
import com.shu.complocaldemo.material3Demo.TextFieldWithIconSample
import com.shu.complocaldemo.material3Demo.ViewModelScreen
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerPage(goBack: () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // icons to mimic drawer destinations
    val items =
        listOf(
            Icons.AutoMirrored.Filled.ExitToApp,
            Icons.Default.Build,
            Icons.Default.Call,
            Icons.Default.Delete,
            Icons.Default.Email,
            Icons.Default.Favorite,
            Icons.Default.Warning,
            Icons.Default.Home,
            Icons.Default.Info,
            Icons.Default.Favorite,
            Icons.Default.Lock,
            Icons.Default.LocationOn,
            Icons.Default.MailOutline,
            Icons.Default.Notifications,
            Icons.Default.AccountCircle,
            Icons.Default.Phone,
            Icons.Default.Person,
            Icons.Default.Refresh,
            Icons.Default.Menu,
        )

    val itemsText = listOf(
        "Back",
        "BasicTextFieldSample",
        "WithStringSample",
        "Placeholder",
        "TextFieldWithIconSample",
        "CreditCardSample",
        "SearchScreen",
        "TextDerivedState",
        "CustomInputTransformation",
        "OutputTransformation",
        "InputTransformationByValueReplace",
        "InputTransformationByValueChoose",
        "InputTransformationChaining",
        "ChangeIteration",
        "ChangeReverseIteration",
        "SearchScreen2",
        "Undo",
        "MenuSample",
        "MenuWithScrollStateSample",
    )
    val selectedItem = remember { mutableStateOf(items[0]) }

    DismissibleNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DismissibleDrawerSheet(drawerState) {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Spacer(Modifier.height(12.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            icon = { Icon(item, contentDescription = null) },
                            label = { Text(itemsText[index]) }, //item.name.substringAfterLast(".")
                            selected = item == selectedItem.value,
                            onClick = if (index > 0) {
                                {
                                    scope.launch { drawerState.close() }
                                    selectedItem.value = item
                                }
                            } else {
                                goBack
                            },
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                    }
                }
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Dismissible Navigation Drawer Sample") },
                        navigationIcon = {
                            /* IconButton(onClick = goBack) {
                                 Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                             }*/
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(Icons.Default.Menu, null)
                            }
                        }
                    )
                },
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
                    Spacer(Modifier.height(20.dp))
                    Button(onClick = { scope.launch { drawerState.open() } }) { Text("Click to open") }

                    when (selectedItem.value) {
                        items[0] -> {}
                        items[1] -> {
                            BasicTextFieldSample()
                        }

                        items[2] -> {
                            BasicTextFieldWithStringSample()
                        }

                        items[3] -> {
                            PlaceholderBasicTextFieldSample()
                        }

                        items[4] -> {
                            TextFieldWithIconSample()
                        }

                        items[5] -> {
                            CreditCardSample()
                        }

                        items[6] -> {
                            SearchScreen(SearchViewModel())
                        }

                        items[7] -> {
                            Screen(ViewModelScreen())
                        }

                        items[8] -> {
                            BasicTextFieldCustomInputTransformationSample()
                        }

                        items[9] -> {
                            BasicTextFieldOutputTransformationSample()
                        }

                        items[10] -> {
                            BasicTextFieldInputTransformationByValueReplaceSample()
                        }

                        items[11] -> {
                            BasicTextFieldInputTransformationByValueChooseSample()
                        }

                        items[12] -> {
                            BasicTextFieldInputTransformationChainingSample()
                        }

                        items[13] -> {
                            BasicTextFieldChangeIterationSample()
                        }

                        items[14] -> {
                            BasicTextFieldChangeReverseIterationSample()
                        }

                        items[15] -> {
                            SearchScreen2(SearchViewModel2())
                        }

                        items[16] -> {
                            BasicTextFieldUndoSample()
                        }

                        items[17] -> { MenuSample()}
                        items[18] -> { MenuWithScrollStateSample() }
                    }
                }
            }
        })
}

@Composable
private fun DrawerPageContent() {
}


