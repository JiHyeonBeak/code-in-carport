package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @brief 문자열 역순배열 함수
 * @section 작성정보
 * - Author: jhbaek
 * - version: 1.0
 * - since: 2024. 03. 20.
 * @section 수정정보
 * - 수정일: 2024. 03. 20.
 * - 수정자: jhbaek
 * - 수정내용: 최초생성
 */
public class reverseString {

    public void entryFunction() {
        // 사용자에게 문자열을 입력받기 위해 Scanner 객체를 생성한다.
        // Scanner객체로 System으로 input되는 데이터를 바이터 단위로 읽음.
        Scanner sc = new Scanner(System.in);
        System.out.println("역순 배열할 문자열을 적어주세요.");
        String userInput = sc.nextLine();
        reverseString(userInput);
    }
    public void reverseString(String testWord) {
        // 입력받은 문자열의 사이즈 체크.
        int wordSize = testWord.length();
        // FIFO가 필요하기에, 큐 객체를 사용한다.
        Queue<String> orderData = new LinkedList<>();
        // 불필요한 리소스 낭비를 막기 위해, 단어를 담을 변수를 미리 선언해둔다.
        String oneWord;
        for (int i=wordSize ; i > 0 ; i-- ) {
            // substring으로 문자열의 마지막부터 바로 앞의 단어를 자른다.
            oneWord = testWord.substring(i-1,i);
            // 자른 단어는 큐에 차곡차곡 넣는다.
            orderData.add(oneWord);
        }
        String result = "";
        for (int j=orderData.size(); j > 0 ; j--) {
            // 단어 역배열이 완료되면, 결과를 보여줄 String 변수에 poll로 꺼내 각 단어를 담는다.
            // 앞서 기재해두었듯이 큐는 선입선출이기에 위에서 역배열로 넣은 그대로 다시 뱉는다.
            result += orderData.poll();
        }
        System.out.println("result :"+result);
    }
}