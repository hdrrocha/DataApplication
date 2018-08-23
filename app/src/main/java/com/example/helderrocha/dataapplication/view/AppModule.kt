package com.example.helderrocha.dataapplication.view

import android.content.Context
import com.example.helderrocha.dataapplication.view.api.NetworkModule
import com.example.helderrocha.dataapplication.view.view.ListDataActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module(includes = [
    NetworkModule::class,
    SchedulerModule::class
])
class AppModule

@Module
abstract class AndroidInjectorsModule {
    @ContributesAndroidInjector
    abstract fun listDataActivity(): ListDataActivity

}

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        AndroidInjectorsModule::class
))
interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApp>() {
        @BindsInstance
        abstract fun appContext(appContext: Context): Builder
    }
}