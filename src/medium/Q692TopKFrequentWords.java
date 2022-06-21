package medium;

import java.util.*;

public class Q692TopKFrequentWords {
    class WordCount{
        public String word;
        public int frequency;
        public WordCount(String word, int frequency){
            this.word = word;
            this.frequency = frequency;
        }
    }

    /**
     *
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (int i=0; i< words.length; i++){
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0)+1 );
        }

        PriorityQueue<WordCount> heap = new PriorityQueue<WordCount>(wordMap.size(), (a, b) -> {
            if (a.frequency == b.frequency){
                return a.word.compareTo(b.word);
            }
            return a.frequency - b.frequency;
        });

        for (Map.Entry<String,Integer> entry: wordMap.entrySet()){
            heap.offer(new WordCount(entry.getKey(), entry.getValue()));
        }

        List<String> result = new ArrayList<>();
        for (int i=0; i<k; i++){
            result.add(heap.poll().word);
        }
        return result;

    }
}
