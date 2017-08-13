package thesis.eng.reviewer.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jamesdeperio on 7/31/2017.
 */
@Entity
public class QuestionaireTable {
    @Id
    private Long id;
    @NotNull
    private Long categoryID;
    @NotNull
    private Long subCategoryID;
    @NotNull
    private String category;
    @NotNull
    private String subCategory;
    @NotNull
    private String question;

    @NotNull
    private String answer;

    @NotNull
    private String option1;

    @NotNull
    private String option2;

    @NotNull
    private String option3;

    @NotNull
    private String directory;

    private int points;
    private Long numberOfQuestion;
    @Generated(hash = 2002595506)
    public QuestionaireTable(Long id, @NotNull Long categoryID,
            @NotNull Long subCategoryID, @NotNull String category,
            @NotNull String subCategory, @NotNull String question,
            @NotNull String answer, @NotNull String option1,
            @NotNull String option2, @NotNull String option3,
            @NotNull String directory, int points, Long numberOfQuestion) {
        this.id = id;
        this.categoryID = categoryID;
        this.subCategoryID = subCategoryID;
        this.category = category;
        this.subCategory = subCategory;
        this.question = question;
        this.answer = answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.directory = directory;
        this.points = points;
        this.numberOfQuestion = numberOfQuestion;
    }
    @Generated(hash = 1978389290)
    public QuestionaireTable() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryID() {
        return this.categoryID;
    }
    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }
    public Long getSubCategoryID() {
        return this.subCategoryID;
    }
    public void setSubCategoryID(Long subCategoryID) {
        this.subCategoryID = subCategoryID;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSubCategory() {
        return this.subCategory;
    }
    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
    public String getQuestion() {
        return this.question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return this.answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getOption1() {
        return this.option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return this.option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return this.option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getDirectory() {
        return this.directory;
    }
    public void setDirectory(String directory) {
        this.directory = directory;
    }
    public int getPoints() {
        return this.points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public Long getNumberOfQuestion() {
        return this.numberOfQuestion;
    }
    public void setNumberOfQuestion(Long numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }
}
