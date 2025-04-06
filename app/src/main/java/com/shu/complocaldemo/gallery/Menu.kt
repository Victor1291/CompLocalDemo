package com.shu.complocaldemo.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shu.complocaldemo.R
import com.shu.complocaldemo.ui.theme.CompLocalDemoTheme


/**
 * A composable function that displays a row of menu items followed by a more button.
 *
 * @param items The list of menu items to display.
 * @param onItemClicked Callback invoked when a menu item is clicked.
 * @param moreIcon The icon to use for the "more" button when the menu is collapsed.
 * @param collapsed The number of items in collapsed state in this state only icon is displayed.
 */
@Composable
inline fun RowScope.Menu(
    items: List<Action>,
    noinline onItemClicked: (item: Action) -> Unit,
    moreIcon: ImageVector = Icons.Outlined.MoreVert,
    collapsed: Int = 4
) {
    val size = items.size
    // Early return if this has no items
    if (size == 0)
        return
    // Display the first 'collapsed' number of items as IconButtons
    repeat(minOf(size, collapsed)) { index ->
        val item = items[index]
        IconButton(
            onClick = { onItemClicked(item) },
            //  contentDescription = stringResource(item.label),
            enabled = item.enabled
        ) {
            // Icon is required for collapsed items
            item.icon?.let { Icon(imageVector = it, contentDescription = "") }
            /*requireNotNull(item.icon) {

                "Collapsed Icon must not be null"
            }*/
        }
    }

    // If all items are already displayed, return
    if (size < collapsed)
        return

    // State to control the expanded state of the dropdown menu
    val (expanded, onDismissRequest) = remember { mutableStateOf(false) }

    // IconToggleButton to show/hide the dropdown menu
    IconToggleButton(expanded, onDismissRequest) {
        Icon(moreIcon, contentDescription = "more") // Icon for the "more" button

        // DropdownMenu to display the remaining items
        DropdownMenu(
            expanded,
            onDismissRequest = { onDismissRequest(false) },
            modifier = Modifier.widthIn(min = 180.dp)
        ) {
            repeat(size - collapsed) { index ->
                val item = items[index + collapsed]
                DropdownMenuItem(
                    text = {
                        Text(stringResource(item.label))
                    },
                    leadingIcon = {
                        item.icon?.let { Icon(imageVector = it, contentDescription = "") }
                    },
                    onClick = { onItemClicked(item); onDismissRequest(false) },
                    // leadingIcon = { item.icon?.let { rememberVectorPainter(it) } }, // Icon is optional for dropdown items
                )
            }
        }
    }
}

private val ORDER_BY_DATE_MODIFIED = Action(R.string.last_modified, Icons.Outlined.DateRange)
private val ORDER_BY_NAME = Action(R.string.grant, Icons.Outlined.Favorite)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CompLocalDemoTheme {
        val actions: List<Action> by remember {
            derivedStateOf {
                buildList {
                    this += if (false) UN_STAR else STAR
                    this += SHARE
                    this += DELETE
                    // if this is video currently return otherwise editing can be called for video also
                    // if (current?.isImage == false) return@buildList
                    this += USE_AS
                    this += EDIT_IN
                    this += ORDER_BY_DATE_MODIFIED
                    this += ORDER_BY_NAME
                }
            }
        }
        Column(
            Modifier.fillMaxSize()
        ) {
            FloatingActionMenu {
                Menu(
                    items = actions,
                    onItemClicked = {

                    }
                )
            }
        }
    }
}

private val DELETE = Action(R.string.delete, Icons.Outlined.Delete)
private val SHARE = Action(R.string.share, Icons.Outlined.Share)
private val USE_AS = Action(R.string.set_as_wallpaper, Icons.Outlined.Warning)
private val EDIT_IN = Action(R.string.edit_in, Icons.Outlined.Edit)
private val STAR = Action(R.string.like, Icons.Filled.Star)
private val UN_STAR = Action(R.string.unlike, Icons.Outlined.Star)