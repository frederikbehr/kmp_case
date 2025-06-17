# 📱 POS/mPOS Case

## 🧭 Overview

This project was developed as a case. The goal was to use Kotlin Multiplatform and Jetpack Compose to make a POS solution (Point-Of-Sale). Furthermore, the requirements were to have it work for Android (Tablet only) and Windows.

## Development Process

It took less time than expected to complete the case. I spent extra time on unrequired features, and was interested in learning more about it during the development.

I had fun working on it, and I found myself digging deep into it and watching a lot of Android- and KMP-focused videos online about it to learn new things.

## 🚀 Getting Started

You can use the application on the following platforms:

- Windows
- Android
- Mac

### Installation

Use the executable files with the following extensions to run the application:

- Windows: .exe
- Mac: .dmg
- Android: .apk

### Running the App

The application will run by itself once you open the executable file.

## ✨ Extra features & work

- Currency
- Image from web (implemented separately for Desktop and Android)
- Extra UI Composables ("Components" in KMP) to give a better idea of future layout.
- App icons for all platforms

## 🏗 Architecture

I have used the MVVM architecture, that Android recommends. Furthermore, I have used:

- Data classes and traditional classes
- Enums (eg. for currency)
- Interface
    - for platform specific functionality such as NetworkImage
    - for repositories, that loads data (categories & menu items), so that it is defined how it should work, and a testing version can be used during testing and development.

## Folder structure

The bulk of the code can be found in the CommonMain folder, where it is structured by domain (eg. product, category, cart).

There is a folder "core", where reusable and general code goes (eg. ColorUtils.kt or Currency), since it doesn't belong to a single domain.

## Issues

Along the way, there were obviously issues (as there always are), and the most difficult ones were with the desktop support.

#### Hardest one:

On desktop, mouse-over would crash the application, although it worked fine on Android. I first asked ChatGPT, but it was not able to help. By copying the error message given, I searched on Google and JetBrains' YouTrack forum had the answer. The error was due to a new version of KMP, so there was a little code, that I had to add in the build.gradle.kt file, and then it worked just fine.

ChatGPT was a good help during this process, and it was especially useful for Jetpack Compose. I used it quite a lot, when I had questions about small issues.
