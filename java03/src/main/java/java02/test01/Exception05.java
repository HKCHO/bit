/* 예외처리의 의미
 1) 리턴 값으로 예외 상황을 알릴 수 없는 경우.
 2) 리턴 값으로 예외 상황을 알린다 하더라도 연산 결과와 충돌이 일어날때.
 3) 작업 코드와 오류 처리 코드를 분리 => 코드 가독성을 높임
 *4) 오류가 발생했을 때 시스템을 종료 하지 않고 계속 수행할 수 있게 한다. 
 
 */
package java02.test01;

import java.util.Scanner;

public class Exception05 {
  public static int divide(int a, int b){
    if(b == 0)
      throw new Error("0으로 나누지 마세요.");
    return a / b;
  }
  
  //0으로 나누게되면 예외가 발생하게 되고 => 시스템이 멈춘다.
  public static void main01(String[] args) {
   
      Scanner scanner = new Scanner(System.in);
      int a,b;
      while(true){
        System.out.println("a ? " );
        a = Integer.parseInt(scanner.nextLine());
        
        System.out.println("b ? " );
        b = Integer.parseInt(scanner.nextLine());
        
        System.out.println("결과(a/b) : " + divide(a,b));
        System.out.println(" 계속 하시겠습니까? ");
        if(scanner.nextLine().equals("n"))
          break;
      }
      scanner.close();
    
  }
  //개선안 =>0으로 나누게되면 예외가 발생하면 간단히 처리하고 계속 실행한다.
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int a, b;
    while (true) {
      System.out.println("a ? ");
      a = Integer.parseInt(scanner.nextLine());

      System.out.println("b ? ");
      b = Integer.parseInt(scanner.nextLine());

      try { //예외가 발생하더라도 간단히 처리하고 계속 다음 명령을 수행한다.
        System.out.println("결과(a/b) : " + divide(a, b));
      } catch (Error ex) {
        System.out.println(ex.getMessage());
      }
      System.out.println(" 계속 하시겠습니까? ");
      if (scanner.nextLine().equals("n"))
        break;

    }
    scanner.close();
  }
}
