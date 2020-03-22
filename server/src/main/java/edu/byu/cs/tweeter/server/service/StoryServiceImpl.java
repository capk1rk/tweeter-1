package edu.byu.cs.tweeter.server.service;

import java.io.IOException;

import edu.byu.cs.tweeter.model.service.StoryService;
import edu.byu.cs.tweeter.model.service.request.StoryRequest;
import edu.byu.cs.tweeter.model.service.response.StoryResponse;
import edu.byu.cs.tweeter.server.dao.TweetsDAO;

public class StoryServiceImpl implements StoryService {

    @Override
    public StoryResponse getStory(StoryRequest request) {
        TweetsDAO dao = new TweetsDAO();
        return dao.getStory(request);
    }
}