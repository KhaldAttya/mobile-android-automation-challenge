### Why Native Test ? Pros and cons.
Native testing has become a really reliable testing frameworks, with it being a grey box testing we could have access to code level features, that help easy and a solution to automate complex scenarios for example the recycler view in android which is very hard to automate using other tools like appium.

Also having the capability to pass launch arguments to sharedprefs in android or userdefaults in ios  could save alot of time trying to simulate certain actions. 

Also the problem of IDs is solved due to having access to the same IDs that dev use could save time.

The issue of black box mobile testing using for example appium is synchronization of the test code and  app  workflow, that being automatically handled by native test is huge time saver, and with features like Idling resource its really reliable.

Also the speed of native tests is really remarkable. The implementation of  CI pipline is much easier in native tests.

I believe the only drawback of the complexity of it, but with much support and investment by Apple and Google it's becoming more easier

## The most hard part

It was setting up the screenshot on failure test rule. I managed to implement it partially on single activity, didn't have the time to implement it to get the current activity when test goes from activity to another.

## Good coding practice

I implemented the page object pattern and in this context I like to call activity object or more generally screen object. I isolated the test data in Enum class to be easy to target and change. 

## Maintenance 

I made sure to reduce redundant code as much as I can, to make it easy to change at one point and reflect, I also made sure to seperate methods in screen objects to make it modular.

## TODOs: 
* To complete the Screenshot on failure test rule.
* To implement Idling resource
* Fix the exercise filtration issue ( Detected by searchWithRandomExerciseKeywordsTest()) the actual filtration logic depends upon keywords order ('10 min Abs' and 'Abs 10 min' ) are of different results
* Implement Tests for offline scenarios.
* Add different Toast Messages to handle cases like: no email entered, no valid email entered and no password entered