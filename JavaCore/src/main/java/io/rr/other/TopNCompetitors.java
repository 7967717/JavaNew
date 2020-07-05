package io.rr.other;

import java.util.*;

public class TopNCompetitors {

    public static void main(String[] args) {
        System.out.println(topNCompetitors(6, 3, Arrays.asList("a", "b", "c", "d"),
                4, Arrays.asList("a f j n ", "a f j n ", "b f b ", "c g", "b f b ", "d, e")));

    }

    public static ArrayList<String> topNCompetitors(int numCompetitors,
                                                    int topNCompetitors,
                                                    List<String> competitors,
                                                    int numReviews,
                                                    List<String> reviews) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String competitor : competitors) {
            int counter = 0;
            for (String review : reviews) {
                if (review.toLowerCase().contains(competitor.toLowerCase())) {
                    counter++;
                }
            }
            map.put(competitor.toLowerCase(), counter);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey()));

        ArrayList<String> res = new ArrayList<>();
        if (list.size() <= topNCompetitors) {
            for (Map.Entry<String, Integer> entry : list) {
                res.add(entry.getKey());
            }
        } else {
            for (int i = 0; i < topNCompetitors; i++) {
                res.add(list.get(i).getKey());
            }
        }
        return res;
    }

}

