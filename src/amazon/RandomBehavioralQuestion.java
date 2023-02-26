package amazon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBehavioralQuestion {
    private static final String QUESTIONS = "Tell me about yourself\n" +
            "Why AWS?\n" +
            "When did you take a risk, make a mistake or fail? How did you respond?\n" +
            "Tell me about a time you failed. How did you deal with the situation?\n" +
            "Tell me about a time you recovered from a difficult situation\n" +
            "Tell me about a time when you had to make a judgment call without having time to refer to a manager/supervisor\n" +
            "Tell me about the conflict with a colleague?\n" +
            "Tell me about a time you received negative feedback from your manager. How did you respond?\n" +
            "Describe a time when you received criticism and how you handled it.\n" +
            "What’s your most successful project?\n" +
            "Describe the most challenging project you’ve worked on so far.\n" +
            "Tell me about a time you took the lead on a difficult project.\n" +
            "Tell me about the complex problem you have worked on\n" +
            "Describe a project that you are particularly proud of. How did it impact your company? What challenges did you encounter and how did you solve them?\n" +
            "Tell me about a time you had to make a decision under pressure to meet a deadline.\n" +
            "A time when you sacrificed short term goals for long term success?\n" +
            "Tell me about the disagreement with your boss.\n" +
            "What is the most significant impact of your work inside a team\n" +
            "What is the most difficult decision you ever took in software\n" +
            "How would you handle a project that is expected to be behind schedule\n" +
            "When you had to pick between different technologies for a project\n" +
            "What is the best invention or idea you had in the past two years\n" +
            "Tell me something interesting you’ve learned recently\n" +
            "Tell me about a time you exceeded your expectations\n" +
            "Tell me a time that you are wrong\n" +
            "Tell me about a tough deadline you have to meet\n";

    public static String pickQuestion(){
        List<String> questions = Arrays.asList(QUESTIONS.split("\n"));
        return questions.get(new Random().nextInt(questions.size()));
    }
}
