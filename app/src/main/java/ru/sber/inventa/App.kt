package ru.sber.inventa

import android.app.Application
import ru.sber.inventa.component.AppComponent
import ru.sber.inventa.component.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent = DaggerAppComponent.create()

}