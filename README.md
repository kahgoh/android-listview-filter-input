Filtering List View
===================
Demo for filtering a [ListView](http://developer.android.com/reference/android/widget/ListView.html). The activities for the demo are:

* __EditTextFilter__ - Uses an [EditText](http://developer.android.com/reference/android/widget/EditText.html) for entering the filter.
* __VirtualKeyboardFilter__ - Uses the built in filtering mechanism for [ListView](http://developer.android.com/reference/android/widget/ListView.html). It will also attempt to pop up the virtual keyboard.

__If the virtual keyboard does not show when running the emulator ...__
Switch off _Keyboard Support_ in the AVD manager. From the AVD manager:
# Select the AVD and click on _Edit_.
# In the _Hardware_ panel, see if the _Keyboard Support_ is listed. If not, select _New_ to add the property.
# Ensure that _Keyboard Support_ is set to _no_.  