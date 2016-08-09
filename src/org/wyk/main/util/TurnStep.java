package org.wyk.main.util;

/**
 * @author wyk
 * @time  2016年6月5日
 */
public class TurnStep {
    private int p = 0;

    private int stepRange = 10;

    private int right = 0;

    private int total = 0;

    private int st;

    private int en;

    public void setP(int p) {
        this.p = p;
    }

    public void setStepRange(int stepRange) {
        this.stepRange = stepRange;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void init() {
        this.en = (this.p + this.right);
        if (this.en > this.total)
            this.en = this.total;
        else if (this.en < this.stepRange)
            this.en = ((this.stepRange > this.total) ? this.total : this.stepRange);
        //this.st = (this.p - this.stepRange - ((this.total - this.p >= this.right) ? this.right : this.total - this.p) + 1);
        
        this.st = (this.p - this.stepRange + ((this.total - this.p >= this.right) ? this.right : this.total - this.p) + 1);
        if (this.st < 1)
            this.st = 1;
    }

    public int getST() {
        return this.st;
    }

    public int getEN() {
        return this.en;
    }
}