Design Decisions:
-----------------
JSON data download: could have used AsyncTask or Volley or Retrofit or even an IntentService but I chose Retrofit.
IntentService requires way too much boilerplate and handwritten code (...a maintenance headache).
Volley is also too low-level, generally far less performant than Retrofit, and also involves more java code ceremony.
AsyncTask is verbose, ancient, and lifecycle-unfriendly - I would not use it on any new project nowadays.

Image download: used Glide library as it seems to be the standard image-fecthing lib that 
Google recommends for Android projects. I could also have used Picasso (- it has a small footprint) or just Retrofit directly.

Code changes I would make given a few more hrs:
1. move all my MainActivity code/logic into a fragment and create a new empty container activity.
   Place the fragment inside the container activity in order to comply with the Android Jetpack / Navigation
   Components architecture.
2. When more screens needed (e.g. an ItemDetails screen), add them in as fragments to my navigation infrastructure.

3. abstract out the web services accessors into a web service Utils class

4. move all hardcoded Height, Width, Margin and Size view attributes out into a separate dimens.xml file

5. experiment with the Glide image params to see if I can increase the quality/resolution of the resulting image file 

6. As more screens/functionality added, split source code into subfolders for ViewModels, Models, Adapters, Fragments etc,

7. add multilanguage support

8. If personal/sensitive key required to access web API, store key in C++ helper file and read the key into Java classes via JNI

9. Add the android robot logo to title bar