# Emoji Food

## The problem

The current approaches to navigation in Jetpack Compose, whether using lambdas or passing navController, often lead to cluttered and complex code, especially in screens with numerous callbacks. This problem is exacerbated when business logic needs to be executed before navigation, such as calculating arguments for the next screen. In such scenarios, developers find themselves in a convoluted process of calling ViewModels, observing results, and then invoking callbacks, resulting in excessive back-and-forth between Screen and ViewModel components. This not only complicates the codebase but also blurs the lines of responsibility between different parts of the application architecture.

## The solution

The solution is to have a custom navigator, that will be provided to every ViewModel. By calling functions of the navigator, we are navigating to different screens. All navigation events are collected in the MainScreen and in that way we don’t need to pass callbacks or navController to the other screens. 
