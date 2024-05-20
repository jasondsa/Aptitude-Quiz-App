package com.azamovhudstc.quizapp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;


import com.azamovhudstc.quizapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Utils {


    public static String formatDate(long time) {
        @SuppressLint({"NewApi", "LocalSuppress"}) SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return formatter.format(calendar.getTime());
    }

    public static Map<String, String> getMathQuestions() {
        HashMap<String, String> questions = new HashMap<>();
        questions.put("4*3", "12");
        questions.put("5*12", "60");
        questions.put("127-45", "82");
        questions.put("y=−6x+8", "78");
        questions.put("43*27", "1161");
        questions.put("175/5", "35");
        questions.put("20/2(5+5) ", "100");
        questions.put("134/2+(12*4)", "115");
        questions.put("56*31", "1736");
        questions.put("1748/76", "23");
        questions.put("3456/432", "8");
        questions.put("23/77", "1771");
        questions.put("32/4", "8");
        questions.put("2892/723", "4");
        questions.put("55/5", "11");

        return questions;
    }

    public static Map<String, String> getRandomMathQuestions(int SIZE) {
        HashMap<String, String> questionsMap = new HashMap<>();
        Map<String, String> originalQuestion = getMathQuestions();
        int originalSize = originalQuestion.size();
        ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

        while (questionsMap.size() <= SIZE) {
            Random random = new Random();
            int randomNumber = random.nextInt(originalSize);
            String question = keyList.get(randomNumber);
            if (!questionsMap.containsKey(question)) {
                questionsMap.put(question, originalQuestion.get(question));
            }
        }
        return questionsMap;
    }

    public static Map<String, Map<String, Boolean>> getVocabularyQuestions() {
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("Ordinary", false);
        answer1.put("Incredible", true);
        answer1.put("Boring", false);
        answer1.put("Common", false);
        questions.put("Select the most appropriate synonym for the word 'Amazing': ", answer1);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("End", false);
        answer2.put("Start", true);
        answer2.put("Finish", false);
        answer2.put("Stop", false);
        questions.put("Find the synonym for 'Begin': ", answer2);

        HashMap<String, Boolean> answer3 = new HashMap<>();
        answer3.put("Tasteless", false);
        answer3.put("Savoury", true);
        answer3.put("Bland", false);
        answer3.put("Unappetizing", false);
        questions.put("Select the word that means the same as 'Delicious':", answer3);

        HashMap<String, Boolean> answer4 = new HashMap<>();
        answer4.put("Serious", false);
        answer4.put("Amusing", true);
        answer4.put("Solemn", false);
        answer4.put("Grave", false);
        questions.put("Choose the correct synonym for 'Funny':", answer4);

        HashMap<String, Boolean> answer5 = new HashMap<>();
        answer5.put("Trivial", false);
        answer5.put("Insignificant", false);
        answer5.put("Vital", true);
        answer5.put("Minor", false);
        questions.put("Find the synonym for 'Important':", answer5);

        HashMap<String, Boolean> answer6 = new HashMap<>();
        answer6.put("Dull", false);
        answer6.put("Boring", false);
        answer6.put("Intriguing", true);
        answer6.put("Tedious", true);
        questions.put("Select the word that means the same as 'Interesting':", answer6);

        HashMap<String, Boolean> answer7 = new HashMap<>();
        answer7.put("Exacerbate", false);
        answer7.put("Alleviate", true);
        answer7.put("Aggravate", false);
        answer7.put("Intensify", false);
        questions.put("Which word means 'to make something less severe'?", answer7);

        HashMap<String, Boolean> answer8 = new HashMap<>();
        answer8.put("Delay", false);
        answer8.put("Hinder", false);
        answer8.put("Expedite", true);
        answer8.put("Procrastinate", false);
        questions.put("Which word means 'to make something happen sooner or more quickly'?", answer8);

        HashMap<String, Boolean> answer9 = new HashMap<>();
        answer9.put("Obscure", false);
        answer9.put("Confuse", false);
        answer9.put("Clarify", true);
        answer9.put("Complicate", false);
        questions.put("Which word means 'to make something clear or easier to understand'?", answer9);


        HashMap<String, Boolean> answer10 = new HashMap<>();
        answer10.put("Contract", false);
        answer10.put("Diminish", false);
        answer10.put("Expand", true);
        answer10.put("Shrink", false);

        questions.put("Which word means 'to increase in size or volume'?", answer10);


        HashMap<String, Boolean> answer11 = new HashMap<>();
        answer11.put("since", false);
        answer11.put("for", true);
        answer11.put("during", false);
        answer11.put("in", false);
        questions.put("Which word correctly completes the sentence: 'He has been working here ___ five years'?", answer11);


        HashMap<String, Boolean> answer12 = new HashMap<>();
        answer12.put("since", true);
        answer12.put("for", false);
        answer12.put("during", false);
        answer12.put("in", false);
        questions.put("Which word correctly completes the sentence: 'I have lived in this city ___ 2002'?", answer12);

        HashMap<String, Boolean> answer13 = new HashMap<>();
        answer13.put("She have gone to the market.", false);
        answer13.put("She has gone to the market.", false);
        answer13.put("She is gone to the market.", false);
        answer13.put("She are gone to the market.", false);
        questions.put("Which sentence uses the correct form of the verb?", answer13);

        HashMap<String, Boolean> answer14 = new HashMap<>();
        answer14.put("I have been to the cinema last night.", false);
        answer14.put("I went to the cinema last night.", true);
        answer14.put("I go to the cinema last night.", false);
        answer14.put("I was going to the cinema last night.", false);
        questions.put("Which sentence is correct?", answer14);

        HashMap<String, Boolean> answer15 = new HashMap<>();
        answer15.put("in", true);
        answer15.put("on", false);
        answer15.put("at", false);
        answer15.put("to", false);
        questions.put("He succeeded ___ passing the exam.", answer15);

        return questions;
    }


    public static Map<String, Map<String, Boolean>> getLogicalReasoningQuestions() {

        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("3, 1, 4, 5, 2", true);
        answer1.put("1, 2, 4, 3, 5", false);
        answer1.put("5, 4, 3, 2, 1", false);
        answer1.put("3, 1, 2, 4, 5", false);
        questions.put("Arrange the words in a meaningful sequence: 1. Police 2. Punishment 3. Crime 4. Judge 5. Judgment", answer1);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("Assumption I is implied", true);
        answer2.put("Assumption II is implied", false);
        answer2.put("Either I or II is implied", false);
        answer2.put("Neither I nor II is implied", false);
        questions.put("Statement: French language learning should be started in school. \nAssumptions: \n1. French language is easy to learn \n2. Learning French helps in getting a job", answer2);

        HashMap<String, Boolean> answer3 = new HashMap<>();
        answer3.put("All mangoes are golden in color", false);
        answer3.put("No golden-colored things are mangoes", false);
        answer3.put("Some mangoes are golden in color", true);
        answer3.put("All golden-colored things are mangoes", false);
        questions.put("Statements: All mangoes are golden in color. No golden-colored things are apples. \nConclusions: \n1. All mangoes are apples. \n2. No apples are golden in color.", answer3);

        HashMap<String, Boolean> answer4 = new HashMap<>();
        answer4.put("Peter is in the East of Mike", false);
        answer4.put("Mike is in the South of Peter", true);
        answer4.put("Peter is in the North of Mike", false);
        answer4.put("Mike is in the East of Peter", false);
        questions.put("Peter is in the East of Tom and Tom is in the North of John. Mike is in the South of John. In which direction of Peter is Mike?", answer4);

        HashMap<String, Boolean> answer5 = new HashMap<>();
        answer5.put("A kilogram", true);
        answer5.put("A meter", false);
        answer5.put("A liter", false);
        answer5.put("A second", false);
        questions.put("Which word does not belong to the group: A kilogram, A meter, A liter, A second?", answer5);

        HashMap<String, Boolean> answer6 = new HashMap<>();
        answer6.put("1", false);
        answer6.put("2", true);
        answer6.put("3", false);
        answer6.put("4", false);
        questions.put("Which of the following diagrams correctly represents lions, elephants, and animals? \n1) Lions and elephants have no relationship to each other, but both are animals. \n2) Lions and elephants are both animals, but they are not related to each other. \n3) Lions and elephants are both animals and are related to each other. \n4) Lions and elephants are not animals.", answer6);

        HashMap<String, Boolean> answer7 = new HashMap<>();
        answer7.put("1, 3, 2, 4, 5", true);
        answer7.put("1, 3, 2, 5, 4", false);
        answer7.put("1, 2, 3, 4, 5", false);
        answer7.put("1, 2, 3, 5, 4", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Infection 2. Consultation 3. Doctor 4. Treatment 5. Recovery?", answer7);

        HashMap<String, Boolean> answer8 = new HashMap<>();
        answer8.put("3, 5, 1, 4, 2", true);
        answer8.put("3, 5, 1, 2, 4", false);
        answer8.put("3, 1, 5, 4, 2", false);
        answer8.put("3, 1, 4, 5, 2", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Presentation 2. Recommendation 3. Arrival 4. Discussion 5. Introduction?", answer8);

        HashMap<String, Boolean> answer9 = new HashMap<>();
        answer9.put("1", false);
        answer9.put("2", true);
        answer9.put("3", false);
        answer9.put("4", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Birth 2. Death 3. Education 4. Career 5. Marriage?", answer9);

        HashMap<String, Boolean> answer10 = new HashMap<>();
        answer10.put("1", false);
        answer10.put("2", true);
        answer10.put("3", false);
        answer10.put("4", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Seed 2. Plant 3. Tree 4. Fruit 5. Flower?", answer10);

        // New questions to replace the repeated ones
        HashMap<String, Boolean> answer11 = new HashMap<>();
        answer11.put("1, 5, 3, 4, 2", true);
        answer11.put("1, 3, 5, 4, 2", false);
        answer11.put("1, 5, 3, 2, 4", false);
        answer11.put("1, 3, 4, 5, 2", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Morning 2. Night 3. Afternoon 4. Evening 5. Noon?", answer11);

        HashMap<String, Boolean> answer12 = new HashMap<>();
        answer12.put("5, 1, 2, 3, 4", true);
        answer12.put("1, 2, 3, 4, 5", false);
        answer12.put("5, 1, 3, 2, 4", false);
        answer12.put("1, 3, 2, 4, 5", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Country 2. State 3. City 4. Village 5. Continent?", answer12);

        HashMap<String, Boolean> answer13 = new HashMap<>();
        answer13.put("3, 1, 4, 2, 5", true);
        answer13.put("1, 3, 4, 2, 5", false);
        answer13.put("3, 4, 1, 2, 5", false);
        answer13.put("3, 1, 2, 4, 5", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Child 2. Adult 3. Infant 4. Adolescent 5. Elderly?", answer13);

        HashMap<String, Boolean> answer14 = new HashMap<>();
        answer14.put("3, 5, 1, 4, 2", true);
        answer14.put("1, 3, 5, 4, 2", false);
        answer14.put("3, 1, 5, 4, 2", false);
        answer14.put("3, 5, 4, 1, 2", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Reading 2. Writing 3. Listening 4. Speaking 5. Understanding?", answer14);

        HashMap<String, Boolean> answer15 = new HashMap<>();
        answer15.put("2, 4, 1, 3, 5", true);
        answer15.put("1, 2, 3, 4, 5", false);
        answer15.put("2, 1, 4, 3, 5", false);
        answer15.put("1, 3, 2, 4, 5", false);
        questions.put("Which of the following is the correct logical sequence of words: 1. Examination 2. Admission 3. Result 4. Study 5. Degree? ", answer15);

        return questions;

    }

    public static Map<String, Map<String, Boolean>> getProgrammingQuestions() {
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("int", true);
        answer1.put("float", false);
        answer1.put("boolean", false);
        answer1.put("double", false);
        questions.put("What is the default data type of numbers in Java?", answer1);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("for", true);
        answer2.put("while", false);
        answer2.put("do-while", false);
        answer2.put("switch", false);
        questions.put("Which loop is best for iterating through an array in Java?", answer2);

        HashMap<String, Boolean> answer3 = new HashMap<>();
        answer3.put("malloc()", false);
        answer3.put("alloc()", false);
        answer3.put("new", true);
        answer3.put("create", false);
        questions.put("Which keyword is used to allocate memory for an object in Java?", answer3);

        HashMap<String, Boolean> answer4 = new HashMap<>();
        answer4.put("Inheritance", true);
        answer4.put("Encapsulation", false);
        answer4.put("Polymorphism", false);
        answer4.put("Abstraction", false);
        questions.put("Which OOP concept is used to derive a class from another class?", answer4);

        HashMap<String, Boolean> answer5 = new HashMap<>();
        answer5.put("==", false);
        answer5.put("equals()", true);
        answer5.put("compareTo()", false);
        answer5.put("equalsString()", false);
        questions.put("Which method is used to compare two strings for their content equality in Java?", answer5);

        HashMap<String, Boolean> answer6 = new HashMap<>();
        answer6.put("Array", false);
        answer6.put("Linked List", false);
        answer6.put("Stack", true);
        answer6.put("Queue", false);
        questions.put("Which data structure follows Last In First Out (LIFO) principle?", answer6);

        HashMap<String, Boolean> answer7 = new HashMap<>();
        answer7.put("public", false);
        answer7.put("private", false);
        answer7.put("protected", false);
        answer7.put("static", true);
        questions.put("Which keyword is used to define a method that belongs to the class, rather than any instance of the class?", answer7);

        HashMap<String, Boolean> answer8 = new HashMap<>();
        answer8.put("Runtime Error", false);
        answer8.put("Syntax Error", true);
        answer8.put("Logical Error", false);
        answer8.put("Compilation Error", false);
        questions.put("What type of error is caused by missing a semicolon at the end of a statement in C++?", answer8);

        HashMap<String, Boolean> answer9 = new HashMap<>();
        answer9.put("Abstract Class", true);
        answer9.put("Interface", false);
        answer9.put("Concrete Class", false);
        answer9.put("Enum", false);
        questions.put("Which type of class in Java cannot be instantiated?", answer9);

        HashMap<String, Boolean> answer10 = new HashMap<>();
        answer10.put("Function", false);
        answer10.put("Method", true);
        answer10.put("Procedure", false);
        answer10.put("Routine", false);
        questions.put("What is a function defined inside a class called in Java?", answer10);

        HashMap<String, Boolean> answer11 = new HashMap<>();
        answer11.put("Garbage Collection", true);
        answer11.put("Memory Leak", false);
        answer11.put("Stack Overflow", false);
        answer11.put("Buffer Overflow", false);
        questions.put("What mechanism automatically handles the deletion of objects when they are no longer needed in Java?", answer11);

        HashMap<String, Boolean> answer12 = new HashMap<>();
        answer12.put("0", true);
        answer12.put("1", false);
        answer12.put("-1", false);
        answer12.put("Undefined", false);
        questions.put("What is the default value of an int variable in a class in Java?", answer12);

        HashMap<String, Boolean> answer13 = new HashMap<>();
        answer13.put("try-catch", true);
        answer13.put("if-else", false);
        answer13.put("throw-throws", false);
        answer13.put("finally", false);
        questions.put("Which block is used to handle exceptions in Java?", answer13);

        HashMap<String, Boolean> answer14 = new HashMap<>();
        answer14.put("Dynamic Binding", true);
        answer14.put("Static Binding", false);
        answer14.put("Both A and B", false);
        answer14.put("None of the above", false);
        questions.put("Which type of binding is used when the method to be called is determined at runtime?", answer14);

        HashMap<String, Boolean> answer15 = new HashMap<>();
        answer15.put("Recursion", true);
        answer15.put("Iteration", false);
        answer15.put("Selection", false);
        answer15.put("Sequence", false);
        questions.put("What is the process of a function calling itself called?", answer15);

        return questions;
    }


    public static Map<String, Map<String, Boolean>> getLiteratureQuestions() {
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("Maya Angelou", true);
        answer1.put("Robert Hass", false);
        answer1.put("Jessica Hagdorn", false);
        answer1.put("Micheal Palmer", false);
        questions.put("Which American writer published ‘A brave and startling truth’ in 1996", answer1);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("Acrostic ", true);
        answer2.put("Haiku", false);
        answer2.put("Epic", false);
        answer2.put("Alliterative", false);
        questions.put("What is a poem called whose first letters of each line spell out a word?", answer2);

        HashMap<String, Boolean> answer3 = new HashMap<>();
        answer3.put("Limerick", true);
        answer3.put("Quartet", false);
        answer3.put("Sextet", false);
        answer3.put("Palindrome", false);
        questions.put("What is a funny poem of five lines called?", answer3);

        HashMap<String, Boolean> answer4 = new HashMap<>();
        answer4.put("Robert Greene", true);
        answer4.put("John Milton", false);
        answer4.put("Philip Sidney", false);
        answer4.put("Christopher Marlowe", false);
        questions.put("Who succeeded Lyly?", answer4);

        HashMap<String, Boolean> answer5 = new HashMap<>();
        answer5.put("Hamlet", true);
        answer5.put("Cymbeline", false);
        answer5.put("Titus Andronicus", false);
        answer5.put("Pericles, Prince of Tyre", false);
        questions.put("Which famous Shakespeare play does the quote,”Neither a borrower nor a lender be” come from?", answer5);

        HashMap<String, Boolean> answer6 = new HashMap<>();
        answer6.put("16th", true);
        answer6.put("17th", false);
        answer6.put("14th", false);
        answer6.put("15th", false);
        questions.put("In which century was Shakespeare born?", answer6);

        HashMap<String, Boolean> answer7 = new HashMap<>();
        answer7.put("A thief", true);
        answer7.put("A clerk", false);
        answer7.put("A teacher", false);
        answer7.put("A dentist", false);
        questions.put("Who is Mr. Tench in The Power and the Glory?", answer7);

        HashMap<String, Boolean> answer8 = new HashMap<>();
        answer8.put("Coleridge", true);
        answer8.put("Wordsworth", false);
        answer8.put("Lamb", false);
        answer8.put("Shelley", false);
        questions.put("Who said ‘Keats was a Greek’?", answer8);

        HashMap<String, Boolean> answer9 = new HashMap<>();
        answer9.put("Gertrude", true);
        answer9.put("Beatrice", false);
        answer9.put("Margaret", false);
        answer9.put("Rosalind", false);
        questions.put("Which of the following is Hamlet’s mother?", answer9);

        HashMap<String, Boolean> answer10 = new HashMap<>();
        answer10.put("Stingy", true);
        answer10.put("Rude", false);
        answer10.put("Unintelligent", false);
        answer10.put("Fanatic", false);
        questions.put("Which of the following was Elizabeth known as?", answer10);

        HashMap<String, Boolean> answer11 = new HashMap<>();
        answer11.put("Keats", true);
        answer11.put("Blake", false);
        answer11.put("Tennyson", false);
        answer11.put("Shelley", false);
        questions.put("For whom it is said: “sensuousness is a paramount bias of his genius”:", answer11);

        HashMap<String, Boolean> answer12 = new HashMap<>();
        answer12.put("Maud", true);
        answer12.put("Ulysses", false);
        answer12.put("Break, Break, Break", false);
        answer12.put("Crossing the Bar", false);
        questions.put("Which of the following poems by Tennyson is a monodrama?", answer12);

        HashMap<String, Boolean> answer13 = new HashMap<>();
        answer13.put("Southey", true);
        answer13.put("Tennyson", false);
        answer13.put("Byron", false);
        answer13.put("Wordsworth", false);
        questions.put("Which one of the following poets was appointed Poet Laureate in the year 1813?", answer13);

        HashMap<String, Boolean> answer14 = new HashMap<>();
        answer14.put("Wordsworth", true);
        answer14.put("Keats", false);
        answer14.put("Byron", false);
        answer14.put("Blake", false);
        questions.put("Who believed that poetry is the spontaneous overflow of emotions?", answer14);

        HashMap<String, Boolean> answer15 = new HashMap<>();
        answer15.put("Dickens", true);
        answer15.put("George Eliot", false);
        answer15.put("Hardy", false);
        answer15.put("None of the above", false);
        questions.put("Moral choice is everything in the works of:", answer15);

        return questions;
    }

    public static Map<String, Map<String, Boolean>> getGeographyQuestions() {
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answer1 = new HashMap<>();
        answer1.put("3", false);
        answer1.put("6", false);
        answer1.put("12", true);
        answer1.put("1", false);
        questions.put("4*3 ?", answer1);

        HashMap<String, Boolean> answer2 = new HashMap<>();
        answer2.put("60", true);
        answer2.put("12", false);
        answer2.put("53", false);
        answer2.put("14", false);
        questions.put("5*12 ?", answer2);

        HashMap<String, Boolean> answer3 = new HashMap<>();
        answer3.put("116", false);
        answer3.put("115", true);
        answer3.put("112", false);
        answer3.put("113", false);
        questions.put("134/2+(12*4) ?", answer3);

        HashMap<String, Boolean> answer4 = new HashMap<>();
        questions.put("2892/723 ?", answer4);
        answer4.put("5", false);
        answer4.put("16", true);
        answer4.put("4", false);
        answer4.put("15", false);

        HashMap<String, Boolean> answer5 = new HashMap<>();
        answer5.put("13", false);
        answer5.put("12", false);
        answer5.put("5", false);
        answer5.put("11", true);
        questions.put("55/5 ? ", answer5);

        HashMap<String, Boolean> answer6 = new HashMap<>();
        answer6.put("101", false);
        answer6.put("131", false);
        answer6.put("100", true);
        answer6.put("112", false);
        questions.put("20/2(5+5) ?", answer6);

        HashMap<String, Boolean> answer7 = new HashMap<>();
        answer7.put("1161", true);
        answer7.put("123", false);
        answer7.put("1421", false);
        answer7.put("1612", false);
        questions.put("43*27?", answer7);

        HashMap<String, Boolean> answer8 = new HashMap<>();
        answer8.put("82", true);
        answer8.put("83", false);
        answer8.put("84", false);
        answer8.put("85", false);
        questions.put("127-45?", answer8);

        HashMap<String, Boolean> answer9 = new HashMap<>();
        answer9.put("-4a + 22b", true);
        answer9.put("4a + 22b", false);
        answer9.put("28a + 30b", false);
        answer9.put("-28a + 30b", false);
        questions.put("12a + 26b -4b – 16a ?", answer9);

        HashMap<String, Boolean> answer10 = new HashMap<>();
        answer10.put(" -1", false);
        answer10.put("2", true);
        answer10.put("–2", false);
        answer10.put("6", false);
        questions.put("(4 – 5) – (13 – 18 + 2) ?", answer10);


        HashMap<String, Boolean> answer12 = new HashMap<>();
        answer12.put("25", false);
        answer12.put("24", false);
        answer12.put("17", false);
        answer12.put("13", true);
        questions.put("3 + 2 * (8 – 3)?", answer12);

        HashMap<String, Boolean> answer13 = new HashMap<>();
        answer13.put("7", false);
        answer13.put("5", false);
        answer13.put("9", true);
        answer13.put("8", false);
        questions.put("3^(4)÷3^(2) ?", answer13);


        return questions;
    }

    public static Map<String,Map<String,Boolean>> getRandomLiteratureAndGeographyQuestions(Context context, String subject, int SIZE){

        Map<String,Map<String,Boolean>> questionsMap = new HashMap<>();
        Map<String, Map<String, Boolean>> originalQuestion = new HashMap<>();
            if(subject.equals(context.getString(R.string.vocabulary))){
                originalQuestion = getVocabularyQuestions();
            } else if (subject.equals(context.getString(R.string.logical_reasoning))){
                originalQuestion = getLogicalReasoningQuestions();
            } else if (subject.equals(context.getString(R.string.geography))) {
                originalQuestion = getGeographyQuestions();
            }
            else if (subject.equals(context.getString(R.string.programming))) {
                originalQuestion = getProgrammingQuestions();
            }
            int originalSize =  originalQuestion.size();
            ArrayList<String> keyList = new ArrayList<String>(originalQuestion.keySet());

            while (questionsMap.size()<=SIZE){
                Random random = new Random();
                int randomNumber = random.nextInt(originalSize);
                String question = keyList.get(randomNumber);
                if (!questionsMap.containsKey(question)){
                    questionsMap.put(question,originalQuestion.get(question));
                }
            }

        return questionsMap;
    }
}
