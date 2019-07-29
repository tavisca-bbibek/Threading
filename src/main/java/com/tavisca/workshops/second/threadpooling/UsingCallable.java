package com.tavisca.workshops.second.threadpooling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class UsingCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future<String>> listOfFutures = new ArrayList<>();

        Callable<String> simpleCallable = new SimpleCallable();
        for (int i = 0; i < 1000; i++) {
            Future<String> future = service.submit(simpleCallable);
            listOfFutures.add(future);
        }

        Function<Future<String>, String> function = (f) -> {
            String name = "";
            try {
                name =  f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return name;
        };

        listOfFutures.stream().map(function).forEach(System.out::println);

        for(Future<String> f: listOfFutures){
            System.out.println(System.currentTimeMillis() + " : " + f.get());
        }
        service.shutdown();
    }
}
