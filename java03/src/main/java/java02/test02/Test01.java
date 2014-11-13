//바이너리 데이터 읽기.
package java02.test02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test01 {
  
  public static void main(String[] args) {
    FileInputStream in = null;
    try{
      // 1) 입력스트림 객체를 준비한다.
      //현재 파일의 위치는 프로젝트 디렉토리이다.
      in = new FileInputStream("img1.jpeg");
      int b = -1;
      int count = 0;
      //2) read()를 통해 1바이트 읽기
      //리턴 타입이 int라 해서 4바이트를 읽는 것은 아니다.
      while( (b = in.read()) != -1){
        count++;
      }
      System.out.println("파일 크기 : "+count + "바이트입니다.");
     /* read() 중에 오류가 발생하면 close()를 호출도 못한다.
      * 그래서 자원을 해재하는 명령을 finall 블록에 두도록 하라!
       */
    }catch(FileNotFoundException ex){
      System.out.println("img1.jpeg 파일을 찾을 수 없습니다.");
    }catch(IOException ex){
      System.out.println("읽기 오류!");
    }finally{
      // 3) File이나 Databace, Socket 등의 자원을 사용한 다음
      //명시적으로 해제해야한다.
      //close () 하다가 예외 발생시 => 아무것도 안한다.
      try{in.close();}catch(IOException ex){}
    }
   

  }

}
