# 1base by quangdt4

## Install
- Update Android Studio to the newest version [Android studio here](https://developer.android.com/studio)
- Config code style (Use default Kotlin coding convention, and select use single import)

## Conventions
- We use ktlint for code style checking
- [Kotlin style here](https://developer.android.com/kotlin/style-guide)

## Workflows
### Main branches (up to now)
- `master`: this branch contains production code. All development code is merged into master in sometime.
- `develop`: this branch contains pre-production code, main development branch. When the features are finished then they are merged into develop.

### Working with GIT
- Workflows for Git: [Gitflow](https://nvie.com/posts/a-successful-git-branching-model/)
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