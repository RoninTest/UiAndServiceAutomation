package apitest.testservice;

import apitest.infrastructure.singleton.RestAsFactory;

public class BaseService {
    public BaseService() {
    }

    protected RestAsFactory restAssFactory = new RestAsFactory();
}
