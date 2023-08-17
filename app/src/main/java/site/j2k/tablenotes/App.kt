package site.j2k.tablenotes

import android.app.Application
import site.j2k.tablenotes.database.AppDatabase

class App : Application() {
    val database by lazy {
        AppDatabase.createDatabase(this)
    }
}
