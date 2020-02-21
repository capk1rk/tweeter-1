package edu.byu.cs.tweeter.presenter;

import edu.byu.cs.tweeter.model.domain.Tweet;
import edu.byu.cs.tweeter.model.services.TweetService;
import edu.byu.cs.tweeter.net.response.TweetResponse;

public class TweetPresenter extends Presenter {

    private final View view;

    public interface View {

    }

    public TweetPresenter(View view) { this.view = view; }

    public TweetResponse shareTweet(Tweet tweet) {
        return TweetService.getInstance().shareTweet(tweet);
    }
}
