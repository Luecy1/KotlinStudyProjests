package com.example.kotlinstudyprojects

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.kotlinstudyprojects.main.BlankViewModel
import com.example.kotlinstudyprojects.room.AppDatabase

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val database: AppDatabase,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(BlankViewModel::class.java) -> BlankViewModel(
                database.userDao()
            )
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}