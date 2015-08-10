
*--------------Course Details--------------*

## Instructor: 

Paul Trebilcox-Ruiz

## Difficulty: 

Intermediate

## Source Files Location: 

https://github.com/tutsplus/DevelopingForAndroidWear

## Topic: 

Android Development, Android Wear

## Categories: 

Code

## Software/Languages/Frameworks: 

Android SDK 21 or later, Java JDK 1.8, Android Studio 1.1 or later

## Course Rate: 

*--------------Course Outline--------------*

# Course Name: 

Developing for Android Wear

# Course Description: 

In this course you will learn about various UI components specifically designed for Android Wear, and how to extend your application to use the new Wear notification types. After you have learned about the various components can improve your applications, you will learn how to create a basic digital watch face to help customize your users' experiences.

# Source Files Description:

Each folder in the source represents the end result of a lesson in this course, and each lesson builds off of the last.

*--------------Course--------------*

# 1 Introduction and Getting Setup

## 1.1 Introduction ( Lesson 1 )

In this lesson you will see examples of what you will create in this course and the various components that you can implement in your Wear apps.

## 1.2 Setting Up Emulators and Hello World ( Lesson 2 )

This lesson will go over setting up a square and round Android Wear emulator, and the structure of Wear apps.

## 1.3 Debugging on a Hardware Device ( Lesson 3 )

While it is possible to debug most Wear features using the Android emulators, this lesson will go over how to debug your applications on a physical Wear device.

**Related Links**
- [Debugging Over Bluetooth] (https://developer.android.com/training/wearables/apps/bt-debugging.html)

# 2 Wearable App UI Components

## 2.1 Round and Square Device Support ( Lesson 4 )

This lesson will teach you how to support both round and square wearable form factors so that the edges of your UI are not lost on rounded devices.

**Related Links**
- [WatchViewStub] (http://developer.android.com/reference/android/support/wearable/view/WatchViewStub.html)
- [BoxInsetLayout] (http://developer.android.com/reference/android/support/wearable/view/BoxInsetLayout.html)

## 2.2 WearableListViews ( Lesson 5 )

ListViews are undoubtedly one of the most used components in Android development. This lesson will introduce you to the WearableListView, which is an extension of the RecyclerView with some additional behaviors that make it more suitable for use on Wear devices.

**Related Links**
- [WearableListView] (http://developer.android.com/reference/android/support/wearable/view/WearableListView.html)
- [WearableListView.Adapter] (http://developer.android.com/reference/android/support/wearable/view/WearableListView.Adapter.html)
- [WearableListView.ViewHolder] (http://developer.android.com/reference/android/support/wearable/view/WearableListView.ViewHolder.html)


## 2.3 DelayedConfirmationView ( Lesson 6 )

In this lesson you will learn about the DelayedConfirmationView, which allows your users to cancel an action before it is executed in the case of a mistake.

- [DelayedConfirmationView] (http://developer.android.com/reference/android/support/wearable/view/DelayedConfirmationView.html)


## 2.4 GridViewPager pt 1 ( Lesson 7 )

This is part one of a two part topic. You will learn about the GridViewPager, a component that mimics the notification stream on a wearable device. This lesson will also introduce the DotsPagerIndicator to help signify multiple pages in a grid row, plus the FragmentGridPagerAdapter and the CardFragment for displaying content inside of a component styled like a notification card.

- [GridViewPager] (http://developer.android.com/reference/android/support/wearable/view/GridViewPager.html)
- [DotsPagerIndicator] (http://developer.android.com/reference/android/support/wearable/view/DotsPageIndicator.html)
- [FragmentGridPagerAdapter] (http://developer.android.com/reference/android/support/wearable/view/FragmentGridPagerAdapter.html)
- [CardFragment] (http://developer.android.com/reference/android/support/wearable/view/CardFragment.html)

## 2.5 GridViewPager pt 2 ( Lesson 8 )

This lesson will continue where the last left off, covering how to add backgrounds to rows and columns in a GridViewPager, and adding a custom fragment in lieu of a CardFragment.

## 2.6 WearableActivity and Ambient Mode ( Lesson 9 )

Added before Google I/O in 2015, Ambient mode activities prevent an application from kicking a user to the notification home screen when keeping the application running would be more appropriate. This lesson will cover how to use ambient mode for your WearableListView activity.

- [WearableActivity] (http://developer.android.com/reference/android/support/wearable/activity/WearableActivity.html)
- [Creating Custom Layouts] (https://developer.android.com/training/wearables/apps/layouts.html)

# 3: Wearable Notifications

- [Notifications] (http://developer.android.com/guide/topics/ui/notifiers/notifications.html)
- [Enhanced and Wearable-Ready Notifications on Android] (http://code.tutsplus.com/tutorials/enhanced-and-wearable-ready-notifications-on-android--cms-21868)

## 3.1 Using Basic and Multipage Notifications ( Lesson 10 )

This video will give you a base understanding of notifications and how to add multiple pages to a single notification in order to display additional content.

## 3.2 Stacking Multiple Notifications and Using an Action Button ( Lesson 11 )

In this lesson you will learn how to group multiple notifications together in order to prevent spamming your user. You will also learn about the ConfirmationActivity and how to add an action button to a wearable notification.

## 3.3 Repying with Speech, Emojis and Predefined Options ( Lesson 12 )

Since wearable devices limit users to only being able to use one hand for interaction, speech is an important avenue for input. This lesson will go over adding voice replies to notifications, as well as how to provide predefined options and emoji responses.

## 3.4 Creating Custom UI Notifications ( Lesson 13 )

When the standard notification card types do not fit what you would want from your application, you can create activities that will take the place of notifications. This lesson will teach you how to build those notifications, giving you the ability to create a completely customized experience for your user.

# 4 Creating a Watch Face


## 4.1 Starting a Digital Watch Face ( Lesson 14 )

Watch faces are the easiest way for users to customize their Android Wear experience. This lesson will introduce you to developing watch faces and help you get one set up on a device.

- [Creating an Android Wear Watch Face] (http://code.tutsplus.com/tutorials/creating-an-android-wear-watch-face--cms-23718)

## 4.2 Handling States for Watch Faces ( Lesson 15 )

This lesson will cover the different states that a watch face must account for, and teach you how to efficiently navigate the lifecycle of an Android Wear watch face.

# 5 Conclusion

## 5.1 Conclusion ( Lesson 16 )

This lesson will review what you have learned, and share some resources for continuing development for Android Wear.

- [TutsPlus Android Tutorials] (https://code.tutsplus.com/categories/android-sdk)
- [Sending and Syncing Data] (http://developer.android.com/training/wearables/data-layer/index.html)
