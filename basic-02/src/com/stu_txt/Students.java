package com.stu_txt;

// 学生类
class Students {
    private String name;// 学生姓名
    private int number;// 学号
    private float mScore;// 数学成绩
    private float cScore;// 语文成绩
    private float eScore;// 英语成绩

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getmScore() {
        return mScore;
    }

    public void setmScore(float mScore) {
        this.mScore = mScore;
    }

    public float getcScore() {
        return cScore;
    }

    public void setcScore(float cScore) {
        this.cScore = cScore;
    }

    public float geteScore() {
        return eScore;
    }

    public void seteScore(float eScore) {
        this.eScore = eScore;
    }

    public float getTotalScore() {
        return mScore + cScore + eScore;
    }

}