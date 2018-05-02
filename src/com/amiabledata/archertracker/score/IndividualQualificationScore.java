package com.amiabledata.archertracker.score;

import java.util.ArrayList;
import java.util.Iterator;

public class IndividualQualificationScore extends Score {
    private ArrayList<Integer> value;
    private Integer sum;
    private Integer tenPlusX;
    private Integer amountOfX;

    public IndividualQualificationScore() {
        setSetNumber(0);
        this.value = new ArrayList<Integer>();
        this.sum = 0;
        this.tenPlusX = 0;
        this.amountOfX = 0;
    }

    public IndividualQualificationScore(IndividualQualificationScore value) {
        setSetNumber(value.getSetNumber());
        setValue(value.getAllValue());
    }

    public void setValue(ArrayList<Integer> value) {
        this.value = new ArrayList<Integer>();
        this.value.addAll(value);
        reevaluate();
    }

    public void addValue(Integer value) {
        this.value.add(value);
        reevaluate();
    }

    public ArrayList<Integer> getAllValue() {
        return this.value;
    }
    public Integer getValue(Integer Index) {
        return this.value.get(Index);
    }

    private void reevaluate() {
        sum = 0;
        tenPlusX = 0;
        amountOfX = 0;

        for(Iterator<Integer> it = this.value.iterator(); it.hasNext();) {
            Integer n = it.next();
            if(n >= 10) {
                if(n >= 11) {
                    amountOfX++;
                }
                tenPlusX++;
                sum += 10;
            } else {
                sum += n;
            }
        }
    }

    public Integer getSum() {
        reevaluate();
        return this.sum;
    }

    public Integer getTenPlusX() {
        reevaluate();
        return this.tenPlusX;
    }

    public Integer getAmountOfX() {
        reevaluate();
        return this.amountOfX;
    }
}
