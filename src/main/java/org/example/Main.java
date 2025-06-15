package org.example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        Call<List<Todo>> call = apiService.getTodos();
        try {
            Response<List<Todo>> response = call.execute();
            if (response.isSuccessful()) {
                List<Todo> todos = response.body();
                for (Todo todo : todos) {
                    System.out.println(todo);
                }
                System.exit(0);
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


