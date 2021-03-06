//package la321.katy.com.fatcat;
//
//import android.app.Application;
//import android.content.SharedPreferences;
//
//public class App extends Application {
//
//    public static App instance;
//    private SharedPreferences sharedPreferences;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        instance = this;
//        sharedPreferences = getSharedPreferences(Constants.SETTINGS, MODE_PRIVATE);
//    }
//
//    public static App getInstance() {
//        return instance;
//    }
//
//    public void setAboutActivityShown(boolean status) {
//        SharedPreferences.Editor edit = sharedPreferences.edit();
//        edit.putBoolean(Constants.IS_ABOUT_ACTIVITY_SHOWN, true);
//        edit.commit();
//    }
//
//    public boolean getIsAboutActivityShown() {
//        return sharedPreferences.contains(Constants.IS_ABOUT_ACTIVITY_SHOWN);
//    }
//
//    public void setPropertiesActivityShown(boolean status) {
//        SharedPreferences.Editor edit = sharedPreferences.edit();
//        edit.putBoolean(Constants.IS_ABOUT_ACTIVITY_SHOWN, true);
//        edit.commit();
//    }
//
//    public boolean getIsProrertiesActivityShown() {
//        return sharedPreferences.contains(Constants.IS_ABOUT_ACTIVITY_SHOWN);
//    }
//
////    fun getMyMainExecutor(): MainThreadExecutor {
////        return AppExecutors().mainThreadExecutor as MainThreadExecutor
////    }
////
////    fun getDBExecutor(): DataBaseThreadExecutor {
////        return AppExecutors().dbExecutor as DataBaseThreadExecutor
////    }
//
//
//}
