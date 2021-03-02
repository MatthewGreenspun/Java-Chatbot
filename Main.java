import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    String numbers = "0123456789";
    Scanner scanner = new Scanner(System.in);
    System.out.print("Bot: What is your name: ");
    String name = scanner.nextLine();
    System.out.println("Bot: Hello, " + name);
    System.out.println("Bot: I am a chatbot. I can tell you riddles, do some math, and do some other stuff. Type \"help\" to see all of the commands. If you want to stop talking to me, just type \"quit\".");
    while(true) {
      System.out.print(name + ": ");
      String input = scanner.nextLine();
      if(input.equals("quit") || input.equals("leave me alone")) {
        System.out.println("Bot: Goodbye " + name + "!!!");
        break;
      } else if(numbers.indexOf(input.charAt(0)) != -1) {
        solveMathProblem(input);
      } else if(input.equals("change my name")){
        System.out.print("Bot: Alright " + name + ", what should I call you now? ");
        String newName = scanner.nextLine();
        if(newName.equals(name)) 
          System.out.println("Bot: Hey, didn't fool me! That's already your name!");
        else {
          name = newName;
          System.out.println("Bot: Sounds good, " + name);
        }
      } else if(input.equals("tell me a riddle")){
          String[][] riddles = {
            {"What is lighter than a feather but hard to hold? ", "your breath"},
            {"What has 4 legs but cannot walk? ", "a table"},
            {"What has 88 keys but cannot open a single door? ", "a piano"},
            {"What can't be used until it is broken? ", "an egg"}};
          int index = (int)(Math.random()*4);
          System.out.print("Bot: " + riddles[index][0]);
          String answer = scanner.nextLine();
          if(answer.equals(riddles[index][1])) System.out.println("Bot: You got it!");
          else System.out.println("Bot: Nope!");
      } else if(input.equals("compliment me")){
        String[] compliments = {", you are the coolest human I know!",
        ", you are awesome!", ", you are the best!", ", you are doing great things"};
        int index = (int)(Math.random()*4);
        System.out.println("bot: " + name + compliments[index]);
      } else if(input.equals("thanks")){
        System.out.println("Bot: You're welcome!");
      } else if(input.equals("help")){
        System.out.println("Bot: \n- quit\n- leave me alone\n- change my name\n- tell me a riddle\n- compliment me\n- thanks\n- help");
      } else 
        System.out.println("Bot: Sorry, I don't know what that means.");
    }
    scanner.close();
  }

  private static void solveMathProblem(String problem) {
    String numbers = "0123456789";
    String operations = "+-*/";
    String firstNumberStr = "";
    String secondNumberStr = "";
    char operation = '+';
    double firstNumber = 0.0;
    double secondNumber = 0.0;
    for(int i = 0; i < problem.length(); i++){
      if(numbers.indexOf(problem.charAt(i)) != -1 || 
        operations.indexOf(problem.charAt(i)) != -1){
        if(numbers.indexOf(problem.charAt(i)) != -1) {
          if(firstNumber == 0.0) firstNumberStr += problem.charAt(i);
          else secondNumberStr += problem.charAt(i);
        } else {
          if(firstNumber == 0.0) {
            try {
              firstNumber = Integer.parseInt(firstNumberStr);
            } catch(Exception e) {
              System.out.println("Bot: Something went wrong. I guess I'm just not that great at math :(");
            }
            operation = problem.charAt(i);
          }
        }

      } else {
        System.out.println("Bot: Sorry, I don't know what that means. If you want me to do some math, then only use the characters \"0123456789+-*/\".");
        break;
      }
    }
    try {
      secondNumber = Integer.parseInt(secondNumberStr);
      if(operation == '+') System.out.println("Bot: " + (firstNumber + secondNumber));
      else if(operation == '-') System.out.println("Bot: " + (firstNumber - secondNumber));
      else if(operation == '*') System.out.println("Bot: " + (firstNumber * secondNumber));
      else if(operation == '/') System.out.println("Bot: " + (firstNumber / secondNumber));
    } catch(Exception e) {
      System.out.println("Bot: Something went wrong. I guess I'm just not that great at math :(");
    }
  }

}