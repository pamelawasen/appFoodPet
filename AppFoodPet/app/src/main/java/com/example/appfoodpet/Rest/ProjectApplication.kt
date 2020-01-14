package com.example.appfoodpet.Rest

import android.app.Application
import java.lang.IllegalStateException
class ProjectApplication : Application() {
    // chamado quando android iniciar o processo da aplicação
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
    companion object {
        // singleton
        private var appInstance: ProjectApplication?  = null
        fun getInstance(): ProjectApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    // chamado quando android terminar processo da aplicação
    override fun onTerminate() {
        super.onTerminate()
    }
}