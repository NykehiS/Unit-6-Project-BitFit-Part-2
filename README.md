# Android Project 6 - Bitfit

Submitted by: **Nykehi Sanders**

**Bitfit**, Totally not Fitbit, is a health metrics app that allows users to track their exercise sessions by entering the name of their workout, workout duration, and calories burned. The app saves each workout locally and displays previous entries so users can keep track of their workout history and overall progress.

Time spent: **9** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **Use at least 2 Fragments**
  - Created a Dashboard Fragment and a Workouts Fragment.
- [x] **Create a new dashboard fragment where users can see a summary of their entered data**
  - The dashboard displays total workouts, average workout duration, average calories per workout, and total calories burned.
- [x] **Use one of the Navigation UI Views (BottomNavigation, Drawer Layout, Top Bar) to move between the fragments**
  - Added a bottom navigation bar to switch between the Dashboard and Workouts screens.

## Optional Features

The following **optional** features are implemented:

- [ ] **Add a more advanced UI (e.g., Graphing) for tracking trends in metrics**
- [ ] **Implement daily notifications to prompt users to fill in their data**

## Additional Features

The following **additional** features are implemented:

- [x] Added a workout entry form to record workouts.
- [x] Displayed saved workouts using a RecyclerView.
- [x] Used a Room database to store workout entries locally.
- [x] Designed the app with a pink color theme.
- [x] Added a message for when no workouts have been recorded.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img width="414" height="861" alt="BitFit Part 2" src="https://github.com/user-attachments/assets/c560c279-e291-4853-af99-802710f1d484" />


GIF created with ScreenToGif for Windows.

## Notes

One challenge I encountered while building the app was connecting the bottom navigation bar to the navigation graph and making sure each fragment opened correctly. I also worked on connecting the workout data saved in the database to the dashboard so the statistics could update based on the user's recorded workouts.

## License

    Copyright 2026 Nykehi Sanders

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
