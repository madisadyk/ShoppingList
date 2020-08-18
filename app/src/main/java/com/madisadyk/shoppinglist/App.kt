package com.madisadyk.shoppinglist

import android.app.Application
import com.madisadyk.shoppinglist.data.db.ShoppingDatabase
import com.madisadyk.shoppinglist.data.repositories.ShoppingRepository
import com.madisadyk.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@App))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider { ShoppingViewModelFactory(instance()) }
    }
}