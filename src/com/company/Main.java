package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i<=100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");

        //union
        //these operations [bulk operations] are destructive. [they modify the set]
        Set<Integer> union = new HashSet<>(squares); //so we create a new union set
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        //intersection
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements"); //[200(total [100+100])-196(union)]
        for(int i: intersection){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        /*Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords)); //adds the elements of arrayWords to the words Set

        for(String s : words){
            System.out.println(s);
        }*/

        //asymmetric difference [one set minus intersection]
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine: ");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature: ");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        //symmetric difference [union minus intersection]
        //getting union
        Set<String> unionOfNatureAndDivine = new HashSet<>(nature);
        unionOfNatureAndDivine.addAll(divine);

        //getting intersection
        Set<String> intersectionOfNatureAndDivine = new HashSet<>(nature);
        intersectionOfNatureAndDivine.retainAll(divine);

        //union minus intersection
        Set<String> symmetricDiff = new HashSet<>(unionOfNatureAndDivine);
        symmetricDiff.removeAll(intersectionOfNatureAndDivine);
        printSet(symmetricDiff);

        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }
        if(nature.containsAll(intersectionOfNatureAndDivine)){
            System.out.println("intersection is a subset of nature");
        }
        if(divine.containsAll(intersectionOfNatureAndDivine)){
            System.out.println("intersection is a subset of divine");
        }
    }

    private static void printSet(Set<String> set){
        for(String s : set){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
