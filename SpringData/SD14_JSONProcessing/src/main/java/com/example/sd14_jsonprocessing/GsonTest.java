package com.example.sd14_jsonprocessing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class GsonTest {

    private static final String json =
            """
                    {
                      "username": "Pesho",
                      "password": "test1234"
                    }
                    """;

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() //Excludes fields that don't have @Expose annotation
                .setPrettyPrinting()
                .create();

        LoginData loginDataToJSON = new LoginData("Pesho", "test1234");

        String result = gson.toJson(loginDataToJSON);

        System.out.println("From Object to JSON: ");
        System.out.println(result);
        System.out.println();

        LoginData loginDataFromJSON = gson.fromJson(json, LoginData.class);

        System.out.println("From JSON to Object: ");
        System.out.println(loginDataFromJSON.getUsername() + " " + loginDataFromJSON.getPassword());
    }

    static class LoginData {

        @Expose
        private String username;

        @Expose
        private String password;

        public LoginData(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
