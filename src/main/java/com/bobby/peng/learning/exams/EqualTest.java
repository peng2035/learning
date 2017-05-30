package com.bobby.peng.learning.exams;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class EqualTest {

    @Override
    public int hashCode() {
        return 1;
    }

    public static void main(String[] args) {
        EqualTest equalTest = new EqualTest();
        EqualTest equalTest1 = new EqualTest();

        if(equalTest.equals(equalTest1)) {
            System.out.println("yes");
        }
    }
}
