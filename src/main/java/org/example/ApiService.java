package org.example;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


import java.util.List;

public interface ApiService {
    @GET("/todos")
    Call<List<Todo>> getTodos();

    @GET("/todos/{id}")
    Call<Todo> getTodo(@Path("id") int TodoId);


}
