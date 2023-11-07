# 1base by quangdt4

## Install
- Update Android Studio to the newest version [Android studio here](https://developer.android.com/studio)
- Config code style (Use default Kotlin coding convention, and select use single import)

## Conventions
- We use ktlint for code style checking
- [Kotlin style here](https://developer.android.com/kotlin/style-guide)

## Workflows
### Main branches (up to now)
- `develop`: main development branch

### Working with GIT
- New feature: branch out from develop/ base feature branch and name it `feature/...`
- Bug: branch out from develop/ base feature branch and name it `bugfix/...`
- When making PR, please select to ***squash commits*** and ***delete source branch*** when merge to keep our branch list clean

## Libraries
- Architecture Components (LiveData, ViewModel...)
- RxJava
- Room
- Dagger
- ....

## Unit tests
- We use Junit4, Mockito, MockK...