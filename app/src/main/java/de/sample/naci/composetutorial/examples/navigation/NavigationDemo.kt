package de.sample.naci.composetutorial.examples.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import de.sample.naci.composetutorial.examples.navigation.model.screenGroups
import de.sample.naci.composetutorial.navigation.Screen1
import de.sample.naci.composetutorial.navigation.Screen2
import de.sample.naci.composetutorial.navigation.Screen3
import de.sample.naci.composetutorial.navigation.Screen4

@Composable
fun NavigationDemo() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                screenGroups.forEach { group ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(text = stringResource(id = group.resourceId))},
                        selected = currentDestination?.hierarchy?.any { it.route == group.route } == true,
                        onClick = {
                            navController.navigate(group.route){
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        })

                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "group1") {
            navigation(startDestination = "1", route = "group1") {
                composable("1") {
                    Screen1(navController = navController)
                }
                composable("2/{text}") { navBackStackEntry ->
                    Screen2(
                        navController = navController,
                        text = navBackStackEntry.arguments?.getString("text").orEmpty()
                    )
                }
            }

            navigation(startDestination = "3", route = "group2") {
                composable("3") {
                    Screen3(navController = navController)
                }
                composable("4") {
                    Screen4(
                        navController = navController
                    )
                }
            }
        }
    }


}