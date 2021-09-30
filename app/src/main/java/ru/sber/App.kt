package ru.sber

import android.app.Application
import ru.sber.component.AppComponent
import ru.sber.component.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()

}