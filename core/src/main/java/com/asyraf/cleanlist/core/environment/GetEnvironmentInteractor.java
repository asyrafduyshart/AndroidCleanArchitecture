package com.asyraf.cleanlist.core.environment;

/**
 * Created by Asyraf Duyshart on 5/22/16.
 */
public class GetEnvironmentInteractor {

    Repository repository;

    public GetEnvironmentInteractor(Repository repository) {
        this.repository = repository;
    }

    public interface Repository {
        Environment getEnvironment();
    }

    public Environment get() {
        return repository.getEnvironment();
    }
}
