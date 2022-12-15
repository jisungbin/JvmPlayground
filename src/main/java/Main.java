class Test {
    private int test;

    public Test(int test) {
        this.test = test;
    }
}

class Test2 extends Test {
    private int test2;

    public Test2(int test, int test2) {
        super(test);
        this.test2 = test2;
    }
}