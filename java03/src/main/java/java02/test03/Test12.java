/* update 명령어 처리 구현
 */
package java02.test03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Test12 {
  static Scanner scanner; 
  static ArrayList<Score12> list = new ArrayList<Score12>(); 

  // Entity 클래스 => 사용자(개발자) 정의 데이터 타입 
  
  
  public static void main(String[] args) {

    scanner = new Scanner(System.in);

    loop: 
    while (true) {
      try {
        String[] token = promptCommand();

        switch (token[0]) {
        case "add":
          doAdd(token);
          break;
        case "list":
          dolist();
          break;
        case "view":
          doView(Integer.parseInt(token[1]));
          break;
        case "delete":
          doDelete(Integer.parseInt(token[1]));
          break;
        case "update":
          doUpdate(Integer.parseInt(token[1]));
          break;
        case "help":
          doHelp();
          break;
        case "exit":
          System.out.println("파일에 저장하였습니다.");
          break loop;
        default:
          System.out.println("이 명령어를 지원하지 않습니다.");
        }

      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
      }
    }
    scanner.close();


  }
  
  private static void doUpdate(int index) {
    if(!isValid(index)) return;
    Score12 score = list.get(index);
    Score12 tempScore = new Score12(score.getName(), score.getKor(),
        score.getEng(), score.getMath());
    String test = null;
    System.out.printf("이름(%s) : ", score.getName());
    test = scanner.nextLine();
    if(test.length() > 0)
      tempScore.setName(test);
    

    System.out.printf("국어(%d) : ", score.getKor());
    test = scanner.nextLine();
    if(test.length() > 0)
      tempScore.setKor(Integer.parseInt(test));
    
    System.out.printf("영어(%d) : ", score.getEng());
    test = scanner.nextLine();
    if(test.length() > 0)
      tempScore.setEng(Integer.parseInt(test));
    
    System.out.printf("수학(%d) : ", score.getMath());
    test = scanner.nextLine();
    if(test.length() > 0)
      tempScore.setMath(Integer.parseInt(test));
    
    System.out.print( "정말 변경하시겠습니까?(y/n)");
    if(scanner.nextLine().equalsIgnoreCase("y")){
      list.set(index, tempScore);
      System.out.println("변경 하였습니다.");
    }else{
      System.out.println("변경 취소 하였습니다.");
    }
  }

  private static boolean isValid(int index){

    if(index< 0 || index >= list.size()){
      System.out.println("존재하지 않는 인덱스 입니다.");
      return false;      
    }else
      return true;
    
  }

  private static void doView(int index) {
    if(!isValid(index)){
      return;
    }
    Score12 score = list.get(index);
    System.out.println("인덱스 : " + index);
    System.out.println("이름 : " + score.getName());
    System.out.println("국어 : " + score.getKor());
    System.out.println("영어 : " + score.getEng());
    System.out.println("수학 : " + score.getMath());
    System.out.println("총점 : " + score.getSum());
    System.out.println("평균 : " + score.getAverage());
  }

  private static void doDelete(int index) {
    if(!isValid(index)){
      return;
    }
    Score12 score = list.get(index);
    System.out.print(score.getName() + "의 성적을 삭제하겠습니까? (y/n)");
    if(scanner.nextLine().equalsIgnoreCase("y")){
      list.remove(index);
      System.out.println("삭제 하였습니다.");
    }else{
      System.out.println("삭제 취소 하였습니다.");
    }
    
  }

  private static void doHelp() {
    System.out.println("list");
    System.out.println("view 인덱스");
    System.out.println("add 이름 국어 영어 수학");
    System.out.println("delete 인덱스");
    System.out.println("update 인덱스");
    System.out.println("exit");
  }

  private static void doAdd(String[] token) {
    Score12 score = new Score12(token[1], 
        Integer.parseInt(token[2]), 
        Integer.parseInt(token[3]), 
        Integer.parseInt(token[4]));
         list.add(score);
         System.out.println("저장되었습니다.");
  }
  private static void dolist() {
    int index = 0;
    for (Score12 score : list){
      System.out.printf("%-3d %-10s %3d %3d %3d\n",
      index, score.getName(), score.getKor()
      , score.getEng(), score.getMath());
      index ++;
    }
    
  }  

  private static String[] promptCommand() {
    System.out.print("명령>");
    String[] token = scanner.nextLine().split(" ");
    return token;
  }
}







