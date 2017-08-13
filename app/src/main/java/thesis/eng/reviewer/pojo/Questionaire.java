
package thesis.eng.reviewer.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Questionaire {

    @SerializedName("answer")
    private String mAnswer;
    @SerializedName("categoryid")
    private String mCategoryid;
    @SerializedName("categoryname")
    private String mCategoryname;
    @SerializedName("directory")
    private String mDirectory;
    @SerializedName("numberofquestion")
    private String mNumberofquestion;
    @SerializedName("option1")
    private String mOption1;
    @SerializedName("option2")
    private String mOption2;
    @SerializedName("option3")
    private String mOption3;
    @SerializedName("points")
    private String mPoints;
    @SerializedName("question")
    private String mQuestion;
    @SerializedName("questionaire")
    private List<Questionaire> mQuestionaire;
    @SerializedName("subcategoryid")
    private String mSubcategoryid;
    @SerializedName("subcategoryname")
    private String mSubcategoryname;

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    public String getCategoryid() {
        return mCategoryid;
    }

    public void setCategoryid(String categoryid) {
        mCategoryid = categoryid;
    }

    public String getCategoryname() {
        return mCategoryname;
    }

    public void setCategoryname(String categoryname) {
        mCategoryname = categoryname;
    }

    public String getDirectory() {
        return mDirectory;
    }

    public void setDirectory(String directory) {
        mDirectory = directory;
    }

    public String getNumberofquestion() {
        return mNumberofquestion;
    }

    public void setNumberofquestion(String numberofquestion) {
        mNumberofquestion = numberofquestion;
    }

    public String getOption1() {
        return mOption1;
    }

    public void setOption1(String option1) {
        mOption1 = option1;
    }

    public String getOption2() {
        return mOption2;
    }

    public void setOption2(String option2) {
        mOption2 = option2;
    }

    public String getOption3() {
        return mOption3;
    }

    public void setOption3(String option3) {
        mOption3 = option3;
    }

    public String getPoints() {
        return mPoints;
    }

    public void setPoints(String points) {
        mPoints = points;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<Questionaire> getQuestionaire() {
        return mQuestionaire;
    }

    public void setQuestionaire(List<Questionaire> questionaire) {
        mQuestionaire = questionaire;
    }

    public String getSubcategoryid() {
        return mSubcategoryid;
    }

    public void setSubcategoryid(String subcategoryid) {
        mSubcategoryid = subcategoryid;
    }

    public String getSubcategoryname() {
        return mSubcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        mSubcategoryname = subcategoryname;
    }

}
