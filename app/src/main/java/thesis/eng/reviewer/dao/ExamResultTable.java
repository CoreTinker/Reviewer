package thesis.eng.reviewer.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jamesdeperio on 8/6/2017.
 */
@Entity
public class ExamResultTable {
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
    private String yourAnswer;

    @NotNull
    private String option1;

    @NotNull
    private String option2;

    @NotNull
    private String option3;
    @NotNull
    private String option4;
    @NotNull
    private String correctAnswer;


    private Long foreignKey;
    private Long points;
    @Generated(hash = 1862983291)
    public ExamResultTable(Long id, @NotNull Long categoryID,
            @NotNull Long subCategoryID, @NotNull String category,
            @NotNull String subCategory, @NotNull String question,
            @NotNull String yourAnswer, @NotNull String option1,
            @NotNull String option2, @NotNull String option3,
            @NotNull String option4, @NotNull String correctAnswer, Long foreignKey,
            Long points) {
        this.id = id;
        this.categoryID = categoryID;
        this.subCategoryID = subCategoryID;
        this.category = category;
        this.subCategory = subCategory;
        this.question = question;
        this.yourAnswer = yourAnswer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.foreignKey = foreignKey;
        this.points = points;
    }
    @Generated(hash = 494373525)
    public ExamResultTable() {
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
    public String getYourAnswer() {
        return this.yourAnswer;
    }
    public void setYourAnswer(String yourAnswer) {
        this.yourAnswer = yourAnswer;
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
    public String getOption4() {
        return this.option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public Long getForeignKey() {
        return this.foreignKey;
    }
    public void setForeignKey(Long foreignKey) {
        this.foreignKey = foreignKey;
    }
    public Long getPoints() {
        return this.points;
    }
    public void setPoints(Long points) {
        this.points = points;
    }

}
