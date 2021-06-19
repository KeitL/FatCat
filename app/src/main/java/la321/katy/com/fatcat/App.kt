package la321.katy.com.fatcat

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import la321.katy.com.fatcat.executors.AppExecutors
import la321.katy.com.fatcat.executors.DataBaseThreadExecutor
import la321.katy.com.fatcat.executors.MainThreadExecutor

class App : Application() {
    private var sharedPreferences: SharedPreferences? = null


    override fun onCreate() {
        super.onCreate()
        DbHelper.init(this)
        sharedPreferences = getSharedPreferences(Constants.SETTINGS, Context.MODE_PRIVATE)
    }

//    fun setAboutActivityShown(status: Boolean) {
//        val edit = sharedPreferences?.edit()
//        edit?.putBoolean(Constants.IS_ABOUT_ACTIVITY_SHOWN, true)
//        edit?.commit()
//    }
//
//    fun getIsAboutActivityShown(): Boolean? {
//        return sharedPreferences?.contains(Constants.IS_ABOUT_ACTIVITY_SHOWN)
//    }
//
//    fun setPropertiesActivityShown(status: Boolean) {
//        val edit = sharedPreferences?.edit()
//        edit?.putBoolean(Constants.IS_ABOUT_ACTIVITY_SHOWN, true)
//        edit?.commit()
//    }
//
//    fun getIsProrertiesActivityShown(): Boolean? {
//        return sharedPreferences?.contains(Constants.IS_ABOUT_ACTIVITY_SHOWN)
//    }

    fun getMyMainExecutor(): MainThreadExecutor {
        return AppExecutors().mainThreadExecutor as MainThreadExecutor
    }

    fun getDBExecutor(): DataBaseThreadExecutor {
        return AppExecutors().dbExecutor as DataBaseThreadExecutor
    }
}