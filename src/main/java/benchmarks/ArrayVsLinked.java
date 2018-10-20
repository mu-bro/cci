package benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
public class ArrayVsLinked {
    public static final int ARRAY_SIZE = 1000;


    public ArrayList arrayList = new ArrayList<Integer>();
    public LinkedList linkedList = new LinkedList<Integer>();

    @Setup(Level.Trial)
    public void setUp() {
        populateList(arrayList, ARRAY_SIZE);
        populateList(linkedList, ARRAY_SIZE);
        System.out.println("arrayList size: " + arrayList.size());
        System.out.println("linkedList size: " + linkedList.size());
    }

    private void populateList(List list, int size) {
        IntStream.range(0, size).forEach(
                i -> list.add(i)
        );
    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void arrayListAddInBeginning() {
//        arrayList.add(5, 10);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void linkedListAddInBeginning() {
//        linkedList.add(5, 10);
//    }


//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void arrayListAddInEnd() {
//        arrayList.add(999, 10);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void linkedListAddInEnd() {
//        linkedList.add(999, 10);
//    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void arrayListSetInMiddle() {
//        arrayList.set(50_000, 10);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void linkedListSetInMiddle() {
//        linkedList.set(50_000, 10);
//    }

//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void arrayListSetInEnd() {
//        arrayList.set(ARRAY_SIZE - 1, 10);
//    }
//
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void linkedListSetInEnd() {
//        linkedList.set(ARRAY_SIZE - 1, 10);
//    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void arrayListAddInMiddle() {
        arrayList.add(arrayList.size()/2, 10);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void linkedListAddInMiddle() {
        linkedList.add(arrayList.size()/2, 10);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(ArrayVsLinked.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(4)
                .forks(1)
                .build();

        new Runner(options).run();
    }
}
