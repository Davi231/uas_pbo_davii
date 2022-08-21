import java.util.Scanner;
class Main{
    
    public static void main(String[] args){
        Questions quest = new Questions();
        Scanner myObj = new Scanner(System.in);
        Player player = new Player();

        System.out.println("");
        System.out.println("");
        System.out.println("====== Selamat Datang di Game Quizz master ======");
        System.out.println("Isi Nama Anda");
        String name = myObj.nextLine();
        player.SetName(name);

        for (int i = 0; i < quest.GetQuestionLength(); i++) {
            String q=quest.GetQuestion(i).question;
            String a=quest.GetQuestion(i).answer;
            System.out.println("Jawab Pertanyaan ini : "+q);
            String answer=myObj.nextLine();
            if(answer.equals(a)){
                System.out.println("Yeah Correct");
                player.IncrementCorrectAnswer();
            }else{
                System.out.println("oops wrong, the correct is "+a);
                player.IncrementWrongAnswer();
            }
        }
        System.out.println("====== Game Over ======");
        System.out.println("Name    : "+player.GetName());
        System.out.println("Correct Answer   : "+ player.GetCorrectAnswer());
        System.out.println("Wrong Answer   : "+ player.GetWrongAnswer());
        System.out.println("Your Score : "+player.CalculateScore(quest.GetQuestionLength()));

        myObj.close();

        System.out.println("");
        System.out.println("");


        

    }
}


class Player{
    String name="";
    int correctAnswer=0;
    int wrongAnswer=0;

    public void SetName(String name){
        this.name=name;
    }

    public String GetName(){
        return this.name;
    }

    public int GetCorrectAnswer(){
        return this.correctAnswer;
    }

    public int GetWrongAnswer(){
        return this.wrongAnswer;
    }

    public void IncrementCorrectAnswer(){
        this.correctAnswer++;
    }
    public void IncrementWrongAnswer(){
        this.wrongAnswer++;
    }

    public float CalculateScore(int q_length){
        return (((float) this.correctAnswer) / q_length)*100;
    }
}

class Question{
    String question;
    String answer;
    Question(String q,String a){
        this.question=q;
        this.answer=a;
    }
}

class Questions {
    Question[] list_q= new Question[3];
    Questions(){
        list_q[0]= new Question("1+1?", "2");
        list_q[1]= new Question("Ibu Kota Jawa Barat?", "Bandung");
        list_q[2]= new Question("4*10?", "40");
    }

    public Question GetQuestion(int index){
        return list_q[index];
    }
    public int GetQuestionLength(){
        return list_q.length;
    }
}

