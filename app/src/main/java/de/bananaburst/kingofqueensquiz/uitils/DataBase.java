package de.bananaburst.kingofqueensquiz.uitils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Julia on 03.01.2015.
 */
public class DataBase {
    ArrayList<Question> mQuestions = new ArrayList<>();

    public DataBase() {
        mQuestions.add(new Question("Wie heißt Douglas mit zweitem Vornamen?","Steven","Harry","Arnold","Kevin"));
        mQuestions.add(new Question("Wie sollte Carrie eigentlich heißen?","Simone","Selma","Sandy","Verona"));
    }

    public Question getRandomQuestion() {
        return mQuestions.get(new Random().nextInt(mQuestions.size()));
    }
}
