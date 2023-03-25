# Coroutines-Demo-App
By default, all the components in an Android application use the same thread for execution, which is nothing but our main thread.
As the application was single threaded, this main thread has many duties to perform, like drawing the views, executing logical pieces of code in a sequential manner, for example network request and database management and so on.
So it was our responsibility to make sure that we are not blocking the main thread.
Coroutines are nothing but lightweight threads. They provide us as an easy way to do asynchronous and synchronous programming.
Coroutines allow the execution to be suspended and resumed later at some point in the future.

As only the original thread that created a view hierarchy can touch its views. So, in this app we have used withContext() to switch b/w Dispatchers. 

You can also see the logcat for the demo of using coroutines both sequentially using delay() and parallely using async() & awaits()
