package de.bananaburst.kingofqueensquiz.uitils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Julia on 03.01.2015.
 */
public class DataBase {
    private ArrayList<Question> mQuestions = new ArrayList<>();
    private int mCurrentQuestion;

    public DataBase() {
        mQuestions.add(new Question("Wie heißt Douglas mit zweitem Vornamen?", "Steven", "Harry", "Arnold", "Kevin"));
        mQuestions.add(new Question("Wie sollte Carrie eigentlich heißen?", "Simone", "Selma", "Sandy", "Verona"));
        mQuestions.add(new Question("Was ist Carrie's Lebenswunsch, seid sie klein war?", "Ein Apartment in der City", "Ein schwarzer Hund", "Das Arthur auszieht", "Das Doug erwachsener wird"));
        mQuestions.add(new Question("Doug kauft in einer Folge ein Auto ohne Carrie um Erlaubnis zu fragen, welches war dieses?", "Jeep Cherokee silber", "Vw Golf rot", "Ein Mercedes Benz silber", "Vw Lupo rot"));
        mQuestions.add(new Question("Was isst Carrie gar nicht gerne?", "Kapern", "Jodl", "Rote Äpfel", "Pudding-Mohnkuchen"));
        mQuestions.add(new Question("Wie viele Frühlingsrollen isst Doug beim Wettessen?", "14", "12", "13", "15"));
        mQuestions.add(new Question("Was klebt an Dougs Weihnachtspullover aus 'längst vergangenen Weihnachtstagen'?", "Zuckerstange", "Jodl", "Minzbonbon", "Donut"));
        mQuestions.add(new Question("Wie heißt Carries Arbeitsehemann?", "Kurt", "Evan", "Steve", "Kevin"));
        mQuestions.add(new Question("Wie heißt Spences Hund?", "Allen", "Rocky", "Evan", "Spike"));
        mQuestions.add(new Question("Worauf soll Deacon im Coopers einschlagen?", "Rippchen", "Steak", "Burger", "Nachos"));
        mQuestions.add(new Question("Was spuckt der Sohn von Mr. Kaplan auf Carries 'geliehenes' Kleid?", "Pürierte Blaubeeren", "Pürierte Erdbeeren", "Pürierte Pflaumen", "Grießbrei"));
        mQuestions.add(new Question("Doug und Carrie beschließen sich von ihrem Ersparten eine Belohnung zu gönnen. Was kauft sich Doug?", "Mundharmonika", "Schlagzeug", "Schlitten", "Kamera"));

        shuffleList();
    }

    public Question getRandomQuestion() {
        return mQuestions.get(new Random().nextInt(mQuestions.size()));
    }

    public void shuffleList() {
        Collections.shuffle(mQuestions);
    }

    public Question getNextQuestion() {
        if (mCurrentQuestion < mQuestions.size()) {
            Question nextQuestion = mQuestions.get(mCurrentQuestion);
            mCurrentQuestion++;
            return nextQuestion;
        } else {
            mCurrentQuestion = 0;
            shuffleList();
            return getNextQuestion();
        }
    }
}
