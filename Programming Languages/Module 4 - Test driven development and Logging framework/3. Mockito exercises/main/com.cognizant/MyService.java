package com.cognizant;

public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(int id) {
        return externalApi.getDataById(id);
    }

    public void submitData(String data) {
        externalApi.sendData(data);
    }

    public void executeProcess() {
        externalApi.process();
    }
}