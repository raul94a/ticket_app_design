package com.raa.dribbble_expiriment_one.ui.home.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import com.raa.dribbble_expiriment_one.darkPurple
import com.raa.dribbble_expiriment_one.lightGrey
import com.raa.dribbble_expiriment_one.lightPurple
import com.raa.dribbble_expiriment_one.orange


@Composable
fun BottomNavigationBar(onClick: (Int) -> Unit, selectedIndex: Int) {
    NavigationBar(

        containerColor = darkPurple
    ) {
        NavigationBarItem(
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = lightPurple,
                selectedIconColor = orange,
                unselectedIconColor = lightGrey
            ),
            selected = selectedIndex == 0, onClick = { onClick(0) }, icon = {
                Icon(imageVector = Icons.Outlined.Home, contentDescription = null)
            })
        NavigationBarItem(
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = lightPurple,
                selectedIconColor = orange,
                unselectedIconColor = lightGrey
            ),
            selected = selectedIndex == 1, onClick = { onClick(1) }, icon = {
                Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
            })
        NavigationBarItem(
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = lightPurple,
                selectedIconColor = orange,
                unselectedIconColor = lightGrey
            ),
            selected = selectedIndex == 2, onClick = { onClick(2) }, icon = {
                Icon(imageVector = Icons.Outlined.Settings, contentDescription = null)
            })

    }

}