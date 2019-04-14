/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.dnd

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val floatingActionButton = findViewById<View>(R.id.floating_action_button) as FloatingActionButton
        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout?.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        val navigationView = findViewById<View>(R.id.navigation_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawerLayout != null) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(menuItem)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        when (menuItem.itemId) {
            R.id.nav_camera -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_camera))
                return true
            }
            R.id.nav_gallery -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_gallery))
                return true
            }
            R.id.nav_slideshow -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_slideshow))
                return true
            }
            R.id.nav_manage -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_tools))
                return true
            }
            R.id.nav_share -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_share))
                return true
            }
            R.id.nav_send -> {
                drawerLayout.closeDrawer(GravityCompat.START)
                displayToast(getString(R.string.chose_send))
                return true
            }
            else -> return false
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}
