package com.omiwrench.homes.data.backend

sealed class NetworkEnvironment(val backendUrl: String) {
    data object Debug :
        NetworkEnvironment(backendUrl = "10.0.2.2")
    data object Release :
        NetworkEnvironment(backendUrl = "10.0.2.2")
}