package com.example.myapplication.showUserProblemstoServiceProviders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShareProblemToServiceProviders {
    private String problemDescription;
    private String problemImage;

//    public ShareProblemToServiceProviders(String problemDescription, String problemImage) {
//        this.problemDescription = problemDescription;
//        this.problemImage = problemImage;
//    }
//
//    public ShareProblemToServiceProviders() {
//    }
//
//    public String getProblemDescription() {
//        return problemDescription;
//    }
//
//    public void setProblemDescription(String problemDescription) {
//        this.problemDescription = problemDescription;
//    }
//
//    public String getProblemImage() {
//        return problemImage;
//    }
//
//    public void setProblemImage(String problemImage) {
//        this.problemImage = problemImage;
//    }
//
//    @Override
//    public String toString() {
//        return "ShareProblemToServiceProviders{" +
//                "problemDescription='" + problemDescription + '\'' +
//                ", problemImage='" + problemImage + '\'' +
//                '}';
//    }
}
