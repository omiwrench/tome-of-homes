# The Tome of Homes


## Tech stack

| Layer      | Tech/Library                                        |
|------------|-----------------------------------------------------|
| Build      | Kotlin DSL + precompiled plugins + version catalogs |
| DI         | Hilt/Dagger                                         |
| UI         | Jetpack Compose + Material3                         |
| Networking | OkHttp + Retrofit                                   |
| View-Data  | ViewModel + Molecule                                | 


## Build structure

| Module type  | Description                                                                            |
|--------------|----------------------------------------------------------------------------------------|
| Feature      | A part of the app that has screens                                                     |
| Library      | Shared code used by multiple modules                                                   |
| Data         | Data-fetching modules, API, database, datastore, etc                                   |
| Repository   | Data-coordinating modules, gets data from data modules, converts it to suitable format |


## Module structure

| Module                  | Description                                |
|-------------------------|--------------------------------------------|
| :app                    | The main "bones" of the entire app.        |
| :library:ui             | UI components + styling                    |
| :feature:listing        | The main list of listings                  |
| :feature:listing:detail | The detail screen of a listing             |
| :data:api               | Backend API network code                   |
| :repository:listing     | Fetches and handles listings from backend  |


## Mocking

```
    chmod +x mock.sh
    ./mock.sh
```

But check what it does first, never run unknown commands ;)