package com.asyraf.cleanlist.core.environment;

/**
 * Created by Asyraf Duyshart on 5/22/16.
 */
public class SetEnvironmentInteractor {

    public interface Repository {
        void setEnvironmentKey(String key);
    }

    Repository repository;

    public SetEnvironmentInteractor(Repository repository) {
        this.repository = repository;
    }

    public void set(String key) {
        repository.setEnvironmentKey(key);
    }
}
