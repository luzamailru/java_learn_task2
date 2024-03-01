package ru.zakharova;

public interface Fractionable {
    @Cash
    double doubleValue();
    @Mutator
    void setNum(int num);
    @Mutator
    void setDenum(int denum);


}
