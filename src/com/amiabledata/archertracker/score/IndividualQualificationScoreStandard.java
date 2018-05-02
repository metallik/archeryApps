package com.amiabledata.archertracker.score;
import com.amiabledata.archertracker.score.Score;
import com.amiabledata.archertracker.score.IndividualQualificationScore;

public class IndividualQualificationScoreStandard extends IndividualQualificationScore{
    //Qualitative Variable
    private String[]TotalScoreRange = {"novice","intermediate","professional","expert","veteran","master"};
    private String[][]SkillRange = {{"poor","good","average","very good","excellent"},{"unskilled","accurate","remarkable"}};
    public void TotalScoreRange(){
       if(getSum()>0 && getSum()<=300)
       {
           System.out.println(TotalScoreRange[0]);
       }
       else if(getSum()>= 301 && getSum()<=450){
            System.out.println(TotalScoreRange[1]);
       }
       else if(getSum()>=451 && getSum()<=550){
           System.out.println(TotalScoreRange[2]);
       }
       else if(getSum()>=551 && getSum()<=630){
           System.out.println(TotalScoreRange[3]);
       }
       else if(getSum()>=631 && getSum()<=680){
           System.out.println(TotalScoreRange[4]);
       }
       else if(getSum()>=681 && getSum()<=720){
           System.out.println(TotalScoreRange[5]);
       }
        
}
    public void TenPlusXSkill(){
        if(getTenPlusX() >= 15){
            System.out.println(SkillRange[0][4]);
        }
        else if(getTenPlusX()>=10 && getTenPlusX()<=14){
            System.out.println(SkillRange[0][3]);
        }
        else if(getTenPlusX()>=5 && getTenPlusX()<= 9){
            System.out.println(SkillRange[0][2]);
        }
        else if(getTenPlusX()>=3 && getTenPlusX()<= 4){
            System.out.println(SkillRange[0][1]);
        }
        else if(getTenPlusX()<3){
            System.out.println(SkillRange[0][0]);
        }
    }
    
    public void XSkill(){
        if(getAmountOfX() >= 5){
            System.out.println(SkillRange[1][2]);
        }
        else if(getAmountOfX()>= 1 && getAmountOfX()<5){
            System.out.println(SkillRange[1][1]);
        }
        else if(getAmountOfX() == 0){
            System.out.println(SkillRange[1][0]);
        }
    }
}
