package com.example.oluwapelumiolaoye.glidemvpretrofit.utility;

/**
 * Created by oluwapelumi.olaoye on 11/6/17.
 */

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule class.
 *
 * This class is used by Dagger to initialise Application context.
 */
@Module
public class AppModule {

    private BaseApplication application;

    public AppModule(BaseApplication app) {
        application = app;
    }

    @Provides
    @Singleton
    BaseApplication providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideContext()
    {
        return application;
    }
}