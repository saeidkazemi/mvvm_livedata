package ir.json.mvvm.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ir.json.mvvm.viewmodel.PostViewModel;
import ir.json.mvvm.viewmodel.ViewModelProviderFactory;

@Module
public abstract class ViewModelFactoryModule {
    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    public abstract ViewModel bindMainViewModel(PostViewModel viewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelFactory);
}
