package com.imobile3.groovypayments.ui.chart;

import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.imobile3.groovypayments.data.CartRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PieChartViewModel extends ViewModel {

    private CartRepository mCartRepository;
    String[] product = {"Tasty Chicken Sandwich", "10-Pack of AA Batteries","Metal Folding Chair",
    "Coca Cola","Claw Hammer"};
    double [] price = {7.50,8.99,22.50,1.25,4.99};



        PieChartViewModel(CartRepository repository) {
            mCartRepository = repository;
    }



    LiveData<List<DataEntry>> getProductList() {


        final MutableLiveData<List<DataEntry>> observable =
                new MutableLiveData<>(new ArrayList<>());
        List<DataEntry> item = new ArrayList<>();

        for (int i=0; i<product.length; i++) {
            item.add(new ValueDataEntry(product[i],price[i]));
        }

        observable.setValue(item);

        return observable;
     }
    }

