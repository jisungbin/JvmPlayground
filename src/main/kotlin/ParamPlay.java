import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParamPlay {
    public static void main(String[] args) throws Exception {
        Method m = MyInterface.class.getMethod("method", String.class);
        Parameter p = m.getParameters()[0];
        System.out.println(p.isNamePresent());
        System.out.println(p.getName());
    }

    public interface MyInterface {
        String method(String str);
    }
}