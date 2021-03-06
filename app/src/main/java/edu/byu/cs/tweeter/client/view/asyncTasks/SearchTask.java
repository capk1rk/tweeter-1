package edu.byu.cs.tweeter.client.view.asyncTasks;

import android.os.AsyncTask;

import java.io.IOException;

import edu.byu.cs.tweeter.client.presenter.MainPresenter;
import edu.byu.cs.tweeter.model.service.request.GetUserRequest;
import edu.byu.cs.tweeter.model.service.response.GetUserResponse;

public class SearchTask extends AsyncTask<GetUserRequest, Void, GetUserResponse> {

    private final MainPresenter presenter;
    private final SearchObserver observer;

    private Exception exception;

    public interface SearchObserver {
        void searchComplete(GetUserResponse response);
        void handleException(Exception e);
    }

    public SearchTask(MainPresenter presenter, SearchObserver observer) {
        this.presenter = presenter;
        this.observer = observer;
    }

    @Override
    protected GetUserResponse doInBackground(GetUserRequest... getUserRequests) {
        GetUserResponse response = null;
        try {
            response = presenter.getUser(getUserRequests[0]);
        } catch (IOException e) {
            exception = e;
        }
        return response;
    }

    @Override
    protected void onPostExecute(GetUserResponse response) {
        if (observer != null) {
            if (exception == null) {
                observer.searchComplete(response);
            } else {
                observer.handleException(exception);
            }
        }
    }
}
