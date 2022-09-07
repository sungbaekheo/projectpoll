import java.util.Scanner;

public class pollsMain {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean run = true;
       while (run) {
        String poll = menu(); // 설문, 통계 선택 메뉴 출력
        switch (poll) {
            case "p":
            case "P": System.out.println("설문조사"); break;
            case "s":
            case "S": System.out.println("통계 확인"); break;
            case "q":
            case "Q": System.out.println("설문을 종료합니다."); run = false; break;
        }
       }
    }
    
    public static String menu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("        백화점 환경 개선을 위한 이용 고객 대상 설문조사        ");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("\n\n              실행하려는 메뉴를 선택해주세요.");
        System.out.println("\n      설문 시작: 'P'      통계 확인: 'S'      종료: 'Q'       ");
        System.out.print("\n선택: ");
        String button = scan.nextLine();
        return button;
    }
}