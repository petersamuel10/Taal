package com.vavisa.taal.ui.main.home;

import androidx.lifecycle.Observer;

import com.vavisa.taal.InstantExecutorExtension;
import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.HomeRepository;
import com.vavisa.taal.ui.main.home.categories.HomeViewModel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith({InstantExecutorExtension.class})
class HomeViewModelTest {

    private HomeViewModel homeViewModel;

    @Mock
    private HomeRepository homeRepository;

    @Mock
    Observer<Resource<List<Category>>> observer;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
        homeViewModel = new HomeViewModel(homeRepository);
        homeViewModel.getLiveData().observeForever(observer);
    }

    @Test
    void testNull() {
        when(homeRepository.getCategories()).thenReturn(null);
        assertNotNull(homeViewModel.getLiveData());
        assertTrue(homeViewModel.getLiveData().hasObservers());
    }

    @Test
    void testApiFetchDataSuccess() {
        final List<Category> categories = new ArrayList<>();
        final Observable<List<Category>> returnedData = Observable.just(categories);

        when(homeRepository.getCategories()).thenReturn(returnedData);
        homeViewModel.getCategories();

        verify(observer).onChanged(Resource.loading());
        verify(observer).onChanged(Resource.success(categories));
        verifyNoMoreInteractions(observer);
        assertEquals(Resource.success(categories), homeViewModel.getLiveData().getValue());
    }

    @Test
    void testApiFetchDataError() throws InterruptedException {
        final Throwable throwable = new Throwable();
        final Observable<List<Category>> error = Observable.error(throwable);

        when(homeRepository.getCategories()).thenReturn(error);
        homeViewModel.getCategories();
        new CountDownLatch(1).await(100, TimeUnit.MILLISECONDS);

        verify(observer).onChanged(Resource.loading());
        verify(observer).onChanged(Resource.error(throwable));
        verifyNoMoreInteractions(observer);
        assertEquals(Resource.error(throwable), homeViewModel.getLiveData().getValue());
    }

}