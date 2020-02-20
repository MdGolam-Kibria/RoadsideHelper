package com.example.myapplication.admin.UserProbPojo;

import java.util.Arrays;

public class PbPojo {
    public byte[] problemImage;
    public String problemDescription;

    public PbPojo() {
    }

    public PbPojo(byte[] problemImage, String problemDescription) {
        this.problemImage = problemImage;
        this.problemDescription = problemDescription;
    }

    public byte[] getProblemImage() {
        return problemImage;
    }

    public void setProblemImage(byte[] problemImage) {
        this.problemImage = problemImage;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    @Override
    public String toString() {
        return "PbPojo{" +
                "problemImage=" + Arrays.toString(problemImage) +
                ", problemDescription='" + problemDescription + '\'' +
                '}';
    }
}
