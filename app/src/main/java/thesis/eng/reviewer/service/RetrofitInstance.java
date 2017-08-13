package thesis.eng.reviewer.service;

import android.content.Context;

public class RetrofitInstance extends RetrofitService {
    @Override
    protected void initHeader() {

    }

    @Override
    public long initConnectTimeout() {
        return 3600;
    }

    @Override
    public long initReadTimeout() {
        return 3600;
    }

    @Override
    public long initWriteTimeout() {
        return 3600;
    }

    @Override
    public int setCacheSize() {
        return 10;
    }

    @Override
    public String setBaseURL() {
      //  return "http://uopcereviewer.16mb.com/reviewer/";
        return "http://192.168.53.2/reviewer/";
    }

    public ReviewerCall getReviewService(Context context){
        return (ReviewerCall) initialize(context, ReviewerCall.class);
    }

}
