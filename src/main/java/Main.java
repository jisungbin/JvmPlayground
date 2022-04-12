import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Toolkit;
import java.util.concurrent.Semaphore;

import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;

public class Main {
    public static void main(String[] args) {
        switch (1) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
        }
    }
}


