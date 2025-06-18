# 🖥️ POS/mPOS Case

## 🧭 Overview

This project was developed as a case. The goal was to use Kotlin Multiplatform and Jetpack Compose to make a POS solution (Point-Of-Sale). Furthermore, the requirements were to have it work for Android (Tablet only) and Windows.

Along the way, I wanted to use this case to learn more. Therefore, I dug into new features, and I was trying to put my self in a customer's shoes.
For example, I guess the colors are there to make it easier for users to tell products apart at a quick glance, and therefore I thought images might be a great idea as well.
They are unique and can make a product quick to spot, when a customer mentions it, but they should not be required. It is then important, that it looks great with and without images, and doing this was not as hard as I thought.

## 🧑‍💻 Development Process

It took less time than expected to complete the case. I spent extra time on extra features, and was interested in learning more about it during the development.

I had fun working on it, and I found myself digging deep into it and watching a lot of Android- and KMP-focused videos online about it to learn new things.

## 🚀 Getting Started

The application is made for the following platforms:

- Windows
- Android

You will need the executable files to follow the installation guide.

### Installation

Use the executable files with the following extensions to run the application:

#### Windows: .exe

On Windows, I could make a .exe/.msi installer, but the file would not run. I got an error: "Failed to launch JVM". I am not sure why this happened, but it could be linked to being on another person's PC. Normally, I develop on a mac, so when I needed the .exe-file, I had to borrow my girlfriend's Windows PC, where it could run during development, but not as being packaged as a .exe.

#### Android: .apk

Drag and drop the .apk file onto an emulator

or

```
adb install -r path/to/mPOS.apk
```

The last method requires the adb CLI to connect to emulators.


## ✨ Extra features & work

- Currency
- Image from web (implemented separately for Desktop and Android)
- Extra UI Composables ("Components" in KMP) to give a better idea of future layout.
- App icons for all platforms

## 🏗 Architecture

I have used the MVVM architecture, that Android recommends. Furthermore, I have used:

- Data classes and traditional classes
- Enums (eg. for currency)
- Object
- State
- Expect / Actual
- Interface
    - for platform specific functionality such as NetworkImage
    - for repositories, that loads data (categories & menu items), so that it is defined how it should work, and a testing version can be used during testing and development.

## Folder structure

The bulk of the code can be found in the commonMain folder, where it is structured by domain (eg. product, category, cart). However, there are platform specific code in androidMain and desktopMain.

There is a folder "core", where reusable and general code goes (eg. ColorUtils.kt or Currency), since it doesn't belong to a single domain.

## Issues

Along the way, there were obviously issues (as there always are), and the most difficult ones were with the desktop support.

In the end, I could run it during development, but it would not work when packaged into .exe or .dmg

#### Hardest one:

On desktop, mouse-over would crash the application, although it worked fine on Android. I first asked ChatGPT, but it was not able to help. By copying the error message given, I searched on Google and JetBrains' YouTrack forum had the answer. The error was due to a new version of KMP, so there was a little code, that I had to add in the build.gradle.kt file, and then it worked just fine.

ChatGPT was a good help during this process, and it was especially useful for Jetpack Compose. I used it quite a lot, when I had questions about small issues.
