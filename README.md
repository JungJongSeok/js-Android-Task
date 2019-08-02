# JS-Android-Utils
![ReadMe](https://img.shields.io/github/license/JungJongSeok/js-android-task)

##Change strong references to weak references

# Function
### AsyncTask to NonLeakAsyncTask
```
        new AsyncTask<Params, Progress, Result>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                doSomeThing();
            }

            @Override
            protected void onPostExecute(Result result) {
                super.onPostExecute(result);
                doSomeThing();
            }

            @Override
            protected Result doInBackground(Params... params) {
                doSomeThing();
                return null;
            }
        }; <- Memory leak

-> For device performance

        new NonLeakAsyncTask(context, new NonLeakAsyncTaskCallback() {
            @Override
            public void onPreExecute() {
                super.onPreExecute();
                doSomeThing();
            }

            @Override
            public void onPostExecute(Object o) {
                super.onPostExecute(o);
                doSomeThing();
            }
            
            @Override
            public Object doInBackground(Object[] objects) {
                doSomeThing();
                return null;
            }
        });
```
### Handler to NonLeakHandler
```
        new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        }; <- Memory leck

-> For device performance

        new NonLeakHandler(context, new NonLeakHandlerCallback() {
            @Override
            public void handleMessage(Message message) {
                doSomeThing();
            }
        });

```

# How to use ?
### Add Project build/gradle
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
### Add defendency
```
dependencies {
    implementation 'com.github.JungJongSeok:js-android-task:1.0.4'
}
```
