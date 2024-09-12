# Android Simple ABC App - XML Layout

## Overview

This Android project demonstrates a simple app using Kotlin, XML layouts, Kotlin Coroutines, Flow, and MVVM architecture. The app features a swipeable ViewPager carousel at the top and a RecyclerView below it. The displayed items in the RecyclerView are dependent on the currently selected image in the ViewPager carousel. Additionally, the app includes a search functionality and calculates the top three most frequent characters from the displayed item list.

## Features

- **Swipeable ViewPager Carousel**: Displays images that users can swipe through.
- **RecyclerView**: Shows item content based on the selected image in the ViewPager.
- **Search View**: Filters the items displayed in the RecyclerView based on user input.
- **Character Frequency Calculation**: Computes and displays the top three most frequent characters from the currently displayed items.

## Architecture

The project follows the MVVM (Model-View-ViewModel) architecture pattern and uses:
- **Kotlin Coroutines**: For asynchronous programming and handling background tasks.
- **Flow**: For reactive data streams and handling UI state updates.
- **XML Layouts**: For defining the UI using traditional Android layout files.

## Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/pshibu008/ABC.git
   cd ABC

2. **Checkout Branch**
     ```bash
     git checkout main
     
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

### Attach App Screenshot
![xml_abc_main_screen](https://github.com/user-attachments/assets/a12b118c-7f97-4413-9c60-5b495068679b)

![xml_abc_sticky_search_screen](https://github.com/user-attachments/assets/1364b3bc-91e8-4120-b894-8850495612df)

![xml_abc_search_screen](https://github.com/user-attachments/assets/0bd1585b-2b89-4aa9-b9aa-1c5501740a1e)

![xml_abc_bottom_sheet_screen](https://github.com/user-attachments/assets/4574e056-1ecf-4ec9-9bbb-de3774cd926d)


