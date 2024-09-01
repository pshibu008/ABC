# Android Simple ABC App

## Overview

This Android project demonstrates a simple app using Kotlin, Jetpack Compose, XML layout, Kotlin Coroutines, Flow, and MVVM architecture. The app features a swipeable ViewPager carousel at the top and a RecyclerView below it. The displayed items in the RecyclerView are dependent on the currently selected image in the ViewPager carousel. Additionally, the app includes a search functionality and calculates the top three most frequent characters from the displayed item list.

## Features

- Swipeable ViewPager Carousel: Displays images that users can swipe through.
- RecyclerView: Shows item content based on the selected image in the ViewPager.
- Search View: Filters the items displayed in the RecyclerView based on user input.
- Character Frequency Calculation: Computes and displays the top three most frequent characters from the currently displayed items.

## Architecture

The project follows the MVVM (Model-View-ViewModel) architecture pattern and uses:

- Kotlin Coroutines: For asynchronous programming and handling background tasks.
- Flow: For reactive data streams and handling UI state updates.
- Jetpack Compose: For modern UI development with a declarative approach.
- XML Layouts: For defining the UI using traditional Android layout files.

## Branches

- `master`: Contains the XML layout implementation.
- `jetpack-compose`: Contains the Jetpack Compose UI implementation.

## Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/pshibu008/ABC.git
   cd ABC

2. **Checkout Branch**
   Switch to the desired branch based on the UI implementation you want to work with:
   - For XML layouts:
     ```bash
     git checkout master
   - For Jetpack Compose:
     ```bash
     git checkout jetpack-compose
     
3. **Open the Project**
   Open the project in Android Studio.

4. **Sync Project**
    Ensure that all dependencies are synchronized. Go to File -> Sync Project with Gradle Files.

5. **Build the Project**
    Build the project to make sure all configurations are correct.

6. **Usage**
  - Swipe the ViewPager: Swipe left or right to navigate through images in the ViewPager carousel.
  - ViewPager and RecyclerView Interaction: The RecyclerView displays items related to the currently selected image in the ViewPager.
  - Search Functionality: Use the search view to filter items in the RecyclerView.
  - Character Frequency: The app calculates and displays the top three most frequent characters from the currently visible items in the RecyclerView.
    
7. **Development**
  - Kotlin Coroutines: Used for handling asynchronous tasks.
  - Flow: Provides a reactive stream of data.
  - MVVM Architecture: Separates concerns by defining models, view models, and views.
  - Jetpack Compose: Modern UI toolkit for building native UIs in a declarative manner.
  - XML Layouts: Traditional layout files used alongside Jetpack Compose for certain UI elements.
    
8. **Libraries Used**
  - Jetpack Compose
  - Kotlin Coroutines
  - Flow
  - RecyclerView
  - ViewPager2
