package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        File file = new File("/Users/ghirisansebastian/IdeaProjects/731_GhirisanSebastian_Prob1/src/com/company/offerten.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<Tasks> tasks = new ArrayList<>();
        //a
        while ((st = br.readLine()) != null) {
            List<String> line = new ArrayList<>(Arrays.asList(st.split("\\$")));
            Status stat;
            if(Objects.equals(line.get(4), "In Progress"))
                stat=Status.In_Progress;
            else
                stat=Status.valueOf(line.get(4));
            tasks.add(new Tasks(Integer.parseInt(line.get(0)),line.get(1),Integer.parseInt(line.get(2)),Integer.parseInt(line.get(3)),stat));
        }

        //b
        tasks.sort(Comparator.comparing(Tasks::getSpent,Comparator.reverseOrder()));
        System.out.println(tasks);

        //c
        try {
            File myObj = new File("taskssortiert.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("taskssortiert.txt");
            for (Tasks task : tasks
            ) {
                myWriter.append(task.toString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        //d
        Map<String,Integer> string_buddget=new HashMap<>();
        int sum=0;
        for(Status stat: Status.values()) {
            sum = 0;
            for (Tasks task:tasks){
                if(task.getStatus()==stat)
                    sum+=task.getRestBudget();
            }
            string_buddget.put(stat.name(),sum);
        }
        Stream<Map.Entry<String, Integer>> sorted =
                string_buddget.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());
        try {
            FileWriter myWriter = new FileWriter("statistik.txt");
            sorted.collect(Collectors.toCollection(LinkedList::new))
                    .descendingIterator().forEachRemaining((a)-> {
                try {
                    myWriter.append(a.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}

