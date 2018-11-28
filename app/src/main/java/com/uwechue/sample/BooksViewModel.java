package com.uwechue.sample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BooksViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Book>> booksList;

    //we will call this method to get the data
    public LiveData<List<Book>> getBooks() {
        //if the list is null
        if (booksList == null) {
            booksList = new MutableLiveData<List<Book>>();
            //we will load it asynchronously from server in this method
            fetchBooks();
        }

        //finally we will return the list
        return booksList;
    }


    //This method is using Retrofit to fetch the JSON data from URL
    private void fetchBooks() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Book>> call = api.getBooks();


        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

                //finally we are setting the list to our MutableLiveData
                booksList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }
}
