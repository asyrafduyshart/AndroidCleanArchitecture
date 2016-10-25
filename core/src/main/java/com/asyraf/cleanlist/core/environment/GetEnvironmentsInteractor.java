package com.asyraf.cleanlist.core.environment;

import java.util.List;

/**
 * Created by Asyraf Duyshart on 5/22/16.
 */
public class GetEnvironmentsInteractor {

    public interface Repository {
        List<Environment> getEnvironments();
    }

    Repository repository;

    public GetEnvironmentsInteractor(Repository repository) {
        this.repository = repository;
    }

    public List<Environment> get() {
        return repository.getEnvironments();
    }
}
