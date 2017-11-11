package com.example.oluwapelumiolaoye.glidemvpretrofit.utility;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by oluwapelumi.olaoye on 11/11/17.
 */

@Singleton
@Component(modules = { AppModule.class})

public interface DependencyComponent {

    void inject(BaseApplication baseApplication);

}
