package com.uwechue.sample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://de-coding-test.s3.amazonaws.com";

    @GET("/books.json")
    Call<List<Book>> getBooks();
}
