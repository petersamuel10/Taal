package com.vavisa.taal.data.repository;

import com.vavisa.taal.data.model.Category;
import com.vavisa.taal.data.network.main.MainApi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class HomeRepositoryTest {

    private HomeRepository homeRepository;

    @Mock
    private MainApi mainApi;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        homeRepository = new HomeRepository(mainApi);
    }

    @Test
    void readyToGo() {
        assertNotNull(mainApi);
        assertNotNull(homeRepository);
    }

    @Test
    void getDataSuccess() throws InterruptedException {
        final List<Category> categories = new ArrayList<>();
        categories.add(new Category());

        final Observable<List<Category>> assumedData = Observable.just(categories);
        when(mainApi.getCategories()).thenReturn(assumedData);

        homeRepository.getCategories()
                .test()
                .await()
                .assertValue(categories);
    }

    @Test
    void getDataFailure() {
        final List<Category> categories = new ArrayList<>();
        categories.add(new Category());

        final Observable<List<Category>> assumedData = Observable.just(categories);
        when(mainApi.getCategories()).thenReturn(null);

        final Observable<List<Category>> actualData = homeRepository.getCategories();

        verify(mainApi).getCategories();
        verifyNoMoreInteractions(mainApi);
        assertNotEquals(assumedData, actualData);
    }
}