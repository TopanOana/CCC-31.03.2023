import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {

    public Service() {
    }


    public String lastFighterStanding(int nrFighters, String tournament){
        String finalString = "";
        while (tournament.length()>1){
            finalString="";
            for (int i=0;i<tournament.length()-1;i+=2){
                Fighter f1 = new Fighter(String.valueOf(tournament.charAt(i)));
                Fighter f2 = new Fighter(String.valueOf(tournament.charAt(i+1)));

                finalString += f1.match(f2).getStyle();
            }
            tournament = finalString;
        }
        return finalString;
    }

    public String notgoodgenerate(int nrFighters, int nrRock, int nrPaper, int nrScissors){
        String finalString = "";
        //first RRRP
        int numberRounds = (int)(Math.log(nrFighters) / Math.log(2));
        int index=numberRounds;
        while (index>1){
            if (nrRock>=Math.pow(2,index)-1 && nrPaper>=2) {
                String str = "R";
                finalString += str.repeat((int) (Math.pow(2,index)-1));
                finalString+="P";
                nrRock -= (int) (Math.pow(2,index)-1);
                nrPaper -=1;
            }
            index--;
        }
        index=numberRounds;
        while (nrRock>=1 && nrScissors>=2){
            finalString+="RS";
            nrRock-=1;
            nrScissors-=1;
        }
        while (nrPaper>=0)
        {
            finalString+="P";
            nrPaper-=1;
        }
//        while (nrRock>=numberRounds && nrPaper>=1 && nrScissors>=numberRounds+1){
//
//            finalString += "RP";
//            for (int i=0;i<numberRounds-1;i++)
//                finalString+="RS";
//            nrRock-=numberRounds;
//            nrPaper-=1;
//            nrScissors-=numberRounds-1;
//        }
//        while(nrRock>=numberRounds && nrPaper>=numberRounds){
//            for(int i=0;i<numberRounds;i++)
//                finalString +="RP";
//            nrRock-=numberRounds;
//            nrPaper-=numberRounds;
//        }
//        while(nrRock>=1 && nrPaper>=2 && nrScissors>=1){
//            finalString += "RPPS";
//            nrRock-=1;
//            nrPaper-=2;
//            nrScissors-=1;
//        }
//        if(nrRock == 1 && nrPaper == 1)
//        {
//            finalString += "RP";
//            nrRock-=1;
//            nrPaper-=1;
//        }
//        //more R less P
//
//        //no more R
//        while(nrPaper>0){
//            finalString+="P";
//            nrPaper-=1;
//        }
        while(nrScissors>0){
            finalString+="S";
            nrScissors-=1;
        }
        return finalString;
    }


    public String generateLevel4(int nrFighters, int nrRock, int nrPaper, int nrScissors){
        String finalString = "";
        int nr = (int)(Math.log(nrFighters) / Math.log(2))-1;
//        System.out.println(nr);
        while(nr>0 && nrRock>0){
            if (nrRock>=Math.pow(2,nr)-1 && nrPaper>=1){
                finalString += "P";
                String str = "R";
                finalString += str.repeat((int) (Math.pow(2,nr)-1));
                nrRock -= (int) (Math.pow(2,nr)-1);
                nrPaper -=1;
            } else{
                if (nrPaper>=(int)Math.pow(2,nr)-nrRock && (int)Math.pow(2,nr)-nrRock>0 ){
                    String str = "R";
                    finalString += str.repeat((int) nrRock);
                    str = "P";
                    int pp = (int)Math.pow(2,nr)-nrRock;
//                    if()
                    finalString += str.repeat((int) pp);
                    nrPaper -= pp;
                    nrRock=0;
                }


            }
            nr--;
        }

        while(nrRock>0){
            nrRock--;
            finalString+="R";
        }

        while(nrPaper>0){
            nrPaper--;
            finalString+="P";
        }

        while(nrScissors>0){
            nrScissors--;
            finalString+="S";
        }

        return finalString;
    }


    public String generateLevel5(int nrFighters, int nrRock, int nrPaper, int nrScissors, int nrL, int nrY){
        String finalString = "";
//        int nr = (int)(Math.log(nrFighters) / Math.log(2))-1;
////        System.out.println(nr);
//        while(nr>0 && nrRock>0){
//            if (nrRock>=Math.pow(2,nr)-1 && nrPaper>=1){
//                finalString += "P";
//                String str = "R";
//                finalString += str.repeat((int) (Math.pow(2,nr)-1));
//                nrRock -= (int) (Math.pow(2,nr)-1);
//                nrPaper -=1;
//            } else{
//                if (nrPaper>=(int)Math.pow(2,nr)-nrRock && (int)Math.pow(2,nr)-nrRock>0 ){
//                    String str = "R";
//                    finalString += str.repeat((int) nrRock);
//                    str = "P";
//                    int pp = (int)Math.pow(2,nr)-nrRock;
////                    if()
//                    finalString += str.repeat((int) pp);
//                    nrPaper -= pp;
//                    nrRock=0;
//                }
//
//
//            }
//            nr--;
//        }
        while(nrScissors>0){
            nrScissors--;
            finalString+="S";
        }

        while(nrL>0){
            nrL--;
            finalString+="L";
        }
        while(nrPaper>0){
            nrPaper--;
            finalString+="P";
        }

        while(nrY>0){
            nrY--;
            finalString+="Y";
        }
        while(nrRock>0){
            nrRock--;
            finalString+="R";
        }





        return finalString;
    }



//    public String generateFirst(int nrFighters, int )

//    public boolean conditionFin(String tournament){
//        return lastStanding(tournament.length(),tournament) == "S";
//    }

//    public String jegBack(int nrFighters, int length, int nrRocks, int nrPaper, int nrScissors, String aux){
//        if(nrFighters==0){
//        }
//
//    }



    public void mainAction(){

        try {
            File input = new File("C:/Users/oanam/IdeaProjects/CCC31MARCH/src/input.txt");
            File output = new File("C:/Users/oanam/IdeaProjects/CCC31MARCH/src/output.txt");
            Scanner scanner = new Scanner(input);
            FileWriter out = new FileWriter(output);

            String firstLine = scanner.nextLine();
            List<String> prim = Arrays.stream(firstLine.split(" ", 0)).toList();
            int N = Integer.valueOf(prim.get(0).trim());
            int M = Integer.valueOf(prim.get(1).trim());

            while (N>0){

                List<String> tourneu = Arrays.stream(scanner.nextLine().split(" ")).toList();
                int nrRock = Integer.valueOf(tourneu.get(0).substring(0, tourneu.get(0).length()-1));
                int nrPaper = Integer.valueOf(tourneu.get(1).substring(0, tourneu.get(1).length()-1));
                int nrScissors = Integer.valueOf(tourneu.get(2).substring(0, tourneu.get(2).length()-1));
                int nrLiz = Integer.valueOf(tourneu.get(3).substring(0, tourneu.get(3).length()-1));
                int nrY = Integer.valueOf(tourneu.get(4).substring(0, tourneu.get(4).length()-1));
                if (N==33) {
                    int i=0;}
                String tournament = this.generateLevel5(M,nrRock,nrPaper,nrScissors, nrLiz, nrY);
                out.write(lastFighterStanding(M,tournament));
                out.write(":->");
                out.write(tournament);
                out.write("\n");

                N--;
            }
            scanner.close();
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
