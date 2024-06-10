package cryptography;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @brief 시프트 암호 함수
 * @section 작성정보
 * - Author: jhbaek
 * - version: 1.0
 * - since: 2024. 06. 05.
 * @section 수정정보
 * - 수정일: 2024. 06. 01.
 * - 수정자: jhbaek
 * - 수정내용: 최초생성
 */
public class shiftCipher {
    Scanner sc = new Scanner(System.in);
    // 엔트리 함수
    public void entryFunction(){
        Scanner sc = new Scanner(System.in);
        // nextInt로 받기때문에, 숫자가 아닌 문자열을 받을 시 try-catch로 예외처리 가능.
        try {
            System.out.println("기능을 선택하세요.\n1.암호화\n2.복호화");
            int asNum = sc.nextInt();
            if(asNum < 3 && asNum > 0) {
                inputFunction(asNum);
            } else {
                System.out.println("1번과 2번중에 선택해주세요.");
                entryFunction();
            }
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
            entryFunction();
        }
    }

    // 입력 함수
    public void inputFunction(int chFlag) {
        System.out.println("암복호할 문장을 입력하세요.\n");
        String word  = sc.nextLine();
        switch(chFlag){
            case 1:
                shiftCipher(word);
                break;
            case 2:
                descramblingFunction(word);
                break;
            default:
                entryFunction();
                break;
        }

    }

    // 복호화 함수
    public void descramblingFunction(String decodingWord) {

    }

    // 암호화 함수
    public void shiftCipher(String encodingWord) {

        // 암호화 편리를 위해, 입력받은 문자열을 대문자로 변경.
        String word = encodingWord.toUpperCase();
        // 아스키코드의 "A"값 설정.
        int aNum = 65;
        // 입력받은 문자열의 아스키코드를 byte배열에 넣는다.
        byte[] bytes = word.getBytes(StandardCharsets.US_ASCII);

        // 필요한 변수 설정.
        String result = ""; // 결과 문자열
        int getNum = 0;     // 암호화 중, 작업 할 문자의 아스키 코드 저장 변수.

        for (int i=0; i <= bytes.length-1 ; i++) {
            // 3자 뒤의 알파벳으로 치환한다.
            getNum = bytes[i] + 3;

            // 만약 Z 이후의 문자라면, 다시 A로 초기화...
            if(getNum > 90) {
                int calNum = (getNum - 91)+aNum;
                bytes[i] = (byte)calNum;
            } else {
                bytes[i] = (byte)getNum;
            }
            // 암호화가 완료되면 자료형을 바꿔 결과 문자열에 한 자 한 자 넣는다.
            result += (char)bytes[i];
        }
        System.out.println(result);
    }
}