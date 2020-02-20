package com.example.myapplication.probImageAndPbView;

public class ProblemModel {

    private String problemDescription;
    private String problemImage;

    public ProblemModel() {
    }

    public ProblemModel(String problemDescription, String problemImage) {
        this.problemDescription = problemDescription;
        this.problemImage = problemImage;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getProblemImage() {
        return problemImage;
    }

    public void setProblemImage(String problemImage) {
        this.problemImage = problemImage;
    }

    @Override
    public String toString() {
        return "ProblemModel{" +
                "problemDescription='" + problemDescription + '\'' +
                ", problemImage='" + problemImage + '\'' +
                '}';
    }
}

