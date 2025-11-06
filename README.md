Submitted by: Oluwamayowa Obimakinde

BitFit Part 2 is a health metrics app that allows users to track daily water intake and view a summary dashboard showing their total and average intake in liters.
This version expands on BitFit Part 1 by introducing multiple Fragments, Navigation UI, and persistent storage using a Room Database.

Time spent: 8 hours spent in total

Required Features

The following required functionality is completed:

 Use at least 2 Fragments (Home & Dashboard)

 Create a new dashboard fragment where users can see a summary of their entered data

 Use a Bottom Navigation View to move between fragments

The following optional features are implemented:

 Display total and average water intake converted to liters (L)

 Add a more advanced UI (e.g., graphs) for tracking trends

 Implement daily notifications to prompt users to fill in their data

The following additional features are implemented:

 Data persistence using Room Database

 RecyclerView displaying all logged water entries

 Live updates to the dashboard when new entries are added

 ViewBinding for clean and type-safe view access

Video Walkthrough

Here's a walkthrough of implemented user stories:

![Untitled video - Made with Clipchamp (3)](https://github.com/user-attachments/assets/af84e287-5280-46a8-98d3-836381ce56c2)


Notes

During development, I learned:

How to navigate between multiple Fragments using the Navigation Component.

How to persist data locally with Room Database.

How to use ViewBinding for more efficient UI interaction.

How to compute aggregated data (total + average) dynamically in Kotlin.

Challenges included Gradle version mismatches (KSP ↔ Kotlin), AndroidX migration, and cleaning up Windows file-lock issues during builds.

License
Copyright 2025 Oluwamayowa Obimakinde

Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.
