package cryptography;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @brief 시프트 암호 함수
 * @section 작성정보
 * - Author: jhbaek
 * - version: 1.0
 * - since: 2024. 06. 01.
 * @section 수정정보
 * - 수정일: 2024. 06. 01.
 * - 수정자: jhbaek
 * - 수정내용: 최초생성
 */
public class shiftCipher {
    public void entryFunction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("암호화 할 문장을 적어주세요.");
        String userInput = sc.nextLine();
        shiftCipher(userInput);
    }
    public void shiftCipher(String encodingWord) {
        String word = encodingWord.toUpperCase();
        int bufferNum = 65;
        byte[] bytes = word.getBytes(StandardCharsets.US_ASCII);
        byte[] result = new byte[] {};
        for (int i=0; i <= bytes.length-1 ; i++) {
            int getNum = bytes[i];
            int checkLastNum = getNum/90;
            if(checkLastNum > 0) {
                int calNum = checkLastNum+bufferNum;
                result[i] = (byte)calNum;
            }
            System.out.println((char)bytes[i]);
        }
    }
}