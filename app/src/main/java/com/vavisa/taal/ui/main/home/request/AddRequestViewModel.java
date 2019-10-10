package com.vavisa.taal.ui.main.home.request;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vavisa.taal.R;
import com.vavisa.taal.data.model.CaseField;
import com.vavisa.taal.data.model.CaseResponse;
import com.vavisa.taal.data.model.Parameter;
import com.vavisa.taal.data.network.main.Resource;
import com.vavisa.taal.data.repository.RequestRepository;
import com.vavisa.taal.databinding.FragmentAddRequestBinding;
import com.vavisa.taal.util.dynamicViews.DynamicView;
import com.vavisa.taal.util.dynamicViews.DynamicViewFactory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AddRequestViewModel extends ViewModel {

    private Context context;
    private Integer categoryId;
    private ArrayList<CaseField> fields;
    private RequestRepository requestRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Resource<List<Parameter>>> liveData = new MutableLiveData<>();
    private MutableLiveData<Resource<CaseResponse>> caseLiveData = new MutableLiveData<>();

    @Inject
    AddRequestViewModel(RequestRepository requestRepository, Context context) {
        this.requestRepository = requestRepository;
        this.context = context;
    }

    MutableLiveData<Resource<List<Parameter>>> getLiveData() {
        return liveData;
    }

    MutableLiveData<Resource<CaseResponse>> getCaseLiveData() {
        return caseLiveData;
    }

    void getRequestParameters(Integer id) {
        this.categoryId = id;
        compositeDisposable.add(requestRepository.getCategoryParameters(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> liveData.setValue(Resource.loading()))
                .subscribe(
                        parameters -> liveData.setValue(Resource.success(parameters)),
                        throwable -> liveData.setValue(Resource.error(throwable))
                ));
    }

    void createRequestView(List<Parameter> parameters, FragmentAddRequestBinding binding) {
        DynamicViewFactory viewFactory = new DynamicViewFactory(context);
        ArrayList<DynamicView> viewsList = new ArrayList<>();
        fields = new ArrayList<>();
        for (Parameter parameter: parameters){
            viewsList.add(viewFactory.createView(parameter));
            viewsList.size();
            CaseField field = new CaseField(parameter.getId());
            fields.add(field);
        }
        binding.setViewsList(viewsList);
    }

    public void submitRequest(ArrayList<DynamicView> viewsList){
        if (getCaseFields(viewsList)) 
            compositeDisposable.add(requestRepository.addCase(fields, categoryId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> caseLiveData.setValue(Resource.loading()))
                    .subscribe(
                            caseResponse -> caseLiveData.setValue(Resource.success(caseResponse)),
                            throwable -> caseLiveData.setValue(Resource.error(throwable))
                    ));
        else 
            caseLiveData.setValue(
                    Resource.error(new Throwable(
                            context.getString(
                                    R.string.fill_required_fields))));
    }

    private boolean getCaseFields(ArrayList<DynamicView> viewsList){
        for (int i=0; i<fields.size(); i++){
            String value = viewsList.get(i).getValue();
            if (value != null)
                fields.get(i).setValue(value);
            else
                return false;
        }
        return true;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }
}
