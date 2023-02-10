@file:Suppress("unused")

package benchmark.small

import benchmark._material.smallTimes
import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Fork
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.annotations.Warmup

@State(Scope.Thread)
@Warmup(iterations = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1, jvmArgs = ["-Xms4G", "-Xmx4G"])
open class SmallNormalBenchmark {
    @Benchmark
    fun main(): Int {
        var result = 0
        smallTimes.forEach { _ ->
            result++
        }
        return result
    }
}
