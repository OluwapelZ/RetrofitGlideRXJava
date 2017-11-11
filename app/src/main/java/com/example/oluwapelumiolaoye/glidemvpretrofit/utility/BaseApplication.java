package com.example.oluwapelumiolaoye.glidemvpretrofit.utility;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by oluwapelumi.olaoye on 11/10/17.
 */

public class BaseApplication extends Application {

    private static BaseApplication context;

    private DependencyComponent dependencyComponent;

    public static BaseApplication getContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        dependencyComponent = DaggerDependencyComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }


    public static DependencyComponent getDependencyComponent() {
        return context.dependencyComponent;
    }

    public static boolean isAndroidApiLevelAndAbove(int apiLevel) {
        return Build.VERSION.SDK_INT >= apiLevel;
    }

    /**
     * Easy convenient string resource retrieval.
     *
     * @param resId The string resource id to get.
     * @return The string resource value.
     */
    @Nullable
    public static String s(int resId) {
        return context != null ? context.getString(resId) : "";
    }
}
