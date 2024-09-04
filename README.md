
```markdown
# Android Simple ABC App - Jetpack Compose

## Overview

This Android project demonstrates a simple app using Kotlin, Jetpack Compose, Kotlin Coroutines, Flow, and MVVM architecture. The app features a swipeable carousel at the top and a list below it. The displayed items in the list are dependent on the currently selected image in the carousel. Additionally, the app includes a search functionality and calculates the top three most frequent characters from the displayed item list.

## Features

- **Swipeable Carousel**: Displays images that users can swipe through.
- **List**: Shows item content based on the selected image in the carousel.
- **Search View**: Filters the items displayed in the list based on user input.
- **Character Frequency Calculation**: Computes and displays the top three most frequent characters from the currently displayed items.

## Architecture

The project follows the MVVM (Model-View-ViewModel) architecture pattern and uses:
- **Kotlin Coroutines**: For asynchronous programming and handling background tasks.
- **Flow**: For reactive data streams and handling UI state updates.
- **Jetpack Compose**: For modern UI development with a declarative approach.

## Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/pshibu008/ABC.git
   cd ABC

2. **Checkout Branch**
     ```bash
     git checkout jetpack_compose
     
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

### Attach Image Screenshot

```markdown
![compose_abc_main_screen](https://github.com/user-attachments/assets/f48a9176-1ef3-4791-bc44-572877381498)

![compose_abc_fab_bottom_sheet_screen](https://github.com/user-attachments/assets/d9f5a536-e6ac-4972-9b93-2c40fdd2445c)

![compose_abc_sticky_search_screen](https://github.com/user-attachments/assets/945a7570-33de-4b3a-95b8-ec88c427c785)

![compose_abc_search_screen](https://github.com/user-attachments/assets/70395c77-9a68-4391-817b-0da2e24a79d5)




