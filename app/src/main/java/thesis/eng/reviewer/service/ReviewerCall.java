package thesis.eng.reviewer.service;


import retrofit2.http.GET;
import rx.Observable;
import thesis.eng.reviewer.pojo.Questionaire;
import thesis.eng.reviewer.pojo.Reviewer;

/**
 * Created by jamesdeperio on 7/29/2017.
 */

public interface ReviewerCall {
    @GET("getData.php")
    Observable<Reviewer> getData();

    @GET("getQuestion.php")
    Observable<Questionaire> getQuestionaire();


}
