import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class HelloWorld {
  public void say(@NotNull List<List<String>> names) {
    names.forEach(name -> name.forEach(n -> System.out.println("Hello " + n + "!")));
  }

  public void say(String... names) {
    Arrays.asList(names).forEach(n -> System.out.println("Hello " + n + "!"));
  }
}
