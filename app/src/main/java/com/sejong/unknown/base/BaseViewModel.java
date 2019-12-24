package com.sejong.unknown.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

abstract public class BaseViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void register(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected void register(Disposable... disposables) {
        compositeDisposable.addAll(disposables);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}
