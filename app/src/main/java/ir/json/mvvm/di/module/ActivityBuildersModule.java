package ir.json.mvvm.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.json.mvvm.view.activity.MainActivity;

@Module
public abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
