public class Context {
    private boolean init = false;

    public Context() { // default constructor
        init = true;
    }

    public boolean isInit() {
        return init;
    }
}
