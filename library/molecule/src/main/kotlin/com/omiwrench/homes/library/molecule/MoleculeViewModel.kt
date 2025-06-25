package com.omiwrench.homes.library.molecule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.SaveableStateRegistry
import androidx.compose.ui.platform.AndroidUiDispatcher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.molecule.RecompositionMode
import app.cash.molecule.launchMolecule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

abstract class MoleculeViewModel<Model>: ViewModel() {
    protected val moleculeScope =
        CoroutineScope(viewModelScope.coroutineContext + AndroidUiDispatcher.Main)
    open val savedStateRegistryKey =
        "${SaveableStateRegistry::class.java.simpleName}:${this.javaClass.simpleName ?: "MoleculeViewModel"}"
    val uiState: StateFlow<Model> by lazy(LazyThreadSafetyMode.NONE) {
        moleculeScope.launchMolecule(
            mode = RecompositionMode.ContextClock
        ) {
            uiState()
        }
    }

    @Composable
    protected abstract fun uiState(): Model
}