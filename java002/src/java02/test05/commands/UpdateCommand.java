/* 명령을 처리하는 매서드를 별도의 클래스 분리 -> command패턴
 * 새로운 멸영어를 추가하더라도 기존코드르 손대지 않고
 * 명ㄹ영을 처리하는 새도르르 클래스도 만든다.
 * 클래스는 외부 파일이기 때문에 추가하기 슆ㅂ다.
 */
package java02.test05.commands;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java02.test05.Command;
import java02.test05.Score;
import java02.test05.ScoreDao;

public class UpdateCommand implements Command {

  public String getCommandInfo() {
    return "update";
  }

  public void service(Map<String, Object> params) throws Exception {
    ScoreDao scoreDao = (ScoreDao)params.get("ScoreDao");
    Scanner scanner = (Scanner)params.get("scanner");
    @SuppressWarnings("unchecked")
    ArrayList<String> options = (ArrayList<String>)params.get("options");
    int index = Integer.parseInt(options.get(0));
    Score score = scoreDao.getData(index);
    if(score == null){
      System.out.println("해당 인덱스의 성적 정보를 찾을 수 없습니다.");
      return;
    }
    Score tempScore = score.clone();
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
      scoreDao.change(index, tempScore);
      System.out.println("변경 하였습니다.");
    }else{
      System.out.println("변경 취소 하였습니다.");
    }

  }

}
