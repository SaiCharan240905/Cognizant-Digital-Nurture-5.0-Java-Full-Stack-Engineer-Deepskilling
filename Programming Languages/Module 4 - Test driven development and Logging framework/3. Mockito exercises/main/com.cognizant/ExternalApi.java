package com.cognizant;

public interface ExternalApi {

    String getData();

    String getDataById(int id);

    void sendData(String data);

    void process();

}