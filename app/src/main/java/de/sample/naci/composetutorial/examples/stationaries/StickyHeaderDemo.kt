package de.sample.naci.composetutorial.examples.stationaries

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.sample.naci.composetutorial.examples.Modifiers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderDemo() {
    LazyColumn {
        stickyHeader {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .clip(RoundedCornerShape(2.dp))
                    .height(40.dp)
                    .fillMaxWidth()
            ) {
                Text("This is the sticky header")
            }
        }
        items(50) {
            ListItem()
        }
    }
}

@Composable
fun ListItem() {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(MaterialTheme.colors.secondary)
            .clip(RoundedCornerShape(4.dp))
            .height(100.dp)
            .fillMaxWidth()
    )
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
data class Contact(
    val name: String
){
    val initial: String by lazy{
        name[0].toString()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsList(grouped: Map<String, List<Contact>>) {

    val listState = rememberLazyListState()//remember scroll position
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {
            coroutineScope.launch {
                // Animate scroll to the first item - Smooth scroll...kinda
                listState.animateScrollToItem(index = 0)
            }
        }){
            Text("Up")
        } }
    ) {
        LazyColumn(state = listState) {
            grouped.forEach { (initial, contactsForInitial) ->
                stickyHeader {
                    CharacterHeader(initial = initial)
                }

                items(contactsForInitial){contact ->
                    ContactListItem(name = contact.name)
                }
            }
        }
    }

}

@Composable
fun MultipleStickyHeaders() {
    val contacts = listOf(
        Contact("Ndalu"),
        Contact("Naci"),
        Contact("Begum"),
        Contact("Daniel"),
        Contact("Ozgur"),
        Contact("Busra"),
        Contact("Alp"),
        Contact("Umit"),
        Contact("Aysegul"),
        Contact("Nazli"),
        Contact("Sergei"),
        Contact("Jan"),
        Contact("Jannis"),
        Contact("Janko"),
        Contact("Long"),
        Contact("Fabian"),
        Contact("Florian"),
        Contact("Julius"),
        Contact("Arif")
    )

    val grouped = contacts.sortedBy { it.initial }.groupBy { it.initial }


    ContactsList(grouped = grouped)
}

@Composable
fun CharacterHeader(
    modifier: Modifier = Modifier,
    initial: String
) {
    Box(
        modifier = modifier
            .background(Color.Gray)
            .clip(RoundedCornerShape(2.dp))
            .height(40.dp)
            .fillMaxWidth()
    ) {
        Text(initial)
    }
}

@Composable
fun ContactListItem(
    modifier: Modifier = Modifier,
    name: String
) {
    Box(
        modifier = modifier
            .background(Color.White)
            .clip(RoundedCornerShape(2.dp))
            .border(1.dp, Color.Black)
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Text(name)
    }
}